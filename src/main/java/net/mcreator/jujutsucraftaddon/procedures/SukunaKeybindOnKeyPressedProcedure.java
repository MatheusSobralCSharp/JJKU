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
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.putString("Owner", (entity.getStringUUID()));
                                (entitytospawn).load(dataIndex);
                            }
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
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("Demon", 1);
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
                                dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
                                (entitytospawn).load(dataIndex);
                            }
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
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
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.putString("Owner", (entity.getStringUUID()));
                                (entitytospawn).load(dataIndex);
                            }
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
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("Demon", 1);
                                (entitytospawn).load(dataIndex);
                            }
                            {
                                CompoundTag dataIndex = new CompoundTag();
                                (entitytospawn).saveWithoutId(dataIndex);
                                dataIndex.getCompound("ForgeData").putDouble("DeathCount", 1);
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
                                dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                                dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
                                (entitytospawn).load(dataIndex);
                            }
                            _serverLevel.addFreshEntity(entitytospawn);
                        }
                    }
                }
            } else {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA.get(), Mth.nextInt(RandomSource.create(), 6000, 18000), 1, false, false));
                if (world instanceof ServerLevel _serverLevel) {
                    Entity entitytospawn = JujutsucraftaddonModEntities.SUKUNA_R.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
                    if (entitytospawn != null) {
                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
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
                                            + 19),
                                    false, false));
                        if ((entitytospawn) instanceof LivingEntity _entity)
                            _entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.putString("Owner", (entity.getStringUUID()));
                            (entitytospawn).load(dataIndex);
                        }
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
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("God", 1);
                            (entitytospawn).load(dataIndex);
                        }
                        {
                            CompoundTag dataIndex = new CompoundTag();
                            (entitytospawn).saveWithoutId(dataIndex);
                            dataIndex.getCompound("ForgeData").putDouble("Demon", 1);
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
                            dataIndex.getCompound("ForgeData").putDouble("Tagged", (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2);
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
                            dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
                            (entitytospawn).load(dataIndex);
                        }
                        _serverLevel.addFreshEntity(entitytospawn);
                    }
                }
            }
        }
    }
}
