package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class Die1Procedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.getPersistentData().getDouble("Fight") == 1 || sourceentity.getPersistentData().getDouble("Wukong") == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "stopsound @s");
				}
			}
			sourceentity.getPersistentData().putDouble("Wukong", 0);
			sourceentity.getPersistentData().putDouble("Fight", 0);
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow4 >= 1) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "clear");
					}
				}
				{
					double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel
							- (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow4 * 2000;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CursedLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
					entity.setInvulnerable(true);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
				if (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.MANIFESTATION.get())) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerCurseTechnique2 = 5;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
					if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CULLING_GAMES) == true) {
						{
							double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Points + 1;
							sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Points = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Tengen")) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) == 2) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1000, 0, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 1000, 1, false, false));
				}
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entity == entityiterator)) {
									if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:crow")) {
										if ((new Object() {
											public String getValue() {
												CompoundTag dataIndex21 = new CompoundTag();
												entityiterator.saveWithoutId(dataIndex21);
												return dataIndex21.getCompound("ForgeData").getString("FOLLOW_ID");
											}
										}.getValue()).equals(entity.getStringUUID())) {
											if (!entityiterator.level().isClientSide())
												entityiterator.discard();
											if (entity instanceof LivingEntity _entity)
												_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
											if (event != null && event.isCancelable()) {
												event.setCanceled(true);
											}
										}
									}
								}
							}
						}
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
						if (Math.random() <= 0.01) {
							if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(JujutsucraftaddonModMobEffects.AWAKENING.get()))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.AWAKENING.get(), 3000, 1, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), 3000, 1, false, false));
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sokamona")), SoundSource.NEUTRAL, 2, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sokamona")), SoundSource.NEUTRAL, 2, 1, false);
									}
								}
								{
									double _setval = 1;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.sokamona = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (event != null && event.isCancelable()) {
									event.setCanceled(true);
								}
							}
						}
					}
				}
			}
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 != 1
				&& (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
				if (Math.random() >= 0.5) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute run summon jujutsucraft:sukuna ~ ~ ~");
						}
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna") && !(new Object() {
				public double getValue() {
					CompoundTag dataIndex35 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex35);
					return dataIndex35.getCompound("ForgeData").getDouble("sukunacompanion");
				}
			}.getValue() == 1)) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
											_ent.level().getServer(), _ent),
									"execute run summon jujutsucraftaddon:sukuna_fushiguro ~ ~ ~ {ArmorItems:[{id:\"jujutsucraft:uniform_normal_chestplate\",Count:1b},{id:\"jujutsucraft:uniform_normal_leggings\",Count:1b}]}");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute run summon jujutsucraft:itadori_yuji_shibuya ~ ~ ~");
						}
					}
					if (!sourceentity.level().isClientSide())
						sourceentity.discard();
				}
			}
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:higuruma_hiromi")) {
				if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:executioners_sword")) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex43 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex43);
									return dataIndex43.getCompound("ForgeData").getDouble("JujutsuSorcerer");
								}
							}.getValue() == 1) {
								if (entityiterator instanceof LivingEntity _entity) {
									ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
						}
					}
				}
			}
		}
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
					if (Math.random() < 0.1) {
						if (!(sourceentity instanceof ServerPlayer _plr49 && _plr49.level() instanceof ServerLevel
								&& _plr49.getAdvancements().getOrStartProgress(_plr49.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
					if (Math.random() < 0.1) {
						if ((sourceentity instanceof ServerPlayer _plr51 && _plr51.level() instanceof ServerLevel
								&& _plr51.getAdvancements().getOrStartProgress(_plr51.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash"))).isDone()) == false) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kusakabe_yatsuya")) {
					if (!(sourceentity instanceof ServerPlayer _plr54 && _plr54.level() instanceof ServerLevel
							&& _plr54.getAdvancements().getOrStartProgress(_plr54.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"))).isDone())) {
						if (Math.random() < 0.1) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
					if (!(sourceentity instanceof ServerPlayer _plr56 && _plr56.level() instanceof ServerLevel
							&& _plr56.getAdvancements().getOrStartProgress(_plr56.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki"))).isDone())) {
						if (Math.random() < 0.1) {
							if (sourceentity instanceof ServerPlayer _player) {
								Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki"));
								AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
								if (!_ap.isDone()) {
									for (String criteria : _ap.getRemainingCriteria())
										_player.getAdvancements().award(_adv, criteria);
								}
							}
						}
					}
				}
				if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex59 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex59);
							return dataIndex59.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 105) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
							{
								Entity _ent = sourceentity;
								if (!_ent.level().isClientSide() && _ent.getServer() != null) {
									_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
											4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojodeath")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojodeath")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
					if (!(sourceentity instanceof ServerPlayer _plr63 && _plr63.level() instanceof ServerLevel
							&& _plr63.getAdvancements().getOrStartProgress(_plr63.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"))).isDone())) {
						if (sourceentity instanceof ServerPlayer _plr64 && _plr64.level() instanceof ServerLevel
								&& _plr64.getAdvancements().getOrStartProgress(_plr64.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) {
							if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
								if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:supreme_martial_solution")) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex68 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex68);
											return dataIndex68.getCompound("ForgeData").getDouble("skill");
										}
									}.getValue() == 105) {
										if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kashimo_hajime")) {
											{
												Entity _ent = sourceentity;
												if (!_ent.level().isClientSide() && _ent.getServer() != null) {
													_ent.getServer().getCommands()
															.performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
																			_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
																	"execute as @s run item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
												}
											}
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											if (sourceentity instanceof ServerPlayer _player) {
												Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:ultimate_power"));
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
											{
												Entity _entity = sourceentity;
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(3, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get()));
												}
											}
										}
									}
								}
							}
						}
					}
				}
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
					QuestGojoProcedure.execute(entity, sourceentity);
				}
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 1) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:fushiguro_toji")) {
						{
							double _setval = 2;
							sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.History = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					}
				}
				if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Warrior")) {
					ProfessionDeathProcedure.execute(entity, sourceentity);
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsCursedSpirit == true
						&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsJujutsuSorcerer == false) {
					ProfessionDeathProcedure.execute(entity, sourceentity);
				}
				if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kenjaku")
						|| ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Okkotsu")) {
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18
							|| (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5
							|| (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (sourceentity
									.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).KenjakuCT1
							|| (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == (entity
									.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).KenjakuCT2) {
						BarrierLessoProcedure.execute(world, entity, sourceentity);
					}
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKM_NO_DROPS) == false) {
					DropItems3Procedure.execute(world, entity, sourceentity);
				}
				if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKM_NO_POWER_PROGRESSION) == false) {
					CursedLevelGainProcedure.execute(entity, sourceentity);
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:mahito")) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:nanami_kento")) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanamitheme")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanamitheme")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
