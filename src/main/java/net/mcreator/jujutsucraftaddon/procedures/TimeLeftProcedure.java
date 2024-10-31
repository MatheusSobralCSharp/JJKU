package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class TimeLeftProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return "Time Left: " + new java.text.DecimalFormat("##.##").format((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).TimeLeft / 20);
    }
}
