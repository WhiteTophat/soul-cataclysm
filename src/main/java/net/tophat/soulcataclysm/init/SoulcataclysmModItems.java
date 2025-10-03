
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.SoulcataclysmMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

public class SoulcataclysmModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SoulcataclysmMod.MODID);
	public static final RegistryObject<Item> SOUL_DIRT = block(SoulcataclysmModBlocks.SOUL_DIRT);
	public static final RegistryObject<Item> SOUL_STONE = block(SoulcataclysmModBlocks.SOUL_STONE);
	public static final RegistryObject<Item> SOUL_LOG = block(SoulcataclysmModBlocks.SOUL_LOG);
	public static final RegistryObject<Item> SOUL_LEAVES = block(SoulcataclysmModBlocks.SOUL_LEAVES);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
