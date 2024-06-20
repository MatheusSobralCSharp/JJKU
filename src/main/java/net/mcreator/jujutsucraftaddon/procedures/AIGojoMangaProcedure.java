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

import net.mcreator.jujutsucraftaddon.entity.TanjerinaEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class AIGojoMangaProcedure {
	public static void execute(LevelAccessor world, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof TanjerinaEntity) {
			if (!(new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 220)) {
				if (Math.random() >= 0.8) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 0) {
						if (Math.random() >= 0.9) {
							if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
								if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 1, false, false));
							}
							CompoundTag dataIndex5 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex5);
							dataIndex5.getCompound("ForgeData").putDouble("skill", 705);
							sourceentity.load(dataIndex5);
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex6 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex6);
									return dataIndex6.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 0) {
								CompoundTag dataIndex7 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex7);
								dataIndex7.getCompound("ForgeData").putDouble("PRESS_Z", 1);
								sourceentity.load(dataIndex7);
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex8 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex8);
									return dataIndex8.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 1) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
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
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
								CompoundTag dataIndex12 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex12);
								dataIndex12.getCompound("ForgeData").putDouble("cnt5", 11);
								sourceentity.load(dataIndex12);
								CompoundTag dataIndex13 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex13);
								dataIndex13.getCompound("ForgeData").putDouble("cnt6", 6);
								sourceentity.load(dataIndex13);
								JujutsucraftaddonMod.queueServerWork(60, () -> {
									CompoundTag dataIndex14 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex14);
									dataIndex14.getCompound("ForgeData").putDouble("PRESS_Z", 0);
									sourceentity.load(dataIndex14);
								});
							}
						} else if (Math.random() >= 0.8) {
							CompoundTag dataIndex17 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex17);
							dataIndex17.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), 105, 107)));
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
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex22 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex22);
									return dataIndex22.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 1) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
								CompoundTag dataIndex24 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex24);
								dataIndex24.getCompound("ForgeData").putDouble("cnt5", 11);
								sourceentity.load(dataIndex24);
								CompoundTag dataIndex25 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex25);
								dataIndex25.getCompound("ForgeData").putDouble("cnt6", 6);
								sourceentity.load(dataIndex25);
								JujutsucraftaddonMod.queueServerWork(60, () -> {
									CompoundTag dataIndex26 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex26);
									dataIndex26.getCompound("ForgeData").putDouble("PRESS_Z", 0);
									sourceentity.load(dataIndex26);
								});
							}
						} else if (Math.random() >= 0.7) {
							CompoundTag dataIndex29 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex29);
							dataIndex29.getCompound("ForgeData").putDouble("skill", (Mth.nextInt(RandomSource.create(), -96, -97)));
							sourceentity.load(dataIndex29);
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex30 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex30);
									return dataIndex30.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 0) {
								CompoundTag dataIndex31 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex31);
								dataIndex31.getCompound("ForgeData").putDouble("PRESS_Z", 1);
								sourceentity.load(dataIndex31);
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex32 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex32);
									return dataIndex32.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 1) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex34 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex34);
									return dataIndex34.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 1) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
									}
								}
								JujutsucraftaddonMod.queueServerWork(60, () -> {
									CompoundTag dataIndex36 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex36);
									dataIndex36.getCompound("ForgeData").putDouble("PRESS_Z", 0);
									sourceentity.load(dataIndex36);
								});
							}
						}
					}
				} else {
					if (Math.random() >= 0.7) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex38 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex38);
								return dataIndex38.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 0) {
							CompoundTag dataIndex39 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex39);
							dataIndex39.getCompound("ForgeData").putDouble("skill", 503);
							sourceentity.load(dataIndex39);
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex40 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex40);
								return dataIndex40.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 0) {
							CompoundTag dataIndex41 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex41);
							dataIndex41.getCompound("ForgeData").putDouble("PRESS_Z", 1);
							sourceentity.load(dataIndex41);
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex42 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex42);
								return dataIndex42.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 1) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
								}
							}
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex44 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex44);
								return dataIndex44.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 1) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
								}
							}
							CompoundTag dataIndex46 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex46);
							dataIndex46.getCompound("ForgeData").putDouble("cnt5", 11);
							sourceentity.load(dataIndex46);
							CompoundTag dataIndex47 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex47);
							dataIndex47.getCompound("ForgeData").putDouble("cnt6", 6);
							sourceentity.load(dataIndex47);
							CompoundTag dataIndex48 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex48);
							dataIndex48.getCompound("ForgeData").putDouble("PRESS_Z", 0);
							sourceentity.load(dataIndex48);
						}
					} else if (Math.random() >= 0.2) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex49 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex49);
								return dataIndex49.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 0) {
							CompoundTag dataIndex50 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex50);
							dataIndex50.getCompound("ForgeData").putDouble("skill", 203);
							sourceentity.load(dataIndex50);
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex51 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex51);
									return dataIndex51.getCompound("ForgeData").getDouble("PRESS_Z");
								}
							}.getValue() == 0) {
								CompoundTag dataIndex52 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex52);
								dataIndex52.getCompound("ForgeData").putDouble("PRESS_Z", 1);
								sourceentity.load(dataIndex52);
							}
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex53 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex53);
								return dataIndex53.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 1) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
								}
							}
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex55 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex55);
								return dataIndex55.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 1) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 2 true");
								}
							}
							CompoundTag dataIndex57 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex57);
							dataIndex57.getCompound("ForgeData").putDouble("PRESS_Z", 0);
							sourceentity.load(dataIndex57);
						}
					}
				}
			}
		}
	}
}
