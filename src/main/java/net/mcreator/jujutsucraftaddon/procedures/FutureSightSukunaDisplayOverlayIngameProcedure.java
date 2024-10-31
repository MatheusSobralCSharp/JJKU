package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class FutureSightSukunaDisplayOverlayIngameProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FutureSightNumber == Mth.nextInt(RandomSource.create(), 105, 107)) {
            return true;
        }
        return false;
    }
}
