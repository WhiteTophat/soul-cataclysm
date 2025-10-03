
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.block.SoulStoneBlock;
import net.tophat.soulcataclysm.block.SoulLogBlock;
import net.tophat.soulcataclysm.block.SoulDirtBlock;
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
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
