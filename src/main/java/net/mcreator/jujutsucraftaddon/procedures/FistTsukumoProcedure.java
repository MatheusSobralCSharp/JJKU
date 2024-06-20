package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class FistTsukumoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Mass Black Hole Barrage")) {
			Tsukumo2Procedure.execute(world, x, y, z, entity);
		}
		if (!((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Mass Black Hole Barrage")) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 4, Level.ExplosionInteraction.NONE);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY()), (entity.getZ()), 5, 0, 0, 0, 1);
		}
	}
}
