package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class BulletProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD.get()), (entity.getX()), (entity.getY() + 2), (entity.getZ()), 0, 0, 0, 0, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 1.5), (entity.getZ()), 0, 0, 0, 0, 1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
	}
}
