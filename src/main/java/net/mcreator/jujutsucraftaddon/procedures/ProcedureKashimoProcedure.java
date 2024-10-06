package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

import java.util.List;
import java.util.Comparator;

public class ProcedureKashimoProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (entity.isShiftKeyDown()) {
					if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
							.equals(Component.translatable("jujutsu.technique.kashimo1").getString())) {
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerSelectCurseTechniqueName = "Thunder Storm";
							capability.syncPlayerVariables(entity);
						});
					} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
							.equals(Component.translatable("jujutsu.technique.attack2").getString())) {
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerSelectCurseTechniqueName = "Kaminari";
							capability.syncPlayerVariables(entity);
						});
					} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
							.equals(Component.translatable("jujutsu.technique.attack1").getString())) {
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerSelectCurseTechniqueName = "Speed Blitz";
							capability.syncPlayerVariables(entity);
						});
					} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
							.equals(Component.translatable("jujutsu.technique.attack3").getString())) {
						entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerSelectCurseTechniqueName = "Genju Kohaku";
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Thunder Storm")) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						{
							final Vec3 _center = new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (!(entity == entityiterator)) {
									if (world instanceof ServerLevel _serverLevel) {
										Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
												MobSpawnType.MOB_SUMMONED);
										if (entitytospawn != null) {
											entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
											((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
														entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
											_serverLevel.addFreshEntity(entitytospawn);
										}
									}
									if (world instanceof ServerLevel _serverLevel) {
										Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
												MobSpawnType.MOB_SUMMONED);
										if (entitytospawn != null) {
											entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
											((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
														entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
											_serverLevel.addFreshEntity(entitytospawn);
										}
									}
									if (world instanceof ServerLevel _serverLevel) {
										Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
												MobSpawnType.MOB_SUMMONED);
										if (entitytospawn != null) {
											entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
											((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
														entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
											if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
											_serverLevel.addFreshEntity(entitytospawn);
										}
									}
								}
							}
						}
					}
				} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Kaminari")) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex62 = new CompoundTag();
								entity.saveWithoutId(dataIndex62);
								return dataIndex62.getCompound("ForgeData").getDouble("cnt1");
							}
						}.getValue() == 1) {
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										if (world instanceof ServerLevel _level) {
											LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
											entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ())));;
											_level.addFreshEntity(entityToSpawn);
										}
										if (world instanceof ServerLevel _serverLevel) {
											Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
													MobSpawnType.MOB_SUMMONED);
											if (entitytospawn != null) {
												entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
												((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
															entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
												_serverLevel.addFreshEntity(entitytospawn);
											}
										}
									}
								}
							}
						}
					}
				} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Speed Blitz")) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex87 = new CompoundTag();
								entity.saveWithoutId(dataIndex87);
								return dataIndex87.getCompound("ForgeData").getDouble("cnt1");
							}
						}.getValue() == 1) {
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 254, false, false));
										{
											Entity _ent = entity;
											_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
										}
										entityiterator.hurt(
												new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 25);
										if (world instanceof ServerLevel _serverLevel) {
											Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
													MobSpawnType.MOB_SUMMONED);
											if (entitytospawn != null) {
												entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
												((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
															entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
												_serverLevel.addFreshEntity(entitytospawn);
											}
										}
									}
								}
							}
						}
					}
				} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Genju Kohaku")) {
					if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex115 = new CompoundTag();
								entity.saveWithoutId(dataIndex115);
								return dataIndex115.getCompound("ForgeData").getDouble("cnt1");
							}
						}.getValue() == 1) {
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										{
											Entity _ent = entity;
											_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
											if (_ent instanceof ServerPlayer _serverPlayer)
												_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
										}
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 254, false, false));
										if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 254, false, false));
										if (world instanceof ServerLevel _serverLevel) {
											Entity entitytospawn = JujutsucraftModEntities.THUNDER_IMPACT.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
													MobSpawnType.MOB_SUMMONED);
											if (entitytospawn != null) {
												entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
												((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
															entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
												_serverLevel.addFreshEntity(entitytospawn);
											}
										}
										if (world instanceof ServerLevel _serverLevel) {
											Entity entitytospawn = JujutsucraftModEntities.ENTITY_BLACK_FLASH.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
													MobSpawnType.MOB_SUMMONED);
											if (entitytospawn != null) {
												entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
												((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(5);
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1,
															entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));
												if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 2, false, false));
												entityiterator.hurt(
														new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
														50);
												_serverLevel.addFreshEntity(entitytospawn);
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
}
