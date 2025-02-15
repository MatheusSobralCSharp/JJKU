package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ReturnRebirthProcedure {
    public static boolean execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return false;
        return (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel >= 30000
                * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY));
    }
}
