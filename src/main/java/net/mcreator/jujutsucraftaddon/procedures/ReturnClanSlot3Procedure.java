package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;

public class ReturnClanSlot3Procedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ClanSlot3;
    }
}
