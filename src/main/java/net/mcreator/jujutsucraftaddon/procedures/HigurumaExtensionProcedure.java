package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class HigurumaExtensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals(Component.translatable("jujutsu.technique.attack1").getString())) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Confiscation";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals(Component.translatable("jujutsu.technique.attack3").getString())) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Guilty";
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
