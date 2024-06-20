package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class RedOOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.RED.get()), x, y, z, 1, 0, 0, 0, 0.1);
	}
}
