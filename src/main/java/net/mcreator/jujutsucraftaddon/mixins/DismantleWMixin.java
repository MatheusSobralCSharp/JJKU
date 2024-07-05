package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.commands.arguments.EntityAnchorArgument;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = DismantleProcedure.class, remap = false)
public abstract class DismantleWMixin {
    public DismantleWMixin(){
    }
    /**
     * @author Sat
     * @reason Testing
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean logic_a;
            boolean worldCutter;
            boolean canUseWorld;
            double dis;
            double x_pos;
            double y_pos;
            double z_pos;
            double yaw;
            double picth;
            double yaw2;
            double pitch2;
            double CNT6;
            double range;
            label429: {
                double _setval;
                label428: {
                    logic_a = false;
                    worldCutter = false;
                    canUseWorld = false;
                    dis = 0.0;
                    x_pos = 0.0;
                    y_pos = 0.0;
                    z_pos = 0.0;
                    yaw = 0.0;
                    picth = 0.0;
                    yaw2 = 0.0;
                    pitch2 = 0.0;
                    CNT6 = 0.0;
                    range = 0.0;
                    double num1 = 0.0;
                    entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                    if (entity instanceof Player) {
                        if (entity instanceof ServerPlayer) {
                            ServerPlayer _plr3 = (ServerPlayer)entity;
                            if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_dismantle_cut_the_world"))).isDone()) {
                                break label428;
                            }
                        }
                    } else {
                        if (entity instanceof SukunaFushiguroEntity && entity instanceof SukunaFushiguroEntity) {
                            SukunaFushiguroEntity _datEntL5 = (SukunaFushiguroEntity)entity;
                            if ((Boolean)_datEntL5.getEntityData().get(SukunaFushiguroEntity.DATA_world_cut)) {
                                break label428;
                            }
                        }

                        if (entity instanceof SukunaPerfectEntity) {
                            break label428;
                        }
                    }

                    canUseWorld = false;
                    _setval = 0.0;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.p_x_power = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                    break label429;
                }

                canUseWorld = true;
                _setval = 1.0;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                    capability.p_x_power = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }

            LivingEntity var10000;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            LivingEntity var44;
            LivingEntity _entity;
            if (var10000 instanceof LivingEntity) {
                EntityAnchorArgument.Anchor var10001 = EntityAnchorArgument.Anchor.EYES;
                Vec3 var10002 = new Vec3(x, y, z);
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                double var57 = var10004.getX();
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                double var58 = var10005.getY();
                LivingEntity var10006;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var58 += (double)var10006.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var10002 = new Vec3(var57, var58, var10006.getZ());
                entity.lookAt(var10001, var10002);
                entity.getPersistentData().putBoolean("PRESS_Z", false);
                if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 6.0) {
                    label450: {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                            label435: {
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
                                        break label435;
                                    }
                                }

                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob) entity;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                if (var10000.getPersistentData().getDouble("Damage") != 0.0) {
                                    break label450;
                                }
                            }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                    }
                }

                if (canUseWorld) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    var44 = var10000;
                    if (var44 instanceof LivingEntity) {
                        _entity = (LivingEntity)var44;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()) && !entity.getPersistentData().getBoolean("flag_dismantle")) {
                            entity.getPersistentData().putBoolean("flag_dismantle", true);
                            entity.getPersistentData().putDouble("cnt6", 5.0);
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                label394: {
                    label393: {
                        if (entity instanceof Player) {
                            if (!entity.isShiftKeyDown()) {
                                break label393;
                            }
                        } else if (!(Math.random() < 0.5)) {
                            break label393;
                        }

                        entity.getPersistentData().putDouble("cnt7", 1.0);
                        break label394;
                    }

                    entity.getPersistentData().putDouble("cnt7", 2.0);
                }

                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10000 = _mobEnt.getTarget();
                } else {
                    var10000 = null;
                }

                if (var10000 instanceof LivingEntity && canUseWorld) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    var44 = var10000;
                    if (var44 instanceof LivingEntity) {
                        _entity = (LivingEntity)var44;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                            entity.getPersistentData().putDouble("cnt7", 2.0);
                        }
                    }
                }
            }

            LivingEntity _entGetArmor;
            double _setval;
            Level _level;
            if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity;
                    if (!_entGetArmor.level().isClientSide()) {
                        _entGetArmor.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity;
                    if (!_entGetArmor.level().isClientSide()) {
                        _entGetArmor.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                    }
                }

                entity.getPersistentData().putDouble("cnt6", -1.25);
                range = 0.5 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL)));
            } else {
                if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
                    yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                    picth = Math.toRadians((double)entity.getXRot());
                    x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
                    y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(picth) * -1.0 * (double)(1.0F + entity.getBbWidth());
                    z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
                    if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                        entity.getPersistentData().putDouble("cnt1", 0.0);
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            if (!_entGetArmor.level().isClientSide()) {
                                _entGetArmor.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            if (!_entGetArmor.level().isClientSide()) {
                                _entGetArmor.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                            }
                        }

                        ServerLevel _level1;
                        if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                            if (world instanceof ServerLevel) {
                                _level1 = (ServerLevel)world;
                                _level1.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)entity.getPersistentData().getDouble("cnt6"), 0.25, 0.25, 0.25, 0.5);
                            }
                        } else if (world instanceof ServerLevel) {
                            _level1 = (ServerLevel)world;
                            _level1.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)entity.getPersistentData().getDouble("cnt6"), 0.25, 0.25, 0.25, 0.5);
                        }

                        if (entity.getPersistentData().getDouble("cnt6") < 3.0) {
                            entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                            if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                                entity.getPersistentData().putDouble("cnt5", 0.0);
                                entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                                if (entity instanceof Player) {
                                    Player _player = (Player)entity;
                                    if (!_player.level().isClientSide()) {
                                        CompoundTag var56 = entity.getPersistentData();
                                        _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.jujutsucraft.dismantle" + Math.round(var56.getDouble("cnt6"))).getString() + "\""), false);
                                    }
                                }

                                if (entity instanceof Player) {
                                    _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 30.0;
                                    double final_setval = _setval;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                        capability.PlayerCursePowerChange = final_setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                            entity.getPersistentData().putDouble("cnt6", 5.0);
                            if (world instanceof Level) {
                                _level = (Level)world;
                                if (!_level.isClientSide()) {
                                    _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                }
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                ((ServerLevel) _level).sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.0);
                            }
                        }
                    }
                }

                range = 1.0 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL)));
            }

            if (entity.getPersistentData().getDouble("cnt1") == 0.0 && (canUseWorld || entity instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_x_power != 0.0)) {
                ItemStack var59;
                if (!(entity instanceof Player)) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var59 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var59 = ItemStack.EMPTY;
                    }

                    var59.getOrCreateTag().putDouble("P_ANIME1", (double)(entity.getPersistentData().getDouble("cnt6") >= 5.0 ? 207 : 120));
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var59 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var59 = ItemStack.EMPTY;
                    }

                    var59.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                }

                PlayAnimationProcedure.execute(entity);
                if (entity instanceof Player) {
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var59 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var59 = ItemStack.EMPTY;
                    }

                    var59.getOrCreateTag().putDouble("P_ANIME1", (double)(entity.getPersistentData().getDouble("cnt6") >= 5.0 ? 207 : 120));
                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        var59 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var59 = ItemStack.EMPTY;
                    }

                    var59.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                }
            }

            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity;
                    _entGetArmor.swing(InteractionHand.MAIN_HAND, true);
                }

                if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
                    entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt7"), 4.0));
                }
            } else if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && (canUseWorld || entity instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_x_power != 0.0)) {
                    worldCutter = true;
                }

                yaw = (double)entity.getYRot();
                picth = (double)entity.getXRot();
                if (world instanceof Level) {
                    _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F, false);
                    }
                }

                if (world instanceof Level) {
                    _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F, false);
                    }
                }

                if (world instanceof Level) {
                    _level = (Level)world;
                    if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F);
                    } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F, false);
                    }
                }

                entity.getPersistentData().putDouble("cnt2", Math.random() * 4.0 - 2.0);
                entity.getPersistentData().putDouble("cnt3", Math.abs(entity.getPersistentData().getDouble("cnt2")) - 2.0);
                yaw2 = yaw - entity.getPersistentData().getDouble("cnt2") * 15.0 * range;
                pitch2 = picth - entity.getPersistentData().getDouble("cnt3") * 15.0 * range;

                for(int index0 = 0; (long)index0 < Math.round(30.0 * range); ++index0) {
                    entity.setYRot((float)yaw2);
                    entity.setXRot((float)pitch2);
                    entity.setYBodyRot(entity.getYRot());
                    entity.setYHeadRot(entity.getYRot());
                    entity.yRotO = entity.getYRot();
                    entity.xRotO = entity.getXRot();
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                    }

                    yaw2 += entity.getPersistentData().getDouble("cnt2");
                    pitch2 += entity.getPersistentData().getDouble("cnt3");
                    dis = 0.0;

                    for(int index1 = 0; (long)index1 < Math.round(20.0 + Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0) * 2.0); ++index1) {
                        x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                        y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                        z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                        entity.getPersistentData().putDouble("Damage", 15.0);
                        if (Math.round(Math.floor(dis)) > 0L) {
                            for(int index2 = 0; index2 < (int)Math.round(Math.floor(dis)); ++index2) {
                                entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.985);
                                if (entity.getPersistentData().getDouble("Damage") < 9.0) {
                                    entity.getPersistentData().putDouble("Damage", 9.0);
                                    break;
                                }
                            }
                        }

                        entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.max(CNT6, 0.75));
                        entity.getPersistentData().putDouble("Range", 3.0 * CNT6 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                        entity.getPersistentData().putDouble("knockback", 0.25 * Math.min(CNT6, 1.0));
                        if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
                            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("knockback") * 0.5);
                        }

                        entity.getPersistentData().putDouble("projectile_type", 1.0);
                        entity.getPersistentData().putDouble("effect", 1.0);
                        if (worldCutter) {
                            entity.getPersistentData().putBoolean("ignore", true);
                            entity.getPersistentData().putDouble("effectConfirm", 3.0);
                        }

                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                            if (Math.random() > CNT6 * 0.5) {
                                if ((!worldCutter || entity.getPersistentData().getDouble("cnt6") >= 5.0) && world instanceof Level) {
                                    _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, Level.ExplosionInteraction.NONE);
                                    }
                                }

                                if (world instanceof Level) {
                                    _level = (Level)world;
                                    if (!_level.isClientSide()) {
                                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F);
                                    } else {
                                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F, false);
                                    }
                                }
                            }

                            if (world instanceof ServerLevel) {
                                ServerLevel _level2 = (ServerLevel)world;
                                _level2.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                            }

                            logic_a = true;
                        }

                        if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                            entity.getPersistentData().putDouble("BlockRange", 1.0 * CNT6 * ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                            entity.getPersistentData().putDouble("BlockDamage", 6.0 * CNT6 *  ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DESTRUCTION_LEVEL))));
                            if (worldCutter) {
                                entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                                entity.getPersistentData().putDouble("BlockDamage", 99999.0);
                            }

                            entity.getPersistentData().putBoolean("noEffect", true);
                            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        }

                        ++dis;
                        if (!worldCutter && logic_a) {
                            logic_a = false;
                            break;
                        }
                    }
                }

                entity.setYRot((float)yaw);
                entity.setXRot((float)picth);
                entity.setYBodyRot(entity.getYRot());
                entity.setYHeadRot(entity.getYRot());
                entity.yRotO = entity.getYRot();
                entity.xRotO = entity.getXRot();
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    _entity.yBodyRotO = _entity.getYRot();
                    _entity.yHeadRotO = _entity.getYRot();
                }

                if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
                    if (entity.getPersistentData().getBoolean("PRESS_Z") && entity.getPersistentData().getDouble("cnt8") < 20.0) {
                        entity.getPersistentData().putDouble("cnt1", 0.0);
                        entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
                        if (entity instanceof Player) {
                            _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 5.0;
                            double final_setval1 = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                capability.PlayerCursePowerChange = final_setval1;
                                capability.syncPlayerVariables(entity);
                            });
                            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange <= 0.0) {
                                entity.getPersistentData().putDouble("skill", 0.0);
                            }
                        }
                    } else {
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                entity.getPersistentData().putDouble("skill", 0.0);
            }

        }
    }
}