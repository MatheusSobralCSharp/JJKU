package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class UiUiAIProcedure {
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
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex20 = new CompoundTag();
					entity.saveWithoutId(dataIndex20);
					return dataIndex20.getCompound("ForgeData").getDouble("Follow");
				}
			}.getValue() == 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex21 = new CompoundTag();
						entity.saveWithoutId(dataIndex21);
						return dataIndex21.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex23 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex23);
						return dataIndex23.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue()) {
					CompoundTag dataIndex26 = new CompoundTag();
					entity.saveWithoutId(dataIndex26);
					dataIndex26.getCompound("ForgeData").putDouble("skill", (new Object() {
						public double getValue() {
							CompoundTag dataIndex25 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex25);
							return dataIndex25.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue()));
					entity.load(dataIndex26);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex27 = new CompoundTag();
						entity.saveWithoutId(dataIndex27);
						return dataIndex27.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getPersistentData().getBoolean("PRESS_Z")) {
						if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) == false) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
												+ 1),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
												? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
												: 0) + 0),
										false, false));
							entity.getPersistentData().putBoolean("PRESS_Z", true);
						} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
							if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getPersistentData().getBoolean("PRESS_Z") == false) {
								entity.getPersistentData().putBoolean("PRESS_Z", false);
							}
						}
					}
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex39 = new CompoundTag();
						entity.saveWithoutId(dataIndex39);
						return dataIndex39.getCompound("ForgeData").getDouble("cnt1");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("cnt1");
					}
				}.getValue()) {
					CompoundTag dataIndex44 = new CompoundTag();
					entity.saveWithoutId(dataIndex44);
					dataIndex44.getCompound("ForgeData").putDouble("cnt1", (new Object() {
						public double getValue() {
							CompoundTag dataIndex43 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex43);
							return dataIndex43.getCompound("ForgeData").getDouble("cnt1");
						}
					}.getValue()));
					entity.load(dataIndex44);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex45 = new CompoundTag();
						entity.saveWithoutId(dataIndex45);
						return dataIndex45.getCompound("ForgeData").getDouble("cnt2");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex47 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex47);
						return dataIndex47.getCompound("ForgeData").getDouble("cnt2");
					}
				}.getValue()) {
					CompoundTag dataIndex50 = new CompoundTag();
					entity.saveWithoutId(dataIndex50);
					dataIndex50.getCompound("ForgeData").putDouble("cnt2", (new Object() {
						public double getValue() {
							CompoundTag dataIndex49 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex49);
							return dataIndex49.getCompound("ForgeData").getDouble("cnt2");
						}
					}.getValue()));
					entity.load(dataIndex50);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex51 = new CompoundTag();
						entity.saveWithoutId(dataIndex51);
						return dataIndex51.getCompound("ForgeData").getDouble("cnt3");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex53 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex53);
						return dataIndex53.getCompound("ForgeData").getDouble("cnt3");
					}
				}.getValue()) {
					CompoundTag dataIndex56 = new CompoundTag();
					entity.saveWithoutId(dataIndex56);
					dataIndex56.getCompound("ForgeData").putDouble("cnt3", (new Object() {
						public double getValue() {
							CompoundTag dataIndex55 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex55);
							return dataIndex55.getCompound("ForgeData").getDouble("cnt3");
						}
					}.getValue()));
					entity.load(dataIndex56);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex57 = new CompoundTag();
						entity.saveWithoutId(dataIndex57);
						return dataIndex57.getCompound("ForgeData").getDouble("cnt4");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex59 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex59);
						return dataIndex59.getCompound("ForgeData").getDouble("cnt4");
					}
				}.getValue()) {
					CompoundTag dataIndex62 = new CompoundTag();
					entity.saveWithoutId(dataIndex62);
					dataIndex62.getCompound("ForgeData").putDouble("cnt4", (new Object() {
						public double getValue() {
							CompoundTag dataIndex61 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex61);
							return dataIndex61.getCompound("ForgeData").getDouble("cnt4");
						}
					}.getValue()));
					entity.load(dataIndex62);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex63 = new CompoundTag();
						entity.saveWithoutId(dataIndex63);
						return dataIndex63.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex65 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex65);
						return dataIndex65.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue()) {
					CompoundTag dataIndex68 = new CompoundTag();
					entity.saveWithoutId(dataIndex68);
					dataIndex68.getCompound("ForgeData").putDouble("cnt5", (new Object() {
						public double getValue() {
							CompoundTag dataIndex67 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex67);
							return dataIndex67.getCompound("ForgeData").getDouble("cnt5");
						}
					}.getValue()));
					entity.load(dataIndex68);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex69 = new CompoundTag();
						entity.saveWithoutId(dataIndex69);
						return dataIndex69.getCompound("ForgeData").getDouble("cnt6");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex71 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex71);
						return dataIndex71.getCompound("ForgeData").getDouble("cnt6");
					}
				}.getValue()) {
					CompoundTag dataIndex74 = new CompoundTag();
					entity.saveWithoutId(dataIndex74);
					dataIndex74.getCompound("ForgeData").putDouble("cnt6", (new Object() {
						public double getValue() {
							CompoundTag dataIndex73 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex73);
							return dataIndex73.getCompound("ForgeData").getDouble("cnt6");
						}
					}.getValue()));
					entity.load(dataIndex74);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex75 = new CompoundTag();
						entity.saveWithoutId(dataIndex75);
						return dataIndex75.getCompound("ForgeData").getDouble("cnt7");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex77 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex77);
						return dataIndex77.getCompound("ForgeData").getDouble("cnt7");
					}
				}.getValue()) {
					CompoundTag dataIndex80 = new CompoundTag();
					entity.saveWithoutId(dataIndex80);
					dataIndex80.getCompound("ForgeData").putDouble("cnt7", (new Object() {
						public double getValue() {
							CompoundTag dataIndex79 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex79);
							return dataIndex79.getCompound("ForgeData").getDouble("cnt7");
						}
					}.getValue()));
					entity.load(dataIndex80);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex81 = new CompoundTag();
						entity.saveWithoutId(dataIndex81);
						return dataIndex81.getCompound("ForgeData").getDouble("cnt8");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex83 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex83);
						return dataIndex83.getCompound("ForgeData").getDouble("cnt8");
					}
				}.getValue()) {
					CompoundTag dataIndex86 = new CompoundTag();
					entity.saveWithoutId(dataIndex86);
					dataIndex86.getCompound("ForgeData").putDouble("cnt8", (new Object() {
						public double getValue() {
							CompoundTag dataIndex85 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex85);
							return dataIndex85.getCompound("ForgeData").getDouble("cnt8");
						}
					}.getValue()));
					entity.load(dataIndex86);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex87 = new CompoundTag();
						entity.saveWithoutId(dataIndex87);
						return dataIndex87.getCompound("ForgeData").getDouble("cnt9");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex89 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex89);
						return dataIndex89.getCompound("ForgeData").getDouble("cnt9");
					}
				}.getValue()) {
					CompoundTag dataIndex92 = new CompoundTag();
					entity.saveWithoutId(dataIndex92);
					dataIndex92.getCompound("ForgeData").putDouble("cnt9", (new Object() {
						public double getValue() {
							CompoundTag dataIndex91 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex91);
							return dataIndex91.getCompound("ForgeData").getDouble("cnt9");
						}
					}.getValue()));
					entity.load(dataIndex92);
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex93 = new CompoundTag();
						entity.saveWithoutId(dataIndex93);
						return dataIndex93.getCompound("ForgeData").getDouble("cnt10");
					}
				}.getValue() != new Object() {
					public double getValue() {
						CompoundTag dataIndex95 = new CompoundTag();
						(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex95);
						return dataIndex95.getCompound("ForgeData").getDouble("cnt10");
					}
				}.getValue()) {
					CompoundTag dataIndex98 = new CompoundTag();
					entity.saveWithoutId(dataIndex98);
					dataIndex98.getCompound("ForgeData").putDouble("cnt10", (new Object() {
						public double getValue() {
							CompoundTag dataIndex97 = new CompoundTag();
							(entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).saveWithoutId(dataIndex97);
							return dataIndex97.getCompound("ForgeData").getDouble("cnt10");
						}
					}.getValue()));
					entity.load(dataIndex98);
				}
				if ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) {
					entity.setShiftKeyDown(true);
				} else if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).isShiftKeyDown()) && entity.isShiftKeyDown()) {
					entity.setShiftKeyDown(false);
				}
			} else {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex106 = new CompoundTag();
						entity.saveWithoutId(dataIndex106);
						return dataIndex106.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 0) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex107 = new CompoundTag();
							entity.saveWithoutId(dataIndex107);
							return dataIndex107.getCompound("ForgeData").getDouble("cnt4");
						}
					}.getValue() >= 1250) {
						if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
												+ 1),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
												? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
												: 0) + 0),
										false, false));
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex112 = new CompoundTag();
									entity.saveWithoutId(dataIndex112);
									return dataIndex112.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue() < 45) {
								CompoundTag dataIndex114 = new CompoundTag();
								entity.saveWithoutId(dataIndex114);
								dataIndex114.getCompound("ForgeData").putDouble("cnt1", (new Object() {
									public double getValue() {
										CompoundTag dataIndex113 = new CompoundTag();
										entity.saveWithoutId(dataIndex113);
										return dataIndex113.getCompound("ForgeData").getDouble("cnt1");
									}
								}.getValue() + 1));
								entity.load(dataIndex114);
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex115 = new CompoundTag();
									entity.saveWithoutId(dataIndex115);
									return dataIndex115.getCompound("ForgeData").getDouble("cnt3");
								}
							}.getValue() < 20) {
								CompoundTag dataIndex117 = new CompoundTag();
								entity.saveWithoutId(dataIndex117);
								dataIndex117.getCompound("ForgeData").putDouble("cnt3", (new Object() {
									public double getValue() {
										CompoundTag dataIndex116 = new CompoundTag();
										entity.saveWithoutId(dataIndex116);
										return dataIndex116.getCompound("ForgeData").getDouble("cnt1");
									}
								}.getValue() + 1));
								entity.load(dataIndex117);
							}
							entity.getPersistentData().putBoolean("PRESS_Z", true);
						} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
							entity.getPersistentData().putBoolean("PRESS_Z", false);
						}
					} else {
						if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) == false) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
												? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
												: 0) + 0),
										false, false));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
										(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0)
												+ 1),
										false, false));
							entity.getPersistentData().putBoolean("PRESS_Z", true);
						} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex127 = new CompoundTag();
									entity.saveWithoutId(dataIndex127);
									return dataIndex127.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() < 6) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex128 = new CompoundTag();
										entity.saveWithoutId(dataIndex128);
										return dataIndex128.getCompound("ForgeData").getDouble("cnt1");
									}
								}.getValue() < 10) {
									CompoundTag dataIndex130 = new CompoundTag();
									entity.saveWithoutId(dataIndex130);
									dataIndex130.getCompound("ForgeData").putDouble("cnt6", (new Object() {
										public double getValue() {
											CompoundTag dataIndex129 = new CompoundTag();
											entity.saveWithoutId(dataIndex129);
											return dataIndex129.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() + 1));
									entity.load(dataIndex130);
								}
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex131 = new CompoundTag();
										entity.saveWithoutId(dataIndex131);
										return dataIndex131.getCompound("ForgeData").getDouble("cnt5");
									}
								}.getValue() >= 1) {
									CompoundTag dataIndex133 = new CompoundTag();
									entity.saveWithoutId(dataIndex133);
									dataIndex133.getCompound("ForgeData").putDouble("cnt5", (new Object() {
										public double getValue() {
											CompoundTag dataIndex132 = new CompoundTag();
											entity.saveWithoutId(dataIndex132);
											return dataIndex132.getCompound("ForgeData").getDouble("cnt5");
										}
									}.getValue() + 1));
									entity.load(dataIndex133);
									CompoundTag dataIndex135 = new CompoundTag();
									entity.saveWithoutId(dataIndex135);
									dataIndex135.getCompound("ForgeData").putDouble("cnt6", (new Object() {
										public double getValue() {
											CompoundTag dataIndex134 = new CompoundTag();
											entity.saveWithoutId(dataIndex134);
											return dataIndex134.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() + 1));
									entity.load(dataIndex135);
								}
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex136 = new CompoundTag();
										entity.saveWithoutId(dataIndex136);
										return dataIndex136.getCompound("ForgeData").getDouble("cnt1");
									}
								}.getValue() > 10) {
									CompoundTag dataIndex138 = new CompoundTag();
									entity.saveWithoutId(dataIndex138);
									dataIndex138.getCompound("ForgeData").putDouble("cnt6", (new Object() {
										public double getValue() {
											CompoundTag dataIndex137 = new CompoundTag();
											entity.saveWithoutId(dataIndex137);
											return dataIndex137.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() + 1));
									entity.load(dataIndex138);
								}
								entity.getPersistentData().putBoolean("PRESS_Z", true);
							} else {
								if (entity.getPersistentData().getBoolean("PRESS_Z") == true) {
									entity.getPersistentData().putBoolean("PRESS_Z", false);
								}
							}
						}
					}
				}
			}
		} else {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex142 = new CompoundTag();
					entity.saveWithoutId(dataIndex142);
					return dataIndex142.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 0) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex143 = new CompoundTag();
						entity.saveWithoutId(dataIndex143);
						return dataIndex143.getCompound("ForgeData").getDouble("cnt4");
					}
				}.getValue() >= 1250) {
					if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1),
									false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1), false,
									false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
											? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
											: 0) + 0),
									false, false));
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex148 = new CompoundTag();
								entity.saveWithoutId(dataIndex148);
								return dataIndex148.getCompound("ForgeData").getDouble("cnt1");
							}
						}.getValue() < 45) {
							CompoundTag dataIndex150 = new CompoundTag();
							entity.saveWithoutId(dataIndex150);
							dataIndex150.getCompound("ForgeData").putDouble("cnt1", (new Object() {
								public double getValue() {
									CompoundTag dataIndex149 = new CompoundTag();
									entity.saveWithoutId(dataIndex149);
									return dataIndex149.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue() + 1));
							entity.load(dataIndex150);
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex151 = new CompoundTag();
								entity.saveWithoutId(dataIndex151);
								return dataIndex151.getCompound("ForgeData").getDouble("cnt3");
							}
						}.getValue() < 20) {
							CompoundTag dataIndex153 = new CompoundTag();
							entity.saveWithoutId(dataIndex153);
							dataIndex153.getCompound("ForgeData").putDouble("cnt3", (new Object() {
								public double getValue() {
									CompoundTag dataIndex152 = new CompoundTag();
									entity.saveWithoutId(dataIndex152);
									return dataIndex152.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue() + 1));
							entity.load(dataIndex153);
						}
						entity.getPersistentData().putBoolean("PRESS_Z", true);
					} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
						entity.getPersistentData().putBoolean("PRESS_Z", false);
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1), false,
									false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50,
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
											? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
											: 0) + 0),
									false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1),
									(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier() : 0) + 1),
									false, false));
						entity.getPersistentData().putBoolean("PRESS_Z", true);
					} else if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex163 = new CompoundTag();
								entity.saveWithoutId(dataIndex163);
								return dataIndex163.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() < 6) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex164 = new CompoundTag();
									entity.saveWithoutId(dataIndex164);
									return dataIndex164.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue() < 10) {
								CompoundTag dataIndex166 = new CompoundTag();
								entity.saveWithoutId(dataIndex166);
								dataIndex166.getCompound("ForgeData").putDouble("cnt6", (new Object() {
									public double getValue() {
										CompoundTag dataIndex165 = new CompoundTag();
										entity.saveWithoutId(dataIndex165);
										return dataIndex165.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() + 1));
								entity.load(dataIndex166);
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex167 = new CompoundTag();
									entity.saveWithoutId(dataIndex167);
									return dataIndex167.getCompound("ForgeData").getDouble("cnt5");
								}
							}.getValue() >= 1) {
								CompoundTag dataIndex169 = new CompoundTag();
								entity.saveWithoutId(dataIndex169);
								dataIndex169.getCompound("ForgeData").putDouble("cnt5", (new Object() {
									public double getValue() {
										CompoundTag dataIndex168 = new CompoundTag();
										entity.saveWithoutId(dataIndex168);
										return dataIndex168.getCompound("ForgeData").getDouble("cnt5");
									}
								}.getValue() + 1));
								entity.load(dataIndex169);
								CompoundTag dataIndex171 = new CompoundTag();
								entity.saveWithoutId(dataIndex171);
								dataIndex171.getCompound("ForgeData").putDouble("cnt6", (new Object() {
									public double getValue() {
										CompoundTag dataIndex170 = new CompoundTag();
										entity.saveWithoutId(dataIndex170);
										return dataIndex170.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() + 1));
								entity.load(dataIndex171);
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex172 = new CompoundTag();
									entity.saveWithoutId(dataIndex172);
									return dataIndex172.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue() > 10) {
								CompoundTag dataIndex174 = new CompoundTag();
								entity.saveWithoutId(dataIndex174);
								dataIndex174.getCompound("ForgeData").putDouble("cnt6", (new Object() {
									public double getValue() {
										CompoundTag dataIndex173 = new CompoundTag();
										entity.saveWithoutId(dataIndex173);
										return dataIndex173.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() + 1));
								entity.load(dataIndex174);
							}
							entity.getPersistentData().putBoolean("PRESS_Z", true);
						} else {
							if (entity.getPersistentData().getBoolean("PRESS_Z") == true) {
								entity.getPersistentData().putBoolean("PRESS_Z", false);
							}
						}
					}
				}
			}
		}
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType()).toString()).contains("crow")) {
				if (entity instanceof Mob) {
					try {
						((Mob) entity).setTarget(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
