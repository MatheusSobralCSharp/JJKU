package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.GetSukunaLevelProcedure;
import net.mcreator.jujutsucraft.procedures.WhenRespawnProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.Iterator;

public class FingerEatedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		boolean success = false;
		boolean sukuna = false;
		double num1 = 0.0;
		double cursed_technique = 0.0;
		double num2 = 0.0;
		double level_control = 0.0;
		double tick = 0.0;
		double cursed_technique2 = 0.0;
		LivingEntity _livEnt33;
		LivingEntity _livEnt36;
		if (entity.getPersistentData().getBoolean("CursedSpirit")) {
			success = true;
		} else {
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_ONLY_ONE_SUKUNA)) {
				if (JujutsucraftaddonModVariables.MapVariables.get(world).Sukuna == 0) {
					if (!(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone())) {
						cursed_technique = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
						cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
						Player _plr;
						if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
							success = true;
							level_control = 2.0;
						} else if (cursed_technique != 21.0 && cursed_technique2 != 21.0) {
							label409:
							{
								label420:
								{
									if (entity instanceof Player) {
										_plr = (Player) entity;
										if (_plr.getAbilities().instabuild) {
											break label420;
										}
									}

									if (cursed_technique != 1.0 && cursed_technique2 != 1.0 && cursed_technique != 6.0 && cursed_technique2 != 6.0) {
										label434:
										{
											if (entity instanceof LivingEntity) {
												_livEnt33 = (LivingEntity) entity;
												if (_livEnt33.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
													break label434;
												}
											}

											success = false;
											level_control = 0.0;
											break label409;
										}
									}
								}

								success = true;
								level_control = 0.0;
							}
						} else {
							success = true;
							level_control = 1.0;
						}

						if (!success) {
							label388:
							{
								if (entity instanceof Player) {
									_plr = (Player) entity;
									if (_plr.getAbilities().instabuild) {
										break label388;
									}
								}

								if (entity instanceof Player) {
									Player _player = (Player) entity;
									ItemStack _setstack = (new ItemStack((ItemLike) JujutsucraftModItems.SUKUNA_FINGER.get())).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}

							if (entity instanceof LivingEntity) {
								_livEnt36 = (LivingEntity) entity;
								_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get());
							}

							if (entity instanceof LivingEntity) {
								_livEnt36 = (LivingEntity) entity;
								_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get());
							}

							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
							}
						}
					}

					if (entity.isAlive()) {
						num1 = 0.0;
						success = false;
						ServerPlayer _plr27;
						ServerPlayer _plr28;
						ServerPlayer _player;
						ServerPlayer _plr25;
						ServerPlayer _plr26;
						if (!success) {
							label435:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_2"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_3"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_4"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()) {
																		success = false;
																		break label435;
																	}
																}

																num1 = 5.0;
																break label435;
															}
														}

														num1 = 4.0;
														break label435;
													}
												}

												num1 = 3.0;
												break label435;
											}
										}

										num1 = 2.0;
										break label435;
									}
								}

								num1 = 1.0;
							}
						}

						if (!success) {
							label436:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_6"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_7"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_8"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_9"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_10"))).isDone()) {
																		success = false;
																		break label436;
																	}
																}

																num1 = 10.0;
																break label436;
															}
														}

														num1 = 9.0;
														break label436;
													}
												}

												num1 = 8.0;
												break label436;
											}
										}

										num1 = 7.0;
										break label436;
									}
								}

								num1 = 6.0;
							}
						}

						if (!success) {
							label437:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_11"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_12"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_13"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_14"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
																		success = false;
																		break label437;
																	}
																}

																num1 = 15.0;
																break label437;
															}
														}

														num1 = 14.0;
														break label437;
													}
												}

												num1 = 13.0;
												break label437;
											}
										}

										num1 = 12.0;
										break label437;
									}
								}

								num1 = 11.0;
							}
						}

						if (!success) {
							label438:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_16"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_17"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_18"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_19"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_20"))).isDone()) {
																		success = false;
																		break label438;
																	}
																}

																num1 = 20.0;
																break label438;
															}
														}

														num1 = 19.0;
														break label438;
													}
												}

												num1 = 18.0;
												break label438;
											}
										}

										num1 = 17.0;
										break label438;
									}
								}

								num1 = 16.0;
							}
						}

						Advancement _adv;
						AdvancementProgress _ap;
						Iterator var37;
						String criteria;
						if (num1 > 0.0) {
							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until jujutsucraft:sukuna_finger_" + Math.round(num1));
							}

							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement revoke @s only jujutsucraft:update");
							}

							if (entity instanceof ServerPlayer) {
								_player = (ServerPlayer) entity;
								_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
								_ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									var37 = _ap.getRemainingCriteria().iterator();

									while (var37.hasNext()) {
										criteria = (String) var37.next();
										_player.getAdvancements().award(_adv, criteria);
									}
								}
							}

							if (entity.getPersistentData().getBoolean("CursedSpirit")) {
								double _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 1000.0;
								entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
									capability.PlayerCursePowerChange = _setval;
									capability.syncPlayerVariables(entity);
								});
							} else {
								label440:
								{
									int var10000;
									label271:
									{
										if (entity instanceof LivingEntity) {
											_livEnt33 = (LivingEntity) entity;
											if (_livEnt33.hasEffect(MobEffects.UNLUCK)) {
												label266:
												{
													if (entity instanceof LivingEntity) {
														_livEnt36 = (LivingEntity) entity;
														if (_livEnt36.hasEffect(MobEffects.UNLUCK)) {
															var10000 = _livEnt36.getEffect(MobEffects.UNLUCK).getAmplifier();
															break label266;
														}
													}

													var10000 = 0;
												}

												++var10000;
												break label271;
											}
										}

										var10000 = 0;
									}

									num2 = (double) var10000;
									num2 = Math.min(num2, 9.0);
									if (!entity.level().isClientSide() && entity.getServer() != null) {
										entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:unluck 180 " + Math.round(num2) + " true");
									}

									if (level_control == 2.0) {
										sukuna = false;
										tick = 300.0;
									} else if (level_control == 1.0) {
										if (num2 >= 9.0 || num1 == 1.0) {
											sukuna = true;
											tick = 300.0;
										}
									} else if (level_control == 0.0) {
										sukuna = true;
										tick = 1000000.0;
									} else {
										sukuna = false;
										tick = 300.0;
									}

									if (!sukuna) {
										if (!(entity instanceof LivingEntity)) {
											break label440;
										}

										_livEnt36 = (LivingEntity) entity;
										if (!_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
											break label440;
										}
									}

									if (!entity.level().isClientSide() && entity.getServer() != null) {
										Commands var41 = entity.getServer().getCommands();
										CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
										Object var10002;
										if (tick > 10000.0) {
											var10002 = "infinite";
										} else {
											int var10003;
											label248:
											{
												if (entity instanceof LivingEntity) {
													LivingEntity _livEnt = (LivingEntity) entity;
													if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
														var10003 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
														break label248;
													}
												}

												var10003 = 0;
											}

											var10002 = Math.round(Math.max(tick, (double) Math.round(Math.floor((double) (var10003 / 20)))));
										}

										var41.performPrefixedCommand(var10001, "effect give @s jujutsucraft:sukuna_effect " + var10002 + " " + Math.round(Math.min(Math.max(GetSukunaLevelProcedure.execute(entity), 1.0), 20.0) - 1.0) + " true");
									}
								}
							}
						}

						if (!entity.getPersistentData().getBoolean("CursedSpirit")) {
							if (entity instanceof ServerPlayer) {
								_player = (ServerPlayer) entity;
								_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
								_ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									var37 = _ap.getRemainingCriteria().iterator();

									while (var37.hasNext()) {
										criteria = (String) var37.next();
										_player.getAdvancements().award(_adv, criteria);
									}
								}
							}

							if (level_control == 0.0) {
								boolean _setval = true;
								entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
									capability.flag_sukuna = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}

						WhenRespawnProcedure.execute(world, x, y, z, entity);
						JujutsucraftaddonModVariables.MapVariables.get(world).Sukuna = 1;
						JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);

					}
				} else {
					if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
						cursed_technique = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
						cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
						Player _plr;
						if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
							success = true;
							level_control = 2.0;
						} else if (cursed_technique != 21.0 && cursed_technique2 != 21.0) {
							label409:
							{
								label420:
								{
									if (entity instanceof Player) {
										_plr = (Player) entity;
										if (_plr.getAbilities().instabuild) {
											break label420;
										}
									}

									if (cursed_technique != 1.0 && cursed_technique2 != 1.0 && cursed_technique != 6.0 && cursed_technique2 != 6.0) {
										label434:
										{
											if (entity instanceof LivingEntity) {
												_livEnt33 = (LivingEntity) entity;
												if (_livEnt33.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
													break label434;
												}
											}

											success = false;
											level_control = 0.0;
											break label409;
										}
									}
								}

								success = true;
								level_control = 0.0;
							}
						} else {
							success = true;
							level_control = 1.0;
						}

						if (!success) {
							label388:
							{
								if (entity instanceof Player) {
									_plr = (Player) entity;
									if (_plr.getAbilities().instabuild) {
										break label388;
									}
								}

								if (entity instanceof Player) {
									Player _player = (Player) entity;
									ItemStack _setstack = (new ItemStack((ItemLike) JujutsucraftModItems.SUKUNA_FINGER.get())).copy();
									_setstack.setCount(1);
									ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
								}
							}

							if (entity instanceof LivingEntity) {
								_livEnt36 = (LivingEntity) entity;
								_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get());
							}

							if (entity instanceof LivingEntity) {
								_livEnt36 = (LivingEntity) entity;
								_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get());
							}

							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
							}
						}
					}

					if (entity.isAlive()) {
						num1 = 0.0;
						success = false;
						ServerPlayer _plr27;
						ServerPlayer _plr28;
						ServerPlayer _player;
						ServerPlayer _plr25;
						ServerPlayer _plr26;
						if (!success) {
							label435:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_2"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_3"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_4"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()) {
																		success = false;
																		break label435;
																	}
																}

																num1 = 5.0;
																break label435;
															}
														}

														num1 = 4.0;
														break label435;
													}
												}

												num1 = 3.0;
												break label435;
											}
										}

										num1 = 2.0;
										break label435;
									}
								}

								num1 = 1.0;
							}
						}

						if (!success) {
							label436:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_6"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_7"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_8"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_9"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_10"))).isDone()) {
																		success = false;
																		break label436;
																	}
																}

																num1 = 10.0;
																break label436;
															}
														}

														num1 = 9.0;
														break label436;
													}
												}

												num1 = 8.0;
												break label436;
											}
										}

										num1 = 7.0;
										break label436;
									}
								}

								num1 = 6.0;
							}
						}

						if (!success) {
							label437:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_11"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_12"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_13"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_14"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
																		success = false;
																		break label437;
																	}
																}

																num1 = 15.0;
																break label437;
															}
														}

														num1 = 14.0;
														break label437;
													}
												}

												num1 = 13.0;
												break label437;
											}
										}

										num1 = 12.0;
										break label437;
									}
								}

								num1 = 11.0;
							}
						}

						if (!success) {
							label438:
							{
								success = true;
								if (entity instanceof ServerPlayer) {
									_player = (ServerPlayer) entity;
									if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_16"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr25 = (ServerPlayer) entity;
											if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_17"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr26 = (ServerPlayer) entity;
													if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_18"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr27 = (ServerPlayer) entity;
															if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_19"))).isDone()) {
																if (entity instanceof ServerPlayer) {
																	_plr28 = (ServerPlayer) entity;
																	if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_20"))).isDone()) {
																		success = false;
																		break label438;
																	}
																}

																num1 = 20.0;
																break label438;
															}
														}

														num1 = 19.0;
														break label438;
													}
												}

												num1 = 18.0;
												break label438;
											}
										}

										num1 = 17.0;
										break label438;
									}
								}

								num1 = 16.0;
							}
						}

						Advancement _adv;
						AdvancementProgress _ap;
						Iterator var37;
						String criteria;
						if (num1 > 0.0) {
							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until jujutsucraft:sukuna_finger_" + Math.round(num1));
							}

							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement revoke @s only jujutsucraft:update");
							}

							if (entity instanceof ServerPlayer) {
								_player = (ServerPlayer) entity;
								_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
								_ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									var37 = _ap.getRemainingCriteria().iterator();

									while (var37.hasNext()) {
										criteria = (String) var37.next();
										_player.getAdvancements().award(_adv, criteria);
									}
								}
							}

							if (entity.getPersistentData().getBoolean("CursedSpirit")) {
								double _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 1000.0;
								entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
									capability.PlayerCursePowerChange = _setval;
									capability.syncPlayerVariables(entity);
								});
							} else {
								label440:
								{
									int var10000;
									label271:
									{
										if (entity instanceof LivingEntity) {
											_livEnt33 = (LivingEntity) entity;
											if (_livEnt33.hasEffect(MobEffects.UNLUCK)) {
												label266:
												{
													if (entity instanceof LivingEntity) {
														_livEnt36 = (LivingEntity) entity;
														if (_livEnt36.hasEffect(MobEffects.UNLUCK)) {
															var10000 = _livEnt36.getEffect(MobEffects.UNLUCK).getAmplifier();
															break label266;
														}
													}

													var10000 = 0;
												}

												++var10000;
												break label271;
											}
										}

										var10000 = 0;
									}

									num2 = (double) var10000;
									num2 = Math.min(num2, 9.0);
									if (!entity.level().isClientSide() && entity.getServer() != null) {
										entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:unluck 180 " + Math.round(num2) + " true");
									}

									if (level_control == 2.0) {
										sukuna = false;
										tick = 300.0;
									} else if (level_control == 1.0) {
										if (num2 >= 9.0 || num1 == 1.0) {
											sukuna = true;
											tick = 300.0;
										}
									} else if (level_control == 0.0) {
										sukuna = true;
										tick = 1000000.0;
									} else {
										sukuna = false;
										tick = 300.0;
									}

									if (!sukuna) {
										if (!(entity instanceof LivingEntity)) {
											break label440;
										}

										_livEnt36 = (LivingEntity) entity;
										if (!_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
											break label440;
										}
									}

									if (!entity.level().isClientSide() && entity.getServer() != null) {
										Commands var41 = entity.getServer().getCommands();
										CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
										Object var10002;
										if (tick > 10000.0) {
											var10002 = "infinite";
										} else {
											int var10003;
											label248:
											{
												if (entity instanceof LivingEntity) {
													LivingEntity _livEnt = (LivingEntity) entity;
													if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
														var10003 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
														break label248;
													}
												}

												var10003 = 0;
											}

											var10002 = Math.round(Math.max(tick, (double) Math.round(Math.floor((double) (var10003 / 20)))));
										}

										var41.performPrefixedCommand(var10001, "effect give @s jujutsucraft:sukuna_effect " + var10002 + " " + Math.round(Math.min(Math.max(GetSukunaLevelProcedure.execute(entity), 1.0), 20.0) - 1.0) + " true");
									}
								}
							}
						}

						if (!entity.getPersistentData().getBoolean("CursedSpirit")) {
							if (entity instanceof ServerPlayer) {
								_player = (ServerPlayer) entity;
								_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
								_ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									var37 = _ap.getRemainingCriteria().iterator();

									while (var37.hasNext()) {
										criteria = (String) var37.next();
										_player.getAdvancements().award(_adv, criteria);
									}
								}
							}

							if (level_control == 0.0) {
								boolean _setval = true;
								entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
									capability.flag_sukuna = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}

						WhenRespawnProcedure.execute(world, x, y, z, entity);
						JujutsucraftaddonModVariables.MapVariables.get(world).Sukuna = 1;
						JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
					}


				}
			} else {
				cursed_technique = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
				cursed_technique2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
				Player _plr;
				if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 0.0) {
					success = true;
					level_control = 2.0;
				} else if (cursed_technique != 21.0 && cursed_technique2 != 21.0) {
					label409:
					{
						label420:
						{
							if (entity instanceof Player) {
								_plr = (Player) entity;
								if (_plr.getAbilities().instabuild) {
									break label420;
								}
							}

							if (cursed_technique != 1.0 && cursed_technique2 != 1.0 && cursed_technique != 6.0 && cursed_technique2 != 6.0) {
								label434:
								{
									if (entity instanceof LivingEntity) {
										_livEnt33 = (LivingEntity) entity;
										if (_livEnt33.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
											break label434;
										}
									}

									success = false;
									level_control = 0.0;
									break label409;
								}
							}
						}

						success = true;
						level_control = 0.0;
					}
				} else {
					success = true;
					level_control = 1.0;
				}

				if (!success) {
					label388:
					{
						if (entity instanceof Player) {
							_plr = (Player) entity;
							if (_plr.getAbilities().instabuild) {
								break label388;
							}
						}

						if (entity instanceof Player) {
							Player _player = (Player) entity;
							ItemStack _setstack = (new ItemStack((ItemLike) JujutsucraftModItems.SUKUNA_FINGER.get())).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
					}

					if (entity instanceof LivingEntity) {
						_livEnt36 = (LivingEntity) entity;
						_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get());
					}

					if (entity instanceof LivingEntity) {
						_livEnt36 = (LivingEntity) entity;
						_livEnt36.removeEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get());
					}

					if (!entity.level().isClientSide() && entity.getServer() != null) {
						entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
					}
				}
			}

			if (entity.isAlive()) {
				num1 = 0.0;
				success = false;
				ServerPlayer _plr27;
				ServerPlayer _plr28;
				ServerPlayer _player;
				ServerPlayer _plr25;
				ServerPlayer _plr26;
				if (!success) {
					label435:
					{
						success = true;
						if (entity instanceof ServerPlayer) {
							_player = (ServerPlayer) entity;
							if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
								if (entity instanceof ServerPlayer) {
									_plr25 = (ServerPlayer) entity;
									if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_2"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr26 = (ServerPlayer) entity;
											if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_3"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr27 = (ServerPlayer) entity;
													if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_4"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr28 = (ServerPlayer) entity;
															if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()) {
																success = false;
																break label435;
															}
														}

														num1 = 5.0;
														break label435;
													}
												}

												num1 = 4.0;
												break label435;
											}
										}

										num1 = 3.0;
										break label435;
									}
								}

								num1 = 2.0;
								break label435;
							}
						}

						num1 = 1.0;
					}
				}

				if (!success) {
					label436:
					{
						success = true;
						if (entity instanceof ServerPlayer) {
							_player = (ServerPlayer) entity;
							if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_6"))).isDone()) {
								if (entity instanceof ServerPlayer) {
									_plr25 = (ServerPlayer) entity;
									if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_7"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr26 = (ServerPlayer) entity;
											if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_8"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr27 = (ServerPlayer) entity;
													if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_9"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr28 = (ServerPlayer) entity;
															if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_10"))).isDone()) {
																success = false;
																break label436;
															}
														}

														num1 = 10.0;
														break label436;
													}
												}

												num1 = 9.0;
												break label436;
											}
										}

										num1 = 8.0;
										break label436;
									}
								}

								num1 = 7.0;
								break label436;
							}
						}

						num1 = 6.0;
					}
				}

				if (!success) {
					label437:
					{
						success = true;
						if (entity instanceof ServerPlayer) {
							_player = (ServerPlayer) entity;
							if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_11"))).isDone()) {
								if (entity instanceof ServerPlayer) {
									_plr25 = (ServerPlayer) entity;
									if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_12"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr26 = (ServerPlayer) entity;
											if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_13"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr27 = (ServerPlayer) entity;
													if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_14"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr28 = (ServerPlayer) entity;
															if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
																success = false;
																break label437;
															}
														}

														num1 = 15.0;
														break label437;
													}
												}

												num1 = 14.0;
												break label437;
											}
										}

										num1 = 13.0;
										break label437;
									}
								}

								num1 = 12.0;
								break label437;
							}
						}

						num1 = 11.0;
					}
				}

				if (!success) {
					label438:
					{
						success = true;
						if (entity instanceof ServerPlayer) {
							_player = (ServerPlayer) entity;
							if (_player.level() instanceof ServerLevel && _player.getAdvancements().getOrStartProgress(_player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_16"))).isDone()) {
								if (entity instanceof ServerPlayer) {
									_plr25 = (ServerPlayer) entity;
									if (_plr25.level() instanceof ServerLevel && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_17"))).isDone()) {
										if (entity instanceof ServerPlayer) {
											_plr26 = (ServerPlayer) entity;
											if (_plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_18"))).isDone()) {
												if (entity instanceof ServerPlayer) {
													_plr27 = (ServerPlayer) entity;
													if (_plr27.level() instanceof ServerLevel && _plr27.getAdvancements().getOrStartProgress(_plr27.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_19"))).isDone()) {
														if (entity instanceof ServerPlayer) {
															_plr28 = (ServerPlayer) entity;
															if (_plr28.level() instanceof ServerLevel && _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_20"))).isDone()) {
																success = false;
																break label438;
															}
														}

														num1 = 20.0;
														break label438;
													}
												}

												num1 = 19.0;
												break label438;
											}
										}

										num1 = 18.0;
										break label438;
									}
								}

								num1 = 17.0;
								break label438;
							}
						}

						num1 = 16.0;
					}
				}

				Advancement _adv;
				AdvancementProgress _ap;
				Iterator var37;
				String criteria;
				if (num1 > 0.0) {
					if (!entity.level().isClientSide() && entity.getServer() != null) {
						entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement grant @s until jujutsucraft:sukuna_finger_" + Math.round(num1));
					}

					if (!entity.level().isClientSide() && entity.getServer() != null) {
						entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "advancement revoke @s only jujutsucraft:update");
					}

					if (entity instanceof ServerPlayer) {
						_player = (ServerPlayer) entity;
						_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:update"));
						_ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							var37 = _ap.getRemainingCriteria().iterator();

							while (var37.hasNext()) {
								criteria = (String) var37.next();
								_player.getAdvancements().award(_adv, criteria);
							}
						}
					}

					if (entity.getPersistentData().getBoolean("CursedSpirit")) {
						double _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 1000.0;
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
							capability.PlayerCursePowerChange = _setval;
							capability.syncPlayerVariables(entity);
						});
					} else {
						label440:
						{
							int var10000;
							label271:
							{
								if (entity instanceof LivingEntity) {
									_livEnt33 = (LivingEntity) entity;
									if (_livEnt33.hasEffect(MobEffects.UNLUCK)) {
										label266:
										{
											if (entity instanceof LivingEntity) {
												_livEnt36 = (LivingEntity) entity;
												if (_livEnt36.hasEffect(MobEffects.UNLUCK)) {
													var10000 = _livEnt36.getEffect(MobEffects.UNLUCK).getAmplifier();
													break label266;
												}
											}

											var10000 = 0;
										}

										++var10000;
										break label271;
									}
								}

								var10000 = 0;
							}

							num2 = (double) var10000;
							num2 = Math.min(num2, 9.0);
							if (!entity.level().isClientSide() && entity.getServer() != null) {
								entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:unluck 180 " + Math.round(num2) + " true");
							}

							if (level_control == 2.0) {
								sukuna = false;
								tick = 300.0;
							} else if (level_control == 1.0) {
								if (num2 >= 9.0 || num1 == 1.0) {
									sukuna = true;
									tick = 300.0;
								}
							} else if (level_control == 0.0) {
								sukuna = true;
								tick = 1000000.0;
							} else {
								sukuna = false;
								tick = 300.0;
							}

							if (!sukuna) {
								if (!(entity instanceof LivingEntity)) {
									break label440;
								}

								_livEnt36 = (LivingEntity) entity;
								if (!_livEnt36.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
									break label440;
								}
							}

							if (!entity.level().isClientSide() && entity.getServer() != null) {
								Commands var41 = entity.getServer().getCommands();
								CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
								Object var10002;
								if (tick > 10000.0) {
									var10002 = "infinite";
								} else {
									int var10003;
									label248:
									{
										if (entity instanceof LivingEntity) {
											LivingEntity _livEnt = (LivingEntity) entity;
											if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
												var10003 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier();
												break label248;
											}
										}

										var10003 = 0;
									}

									var10002 = Math.round(Math.max(tick, (double) Math.round(Math.floor((double) (var10003 / 20)))));
								}

								var41.performPrefixedCommand(var10001, "effect give @s jujutsucraft:sukuna_effect " + var10002 + " " + Math.round(Math.min(Math.max(GetSukunaLevelProcedure.execute(entity), 1.0), 20.0) - 1.0) + " true");
							}
						}
					}
				}

				if (!entity.getPersistentData().getBoolean("CursedSpirit")) {
					if (entity instanceof ServerPlayer) {
						_player = (ServerPlayer) entity;
						_adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:observation_of_the_soul"));
						_ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							var37 = _ap.getRemainingCriteria().iterator();

							while (var37.hasNext()) {
								criteria = (String) var37.next();
								_player.getAdvancements().award(_adv, criteria);
							}
						}
					}

					if (level_control == 0.0) {
						boolean _setval = true;
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
							capability.flag_sukuna = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}

				WhenRespawnProcedure.execute(world, x, y, z, entity);
				JujutsucraftaddonModVariables.MapVariables.get(world).Sukuna = 1;
				JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);

			}


		}

	}
}
