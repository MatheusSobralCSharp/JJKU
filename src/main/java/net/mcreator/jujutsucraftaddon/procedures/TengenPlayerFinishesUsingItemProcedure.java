package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class TengenPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (Math.random() <= 0.001) {
            {
                String _setval = "Tengen";
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.Subrace = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}
