package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class SpawnCloneBasedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
        if (sourceentity == null)
            return;
        if (Math.random() <= 0.3) {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.putString("Owner", (sourceentity.getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
                        .setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
                        .setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
                        .setBaseValue((((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
                        .setBaseValue(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if ((entitytospawn) instanceof LivingEntity _entity) {
                    ItemStack _setstack = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player)
                        _player.getInventory().setChanged();
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(0, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.FEET, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(1, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.LEGS, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(2, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.CHEST, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("Tagged", (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("CursedSpirit");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            sourceentity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                if ((entitytospawn) instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
                    _toTame.tame(_owner);
            }
        }
    }
}
