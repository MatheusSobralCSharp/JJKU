package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparation2Entity;
import net.mcreator.jujutsucraft.procedures.AIZeninMakiProcedure;
import net.mcreator.jujutsucraft.procedures.AIGojoSchoolDaysProcedure;

public class GojoMangaOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("UseCursedTechnique") == 0) {
			entity.getPersistentData().putDouble("UseCursedTechnique", 0);
		}
		if (entity.getPersistentData().getDouble("JujutsuSorcerer") == 0) {
			entity.getPersistentData().putDouble("JujutsuSorcerer", 0);
		}
		if (entity instanceof MakiPreparationEntity) {
			AIZeninMakiProcedure.execute(world, x, y, z, entity);
		} else if (entity instanceof MakiPreparation2Entity) {
			if (Math.random() < (1) / ((float) 1000000)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get()), x, (y - 134), z, 0, 3, 3, 3, 1);
			}
		}
		AIGojoSchoolDaysProcedure.execute(world, x, y, z, entity);
	}
}
