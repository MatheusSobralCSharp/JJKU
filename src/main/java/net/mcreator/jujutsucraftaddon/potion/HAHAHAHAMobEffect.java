package net.mcreator.jujutsucraftaddon.potion;

import net.mcreator.jujutsucraftaddon.procedures.HAHAHAHAEffectExpiresProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class HAHAHAHAMobEffect extends MobEffect {
    public HAHAHAHAMobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
        super.removeAttributeModifiers(entity, attributeMap, amplifier);
        HAHAHAHAEffectExpiresProcedure.execute(entity.level(), entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
