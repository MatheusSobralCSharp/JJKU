package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionEffectExpiresProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = DomainExpansionEffectExpiresProcedure.class, remap = false)
public abstract class DomainFinishMixin {
    public DomainFinishMixin() {

    }
    /**
     * @author Sat
     * @reason None
     */
    @Inject(
            method = {"execute"},
            at = {@At("HEAD")},
            remap = false
    )
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity instanceof Entity && !((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
            if ((((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) >= 2) {
                if (entity instanceof LivingEntity _entity)
                    _entity.removeEffect(JujutsucraftModMobEffects.ZONE.get());
                JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
                JujutsucraftModVariables.MapVariables.get(world).syncData(world);
            }
        }
    }
}