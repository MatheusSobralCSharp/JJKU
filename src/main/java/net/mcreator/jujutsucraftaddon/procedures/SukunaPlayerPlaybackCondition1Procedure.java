package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaPlayerPlaybackCondition1Procedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_CUTSCENE_1.get());
    }
}
