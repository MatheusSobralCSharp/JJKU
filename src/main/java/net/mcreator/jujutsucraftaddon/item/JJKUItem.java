package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class JJKUItem extends Item {
    public JJKUItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
