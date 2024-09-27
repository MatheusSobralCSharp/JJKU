package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class FakeClonesOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		JujutsucraftaddonMod.queueServerWork(Mth.nextInt(RandomSource.create(), 1, 100), () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}
}
