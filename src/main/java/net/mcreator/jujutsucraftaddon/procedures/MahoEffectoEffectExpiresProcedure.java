package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class MahoEffectoEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!entity.level().isClientSide())
			entity.discard();
	}
}
