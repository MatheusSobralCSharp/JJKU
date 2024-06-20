
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.GojoAwakeningOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftaddon.procedures.GojoAwakeningEffectStartedappliedProcedure;

public class GojoAwakeningMobEffect extends MobEffect {
	public GojoAwakeningMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GojoAwakeningEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GojoAwakeningOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
