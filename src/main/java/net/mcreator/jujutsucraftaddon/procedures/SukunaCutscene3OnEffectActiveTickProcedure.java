package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.ErroEntity;

public class SukunaCutscene3OnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ErroEntity) {
			((ErroEntity) entity).setAnimation("animation.sukuna.mode2");
		}
	}
}
