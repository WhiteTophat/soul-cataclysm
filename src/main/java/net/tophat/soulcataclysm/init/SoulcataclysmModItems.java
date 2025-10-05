
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.item.EctoniumClumpItem;
import net.tophat.soulcataclysm.SoulcataclysmMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

public class SoulcataclysmModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SoulcataclysmMod.MODID);
	public static final RegistryObject<Item> SOUL_DIRT = block(SoulcataclysmModBlocks.SOUL_DIRT);
	public static final RegistryObject<Item> SOUL_STONE = block(SoulcataclysmModBlocks.SOUL_STONE);
	public static final RegistryObject<Item> SOUL_LOG = block(SoulcataclysmModBlocks.SOUL_LOG);
	public static final RegistryObject<Item> SOUL_LEAVES = block(SoulcataclysmModBlocks.SOUL_LEAVES);
	public static final RegistryObject<Item> SOUL_PLANKS = block(SoulcataclysmModBlocks.SOUL_PLANKS);
	public static final RegistryObject<Item> SOUL_BONE_BLOCK = block(SoulcataclysmModBlocks.SOUL_BONE_BLOCK);
	public static final RegistryObject<Item> SOUL_BRICKS = block(SoulcataclysmModBlocks.SOUL_BRICKS);
	public static final RegistryObject<Item> SOUL_STONE_BRICKS = block(SoulcataclysmModBlocks.SOUL_STONE_BRICKS);
	public static final RegistryObject<Item> MOSSY_SOUL_STONE_BRICKS = block(SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS);
	public static final RegistryObject<Item> CRACKED_SOUL_STONE_BRICKS = block(SoulcataclysmModBlocks.CRACKED_SOUL_STONE_BRICKS);
	public static final RegistryObject<Item> CHISELED_SOUL_STONE_BRICKS = block(SoulcataclysmModBlocks.CHISELED_SOUL_STONE_BRICKS);
	public static final RegistryObject<Item> ECTONIUM_BLOCK = block(SoulcataclysmModBlocks.ECTONIUM_BLOCK);
	public static final RegistryObject<Item> ECTONIUM_CLUMP = REGISTRY.register("ectonium_clump", () -> new EctoniumClumpItem());
	public static final RegistryObject<Item> SOUL_WOOD_STAIRS = block(SoulcataclysmModBlocks.SOUL_WOOD_STAIRS);
	public static final RegistryObject<Item> SOUL_WOOD_SLAB = block(SoulcataclysmModBlocks.SOUL_WOOD_SLAB);
	public static final RegistryObject<Item> SOUL_WOOD_FENCE = block(SoulcataclysmModBlocks.SOUL_WOOD_FENCE);
	public static final RegistryObject<Item> SOUL_WOOD_FENCE_GATE = block(SoulcataclysmModBlocks.SOUL_WOOD_FENCE_GATE);
	public static final RegistryObject<Item> SOUL_COMMUNICATOR = block(SoulcataclysmModBlocks.SOUL_COMMUNICATOR);
	public static final RegistryObject<Item> SOUL_COBBLESTONE = block(SoulcataclysmModBlocks.SOUL_COBBLESTONE);
	public static final RegistryObject<Item> MOSSY_SOUL_COBBLESTONE = block(SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE);
	public static final RegistryObject<Item> SOUL_FLOWER = block(SoulcataclysmModBlocks.SOUL_FLOWER);
	public static final RegistryObject<Item> SOUL_GRASS = block(SoulcataclysmModBlocks.SOUL_GRASS);
	public static final RegistryObject<Item> SOUL_DIRT_PATH = block(SoulcataclysmModBlocks.SOUL_DIRT_PATH);
	public static final RegistryObject<Item> STRIPPED_SOUL_LOG = block(SoulcataclysmModBlocks.STRIPPED_SOUL_LOG);
	public static final RegistryObject<Item> SOUL_WOOD = block(SoulcataclysmModBlocks.SOUL_WOOD);
	public static final RegistryObject<Item> STRIPPED_SOUL_WOOD = block(SoulcataclysmModBlocks.STRIPPED_SOUL_WOOD);
	public static final RegistryObject<Item> SOUL_BRICKS_SLAB = block(SoulcataclysmModBlocks.SOUL_BRICKS_SLAB);
	public static final RegistryObject<Item> SOUL_BRICKS_STAIRS = block(SoulcataclysmModBlocks.SOUL_BRICKS_STAIRS);
	public static final RegistryObject<Item> SOUL_BRICKS_WALL = block(SoulcataclysmModBlocks.SOUL_BRICKS_WALL);
	public static final RegistryObject<Item> SOUL_WOOD_DOOR = doubleBlock(SoulcataclysmModBlocks.SOUL_WOOD_DOOR);
	public static final RegistryObject<Item> SOUL_WOOD_TRAPDOOR = block(SoulcataclysmModBlocks.SOUL_WOOD_TRAPDOOR);
	public static final RegistryObject<Item> SOUL_WOOD_PRESSURE_PLATE = block(SoulcataclysmModBlocks.SOUL_WOOD_PRESSURE_PLATE);
	public static final RegistryObject<Item> SOUL_WOOD_BUTTON = block(SoulcataclysmModBlocks.SOUL_WOOD_BUTTON);
	public static final RegistryObject<Item> SOUL_STONE_BRICKS_SLAB = block(SoulcataclysmModBlocks.SOUL_STONE_BRICKS_SLAB);
	public static final RegistryObject<Item> SOUL_STONE_BRICKS_STAIRS = block(SoulcataclysmModBlocks.SOUL_STONE_BRICKS_STAIRS);
	public static final RegistryObject<Item> SOUL_STONE_BRICKS_WALL = block(SoulcataclysmModBlocks.SOUL_STONE_BRICKS_WALL);
	public static final RegistryObject<Item> MOSSY_SOUL_STONE_BRICKS_SLAB = block(SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_SLAB);
	public static final RegistryObject<Item> MOSSY_SOUL_STONE_BRICKS_STAIRS = block(SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_STAIRS);
	public static final RegistryObject<Item> MOSSY_SOUL_STONE_BRICKS_WALL = block(SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS_WALL);
	public static final RegistryObject<Item> SOUL_COBBLESTONE_STAIRS = block(SoulcataclysmModBlocks.SOUL_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> SOUL_COBBLESTONE_SLAB = block(SoulcataclysmModBlocks.SOUL_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> SOUL_COBBLESTONE_WALL = block(SoulcataclysmModBlocks.SOUL_COBBLESTONE_WALL);
	public static final RegistryObject<Item> MOSSY_SOUL_COBBLESTONE_SLAB = block(SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_SLAB);
	public static final RegistryObject<Item> MOSSY_SOUL_COBBLESTONE_STAIRS = block(SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_STAIRS);
	public static final RegistryObject<Item> MOSSY_SOUL_COBBLESTONE_WALL = block(SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE_WALL);
	public static final RegistryObject<Item> SOUL_FARMLAND = block(SoulcataclysmModBlocks.SOUL_FARMLAND);
	public static final RegistryObject<Item> SOUL_GRASS_BLOCK = block(SoulcataclysmModBlocks.SOUL_GRASS_BLOCK);
	public static final RegistryObject<Item> ECTONIUM_ORE = block(SoulcataclysmModBlocks.ECTONIUM_ORE);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties()));
	}
}
