package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraftaddon.entity.UraumeEntity;
import net.mcreator.jujutsucraftaddon.entity.TanjerinaEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.SatushiEntity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.HusseinDongEntity;
import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.mcreator.jujutsucraftaddon.entity.GojoMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.GegeAkutamiEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class DomainsAIProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof YutaCullingGamesEntity) {
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex1 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex1);
						return dataIndex1.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 5 || new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 520 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex4 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex4);
							return dataIndex4.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex5 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex5);
						dataIndex5.getCompound("ForgeData").putDouble("skill", 520);
						sourceentity.load(dataIndex5);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex6 = new CompoundTag();
					entity.saveWithoutId(dataIndex6);
					return dataIndex6.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex8 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex8);
							return dataIndex8.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 5 || new Object() {
						public double getValue() {
							CompoundTag dataIndex9 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex9);
							return dataIndex9.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 520 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex10 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex10);
							return dataIndex10.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex11 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex11);
						dataIndex11.getCompound("ForgeData").putDouble("skill", 520);
						sourceentity.load(dataIndex11);
					}
				}
			}
		} else if (sourceentity instanceof SatushiEntity) {
			if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 255) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 255, false, false));
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex16 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex16);
					return dataIndex16.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() >= 1) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
			}
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex18 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex18);
						return dataIndex18.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex19 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex19);
							return dataIndex19.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex20 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex20);
							return dataIndex20.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 120 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex21 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex21);
							return dataIndex21.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex22 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex22);
						dataIndex22.getCompound("ForgeData").putDouble("skill", 120);
						sourceentity.load(dataIndex22);
					}
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex24 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex24);
						return dataIndex24.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex25 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex25);
							return dataIndex25.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex26 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex26);
							return dataIndex26.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 120 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex27 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex27);
							return dataIndex27.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex28 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex28);
						dataIndex28.getCompound("ForgeData").putDouble("skill", 120);
						sourceentity.load(dataIndex28);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex29 = new CompoundTag();
					entity.saveWithoutId(dataIndex29);
					return dataIndex29.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex30 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex30);
						return dataIndex30.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex31 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex31);
							return dataIndex31.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex32 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex32);
							return dataIndex32.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 120 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex33 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex33);
							return dataIndex33.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex34 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex34);
						dataIndex34.getCompound("ForgeData").putDouble("skill", 120);
						sourceentity.load(dataIndex34);
					}
				}
			}
		} else if (sourceentity instanceof UraumeEntity) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex36 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex36);
					return dataIndex36.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() >= 1) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
			}
			if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) < 255) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 255, false, false));
				}
			}
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex42 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex42);
							return dataIndex42.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 24 || new Object() {
						public double getValue() {
							CompoundTag dataIndex43 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex43);
							return dataIndex43.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2420 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex44 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex44);
							return dataIndex44.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex45 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex45);
						dataIndex45.getCompound("ForgeData").putDouble("skill", 2420);
						sourceentity.load(dataIndex45);
					}
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex47 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex47);
						return dataIndex47.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex48 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex48);
							return dataIndex48.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 24 || new Object() {
						public double getValue() {
							CompoundTag dataIndex49 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex49);
							return dataIndex49.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2420 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex50 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex50);
							return dataIndex50.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex51 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex51);
						dataIndex51.getCompound("ForgeData").putDouble("skill", 2420);
						sourceentity.load(dataIndex51);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex52 = new CompoundTag();
					entity.saveWithoutId(dataIndex52);
					return dataIndex52.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex53 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex53);
						return dataIndex53.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex54 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex54);
							return dataIndex54.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 24 || new Object() {
						public double getValue() {
							CompoundTag dataIndex55 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex55);
							return dataIndex55.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2420 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex56 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex56);
							return dataIndex56.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex57 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex57);
						dataIndex57.getCompound("ForgeData").putDouble("skill", 2420);
						sourceentity.load(dataIndex57);
					}
				}
			}
		} else if (sourceentity instanceof GegeAkutamiEntity) {
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex59 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex59);
						return dataIndex59.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex60 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex60);
							return dataIndex60.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex61 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex61);
							return dataIndex61.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 120 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex62 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex62);
							return dataIndex62.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex63 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex63);
						dataIndex63.getCompound("ForgeData").putDouble("skill", 120);
						sourceentity.load(dataIndex63);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex64 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex64);
								return dataIndex64.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 120) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex66 = new CompoundTag();
					entity.saveWithoutId(dataIndex66);
					return dataIndex66.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex67 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex67);
						return dataIndex67.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex68 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex68);
							return dataIndex68.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 1 || new Object() {
						public double getValue() {
							CompoundTag dataIndex69 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex69);
							return dataIndex69.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 120 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex70 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex70);
							return dataIndex70.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex71 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex71);
						dataIndex71.getCompound("ForgeData").putDouble("skill", 120);
						sourceentity.load(dataIndex71);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex72 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex72);
								return dataIndex72.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 120) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			}
		} else if (sourceentity instanceof HakariEntity) {
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex75 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex75);
						return dataIndex75.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex76 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex76);
							return dataIndex76.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 29 || new Object() {
						public double getValue() {
							CompoundTag dataIndex77 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex77);
							return dataIndex77.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2920 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex78 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex78);
							return dataIndex78.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex79 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex79);
						dataIndex79.getCompound("ForgeData").putDouble("skill", 2920);
						sourceentity.load(dataIndex79);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex80 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex80);
								return dataIndex80.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 2920) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex83 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex83);
						return dataIndex83.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex84 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex84);
							return dataIndex84.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 29 || new Object() {
						public double getValue() {
							CompoundTag dataIndex85 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex85);
							return dataIndex85.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2920 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex86 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex86);
							return dataIndex86.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex87 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex87);
						dataIndex87.getCompound("ForgeData").putDouble("skill", 2920);
						sourceentity.load(dataIndex87);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex88 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex88);
								return dataIndex88.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 2920) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex90 = new CompoundTag();
					entity.saveWithoutId(dataIndex90);
					return dataIndex90.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex91 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex91);
						return dataIndex91.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex92 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex92);
							return dataIndex92.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 29 || new Object() {
						public double getValue() {
							CompoundTag dataIndex93 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex93);
							return dataIndex93.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2920 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex94 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex94);
							return dataIndex94.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex95 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex95);
						dataIndex95.getCompound("ForgeData").putDouble("skill", 2920);
						sourceentity.load(dataIndex95);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex96 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex96);
								return dataIndex96.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 2920) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			}
		} else if (sourceentity instanceof GojoMangaEntity) {
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex99 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex99);
						return dataIndex99.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex100 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex100);
							return dataIndex100.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 2 || new Object() {
						public double getValue() {
							CompoundTag dataIndex101 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex101);
							return dataIndex101.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 220 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex102 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex102);
							return dataIndex102.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex103 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex103);
						dataIndex103.getCompound("ForgeData").putDouble("skill", 220);
						sourceentity.load(dataIndex103);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex104 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex104);
								return dataIndex104.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 220) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex106 = new CompoundTag();
					entity.saveWithoutId(dataIndex106);
					return dataIndex106.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex107 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex107);
						return dataIndex107.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex108 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex108);
							return dataIndex108.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 29 || new Object() {
						public double getValue() {
							CompoundTag dataIndex109 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex109);
							return dataIndex109.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2920 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex110 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex110);
							return dataIndex110.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex111 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex111);
						dataIndex111.getCompound("ForgeData").putDouble("skill", 220);
						sourceentity.load(dataIndex111);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex112 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex112);
								return dataIndex112.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 220) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			}
		} else if (sourceentity instanceof HusseinDongEntity) {
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex115 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex115);
						return dataIndex115.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex116 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex116);
							return dataIndex116.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 2815)) {
						CompoundTag dataIndex117 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex117);
						dataIndex117.getCompound("ForgeData").putDouble("skill", 2815);
						sourceentity.load(dataIndex117);
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex118 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex118);
								return dataIndex118.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 2815) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
								}
							}
						}
					}
				}
			}
		} else if (sourceentity instanceof TanjerinaEntity) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex121 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex121);
					return dataIndex121.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() >= 1) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 40, 2, false, false));
			}
			if (Math.random() < 0.01) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex123 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex123);
						return dataIndex123.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 1) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex124 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex124);
							return dataIndex124.getCompound("ForgeData").getDouble("skill_domain");
						}
					}.getValue() == 2 || new Object() {
						public double getValue() {
							CompoundTag dataIndex125 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex125);
							return dataIndex125.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 220 || (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex126 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex126);
							return dataIndex126.getCompound("ForgeData").getBoolean("flag_domain");
						}
					}.getValue()) == true)) {
						CompoundTag dataIndex127 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex127);
						dataIndex127.getCompound("ForgeData").putDouble("skill", 220);
						sourceentity.load(dataIndex127);
					}
				}
			} else if (Math.random() > 0.01 && Math.random() < 0.05) {
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex128 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex128);
						return dataIndex128.getCompound("ForgeData").getBoolean("Igris");
					}
				}.getValue()) == false) {
					if (!world.getEntitiesOfClass(IgrisEntity.class, AABB.ofSize(new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), 100, 100, 100), e -> true).isEmpty() == false) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftaddonModEntities.IGRIS.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							CompoundTag dataIndex1 = new CompoundTag();
							(entitytospawn).saveWithoutId(dataIndex1);
							dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
							(entitytospawn).load(dataIndex1);
							CompoundTag dataIndex3 = new CompoundTag();
							(entitytospawn).saveWithoutId(dataIndex3);
							dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
								public double getValue() {
									CompoundTag dataIndex2 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex2);
									return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
								}
							}.getValue()));
							(entitytospawn).load(dataIndex3);
						}
						CompoundTag dataIndex136 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex136);
						dataIndex136.getCompound("ForgeData").putBoolean("Igris", true);
						sourceentity.load(dataIndex136);
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
							}
						}
					}
				}
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex138 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex138);
						return dataIndex138.getCompound("ForgeData").getBoolean("Beru");
					}
				}.getValue()) == false) {
					if (!world.getEntitiesOfClass(Shadow1Entity.class, AABB.ofSize(new Vec3((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), 100, 100, 100), e -> true).isEmpty() == false) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftaddonModEntities.SHADOW_1.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							}
							CompoundTag dataIndex1 = new CompoundTag();
							(entitytospawn).saveWithoutId(dataIndex1);
							dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
							(entitytospawn).load(dataIndex1);
							CompoundTag dataIndex3 = new CompoundTag();
							(entitytospawn).saveWithoutId(dataIndex3);
							dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
								public double getValue() {
									CompoundTag dataIndex2 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex2);
									return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
								}
							}.getValue()));
							(entitytospawn).load(dataIndex3);
						}
						CompoundTag dataIndex146 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex146);
						dataIndex146.getCompound("ForgeData").putBoolean("Beru", true);
						sourceentity.load(dataIndex146);
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
							}
						}
					}
				}
			}
		}
	}
}
