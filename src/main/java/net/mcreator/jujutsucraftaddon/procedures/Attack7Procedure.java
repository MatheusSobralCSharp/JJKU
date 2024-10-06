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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

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
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique")))) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if ((entityiterator.getStringUUID()).equals(new Object() {
							public String getValue() {
								CompoundTag dataIndex48 = new CompoundTag();
								entity.saveWithoutId(dataIndex48);
								return dataIndex48.getCompound("ForgeData").getString("OWNER_UUID");
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
			if (!(sourceentity.getDisplayName().getString()).equals("Hussein Dong")) {
				if (!((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex71 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex71);
							return dataIndex71.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 0) {
						if (Math.random() <= 0.5) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex72 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex72);
									return dataIndex72.getCompound("ForgeData").getDouble("brokenBrain");
								}
							}.getValue() <= 1) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex73 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex73);
										return dataIndex73.getCompound("ForgeData").getDouble("skill_domain");
									}
								}.getValue() == 0) {
									{
										final Vec3 _center = new Vec3(x, y, z);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if (entityiterator == entity) {
												if ((sourceentity.getDisplayName().getString()).contains("Gojo")) {
													CompoundTag dataIndex77 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex77);
													dataIndex77.getCompound("ForgeData").putDouble("skill", (100 * 2 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex77);
												} else if ((sourceentity.getDisplayName().getString()).contains("Choso")) {
													CompoundTag dataIndex80 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex80);
													dataIndex80.getCompound("ForgeData").putDouble("skill", (100 * 10 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex80);
												} else if ((sourceentity.getDisplayName().getString()).contains("Sukuna")) {
													CompoundTag dataIndex83 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex83);
													dataIndex83.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex83);
												} else if ((sourceentity.getDisplayName().getString()).contains("Inumaki")) {
													CompoundTag dataIndex86 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex86);
													dataIndex86.getCompound("ForgeData").putDouble("skill", (100 * 3 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex86);
												} else if ((sourceentity.getDisplayName().getString()).contains("Jogo")) {
													CompoundTag dataIndex89 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex89);
													dataIndex89.getCompound("ForgeData").putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex89);
												} else if ((sourceentity.getDisplayName().getString()).contains("Megumi")) {
													CompoundTag dataIndex92 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex92);
													dataIndex92.getCompound("ForgeData").putDouble("skill", (100 * 6 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex92);
												} else if ((sourceentity.getDisplayName().getString()).contains("Kashimo")) {
													CompoundTag dataIndex95 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex95);
													dataIndex95.getCompound("ForgeData").putDouble("skill", (100 * 7 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex95);
												} else if ((sourceentity.getDisplayName().getString()).contains("Dagon")) {
													CompoundTag dataIndex98 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex98);
													dataIndex98.getCompound("ForgeData").putDouble("skill", (100 * 8 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex98);
												} else if ((sourceentity.getDisplayName().getString()).contains("Dagon")) {
													CompoundTag dataIndex101 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex101);
													dataIndex101.getCompound("ForgeData").putDouble("skill", (100 * 9 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex101);
												} else {
													CompoundTag dataIndex105 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex105);
													dataIndex105.getCompound("ForgeData").putDouble("skill",
															(100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 20)));
													sourceentity.load(dataIndex105);
												}
											} else {
												CompoundTag dataIndex109 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex109);
												dataIndex109.getCompound("ForgeData").putDouble("skill",
														(100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 19)));
												sourceentity.load(dataIndex109);
											}
										}
									}
								} else {
									CompoundTag dataIndex114 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex114);
									dataIndex114.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
											.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 19)));
									sourceentity.load(dataIndex114);
								}
							} else {
								CompoundTag dataIndex118 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex118);
								dataIndex118.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
										.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 19)));
								sourceentity.load(dataIndex118);
							}
						}
					}
				}
			} else {
				ClonesDongProcedure.execute(sourceentity);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex119 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex119);
						return dataIndex119.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 0) {
					if (Math.random() <= 0.5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex120 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex120);
								return dataIndex120.getCompound("ForgeData").getDouble("brokenBrain");
							}
						}.getValue() <= 1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex121 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex121);
									return dataIndex121.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (Math.random() <= 0.5) {
											if (entityiterator == entity) {
												CompoundTag dataIndex124 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex124);
												dataIndex124.getCompound("ForgeData").putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 20)));
												sourceentity.load(dataIndex124);
											} else {
												CompoundTag dataIndex126 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex126);
												dataIndex126.getCompound("ForgeData").putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
												sourceentity.load(dataIndex126);
											}
										} else {
											if (entityiterator == entity) {
												CompoundTag dataIndex129 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex129);
												dataIndex129.getCompound("ForgeData").putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 20)));
												sourceentity.load(dataIndex129);
											} else {
												CompoundTag dataIndex131 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex131);
												dataIndex131.getCompound("ForgeData").putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
												sourceentity.load(dataIndex131);
											}
										}
									}
								}
							} else {
								if (Math.random() <= 0.5) {
									CompoundTag dataIndex134 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex134);
									dataIndex134.getCompound("ForgeData").putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
									sourceentity.load(dataIndex134);
								} else {
									CompoundTag dataIndex136 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex136);
									dataIndex136.getCompound("ForgeData").putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
									sourceentity.load(dataIndex136);
								}
							}
						} else {
							if (Math.random() <= 0.5) {
								CompoundTag dataIndex138 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex138);
								dataIndex138.getCompound("ForgeData").putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
								sourceentity.load(dataIndex138);
							} else {
								CompoundTag dataIndex140 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex140);
								dataIndex140.getCompound("ForgeData").putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
								sourceentity.load(dataIndex140);
							}
						}
					}
				}
			}
		}
		if (sourceentity.getPersistentData().getDouble("NoAttac1") == 1) {
			sourceentity.getPersistentData().putDouble("cnt_target", 0);
		}
		TargetProcedure.execute(world, x, y, z, entity, sourceentity);
		if (sourceentity instanceof UiUiEntity) {
			if (!((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex146 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex146);
						return dataIndex146.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 0) {
					if (Math.random() <= 0.5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex147 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex147);
								return dataIndex147.getCompound("ForgeData").getDouble("brokenBrain");
							}
						}.getValue() <= 1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex148 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex148);
									return dataIndex148.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											CompoundTag dataIndex153 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex153);
											dataIndex153.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
													.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 3)));
											sourceentity.load(dataIndex153);
										} else {
											CompoundTag dataIndex157 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex157);
											dataIndex157.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
													.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 3)));
											sourceentity.load(dataIndex157);
										}
									}
								}
							} else {
								CompoundTag dataIndex162 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex162);
								dataIndex162.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
										.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 3)));
								sourceentity.load(dataIndex162);
							}
						} else {
							CompoundTag dataIndex166 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex166);
							dataIndex166.getCompound("ForgeData").putDouble("skill", (100 * ((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
									.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 + Mth.nextInt(RandomSource.create(), 0, 3)));
							sourceentity.load(dataIndex166);
						}
					}
				}
			}
		}
		if (sourceentity instanceof Shadow1Entity || sourceentity instanceof IgrisEntity) {
			if (!((sourceentity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) < 10) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 10, false, false));
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex173 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex173);
						return dataIndex173.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 0) {
					if (Math.random() <= 0.5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex174 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex174);
								return dataIndex174.getCompound("ForgeData").getDouble("brokenBrain");
							}
						}.getValue() <= 1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex175 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex175);
									return dataIndex175.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											CompoundTag dataIndex178 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex178);
											dataIndex178.getCompound("ForgeData").putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
											sourceentity.load(dataIndex178);
										} else {
											CompoundTag dataIndex180 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex180);
											dataIndex180.getCompound("ForgeData").putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
											sourceentity.load(dataIndex180);
										}
									}
								}
							} else {
								CompoundTag dataIndex183 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex183);
								dataIndex183.getCompound("ForgeData").putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
								sourceentity.load(dataIndex183);
							}
						} else {
							CompoundTag dataIndex185 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex185);
							dataIndex185.getCompound("ForgeData").putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
							sourceentity.load(dataIndex185);
						}
					}
				}
			}
		}
		if (sourceentity instanceof SukunaREntity) {
			if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) < 10) {
				if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 10, false, false));
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex189 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex189);
					return dataIndex189.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 0) {
				if (Math.random() <= 0.5) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex190 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex190);
							return dataIndex190.getCompound("ForgeData").getDouble("brokenBrain");
						}
					}.getValue() <= 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex191 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex191);
								return dataIndex191.getCompound("ForgeData").getDouble("Tagged");
							}
						}.getValue() != 21) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex192 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex192);
									return dataIndex192.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											CompoundTag dataIndex195 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex195);
											dataIndex195.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 20)));
											sourceentity.load(dataIndex195);
										} else {
											CompoundTag dataIndex198 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex198);
											dataIndex198.getCompound("ForgeData").putDouble("skill", (100 * new Object() {
												public double getValue() {
													CompoundTag dataIndex196 = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex196);
													return dataIndex196.getCompound("ForgeData").getDouble("Tagged");
												}
											}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
											sourceentity.load(dataIndex198);
										}
									}
								}
							} else {
								if (Math.random() <= 0.5) {
									CompoundTag dataIndex201 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex201);
									dataIndex201.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 19)));
									sourceentity.load(dataIndex201);
								} else {
									CompoundTag dataIndex204 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex204);
									dataIndex204.getCompound("ForgeData").putDouble("skill", (100 * new Object() {
										public double getValue() {
											CompoundTag dataIndex202 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex202);
											return dataIndex202.getCompound("ForgeData").getDouble("Tagged");
										}
									}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
									sourceentity.load(dataIndex204);
								}
							}
						} else {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex205 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex205);
									return dataIndex205.getCompound("ForgeData").getDouble("skill_domain");
								}
							}.getValue() == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											CompoundTag dataIndex208 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex208);
											dataIndex208.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 20)));
											sourceentity.load(dataIndex208);
										} else {
											CompoundTag dataIndex210 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex210);
											dataIndex210.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 1, 7)));
											sourceentity.load(dataIndex210);
										}
									}
								}
							} else {
								CompoundTag dataIndex213 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex213);
								dataIndex213.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 7)));
								sourceentity.load(dataIndex213);
							}
						}
					} else {
						CompoundTag dataIndex215 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex215);
						dataIndex215.getCompound("ForgeData").putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 19)));
						sourceentity.load(dataIndex215);
					}
				}
			}
		}
	}
}
