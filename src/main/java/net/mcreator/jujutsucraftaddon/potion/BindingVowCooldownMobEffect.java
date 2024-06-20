
package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BindingVowCooldownMobEffect extends MobEffect {
	public BindingVowCooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
