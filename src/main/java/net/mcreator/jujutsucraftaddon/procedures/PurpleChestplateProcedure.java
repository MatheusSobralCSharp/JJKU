package net.mcreator.jujutsucraftaddon.procedures;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.item.PurpleCapeItem;

public class PurpleChestplateProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.onGround() == false) {
            if (itemstack.getItem() instanceof PurpleCapeItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "float2");
        } else if (entity.onGround() == true) {
            if (itemstack.getItem() instanceof PurpleCapeItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "empty");
        }
    }
}
