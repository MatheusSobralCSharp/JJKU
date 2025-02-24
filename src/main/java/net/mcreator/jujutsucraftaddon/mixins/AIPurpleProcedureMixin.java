package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AIPurpleProcedure.class, priority = -10000)
public abstract class AIPurpleProcedureMixin {
    /**
     * @author Sat
     * @reason None
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_attack = false;
            boolean big = false;
            Entity entity_a = null;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double rad = 0.0;
            double rad_now = 0.0;
            double dis = 0.0;
            double z_power = 0.0;
            double y_power = 0.0;
            double x_power = 0.0;
            double power = 0.0;
            double pitch = 0.0;
            double yaw = 0.0;
            double range = 0.0;
            double damage = 0.0;
            double num_loop = 0.0;
            big = entity.getPersistentData().getBoolean("explode");
            power = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (big) {
                range = ReturnEntitySizeProcedure.execute(entity) + entity.getPersistentData().getDouble("cnt6");
            } else {
                range = ReturnEntitySizeProcedure.execute(entity);
            }
            if (big) {
                range *= 1.0;
                if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                    entity.getPersistentData().putDouble("cnt3", 1.0);
                }
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                Level _level;
                if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                    logic_attack = false;
                    if (LogicOwnerExistProcedure.execute(world, entity)) {
                        entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                            public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                        return serverLevel.getEntity(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                }

                                return null;
                            }
                        }).apply(world, entity.getPersistentData().getString("OWNER_UUID"));
                        if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                            logic_attack = true;
                            yaw = Math.toRadians(entity_a.getYRot() + 90.0F);
                            pitch = Math.toRadians(entity_a.getXRot());
                            dis = 1.5 + (double) entity_a.getBbWidth();
                            Entity _ent = entity;
                            _ent.teleportTo(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double) entity_a.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                _serverPlayer.connection.teleport(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double) entity_a.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis, _ent.getYRot(), _ent.getXRot());
                            }

                            entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                            entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                            entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                            entity.getPersistentData().putDouble("cnt3", 1.0);
                        }
                    }

                    if (Math.random() < 0.05 && world instanceof Level) {
                        _level = (Level) world;
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float) (0.5 + Math.random()));
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float) (0.5 + Math.random()), false);
                        }
                    }

                    if (!logic_attack || !entity.isAlive()) {
                        entity.getPersistentData().putDouble("cnt3", 1.0);
                    }
                } else {
                    entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                    if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                    } else {
                        BulletDomainHit2Procedure.execute(world, entity);
                        if (big) {
                            if (((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() < 300.0) {
                                ((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).setBaseValue(Math.min(((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() + 15.0, 300.0));
                            }

                            if (entity.getPersistentData().getDouble("cnt1") == 10.0 && world instanceof Level) {
                                _level = (Level) world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
                                }
                            }

                            if (entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0 && world instanceof Level) {
                                _level = (Level) world;
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float) (1.0 + Math.random()));
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float) (1.0 + Math.random()), false);
                                }
                            }
                        }

                        if (world instanceof ServerLevel _level1) {
                            _level1.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int) (5.0 * range), range, range, range, range);
                        }

                        x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
                        y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
                        z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
                        dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                        if (dis > 0.0) {
                            x_power /= dis;
                            y_power /= dis;
                            z_power /= dis;
                        }

                        damage = Math.max(80.0 * Math.pow(0.99, entity.getPersistentData().getDouble("cnt_life")), 55.0) * power;

                        for (int index0 = 0; index0 < (int) Math.round(Math.max(dis, 1.0)); ++index0) {
                            x_pos = entity.getX();
                            y_pos = entity.getY();
                            z_pos = entity.getZ();
                            if (!big && entity.getPersistentData().getDouble("cnt1") >= 12.0) {
                                if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                                    if (world instanceof Level) {
                                        _level = (Level) world;
                                        if (!_level.isClientSide()) {
                                            _level.explode(null, x_pos, y_pos, z_pos, (float) (2.0 * range), Level.ExplosionInteraction.MOB);
                                        }
                                    }
                                } else if (world instanceof Level) {
                                    _level = (Level) world;
                                    if (!_level.isClientSide()) {
                                        _level.explode(null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                    }
                                }
                            }

                            if (!big || entity.getPersistentData().getDouble("cnt1") <= 30.0) {
                                entity.getPersistentData().putDouble("Damage", damage);
                                entity.getPersistentData().putDouble("Range", 8.0 * range);
                                entity.getPersistentData().putDouble("knockback", big ? 1.0 : 0.1);
                                entity.getPersistentData().putDouble("effectConfirm", 2.0);
                                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                            }

                            if (!big || entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0) {
                                entity.getPersistentData().putDouble("BlockRange", 3.0 * range);
                                entity.getPersistentData().putDouble("BlockDamage", 18.0 * power);
                                entity.getPersistentData().putBoolean("noParticle", true);
                                entity.getPersistentData().putBoolean("noEffect", true);
                                entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                                BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                            }

                            if (world instanceof ServerLevel _level2) {
                                _level2.sendParticles(JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE.get(), x_pos, y_pos, z_pos, (int) (5.0 * range), range, range, range, range);
                            }

                            if (big) {
                                break;
                            }

                            if (entity.getPersistentData().getBoolean("Stop")) {
                                entity.getPersistentData().putBoolean("Stop", false);
                                break;
                            }

                            entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                            if (entity instanceof ServerPlayer _serverPlayer) {
                                _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                            }
                        }

                        if (big) {
                            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        } else {
                            entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
                        }

                        entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                        if (((LivingEntity) entity).getAttribute(JujutsucraftModAttributes.SIZE.get()).getBaseValue() < 80.0) {
                            if (entity.getPersistentData().getDouble("cnt1") >= (double) (big ? 80 : 30) && !entity.level().isClientSide()) {
                                entity.discard();
                            }
                        } else {
                            if (entity.getPersistentData().getDouble("cnt_life") >= (double) 500 && !entity.level().isClientSide()) {
                                entity.discard();
                            }
                        }

                    }
                }
            }

        }
    }
}
