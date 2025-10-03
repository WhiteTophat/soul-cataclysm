package net.tophat.soulcataclysm;

import net.tophat.soulcataclysm.init.SoulcataclysmModBlocks;
import net.tophat.soulcataclysm.network.SoulcataclysmModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;

import java.util.Stack;
import java.util.Map;
import javax.annotation.Nullable;

public class InfectionHandler {
	// Util
	public static boolean blockHasTag(BlockState block, String tag) {
		return block.is(BlockTags.create(new ResourceLocation(tag)));
	}
	public static boolean blockHasTag(Block block, String tag) {
		return blockHasTag(block.defaultBlockState(), tag);
	}

	// Variables
	public static double getPoints(LevelAccessor world) {
		return SoulcataclysmModVariables.WorldVariables.get(world).points;
	}
	public static void setPoints(LevelAccessor world, double value) {
		SoulcataclysmModVariables.WorldVariables.get(world).points = value;
	}

	// Spreading System
    public static Stack<BlockPos> getNeighboringBlocks(BlockPos pos) {
        Stack<BlockPos> neighbors = new Stack();
        neighbors.add(BlockPos.containing(pos.getX() + 1, pos.getY(), pos.getZ()));
        neighbors.add(BlockPos.containing(pos.getX() - 1, pos.getY(), pos.getZ()));
        neighbors.add(BlockPos.containing(pos.getX(), pos.getY() + 1, pos.getZ()));
        neighbors.add(BlockPos.containing(pos.getX(), pos.getY() - 1, pos.getZ()));
        neighbors.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1));
        neighbors.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1));
        return neighbors;
    }
	public static boolean isBlockInfected(Block block) {
        return block.defaultBlockState().is(BlockTags.create(new ResourceLocation("soulcataclysm:infected")));
    }
	public static double getBlockInfectWorth(LevelAccessor accessor, BlockPos pos, int depth, boolean startingCall) {
        BlockState blockState = accessor.getBlockState(pos);
        Block block = blockState.getBlock();
        if (isBlockInfected(block)) { return startingCall ? -999 : 0; }
		if (infectBlock(blockState).getBlock() == Blocks.AIR) { return startingCall ? -999 : 0; }

        double worth = 0;
        for (BlockPos neighbor : getNeighboringBlocks(pos)) {
            BlockState neighborState = accessor.getBlockState(neighbor);
            Block neighborBlock = neighborState.getBlock();

            if (depth > 0) {
                worth += getBlockInfectWorth(accessor, neighbor, depth - 1, false);
            }
            if (!isBlockInfected(neighborBlock)) { worth += 3; }
			if (neighborBlock == Blocks.AIR) { worth += 5; }
        }
        return worth;
    }
	@Nullable
    public static BlockPos decideSpread(Level level, BlockPos start, int depth) {
        Stack<BlockPos> possiblePositions = getNeighboringBlocks(start);

        BlockPos currentChoice = null;
        double highestWorth = -9999;
        for (BlockPos pos : possiblePositions) {
            double worth = getBlockInfectWorth(level, pos, depth, true);
            if (worth <= -20) continue;
            if (worth > highestWorth) {
                currentChoice = pos;
                highestWorth = worth;
            }
        }
        Stack<BlockPos> choices = new Stack();
        for (BlockPos pos : possiblePositions) {
            double worth = getBlockInfectWorth(level, pos, depth, true);
            if (worth <= -20) continue;
            if (worth == highestWorth) {
                choices.add(pos);
            }
        }
        try {
            currentChoice = choices.get((int) (Math.round(Math.random() * choices.size())));
        } catch (Exception e) {
            currentChoice = null;
        }
        return currentChoice;
    }
	public static BlockState infectBlock(BlockState block) {
		if (blockHasTag(block, "minecraft:dirt")) {
			return SoulcataclysmModBlocks.SOUL_DIRT.get().defaultBlockState();
		} else if (blockHasTag(block, "minecraft:logs")) {
			BlockState infected = SoulcataclysmModBlocks.SOUL_LOG.get().defaultBlockState();
			Property<?> uninfectedProperty = block.getBlock().getStateDefinition().getProperty("axis");
			Property<?> property = infected.getBlock().getStateDefinition().getProperty("axis");
			if (property instanceof EnumProperty enumProperty && uninfectedProperty instanceof EnumProperty uninfEnumProperty) {
				infected = infected.setValue(enumProperty, block.getValue(uninfEnumProperty));
			}
			return infected;
		} else if (blockHasTag(block, "forge:stone")) {
			return SoulcataclysmModBlocks.SOUL_STONE.get().defaultBlockState();
		} else if (blockHasTag(block, "minecraft:leaves")) {
			return SoulcataclysmModBlocks.SOUL_LEAVES.get().defaultBlockState();
		}
		return Blocks.AIR.defaultBlockState();
	}

	// Reputation System
	private static Map<Item, double> cachedItemValues = new Map();
	public static double getReputation(LevelAccessor world, Player player) {
		return (player.getCapability(SoulcataclysmModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SoulcataclysmModVariables.PlayerVariables())).reputation;
	}
	public static void setReputation(LevelAccessor world, Player player, double value) {
		player.getCapability(SoulcataclysmModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
			capability.reputation = value;
			capability.syncPlayerVariables(player);
		});
	}
	public static double getItemValue(LevelAccessor world, Item item) {
		double value = 0;
		switch (item) {
			case Items.DIAMOND:
				value = 300;
				break;
			case Items.OBSIDIAN:
				value = 300;
				break;
			case Items.EMERALD:
				value = 200;
				break;
			case Items.ENCHANTED_GOLDEN_APPLE:
				value = 500;
				break;
			case Items.GOLDEN_APPLE:
				value = 350;
				break;
			default:
				if (cachedItemValues.containsKey(item)) {
					return cachedItemValues.get(item);
				}
				Stack<Recipe> recipes = world.getRecipeManager().getRecipes();
				for (Recipe recipe : recipes) {
					Item result = recipe.getResultItem(RegistryAccess.EMPTY).getItem();
					boolean isItemResult = result == item;
					NonNullList<Ingredient> ingredients = recipe.getIngredients();
					for (Ingredient i : ingredients) {
						for (ItemStack stack : i.getItems()) {
							Item curItem = stack.getItem();
							if (isItemResult) {
								value += getItemValue(curItem);
							} else if (curItem == item) {
								value += 1;
							}
						}
					}
				}
				cachedItemValues.set(item, value);
				break;
		}
		return value;
	}
}
