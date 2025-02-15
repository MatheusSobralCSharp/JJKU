package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class JujutsuSchoolItem extends Item {
    public JujutsuSchoolItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}
