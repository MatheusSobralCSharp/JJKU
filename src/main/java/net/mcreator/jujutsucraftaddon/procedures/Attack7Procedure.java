package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class Attack7Procedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getOriginalTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Monster) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:sukuna")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsmaho")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsmaho")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
							}
						}
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex10 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex10);
						dataIndex10.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex10);
					}
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex11 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex11);
						return dataIndex11.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru_school_days")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex14 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex14);
						dataIndex14.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex14);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:nanami_kento")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex16 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex16);
						return dataIndex16.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex19 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex19);
						dataIndex19.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex19);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex21 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex21);
						return dataIndex21.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex24 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex24);
						dataIndex24.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex24);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex26 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex26);
						return dataIndex26.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:choso")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex29 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex29);
						dataIndex29.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex29);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji_bug")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex31 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex31);
						return dataIndex31.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex34 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex34);
						dataIndex34.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex34);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex36 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex36);
						return dataIndex36.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:jogo")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex39 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex39);
						dataIndex39.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex39);
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru_curse_user")) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex44 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex44);
						dataIndex44.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex44);
					}
				}
			}
		}
		if (sourceentity instanceof ItadoriShinjukuEntity) {
			if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (Math.random() <= 0.05) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = JujutsucraftModEntities.ENTITY_BLACK_FLASH.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 1, 60, false, true));
							_serverLevel.addFreshEntity(entitytospawn);
						}
					}
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if ((entityiterator.getStringUUID()).equals(new Object() {
							public String getValue() {
								CompoundTag dataIndex52 = new CompoundTag();
								entity.saveWithoutId(dataIndex52);
								return dataIndex52.getCompound("ForgeData").getString("OWNER_UUID");
							}
						}.getValue())) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
								if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:nue")) {
									if (entity.getPersistentData().getDouble("BuffedSukuna") == 0) {
										((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(4);
										((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
												.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2));
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
										entity.getPersistentData().putDouble("BuffedSukuna", 1);
									}
								} else {
									if (entity.getPersistentData().getDouble("BuffedSukuna") == 0) {
										((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
										((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
												.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2));
										if (entity instanceof LivingEntity _entity)
											_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
										entity.getPersistentData().putDouble("BuffedSukuna", 1);
									}
								}
							}
						}
					}
				}
			}
		}
		if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity) {
			if (!((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex74 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex74);
						return dataIndex74.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 0) {
					if (Math.random() <= 0.5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex75 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex75);
								return dataIndex75.getCompound("ForgeData").getDouble("brokenBrain");
							}
						}.getValue() <= 1) {
							CompoundTag dataIndex79 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex79);
							dataIndex79.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 20)));
							sourceentity.load(dataIndex79);
						} else {
							CompoundTag dataIndex83 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex83);
							dataIndex83.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 19)));
							sourceentity.load(dataIndex83);
						}
					}
				}
			}
		}
	}
}
