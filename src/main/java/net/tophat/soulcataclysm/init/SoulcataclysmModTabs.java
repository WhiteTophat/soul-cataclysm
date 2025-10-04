
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.SoulcataclysmMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class SoulcataclysmModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SoulcataclysmMod.MODID);
	public static final RegistryObject<CreativeModeTab> SOUL_CATACLYSM_TAB = REGISTRY.register("soul_cataclysm_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.soulcataclysm.soul_cataclysm_tab")).icon(() -> new ItemStack(SoulcataclysmModBlocks.ECTONIUM_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(SoulcataclysmModBlocks.SOUL_DIRT.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_STONE.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_LOG.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_LEAVES.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_PLANKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_BONE_BLOCK.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_BRICKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_STONE_BRICKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.MOSSY_SOUL_STONE_BRICKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.CRACKED_SOUL_STONE_BRICKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.CHISELED_SOUL_STONE_BRICKS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.ECTONIUM_BLOCK.get().asItem());
				tabData.accept(SoulcataclysmModItems.ECTONIUM_CLUMP.get());
				tabData.accept(SoulcataclysmModBlocks.SOUL_WOOD_STAIRS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_WOOD_SLAB.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_WOOD_FENCE.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_WOOD_FENCE_GATE.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_COMMUNICATOR.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_COBBLESTONE.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.MOSSY_SOUL_COBBLESTONE.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_FLOWER.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_GRASS.get().asItem());
				tabData.accept(SoulcataclysmModBlocks.SOUL_DIRT_PATH.get().asItem());
			}).build());
}
