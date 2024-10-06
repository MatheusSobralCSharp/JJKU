package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

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
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class SukunaKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double numberrea = 0;
		if (entity instanceof LivingEntity) {
			if ((entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
					&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_7"))).isDone()) == false) {
				if (Math.random() <= 0.5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 3000, 6000), 1, false, false));
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.setBaseValue((1 + ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue()));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
								.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 30));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
								.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
									(int) (((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
											+ 16),
									false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex33 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex33);
						dataIndex33.putString("Owner", (entity.getStringUUID()));
						(entitytospawn).load(dataIndex33);
						if ((entitytospawn) instanceof LivingEntity _entity) {
							ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
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
						CompoundTag dataIndex44 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex44);
						dataIndex44.getCompound("ForgeData").putDouble("Demon", 1);
						(entitytospawn).load(dataIndex44);
						CompoundTag dataIndex47 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex47);
						dataIndex47.getCompound("ForgeData").putDouble("friend_num", (new Object() {
							public double getValue() {
								CompoundTag dataIndex46 = new CompoundTag();
								entity.saveWithoutId(dataIndex46);
								return dataIndex46.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex47);
						CompoundTag dataIndex50 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex50);
						dataIndex50.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
							public double getValue() {
								CompoundTag dataIndex49 = new CompoundTag();
								entity.saveWithoutId(dataIndex49);
								return dataIndex49.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex50);
						CompoundTag dataIndex53 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex53);
						dataIndex53.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
						(entitytospawn).load(dataIndex53);
						CompoundTag dataIndex55 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex55);
						dataIndex55.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
						(entitytospawn).load(dataIndex55);
						CompoundTag dataIndex58 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex58);
						dataIndex58.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex57 = new CompoundTag();
								entity.saveWithoutId(dataIndex57);
								return dataIndex57.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex58);
						CompoundTag dataIndex61 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex61);
						dataIndex61.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex60 = new CompoundTag();
								entity.saveWithoutId(dataIndex60);
								return dataIndex60.getCompound("ForgeData").getBoolean("CursedSpirit");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex61);
						CompoundTag dataIndex64 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex64);
						dataIndex64.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex63 = new CompoundTag();
								entity.saveWithoutId(dataIndex63);
								return dataIndex63.getCompound("ForgeData").getBoolean("CurseUser");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex64);
					}
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 4000, 6000), 1, false, false));
					JujutsucraftaddonMod.queueServerWork(40, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:sukunaheart")), SoundSource.NEUTRAL, 3, 1, false);
							}
						}
					});
					if (world instanceof ServerLevel _serverLevel) {
						Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entitytospawn != null) {
							entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						}
						(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
								.setBaseValue((1 + ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue()));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
								.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 40));
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
								.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
									(int) (((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0)
											+ 16),
									false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex99 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex99);
						dataIndex99.putString("Owner", (entity.getStringUUID()));
						(entitytospawn).load(dataIndex99);
						if ((entitytospawn) instanceof LivingEntity _entity) {
							ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_HEARY.get(), 20, 1, false, false));
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
						CompoundTag dataIndex112 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex112);
						dataIndex112.getCompound("ForgeData").putDouble("Demon", 1);
						(entitytospawn).load(dataIndex112);
						CompoundTag dataIndex114 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex114);
						dataIndex114.getCompound("ForgeData").putDouble("DeathCount", 1);
						(entitytospawn).load(dataIndex114);
						CompoundTag dataIndex117 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex117);
						dataIndex117.getCompound("ForgeData").putDouble("friend_num", (new Object() {
							public double getValue() {
								CompoundTag dataIndex116 = new CompoundTag();
								entity.saveWithoutId(dataIndex116);
								return dataIndex116.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex117);
						CompoundTag dataIndex120 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex120);
						dataIndex120.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
							public double getValue() {
								CompoundTag dataIndex119 = new CompoundTag();
								entity.saveWithoutId(dataIndex119);
								return dataIndex119.getCompound("ForgeData").getDouble("friend_num");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex120);
						CompoundTag dataIndex123 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex123);
						dataIndex123.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
						(entitytospawn).load(dataIndex123);
						CompoundTag dataIndex125 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex125);
						dataIndex125.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
						(entitytospawn).load(dataIndex125);
						CompoundTag dataIndex128 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex128);
						dataIndex128.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex127 = new CompoundTag();
								entity.saveWithoutId(dataIndex127);
								return dataIndex127.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex128);
						CompoundTag dataIndex131 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex131);
						dataIndex131.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex130 = new CompoundTag();
								entity.saveWithoutId(dataIndex130);
								return dataIndex130.getCompound("ForgeData").getBoolean("CursedSpirit");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex131);
						CompoundTag dataIndex134 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex134);
						dataIndex134.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
							public boolean getValue() {
								CompoundTag dataIndex133 = new CompoundTag();
								entity.saveWithoutId(dataIndex133);
								return dataIndex133.getCompound("ForgeData").getBoolean("CurseUser");
							}
						}.getValue()));
						(entitytospawn).load(dataIndex134);
					}
				}
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 6000, 18000), 1, false, false));
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
							.setBaseValue((1 + ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue()));
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
							.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
							.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 40));
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
							.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).setBaseValue(0.3);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), (-1),
								(int) (((entitytospawn) instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() : 0) + 19),
								false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex167 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex167);
					dataIndex167.putString("Owner", (entity.getStringUUID()));
					(entitytospawn).load(dataIndex167);
					if ((entitytospawn) instanceof LivingEntity _entity) {
						ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
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
					CompoundTag dataIndex178 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex178);
					dataIndex178.getCompound("ForgeData").putDouble("God", 1);
					(entitytospawn).load(dataIndex178);
					CompoundTag dataIndex180 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex180);
					dataIndex180.getCompound("ForgeData").putDouble("Demon", 1);
					(entitytospawn).load(dataIndex180);
					CompoundTag dataIndex183 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex183);
					dataIndex183.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex182 = new CompoundTag();
							entity.saveWithoutId(dataIndex182);
							return dataIndex182.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex183);
					CompoundTag dataIndex186 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex186);
					dataIndex186.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
						public double getValue() {
							CompoundTag dataIndex185 = new CompoundTag();
							entity.saveWithoutId(dataIndex185);
							return dataIndex185.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex186);
					CompoundTag dataIndex189 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex189);
					dataIndex189.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
					(entitytospawn).load(dataIndex189);
					CompoundTag dataIndex191 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex191);
					dataIndex191.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
					(entitytospawn).load(dataIndex191);
					CompoundTag dataIndex194 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex194);
					dataIndex194.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex193 = new CompoundTag();
							entity.saveWithoutId(dataIndex193);
							return dataIndex193.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex194);
					CompoundTag dataIndex197 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex197);
					dataIndex197.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex196 = new CompoundTag();
							entity.saveWithoutId(dataIndex196);
							return dataIndex196.getCompound("ForgeData").getBoolean("CursedSpirit");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex197);
					CompoundTag dataIndex200 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex200);
					dataIndex200.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex199 = new CompoundTag();
							entity.saveWithoutId(dataIndex199);
							return dataIndex199.getCompound("ForgeData").getBoolean("CurseUser");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex200);
				}
			}
		}
	}
}
