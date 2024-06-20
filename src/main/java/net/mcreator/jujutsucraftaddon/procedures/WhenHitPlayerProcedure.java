package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class WhenHitPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 22) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
						Mth.nextInt(RandomSource.create(), 1, 40));
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 35) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (!(new Object() {
					public String getValue() {
						CompoundTag dataIndex5 = new CompoundTag();
						entity.saveWithoutId(dataIndex5);
						return dataIndex5.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID())) {
					WhenHitJunpeiProcedure.execute(world, entity, sourceentity);
				} else if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						entity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex9 = new CompoundTag();
						entity.saveWithoutId(dataIndex9);
						return dataIndex9.getCompound("ForgeData").getBoolean("Buffed");
					}
				}.getValue()) == false) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 2));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex16 = new CompoundTag();
					entity.saveWithoutId(dataIndex16);
					dataIndex16.getCompound("ForgeData").putBoolean("Buffed", true);
					entity.load(dataIndex16);
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
			TodoHitProcedureProcedure.execute(world, x, y, z, sourceentity);
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (sourceentity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
					&& _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLUE_PUNCH.get()), (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.GOJO_IMBUED_THUNDER.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)),
								(entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0,
								(Mth.nextDouble(RandomSource.create(), 0, 1)));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 24));
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
							Mth.nextInt(RandomSource.create(), 1, 40));
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
					&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0.5, 2)),
							(entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0.5, 2)),
							(entity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 0.1);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:death_painting_blood 10 1 false");
					}
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 150);
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 14) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (Math.random() <= 0.005) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run jjc_cursepower -1 @s");
						}
					}
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (!((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:garuda") && (new Object() {
					public String getValue() {
						CompoundTag dataIndex65 = new CompoundTag();
						entity.saveWithoutId(dataIndex65);
						return dataIndex65.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID()))) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.TSUKUMO_PUNCH.get()), (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
							(float) Mth.nextDouble(RandomSource.create(), 0, 20));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.TSUKUMO_PUNCH.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)),
								(entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0, (Mth.nextDouble(RandomSource.create(), 0, 1)));
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:garuda") && (new Object() {
					public String getValue() {
						CompoundTag dataIndex85 = new CompoundTag();
						entity.saveWithoutId(dataIndex85);
						return dataIndex85.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex87 = new CompoundTag();
						entity.saveWithoutId(dataIndex87);
						return dataIndex87.getCompound("ForgeData").getBoolean("Buffed");
					}
				}.getValue()) == false) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 2));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex94 = new CompoundTag();
					entity.saveWithoutId(dataIndex94);
					dataIndex94.getCompound("ForgeData").putBoolean("Buffed", true);
					entity.load(dataIndex94);
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.ICE.get()), (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.ICE.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)),
							(entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0, (Mth.nextDouble(RandomSource.create(), 0, 1)));
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
						(float) Mth.nextDouble(RandomSource.create(), 0, 20));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1, false, false));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_freeze")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 12) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION_EMITTER, (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)),
							(entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0, (Mth.nextDouble(RandomSource.create(), 0, 1)));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.EXPLOSION, (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
				if (Math.random() <= 0.01) {
					if (world instanceof Level _level && !_level.isClientSide())
						_level.explode(null, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, Level.ExplosionInteraction.NONE);
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 8) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WATER.get()), (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WATER.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)),
							(entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0, (Mth.nextDouble(RandomSource.create(), 0, 1)));
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
						(float) Mth.nextDouble(RandomSource.create(), 0, 20));
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.DROWN)), (float) Mth.nextDouble(RandomSource.create(), 0, 20));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music.under_water")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("music.under_water")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:transfigured_human_3") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:transfigured_human_2")
						|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:polymorphic_soul_isomer")
						|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:transfigured_human_1")) && (new Object() {
							public String getValue() {
								CompoundTag dataIndex162 = new CompoundTag();
								entity.saveWithoutId(dataIndex162);
								return dataIndex162.getCompound("ForgeData").getString("OWNER_UUID");
							}
						}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex164 = new CompoundTag();
								entity.saveWithoutId(dataIndex164);
								return dataIndex164.getCompound("ForgeData").getBoolean("Buffed");
							}
						}.getValue()) == false) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 0.5));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 4));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
								(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1), false, false));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex173 = new CompoundTag();
					entity.saveWithoutId(dataIndex173);
					dataIndex173.getCompound("ForgeData").putBoolean("Buffed", true);
					entity.load(dataIndex173);
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (!(((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika_2")) && (new Object() {
					public String getValue() {
						CompoundTag dataIndex177 = new CompoundTag();
						entity.saveWithoutId(dataIndex177);
						return dataIndex177.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID()))) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU_RING.get()), (entity.getX()), (entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ()), 1, 0, 0, 0, 0.1);
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSED_POWER_OKKOTSU_RING.get()), (entity.getX() + Mth.nextDouble(RandomSource.create(), 0, 1)),
								(entity.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)), (entity.getZ() + Mth.nextDouble(RandomSource.create(), 0, 1)), (int) Mth.nextDouble(RandomSource.create(), 0, 4), 0, 0, 0,
								(Mth.nextDouble(RandomSource.create(), 0, 1)));
				} else if (((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:rika_2")) && (new Object() {
					public String getValue() {
						CompoundTag dataIndex195 = new CompoundTag();
						entity.saveWithoutId(dataIndex195);
						return dataIndex195.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex197 = new CompoundTag();
						entity.saveWithoutId(dataIndex197);
						return dataIndex197.getCompound("ForgeData").getBoolean("Buffed");
					}
				}.getValue()) == false) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 2));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2.5));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).locker == 1) {
						CompoundTag dataIndex206 = new CompoundTag();
						entity.saveWithoutId(dataIndex206);
						dataIndex206.getCompound("ForgeData").putBoolean("Buffed2", true);
						entity.load(dataIndex206);
					}
					CompoundTag dataIndex207 = new CompoundTag();
					entity.saveWithoutId(dataIndex207);
					dataIndex207.getCompound("ForgeData").putBoolean("Buffed", true);
					entity.load(dataIndex207);
				}
			}
		} else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
			if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (Math.random() <= 0.1) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:projection_sorcery 1 1 true");
						}
					}
				}
			}
		}
	}
}
