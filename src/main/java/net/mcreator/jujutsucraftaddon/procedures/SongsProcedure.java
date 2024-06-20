package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class SongsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1
				&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18
						|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru"))) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("Fight");
				}
			}.getValue() == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:getovstoji")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				CompoundTag dataIndex5 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex5);
				dataIndex5.getCompound("ForgeData").putDouble("Fight", 1);
				sourceentity.load(dataIndex5);
			}
		} else {
			if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2
					&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1
							|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro"))
					|| (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1
							&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2
									|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru"))) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex12 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex12);
						return dataIndex12.getCompound("ForgeData").getDouble("Fight");
					}
				}.getValue() == 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:judas")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:judas")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					CompoundTag dataIndex14 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex14);
					dataIndex14.getCompound("ForgeData").putDouble("Fight", 1);
					sourceentity.load(dataIndex14);
				}
			} else {
				if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21
						&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10
								|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:choso"))) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex18 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex18);
							return dataIndex18.getCompound("ForgeData").getDouble("Fight");
						}
					}.getValue() == 0) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:chosovsyuuuji")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						CompoundTag dataIndex20 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex20);
						dataIndex20.getCompound("ForgeData").putDouble("Fight", 1);
						sourceentity.load(dataIndex20);
					}
				} else {
					if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1
							&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4
									|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:jogo"))) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex24 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex24);
								return dataIndex24.getCompound("ForgeData").getDouble("Fight");
							}
						}.getValue() == 0) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavsjogo")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							CompoundTag dataIndex26 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex26);
							dataIndex26.getCompound("ForgeData").putDouble("Fight", 1);
							sourceentity.load(dataIndex26);
						}
					} else {
						if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1
								&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10
										|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2"))) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex30 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex30);
									return dataIndex30.getCompound("ForgeData").getDouble("Fight");
								}
							}.getValue() == 0) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:tojivsdagonvsyujivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								CompoundTag dataIndex32 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex32);
								dataIndex32.getCompound("ForgeData").putDouble("Fight", 1);
								sourceentity.load(dataIndex32);
							}
						} else {
							if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1
									&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2
											|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru"))) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex36 = new CompoundTag();
										sourceentity.saveWithoutId(dataIndex36);
										return dataIndex36.getCompound("ForgeData").getDouble("Fight");
									}
								}.getValue() == 0) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gojovstoji")), SoundSource.NEUTRAL, 1, 1, false);
										}
									}
									CompoundTag dataIndex38 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex38);
									dataIndex38.getCompound("ForgeData").putDouble("Fight", 1);
									sourceentity.load(dataIndex38);
								}
							} else {
								if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5
										&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18
												|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru_curse_user"))) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex42 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex42);
											return dataIndex42.getCompound("ForgeData").getDouble("Fight");
										}
									}.getValue() == 0) {
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
								} else {
									if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21
											&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15
													|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito"))) {
										if (new Object() {
											public double getValue() {
												CompoundTag dataIndex48 = new CompoundTag();
												sourceentity.saveWithoutId(dataIndex48);
												return dataIndex48.getCompound("ForgeData").getDouble("Fight");
											}
										}.getValue() == 0) {
											if (world instanceof Level _level) {
												if (!_level.isClientSide()) {
													_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1);
												} else {
													_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:itadorivsmahito")), SoundSource.NEUTRAL, 1, 1, false);
												}
											}
											CompoundTag dataIndex50 = new CompoundTag();
											sourceentity.saveWithoutId(dataIndex50);
											dataIndex50.getCompound("ForgeData").putDouble("Fight", 1);
											sourceentity.load(dataIndex50);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
