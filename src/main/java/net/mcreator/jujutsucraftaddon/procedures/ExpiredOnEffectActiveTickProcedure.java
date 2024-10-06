package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class ExpiredOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.isClientSide()) {
			if (Minecraft.getInstance().gameRenderer.currentEffect() != null) {
				Minecraft.getInstance().gameRenderer.shutdownEffect();
			}
		}
	}
}
