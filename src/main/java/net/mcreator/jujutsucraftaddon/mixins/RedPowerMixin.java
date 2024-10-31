package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({KeyChangeTechniqueOnKeyPressedProcedure.class})
public abstract class RedPowerMixin {

    public RedPowerMixin() {
    }

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 0.1),
            remap = false
    )
    private static double modifyConstant(double constant, LevelAccessor world) {
        if (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SIX_EYES_LEVEL) > 1) {
            return (double) world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SIX_EYES_LEVEL) / 10;
        } else {
            return 0.1;
        }
    }

    @Inject(method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V", at = @At("RETURN"), remap = false)
    private static void modifyCurseTechniqueCost(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                if (livingEntity.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    double newCost = Math.round(capability.PlayerSelectCurseTechniqueCost * (double) (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_LEVEL)) / 10);
                    capability.PlayerSelectCurseTechniqueCost = newCost;
                    capability.syncPlayerVariables(entity);
                }
            });
        }
    }
}