package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftaddon.entity.ErroEntity;
import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class SukunaAttackAnimationsProcedure {
    public static void execute(Entity sourceentity, Entity entity, LevelAccessor world, double x, double y, double z) {
        if (sourceentity == null)
            return;


        if (!(sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()))) {
            if (!(sourceentity.getPersistentData().getDouble("skill") == 105 || sourceentity.getPersistentData().getDouble("skill") == 106)) {
                if (sourceentity instanceof ErroEntity) {
                    ((ErroEntity) sourceentity).setAnimation(("animation.sukuna.attack" + Mth.nextInt(RandomSource.create(), 1, 9)));
                }

                if (sourceentity instanceof ErrorEntity) {
                    ((ErrorEntity) sourceentity).setAnimation(("animation.sukuna.attack" + Mth.nextInt(RandomSource.create(), 1, 9)));
                }
            } else {
                if (sourceentity.getPersistentData().getDouble("skill") == 105) {
                    if (sourceentity.onGround()) {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation(("animation.dismantle_maximum" + Mth.nextInt(RandomSource.create(), 1, 4)));
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation(("animation.dismantle_maximum" + Mth.nextInt(RandomSource.create(), 1, 4)));
                        }
                    } else {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation("animation.dismantle_backwards");
                        }
                    }
                }
                if (sourceentity.getPersistentData().getDouble("skill") == 106) {
                    if (sourceentity.onGround()) {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation(("animation.cleave.attack" + Mth.nextInt(RandomSource.create(), 1, 5)));
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation(("animation.cleave.attack" + Mth.nextInt(RandomSource.create(), 1, 5)));
                        }
                    } else {
                        if (sourceentity instanceof ErroEntity) {
                            ((ErroEntity) sourceentity).setAnimation("animation.dissect");
                        }
                        if (sourceentity instanceof ErrorEntity) {
                            ((ErrorEntity) sourceentity).setAnimation("animation.dissect");
                        }
                    }
                }
            }
        } else {

        }
    }
}
