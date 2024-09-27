package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class YuunItemGlowingConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get());
	}
}
