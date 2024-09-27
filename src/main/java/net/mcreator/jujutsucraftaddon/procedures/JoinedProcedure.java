package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JoinedProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RCT_LEVEL_CAP));
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RCTLimitLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).blackflashmastery == 0) {
			{
				double _setval = 1;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.blackflashmastery = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CE_CAP));
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.CECap = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
