package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class BerserkEffectExpiresProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (world instanceof ServerLevel) {
            if (entity instanceof LivingEntity _livingEntity) {
                _livingEntity.removeEffect(MobEffects.DAMAGE_BOOST);
                _livingEntity.removeEffect(MobEffects.REGENERATION);
            }
        }
    }
}
