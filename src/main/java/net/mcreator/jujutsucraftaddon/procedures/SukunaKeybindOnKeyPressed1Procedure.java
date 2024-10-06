package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;

public class SukunaKeybindOnKeyPressed1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get()))) {
			if (Math.random() <= 0.1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sukuna: What An Annoying Brat "), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc1")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc1")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (Math.random() <= 0.2) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sukuna: Idiot."), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc2")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc2")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (Math.random() <= 0.3) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sukuna: If You'll accept my conditions, I'll help you and bring us back to life"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc3")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc3")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (Math.random() <= 0.4) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sukuna: Brat "), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc4")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc4")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (Math.random() <= 0.5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Sukuna: Man, you're boring "), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc5")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunavc5")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("CONTAIN SUKUNA"), false);
			ContainProcedure.execute(world, x, y, z, entity);
		}
		if ((entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
				&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_7"))).isDone()) == false) {
			if (Math.random() <= 0.05 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE))) {
				SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
			}
		} else {
			if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
					&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_15"))).isDone()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:fushiguro_megumi_shibuya")) {
							SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
						}
					}
				}
			} else {
				if (Math.random() <= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_RATE))) {
					SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
				}
			}
		}
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger")))) : false) {
				{
					Entity _ent = entityiterator;
					_ent.teleportTo((entity.getX()), (entity.getY() + y), (entity.getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + y), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
				}
				if (entityiterator instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:sukuna_finger")));
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (entityiterator instanceof ServerPlayer _plr28 && _plr28.level() instanceof ServerLevel
							&& _plr28.getAdvancements().getOrStartProgress(_plr28.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:welcome_to_jujutsu_plus"))).isDone()) {
						if ((entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 6) {
							if (Math.random() <= 0.05) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), -1, 1, false, false));
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									(entitytospawn).setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
											.setBaseValue((1 + ((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue()));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
											.setBaseValue(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
											.setBaseValue((((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 40));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
											.setBaseValue(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
									if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
												(int) (((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
														? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
														: 0) + 16),
												false, false));
									if ((entitytospawn) instanceof LivingEntity _entity)
										_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
									CompoundTag dataIndex60 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex60);
									dataIndex60.putString("Owner", (entityiterator.getStringUUID()));
									(entitytospawn).load(dataIndex60);
									if ((entitytospawn) instanceof LivingEntity _entity) {
										ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
										}
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
										}
									}
									CompoundTag dataIndex71 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex71);
									dataIndex71.getCompound("ForgeData").putDouble("God", 1);
									(entitytospawn).load(dataIndex71);
									CompoundTag dataIndex73 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex73);
									dataIndex73.getCompound("ForgeData").putDouble("Demon", 1);
									(entitytospawn).load(dataIndex73);
									CompoundTag dataIndex76 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex76);
									dataIndex76.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex75 = new CompoundTag();
											entityiterator.saveWithoutId(dataIndex75);
											return dataIndex75.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex76);
									CompoundTag dataIndex79 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex79);
									dataIndex79.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex78 = new CompoundTag();
											entityiterator.saveWithoutId(dataIndex78);
											return dataIndex78.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex79);
									CompoundTag dataIndex82 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex82);
									dataIndex82.getCompound("ForgeData").putDouble("Tagged",
											(entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
									(entitytospawn).load(dataIndex82);
									CompoundTag dataIndex84 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex84);
									dataIndex84.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
									(entitytospawn).load(dataIndex84);
									CompoundTag dataIndex86 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex86);
									dataIndex86.getCompound("ForgeData").putBoolean("CurseUser", true);
									(entitytospawn).load(dataIndex86);
								}
							}
						} else if ((entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
							if (Math.random() <= 0.4) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), -1, 1, false, false));
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									(entitytospawn).setCustomName(Component.literal((entityiterator.getDisplayName().getString())));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
											.setBaseValue((1 + ((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue()));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
											.setBaseValue(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
											.setBaseValue((((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 40));
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
											.setBaseValue(((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
									((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
									if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
												(int) (((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
														? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
														: 0) + 16),
												false, false));
									if ((entitytospawn) instanceof LivingEntity _entity)
										_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
									CompoundTag dataIndex119 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex119);
									dataIndex119.putString("Owner", (entityiterator.getStringUUID()));
									(entitytospawn).load(dataIndex119);
									if ((entitytospawn) instanceof LivingEntity _entity) {
										ItemStack _setstack = (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
										_setstack.setCount(1);
										_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (_entity instanceof Player _player)
											_player.getInventory().setChanged();
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
										}
									}
									{
										Entity _entity = (entitytospawn);
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
										}
									}
									CompoundTag dataIndex130 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex130);
									dataIndex130.getCompound("ForgeData").putDouble("God", 1);
									(entitytospawn).load(dataIndex130);
									CompoundTag dataIndex132 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex132);
									dataIndex132.getCompound("ForgeData").putDouble("Demon", 1);
									(entitytospawn).load(dataIndex132);
									CompoundTag dataIndex135 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex135);
									dataIndex135.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex134 = new CompoundTag();
											entityiterator.saveWithoutId(dataIndex134);
											return dataIndex134.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex135);
									CompoundTag dataIndex138 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex138);
									dataIndex138.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex137 = new CompoundTag();
											entityiterator.saveWithoutId(dataIndex137);
											return dataIndex137.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex138);
									CompoundTag dataIndex141 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex141);
									dataIndex141.getCompound("ForgeData").putDouble("Tagged",
											(entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
									(entitytospawn).load(dataIndex141);
									CompoundTag dataIndex143 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex143);
									dataIndex143.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
									(entitytospawn).load(dataIndex143);
									CompoundTag dataIndex145 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex145);
									dataIndex145.getCompound("ForgeData").putBoolean("CurseUser", true);
									(entitytospawn).load(dataIndex145);
								}
							}
						}
					}
				}
			}
		}
	}
}
