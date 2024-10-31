package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class CloneEntityProcedureProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
            if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)
                                    ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.MOVEMENT_SPEED)) && (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt12
                    && _livEnt12.hasEffect(MobEffects.MOVEMENT_SPEED)) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED)
                                    ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier()
                                    : 0,
                            false, false));
            }
            if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.HEALTH_BOOST))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, -1,
                            (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0,
                            false, false));
            }
            if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) {
                entity.setShiftKeyDown(true);
            } else if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) && entity.isShiftKeyDown()) {
                entity.setShiftKeyDown(false);
            }
            if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
                if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("brokenBrain");
                        }
                    }.getValue() <= 1) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                            }
                        }.getValue() == 0) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 0) {
                                if (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("skill_domain");
                                    }
                                }.getValue() > 0) {
                                    {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        dataIndex.getCompound("ForgeData").putDouble("skill", (100 * new Object() {
                                            public double getValue() {
                                                CompoundTag dataIndex = new CompoundTag();
                                                entity.saveWithoutId(dataIndex);
                                                return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                            }
                                        }.getValue() + 20));
                                        entity.load(dataIndex);
                                    }
                                } else {
                                    if (Math.random() < (1) / ((float) 2000)) {
                                        {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            dataIndex.getCompound("ForgeData").putDouble("skill", (100 * new Object() {
                                                public double getValue() {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    entity.saveWithoutId(dataIndex);
                                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                                }
                                            }.getValue() + 20));
                                            entity.load(dataIndex);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (Math.random() <= 0.06) {
                    if (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                        }
                    }.getValue() == 0) {
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("skill", (100 * new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("Tagged");
                                }
                            }.getValue() + Mth.nextInt(RandomSource.create(), 1, 19)));
                            entity.load(dataIndex);
                        }
                    }
                }
            }
            if (new Object() {
                public double getValue() {
                    CompoundTag dataIndex = new CompoundTag();
                    entity.saveWithoutId(dataIndex);
                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                }
            }.getValue() > 0) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entity.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("cnt4");
                    }
                }.getValue() >= 1250) {
                    if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1),
                                    false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1), false,
                                    false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                            : 0) + 0),
                                    false, false));
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                            }
                        }.getValue() < 45) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() + 1));
                                entity.load(dataIndex);
                            }
                        }
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt3");
                            }
                        }.getValue() < 20) {
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("cnt3", (new Object() {
                                    public double getValue() {
                                        CompoundTag dataIndex = new CompoundTag();
                                        entity.saveWithoutId(dataIndex);
                                        return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                    }
                                }.getValue() + 1));
                                entity.load(dataIndex);
                            }
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("PRESS_Z", true);
                            entity.load(dataIndex);
                        }
                    } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("PRESS_Z", false);
                            entity.load(dataIndex);
                        }
                    }
                } else {
                    if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) == false) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1),
                                    false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1), false,
                                    false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 20,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
                                            : 0) + 0),
                                    false, false));
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putBoolean("PRESS_Z", true);
                            entity.load(dataIndex);
                        }
                    } else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        if (new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                            }
                        }.getValue() < 6) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                }
                            }.getValue() < 10) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                }
                            }.getValue() >= 1) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt5");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("cnt1");
                                }
                            }.getValue() > 10) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            entity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("cnt6");
                                        }
                                    }.getValue() + 1));
                                    entity.load(dataIndex);
                                }
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                entity.saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putBoolean("PRESS_Z", true);
                                entity.load(dataIndex);
                            }
                        } else {
                            if ((new Object() {
                                public boolean getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getBoolean("PRESS_Z");
                                }
                            }.getValue()) == true) {
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putBoolean("PRESS_Z", false);
                                    entity.load(dataIndex);
                                }
                            }
                        }
                    }
                }
            }
        } else {
            CloneTestProcedure.execute(world, entity);
        }
    }
}
