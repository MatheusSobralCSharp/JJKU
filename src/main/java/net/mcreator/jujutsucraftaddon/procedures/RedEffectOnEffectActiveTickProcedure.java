package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class RedEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		JujutsucraftaddonMod.queueServerWork(160, () -> {
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:height 1 " + entity.getStringUUID());
			}
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:width 1 " + entity.getStringUUID());
			}
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 6, Level.ExplosionInteraction.TNT);
		});
	}
}
