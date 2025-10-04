package net.tophat.soulcataclysm.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DdfProcedure {
	public static boolean execute() {
		return new ItemStack(Items.COCOA_BEANS).is(ItemTags.create(new ResourceLocation("minecraft:logs")));
	}
}
