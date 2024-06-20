
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.RCTCutOnEffectActiveTickProcedure;

public class RCTCutMobEffect extends MobEffect {
	public RCTCutMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RCTCutOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
