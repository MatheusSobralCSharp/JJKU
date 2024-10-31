package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;

import java.util.List;
import java.util.Comparator;

public class SwordJinWooRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (entity.isShiftKeyDown()) {
            {
                final Vec3 _center = new Vec3(x, y, z);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if ((new Object() {
                        public String getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entityiterator.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                        }
                    }.getValue()).equals(entity.getStringUUID())) {
                        if (entityiterator instanceof IgrisEntity) {
                            ((IgrisEntity) entityiterator).setAnimation("kneel");
                        }
                        if (entityiterator instanceof Shadow1Entity) {
                            ((Shadow1Entity) entityiterator).setAnimation("kneel");
                        }
                    }
                }
            }
        } else {
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftaddonModEntities.IGRIS.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                }
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
                (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
                        .setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 20));
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("IsMahoraga", 1);
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
                    dataIndex.getCompound("ForgeData").putBoolean("Player", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
            }
            if (world instanceof ServerLevel _serverLevel) {
                Entity entitytospawn = JujutsucraftaddonModEntities.SHADOW_1.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                if (entitytospawn != null) {
                    entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                }
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
                (entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
                        .setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 20));
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
                        .setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
                ((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
                if ((entitytospawn) instanceof LivingEntity _entity)
                    _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                {
                    Entity _entity = (entitytospawn);
                    if (_entity instanceof Player _player) {
                        _player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity _living) {
                        _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
                    }
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("IsMahoraga", 1);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                        public double getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                        }
                    }.getValue()));
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
                    dataIndex.getCompound("ForgeData").putBoolean("Player", true);
                    (entitytospawn).load(dataIndex);
                }
                {
                    CompoundTag dataIndex = new CompoundTag();
                    (entitytospawn).saveWithoutId(dataIndex);
                    dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
                        public boolean getValue() {
                            CompoundTag dataIndex = new CompoundTag();
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
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
                            entity.saveWithoutId(dataIndex);
                            return dataIndex.getCompound("ForgeData").getBoolean("CurseUser");
                        }
                    }.getValue()));
                    (entitytospawn).load(dataIndex);
                }
            }
            if (new Object() {
                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
                    }
                    return false;
                }
            }.checkGamemode(entity)) {
                if (entity instanceof Player _player)
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 300);
            }
        }
    }
}
