
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.BindingVowOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowEffectStartedappliedProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowEffectExpiresProcedure;

public class BindingVowMobEffect extends MobEffect {
	public BindingVowMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3407872);
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.addAttributeModifiers(entity, attributeMap, amplifier);
		BindingVowEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BindingVowOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BindingVowEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
