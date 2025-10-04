
package net.tophat.soulcataclysm.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EctoniumClumpItem extends Item {
	public EctoniumClumpItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
