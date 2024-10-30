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
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraft.entity.SukunaEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.NanamiKentoEntity;
import net.mcreator.jujutsucraft.entity.MahitoEntity;
import net.mcreator.jujutsucraft.entity.JogoEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.GetoSuguruEntity;
import net.mcreator.jujutsucraft.entity.GetoSuguruCurseUserEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroTojiBugEntity;
import net.mcreator.jujutsucraft.entity.Dagon2Entity;
import net.mcreator.jujutsucraft.entity.ChosoEntity;

import javax.annotation.Nullable;

import java.util.Objects;
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
			if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
				if ((Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof Monster) {
								if (entityiterator instanceof SukunaEntity) {
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
				} else if (sourceentity instanceof FushiguroTojiEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof GetoSuguruEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof GojoSatoruSchoolDaysEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof NanamiKentoEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof MahitoEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:nanami")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof ItadoriYujiShibuyaEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof MahitoEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof ItadoriYujiShibuyaEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof ChosoEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof FushiguroTojiBugEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof Dagon2Entity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof SukunaEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof JogoEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				} else if (sourceentity instanceof OkkotsuYutaEntity) {
					if (sourceentity.getPersistentData().getDouble("Fight") == 0) {
						if (entity instanceof GetoSuguruCurseUserEntity) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:yutavsgeto")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							sourceentity.getPersistentData().putDouble("Fight", 1);
						}
					}
				}
			}
		}
		if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity) {
			if (sourceentity.getPersistentData().getDouble("Tagged") > 0) {
				if (sourceentity.getPersistentData().getDouble("skill") == 0) {
					if (Math.random() <= 0.5) {
						if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
							if (sourceentity.getPersistentData().getDouble("skill_domain") == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("Tagged");
												}
											}.getValue() + Mth.nextInt(RandomSource.create(), 0, 20)));
										} else {
											sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("Tagged");
												}
											}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
										}
									}
								}
							} else {
								sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
									public double getValue() {
										CompoundTag dataIndex = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex);
										return dataIndex.getCompound("ForgeData").getDouble("Tagged");
									}
								}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
							}
						} else {
							sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
								public double getValue() {
									CompoundTag dataIndex = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex);
									return dataIndex.getCompound("ForgeData").getDouble("Tagged");
								}
							}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
						}
					}
				}
			} else {
				ClonesDongProcedure.execute(sourceentity);
				if (sourceentity.getPersistentData().getDouble("skill") == 0) {
					if (Math.random() <= 0.5) {
						if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
							if (sourceentity.getPersistentData().getDouble("skill_domain") == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (Math.random() <= 0.5) {
											if (entityiterator == entity) {
												sourceentity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 20)));
											} else {
												sourceentity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
											}
										} else {
											if (entityiterator == entity) {
												sourceentity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 20)));
											} else {
												sourceentity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
											}
										}
									}
								}
							} else {
								if (Math.random() <= 0.5) {
									sourceentity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
								} else {
									sourceentity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
								}
							}
						} else {
							if (Math.random() <= 0.5) {
								sourceentity.getPersistentData().putDouble("skill", (100 + Mth.nextInt(RandomSource.create(), 0, 19)));
							} else {
								sourceentity.getPersistentData().putDouble("skill", (600 + Mth.nextInt(RandomSource.create(), 0, 19)));
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
				if (sourceentity.getPersistentData().getDouble("skill") == 0) {
					if (Math.random() <= 0.5) {
						if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
							if (sourceentity.getPersistentData().getDouble("skill_domain") == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("Tagged");
												}
											}.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
										} else {
											sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													sourceentity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("Tagged");
												}
											}.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
										}
									}
								}
							} else {
								sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
									public double getValue() {
										CompoundTag dataIndex = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex);
										return dataIndex.getCompound("ForgeData").getDouble("Tagged");
									}
								}.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
							}
						} else {
							sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
								public double getValue() {
									CompoundTag dataIndex = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex);
									return dataIndex.getCompound("ForgeData").getDouble("Tagged");
								}
							}.getValue() + Mth.nextInt(RandomSource.create(), 0, 3)));
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
				if (sourceentity.getPersistentData().getDouble("skill") == 0) {
					if (Math.random() <= 0.5) {
						if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
							if (sourceentity.getPersistentData().getDouble("skill_domain") == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											sourceentity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
										} else {
											sourceentity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
										}
									}
								}
							} else {
								sourceentity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
							}
						} else {
							sourceentity.getPersistentData().putDouble("skill", (100 * 16 + Mth.nextInt(RandomSource.create(), 0, 19)));
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
			if (sourceentity.getPersistentData().getDouble("skill") == 0) {
				if (Math.random() <= 0.5) {
					if (sourceentity.getPersistentData().getDouble("brokenBrain") <= 1) {
						if (sourceentity.getPersistentData().getDouble("Tagged") != 21) {
							if (sourceentity.getPersistentData().getDouble("skill_domain") == 0) {
								{
									final Vec3 _center = new Vec3(x, y, z);
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator == entity) {
											sourceentity.getPersistentData().putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 20)));
										} else {
											sourceentity.getPersistentData().putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 19)));
										}
									}
								}
							} else {
								if (Math.random() <= 0.5) {
									sourceentity.getPersistentData().putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 19)));
								} else {
									sourceentity.getPersistentData().putDouble("skill", (100 * new Object() {
										public double getValue() {
											CompoundTag dataIndex = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex);
											return dataIndex.getCompound("ForgeData").getDouble("Tagged");
										}
									}.getValue() + Mth.nextInt(RandomSource.create(), 0, 19)));
								}
							}
						} else {
							sourceentity.getPersistentData().putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 1, 7)));
						}
					} else {
						sourceentity.getPersistentData().putDouble("skill", (100 * 1 + Mth.nextInt(RandomSource.create(), 0, 19)));
					}
				}
			}
		}
	}
}
