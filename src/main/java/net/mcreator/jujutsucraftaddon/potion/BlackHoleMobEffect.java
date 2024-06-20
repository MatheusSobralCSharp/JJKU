
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.BlackHoleEffectExpiresProcedure;

public class BlackHoleMobEffect extends MobEffect {
	public BlackHoleMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BlackHoleEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}