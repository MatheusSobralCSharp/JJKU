package net.mcreator.jujutsucraftaddon.procedures;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.item.VergilItem;

public class VergilChestplateTickEventProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("Vergil") == 1) {
            if (itemstack.getItem() instanceof VergilItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "combat");
        }
    }
}
