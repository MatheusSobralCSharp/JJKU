package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class HistoryBookItem extends Item {
    public HistoryBookItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
