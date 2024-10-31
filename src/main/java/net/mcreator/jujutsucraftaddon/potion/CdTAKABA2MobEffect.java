package net.mcreator.jujutsucraftaddon.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CdTAKABA2MobEffect extends MobEffect {
    public CdTAKABA2MobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
