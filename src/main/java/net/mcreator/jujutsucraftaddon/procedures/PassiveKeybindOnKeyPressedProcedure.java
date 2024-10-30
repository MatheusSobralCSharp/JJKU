package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.DismantleVariantEntity;
import net.mcreator.jujutsucraftaddon.entity.DismantleEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

import java.util.List;
import java.util.Comparator;

public class PassiveKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
			if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Dismantle")) {
				if (entity.onGround()) {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
						if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
								&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()) {
							if (Math.random() < (1) / ((float) 25)) {
								int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
								int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
								int yIterationsSphere = verticalRadiusSphere;
								for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
									for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
										for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
											double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
													+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
											if (distanceSq <= 1.0) {
												if (world instanceof ServerLevel projectileLevel) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
															AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															entityToSpawn.setKnockback(knockback);
															entityToSpawn.setSilent(true);
															entityToSpawn.setPierceLevel(piercing);
															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity,
															(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
													_entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
													_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											}
										}
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
								{
									double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
									entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PlayerCursePower = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
												AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												entityToSpawn.setPierceLevel(piercing);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity,
												(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
								{
									double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
									entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PlayerCursePower = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				} else {
					if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
						if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
								&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_5"))).isDone()) {
							if (Math.random() < (1) / ((float) 25)) {
								int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
								int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel) - 1;
								int yIterationsSphere = verticalRadiusSphere;
								for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
									for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
										for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
											double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
													+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
											if (distanceSq <= 1.0) {
												if (world instanceof ServerLevel projectileLevel) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
															AbstractArrow entityToSpawn = new DismantleVariantEntity(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), level);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															entityToSpawn.setKnockback(knockback);
															entityToSpawn.setSilent(true);
															entityToSpawn.setPierceLevel(piercing);
															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity,
															(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
													_entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
													_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
													} else {
														_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
													}
												}
											}
										}
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
								{
									double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
									entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PlayerCursePower = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
												AbstractArrow entityToSpawn = new DismantleVariantEntity(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), level);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												entityToSpawn.setKnockback(knockback);
												entityToSpawn.setSilent(true);
												entityToSpawn.setPierceLevel(piercing);
												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity,
												(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 10, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
								{
									double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
									entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.PlayerCursePower = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Cleave")) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 500) {
					if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
							&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
						int horizontalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
						int verticalRadiusSphere = (int) ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel * 2) - 1;
						int yIterationsSphere = verticalRadiusSphere;
						for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
							for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
								for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
									double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
											+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
									if (distanceSq <= 1.0) {
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
													AbstractArrow entityToSpawn = new DismantleVariantEntity(JujutsucraftaddonModEntities.DISMANTLE_VARIANT.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													entityToSpawn.setPierceLevel(piercing);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity,
													(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
											_entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
											_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
										if (world instanceof ServerLevel projectileLevel) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
													AbstractArrow entityToSpawn = new DismantleEntity(JujutsucraftaddonModEntities.DISMANTLE.get(), level);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													entityToSpawn.setKnockback(knockback);
													entityToSpawn.setSilent(true);
													entityToSpawn.setPierceLevel(piercing);
													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity,
													(float) (10 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel), 3, (byte) 1);
											_entityToSpawn.setPos(x + xi, entity.getEyeY(), z + zi);
											_entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 10, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kai")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
										if (world instanceof Level _level) {
											if (!_level.isClientSide()) {
												_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1);
											} else {
												_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dismantle")), SoundSource.NEUTRAL, 1, 1, false);
											}
										}
									}
								}
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION.get(), 1, 1, false, false));
						{
							double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 500);
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerCursePower = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
					{
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						dataIndex.getCompound("ForgeData").putDouble("skill", 205);
						entity.load(dataIndex);
					}
					{
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
						entity.load(dataIndex);
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
			if (entity.isShiftKeyDown()) {
				{
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					dataIndex.getCompound("ForgeData").putDouble("skill", 604);
					entity.load(dataIndex);
				}
				{
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
					entity.load(dataIndex);
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
					}
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((new Object() {
							public String getValue() {
								CompoundTag dataIndex = new CompoundTag();
								entityiterator.saveWithoutId(dataIndex);
								return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
							}
						}.getValue()).equals(entity.getStringUUID())) {
							if (entityiterator.getPersistentData().getDouble("NoAttac1") == 0) {
								entityiterator.getPersistentData().putDouble("NoAttac1", 1);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.AI.get(), -1, 1, false, false));
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Disabled Shikigami Attack"), false);
							} else if (entityiterator.getPersistentData().getDouble("NoAttac1") == 1) {
								entityiterator.getPersistentData().putDouble("NoAttac1", 0);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(JujutsucraftaddonModMobEffects.AI.get());
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Enabled Shikigami Attack"), false);
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 1006);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
					public double getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue() + 1));
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
					public double getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getDouble("cnt1");
					}
				}.getValue() + 1));
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 1810);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 29) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 2905);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 2005);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 1905);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("cnt5", (new Object() {
					public double getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue() + 1));
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("cnt1", (new Object() {
					public double getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getDouble("cnt1");
					}
				}.getValue() + 1));
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 1305);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 910);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 3005);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("skill", 2705);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex);
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
			if (!(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder Blitz")
					|| ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder God"))) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
					{
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						dataIndex.getCompound("ForgeData").putDouble("skill", 705);
						entity.load(dataIndex);
					}
					{
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						dataIndex.getCompound("ForgeData").putDouble("PRESS_Z", 1);
						entity.load(dataIndex);
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
						}
					}
				}
			}
			if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder Blitz")) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 50) {
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
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
											{
												Entity _ent = entity;
												_ent.teleportTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()));
												if (_ent instanceof ServerPlayer _serverPlayer)
													_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
											}
											_serverLevel.addFreshEntity(entitytospawn);
										}
									}
									{
										double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 50);
										entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.PlayerCursePower = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							}
						}
					}
				}
			} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder God")) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 200) {
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
									if ((entityiterator instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) == false) {
										JujutsucraftaddonMod.queueServerWork(20, () -> {
											for (int index0 = 0; index0 < 10; index0++) {
												if (world instanceof ServerLevel _level)
													_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 4, 0, 0, 0, 1);
												if (world instanceof ServerLevel _serverLevel) {
													Entity entitytospawn = EntityType.LIGHTNING_BOLT.spawn(_serverLevel,
															BlockPos.containing((entityiterator.getX() + Mth.nextInt(RandomSource.create(), -1, 1)), (entityiterator.getY()), (entityiterator.getZ() + Mth.nextInt(RandomSource.create(), -1, 1))),
															MobSpawnType.MOB_SUMMONED);
													if (entitytospawn != null) {
														entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
													}
												}
											}
										});
										entityiterator.hurt(
												new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 40);
										{
											double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 200);
											entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.PlayerCursePower = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										break;
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
