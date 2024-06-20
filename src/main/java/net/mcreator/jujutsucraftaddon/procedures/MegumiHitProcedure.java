package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class MegumiHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (Math.random() <= 0.02) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex0 = new CompoundTag();
					entity.saveWithoutId(dataIndex0);
					return dataIndex0.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
				}
			}.getValue() != -2) {
				if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mahoraga_wheel_helmet")) {
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ())), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						CompoundTag dataIndex1 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex1);
						dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
						(entitytospawn).load(dataIndex1);
						CompoundTag dataIndex3 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex3);
						dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
							public double getValue() {
								CompoundTag dataIndex2 = new CompoundTag();
								entity.saveWithoutId(dataIndex2);
								return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex3);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
						((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("MAHORAGA!!!"), false);
					}
				}
			}
		}
		if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Divine Dog Black")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_BLACK.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Gyokuken.."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Merged Beast Agito")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.MERGED_BEAST_AGITO.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Nue Kon - Kango Ju Agito..."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Piercing Ox")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.PIERCING_OX.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Kangyu.."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Toad")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.TOAD.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Gama.."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Rabbit Escape")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.RABBIT_ESCAPE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Datto"), false);
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Tiger Funeral")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.TIGER_FUNERAL.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(" Koso!"), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Divine Dog White")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_WHITE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Gyokuken.."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Divine Dog Totality")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.DIVINE_DOG_TOTALITY.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Gyokuken Kon.."), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Nue")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.NUE.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(6);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("NUE"), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Great Serpent")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.GREAT_SERPENT.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 60, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(2);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Orochi"), false);
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Max Elephant")) {
			if (Math.random() <= 0.03) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.MAX_ELEPHANT.get().spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY() + 10), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex1 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex1);
					dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex1);
					CompoundTag dataIndex3 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex3);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MANIFESTATION.get(), 200, 1));
					((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("BANSHO!"), false);
				}
			}
		}
	}
}
