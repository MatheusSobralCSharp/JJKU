package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = MaximumMeteorProcedure.class, remap = false)
public abstract class JogoLaserMixin {
    public JogoLaserMixin(){
    }
    /**
     * @author Sat
     * @reason Testing
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean rotate = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double CNT6 = 0.0;
            double damage = 0.0;
            double picth = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            LivingEntity var10000;
            LivingEntity _entity;
            Mob _mobEnt;
            ServerLevel _level;
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                    }
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                        label265: {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                label266: {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob) entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getBoolean("attack")) {
                                            break label266;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob) entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label265;
                                    }
                                }
                            }

                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    ItemStack var50;
                    if (!(entity instanceof Player)) {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var50 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var50 = ItemStack.EMPTY;
                        }

                        var50.getOrCreateTag().putDouble("P_ANIME1", -4.0);
                    }

                    PlayAnimationProcedure.execute(entity);
                    if (entity instanceof Player) {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            var50 = _entity.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var50 = ItemStack.EMPTY;
                        }

                        var50.getOrCreateTag().putDouble("P_ANIME1", -4.0);
                    }

                    entity.getPersistentData().putDouble("cnt1", 0.0);
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.0, 0.0, 0.0, 0.05);
                        }
                    } else if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.0, 0.0, 0.0, 0.0);
                    }

                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.END_ROD, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.0, 0.0, 0.0, 0.0);
                    }

                    if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                        if (entity instanceof Player) {
                            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }

                        if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                            entity.getPersistentData().putDouble("cnt6", 5.0);
                            if (world instanceof Level) {
                                Level _level2 = (Level)world;
                                if (!_level2.isClientSide()) {
                                    _level2.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                }
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.1);
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 2.0) {
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    Level var58 = var10000.level();
                    ClipContext var10001 = new ClipContext(var10000.getEyePosition(1.0F), new Vec3(entity.getX(), entity.getY(), entity.getZ()), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity);
                    LivingEntity var10003;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10003 = _mobEnt.getTarget();
                    } else {
                        var10003 = null;
                    }

                    Vec3 var48 = var10003.getEyePosition(1.0F);
                    LivingEntity var10004;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.getTarget();
                    } else {
                        var10004 = null;
                    }

                    Vec3 var51 = var10004.getEyePosition(1.0F);
                    LivingEntity var10005;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    var51 = var51.add(var10005.getViewVector(1.0F).scale(0.0));
                    ClipContext.Block var52 = ClipContext.Block.OUTLINE;
                    ClipContext.Fluid var10006 = ClipContext.Fluid.NONE;
                    LivingEntity var10007;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10007 = _mobEnt.getTarget();
                    } else {
                        var10007 = null;
                    }

                    var10001 = new ClipContext(var48, var51, var52, var10006, var10007);
                    double var60 = (double)var58.clip(var10001).getBlockPos().getX();
                    LivingEntity var40;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var40 = _mobEnt.getTarget();
                    } else {
                        var40 = null;
                    }

                    Level var41 = var40.level();
                    ClipContext var10002 = null;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10004 = _mobEnt.getTarget();
                    } else {
                        var10004 = null;
                    }

                    var51 = var10004.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    Vec3 var54 = var10005.getEyePosition(1.0F);
                    LivingEntity var53;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var53 = _mobEnt.getTarget();
                    } else {
                        var53 = null;
                    }

                    var54 = var54.add(var53.getViewVector(1.0F).scale(0.0));
                    ClipContext.Block var55 = ClipContext.Block.OUTLINE;
                    ClipContext.Fluid var56 = ClipContext.Fluid.NONE;
                    LivingEntity var10008;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10008 = _mobEnt.getTarget();
                    } else {
                        var10008 = null;
                    }

                    var10002 = new ClipContext(var51, var54, var55, var56, var10008);
                    double var43 = (double)var41.clip(var10002).getBlockPos().getY();
                    LivingEntity var42;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var42 = _mobEnt.getTarget();
                    } else {
                        var42 = null;
                    }

                    Level var45 = var42.level();
                    ClipContext var49;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10005 = _mobEnt.getTarget();
                    } else {
                        var10005 = null;
                    }

                    var54 = var10005.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var53 = _mobEnt.getTarget();
                    } else {
                        var53 = null;
                    }

                    Vec3 var57 = var53.getEyePosition(1.0F);
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10007 = _mobEnt.getTarget();
                    } else {
                        var10007 = null;
                    }

                    var57 = var57.add(var10007.getViewVector(1.0F).scale(0.0));
                    ClipContext.Block var61 = ClipContext.Block.OUTLINE;
                    ClipContext.Fluid var59 = ClipContext.Fluid.NONE;
                    LivingEntity var10009;
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10009 = _mobEnt.getTarget();
                    } else {
                        var10009 = null;
                    }

                    var49 = new ClipContext(var54, var57, var61, var59, var10009);
                    RotateEntityProcedure.execute(var60, var43, (double)var45.clip(var49).getBlockPos().getZ(), entity);
                }

                int var44;
                label230: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var44 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label230;
                        }
                    }

                    var44 = 0;
                }

                HP = (double)(40 + var44 * 8);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    Commands var62 = _level.getServer().getCommands();
                    CommandSourceStack var47 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                    long var46 = Math.round(HP);
                    var62.performPrefixedCommand(var47, "summon jujutsucraft:energy_ball_white ~ ~ ~ {NoAI:1b,Health:" + var46 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + Math.round(entity.getYRot() % 360.0F) + "F," + Math.round(entity.getXRot()) + "F]}");
                }

                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var34 = _entfound.iterator();

                while(var34.hasNext()) {
                    Entity entityiterator = (Entity)var34.next();
                    if (entityiterator instanceof EnergyBallWhiteEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        entityiterator.getPersistentData().putBoolean("flame", true);
                        entityiterator.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                        entityiterator.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 4.0);
                        entityiterator.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 4.0);
                        entityiterator.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 4.0);
                        break;
                    }
                }

                if (world instanceof Level) {
                    Level _level3 = (Level)world;
                    if (!_level3.isClientSide()) {
                        _level3.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.8F, 1.0F);
                    } else {
                        _level3.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.8F, 1.0F, false);
                    }
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 25, 0.1, 0.1, 0.1, 1.0);
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }

        }
    }
}
