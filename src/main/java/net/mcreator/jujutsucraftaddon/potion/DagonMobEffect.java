
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jujutsucraftaddon.procedures.DagonOnEffectActiveTickProcedure;

public class DagonMobEffect extends MobEffect {
	public DagonMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3342337);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		DagonOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
