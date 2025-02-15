package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaKeybindOnKeyPressedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        double numberrea = 0;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_SPAWNING.get(), 60, 1, false, false));
    }
}
