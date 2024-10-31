package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.HeianOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftaddon.procedures.HeianEffectStartedappliedProcedure;

public class HeianMobEffect extends MobEffect {
    public HeianMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        HeianEffectStartedappliedProcedure.execute(entity);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        HeianOnEffectActiveTickProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
