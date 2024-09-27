package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class ReturnBarrierlessExpProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return Component.translatable("amount5").getString() + "" + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessCount
				+ Component.translatable("amount6").getString();
	}
}
