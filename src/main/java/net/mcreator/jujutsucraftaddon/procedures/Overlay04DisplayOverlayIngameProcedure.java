package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

public class Overlay04DisplayOverlayIngameProcedure {
    public static boolean execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return false;
        return (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Kokusen == 4 && entity instanceof LivingEntity _livEnt0
                && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.KOKUSEN_EFFECT_TWO.get()) && world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE) == false;
    }
}
