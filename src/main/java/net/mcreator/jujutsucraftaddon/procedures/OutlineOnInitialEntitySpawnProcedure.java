package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class OutlineOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("Tag1", 20);
	}
}
