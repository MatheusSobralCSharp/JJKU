
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.ContainedOnEffectActiveTickProcedure;

public class ContainedMobEffect extends MobEffect {
	public ContainedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ContainedOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
