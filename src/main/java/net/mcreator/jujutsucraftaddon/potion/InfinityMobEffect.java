package net.mcreator.jujutsucraftaddon.potion;

import net.mcreator.jujutsucraftaddon.procedures.InfinityOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class InfinityMobEffect extends MobEffect {
    public InfinityMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        InfinityOnEffectActiveTickProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
