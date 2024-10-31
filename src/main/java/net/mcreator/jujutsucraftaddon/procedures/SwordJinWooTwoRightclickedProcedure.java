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

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;

public class SwordJinWooTwoRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (world instanceof ServerLevel _serverLevel) {
            Entity entitytospawn = JujutsucraftaddonModEntities.CLONE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entitytospawn != null) {
                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                if ((entitytospawn) instanceof CloneEntity _datEntSetS)
                    _datEntSetS.getEntityData().set(CloneEntity.DATA_Testing, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Shadow).toLowerCase());
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.putString("Owner", (entity.getStringUUID()));
                    (entitytospawn).load(dataIndex);
                }
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
                (entitytospawn).setCustomName(Component.literal(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ShadowName)));
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                if ((entitytospawn) instanceof LivingEntity _entity) {
                    ItemStack _setstack = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot5).copy();
                    _setstack.setCount(1);
                    _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                    if (_entity instanceof Player _player)
                        _player.getInventory().setChanged();
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(0, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot1));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.FEET, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot1));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(1, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot2));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.LEGS, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot2));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(2, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot3));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.CHEST, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot3));
                    }
                }
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot4));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Armorslot4));
                    }
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
                    dataIndex.getCompound("ForgeData").putBoolean("Player", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    String _setval = "";
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.ShadowName = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    String _setval = "";
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.Shadow = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                _serverLevel.addFreshEntity(entitytospawn);
            }
        }
    }
}
