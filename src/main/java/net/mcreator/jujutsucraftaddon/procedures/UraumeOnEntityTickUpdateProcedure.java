package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class UraumeOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		UraumeOnInitialEntitySpawnProcedure.execute(entity);
		SukunaMangaRCTProcedure.execute(world, entity);
	}
}
