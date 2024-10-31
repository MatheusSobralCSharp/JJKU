package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class OvertimeOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get()), x, (y + 1), z, 2, 0, 0, 0, 0.5);
        } else if (world instanceof Level _lvl2 && _lvl2.isDay()) {
            if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.WEAKNESS))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1000, 1, false, false));
            }
        }
    }
}
