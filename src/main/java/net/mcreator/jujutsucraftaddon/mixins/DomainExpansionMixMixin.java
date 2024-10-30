package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.DomainExpansionOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = DomainExpansionOnEffectActiveTickProcedure.class)
public abstract class DomainExpansionMixMixin {
    public DomainExpansionMixMixin() {
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_DOMAIN_NERF)) {
            if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get()))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get(), -1, 1, false, false));
            }
        }
    }
}