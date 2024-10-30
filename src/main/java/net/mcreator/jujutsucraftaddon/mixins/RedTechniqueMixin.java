package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.GetDistanceNearestEnemyProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraft.procedures.TechniqueRedProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.PlayGojoRed2Procedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
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

@Mixin(value = TechniqueRedProcedure.class, remap = false)
public abstract class RedTechniqueMixin {
    public RedTechniqueMixin(){
    }

    /**
     * @author Satushi
     * @reason Changing Red
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double HP = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            boolean rotate = false;
            boolean logic_a = false;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            LivingEntity _livEnt;
            List _entfound;
            Iterator var24;
            Entity entityiterator;
            ServerLevel _level;
            Vec3 _center;
            Level _level2;
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                entity.getPersistentData().putDouble("cnt2", 1.0);
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    if (!_livEnt.level().isClientSide()) {
                        _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    _livEnt.swing(InteractionHand.MAIN_HAND, true);
                }

                int var10001;
                label183: {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label183;
                        }
                    }

                    var10001 = 0;
                }

                HP = (double)(40 + var10001 * 20);
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    Commands var10000 = _level.getServer().getCommands();
                    CommandSourceStack var29 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
                    long var10002 = Math.round(HP);
                    var10000.performPrefixedCommand(var29, "summon jujutsucraft:red ~ ~ ~ {Health:" + var10002 + "f,Attributes:[{Name:generic.max_health,Base:" + Math.round(HP) + "}],Rotation:[" + entity.getYRot() + "F," + entity.getXRot() + "F]}");
                }

                _center = new Vec3(x_pos, y_pos, z_pos);
                Vec3 final_center = _center;
                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(2.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(final_center);
                })).toList();
                var24 = _entfound.iterator();

                while(var24.hasNext()) {
                    entityiterator = (Entity)var24.next();
                    if (entityiterator instanceof RedEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        break;
                    }
                }

                if (world instanceof Level) {
                    _level2 = (Level)world;
                    if (!_level2.isClientSide()) {
                        _level2.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level2.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:slow_motion_end")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }
            }

            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                }
            }

            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                }
            }

            logic_a = false;
            _center = new Vec3(x_pos, y_pos, z_pos);
            Vec3 final_center1 = _center;
            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> {
                return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                return _entcnd.distanceToSqr(final_center1);
            })).toList();
            var24 = _entfound.iterator();

            while(var24.hasNext()) {
                entityiterator = (Entity)var24.next();
                if (entityiterator instanceof RedEntity && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                    logic_a = true;
                    entityiterator.getPersistentData().putDouble("cnt6", Math.max(entityiterator.getPersistentData().getDouble("cnt6"), entity.getPersistentData().getDouble("cnt6")));
                    entityiterator.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), entity.getDeltaMovement().y(), entity.getDeltaMovement().z()));
                    Entity _ent = entityiterator;
                    _ent.teleportTo(x_pos, y_pos, z_pos);
                    if (_ent instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, _ent.getYRot(), _ent.getXRot());
                    }
                    break;
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 20.0 && logic_a) {
                LivingEntity var28;
                if (entity instanceof Mob) {
                    Mob _mobEnt = (Mob)entity;
                    var28 = _mobEnt.getTarget();
                } else {
                    var28 = null;
                }

                if (var28 instanceof LivingEntity) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                        label196: {
                            if (entity instanceof Mob) {
                                Mob _mobEnt = (Mob)entity;
                                var28 = _mobEnt.getTarget();
                            } else {
                                var28 = null;
                            }

                            if (var28.getPersistentData().getDouble("skill") != 0.0) {
                                label197: {
                                    if (entity instanceof Mob) {
                                        Mob _mobEnt = (Mob)entity;
                                        var28 = _mobEnt.getTarget();
                                    } else {
                                        var28 = null;
                                    }

                                    if (var28.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            Mob _mobEnt = (Mob)entity;
                                            var28 = _mobEnt.getTarget();
                                        } else {
                                            var28 = null;
                                        }

                                        if (var28.getPersistentData().getBoolean("attack")) {
                                            break label197;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        Mob _mobEnt = (Mob)entity;
                                        var28 = _mobEnt.getTarget();
                                    } else {
                                        var28 = null;
                                    }

                                    if (var28.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label196;
                                    }
                                }
                            }

                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt57 = (LivingEntity)entity;
                        if (_livEnt57.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                            entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                    }

                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 20.0));
                    if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            ((ServerLevel) _level).sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.25, 0.25, 0.25, 0.5);
                        }
                    } else if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        ((ServerLevel) _level).sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(entity.getPersistentData().getDouble("cnt6") + 1.0), 0.25, 0.25, 0.25, 0.5);
                    }

                    if (entity.getPersistentData().getDouble("cnt6") < 3.0) {
                        entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                            entity.getPersistentData().putDouble("cnt5", 0.0);
                            entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                            if (entity instanceof Player) {
                                Player _player = (Player)entity;
                                if (!_player.level().isClientSide()) {
                                    CompoundTag var30 = entity.getPersistentData();
                                    _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.jujutsucraft.red" + Math.round(var30.getDouble("cnt6"))).getString() + "\""), false);
                                }
                            }

                            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 25.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                            _level2 = (Level)world;
                            if (!_level2.isClientSide()) {
                                _level2.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                            }
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            ((ServerLevel) _level).sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.5);
                        }

                        if (world instanceof Level) {
                            _level2 = (Level)world;
                            if (!_level2.isClientSide()) {
                                _level2.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                            } else {
                                _level2.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                            }
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Tatical Mode")){
                PlayGojoRed2Procedure.execute(world, x, y, z, entity);
            } else {
                PlayAnimationProcedure.execute(entity);
            }
        }
    }
}
