package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerSetProfessionProcedure;
import net.mcreator.jujutsucraft.procedures.SummonCrowProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ConcorrentSpawnProcedure {
    public static void execute(Entity entity, LevelAccessor world, double x, double y, double z) {
        if (entity != null) {
            String STR1 = "";
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double NUM1 = 0.0;
            double sukuna_level = 0.0;
            double MAX_CURSE_POWER = 0.0;
            Entity _ent = entity;
            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "advancement revoke @s only jujutsucraft:update");
            }

            Advancement _adv;
            AdvancementProgress _ap;
            Iterator var25;
            String criteria;
            ServerPlayer _player;
            if (entity instanceof ServerPlayer) {
                _player = (ServerPlayer) entity;
                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
                _ap = _player.getAdvancements().getOrStartProgress(Objects.requireNonNull(_adv));
                if (!_ap.isDone()) {
                    var25 = _ap.getRemainingCriteria().iterator();

                    while (var25.hasNext()) {
                        criteria = (String) var25.next();
                        _player.getAdvancements().award(_adv, criteria);
                    }
                }
            }

            double _setval;
            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).friend_num_keep != 0.0) {
                entity.getPersistentData().putDouble("friend_num", entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).friend_num_keep);
                x_pos = 0.0;
                z_pos = 0.0;
                _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    Commands var10000 = _ent.getServer().getCommands();
                    CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent);
                    long var10002 = Math.round(x_pos);
                    var10000.performPrefixedCommand(var10001, "execute in jujutsucraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos));
                }

                if (world instanceof ServerLevel _origLevel) {
                    world = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("jujutsucraft:cursed_spirit_manipulation_dimension")));
                    if (world != null) {
                        Vec3 _center = new Vec3(x_pos, 128.0, z_pos);
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        Iterator var40 = _entfound.iterator();

                        label205:
                        while (true) {
                            Entity entityiterator;
                            do {
                                do {
                                    do {
                                        if (!var40.hasNext()) {
                                            break label205;
                                        }

                                        entityiterator = (Entity) var40.next();
                                    } while (entity == entityiterator);
                                } while (!entityiterator.isAlive());
                            } while (entity.getPersistentData().getDouble("friend_num") != entityiterator.getPersistentData().getDouble("friend_num_worker"));

                            NUM1 = 0.0;

                            for (int index0 = 0; index0 < 10000; ++index0) {
                                ++NUM1;
                                STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                                if (entity.getPersistentData().getDouble(STR1) == 0.0 || entity.getPersistentData().getDouble(STR1) == entityiterator.getY() || entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString())) {
                                    entity.getPersistentData().putDouble(STR1, entityiterator.getY());
                                    entity.getPersistentData().putString(STR1 + "_name", entityiterator.getDisplayName().getString());
                                    entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                                    break;
                                }
                            }

                            entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                            entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        }
                    }

                    world = world;
                }

                _setval = 0.0;
                double final_setval2 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.friend_num_keep = final_setval2;
                    capability.syncPlayerVariables(entity);
                });
            }

            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 11.0 || entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 == 11.0) && world.getEntitiesOfClass(CrowEntity.class, AABB.ofSize(new Vec3(x, y, z), 32.0, 32.0, 32.0), (e) -> {
                return true;
            }).isEmpty()) {
                SummonCrowProcedure.execute(world, x, y, z, entity);
            }

            boolean _setval2;
            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerFlag_A) {
                _setval2 = false;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerFlag_A = _setval2;
                    capability.syncPlayerVariables(entity);
                });
                Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue(0.0);
                Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR_TOUGHNESS)).setBaseValue(0.0);
                if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == -99.0) {
                    double _setval3 = 0.0;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                        capability.PlayerCurseTechnique = _setval3;
                        capability.syncPlayerVariables(entity);
                    });
                    double _setval4 = 5.0;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                        capability.PlayerCursePowerFormer = _setval4;
                        capability.syncPlayerVariables(entity);
                    });
                } else {
                    if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 0.0) {
                        double _setval5 = (double) Math.round(Math.random() * 37.0);
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = _setval5;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique <= 0.0) {
                        _setval = (double) Math.round(Math.random() * 4.0);
                        double final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCursePowerFormer = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        _setval = -1.0;
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerFormer == 0.0) {
                            if (entity instanceof ServerPlayer) {
                                _player = (ServerPlayer) entity;
                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:completely_physically_gifted"));
                                _ap = _player.getAdvancements().getOrStartProgress(Objects.requireNonNull(_adv));
                                if (!_ap.isDone()) {
                                    var25 = _ap.getRemainingCriteria().iterator();

                                    while (var25.hasNext()) {
                                        criteria = (String) var25.next();
                                        _player.getAdvancements().award(_adv, criteria);
                                    }
                                }
                            }

                            if (entity instanceof ServerPlayer) {
                                _player = (ServerPlayer) entity;
                                _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
                                _ap = _player.getAdvancements().getOrStartProgress(Objects.requireNonNull(_adv));
                                if (!_ap.isDone()) {
                                    var25 = _ap.getRemainingCriteria().iterator();

                                    while (var25.hasNext()) {
                                        criteria = (String) var25.next();
                                        _player.getAdvancements().award(_adv, criteria);
                                    }
                                }
                            }
                        }
                    } else {
                        _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique == 5.0 ? 400.0 : 200.0;
                        double final_setval3 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCursePowerFormer = final_setval3;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerProfession >= 0.0) {
                        boolean _setval4 = Math.random() < 0.01;
                        boolean final_setval4 = _setval4;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.FlagSixEyes = final_setval4;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }

                _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique;
                double final_setval5 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerCurseTechnique2 = final_setval5;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval6 = false;
                boolean final_setval6 = _setval6;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.flag_sukuna = final_setval6;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval3 = true;
                boolean final_setval7 = _setval3;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.noChangeTechnique = final_setval7;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval4 = true;
                boolean final_setval8 = _setval4;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.SecondTechnique = final_setval8;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerFormer * (double) Math.round((2.0 + entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerLevel) / 1.1);
            double final_setval9 = _setval;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                capability.PlayerCursePowerMAX = final_setval9;
                capability.syncPlayerVariables(entity);
            });
            LivingEntity _entity;
            if (entity instanceof LivingEntity) {
                _entity = (LivingEntity) entity;
                if (_entity.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    int var30;
                    label137:
                    {
                        if (entity instanceof LivingEntity _livEnt) {
                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                var30 = Objects.requireNonNull(_livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())).getAmplifier();
                                break label137;
                            }
                        }

                        var30 = 0;
                    }

                    sukuna_level = Math.min(var30 + 1, 20);
                    double _setval3 = Math.max(entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerMAX, sukuna_level <= 9.0 ? 3000.0 + (sukuna_level - 1.0) * 300.0 : 8000.0 + (sukuna_level - 10.0) * 1000.0);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                        capability.PlayerCursePowerMAX = _setval3;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

            if (!entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerFlag_B) {
                boolean _setval10 = true;
                boolean final_setval10 = _setval10;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerFlag_B = final_setval10;
                    capability.syncPlayerVariables(entity);
                });
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
                    }
                }

                Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue(0.0);
                Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR_TOUGHNESS)).setBaseValue(0.0);
                _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerMAX;
                double final_setval11 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerCursePower = final_setval11;
                    capability.syncPlayerVariables(entity);
                });
                _setval = 0.0;
                double final_setval12 = _setval;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerSelectCurseTechnique = final_setval12;
                    capability.syncPlayerVariables(entity);
                });
                entity.getPersistentData().putBoolean("infinity", false);
                entity.getPersistentData().putDouble("brokenBrain", 0.0);
                boolean _setval11 = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval11;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval12 = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.SecondTechnique = _setval12;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                PlayerSetProfessionProcedure.execute(entity);
                _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "advancement revoke @s only jujutsucraft:update");
                }

                if (entity instanceof ServerPlayer) {
                    _player = (ServerPlayer) entity;
                    _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
                    _ap = _player.getAdvancements().getOrStartProgress(Objects.requireNonNull(_adv));
                    if (!_ap.isDone()) {
                        var25 = _ap.getRemainingCriteria().iterator();

                        while (var25.hasNext()) {
                            criteria = (String) var25.next();
                            _player.getAdvancements().award(_adv, criteria);
                        }
                    }
                }
            }

        }
    }
}
