package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CursedFistItem extends Item {
    public CursedFistItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
