package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class TextureAnimator1MobEffect extends MobEffect {
    public TextureAnimator1MobEffect() {
        super(MobEffectCategory.NEUTRAL, -1);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
