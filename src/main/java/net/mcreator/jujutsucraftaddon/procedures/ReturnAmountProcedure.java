package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class ReturnAmountProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return Component.translatable("amount1").getString() + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount2
                + Component.translatable("amount2").getString();
    }
}
