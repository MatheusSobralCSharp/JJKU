package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class ChosoArmsLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get(), 50,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getAmplifier() : 0) + 14), false,
					false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 50,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier() : 0) + 14), false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 3, false, false));
	}
}
