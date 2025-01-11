
package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TestItem1Item extends Item {
	public TestItem1Item() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
