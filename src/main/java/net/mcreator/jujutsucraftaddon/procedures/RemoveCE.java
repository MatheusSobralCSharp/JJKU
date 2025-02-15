package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class RemoveCE {
    public static void execute(Entity entity, Level world) {
        if (entity == null || world == null) return;
        {
            double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 25);
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.PlayerCursePower = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity.getPersistentData().getDouble("skill") == 120) {
            {
                double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 100);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerCursePower = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }

    }
}
