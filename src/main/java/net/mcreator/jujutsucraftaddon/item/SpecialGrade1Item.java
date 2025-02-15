package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SpecialGrade1Item extends Item {
    public SpecialGrade1Item() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}
