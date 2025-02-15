package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

@Mixin(value = DeadlySentencingActiveProcedure.class, priority = -10000)
public class DeadlySentencingMixin {
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_a;
            Entity entity_a;
            double x_pos;
            double y_pos;
            double var10000;
            double z_pos;
            double num1;
            double range;
            double tick;
            double num2;
            double num3;
            ItemStack item_a;
            LivingEntity _entity;
            label811:
            {
                logic_a = false;
                boolean logic_b = false;
                boolean failed = false;
                entity_a = null;
                Entity entity_b = null;
                x_pos = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                double yaw = 0.0;
                num1 = 0.0;
                range = 0.0;
                double pitch = 0.0;
                tick = 0.0;
                num2 = 0.0;
                num3 = 0.0;
                item_a = ItemStack.EMPTY;
                range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity) entity;
                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = (double) _entity.getEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                        break label811;
                    }
                }

                var10000 = 0.0;
            }

            tick = var10000;
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                    if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                            return serverLevel.getEntity(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                    }

                    return null;
                }
            }).apply(world, entity.getPersistentData().getString("takada_UUID"));
            Entity _ent;
            Iterator var36;
            Entity entityiterator;
            ServerLevel _level;
            Vec3 _center;
            List _entfound;
            LivingEntity _livEnt;
            if (!(entity_a instanceof JudgemanEntity) && tick % 20.0 == 10.0) {
                num2 = (double) entity.getYRot();
                num3 = (double) entity.getXRot();
                RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
                num1 = Math.toRadians((double) (entity.getYRot() + 90.0F + 180.0F));
                x_pos = entity.getX() + Math.cos(num1) * (double) (5.0F + entity.getBbWidth());
                y_pos = entity.getY();
                z_pos = entity.getZ() + Math.sin(num1) * (double) (5.0F + entity.getBbWidth());
                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _ent = ((EntityType) JujutsucraftModEntities.JUDGEMAN.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                    if (_ent != null) {
                        _ent.setYRot(world.getRandom().nextFloat() * 360.0F);
                    }
                }

                _center = new Vec3(x_pos, y_pos, z_pos);
                Vec3 final_center = _center;
                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(final_center);
                })).toList();
                var36 = _entfound.iterator();

                while (var36.hasNext()) {
                    entityiterator = (Entity) var36.next();
                    if (entityiterator instanceof JudgemanEntity && entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                        entity.getPersistentData().putString("takada_UUID", entityiterator.getStringUUID());
                        entityiterator.getPersistentData().putBoolean("domain_entity", true);
                        entityiterator = entityiterator;
                        if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                            entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "data merge entity @s {Invulnerable:1b}");
                        }

                        entity_a = entityiterator;
                        break;
                    }
                }

                entity.setYRot((float) num2);
                entity.setXRot((float) num3);
                entity.setYBodyRot(entity.getYRot());
                entity.setYHeadRot(entity.getYRot());
                entity.yRotO = entity.getYRot();
                entity.xRotO = entity.getXRot();
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entity;
                    _livEnt.yBodyRotO = _livEnt.getYRot();
                    _livEnt.yHeadRotO = _livEnt.getYRot();
                }
            }

            int var79;
            if (entity_a instanceof JudgemanEntity) {
                if (entity.getPersistentData().getDouble("skill") != 2719.0) {
                    label791:
                    {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                var79 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                break label791;
                            }
                        }

                        var79 = 0;
                    }

                    if (var79 > 0) {
                        entity_a.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma")));
                    } else {
                        num1 = (double) (entity_a.getYRot() % 360.0F);
                        _ent = entity_a;
                        _ent.setYRot(entity.getYRot() % 360.0F);
                        _ent.setXRot(entity.getXRot());
                        _ent.setYBodyRot(_ent.getYRot());
                        _ent.setYHeadRot(_ent.getYRot());
                        _ent.yRotO = _ent.getYRot();
                        _ent.xRotO = _ent.getXRot();
                        if (_ent instanceof LivingEntity) {
                            _entity = (LivingEntity) _ent;
                            _entity.yBodyRotO = _entity.getYRot();
                            _entity.yHeadRotO = _entity.getYRot();
                        }

                        num2 = num1 - (double) entity.getYRot();
                        if (Math.abs(num2) > 180.0) {
                            _ent = entity_a;
                            _ent.setYRot((float) (num1 + Math.min(4.0, Math.abs(num2)) * (double) (num2 < 0.0 ? -1 : 1)));
                            _ent.setXRot(entity.getXRot());
                            _ent.setYBodyRot(_ent.getYRot());
                            _ent.setYHeadRot(_ent.getYRot());
                            _ent.yRotO = _ent.getYRot();
                            _ent.xRotO = _ent.getXRot();
                            if (_ent instanceof LivingEntity) {
                                _entity = (LivingEntity) _ent;
                                _entity.yBodyRotO = _entity.getYRot();
                                _entity.yHeadRotO = _entity.getYRot();
                            }
                        } else {
                            _ent = entity_a;
                            _ent.setYRot((float) (num1 + Math.min(4.0, Math.abs(num2)) * (double) (num2 > 0.0 ? -1 : 1)));
                            _ent.setXRot(entity.getXRot());
                            _ent.setYBodyRot(_ent.getYRot());
                            _ent.setYHeadRot(_ent.getYRot());
                            _ent.yRotO = _ent.getYRot();
                            _ent.xRotO = _ent.getXRot();
                            if (_ent instanceof LivingEntity) {
                                _entity = (LivingEntity) _ent;
                                _entity.yBodyRotO = _entity.getYRot();
                                _entity.yHeadRotO = _entity.getYRot();
                            }
                        }
                    }

                    num1 = Math.toRadians((double) (entity_a.getYRot() + 90.0F + 180.0F));
                    x_pos = entity.getX() + Math.cos(num1) * (double) (5.0F + entity.getBbWidth());
                    y_pos = entity.getY();
                    z_pos = entity.getZ() + Math.sin(num1) * (double) (5.0F + entity.getBbWidth());
                    entity_a.teleportTo(entity_a.getX() + Math.min(0.25, Math.abs(x_pos - entity_a.getX())) * (double) (x_pos > entity_a.getX() ? 1 : -1), entity_a.getY() + Math.min(0.25, Math.abs(y_pos - entity_a.getY())) * (double) (y_pos > entity_a.getY() ? 1 : -1), entity_a.getZ() + Math.min(0.25, Math.abs(z_pos - entity_a.getZ())) * (double) (z_pos > entity_a.getZ() ? 1 : -1));
                    if (entity_a instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer) entity_a;
                        _serverPlayer.connection.teleport(entity_a.getX() + Math.min(0.25, Math.abs(x_pos - entity_a.getX())) * (double) (x_pos > entity_a.getX() ? 1 : -1), entity_a.getY() + Math.min(0.25, Math.abs(y_pos - entity_a.getY())) * (double) (y_pos > entity_a.getY() ? 1 : -1), entity_a.getZ() + Math.min(0.25, Math.abs(z_pos - entity_a.getZ())) * (double) (z_pos > entity_a.getZ() ? 1 : -1), entity_a.getYRot(), entity_a.getXRot());
                    }
                }

                entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                if (!entity.isAlive() && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
                    entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel) entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                }
            }

            if (!entity.getPersistentData().getBoolean("Failed") || entity.getPersistentData().getDouble("skill") == 2719.0) {
                entity.getPersistentData().putBoolean("DomainAttack", false);
                if (tick % 20.0 == 10.0) {
                    if (entity.getPersistentData().getDouble("skill") == 2719.0 && entity.getPersistentData().getDouble("cnt3") >= 20.0) {
                        entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                            double var10001;
                            int var10002;
                            label773:
                            {
                                var10000 = Math.random() * 100.0;
                                var10001 = entity.getPersistentData().getDouble("cnt4");
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var10002 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label773;
                                    }
                                }

                                var10002 = 0;
                            }

                            if (var10000 <= var10001 * Math.min((double) (var10002 + 1) * 0.1, 1.0)) {
                                entity.getPersistentData().putDouble("cnt2", 0.0);
                            } else {
                                entity.getPersistentData().putDouble("cnt2", 1.0);
                            }
                        }
                    }

                    label768:
                    {
                        num1 = 0.0;
                        num2 = 0.0;
                        num3 = 1.0;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                var79 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                break label768;
                            }
                        }

                        var79 = 0;
                    }

                    if (var79 < 1) {
                        ++num1;
                    }

                    item_a = (new ItemStack((ItemLike) JujutsucraftModItems.EXECUTIONERS_SWORD.get())).copy();
                    _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                    Vec3 final_center1 = _center;
                    _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(final_center1);
                    })).toList();
                    var36 = _entfound.iterator();

                    label763:
                    while (true) {
                        LazyOptional var81;
                        ItemStack var82;
                        if (!var36.hasNext()) {
                            if (entity.getPersistentData().getDouble("skill") == 2719.0) {
                                if (!(entity.getPersistentData().getDouble("cnt1") >= 5.0)) {
                                    break;
                                }

                                if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                                    item_a.getOrCreateTag().putString("OWNER_UUID", entity.getStringUUID());
                                    if (!(entity instanceof Player)) {
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            ItemStack _setstack = item_a.copy();
                                            _setstack.setCount(1);
                                            _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                            if (_entity instanceof Player) {
                                                Player _player = (Player) _entity;
                                                _player.getInventory().setChanged();
                                            }
                                        }
                                    } else {
                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity) entity;
                                            var82 = _entity.getMainHandItem();
                                        } else {
                                            var82 = ItemStack.EMPTY;
                                        }

                                        label592:
                                        {
                                            ItemStack _setstack;
                                            Player _player;
                                            if (var82.getItem() != JujutsucraftModItems.GAVEL.get()) {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity;
                                                    var82 = _livEnt.getMainHandItem();
                                                } else {
                                                    var82 = ItemStack.EMPTY;
                                                }

                                                if (var82.getItem() != JujutsucraftModItems.GAVEL_LONG.get()) {
                                                    if (entity instanceof LivingEntity) {
                                                        _entity = (LivingEntity) entity;
                                                        var82 = _entity.getMainHandItem();
                                                    } else {
                                                        var82 = ItemStack.EMPTY;
                                                    }

                                                    if (var82.getItem() != JujutsucraftModItems.GAVEL_BIG.get()) {
                                                        if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEnt2 = (LivingEntity) entity;
                                                            var82 = _livEnt2.getMainHandItem();
                                                        } else {
                                                            var82 = ItemStack.EMPTY;
                                                        }

                                                        if (var82.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                                            if (entity instanceof LivingEntity) {
                                                                _livEnt = (LivingEntity) entity;
                                                                var82 = _livEnt.getOffhandItem();
                                                            } else {
                                                                var82 = ItemStack.EMPTY;
                                                            }

                                                            if (var82.getItem() != JujutsucraftModItems.GAVEL.get()) {
                                                                if (entity instanceof LivingEntity) {
                                                                    _entity = (LivingEntity) entity;
                                                                    var82 = _entity.getOffhandItem();
                                                                } else {
                                                                    var82 = ItemStack.EMPTY;
                                                                }

                                                                if (var82.getItem() != JujutsucraftModItems.GAVEL_LONG.get()) {
                                                                    if (entity instanceof LivingEntity) {
                                                                        _livEnt = (LivingEntity) entity;
                                                                        var82 = _livEnt.getOffhandItem();
                                                                    } else {
                                                                        var82 = ItemStack.EMPTY;
                                                                    }

                                                                    if (var82.getItem() != JujutsucraftModItems.GAVEL_BIG.get()) {
                                                                        if (entity instanceof LivingEntity) {
                                                                            _livEnt = (LivingEntity) entity;
                                                                            var82 = _livEnt.getOffhandItem();
                                                                        } else {
                                                                            var82 = ItemStack.EMPTY;
                                                                        }

                                                                        if (var82.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                                                            num1 = 0.0;
                                                                            // Initialize AtomicReference with the correct generic type
                                                                            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
                                                                            LazyOptional<IItemHandler> var811 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
                                                                            var811.ifPresent(_iitemhandlerref::set);
                                                                            if (_iitemhandlerref.get() != null) {
                                                                                for (int _idx = 0; _idx < ((IItemHandler) _iitemhandlerref.get()).getSlots(); ++_idx) {
                                                                                    ItemStack itemstackiterator = ((IItemHandler) _iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                                                                    if (itemstackiterator.getItem() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                                                                        _ent = entity;
                                                                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s container." + Math.round(num1) + " with air");
                                                                                        }
                                                                                        break;
                                                                                    }

                                                                                    ++num1;
                                                                                }
                                                                            }

                                                                            if (entity instanceof Player) {
                                                                                _player = (Player) entity;
                                                                                _setstack = item_a.copy();
                                                                                _setstack.setCount(1);
                                                                                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                                                            }
                                                                            break label592;
                                                                        }
                                                                    }
                                                                }
                                                            }

                                                            if (entity instanceof LivingEntity) {
                                                                _entity = (LivingEntity) entity;
                                                                _setstack = item_a.copy();
                                                                _setstack.setCount(1);
                                                                _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                                                                if (_entity instanceof Player) {
                                                                    _player = (Player) _entity;
                                                                    _player.getInventory().setChanged();
                                                                }
                                                            }
                                                            break label592;
                                                        }
                                                    }
                                                }
                                            }

                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                _setstack = item_a.copy();
                                                _setstack.setCount(1);
                                                _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                                if (_entity instanceof Player) {
                                                    _player = (Player) _entity;
                                                    _player.getInventory().setChanged();
                                                }
                                            }
                                        }

                                        if (world.isClientSide()) {
                                            Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack((ItemLike) JujutsucraftModItems.EXECUTIONERS_SWORD.get()));
                                        }
                                    }

                                    Level _level2;
                                    if (world instanceof Level) {
                                        _level2 = (Level) world;
                                        if (!_level2.isClientSide()) {
                                            _level2.playSound((Player) null, BlockPos.containing(x, y + (double) entity.getBbHeight() * 0.5, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F);
                                        } else {
                                            _level2.playLocalSound(x, y + (double) entity.getBbHeight() * 0.5, z, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")), SoundSource.NEUTRAL, 2.0F, 1.5F, false);
                                        }
                                    }

                                    if (world instanceof Level) {
                                        _level2 = (Level) world;
                                        if (!_level2.isClientSide()) {
                                            _level2.playSound((Player) null, BlockPos.containing(x, y + (double) entity.getBbHeight() * 0.5, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                                        } else {
                                            _level2.playLocalSound(x, y + (double) entity.getBbHeight() * 0.5, z, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:frame_set")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                                        }
                                    }

                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel) world;
                                        _level.sendParticles(ParticleTypes.END_ROD, x, y + (double) entity.getBbHeight() * 0.5, z, 25, 0.25, 0.25, 0.25, 0.25);
                                    }

                                    if (entity instanceof Player) {
                                        Player _player = (Player) entity;
                                        _player.getCooldowns().addCooldown((Item) JujutsucraftModItems.EXECUTIONERS_SWORD.get(), 0);
                                    }
                                }

                                entity.getPersistentData().putDouble("skill", 0.0);
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                }

                                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                                boolean _setval = true;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                    capability.noChangeTechnique = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                                break;
                            }

                            if (!(num1 > 1.0) && (!(num1 > 0.0) || !(num3 > 1.0))) {
                                break;
                            }

                            if (num2 < num3) {
                                label684:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity) entity;
                                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                            var79 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                            break label684;
                                        }
                                    }

                                    var79 = 0;
                                }

                                if (var79 >= 1 && entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    _livEnt.removeEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get());
                                }

                                _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                                Vec3 final_center2 = _center;
                                _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                                    return true;
                                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                    return _entcnd.distanceToSqr(final_center2);
                                })).toList();
                                var36 = _entfound.iterator();

                                while (var36.hasNext()) {
                                    entityiterator = (Entity) var36.next();
                                    if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && LogicAttackDomainProcedure.execute(entity, entityiterator)) {
                                        label674:
                                        {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entityiterator;
                                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                    var79 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                    break label674;
                                                }
                                            }

                                            var79 = 0;
                                        }

                                        if (var79 >= 1 && entityiterator instanceof LivingEntity) {
                                            _entity = (LivingEntity) entityiterator;
                                            _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get());
                                        }
                                    }

                                    if (entityiterator instanceof EntityWitnessStandEntity && !entityiterator.level().isClientSide()) {
                                        entityiterator.discard();
                                    }
                                }

                                num1 = num3;
                            }

                            num2 = 0.0;
                            num3 = (double) entity.getYRot();
                            int index1 = 0;

                            while (true) {
                                if (index1 >= (int) Math.round(num1)) {
                                    break label763;
                                }

                                label831:
                                {
                                    ++num2;
                                    entity_a = null;
                                    if (num2 <= 1.0) {
                                        label640:
                                        {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entity;
                                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                    var79 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                    break label640;
                                                }
                                            }

                                            var79 = 0;
                                        }

                                        if (var79 < 1) {
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity) entity;
                                                if (!_entity.level().isClientSide()) {
                                                    _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get(), 5, 1, false, false));
                                                }
                                            }

                                            entity_a = entity;
                                            break label831;
                                        }
                                    }

                                    Vec3 _center1 = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                                    List<Entity> _entfound2 = world.getEntitiesOfClass(Entity.class, (new AABB(_center1, _center1)).inflate(range / 2.0), (e) -> {
                                        return true;
                                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                        return _entcnd.distanceToSqr(_center1);
                                    })).toList();
                                    Iterator var77 = _entfound2.iterator();

                                    label635:
                                    while (true) {
                                        do {
                                            do {
                                                do {
                                                    do {
                                                        do {
                                                            do {
                                                                if (!var77.hasNext()) {
                                                                    break label635;
                                                                }

                                                                entityiterator = (Entity) var77.next();
                                                            } while (entity == entityiterator);
                                                        } while (!(entityiterator instanceof LivingEntity));
                                                    } while (!entityiterator.isAlive());
                                                } while (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))));
                                            } while (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))));
                                        } while (!LogicAttackDomainProcedure.execute(entity, entityiterator));

                                        label632:
                                        {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entityiterator;
                                                if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                    var79 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                    break label632;
                                                }
                                            }

                                            var79 = 0;
                                        }

                                        if (var79 < 1) {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entityiterator;
                                                if (!_livEnt.level().isClientSide()) {
                                                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get(), 5, 1, false, false));
                                                }
                                            }

                                            entity_a = entityiterator;
                                            break;
                                        }
                                    }
                                }

                                if (!(entity_a instanceof LivingEntity)) {
                                    break label763;
                                }

                                x_pos = entity.getPersistentData().getDouble("x_pos_doma") + Math.cos(Math.toRadians(num3)) * Math.min(4.0 + num1 * 0.3, range * 0.5 * 0.5);
                                y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                                z_pos = entity.getPersistentData().getDouble("z_pos_doma") + Math.sin(Math.toRadians(num3)) * Math.min(4.0 + num1 * 0.3, range * 0.5 * 0.5);
                                if (world instanceof ServerLevel) {
                                    _level = (ServerLevel) world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity) null)).withSuppressedOutput(), "summon jujutsucraft:entity_witness_stand ~ ~ ~ {Invulnerable:1b,NoAI:1b,Rotation:[" + (num3 + 90.0) + "F,0F]}");
                                }

                                Vec3 _center3 = new Vec3(x_pos, y_pos, z_pos);
                                List<Entity> _entfound1 = world.getEntitiesOfClass(Entity.class, (new AABB(_center3, _center3)).inflate(0.5), (e) -> {
                                    return true;
                                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                    return _entcnd.distanceToSqr(_center3);
                                })).toList();
                                Iterator var56 = _entfound1.iterator();

                                while (var56.hasNext()) {
                                    entityiterator = (Entity) var56.next();
                                    if (entityiterator instanceof EntityWitnessStandEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                                        SetRangedAmmoProcedure.execute(entity, entityiterator);
                                        entityiterator.getPersistentData().putString("TARGET", entity_a.getStringUUID());
                                        entity_a.setYRot(entityiterator.getYRot());
                                        entity_a.setXRot(0.0F);
                                        entity_a.setYBodyRot(entity_a.getYRot());
                                        entity_a.setYHeadRot(entity_a.getYRot());
                                        entity_a.yRotO = entity_a.getYRot();
                                        entity_a.xRotO = entity_a.getXRot();
                                        if (entity_a instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entity_a;
                                            _livEnt.yBodyRotO = _livEnt.getYRot();
                                            _livEnt.yHeadRotO = _livEnt.getYRot();
                                        }
                                        break;
                                    }
                                }

                                num3 += 360.0 / num1;
                                ++index1;
                            }
                        }

                        entityiterator = (Entity) var36.next();
                        if (entity != entityiterator) {
                            if (entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                                if (entity.getPersistentData().getDouble("skill") == 2719.0) {
                                    if (entity.getPersistentData().getDouble("cnt3") >= 20.0) {
                                        if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                                            entityiterator = entityiterator;
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                            }

                                            entityiterator = entity;
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma1").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                            }
                                        } else if (entity.getPersistentData().getDouble("cnt1") == 2.0) {
                                            entityiterator = entityiterator;
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                            }

                                            entityiterator = entity;
                                            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma2").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                            }
                                        } else if (entity.getPersistentData().getDouble("cnt1") == 3.0) {
                                            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                                                entityiterator = entityiterator;
                                                if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                                }

                                                entityiterator = entity;
                                                if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel) entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "title @s title {\"text\":\"" + Component.translatable("jujutsu.message.higuruma3").getString() + "\",\"color\":\"dark_red\",\"bold\":true}");
                                                }
                                            } else {
                                                entity.getPersistentData().putDouble("cnt1", 4.0);
                                            }
                                        } else if (entity.getPersistentData().getDouble("cnt1") >= 5.0 && LogicAttackDomainProcedure.execute(entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                            logic_a = false;
                                            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
                                            LazyOptional<IItemHandler> var811 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null);
                                            Objects.requireNonNull(_iitemhandlerref);
                                            var811.ifPresent(_iitemhandlerref::set);
                                            ItemStack _setstack;
                                            Player _player;
                                            if (_iitemhandlerref.get() != null) {
                                                for (int _idx = 0; _idx < ((IItemHandler) _iitemhandlerref.get()).getSlots(); ++_idx) {
                                                    _setstack = ((IItemHandler) _iitemhandlerref.get()).getStackInSlot(_idx).copy();
                                                    if (_setstack.is(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                                        logic_a = true;
                                                        if (entityiterator instanceof Player) {
                                                            _player = (Player) entityiterator;
                                                            _player.getCooldowns().addCooldown(_setstack.getItem(), 1800);
                                                        }
                                                    }
                                                }
                                            }

                                            if (!(entityiterator instanceof Player)) {
                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entityiterator;
                                                    var82 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                                                } else {
                                                    var82 = ItemStack.EMPTY;
                                                }

                                                if (var82.is(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                                    logic_a = true;
                                                    if (entityiterator instanceof Player) {
                                                        _player = (Player) entityiterator;
                                                        ItemCooldowns var83 = _player.getCooldowns();
                                                        ItemStack var80;
                                                        if (entityiterator instanceof LivingEntity) {
                                                            _livEnt = (LivingEntity) entityiterator;
                                                            var80 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                                                        } else {
                                                            var80 = ItemStack.EMPTY;
                                                        }

                                                        var83.addCooldown(var80.getItem(), 3600);
                                                    }
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entityiterator;
                                                    var82 = _livEnt.getMainHandItem();
                                                } else {
                                                    var82 = ItemStack.EMPTY;
                                                }

                                                if (var82.is(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                                    logic_a = true;
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity) entityiterator;
                                                        _setstack = ItemStack.EMPTY.copy();
                                                        _setstack.setCount(1);
                                                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                                        if (_entity instanceof Player) {
                                                            _player = (Player) _entity;
                                                            _player.getInventory().setChanged();
                                                        }
                                                    }
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entityiterator;
                                                    var82 = _livEnt.getOffhandItem();
                                                } else {
                                                    var82 = ItemStack.EMPTY;
                                                }

                                                if (var82.is(ItemTags.create(new ResourceLocation("jujutsucraft:has_technique_tools")))) {
                                                    logic_a = true;
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity) entityiterator;
                                                        _setstack = ItemStack.EMPTY.copy();
                                                        _setstack.setCount(1);
                                                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                                                        if (_entity instanceof Player) {
                                                            _player = (Player) _entity;
                                                            _player.getInventory().setChanged();
                                                        }
                                                    }
                                                }
                                            }

                                            if (!logic_a) {
                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entityiterator;
                                                    if (!_livEnt.level().isClientSide()) {
                                                        _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get(), 1800, 0, false, false));
                                                    }
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entityiterator;
                                                    if (!_livEnt.level().isClientSide()) {
                                                        _livEnt.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1800, 2, false, false));
                                                    }
                                                }
                                            }

                                            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                                                num1 = 0.0;

                                                for (int index0 = 0; index0 < 200; ++index0) {
                                                    ++num1;
                                                    if (item_a.getOrCreateTag().getString("TARGET" + Math.round(num1)).isEmpty()) {
                                                        item_a.getOrCreateTag().putString("TARGET" + Math.round(num1), entityiterator.getStringUUID());
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    } else if (LogicAttackDomainProcedure.execute(entity, entityiterator) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                        if (entityiterator instanceof HigurumaHiromiEntity) {
                                            entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4"), 1.0));
                                        } else {
                                            label725:
                                            {
                                                label724:
                                                {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entityiterator;
                                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                            break label724;
                                                        }
                                                    }

                                                    if (!(entityiterator instanceof MahitoEntity)) {
                                                        if (!entityiterator.getPersistentData().getBoolean("CurseUser") && !entityiterator.getPersistentData().getBoolean("CursedSpirit") && !(entityiterator instanceof ItadoriYujiEntity) && !(entityiterator instanceof ItadoriYujiShibuyaEntity)) {
                                                            if (entityiterator.getPersistentData().getBoolean("JujutsuSorcerer")) {
                                                                entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4"),  10 *  Mth.nextInt(RandomSource.create(), 1, 5)));
                                                            } else {
                                                                entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4"), 25.0 *  Mth.nextInt(RandomSource.create(), 1, 4)));
                                                            }
                                                        } else {
                                                            entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4"),  50 *  Mth.nextInt(RandomSource.create(), 1, 2)));
                                                        }
                                                        break label725;
                                                    }
                                                }

                                                entity.getPersistentData().putDouble("cnt4", Math.max(entity.getPersistentData().getDouble("cnt4"), 100.0));
                                            }
                                        }
                                    }
                                } else if (LogicAttackDomainProcedure.execute(entity, entityiterator)) {
                                    label838:
                                    {
                                        if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                            label708:
                                            {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity) entity;
                                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                        var79 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                        break label708;
                                                    }
                                                }

                                                var79 = 0;
                                            }

                                            if (var79 < 1) {
                                                break label838;
                                            }
                                        }

                                        label701:
                                        {
                                            ++num3;
                                            if (entityiterator instanceof LivingEntity) {
                                                _entity = (LivingEntity) entityiterator;
                                                if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                    var79 = _entity.getEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                                                    break label701;
                                                }
                                            }

                                            var79 = 0;
                                        }

                                        if (var79 < 1) {
                                            ++num1;
                                        }
                                    }
                                }
                            }

                            if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 || entityiterator.getPersistentData().getDouble("cnt6") != 0.0) {
                                if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.level().isClientSide()) {
                                    entityiterator.discard();
                                }

                                if (entityiterator.getPersistentData().getDouble("skill") > 0.0) {
                                    entityiterator.getPersistentData().putDouble("skill", 0.0);
                                }
                            }
                        }

                        if (entityiterator instanceof EntityWitnessStandEntity) {
                            ++num2;
                        }
                    }
                }

                entity.getPersistentData().putBoolean("DomainAttack", false);
            }

        }
    }
}
