package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class BindingVowTechniqueProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 1200, 3, false, false));
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
