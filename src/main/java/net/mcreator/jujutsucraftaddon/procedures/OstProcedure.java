package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class OstProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OstVariable == 0) {
            {
                double _setval = 1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.OstVariable = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Disabled Ost"), false);
        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OstVariable == 1) {
            {
                double _setval = 0;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.OstVariable = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Enabled Ost"), false);
        }
    }
}
