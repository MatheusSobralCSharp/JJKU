package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.StevensonScreenEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.CursedSpiritGrade37Entity;

import javax.annotation.Nullable;

import java.util.Objects;

@Mod.EventBusSubscriber
public class SpawnedProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RESPAWNED_JUJUTSU.get(), 20, 1, false, false));
				MobSpawnType spawnType = ((PathfinderMob) entity).getSpawnType();
				if (spawnType != null) {
					if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_STEVENSON) == true) {
							if (entity instanceof StevensonScreenEntity) {
								if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
									if (!(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										} else if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
									}
								}
							}
						}
						if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_ARMORY_SPIRIT) == true) {
							if (entity instanceof CursedSpiritGrade37Entity) {
								if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
									if (!(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										} else if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
									}
								}
							}
						}
						if (entity instanceof SukunaEntity || (Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:sukuna_fushiguro") || entity instanceof SukunaPerfectEntity) {
							if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
								if (!(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
									if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_RATE))) {
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										} else if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
									}
								}
							}
						} else if (entity instanceof GojoSatoruSchoolDaysEntity || entity instanceof GojoSatoruEntity) {
							if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
								if (!(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
									if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_GOJO_RATE))) {
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										} else if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
									}
								}
							}
						} else if (entity instanceof FushiguroTojiEntity || entity instanceof FushiguroTojiBugEntity) {
							if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
								if (!(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
									if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_TOJI_RATE))) {
										if (event != null && event.isCancelable()) {
											event.setCanceled(true);
										} else if (event != null && event.hasResult()) {
											event.setResult(Event.Result.DENY);
										}
									}
								}
							}
						}
						if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
							if (entity.getPersistentData().getDouble("CursedSpirit") == 1 && !(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
								if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RATE))) {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									} else if (event != null && event.hasResult()) {
										event.setResult(Event.Result.DENY);
									}
								}
							} else if (entity.getPersistentData().getDouble("CurseUser") == 1 && !(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
								if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSE_USERS_RATE))) {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									} else if (event != null && event.hasResult()) {
										event.setResult(Event.Result.DENY);
									}
								}
							} else if (entity.getPersistentData().getDouble("JujutsuSorcerer") == 1 && !(((PathfinderMob) entity).getSpawnType().toString()).equals("COMMAND")) {
								if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SORCERERS_RATE))) {
									if (event != null && event.isCancelable()) {
										event.setCanceled(true);
									} else if (event != null && event.hasResult()) {
										event.setResult(Event.Result.DENY);
									}
								}
							} // Check if the entity has the specified tags
							// Check if the entity has the specified tags
							if (entity.getPersistentData().getDouble("CursedSpirit") == 1 ||
									entity.getPersistentData().getDouble("CurseUser") == 1 ||
									entity.getPersistentData().getDouble("JujutsuSorcerer") == 1) {

								// Check if the entity has "ForgeData" and if it's not null
								if (entity.getPersistentData().contains("ForgeData")) {
									CompoundTag forgeData = entity.getPersistentData().getCompound("ForgeData");
									if (forgeData != null) {
										double buffValue = forgeData.getDouble("buff");

										// If "buff" is not set to 1, apply the health modification
										if (buffValue != 1) {
											LivingEntity livingEntity = (LivingEntity) entity;

											// Get the current MAX_HEALTH attribute
											AttributeInstance maxHealthAttr = livingEntity.getAttribute(Attributes.MAX_HEALTH);
											if (maxHealthAttr != null) {
												// Update the MAX_HEALTH attribute based on game difficulty
												double gameDifficulty = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY);
												double newMaxHealth = 100.0 / gameDifficulty * maxHealthAttr.getBaseValue();
												maxHealthAttr.setBaseValue(newMaxHealth);

												// Set the entity's health to the new maximum
												livingEntity.setHealth(livingEntity.getMaxHealth());
											}

											// Update the "buff" value in the persistent data
											forgeData.putDouble("buff", 1);
											entity.getPersistentData().put("ForgeData", forgeData);
										}
									}
								}
							}
							if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_OVERWORLD)) {
								if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
									if (!(((PathfinderMob) entity).getSpawnType().toString()).isEmpty()) {
										if ((((PathfinderMob) entity).getSpawnType().toString()).equals("NATURAL")) {
											if (event != null && event.isCancelable()) {
												event.setCanceled(true);
											} else if (event != null && event.hasResult()) {
												event.setResult(Event.Result.DENY);
											}
										}
									}
								}
							}
						}
					}
				}
				KenjakuDomainSummoningProcedure.execute(world, x, y, z, entity);
				if (entity.getPersistentData().getDouble("Mahoraga") == 1) {
					if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MAHO_EFFECTO.get(), 40, 1, false, false));
					}
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_VANILLA) == true) {
				if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:vanilla_mob")))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					} else if (event != null && event.hasResult()) {
						event.setResult(Event.Result.DENY);
					}
				}
			}
		}
	}
}
