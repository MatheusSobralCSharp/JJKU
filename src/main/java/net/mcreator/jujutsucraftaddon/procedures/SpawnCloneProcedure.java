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

public class SpawnCloneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
			(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
					.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
			((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
			if ((entitytospawn) instanceof LivingEntity _entity)
				_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
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
			CompoundTag dataIndex52 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex52);
			dataIndex52.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
			(entitytospawn).load(dataIndex52);
			CompoundTag dataIndex54 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex54);
			dataIndex54.getCompound("ForgeData").putBoolean("Player", true);
			(entitytospawn).load(dataIndex54);
			CompoundTag dataIndex57 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex57);
			dataIndex57.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex56 = new CompoundTag();
					entity.saveWithoutId(dataIndex56);
					return dataIndex56.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex57);
			CompoundTag dataIndex60 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex60);
			dataIndex60.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex59 = new CompoundTag();
					entity.saveWithoutId(dataIndex59);
					return dataIndex59.getCompound("ForgeData").getBoolean("CursedSpirit");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex60);
			CompoundTag dataIndex63 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex63);
			dataIndex63.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
				public boolean getValue() {
					CompoundTag dataIndex62 = new CompoundTag();
					entity.saveWithoutId(dataIndex62);
					return dataIndex62.getCompound("ForgeData").getBoolean("CurseUser");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex63);
		}
	}
}
