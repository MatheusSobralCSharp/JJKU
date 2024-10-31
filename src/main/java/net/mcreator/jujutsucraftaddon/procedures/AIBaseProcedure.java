package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class AIBaseProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (sourceentity instanceof ItadoriShinjukuEntity) {
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex1 = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex1);
                    return dataIndex1.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() >= 1) {
                if (!(sourceentity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()))) {
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1, 1, false, false));
                    if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 1, 1, false, false));
                    CompoundTag dataIndex5 = new CompoundTag();
                    sourceentity.saveWithoutId(dataIndex5);
                    dataIndex5.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                    sourceentity.load(dataIndex5);
                }
            }
            if (Math.random() >= 0.8) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex6 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex6);
                        return dataIndex6.getCompound("ForgeData").getDouble("skill");
                    }
                }.getValue() == 0) {
                    if (Math.random() >= 0.9) {
                        CompoundTag dataIndex7 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex7);
                        dataIndex7.getCompound("ForgeData").putDouble("skill", 1007);
                        sourceentity.load(dataIndex7);
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex8 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex8);
                                return dataIndex8.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex9 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex9);
                            dataIndex9.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                            sourceentity.load(dataIndex9);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex10 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex10);
                                return dataIndex10.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            CompoundTag dataIndex12 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex12);
                            dataIndex12.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                            sourceentity.load(dataIndex12);
                            CompoundTag dataIndex13 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex13);
                            dataIndex13.getCompound("ForgeData").putDouble("cnt5", 11);
                            sourceentity.load(dataIndex13);
                            CompoundTag dataIndex14 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex14);
                            dataIndex14.getCompound("ForgeData").putDouble("cnt6", 6);
                            sourceentity.load(dataIndex14);
                            CompoundTag dataIndex15 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex15);
                            dataIndex15.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                            sourceentity.load(dataIndex15);
                        }
                    } else if (Math.random() >= 0.7) {
                        CompoundTag dataIndex17 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex17);
                        dataIndex17.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                        sourceentity.load(dataIndex17);
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex18 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex18);
                                return dataIndex18.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex19 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex19);
                            dataIndex19.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                            sourceentity.load(dataIndex19);
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex20 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex20);
                                return dataIndex20.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 1) {
                            {
                                Entity _ent = sourceentity;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                                }
                            }
                            CompoundTag dataIndex22 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex22);
                            dataIndex22.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                            sourceentity.load(dataIndex22);
                        }
                    }
                }
            } else {
                if (Math.random() >= 0.6) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex23 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex23);
                            return dataIndex23.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        CompoundTag dataIndex25 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex25);
                        dataIndex25.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -98, -96)));
                        sourceentity.load(dataIndex25);
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex26 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex26);
                                return dataIndex26.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex27 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex27);
                            dataIndex27.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                            sourceentity.load(dataIndex27);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex28 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex28);
                            return dataIndex28.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                        CompoundTag dataIndex30 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex30);
                        dataIndex30.getCompound("ForgeData").putDouble("cnt5", 11);
                        sourceentity.load(dataIndex30);
                        CompoundTag dataIndex31 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex31);
                        dataIndex31.getCompound("ForgeData").putDouble("cnt6", 6);
                        sourceentity.load(dataIndex31);
                        CompoundTag dataIndex32 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex32);
                        dataIndex32.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                        sourceentity.load(dataIndex32);
                    }
                } else if (Math.random() >= 0.2) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex33 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex33);
                            return dataIndex33.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        CompoundTag dataIndex34 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex34);
                        dataIndex34.getCompound("ForgeData").putDouble("skill", (-98));
                        sourceentity.load(dataIndex34);
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex35 = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex35);
                                return dataIndex35.getCompound("ForgeData").getDouble("PRESS_Z");
                            }
                        }.getValue() == 0) {
                            CompoundTag dataIndex36 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex36);
                            dataIndex36.getCompound("ForgeData").putDouble("PRESS_Z", 1);
                            sourceentity.load(dataIndex36);
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex37 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex37);
                            return dataIndex37.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                    }
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex39 = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex39);
                            return dataIndex39.getCompound("ForgeData").getDouble("PRESS_Z");
                        }
                    }.getValue() == 1) {
                        {
                            Entity _ent = sourceentity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                        _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
                            }
                        }
                        CompoundTag dataIndex41 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex41);
                        dataIndex41.getCompound("ForgeData").putDouble("cnt5", 11);
                        sourceentity.load(dataIndex41);
                        CompoundTag dataIndex42 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex42);
                        dataIndex42.getCompound("ForgeData").putDouble("cnt6", 6);
                        sourceentity.load(dataIndex42);
                        CompoundTag dataIndex43 = new CompoundTag();
                        sourceentity.saveWithoutId(dataIndex43);
                        dataIndex43.getCompound("ForgeData").putDouble("PRESS_Z", 0);
                        sourceentity.load(dataIndex43);
                    }
                }
            }
        }
    }
}
