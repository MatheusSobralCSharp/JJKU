package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class TestingItemItem extends Item {
    public TestingItemItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
