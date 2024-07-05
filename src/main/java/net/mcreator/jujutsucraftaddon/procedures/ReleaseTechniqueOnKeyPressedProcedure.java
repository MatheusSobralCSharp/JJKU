package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.minecraft.world.entity.Entity;
import net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure;

public class ReleaseTechniqueOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		net.mcreator.jujutsucraft.procedures.KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
	}
}
