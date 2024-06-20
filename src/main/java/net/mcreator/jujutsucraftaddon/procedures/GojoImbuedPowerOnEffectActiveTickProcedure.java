package net.mcreator.jujutsucraftaddon.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class GojoImbuedPowerOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double timer2 = 0;
		double sev = 0;
		double sevx = 0;
		double sevy = 0;
		double sevz = 0;
		double tedx = 0;
		double tedy = 0;
		double tedz = 0;
		double sevx2 = 0;
		double sevy2 = 0;
		double sevz2 = 0;
		double a = 0;
		double ted = 0;
		double sev2 = 0;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
						&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("PRESS_Z");
						}
					}.getValue() == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex3 = new CompoundTag();
								entity.saveWithoutId(dataIndex3);
								return dataIndex3.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 207) {
							if (entity.isShiftKeyDown()) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex5 = new CompoundTag();
										entity.saveWithoutId(dataIndex5);
										return dataIndex5.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() >= 1) {
									{
										final Vec3 _center = new Vec3(x, y, z);
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
												.toList();
										for (Entity entityiterator : _entfound) {
											if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:red")) {
												if ((new Object() {
													public String getValue() {
														CompoundTag dataIndex7 = new CompoundTag();
														entityiterator.saveWithoutId(dataIndex7);
														return dataIndex7.getCompound("ForgeData").getString("OWNER_UUID");
													}
												}.getValue()).equals(entity.getStringUUID())) {
													if (!(entityiterator instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.RED_EFFECT.get()))) {
														if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
															_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RED_EFFECT.get(), 400, 1, false, false));
													}
												}
											}
										}
									}
								}
							}
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex12 = new CompoundTag();
								entity.saveWithoutId(dataIndex12);
								return dataIndex12.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue() == 215) {
							if (entity.isShiftKeyDown()) {
								if (new Object() {
									double convert(String s) {
										try {
											return Double.parseDouble(s.trim());
										} catch (Exception e) {
										}
										return 0;
									}
								}.convert(ReturnlevelProcedure.execute(world, entity)) >= 30000) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex14 = new CompoundTag();
											entity.saveWithoutId(dataIndex14);
											return dataIndex14.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() >= 0) {
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
																_ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s at @s unless entity @e[nbt={ForgeData:{red:2d}},distance=..50] run summon jujutsucraftaddon:red_entity ~ ~15 ~ {ForgeData:{red:2.0d}}");
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.getServer() != null) {
												_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
														_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
														"execute as @s run effect clear @s jujutsucraft:cursed_technique");
											}
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (entity instanceof ServerPlayer _plr17 && _plr17.level() instanceof ServerLevel
						&& _plr17.getAdvancements().getOrStartProgress(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()) {
					if (!entity.isShiftKeyDown()) {
						if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Hollow Purple")
								&& ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
										.equals("Unlimited Hollow Purple") == false) {
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerSelectCurseTechniqueName = "200% Murasaki";
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity.isShiftKeyDown()) {
						if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Hollow Purple")
								|| ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("200% Murasaki")) {
							if (new Object() {
								double convert(String s) {
									try {
										return Double.parseDouble(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert(ReturnlevelProcedure.execute(world, entity)) >= 22000) {
								entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.PlayerSelectCurseTechniqueName = "Unlimited Hollow Purple";
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
					if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Unlimited Hollow Purple")) {
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null && !animation.isActive()) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
								}
							}
						}
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
							if (entity.isShiftKeyDown()) {
								{
									double _setval = 4;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.AnimationDefense = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:aka2")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:aka2")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								{
									Entity _ent = entity;
									_ent.teleportTo(x, (y + 15), z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(x, (y + 15), z, _ent.getYRot(), _ent.getXRot());
								}
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 1, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 600, 1, false, false));
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s at @s unless entity @e[nbt={ForgeData:{blue:1d}},distance=..50] run summon jujutsucraftaddon:blue_entity ~-30 ~2 ~ {ForgeData:{blue:1.0d}}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s at @s unless entity @e[nbt={ForgeData:{red:2d}},distance=..50] run summon jujutsucraftaddon:red_entity ~30 ~2 ~ {ForgeData:{red:2.0d}}");
									}
								}
								{
									double _setval = 0;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.OutputLevel = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect clear @s jujutsucraft:cursed_technique");
									}
								}
							}
						}
					}
					if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("200% Murasaki")) {
						if (entity.onGround()) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex40 = new CompoundTag();
									entity.saveWithoutId(dataIndex40);
									return dataIndex40.getCompound("ForgeData").getDouble("skill");
								}
							}.getValue() == 215) {
								if (!entity.isShiftKeyDown()) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex42 = new CompoundTag();
											entity.saveWithoutId(dataIndex42);
											return dataIndex42.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() == 1) {
										if (!(entity instanceof LivingEntity _livEnt43 && _livEnt43.hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()))) {
											{
												double _setval = 1;
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Murasaki = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											{
												double _setval = 1;
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Murasaki = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
											if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
												_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), 400, 1, false, false));
										}
									}
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex45 = new CompoundTag();
											entity.saveWithoutId(dataIndex45);
											return dataIndex45.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() > 1 && new Object() {
										public double getValue() {
											CompoundTag dataIndex46 = new CompoundTag();
											entity.saveWithoutId(dataIndex46);
											return dataIndex46.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() < 3) {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.WITCH, x, (y + 1), z, 5, 1, 1, 1, 0.1);
									}
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex48 = new CompoundTag();
											entity.saveWithoutId(dataIndex48);
											return dataIndex48.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() > 3 && new Object() {
										public double getValue() {
											CompoundTag dataIndex49 = new CompoundTag();
											entity.saveWithoutId(dataIndex49);
											return dataIndex49.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() < 5) {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.WITCH, x, (y + 1), z, 10, 1, 1, 1, 0.1);
									}
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex51 = new CompoundTag();
											entity.saveWithoutId(dataIndex51);
											return dataIndex51.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() > 5) {
										if (world instanceof ServerLevel _level)
											_level.sendParticles(ParticleTypes.WITCH, x, (y + 1), z, 15, 1, 1, 1, 0.1);
									}
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex53 = new CompoundTag();
											entity.saveWithoutId(dataIndex53);
											return dataIndex53.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() > 5) {
										if (new Object() {
											public double getValue() {
												CompoundTag dataIndex54 = new CompoundTag();
												entity.saveWithoutId(dataIndex54);
												return dataIndex54.getCompound("ForgeData").getDouble("cnt6");
											}
										}.getValue() <= 50) {
											CompoundTag dataIndex56 = new CompoundTag();
											entity.saveWithoutId(dataIndex56);
											dataIndex56.getCompound("ForgeData").putDouble("cnt6", (new Object() {
												public double getValue() {
													CompoundTag dataIndex55 = new CompoundTag();
													entity.saveWithoutId(dataIndex55);
													return dataIndex55.getCompound("ForgeData").getDouble("cnt6");
												}
											}.getValue() + 1));
											entity.load(dataIndex56);
											CompoundTag dataIndex58 = new CompoundTag();
											entity.saveWithoutId(dataIndex58);
											dataIndex58.getCompound("ForgeData").putDouble("Range", (new Object() {
												public double getValue() {
													CompoundTag dataIndex57 = new CompoundTag();
													entity.saveWithoutId(dataIndex57);
													return dataIndex57.getCompound("ForgeData").getDouble("Range");
												}
											}.getValue() + 1));
											entity.load(dataIndex58);
										}
									}
								}
							}
						}
					}
				}
				if (entity instanceof ServerPlayer _plr59 && _plr59.level() instanceof ServerLevel
						&& _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
					if (entity.isShiftKeyDown()) {
						if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Cursed Technique Lapse: Blue")) {
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerSelectCurseTechniqueName = "Maximum Cursed Energy Output: Blue";
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		}
	}
}
