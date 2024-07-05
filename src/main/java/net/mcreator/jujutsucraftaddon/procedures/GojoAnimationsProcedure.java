package net.mcreator.jujutsucraftaddon.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class GojoAnimationsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 1 && new Object() {
			public double getValue() {
				CompoundTag dataIndex1 = new CompoundTag();
				entity.saveWithoutId(dataIndex1);
				return dataIndex1.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 215) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {
					if (!entity.isShiftKeyDown()) {
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null && !animation.isActive()) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki"))));
								}
							}
						}
					} else if (entity.isShiftKeyDown()) {
						if (new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(ReturnlevelProcedure.execute(world, entity)) >= 28000) {
							if (world.isClientSide()) {
								if (entity instanceof AbstractClientPlayer player) {
									var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
									if (animation != null && !animation.isActive()) {
										animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
									}
								}
							}
						}
					}
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex7 = new CompoundTag();
				entity.saveWithoutId(dataIndex7);
				return dataIndex7.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 1 && new Object() {
			public double getValue() {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				return dataIndex8.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 215 && new Object() {
			public double getValue() {
				CompoundTag dataIndex9 = new CompoundTag();
				entity.saveWithoutId(dataIndex9);
				return dataIndex9.getCompound("ForgeData").getDouble("cnt1");
			}
		}.getValue() >= 0) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @s * jujutsucraft:electric_shock");
					}
				}
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null && !animation.isActive()) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "gojopurple"))));
						}
					}
				}
				if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
						&& _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex13 = new CompoundTag();
							entity.saveWithoutId(dataIndex13);
							return dataIndex13.getCompound("ForgeData").getDouble("cnt6");
						}
					}.getValue() > 5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex14 = new CompoundTag();
								entity.saveWithoutId(dataIndex14);
								return dataIndex14.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() <= 50) {
							CompoundTag dataIndex16 = new CompoundTag();
							entity.saveWithoutId(dataIndex16);
							dataIndex16.getCompound("ForgeData").putDouble("cnt6", (new Object() {
								public double getValue() {
									CompoundTag dataIndex15 = new CompoundTag();
									entity.saveWithoutId(dataIndex15);
									return dataIndex15.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() + 1));
							entity.load(dataIndex16);
						}
					}
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex17 = new CompoundTag();
				entity.saveWithoutId(dataIndex17);
				return dataIndex17.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 215) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				if (!entity.isShiftKeyDown()) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex19 = new CompoundTag();
							entity.saveWithoutId(dataIndex19);
							return dataIndex19.getCompound("ForgeData").getDouble("cnt6");
						}
					}.getValue() == 1) {
						if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund != 1) {
							{
								double _setval = 1;
								entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.gojosund = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex20 = new CompoundTag();
				entity.saveWithoutId(dataIndex20);
				return dataIndex20.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 1 && new Object() {
			public double getValue() {
				CompoundTag dataIndex21 = new CompoundTag();
				entity.saveWithoutId(dataIndex21);
				return dataIndex21.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 206 && new Object() {
			public double getValue() {
				CompoundTag dataIndex22 = new CompoundTag();
				entity.saveWithoutId(dataIndex22);
				return dataIndex22.getCompound("ForgeData").getDouble("cnt1");
			}
		}.getValue() >= 0) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				if (entity.isShiftKeyDown()) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
							if (animation != null && !animation.isActive()) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "bluegojo"))));
							}
						}
					}
					if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
							&& _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex26 = new CompoundTag();
								entity.saveWithoutId(dataIndex26);
								return dataIndex26.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() > 5) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex27 = new CompoundTag();
									entity.saveWithoutId(dataIndex27);
									return dataIndex27.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() <= 10) {
								CompoundTag dataIndex29 = new CompoundTag();
								entity.saveWithoutId(dataIndex29);
								dataIndex29.getCompound("ForgeData").putDouble("cnt6", (new Object() {
									public double getValue() {
										CompoundTag dataIndex28 = new CompoundTag();
										entity.saveWithoutId(dataIndex28);
										return dataIndex28.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() + 1));
								entity.load(dataIndex29);
							}
						}
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex30 = new CompoundTag();
					entity.saveWithoutId(dataIndex30);
					return dataIndex30.getCompound("ForgeData").getDouble("PRESS_Z");
				}
			}.getValue() == 1 && new Object() {
				public double getValue() {
					CompoundTag dataIndex31 = new CompoundTag();
					entity.saveWithoutId(dataIndex31);
					return dataIndex31.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 206 && new Object() {
				public double getValue() {
					CompoundTag dataIndex32 = new CompoundTag();
					entity.saveWithoutId(dataIndex32);
					return dataIndex32.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 1) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
					if (entity.isShiftKeyDown()) {
						if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get()))) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get(), 100, 1, false, false));
						}
					}
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund == 1
					&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund < 2) {
				{
					double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gojosund = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gojosund = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gojosund = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @s");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
