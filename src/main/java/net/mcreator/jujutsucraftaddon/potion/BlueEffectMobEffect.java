package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.BlueEffectOnEffectActiveTickProcedure;

public class BlueEffectMobEffect extends MobEffect {
    public BlueEffectMobEffect() {
        super(MobEffectCategory.NEUTRAL, -1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        BlueEffectOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
