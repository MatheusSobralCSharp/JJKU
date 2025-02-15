package net.mcreator.jujutsucraftaddon.potion;

import net.mcreator.jujutsucraftaddon.procedures.SukunaCutscene3OnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SukunaCutscene3MobEffect extends MobEffect {
    public SukunaCutscene3MobEffect() {
        super(MobEffectCategory.BENEFICIAL, -1);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        SukunaCutscene3OnEffectActiveTickProcedure.execute(entity);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
