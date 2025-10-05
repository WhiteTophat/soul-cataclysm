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
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;

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
	public static boolean itemHasTag(ItemStack item, String tag) {
		return item.is(ItemTags.create(new ResourceLocation(tag)));
	}
	public static boolean itemHasTag(Item item, String tag) {
		return itemHasTag(new ItemStack(item), tag);
	}
	public static boolean itemHasAnyTag(ItemStack item, String[] tags) {
		for (String tag : tags) {
			if (itemHasTag(item, tag)) return true;
		}
		return false;
	}
	public static boolean itemHasAnyTag(Item item, String[] tags) {
		for (String tag : tags) {
			if (itemHasTag(item, tag)) return true;
		}
		return false;
	}
	public static BlockState copyProperty(BlockState origin, BlockState target, String propertyName) {
		Property<?> originProperty = origin.getBlock().getStateDefinition().getProperty(propertyName);
		Property<?> targetProperty = target.getBlock().getStateDefinition().getProperty(propertyName);
		if (originProperty == null || targetProperty == null) { return target; }
		BlockState modified = target;
		if (originProperty instanceof EnumProperty enumProperty && targetProperty instanceof EnumProperty uninfEnumProperty) {
			modified = modified.setValue(enumProperty, origin.getValue(uninfEnumProperty));
		} else if (originProperty instanceof BooleanProperty enumProperty && targetProperty instanceof BooleanProperty uninfEnumProperty) {
			modified = modified.setValue(enumProperty, origin.getValue(uninfEnumProperty));
		} else if (originProperty instanceof IntegerProperty enumProperty && targetProperty instanceof IntegerProperty uninfEnumProperty) {
			modified = modified.setValue(enumProperty, origin.getValue(uninfEnumProperty));
		} else {
			modified = modified.setValue((Property) targetProperty, origin.getValue((Property) originProperty));
		}
		return modified;
	}
	public static BlockState copyProperties(BlockState origin, BlockState target, String[] properties) {
		BlockState modified = target;
		for (String prop : properties) {
			modified = copyProperty(origin, modified, prop);
		}
		return modified;
	}
	public static boolean isPlantBlock(BlockState block) {
		if (blockHasTag(block, "minecraft:flowers")) { return true; }
		if (block.getBlock() == Blocks.GRASS) { return true; }
		return false;
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
			BlockState infected = null;
			if (blockHasTag(block, "soulcataclysm:stripped_logs")) {
				infected = SoulcataclysmModBlocks.STRIPPED_SOUL_LOG.get().defaultBlockState();
			} else if (blockHasTag(block, "soulcataclysm:log_wood")) {
				infected = SoulcataclysmModBlocks.SOUL_WOOD.get().defaultBlockState();
			} else if (blockHasTag(block, "soulcataclysm:stripped_wood")) {
				infected = SoulcataclysmModBlocks.STRIPPED_SOUL_WOOD.get().defaultBlockState();
			} else {
				infected = SoulcataclysmModBlocks.SOUL_LOG.get().defaultBlockState();
			}
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

		} else if (blockHasTag(block, "minecraft:stone_bricks")) {
			if (block.getBlock() == Blocks.MOSSY_STONE_BRICKS) {
				return SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS.get().defaultBlockState();
			} else if (block.getBlock() == Blocks.CRACKED_STONE_BRICKS) {
				return SoulcataclysmModBlocks.CRACKED_SOUL_STONE_BRICKS.get().defaultBlockState();
			} else if (block.getBlock() == Blocks.CHISELED_STONE_BRICKS) {
				return SoulcataclysmModBlocks.CHISELED_SOUL_STONE_BRICKS.get().defaultBlockState();
			}
			return SoulcataclysmModBlocks.SOUL_STONE_BRICKS.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.BONE_BLOCK) {
			BlockState infected = SoulcataclysmModBlocks.SOUL_BONE_BLOCK.get().defaultBlockState();
			Property<?> uninfectedProperty = block.getBlock().getStateDefinition().getProperty("axis");
			Property<?> property = infected.getBlock().getStateDefinition().getProperty("axis");
			if (property instanceof EnumProperty enumProperty && uninfectedProperty instanceof EnumProperty uninfEnumProperty) {
				infected = infected.setValue(enumProperty, block.getValue(uninfEnumProperty));
			}
			return infected;

		} else if (block.getBlock() == Blocks.BRICKS) {
			return SoulcataclysmModBlocks.SOUL_BRICKS.get().defaultBlockState();

		} else if (blockHasTag(block, "minecraft:planks")) {
			return SoulcataclysmModBlocks.SOUL_PLANKS.get().defaultBlockState();

		} else if (blockHasTag(block, "minecraft:wooden_stairs")) {
			return copyProperties(block, SoulcataclysmModBlocks.SOUL_WOOD_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (blockHasTag(block, "minecraft:wooden_slabs")) {
			return copyProperty(block, SoulcataclysmModBlocks.SOUL_WOOD_SLAB.get().defaultBlockState(), "type");

		} else if (blockHasTag(block, "forge:fences/wooden")) {
			return copyProperties(block, SoulcataclysmModBlocks.SOUL_WOOD_FENCE.get().defaultBlockState(), new String[] {
				"east", "north", "south", "west"
			});

		} else if (block.getBlock() == Blocks.COBBLESTONE) {
			return SoulcataclysmModBlocks.SOUL_COBBLESTONE.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.MOSSY_COBBLESTONE) {
			return SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE.get().defaultBlockState();

		} else if (blockHasTag(block, "minecraft:flowers")) {
			return SoulcataclysmModBlocks.SOUL_FLOWER.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.GRASS) {
			return SoulcataclysmModBlocks.SOUL_GRASS.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.DIRT_PATH) {
			return SoulcataclysmModBlocks.SOUL_DIRT_PATH.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.FARMLAND) {
			return SoulcataclysmModBlocks.SOUL_FARMLAND.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.STONE_BRICK_SLAB) {
			return copyProperty(block, SoulcataclysmModBlocks.SOUL_STONE_BRICKS_SLAB.get().defaultBlockState(), "type");

		} else if (block.getBlock() == Blocks.STONE_BRICK_STAIRS) {
			return copyProperties(block, SoulcataclysmModBlocks.SOUL_STONE_BRICKS_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (block.getBlock() == Blocks.STONE_BRICK_WALL) {
			return SoulcataclysmModBlocks.SOUL_STONE_BRICKS_WALL.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.MOSSY_STONE_BRICK_SLAB) {
			return copyProperty(block, SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_SLAB.get().defaultBlockState(), "type");

		} else if (block.getBlock() == Blocks.MOSSY_STONE_BRICK_STAIRS) {
			return copyProperties(block, SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (block.getBlock() == Blocks.MOSSY_STONE_BRICK_WALL) {
			return SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_WALL.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.COBBLESTONE_SLAB) {
			return copyProperty(block, SoulcataclysmModBlocks.SOUL_COBBLESTONE_SLAB.get().defaultBlockState(), "type");

		} else if (block.getBlock() == Blocks.COBBLESTONE_STAIRS) {
			return copyProperties(block, SoulcataclysmModBlocks.SOUL_COBBLESTONE_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (block.getBlock() == Blocks.COBBLESTONE_WALL) {
			return SoulcataclysmModBlocks.SOUL_COBBLESTONE_WALL.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.MOSSY_COBBLESTONE_SLAB) {
			return copyProperty(block, SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_SLAB.get().defaultBlockState(), "type");
		
		} else if (block.getBlock() == Blocks.MOSSY_COBBLESTONE_STAIRS) {
			return copyProperties(block, SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (block.getBlock() == Blocks.MOSSY_COBBLESTONE_WALL) {
			return SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_WALL.get().defaultBlockState();

		} else if (block.getBlock() == Blocks.BRICK_SLAB) {
			return copyProperty(block, SoulcataclysmModBlocks.SOUL_BRICKS_SLAB.get().defaultBlockState(), "type");
		
		} else if (block.getBlock() == Blocks.BRICK_STAIRS) {
			return copyProperties(block, SoulcataclysmModBlocks.SOUL_BRICKS_STAIRS.get().defaultBlockState(), new String[] {
				"facing",
				"half",
				"shape"
			});

		} else if (block.getBlock() == Blocks.TORCH) {
			return Blocks.SOUL_TORCH.get().defaultBlockState();
		} else if (block.getBlock() == Blocks.WALL_TORCH) {
			return copyProperty(block, Blocks.SOUL_WALL_TORCH.get().defaultBlockState(), "facing");
		}
		return Blocks.AIR.defaultBlockState();
	}

	// Reputation System
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
		if (itemHasTag(item, "soulcataclysm:positive_items")) {
			return 10;
		} else if (itemHasTag(item, "soulcataclysm:negative_items")) {
			return -5;
		}
		return 1;
	}
}