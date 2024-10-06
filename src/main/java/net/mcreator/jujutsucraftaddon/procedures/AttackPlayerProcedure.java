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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class AttackPlayerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
		if (damagesource == null || entity == null || sourceentity == null)
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
			if (entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
				CounterProcedureProcedure.execute(world, damagesource, entity, sourceentity);
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
					if (!(entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
							&& _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) && entity instanceof ServerPlayer _plr17
							&& _plr17.level() instanceof ServerLevel && _plr17.getAdvancements().getOrStartProgress(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
						WorldSlashQuestProcedure.execute(world, entity);
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 5) {
					BrainEffectTwoProcedure.execute(entity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED) == true) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
							|| (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
						if (Math.random() <= 0.05) {
							if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
									&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
									SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
								}
							}
						}
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
								if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
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
				if (!(entity instanceof LivingEntity _livEnt36 && _livEnt36.hasEffect(MobEffects.CONFUSION))) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex37 = new CompoundTag();
							entity.saveWithoutId(dataIndex37);
							return dataIndex37.getCompound("ForgeData").getDouble("brokenBrain");
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
								CompoundTag dataIndex42 = new CompoundTag();
								entity.saveWithoutId(dataIndex42);
								return dataIndex42.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 0) {
							if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("domain" + new java.text.DecimalFormat("##.##").format(new Object() {
								public double getValue() {
									CompoundTag dataIndex43 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex43);
									return dataIndex43.getCompound("ForgeData").getDouble("skill_domain");
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
					((LivingHurtEvent) event).setAmount(((float) (amount / 1.2)));
				}
			}
			if ((entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) == false) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
					if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
						CounterItadoriProcedure.execute(world, entity);
					}
				}
			} else if (entity instanceof LivingEntity _livEnt51 && _livEnt51.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
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
			if (entity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(JujutsucraftaddonModMobEffects.TRAINING.get())) {
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
											_ent.teleportTo((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
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
									Entity _ent = sourceentity;
									_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
								}
								{
									Entity _ent = entity;
									_ent.teleportTo((sourceentity.getX()), (entity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
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
									Entity _ent = sourceentity;
									_ent.teleportTo((entity.getX()), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (entity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
								}
								{
									Entity _ent = entity;
									_ent.teleportTo((sourceentity.getX()), (entity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((sourceentity.getX()), (entity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -2, 2)), _ent.getYRot(), _ent.getXRot());
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
		if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				LineSukunaProcedure.execute(world, x, y, z, sourceentity);
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				LineGojoProcedure.execute(world, x, y, z, sourceentity);
			}
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Damage).equals("True")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Damage Amount: " + new java.text.DecimalFormat("##.##").format(amount))), false);
			}
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
				if (entity instanceof ServerPlayer _plr119 && _plr119.level() instanceof ServerLevel
						&& _plr119.getAdvancements().getOrStartProgress(_plr119.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
						if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
							YutaCondition2Procedure.execute(world, x, y, z, entity);
						}
					}
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 1) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 0) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerCursePower = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower
									- 100 / (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel);
							capability.syncPlayerVariables(entity);
						});
						((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Reduced 50% Of Damage"), false);
					}
				}
			}
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).MahoragaCanAdapt == 1) {
					if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 300) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal(("Adaptation: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource))) + "%"))),
										false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 300) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Mahoraga Adapted To: " + ("" + damagesource))), false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) > 300) {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
						}
					}
				}
				if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.FALL) || damagesource.is(DamageTypes.ARROW) || damagesource.is(DamageTypes.FREEZE) || damagesource.is(DamageTypes.LIGHTNING_BOLT)
						|| damagesource.is(DamageTypes.IN_FIRE) || damagesource.is(DamageTypes.DROWN) || damagesource.is(DamageTypes.ON_FIRE)) {
					if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 20) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal(
												("Adaptation: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) * 5) + "%"))),
										false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 20) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Mahoraga Adapted To: " + ("" + damagesource))), false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) > 20) {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
						}
					}
				} else if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION) || damagesource.is(DamageTypes.PLAYER_ATTACK) || damagesource.is(DamageTypes.MOB_ATTACK)
						|| damagesource.is(DamageTypes.MOB_ATTACK_NO_AGGRO)) {
					if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
						if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) < 50) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal(
												("Adaptation: " + (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) * 2) + "%"))),
										false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) == 50) {
							(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().putDouble(("" + damagesource),
									((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) + 1));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Mahoraga Adapted To: " + ("" + damagesource))), false);
						} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) > 50) {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof UiUiEntity) {
						if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
							{
								Entity _ent = entityiterator;
								_ent.teleportTo(x, y, z);
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 400,
										(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : 0)
												+ 3),
										false, false));
						}
					}
				}
			}
		}
		if (sourceentity instanceof LivingEntity _livEnt211 && _livEnt211.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.YUUN.get()) {
				((LivingHurtEvent) event).setAmount(((float) (amount * 2)));
			}
		}
		if (entity.getPersistentData().getDouble("IsMahoraga") == 1
				&& (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).contains("mahoraga")) {
			MahoragaLogicProcedure.execute(world, entity, sourceentity);
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_STAFF.get()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (Math.random() <= 0.3) {
						if (entityiterator == sourceentity) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).contains("clone") == false) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									CompoundTag dataIndex224 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex224);
									dataIndex224.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
									(entitytospawn).load(dataIndex224);
									CompoundTag dataIndex227 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex227);
									dataIndex227.putString("Owner", (sourceentity.getStringUUID()));
									(entitytospawn).load(dataIndex227);
									(entitytospawn).setCustomName(Component.literal((sourceentity.getDisplayName().getString())));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
											.setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
											.setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
											.setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
											.setBaseValue((((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
											.setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
									if ((entitytospawn) instanceof LivingEntity _entity)
										_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
									if ((entitytospawn) instanceof LivingEntity _entity) {
										ItemStack _setstack = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(0, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.FEET, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
										}
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
										}
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(2, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.CHEST, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
										}
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
										}
									}
									CompoundTag dataIndex269 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex269);
									dataIndex269.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex268 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex268);
											return dataIndex268.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex269);
									CompoundTag dataIndex272 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex272);
									dataIndex272.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex271 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex271);
											return dataIndex271.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex272);
									CompoundTag dataIndex274 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex274);
									dataIndex274.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
									(entitytospawn).load(dataIndex274);
									CompoundTag dataIndex276 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex276);
									dataIndex276.getCompound("ForgeData").putBoolean("Player", true);
									(entitytospawn).load(dataIndex276);
									CompoundTag dataIndex279 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex279);
									dataIndex279.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
										public boolean getValue() {
											CompoundTag dataIndex278 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex278);
											return dataIndex278.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex279);
									CompoundTag dataIndex282 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex282);
									dataIndex282.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
										public boolean getValue() {
											CompoundTag dataIndex281 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex281);
											return dataIndex281.getCompound("ForgeData").getBoolean("CursedSpirit");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex282);
									CompoundTag dataIndex285 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex285);
									dataIndex285.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
										public boolean getValue() {
											CompoundTag dataIndex284 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex284);
											return dataIndex284.getCompound("ForgeData").getBoolean("CurseUser");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex285);
								}
							}
						}
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKM_WUKONG) == true) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 19) {
					if (entity.getPersistentData().getDouble("Wukong") == 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1, false);
							}
						}
						entity.getPersistentData().putDouble("Wukong", 1);
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:miwa_kasumi")) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 40) {
					if (!(entity instanceof LivingEntity _livEnt296 && _livEnt296.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 120, 1, false, false));
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NPC_FISTS) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
				if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta_culling_game")) {
						FistYutaProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji")) {
						FistItadoriProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
						FistGojoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")
							|| (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
						FistSukunaProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:mahito")) {
						FistMahitoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:hakari_kinji")) {
						FistHakariProcedure.execute(world, entity, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:kashimo_hajime")) {
						FistKashimoProcedure.execute(world, entity, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:choso")) {
						FistChosoProcedure.execute(world, sourceentity);
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:jogo")) {
						FistJogoProcedure.execute(world, sourceentity);
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("skill" + new java.text.DecimalFormat("##.##").format(new Object() {
				public double getValue() {
					CompoundTag dataIndex314 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex314);
					return dataIndex314.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue()))) >= 100) {
				if (!(new Object() {
					public double getValue() {
						CompoundTag dataIndex318 = new CompoundTag();
						entity.saveWithoutId(dataIndex318);
						return dataIndex318.getCompound("ForgeData").getDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
							public double getValue() {
								CompoundTag dataIndex317 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex317);
								return dataIndex317.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue())));
					}
				}.getValue() == 1)) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 1));
					CompoundTag dataIndex322 = new CompoundTag();
					entity.saveWithoutId(dataIndex322);
					dataIndex322.getCompound("ForgeData").putDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
						public double getValue() {
							CompoundTag dataIndex321 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex321);
							return dataIndex321.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue())), 1);
					entity.load(dataIndex322);
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
					SlashProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER) == true) {
					SongsProcedure.execute(world, x, y, z, entity, sourceentity);
				}
				if (sourceentity instanceof ServerPlayer _plr326 && _plr326.level() instanceof ServerLevel
						&& _plr326.getAdvancements().getOrStartProgress(_plr326.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone()
						&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
						FistSukunaProcedure.execute(world, sourceentity);
					} else if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) == false) {
						FistsProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
					if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
						if (sourceentity instanceof ServerPlayer _plr331 && _plr331.level() instanceof ServerLevel
								&& _plr331.getAdvancements().getOrStartProgress(_plr331.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
							YutaConditionProcedure.execute(world, x, y, z, sourceentity);
						}
					}
				}
			} else if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
				if (!(sourceentity instanceof LivingEntity _livEnt333 && _livEnt333.hasEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get()))) {
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex334 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex334);
								return dataIndex334.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 1) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get(), -1, 1, false, false));
						}
					}
				}
			}
		}
		if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					WhenHitPlayerProcedure.execute(world, x, y, z, entity, sourceentity);
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
						ChosoExtensionProcedure.execute(world, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
						CutRCTProcedure.execute(world, entity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
						if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Uraume")) {
							WhenHitUraumeProcedure.execute(world, entity);
						}
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
					if (!(sourceentity instanceof LivingEntity _livEnt341 && _livEnt341.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get(), -1, 1, false, false));
						}
					}
				} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
					if (!(sourceentity instanceof LivingEntity _livEnt345 && _livEnt345.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get()))
							&& ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get(), -1, 1, false, false));
						}
					}
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel == true) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex349 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex349);
								return dataIndex349.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 0 && new Object() {
							public double getValue() {
								CompoundTag dataIndex350 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex350);
								return dataIndex350.getCompound("ForgeData").getDouble("skill_domain");
							}
						}.getValue() == 0) {
							if (Math.random() <= 0.05) {
								{
									Entity _ent = sourceentity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower 10 @s");
									}
								}
							}
						}
					}
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
						ConfiscationAndGuiltyProcedure.execute(world, entity, sourceentity);
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
						entity.setSecondsOnFire(15);
						(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
								.setDamageValue((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1));
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
						MegumiHit2Procedure.execute(world, entity, sourceentity);
						if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
							if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 3) {
								if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
									SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
									{
										double _setval = 0;
										sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.OutputLevel = _setval;
											capability.syncPlayerVariables(sourceentity);
										});
									}
								}
							}
						}
					} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
						TojiRCTCutProcedure.execute(world, x, y, z, entity, sourceentity);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLACK_FLASH_CUT.get(), 60, 1, false, false));
						((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
					}
				}
				if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT) == true) {
						AirCombatProcedure.execute(world, x, y, z, entity, sourceentity);
					}
				}
			}
		}
		if (((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("dialoguesoul2").getString())
				|| ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
						.contains(Component.translatable("dialoguesoul1").getString())) {
			if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) || sourceentity instanceof LivingEntity _livEnt373 && _livEnt373.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
				if (Math.random() <= 0.5) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI.get()), x, y, z, 1, 1, 1, 1, 1);
				} else {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI.get()), x, y, z, 1, 1, 1, 1, 1);
				}
				((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(),
							(120 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getDuration() : 0)),
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1), false, true));
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex379 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex379);
				return dataIndex379.getCompound("ForgeData").getDouble("Kyoka");
			}
		}.getValue() == 5) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.KYOKA.get()) {
				SpawnCloneDefensiveProcedure.execute(world, x, y, z, entity);
				{
					Entity _ent = entity;
					_ent.teleportTo((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
				}
				sourceentity.hurt(damagesource, (float) amount);
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex388 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex388);
				return dataIndex388.getCompound("ForgeData").getDouble("Jogoat");
			}
		}.getValue() == 1) {
			if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get());
			} else if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
			} else if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
				if (sourceentity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.UNSTABLE.get());
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex395 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex395);
					return dataIndex395.getCompound("ForgeData").getDouble("brokenBrain");
				}
			}.getValue() == 2) {
				CompoundTag dataIndex396 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex396);
				dataIndex396.getCompound("ForgeData").putDouble("brokenBrain", 0);
				sourceentity.load(dataIndex396);
			}
		}
		if ((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex397 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex397);
				return dataIndex397.getCompound("ForgeData").getBoolean("CursedSpirit");
			}
		}.getValue()) == false && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel == false) {
			if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Blacksmith")) {
				if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Fire")) {
					if (Math.random() <= 0.1) {
						entity.setSecondsOnFire(15);
					}
					if (entity.getRemainingFireTicks() > 0) {
						if (Math.random() <= 0.5) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60, entity.getRemainingFireTicks(), false, false));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, entity.getRemainingFireTicks(), false, false));
						}
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftModEntities.BULLET_FLAME_PROJECTILE.get().spawn(_serverLevel, BlockPos.containing(x, (y + 1), z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								CompoundTag dataIndex406 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex406);
								dataIndex406.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex405 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex405);
										return dataIndex405.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex406);
								CompoundTag dataIndex409 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex409);
								dataIndex409.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex408 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex408);
										return dataIndex408.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex409);
								CompoundTag dataIndex412 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex412);
								dataIndex412.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex412);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.shoot")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.shoot")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
											entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
								_serverLevel.addFreshEntity(entitytospawn);
							}
						}
					}
				} else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Water")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
					if (Math.random() <= 0.1) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftModEntities.ENTITY_WATER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								CompoundTag dataIndex421 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex421);
								dataIndex421.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex420 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex420);
										return dataIndex420.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex421);
								CompoundTag dataIndex424 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex424);
								dataIndex424.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex423 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex423);
										return dataIndex423.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex424);
								CompoundTag dataIndex426 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex426);
								dataIndex426.getCompound("ForgeData").putDouble("cnt3", 1);
								(entitytospawn).load(dataIndex426);
								CompoundTag dataIndex428 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex428);
								dataIndex428.getCompound("ForgeData").putDouble("cnt6", 60);
								(entitytospawn).load(dataIndex428);
								CompoundTag dataIndex431 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex431);
								dataIndex431.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex431);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton_horse.step_water")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton_horse.step_water")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
											entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
								_serverLevel.addFreshEntity(entitytospawn);
							}
						}
					}
				} else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Wind")) {
					if (Math.random() <= 0.5) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftModEntities.ENTITY_SLASH.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								CompoundTag dataIndex442 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex442);
								dataIndex442.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex441 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex441);
										return dataIndex441.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex442);
								CompoundTag dataIndex445 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex445);
								dataIndex445.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex444 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex444);
										return dataIndex444.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex445);
								CompoundTag dataIndex448 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex448);
								dataIndex448.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex448);
								((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10.1);
								CompoundTag dataIndex452 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex452);
								dataIndex452.getCompound("ForgeData").putDouble("cnt3", 1);
								(entitytospawn).load(dataIndex452);
								CompoundTag dataIndex454 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex454);
								dataIndex454.getCompound("ForgeData").putDouble("cnt6", 10);
								(entitytospawn).load(dataIndex454);
								(entitytospawn)
										.setDeltaMovement(
												new Vec3(
														(sourceentity.level()
																.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																		sourceentity))
																.getBlockPos().getX()),
														(sourceentity.level()
																.clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
																		sourceentity))
																.getBlockPos().getY()),
														(sourceentity.level().clip(new ClipContext(sourceentity.getEyePosition(1f), sourceentity.getEyePosition(1f).add(sourceentity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE,
																ClipContext.Fluid.NONE, sourceentity)).getBlockPos().getZ())));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:slash2")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:slash2")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
											entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
								_serverLevel.addFreshEntity(entitytospawn);
							}
						}
					} else if (Math.random() <= 0.01) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftModEntities.ENTITY_TORNADO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								CompoundTag dataIndex467 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex467);
								dataIndex467.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex466 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex466);
										return dataIndex466.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex467);
								CompoundTag dataIndex470 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex470);
								dataIndex470.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex469 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex469);
										return dataIndex469.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex470);
								CompoundTag dataIndex473 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex473);
								dataIndex473.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex473);
								CompoundTag dataIndex475 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex475);
								dataIndex475.putBoolean("Player", true);
								(entitytospawn).load(dataIndex475);
								CompoundTag dataIndex477 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex477);
								dataIndex477.putBoolean("NoAI", true);
								(entitytospawn).load(dataIndex477);
								((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10.1);
								CompoundTag dataIndex481 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex481);
								dataIndex481.getCompound("ForgeData").putDouble("skill", 3610);
								(entitytospawn).load(dataIndex481);
								CompoundTag dataIndex483 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex483);
								dataIndex483.putString("Texture", "tornado_blue");
								(entitytospawn).load(dataIndex483);
								CompoundTag dataIndex485 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex485);
								dataIndex485.getCompound("ForgeData").putDouble("cnt6", 10);
								(entitytospawn).load(dataIndex485);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("intentionally_empty")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
											entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
								_serverLevel.addFreshEntity(entitytospawn);
							}
						}
					}
				} else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Lightning")) {
					if (Math.random() <= 0.05) {
						if (world instanceof ServerLevel _serverLevel) {
							Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
							if (entitytospawn != null) {
								entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								CompoundTag dataIndex493 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex493);
								dataIndex493.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex492 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex492);
										return dataIndex492.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex493);
								CompoundTag dataIndex496 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex496);
								dataIndex496.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex495 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex495);
										return dataIndex495.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex496);
								CompoundTag dataIndex499 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex499);
								dataIndex499.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex499);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
											entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
								_serverLevel.addFreshEntity(entitytospawn);
							}
						}
					}
				} else if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Earth")) {
					if (Math.random() <= 0.5) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2, false, false));
						((LivingHurtEvent) event).setAmount(((float) (amount * 2)));
					}
				}
			} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Blacksmith")) {
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Element).equals("Wind")) {
					if (Math.random() <= 0.05) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("The Leaf Flows In Your Body"), false);
						entity.setDeltaMovement(new Vec3((Mth.nextInt(RandomSource.create(), -2, 2)), 0, 0));
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
			if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Warrior")) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Level >= 2) {
					if (Math.random() <= 0.01) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 40, 0, false, false));
					}
				}
			}
		}
		if (sourceentity instanceof LivingEntity _livEnt511 && _livEnt511.hasEffect(JujutsucraftaddonModMobEffects.MEDITATION_STATE.get())) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex512 = new CompoundTag();
					entity.saveWithoutId(dataIndex512);
					return dataIndex512.getCompound("ForgeData").getDouble("Spirit");
				}
			}.getValue() == 1) {
				if (amount < 400) {
					sourceentity.getPersistentData().putDouble("PointsSpirit", (sourceentity.getPersistentData().getDouble("PointsSpirit") + amount));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
				} else {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
		if (entity.getPersistentData().getBoolean("CursedSpirit") == true && entity.getPersistentData().getBoolean("CurseUser") == false) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15
					&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (Math.random() <= 0.005) {
					sourceentity.hurt(damagesource, (float) (amount / 2));
				}
			}
			if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15
					&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (Math.random() <= 0.005) {
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 40, 0, false, false));
				}
			}
			if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15
					&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
					if (Math.random() <= 0.1) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANTI_HEAL.get(), 40, 0, false, false));
					}
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) == false) {
			if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) == false) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19
							&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
						if (Math.random() <= 0.1) {
							SpawnFakeCloneProcedure.execute(world, x, y, z, entity);
							{
								Entity _ent = entity;
								_ent.teleportTo(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)), _ent.getYRot(), _ent.getXRot());
							}
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof IgrisEntity || sourceentity instanceof Shadow1Entity) {
			AttackedShadowsProcedure.execute(x, y, z, sourceentity);
		}
	}
}
