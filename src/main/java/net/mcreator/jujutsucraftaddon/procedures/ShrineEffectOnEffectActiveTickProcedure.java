package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ShrineEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double particleRadius = 0;
		double particleAmount = 0;
		if (ModList.get().isLoaded("jjkueffects")) {
			ParticlesEffectsProcedure.execute(entity);
		} else {
			Particles2Procedure.execute(world, entity);
		}
	}
}
