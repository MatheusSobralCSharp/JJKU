package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class CutRCTProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
		}
	}
}
