package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.KaichiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.GetDistanceNearestEnemyProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.SetRangedAmmoProcedure;
import net.mcreator.jujutsucraft.procedures.SkillKaichiProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = SkillKaichiProcedure.class, remap = false)
public abstract class RyuKaichiMixin {
    public RyuKaichiMixin() {
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean logic_a = false;
            boolean logic_b = false;
            boolean strong = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double num1 = 0.0;
            double range = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double CNT6 = 0.0;
            double range_2 = 0.0;
            double HP = 0.0;
            double pitch = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
                }
            }

            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                }
            }

            ((LivingEntity)entity).getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION1.get()).setBaseValue(-4.0);
            PlayAnimationProcedure.execute(entity);
            LivingEntity var10000;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                EntityAnchorArgument.Anchor var10001 = EntityAnchorArgument.Anchor.EYES;
                Vec3 var10002;
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                double var43 = var10004.getX();
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                double var44 = var10005.getY();
                LivingEntity var10006;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var44 += (double)var10006.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var10002 = new Vec3(var43, var44, var10006.getZ());
                entity.lookAt(var10001, var10002);
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (1.5 + (double)entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (1.5 + (double)entity.getBbWidth());
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
                entity.getPersistentData().putBoolean("PRESS_Z", false);
                if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 8.0) {
                    label176: {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                            label173: {
                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob)entity;
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
                                        break label173;
                                    }
                                }

                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob) entity;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                    break label176;
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
                entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 9.0));
            }

            if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    _livEnt.swing(InteractionHand.MAIN_HAND, true);
                }

                int var42;
                label136: {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var42 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label136;
                        }
                    }

                    var42 = 0;
                }

                HP = (double)(40 + var42 * 4 * 4);

                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain){
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel) world;
                        Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.KAICHI.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }
                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }

                        if (entityToSpawn != null) {
                            entityToSpawn.setYRot(entity.getYRot());
                            entityToSpawn.setYBodyRot(entity.getYRot());
                            entityToSpawn.setYHeadRot(entity.getYRot());
                            entityToSpawn.setXRot(entity.getXRot());
                        }
                    }

                } else if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.KAICHI.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                    if (entityToSpawn != null) {
                        entityToSpawn.setYRot(entity.getYRot());
                        entityToSpawn.setYBodyRot(entity.getYRot());
                        entityToSpawn.setYHeadRot(entity.getYRot());
                        entityToSpawn.setXRot(entity.getXRot());
                    }
                }

                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var50 = _entfound.iterator();

                while(var50.hasNext()) {
                    Entity entityiterator = (Entity)var50.next();
                    if (entityiterator instanceof KaichiEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        Entity _ent = entityiterator;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:1b}");
                        }

                        ((LivingEntity)entityiterator).getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        if (entityiterator instanceof LivingEntity) {
                            LivingEntity _entity = (LivingEntity)entityiterator;
                            _entity.setHealth((float)HP);
                        }
                        break;
                    }
                }

                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                    } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                    }
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    _livEnt.swing(InteractionHand.MAIN_HAND, true);
                }

                entity.getPersistentData().putDouble("skill", 0.0);
            }

        }
    }
}
