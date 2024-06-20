
package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TrashItem extends Item {
	public TrashItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
