package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class GojoMangaOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("UseCursedTechnique") == 0) {
			entity.getPersistentData().putDouble("UseCursedTechnique", 0);
		}
		if (entity.getPersistentData().getDouble("JujutsuSorcerer") == 0) {
			entity.getPersistentData().putDouble("JujutsuSorcerer", 0);
		}
	}
}
