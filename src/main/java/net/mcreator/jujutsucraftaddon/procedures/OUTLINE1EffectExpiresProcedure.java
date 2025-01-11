package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class OUTLINE1EffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		String setr = "";
		if (world.isClientSide()) {
			Minecraft.getInstance().gameRenderer.shutdownEffect();
			Minecraft.getInstance().gameRenderer.shutdownEffect();
			Minecraft.getInstance().gameRenderer.shutdownEffect();
			Minecraft.getInstance().gameRenderer.shutdownEffect();
			Minecraft.getInstance().gameRenderer.shutdownEffect();
		}
		Minecraft.getInstance().gameRenderer.shutdownEffect();
		Minecraft.getInstance().gameRenderer.shutdownEffect();
	}
}
