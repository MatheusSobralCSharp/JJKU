package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

@Mod.EventBusSubscriber
public class AttackPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
				if (Math.random() <= 0.5) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
								if (((entityiterator instanceof LivingEntity) && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.ZONE.get())) == false) {
									entityiterator.getPersistentData().putDouble("skill", 710);
									entityiterator.getPersistentData().putDouble("PRESS_Z", 1);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
								} else {
									entityiterator.getPersistentData().putDouble("skill", 705);
									entityiterator.getPersistentData().putDouble("PRESS_Z", 1);
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
								}
							}
						}
					}
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
					if (Math.random() <= 0.001) {
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null && !animation.isActive()) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dodge" + Mth.nextInt(RandomSource.create(), 1, 3))))));
								}
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get()), x, y, z, 5, 3, 3, 3, 1);
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:projection_sorcery 1 1 true");
							}
						}
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
			if (entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
				CounterProcedureProcedure.execute(world, entity, sourceentity);
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				CeLevelProcedure.execute(sourceentity);
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
						if (Math.random() <= 0.2) {
							TodoHitProcedure2Procedure.execute(world, x, y, z, entity, sourceentity);
						}
					} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
						MegumiHitProcedure.execute(world, entity, sourceentity);
					}
				}
				if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0) >= 19) {
					if (!(entity instanceof ServerPlayer _plr21 && _plr21.level() instanceof ServerLevel
							&& _plr21.getAdvancements().getOrStartProgress(_plr21.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) && entity instanceof ServerPlayer _plr22
							&& _plr22.level() instanceof ServerLevel && _plr22.getAdvancements().getOrStartProgress(_plr22.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
						WorldSlashQuestProcedure.execute(world, entity);
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 5) {
					BrainEffectTwoProcedure.execute(entity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED) == true) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
							|| (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
						SukunaTakesOverBodyProcedure.execute(world, entity, sourceentity);
					}
				}
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
					ChangeMimicryProcedure.execute(entity, sourceentity);
				}
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Inumaki")) {
					InumakiClanTrashProcedure.execute(world, entity);
				}
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
						if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != -1) {
							if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get()) == false) {
								if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
									if (amount > 5) {
										LimbssProcedure.execute(world, entity, amount);
									}
								}
							}
						}
					}
				}
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS) == true) {
						if (!(new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer _serverPlayer) {
									return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
								} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
									return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
											&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
								}
								return false;
							}
						}.checkGamemode(entity))) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb > 0) {
								if (!(entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
									if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get(), -1, 1, false, false));
								}
							}
						}
					}
				}
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) == false) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomain == true) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get(), 20,
											(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())
													? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()).getAmplifier()
													: 0) + 1),
											false, false));
							}
						}
					}
				}
				if (!(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.CONFUSION))) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex39 = new CompoundTag();
							entity.saveWithoutId(dataIndex39);
							return dataIndex39.getCompound("ForgeData").getDouble("brokenBrain");
						}
					}.getValue() == 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 245, false, false));
					}
				}
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
					if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex44 = new CompoundTag();
								entity.saveWithoutId(dataIndex44);
								return dataIndex44.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 0) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("domain" + new java.text.DecimalFormat("##.##").format(new Object() {
								public double getValue() {
									CompoundTag dataIndex45 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex45);
									return dataIndex45.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue()))) >= 100) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s unless entity @e[nbt={ForgeData:{Mahoraga:1d}},distance=..50] run summon jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga ~ ~ ~ {ForgeData:{Mahoraga:1d},Attributes:[{Name:\"jujutsucraft:size\",Base:2}]}");
									}
								}
							}
						}
					}
				}
			}
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 > 0) {
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Disaster Curses")) {
					((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
				}
			}
			if ((entity instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) == false) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
					if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
						CounterItadoriProcedure.execute(world, entity);
					}
				}
			} else if (entity instanceof LivingEntity _livEnt53 && _livEnt53.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
					((LivingHurtEvent) event).setAmount(((float) (amount / 1.1)));
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED) == true) {
				CounterBFProcedure.execute(world, sourceentity);
			}
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (entity instanceof LivingEntity _livEnt57 && _livEnt57.hasEffect(JujutsucraftaddonModMobEffects.TRAINING.get())) {
				if (amount > 80) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Failed Test, Try Again"), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Failed Test, Try Again"), false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.big_fall")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.big_fall")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get());
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(JujutsucraftaddonModMobEffects.TRAINING.get());
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Failed Test, Try Again"), false);
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
					if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) == false
							&& (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false
							&& (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) == false) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (Math.random() <= 0.5) {
									if (!(entityiterator == sourceentity)) {
										{
											Entity _ent = entity;
											_ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
										}
										{
											Entity _ent = sourceentity;
											_ent.teleportTo((entityiterator.getX()), (sourceentity.getY()), (entityiterator.getZ()));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (sourceentity.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:clap")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										}
									} else {
										((LivingHurtEvent) event).setAmount(((float) (amount / 1.1)));
									}
								}
							}
						}
						if (Math.random() <= 0.01) {
							entity.getPersistentData().putDouble("Roulette", 2);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("This Now Allows Him To Activate His Swapping Technique Roughly Fifty Times In A Single Second"), false);
						} else if (Math.random() <= 0.02) {
							entity.getPersistentData().putDouble("Roulette", 1);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal("Having Replaced His Left Arm, Changed The Activation Condition Of His Technique From Applause, To The Collision Between The Wooden Box And The Metal Teeth Of The Vibraslap"), false);
						}
						if (entity.getPersistentData().getDouble("Roulette") == 1) {
							for (int index0 = 0; index0 < 50; index0++) {
								{
									Entity _ent = entity;
									_ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
								}
								{
									Entity _ent = sourceentity;
									_ent.teleportTo((entity.getX()), (sourceentity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entity.getX()), (sourceentity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
								}
								sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
										(float) amount);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								entity.getPersistentData().putDouble("Roulette", 0);
							}
						} else if (entity.getPersistentData().getDouble("Roulette") == 2) {
							for (int index1 = 0; index1 < 25; index1++) {
								{
									Entity _ent = entity;
									_ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
								}
								{
									Entity _ent = sourceentity;
									_ent.teleportTo((entity.getX()), (sourceentity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entity.getX()), (sourceentity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
								}
								sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
										(float) amount);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:vibraslap")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								entity.getPersistentData().putDouble("Roulette", 0);
							}
						}
					}
				}
			}
		}
	}
}
