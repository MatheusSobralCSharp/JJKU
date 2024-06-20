
package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ItemTest2Item extends Item {
	public ItemTest2Item() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
