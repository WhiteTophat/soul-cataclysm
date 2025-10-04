
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.block.SoulWoodStairsBlock;
import net.tophat.soulcataclysm.block.SoulWoodSlabBlock;
import net.tophat.soulcataclysm.block.SoulWoodFenceGateBlock;
import net.tophat.soulcataclysm.block.SoulWoodFenceBlock;
import net.tophat.soulcataclysm.block.SoulStoneBricksBlock;
import net.tophat.soulcataclysm.block.SoulStoneBlock;
import net.tophat.soulcataclysm.block.SoulPlanksBlock;
import net.tophat.soulcataclysm.block.SoulLogBlock;
import net.tophat.soulcataclysm.block.SoulLeavesBlock;
import net.tophat.soulcataclysm.block.SoulGrassBlock;
import net.tophat.soulcataclysm.block.SoulFlowerBlock;
import net.tophat.soulcataclysm.block.SoulDirtPathBlock;
import net.tophat.soulcataclysm.block.SoulDirtBlock;
import net.tophat.soulcataclysm.block.SoulCommunicatorBlock;
import net.tophat.soulcataclysm.block.SoulCobblestoneBlock;
import net.tophat.soulcataclysm.block.SoulBricksBlock;
import net.tophat.soulcataclysm.block.SoulBoneBlockBlock;
import net.tophat.soulcataclysm.block.MossySoulStoneBricksBlock;
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
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
