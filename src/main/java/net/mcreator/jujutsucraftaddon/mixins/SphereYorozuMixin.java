package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AITrueSphereProcedure.class, remap = false)
public abstract class SphereYorozuMixin {
    public SphereYorozuMixin() {

    }
    /**
     * @author S
     * @reason none
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            Entity entity_a = null;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_target = 0.0;
            double x_power = 0.0;
            double pitch = 0.0;
            double y_target = 0.0;
            double z_target = 0.0;
            double yaw = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double dis = 0.0;
            boolean logic_a = false;
            boolean LogicOwner = false;
            if (entity.isAlive()) {
                LivingEntity _livEnt7;
                if (entity instanceof LivingEntity) {
                    _livEnt7 = (LivingEntity)entity;
                    if (!_livEnt7.level().isClientSide()) {
                        _livEnt7.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
                    }
                }

                LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
                if (LogicOwner) {
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
                    LivingEntity _entity;
                    Entity _ent;
                    if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                        label148: {
                            if (entity instanceof LivingEntity) {
                                _livEnt7 = (LivingEntity)entity;
                                if (_livEnt7.hasEffect(MobEffects.REGENERATION)) {
                                    break label148;
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 4, false, false));
                                }
                            }
                        }

                        if (entity_a instanceof Player) {
                            double _setval = ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                            (new BiFunction<LevelAccessor, String, Entity>() {
                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                        try {
                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                        } catch (Exception var5) {
                                        }
                                    }

                                    return null;
                                }
                            }).apply(world, entity.getPersistentData().getString("OWNER_UUID")).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = _setval;
                                capability.syncPlayerVariables((new BiFunction<LevelAccessor, String, Entity>() {
                                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                        if (levelAccessor instanceof ServerLevel serverLevel) {
                                            try {
                                                return serverLevel.getEntity(UUID.fromString(uuid));
                                            } catch (Exception var5) {
                                            }
                                        }

                                        return null;
                                    }
                                }).apply(world, entity.getPersistentData().getString("OWNER_UUID")));
                            });
                            if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0) {
                                _ent = entity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                                }
                            }
                        }
                    }

                    if (((LivingEntity)entity).getAttribute((Attribute) JujutsucraftModAttributes.SIZE.get()).getBaseValue() < world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_YOROZU_SPHERE_LIMIT)) {
                        ((LivingEntity)entity).getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue((((LivingEntity)entity).getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue() + 0.05));
                    }

                    x_pos = entity.getX();
                    y_pos = entity.getY() + (double)(entity.getBbHeight() * 0.0F);
                    z_pos = entity.getZ();
                    entity.getPersistentData().putDouble("Damage", 22.0 * 4.0);
                    entity.getPersistentData().putDouble("Range", (double)entity.getBbHeight() * 1.2 * 2);
                    entity.getPersistentData().putDouble("knockback", 0.5);
                    entity.getPersistentData().putDouble("projectile_type", 1.0);
                    entity.getPersistentData().putBoolean("ignore", true);
                    RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    entity.getPersistentData().putDouble("BlockRange", (double)entity.getBbHeight() * 4.0);
                    entity.getPersistentData().putDouble("BlockDamage", 99999.0);
                    entity.getPersistentData().putBoolean("noParticle", true);
                    entity.getPersistentData().putBoolean("noEffect", true);
                    entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                    BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                    if (entity.getPersistentData().getDouble("move") == 0.0) {
                        if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
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
                                if (entity.getPersistentData().getDouble("cnt_x") == 0.0) {
                                    if (entity_a.getPersistentData().getDouble("skill") != 0.0 && entity_a.getPersistentData().getBoolean("attack")) {
                                        entity.getPersistentData().putDouble("cnt_x", 1.0);
                                    }
                                } else if (entity.getPersistentData().getDouble("cnt_x") == 1.0) {
                                    if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                                        entity.getPersistentData().putDouble("cnt_x", 2.0);
                                    }
                                } else {
                                    entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                                    if (entity.getPersistentData().getDouble("cnt_x") > 10.0) {
                                        ResetCounterProcedure.execute(entity);
                                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                                        entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
                                        entity.getPersistentData().putDouble("move", entity.getPersistentData().getDouble("cnt_x2"));
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:1b}");
                                        }
                                    }
                                }

                                logic_a = true;
                                yaw = (double)entity_a.getYRot();
                                pitch = (double)entity_a.getXRot();
                                x_power = entity.getX();
                                y_power = entity.getY();
                                z_power = entity.getZ();
                                x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + 90.0 + 180.0)) * 8.0;
                                y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + 2.0;
                                z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + 180.0)) * 8.0;
                                if (Math.abs(x_target - x_power) > 0.5) {
                                    x_target = x_power + (x_power > x_target ? -0.5 : 0.5);
                                }

                                if (Math.abs(y_target - y_power) > 0.5) {
                                    y_target = y_power + (y_power > y_target ? -0.5 : 0.5);
                                }

                                if (Math.abs(z_target - z_power) > 0.5) {
                                    z_target = z_power + (z_power > z_target ? -0.5 : 0.5);
                                }

                                _ent = entity;
                                _ent.teleportTo(x_target, y_target, z_target);
                                if (_ent instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                                    _serverPlayer.connection.teleport(x_target, y_target, z_target, _ent.getYRot(), _ent.getXRot());
                                }

                                entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                                _ent = entity;
                                _ent.setYRot(entity_a.getYRot());
                                _ent.setXRot(entity_a.getXRot());
                                _ent.setYBodyRot(_ent.getYRot());
                                _ent.setYHeadRot(_ent.getYRot());
                                _ent.yRotO = _ent.getYRot();
                                _ent.xRotO = _ent.getXRot();
                                if (_ent instanceof LivingEntity) {
                                    _entity = (LivingEntity)_ent;
                                    _entity.yBodyRotO = _entity.getYRot();
                                    _entity.yHeadRotO = _entity.getYRot();
                                }
                            }
                        }

                        if (!logic_a) {
                            _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @s");
                            }
                        }
                    } else {
                        AITrueSphere1Procedure.execute(world, x, y, z, entity);
                    }
                }
            } else {
                world.levelEvent(2001, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 0.0F), z), Block.getId(((Block) JujutsucraftModBlocks.JUJUTSU_BARRIER.get()).defaultBlockState()));
                if (world instanceof Level) {
                    Level _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y + (double)(entity.getBbHeight() * 0.0F), z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                    } else {
                        _level.playLocalSound(x, y + (double)(entity.getBbHeight() * 0.0F), z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                    }
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x, y + (double)(entity.getBbHeight() * 0.0F), z, (int)(ReturnEntitySizeProcedure.execute(entity) * 18.0), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.25);
                }

                if (!entity.level().isClientSide()) {
                    entity.discard();
                }
            }

        }
    }
}

