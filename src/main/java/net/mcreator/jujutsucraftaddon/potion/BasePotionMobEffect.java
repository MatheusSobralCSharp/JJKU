package net.mcreator.jujutsucraftaddon.potion;

import net.mcreator.jujutsucraftaddon.procedures.BasePotionOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class BasePotionMobEffect extends MobEffect {
    public BasePotionMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        BasePotionOnEffectActiveTickProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
