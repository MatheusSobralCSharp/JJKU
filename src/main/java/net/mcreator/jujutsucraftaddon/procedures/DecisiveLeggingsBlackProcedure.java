package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.item.DecisiveBlackItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;

public class DecisiveLeggingsBlackProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (!entity.onGround()) {
            if (itemstack.getItem() instanceof DecisiveBlackItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "float2");
        } else if (entity.onGround()) {
            if (itemstack.getItem() instanceof DecisiveBlackItem armor && armor instanceof GeoItem)
                itemstack.getOrCreateTag().putString("geckoAnim", "empty");
        }
    }
}
