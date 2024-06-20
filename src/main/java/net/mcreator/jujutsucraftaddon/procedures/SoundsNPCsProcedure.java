package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

import java.util.List;
import java.util.Comparator;

public class SoundsNPCsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MOB_OSTS) == true) {
			if (sourceentity instanceof Monster) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
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
					}
					if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex9 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex9);
								return dataIndex9.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex12 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex12);
								dataIndex12.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex12);
							}
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex13 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex13);
								return dataIndex13.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex16 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex16);
								dataIndex16.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex16);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex18 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex18);
								return dataIndex18.getCompound("ForgeData").getDouble("Fight");
							}
						}.getValue() == 0) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:judas")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:judas")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								CompoundTag dataIndex21 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex21);
								dataIndex21.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex21);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:nanami_kento")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex23 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex23);
								return dataIndex23.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex26 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex26);
								dataIndex26.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex26);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex28 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex28);
								return dataIndex28.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex31 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex31);
								dataIndex31.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex31);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex33 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex33);
								return dataIndex33.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex36 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex36);
								dataIndex36.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex36);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:fushiguro_toji_bug")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex38 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex38);
								return dataIndex38.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex41 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex41);
								dataIndex41.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex41);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:sukuna")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex43 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex43);
								return dataIndex43.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex46 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex46);
								dataIndex46.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex46);
							}
						}
					} else if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:okkotsu_yuta")) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex48 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex48);
								return dataIndex48.getCompound("ForgeData").getDouble("Fight");
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
								CompoundTag dataIndex51 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex51);
								dataIndex51.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex51);
							}
						}
					}
				}
			}
		}
	}
}
