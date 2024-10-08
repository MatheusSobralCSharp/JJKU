package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class NoCooldownProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get());
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.UNSTABLE.get());
		} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get());
		}
	}
}
