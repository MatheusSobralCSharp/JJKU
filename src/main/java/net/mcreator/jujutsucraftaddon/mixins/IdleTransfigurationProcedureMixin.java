package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.IdleTransfigurationProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = IdleTransfigurationProcedure.class, priority = -10000)
public abstract class IdleTransfigurationProcedureMixin {

    /**
     * @author Satushi
     * @reason Changes IdleTransfiguration buffing the range + damage ( Need be fixed in v40 )
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean worldCutter = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double CNT6 = 0.0;
            double distance = 0.0;
            double old_skill = 0.0;
            double range = 0.0;
            double old_cooldown = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity _entity) {
                if (!_entity.level().isClientSide()) {
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
                }
            }

            x_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
            LivingEntity var10000;
            if (entity instanceof Mob _mobEnt) {
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                EntityAnchorArgument.Anchor var10001 = EntityAnchorArgument.Anchor.EYES;
                Vec3 var10002;
                Mob _mobEnt;
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                double var22 = var10004.getX();
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                double var23 = var10005.getY();
                LivingEntity var10006;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var23 += (double) var10006.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var10002 = new Vec3(var22, var23, var10006.getZ());
                entity.lookAt(var10001, var10002);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                entity.getPersistentData().putDouble("Damage", 24.0 + entity.getPersistentData().getDouble("cnt2") * 0.1 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_IDLE_TRANSFIGURATION_LEVEL)));
                entity.getPersistentData().putDouble("Range", 5.0 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_IDLE_TRANSFIGURATION_LEVEL)));
                entity.getPersistentData().putDouble("effect", 2.0);
                entity.getPersistentData().putDouble("knockback", 0.1);
                entity.getPersistentData().putDouble("effect", 12.0);
                entity.getPersistentData().putDouble("effectConfirm", 2.0);
                entity.getPersistentData().putBoolean("swing", true);
                entity.getPersistentData().putBoolean("onlyLiving", true);
                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                entity.getPersistentData().putDouble("skill", 0.0);
            }

        }
    }
}
