package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class SukunaMangaRCTProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) == true) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 150, 4, false, true));
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("rctcount");
			}
		}.getValue() >= 2000) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
						if (Math.random() < 0.001) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex9 = new CompoundTag();
									entity.saveWithoutId(dataIndex9);
									return dataIndex9.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 2) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 2 4 true");
									}
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
						if (Math.random() < 0.1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex12 = new CompoundTag();
									entity.saveWithoutId(dataIndex12);
									return dataIndex12.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 2) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 3 true");
									}
								}
							}
						}
					}
				}
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex14 = new CompoundTag();
				entity.saveWithoutId(dataIndex14);
				return dataIndex14.getCompound("ForgeData").getDouble("rctcount");
			}
		}.getValue() >= 1000) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex16 = new CompoundTag();
						entity.saveWithoutId(dataIndex16);
						return dataIndex16.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
						if (Math.random() < 0.001) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex19 = new CompoundTag();
									entity.saveWithoutId(dataIndex19);
									return dataIndex19.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 2) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 3 true");
									}
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
						if (Math.random() < 0.1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex22 = new CompoundTag();
									entity.saveWithoutId(dataIndex22);
									return dataIndex22.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 2) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 2 true");
									}
								}
							}
						}
					}
				}
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex24 = new CompoundTag();
				entity.saveWithoutId(dataIndex24);
				return dataIndex24.getCompound("ForgeData").getDouble("rctcount");
			}
		}.getValue() <= 1000) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex26 = new CompoundTag();
						entity.saveWithoutId(dataIndex26);
						return dataIndex26.getCompound("ForgeData").getDouble("brokenBrain");
					}
				}.getValue() <= 2) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 400 && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 150) {
						if (Math.random() < 0.001) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex29 = new CompoundTag();
									entity.saveWithoutId(dataIndex29);
									return dataIndex29.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 1) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 1 true");
									}
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 150) {
						if (Math.random() < 0.1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex32 = new CompoundTag();
									entity.saveWithoutId(dataIndex32);
									return dataIndex32.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 2) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:reverse_cursed_technique 1 2 true");
									}
								}
							}
						}
					}
				}
			}
		}
		if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
			CompoundTag dataIndex36 = new CompoundTag();
			entity.saveWithoutId(dataIndex36);
			dataIndex36.getCompound("ForgeData").putDouble("rctcount", (new Object() {
				public double getValue() {
					CompoundTag dataIndex35 = new CompoundTag();
					entity.saveWithoutId(dataIndex35);
					return dataIndex35.getCompound("ForgeData").getDouble("rctcount");
				}
			}.getValue() - 1));
			entity.load(dataIndex36);
		} else if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) == false) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex38 = new CompoundTag();
					entity.saveWithoutId(dataIndex38);
					return dataIndex38.getCompound("ForgeData").getDouble("rctcount");
				}
			}.getValue() == 0) {
				CompoundTag dataIndex39 = new CompoundTag();
				entity.saveWithoutId(dataIndex39);
				dataIndex39.getCompound("ForgeData").putDouble("rctcount", 4000);
				entity.load(dataIndex39);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex40 = new CompoundTag();
					entity.saveWithoutId(dataIndex40);
					return dataIndex40.getCompound("ForgeData").getDouble("rctcount");
				}
			}.getValue() > 0) {
				CompoundTag dataIndex42 = new CompoundTag();
				entity.saveWithoutId(dataIndex42);
				dataIndex42.getCompound("ForgeData").putDouble("rctcount", (new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						entity.saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("rctcount");
					}
				}.getValue() + 1));
				entity.load(dataIndex42);
			}
		}
	}
}
