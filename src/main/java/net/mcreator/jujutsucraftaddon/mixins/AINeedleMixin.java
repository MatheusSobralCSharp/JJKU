package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.NeedleEntity;
import net.mcreator.jujutsucraft.procedures.AINeedleProcedure;
import net.mcreator.jujutsucraft.procedures.BulletDomainHit2Procedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AINeedleProcedure.class, priority = 3000)
public abstract class AINeedleMixin {
    public AINeedleMixin(){
    }
    /**
     * @author Satushi
     * @reason Fix Damage Needle
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            boolean logic_a = false;
            boolean attack = false;
            Entity entity_a = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_target = 0.0;
            double y_target = 0.0;
            double z_target = 0.0;
            double yaw_cal = 0.0;
            double pitch_cal = 0.0;
            double move_power = 0.0;
            double dis = 0.0;
            double tick = 0.0;
            double z_fix = 0.0;
            double num1 = 0.0;
            double x_fix = 0.0;
            double y_fix = 0.0;
            double old_distance = 0.0;
            double distance = 0.0;
            double num2 = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 4.0) {
                entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
                if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                    if (entity instanceof NeedleEntity) {
                        ((NeedleEntity)entity).setAnimation("attack");
                    }

                    if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                        } else {
                            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("cnt1") == 7.0) {
                    x_pos = entity.getX();
                    y_pos = entity.getY();
                    z_pos = entity.getZ();
                    x_power = 0.0;
                    y_power = 1.0;
                    z_power = 0.0;

                    double e = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0;

                    for(int index0 = 0; index0 < (int)entity.getBbHeight(); ++index0) {
                        entity.getPersistentData().putDouble("Damage", 10.0 * e / 5);
                        entity.getPersistentData().putDouble("Range", 2.5);
                        entity.getPersistentData().putDouble("effect", 1.0);
                        entity.getPersistentData().putDouble("knockback", 0.01);
                        entity.getPersistentData().putDouble("projectile_type", 1.0);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        x_pos += x_power;
                        y_pos += y_power;
                        z_pos += z_power;
                    }
                }

                if (entity.getPersistentData().getDouble("cnt1") > 35.0 && !entity.level().isClientSide()) {
                    entity.discard();
                }

                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            }

        }
        ci.cancel();
    }
}
