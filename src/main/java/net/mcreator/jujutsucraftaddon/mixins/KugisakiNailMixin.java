package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.BulletNailEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.procedures.DamageFixProcedure;
import net.mcreator.jujutsucraft.procedures.KugisakiNailProcedure;
import net.mcreator.jujutsucraft.procedures.RotateEntityProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(value = KugisakiNailProcedure.class, remap = false)
public abstract class KugisakiNailMixin {
    public KugisakiNailMixin() {

    }

    /**
     * @author Sat
     * @reason None
     */

    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double dis = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double power = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double CNT6 = 0.0;
            double distance = 0.0;
            double pitch = 0.0;
            double damage = 30.0;
            boolean logic_a = false;
            boolean logic_attack = false;
            boolean logic_b = false;
            boolean attack = false;
            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                _livEnt.swing(InteractionHand.MAIN_HAND, true);
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                var10000 = _livEnt.getMainHandItem();
            } else {
                var10000 = ItemStack.EMPTY;
            }

            Level projectileLevel;
            if (var10000.getItem() == JujutsucraftModItems.HAMMER.get()) {
                if (world instanceof Level) {
                    projectileLevel = (Level) world;
                    if (!projectileLevel.isClientSide()) {
                        projectileLevel.playSound((Player) null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F);
                    } else {
                        projectileLevel.playLocalSound(x, y, z, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
                    }
                }
            }

            if (Math.random() <= 0.01) {
                if (entity instanceof Player) {
                    Player _player = (Player) entity;
                    ItemStack _stktoremove = new ItemStack((ItemLike) JujutsucraftModItems.NAIL.get());
                    _player.getInventory().clearOrCountMatchingItems((p) -> {
                        return _stktoremove.getItem() == p.getItem();
                    }, 1, _player.inventoryMenu.getCraftSlots());
                }
            }

            LivingEntity var43;
            if (entity instanceof Mob) {
                Mob _mobEnt = (Mob) entity;
                var43 = _mobEnt.getTarget();
            } else {
                var43 = null;
            }

            if (var43 instanceof LivingEntity) {
                Mob _mobEnt;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var43 = _mobEnt.getTarget();
                } else {
                    var43 = null;
                }

                Level var48 = var43.level();
                ClipContext var10001;
                LivingEntity var10003;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10003 = _mobEnt.getTarget();
                } else {
                    var10003 = null;
                }

                Vec3 var51 = var10003.getEyePosition(1.0F);
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                Vec3 var53 = var10004.getEyePosition(1.0F);
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var53 = var53.add(var10005.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var54 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                LivingEntity var10007;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var10001 = new ClipContext(var51, var53, var54, var10006, var10007);
                double var49 = (double) var48.clip(var10001).getBlockPos().getX();
                LivingEntity var44;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var44 = _mobEnt.getTarget();
                } else {
                    var44 = null;
                }

                Level var45 = var44.level();
                ClipContext var10002;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                var53 = var10004.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                Vec3 var56 = var10005.getEyePosition(1.0F);
                LivingEntity var55;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var55 = _mobEnt.getTarget();
                } else {
                    var55 = null;
                }

                var56 = var56.add(var55.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var57 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var58 = ClipContext.Fluid.NONE;
                LivingEntity var10008;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10008 = _mobEnt.getTarget();
                } else {
                    var10008 = null;
                }

                var10002 = new ClipContext(var53, var56, var57, var58, var10008);
                double var47 = (double) var45.clip(var10002).getBlockPos().getY();
                LivingEntity var46;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var46 = _mobEnt.getTarget();
                } else {
                    var46 = null;
                }

                Level var50 = var46.level();
                ClipContext var52;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                var56 = var10005.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var55 = _mobEnt.getTarget();
                } else {
                    var55 = null;
                }

                Vec3 var59 = var55.getEyePosition(1.0F);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10007 = _mobEnt.getTarget();
                } else {
                    var10007 = null;
                }

                var59 = var59.add(var10007.getViewVector(1.0F).scale(0.0));
                ClipContext.Block var61 = ClipContext.Block.OUTLINE;
                ClipContext.Fluid var60 = ClipContext.Fluid.NONE;
                LivingEntity var10009;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob) entity;
                    var10009 = _mobEnt.getTarget();
                } else {
                    var10009 = null;
                }

                var52 = new ClipContext(var56, var59, var61, var60, var10009);
                RotateEntityProcedure.execute(var49, var47, (double) var50.clip(var52).getBlockPos().getZ(), entity);
            }

            entity.getPersistentData().putDouble("Damage", 1.5);
            DamageFixProcedure.execute(entity);
            Entity _shootFrom = entity;
            projectileLevel = _shootFrom.level();
            if (!projectileLevel.isClientSide()) {
                Projectile _entityToSpawn = ((new Object() {
                    public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
                        AbstractArrow entityToSpawn = new BulletNailEntity((EntityType) JujutsucraftModEntities.BULLET_NAIL.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double) damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setCritArrow(true);
                        entityToSpawn.pickup = AbstractArrow.Pickup.ALLOWED;
                        return entityToSpawn;
                    }
                })).getArrow(projectileLevel, entity, (float) damage, 0);
                _entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
                _entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3.0F, 0.0F);
                projectileLevel.addFreshEntity(_entityToSpawn);
            }

            entity.getPersistentData().putDouble("skill", 0.0);
        }
    }
}