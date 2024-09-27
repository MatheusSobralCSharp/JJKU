package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = AITrueSphereProcedure.class)
public abstract class SphereYorozuMixin {
    public SphereYorozuMixin() {

    }
    /**
     * @author Satushi
     * @reason Auto-Change the Yorozu Sphere Size and Strength, look at lines: 27, 28
     */
    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 15.0),
            remap = false
    )
    private static double injection0(double constant, LevelAccessor world) {
        if (world != null) {
            int valueNew = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_YOROZU_SPHERE_LIMIT);
            return valueNew;
        } else {
            return constant;
        }
    }
}


