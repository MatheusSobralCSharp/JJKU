package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class SukunaTakesOverBodyProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.isAlive() && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 10) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21) {
				if (!(entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
						&& _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) {
					if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()
							&& !(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
									&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone())) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
							if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.005) {
								if (!(new Object() {
									public double getValue() {
										CompoundTag dataIndex9 = new CompoundTag();
										entity.saveWithoutId(dataIndex9);
										return dataIndex9.getCompound("ForgeData").getDouble("SukunaDog");
									}
								}.getValue() == 2)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run gamemode spectator @s");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run summon jujutsucraftaddon:sukuna_no_shirt ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
												(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
									CompoundTag dataIndex13 = new CompoundTag();
									entity.saveWithoutId(dataIndex13);
									dataIndex13.getCompound("ForgeData").putDouble("SukunaDog", 2);
									entity.load(dataIndex13);
								}
							}
						}
					} else if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()
							&& !(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
									&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_16"))).isDone())) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
								if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
										&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
									if (!(new Object() {
										public double getValue() {
											CompoundTag dataIndex20 = new CompoundTag();
											entity.saveWithoutId(dataIndex20);
											return dataIndex20.getCompound("ForgeData").getDouble("SukunaDog");
										}
									}.getValue() == 2)) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run gamemode spectator @s");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run summon jujutsucraft:sukuna ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
											}
										}
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 254, false, false));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
										CompoundTag dataIndex25 = new CompoundTag();
										entity.saveWithoutId(dataIndex25);
										dataIndex25.getCompound("ForgeData").putDouble("SukunaDog", 2);
										entity.load(dataIndex25);
									}
								} else {
									if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
										if (!(new Object() {
											public double getValue() {
												CompoundTag dataIndex27 = new CompoundTag();
												entity.saveWithoutId(dataIndex27);
												return dataIndex27.getCompound("ForgeData").getDouble("SukunaDog");
											}
										}.getValue() == 2)) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"execute as @s run gamemode spectator @s");
												}
											}
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"execute as @s run summon jujutsucraft:sukuna ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
														(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
											CompoundTag dataIndex31 = new CompoundTag();
											entity.saveWithoutId(dataIndex31);
											dataIndex31.getCompound("ForgeData").putDouble("SukunaDog", 2);
											entity.load(dataIndex31);
										}
									}
								}
							} else {
								if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
									if (!(new Object() {
										public double getValue() {
											CompoundTag dataIndex33 = new CompoundTag();
											entity.saveWithoutId(dataIndex33);
											return dataIndex33.getCompound("ForgeData").getDouble("SukunaDog");
										}
									}.getValue() == 2)) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run gamemode spectator @s");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run summon jujutsucraft:sukuna ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
											}
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
										CompoundTag dataIndex37 = new CompoundTag();
										entity.saveWithoutId(dataIndex37);
										dataIndex37.getCompound("ForgeData").putDouble("SukunaDog", 2);
										entity.load(dataIndex37);
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
				if (!(entity instanceof ServerPlayer _plr39 && _plr39.level() instanceof ServerLevel
						&& _plr39.getAdvancements().getOrStartProgress(_plr39.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())) {
					if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()
							&& !(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
									&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone())) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
							if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.005) {
								if (!(new Object() {
									public double getValue() {
										CompoundTag dataIndex45 = new CompoundTag();
										entity.saveWithoutId(dataIndex45);
										return dataIndex45.getCompound("ForgeData").getDouble("SukunaDog");
									}
								}.getValue() == 2)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run gamemode spectator @s");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run summon jujutsucraftaddon:sukuna_fushiguro ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
												(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
									CompoundTag dataIndex49 = new CompoundTag();
									entity.saveWithoutId(dataIndex49);
									dataIndex49.getCompound("ForgeData").putDouble("SukunaDog", 2);
									entity.load(dataIndex49);
								}
							}
						}
					} else if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()
							&& !(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
									&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_20"))).isDone())) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
								if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
										&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_16"))).isDone()) {
									if (!(new Object() {
										public double getValue() {
											CompoundTag dataIndex56 = new CompoundTag();
											entity.saveWithoutId(dataIndex56);
											return dataIndex56.getCompound("ForgeData").getDouble("SukunaDog");
										}
									}.getValue() == 2)) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run gamemode spectator @s");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands()
														.performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																"execute as @s run summon jujutsucraftaddon:sukuna_manga ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
											}
										}
										if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 254, false, false));
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
										CompoundTag dataIndex61 = new CompoundTag();
										entity.saveWithoutId(dataIndex61);
										dataIndex61.getCompound("ForgeData").putDouble("SukunaDog", 2);
										entity.load(dataIndex61);
									}
								} else {
									if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
										if (!(new Object() {
											public double getValue() {
												CompoundTag dataIndex63 = new CompoundTag();
												entity.saveWithoutId(dataIndex63);
												return dataIndex63.getCompound("ForgeData").getDouble("SukunaDog");
											}
										}.getValue() == 2)) {
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
															_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
															"execute as @s run gamemode spectator @s");
												}
											}
											{
												Entity _ent = entity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands()
															.performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																			_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																	"execute as @s run summon jujutsucraftaddon:sukuna_manga ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
												}
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
														(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
											CompoundTag dataIndex67 = new CompoundTag();
											entity.saveWithoutId(dataIndex67);
											dataIndex67.getCompound("ForgeData").putDouble("SukunaDog", 2);
											entity.load(dataIndex67);
										}
									}
								}
							} else {
								if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
									if (!(new Object() {
										public double getValue() {
											CompoundTag dataIndex69 = new CompoundTag();
											entity.saveWithoutId(dataIndex69);
											return dataIndex69.getCompound("ForgeData").getDouble("SukunaDog");
										}
									}.getValue() == 2)) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run gamemode spectator @s");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands()
														.performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																"execute as @s run summon jujutsucraftaddon:sukuna_manga ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
											}
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
										CompoundTag dataIndex73 = new CompoundTag();
										entity.saveWithoutId(dataIndex73);
										dataIndex73.getCompound("ForgeData").putDouble("SukunaDog", 2);
										entity.load(dataIndex73);
									}
								}
							}
						}
					} else if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_20"))).isDone()) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
							if (entity instanceof ServerPlayer _plr76 && _plr76.level() instanceof ServerLevel
									&& _plr76.getAdvancements().getOrStartProgress(_plr76.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone()) {
								if (!(new Object() {
									public double getValue() {
										CompoundTag dataIndex77 = new CompoundTag();
										entity.saveWithoutId(dataIndex77);
										return dataIndex77.getCompound("ForgeData").getDouble("SukunaDog");
									}
								}.getValue() == 2)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run gamemode spectator @s");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run summon jujutsucraft:sukuna_fushiguro ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
										}
									}
									if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
												(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 254, false, false));
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
												(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
									CompoundTag dataIndex82 = new CompoundTag();
									entity.saveWithoutId(dataIndex82);
									dataIndex82.getCompound("ForgeData").putDouble("SukunaDog", 2);
									entity.load(dataIndex82);
								}
							} else {
								if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
									if (!(new Object() {
										public double getValue() {
											CompoundTag dataIndex84 = new CompoundTag();
											entity.saveWithoutId(dataIndex84);
											return dataIndex84.getCompound("ForgeData").getDouble("SukunaDog");
										}
									}.getValue() == 2)) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run gamemode spectator @s");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands()
														.performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																		_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																"execute as @s run summon jujutsucraft:sukuna_fushiguro ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
											}
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
													(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
										CompoundTag dataIndex88 = new CompoundTag();
										entity.saveWithoutId(dataIndex88);
										dataIndex88.getCompound("ForgeData").putDouble("SukunaDog", 2);
										entity.load(dataIndex88);
									}
								}
							}
						} else {
							if (Math.random() < (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE)) * 0.01) {
								if (!(new Object() {
									public double getValue() {
										CompoundTag dataIndex90 = new CompoundTag();
										entity.saveWithoutId(dataIndex90);
										return dataIndex90.getCompound("ForgeData").getDouble("SukunaDog");
									}
								}.getValue() == 2)) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run gamemode spectator @s");
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run summon jujutsucraft:sukuna_fushiguro ~ ~ ~ {ForgeData:{sukunacompanion:1b}}");
										}
									}
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(),
												(int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).FingerCount * 200), 1, false, false));
									CompoundTag dataIndex94 = new CompoundTag();
									entity.saveWithoutId(dataIndex94);
									dataIndex94.getCompound("ForgeData").putDouble("SukunaDog", 2);
									entity.load(dataIndex94);
								}
							}
						}
					}
				}
			}
		}
	}
}
