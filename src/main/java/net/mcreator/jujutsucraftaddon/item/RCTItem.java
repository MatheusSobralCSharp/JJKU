package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class RCTItem extends Item {
    public RCTItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
