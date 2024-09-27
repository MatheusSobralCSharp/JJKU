package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ElementalAttackProcedure {
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
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("Kyoka");
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
				CompoundTag dataIndex9 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex9);
				return dataIndex9.getCompound("ForgeData").getDouble("Jogoat");
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
					CompoundTag dataIndex16 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex16);
					return dataIndex16.getCompound("ForgeData").getDouble("brokenBrain");
				}
			}.getValue() == 2) {
				CompoundTag dataIndex17 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex17);
				dataIndex17.getCompound("ForgeData").putDouble("brokenBrain", 0);
				sourceentity.load(dataIndex17);
			}
		}
		if ((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex18 = new CompoundTag();
				entity.saveWithoutId(dataIndex18);
				return dataIndex18.getCompound("ForgeData").getBoolean("CursedSpirit");
			}
		}.getValue()) == false || (new Object() {
			public boolean getValue() {
				CompoundTag dataIndex19 = new CompoundTag();
				entity.saveWithoutId(dataIndex19);
				return dataIndex19.getCompound("ForgeData").getBoolean("CurseUser");
			}
		}.getValue()) == true || (new Object() {
			public boolean getValue() {
				CompoundTag dataIndex20 = new CompoundTag();
				entity.saveWithoutId(dataIndex20);
				return dataIndex20.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
			}
		}.getValue()) == true) {
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
								CompoundTag dataIndex29 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex29);
								dataIndex29.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex28 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex28);
										return dataIndex28.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex29);
								CompoundTag dataIndex32 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex32);
								dataIndex32.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex31 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex31);
										return dataIndex31.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex32);
								CompoundTag dataIndex35 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex35);
								dataIndex35.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex35);
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
								CompoundTag dataIndex44 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex44);
								dataIndex44.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex43 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex43);
										return dataIndex43.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex44);
								CompoundTag dataIndex47 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex47);
								dataIndex47.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex46 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex46);
										return dataIndex46.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex47);
								CompoundTag dataIndex49 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex49);
								dataIndex49.getCompound("ForgeData").putDouble("cnt3", 1);
								(entitytospawn).load(dataIndex49);
								CompoundTag dataIndex51 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex51);
								dataIndex51.getCompound("ForgeData").putDouble("cnt6", 60);
								(entitytospawn).load(dataIndex51);
								CompoundTag dataIndex54 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex54);
								dataIndex54.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex54);
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
								CompoundTag dataIndex65 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex65);
								dataIndex65.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex64 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex64);
										return dataIndex64.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex65);
								CompoundTag dataIndex68 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex68);
								dataIndex68.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex67 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex67);
										return dataIndex67.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex68);
								CompoundTag dataIndex71 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex71);
								dataIndex71.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex71);
								((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10.1);
								CompoundTag dataIndex75 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex75);
								dataIndex75.getCompound("ForgeData").putDouble("cnt3", 1);
								(entitytospawn).load(dataIndex75);
								CompoundTag dataIndex77 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex77);
								dataIndex77.getCompound("ForgeData").putDouble("cnt6", 10);
								(entitytospawn).load(dataIndex77);
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
								CompoundTag dataIndex90 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex90);
								dataIndex90.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex89 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex89);
										return dataIndex89.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex90);
								CompoundTag dataIndex93 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex93);
								dataIndex93.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex92 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex92);
										return dataIndex92.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex93);
								CompoundTag dataIndex96 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex96);
								dataIndex96.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex96);
								CompoundTag dataIndex98 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex98);
								dataIndex98.putBoolean("Player", true);
								(entitytospawn).load(dataIndex98);
								CompoundTag dataIndex100 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex100);
								dataIndex100.putBoolean("NoAI", true);
								(entitytospawn).load(dataIndex100);
								((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10.1);
								CompoundTag dataIndex104 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex104);
								dataIndex104.getCompound("ForgeData").putDouble("skill", 3610);
								(entitytospawn).load(dataIndex104);
								CompoundTag dataIndex106 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex106);
								dataIndex106.putString("Texture", "tornado_blue");
								(entitytospawn).load(dataIndex106);
								CompoundTag dataIndex108 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex108);
								dataIndex108.getCompound("ForgeData").putDouble("cnt6", 10);
								(entitytospawn).load(dataIndex108);
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
								CompoundTag dataIndex116 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex116);
								dataIndex116.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex115 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex115);
										return dataIndex115.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex116);
								CompoundTag dataIndex119 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex119);
								dataIndex119.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex118 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex118);
										return dataIndex118.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex119);
								CompoundTag dataIndex122 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex122);
								dataIndex122.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
								(entitytospawn).load(dataIndex122);
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
		if (sourceentity instanceof LivingEntity _livEnt134 && _livEnt134.hasEffect(JujutsucraftaddonModMobEffects.MEDITATION_STATE.get())) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex135 = new CompoundTag();
					entity.saveWithoutId(dataIndex135);
					return dataIndex135.getCompound("ForgeData").getDouble("Spirit");
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
	}
}
