package net.mcreator.jujutsucraftaddon.potion;

import net.mcreator.jujutsucraftaddon.procedures.KokusenEffectTwoOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class KokusenEffectTwoMobEffect extends MobEffect {
    public KokusenEffectTwoMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        KokusenEffectTwoOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
