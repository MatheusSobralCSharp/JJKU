package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;

public class SpawnCloneDefensiveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftaddonModEntities.FAKE_CLONES.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			CompoundTag dataIndex2 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
			(entitytospawn).load(dataIndex2);
			CompoundTag dataIndex5 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex5);
			dataIndex5.putString("Owner", (entity.getStringUUID()));
			(entitytospawn).load(dataIndex5);
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
			(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
			if ((entitytospawn) instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
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
			{
				Entity _entity = (entitytospawn);
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
				}
			}
			{
				Entity _entity = (entitytospawn);
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
				}
			}
			CompoundTag dataIndex43 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex43);
			dataIndex43.getCompound("ForgeData").putDouble("friend_num", (new Object() {
				public double getValue() {
					CompoundTag dataIndex42 = new CompoundTag();
					entity.saveWithoutId(dataIndex42);
					return dataIndex42.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex43);
			CompoundTag dataIndex46 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex46);
			dataIndex46.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
				public double getValue() {
					CompoundTag dataIndex45 = new CompoundTag();
					entity.saveWithoutId(dataIndex45);
					return dataIndex45.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex46);
			CompoundTag dataIndex48 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex48);
			dataIndex48.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
			(entitytospawn).load(dataIndex48);
			CompoundTag dataIndex50 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex50);
			dataIndex50.getCompound("ForgeData").putBoolean("Player", true);
			(entitytospawn).load(dataIndex50);
			CompoundTag dataIndex53 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex53);
			dataIndex53.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex52 = new CompoundTag();
					entity.saveWithoutId(dataIndex52);
					return dataIndex52.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex53);
			CompoundTag dataIndex56 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex56);
			dataIndex56.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex55 = new CompoundTag();
					entity.saveWithoutId(dataIndex55);
					return dataIndex55.getCompound("ForgeData").getBoolean("CursedSpirit");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex56);
			CompoundTag dataIndex59 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex59);
			dataIndex59.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex58 = new CompoundTag();
					entity.saveWithoutId(dataIndex58);
					return dataIndex58.getCompound("ForgeData").getBoolean("CurseUser");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex59);
		}
	}
}
