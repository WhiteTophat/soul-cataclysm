
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.block.StrippedSoulWoodBlock;
import net.tophat.soulcataclysm.block.StrippedSoulLogBlock;
import net.tophat.soulcataclysm.block.SoulWoodTrapdoorBlock;
import net.tophat.soulcataclysm.block.SoulWoodStairsBlock;
import net.tophat.soulcataclysm.block.SoulWoodSlabBlock;
import net.tophat.soulcataclysm.block.SoulWoodPressurePlateBlock;
import net.tophat.soulcataclysm.block.SoulWoodFenceGateBlock;
import net.tophat.soulcataclysm.block.SoulWoodFenceBlock;
import net.tophat.soulcataclysm.block.SoulWoodDoorBlock;
import net.tophat.soulcataclysm.block.SoulWoodButtonBlock;
import net.tophat.soulcataclysm.block.SoulWoodBlock;
import net.tophat.soulcataclysm.block.SoulStoneBricksWallBlock;
import net.tophat.soulcataclysm.block.SoulStoneBricksStairsBlock;
import net.tophat.soulcataclysm.block.SoulStoneBricksSlabBlock;
import net.tophat.soulcataclysm.block.SoulStoneBricksBlock;
import net.tophat.soulcataclysm.block.SoulStoneBlock;
import net.tophat.soulcataclysm.block.SoulPlanksBlock;
import net.tophat.soulcataclysm.block.SoulLogBlock;
import net.tophat.soulcataclysm.block.SoulLeavesBlock;
import net.tophat.soulcataclysm.block.SoulGrassBlock;
import net.tophat.soulcataclysm.block.SoulFlowerBlock;
import net.tophat.soulcataclysm.block.SoulFarmlandBlock;
import net.tophat.soulcataclysm.block.SoulDirtPathBlock;
import net.tophat.soulcataclysm.block.SoulDirtBlock;
import net.tophat.soulcataclysm.block.SoulCommunicatorBlock;
import net.tophat.soulcataclysm.block.SoulCobblestoneWallBlock;
import net.tophat.soulcataclysm.block.SoulCobblestoneStairsBlock;
import net.tophat.soulcataclysm.block.SoulCobblestoneSlabBlock;
import net.tophat.soulcataclysm.block.SoulCobblestoneBlock;
import net.tophat.soulcataclysm.block.SoulBricksWallBlock;
import net.tophat.soulcataclysm.block.SoulBricksStairsBlock;
import net.tophat.soulcataclysm.block.SoulBricksSlabBlock;
import net.tophat.soulcataclysm.block.SoulBricksBlock;
import net.tophat.soulcataclysm.block.SoulBoneBlockBlock;
import net.tophat.soulcataclysm.block.MossySoulStoneBricksWallBlock;
import net.tophat.soulcataclysm.block.MossySoulStoneBricksStairsBlock;
import net.tophat.soulcataclysm.block.MossySoulStoneBricksSlabBlock;
import net.tophat.soulcataclysm.block.MossySoulStoneBricksBlock;
import net.tophat.soulcataclysm.block.MossySoulCobblestoneWallBlock;
import net.tophat.soulcataclysm.block.MossySoulCobblestoneStairsBlock;
import net.tophat.soulcataclysm.block.MossySoulCobblestoneSlabBlock;
import net.tophat.soulcataclysm.block.MossySoulCobblestoneBlock;
import net.tophat.soulcataclysm.block.EctoniumBlockBlock;
import net.tophat.soulcataclysm.block.CrackedSoulStoneBricksBlock;
import net.tophat.soulcataclysm.block.ChiseledSoulStoneBricksBlock;
import net.tophat.soulcataclysm.SoulcataclysmMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class SoulcataclysmModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SoulcataclysmMod.MODID);
	public static final RegistryObject<Block> SOUL_DIRT = REGISTRY.register("soul_dirt", () -> new SoulDirtBlock());
	public static final RegistryObject<Block> SOUL_STONE = REGISTRY.register("soul_stone", () -> new SoulStoneBlock());
	public static final RegistryObject<Block> SOUL_LOG = REGISTRY.register("soul_log", () -> new SoulLogBlock());
	public static final RegistryObject<Block> SOUL_LEAVES = REGISTRY.register("soul_leaves", () -> new SoulLeavesBlock());
	public static final RegistryObject<Block> SOUL_PLANKS = REGISTRY.register("soul_planks", () -> new SoulPlanksBlock());
	public static final RegistryObject<Block> SOUL_BONE_BLOCK = REGISTRY.register("soul_bone_block", () -> new SoulBoneBlockBlock());
	public static final RegistryObject<Block> SOUL_BRICKS = REGISTRY.register("soul_bricks", () -> new SoulBricksBlock());
	public static final RegistryObject<Block> SOUL_STONE_BRICKS = REGISTRY.register("soul_stone_bricks", () -> new SoulStoneBricksBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_STONE_BRICKS = REGISTRY.register("mossy_soul_stone_bricks", () -> new MossySoulStoneBricksBlock());
	public static final RegistryObject<Block> CRACKED_SOUL_STONE_BRICKS = REGISTRY.register("cracked_soul_stone_bricks", () -> new CrackedSoulStoneBricksBlock());
	public static final RegistryObject<Block> CHISELED_SOUL_STONE_BRICKS = REGISTRY.register("chiseled_soul_stone_bricks", () -> new ChiseledSoulStoneBricksBlock());
	public static final RegistryObject<Block> ECTONIUM_BLOCK = REGISTRY.register("ectonium_block", () -> new EctoniumBlockBlock());
	public static final RegistryObject<Block> SOUL_WOOD_STAIRS = REGISTRY.register("soul_wood_stairs", () -> new SoulWoodStairsBlock());
	public static final RegistryObject<Block> SOUL_WOOD_SLAB = REGISTRY.register("soul_wood_slab", () -> new SoulWoodSlabBlock());
	public static final RegistryObject<Block> SOUL_WOOD_FENCE = REGISTRY.register("soul_wood_fence", () -> new SoulWoodFenceBlock());
	public static final RegistryObject<Block> SOUL_WOOD_FENCE_GATE = REGISTRY.register("soul_wood_fence_gate", () -> new SoulWoodFenceGateBlock());
	public static final RegistryObject<Block> SOUL_COMMUNICATOR = REGISTRY.register("soul_communicator", () -> new SoulCommunicatorBlock());
	public static final RegistryObject<Block> SOUL_COBBLESTONE = REGISTRY.register("soul_cobblestone", () -> new SoulCobblestoneBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_COBBLESTONE = REGISTRY.register("mossy_soul_cobblestone", () -> new MossySoulCobblestoneBlock());
	public static final RegistryObject<Block> SOUL_FLOWER = REGISTRY.register("soul_flower", () -> new SoulFlowerBlock());
	public static final RegistryObject<Block> SOUL_GRASS = REGISTRY.register("soul_grass", () -> new SoulGrassBlock());
	public static final RegistryObject<Block> SOUL_DIRT_PATH = REGISTRY.register("soul_dirt_path", () -> new SoulDirtPathBlock());
	public static final RegistryObject<Block> STRIPPED_SOUL_LOG = REGISTRY.register("stripped_soul_log", () -> new StrippedSoulLogBlock());
	public static final RegistryObject<Block> SOUL_WOOD = REGISTRY.register("soul_wood", () -> new SoulWoodBlock());
	public static final RegistryObject<Block> STRIPPED_SOUL_WOOD = REGISTRY.register("stripped_soul_wood", () -> new StrippedSoulWoodBlock());
	public static final RegistryObject<Block> SOUL_BRICKS_SLAB = REGISTRY.register("soul_bricks_slab", () -> new SoulBricksSlabBlock());
	public static final RegistryObject<Block> SOUL_BRICKS_STAIRS = REGISTRY.register("soul_bricks_stairs", () -> new SoulBricksStairsBlock());
	public static final RegistryObject<Block> SOUL_BRICKS_WALL = REGISTRY.register("soul_bricks_wall", () -> new SoulBricksWallBlock());
	public static final RegistryObject<Block> SOUL_WOOD_DOOR = REGISTRY.register("soul_wood_door", () -> new SoulWoodDoorBlock());
	public static final RegistryObject<Block> SOUL_WOOD_TRAPDOOR = REGISTRY.register("soul_wood_trapdoor", () -> new SoulWoodTrapdoorBlock());
	public static final RegistryObject<Block> SOUL_WOOD_PRESSURE_PLATE = REGISTRY.register("soul_wood_pressure_plate", () -> new SoulWoodPressurePlateBlock());
	public static final RegistryObject<Block> SOUL_WOOD_BUTTON = REGISTRY.register("soul_wood_button", () -> new SoulWoodButtonBlock());
	public static final RegistryObject<Block> SOUL_STONE_BRICKS_SLAB = REGISTRY.register("soul_stone_bricks_slab", () -> new SoulStoneBricksSlabBlock());
	public static final RegistryObject<Block> SOUL_STONE_BRICKS_STAIRS = REGISTRY.register("soul_stone_bricks_stairs", () -> new SoulStoneBricksStairsBlock());
	public static final RegistryObject<Block> SOUL_STONE_BRICKS_WALL = REGISTRY.register("soul_stone_bricks_wall", () -> new SoulStoneBricksWallBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_STONE_BRICKS_SLAB = REGISTRY.register("mossy_soul_stone_bricks_slab", () -> new MossySoulStoneBricksSlabBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_STONE_BRICKS_STAIRS = REGISTRY.register("mossy_soul_stone_bricks_stairs", () -> new MossySoulStoneBricksStairsBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_STONE_BRICKS_WALL = REGISTRY.register("mossy_soul_stone_bricks_wall", () -> new MossySoulStoneBricksWallBlock());
	public static final RegistryObject<Block> SOUL_COBBLESTONE_STAIRS = REGISTRY.register("soul_cobblestone_stairs", () -> new SoulCobblestoneStairsBlock());
	public static final RegistryObject<Block> SOUL_COBBLESTONE_SLAB = REGISTRY.register("soul_cobblestone_slab", () -> new SoulCobblestoneSlabBlock());
	public static final RegistryObject<Block> SOUL_COBBLESTONE_WALL = REGISTRY.register("soul_cobblestone_wall", () -> new SoulCobblestoneWallBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_COBBLESTONE_SLAB = REGISTRY.register("mossy_soul_cobblestone_slab", () -> new MossySoulCobblestoneSlabBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_COBBLESTONE_STAIRS = REGISTRY.register("mossy_soul_cobblestone_stairs", () -> new MossySoulCobblestoneStairsBlock());
	public static final RegistryObject<Block> MOSSY_SOUL_COBBLESTONE_WALL = REGISTRY.register("mossy_soul_cobblestone_wall", () -> new MossySoulCobblestoneWallBlock());
	public static final RegistryObject<Block> SOUL_FARMLAND = REGISTRY.register("soul_farmland", () -> new SoulFarmlandBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
