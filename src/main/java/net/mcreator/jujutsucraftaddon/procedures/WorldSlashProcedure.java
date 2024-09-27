package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class WorldSlashProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double timer = 0;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF) == true) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash == true) {
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
						.equals(Component.translatable("jujutsu.technique.dismantle").getString())) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguews").getString());
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
						.equals(Component.translatable("jujutsu.technique.open").getString())) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguekamino").getString());
						capability.syncPlayerVariables(entity);
					});
				}
				if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sukuna_body_chestplate")
						|| (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) <= 4) {
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex12 = new CompoundTag();
								entity.saveWithoutId(dataIndex12);
								return dataIndex12.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 1) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex13 = new CompoundTag();
									entity.saveWithoutId(dataIndex13);
									return dataIndex13.getCompound("ForgeData").getDouble("skill");
								}
							}.getValue() == 107) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex14 = new CompoundTag();
										entity.saveWithoutId(dataIndex14);
										return dataIndex14.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() >= 5) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex15 = new CompoundTag();
											entity.saveWithoutId(dataIndex15);
											return dataIndex15.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() <= 30) {
										CompoundTag dataIndex17 = new CompoundTag();
										entity.saveWithoutId(dataIndex17);
										dataIndex17.getCompound("ForgeData").putDouble("cnt6", (new Object() {
											public double getValue() {
												CompoundTag dataIndex16 = new CompoundTag();
												entity.saveWithoutId(dataIndex16);
												return dataIndex16.getCompound("ForgeData").getDouble("cnt6");
											}
										}.getValue() + 1));
										entity.load(dataIndex17);
									}
								}
							}
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex18 = new CompoundTag();
									entity.saveWithoutId(dataIndex18);
									return dataIndex18.getCompound("ForgeData").getDouble("skill");
								}
							}.getValue() == 105) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex19 = new CompoundTag();
										entity.saveWithoutId(dataIndex19);
										return dataIndex19.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() >= 5) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex20 = new CompoundTag();
											entity.saveWithoutId(dataIndex20);
											return dataIndex20.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() <= 75) {
										CompoundTag dataIndex22 = new CompoundTag();
										entity.saveWithoutId(dataIndex22);
										dataIndex22.getCompound("ForgeData").putDouble("cnt6", (new Object() {
											public double getValue() {
												CompoundTag dataIndex21 = new CompoundTag();
												entity.saveWithoutId(dataIndex21);
												return dataIndex21.getCompound("ForgeData").getDouble("cnt6");
											}
										}.getValue() + 1));
										entity.load(dataIndex22);
									}
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex23 = new CompoundTag();
											entity.saveWithoutId(dataIndex23);
											return dataIndex23.getCompound("ForgeData").getDouble("cnt6");
										}
									}.getValue() >= 75) {
										if (!(new Object() {
											public double getValue() {
												CompoundTag dataIndex24 = new CompoundTag();
												entity.saveWithoutId(dataIndex24);
												return dataIndex24.getCompound("ForgeData").getDouble("brokenBrain");
											}
										}.getValue() == 2)) {
											CompoundTag dataIndex25 = new CompoundTag();
											entity.saveWithoutId(dataIndex25);
											dataIndex25.getCompound("ForgeData").putDouble("brokenBrain", 2);
											entity.load(dataIndex25);
										}
										{
											final Vec3 _center = new Vec3(x, y, z);
											List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(60 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
													.toList();
											for (Entity entityiterator : _entfound) {
												if (!(entityiterator == entity)) {
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 254, false, false));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 254, false, false));
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get());
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get());
													if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 100000,
																(int) ((entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
																		? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
																		: 0) + 255),
																false, true));
													if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
														_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 10000,
																(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())
																		? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier()
																		: 0) + 2),
																false, false));
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
													if (entityiterator instanceof LivingEntity _entity)
														_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
													{
														double _setval = 1;
														entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.OutputLevel = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
													{
														boolean _setval = false;
														entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
															capability.WorldSlash = _setval;
															capability.syncPlayerVariables(entity);
														});
													}
												}
											}
										}
									}
								}
							}
						} else if (new Object() {
							public double getValue() {
								CompoundTag dataIndex37 = new CompoundTag();
								entity.saveWithoutId(dataIndex37);
								return dataIndex37.getCompound("ForgeData").getDouble("PRESS_Z");
							}
						}.getValue() == 0) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex38 = new CompoundTag();
									entity.saveWithoutId(dataIndex38);
									return dataIndex38.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() >= 5) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex39 = new CompoundTag();
										entity.saveWithoutId(dataIndex39);
										return dataIndex39.getCompound("ForgeData").getDouble("cnt6");
									}
								}.getValue() >= 30) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run effect give @s jujutsucraft:unstable 150 2 true");
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
