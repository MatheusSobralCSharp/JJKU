package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.ErroEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraftaddon.entity.CentipedeEntity;

import java.util.List;
import java.util.Comparator;

public class ClonesAIGeneralProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
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
		} else if (sourceentity instanceof CentipedeEntity) {
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
											sourceentity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
										} else {
											sourceentity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
										}
									}
								}
							} else {
								sourceentity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
							}
						} else {
							sourceentity.getPersistentData().putDouble("skill", (100 * 4 + Mth.nextInt(RandomSource.create(), 0, 19)));
						}
					}
				}
			}
		}
		if (sourceentity instanceof ErroEntity) {
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
