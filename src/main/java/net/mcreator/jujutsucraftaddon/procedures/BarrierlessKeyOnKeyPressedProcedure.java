package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

public class BarrierlessKeyOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
			if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
					&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"))).isDone()) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain == false) {
					{
						boolean _setval = true;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.BarrierlessDomain = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("dialoguebarrierless").getString() + ": On")), false);
					if (entity instanceof Player _player)
						_player.closeContainer();
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain == true) {
					{
						boolean _setval = false;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.BarrierlessDomain = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((Component.translatable("dialoguebarrierless").getString() + ": Off")), false);
					if (entity instanceof Player _player)
						_player.closeContainer();
				}
			}
		}
	}
}
