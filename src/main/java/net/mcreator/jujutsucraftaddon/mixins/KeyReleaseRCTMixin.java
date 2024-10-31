package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.KeyReverseCursedTechniqueOnKeyReleasedProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(value = KeyReverseCursedTechniqueOnKeyReleasedProcedure.class, remap = false)
public abstract class KeyReleaseRCTMixin {
    public KeyReleaseRCTMixin() {
    }

    /**
     * @author Sat
     * @reason None
     */
    @Overwrite
    public static void execute(Entity entity) {
        if (entity != null) {
            if (entity instanceof LivingEntity _entity) {
                _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
            }
            entity.getPersistentData().putBoolean("PRESS_BURNOUT", false);
            entity.getPersistentData().putDouble("cnt_v", 0);
            entity.getPersistentData().putBoolean("PRESS_M", false);
        }
    }
}
