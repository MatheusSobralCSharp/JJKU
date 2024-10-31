package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.List;
import java.util.Iterator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class GojoAnimationsProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 215) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                if (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {
                    if (!entity.isShiftKeyDown()) {
                        if (world.isClientSide()) {
                            if (entity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki"))));
                                }
                            }
                        }
                        if (!world.isClientSide()) {
                            if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
                                List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
                                synchronized (connections) {
                                    Iterator<Connection> iterator = connections.iterator();
                                    while (iterator.hasNext()) {
                                        Connection connection = iterator.next();
                                        if (!connection.isConnecting() && connection.isConnected())
                                            JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("murasaki"), entity.getId(), false), connection,
                                                    NetworkDirection.PLAY_TO_CLIENT);
                                    }
                                }
                            }
                        }
                    } else if (entity.isShiftKeyDown()) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 3) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
                                    }
                                }
                            }
                            if (!world.isClientSide()) {
                                if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
                                    List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
                                    synchronized (connections) {
                                        Iterator<Connection> iterator = connections.iterator();
                                        while (iterator.hasNext()) {
                                            Connection connection = iterator.next();
                                            if (!connection.isConnecting() && connection.isConnected())
                                                JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("murasaki2"), entity.getId(), false), connection,
                                                        NetworkDirection.PLAY_TO_CLIENT);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 215 && entity.getPersistentData().getDouble("cnt1") >= 0) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @s * jujutsucraft:electric_shock");
                    }
                }
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "gojopurple"))));
                        }
                    }
                }
                if (!world.isClientSide()) {
                    if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
                        List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
                        synchronized (connections) {
                            Iterator<Connection> iterator = connections.iterator();
                            while (iterator.hasNext()) {
                                Connection connection = iterator.next();
                                if (!connection.isConnecting() && connection.isConnected())
                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("gojopurple"), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
                            }
                        }
                    }
                }
                if (entity instanceof ServerPlayer _plr12 && _plr12.level() instanceof ServerLevel
                        && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
                    if (entity.getPersistentData().getDouble("cnt6") > 5) {
                        if (entity.getPersistentData().getDouble("cnt6") <= 50) {
                            entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 215) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
                if (!entity.isShiftKeyDown()) {
                    if (entity.getPersistentData().getDouble("cnt6") == 1) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund != 1) {
                            {
                                double _setval = 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.gojosund = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }
                }
            }
        }
        if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 206 && entity.getPersistentData().getDouble("cnt1") >= 0) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
                if (entity.isShiftKeyDown()) {
                    if (world.isClientSide()) {
                        if (entity instanceof AbstractClientPlayer player) {
                            var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "bluegojo"))));
                            }
                        }
                    }
                    if (!world.isClientSide()) {
                        if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
                            List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
                            synchronized (connections) {
                                Iterator<Connection> iterator = connections.iterator();
                                while (iterator.hasNext()) {
                                    Connection connection = iterator.next();
                                    if (!connection.isConnecting() && connection.isConnected())
                                        JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("bluegojo"), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
                                }
                            }
                        }
                    }
                    if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                            && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
                        if (entity.getPersistentData().getDouble("cnt6") > 5) {
                            if (entity.getPersistentData().getDouble("cnt6") <= 10) {
                                entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
                            }
                        }
                    }
                }
            }
            if (entity.getPersistentData().getDouble("PRESS_Z") == 1 && entity.getPersistentData().getDouble("skill") == 206 && entity.getPersistentData().getDouble("cnt1") == 1) {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
                    if (entity.isShiftKeyDown()) {
                        if (!(entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get()))) {
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu")), SoundSource.NEUTRAL, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:maximumblu")), SoundSource.NEUTRAL, 1, 1, false);
                                }
                            }
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_BLUE_ANIM.get(), 100, 1, false, false));
                        }
                    }
                }
            }
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund == 1
                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund < 2) {
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).gojosund + 1;
                    entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.gojosund = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    Entity _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run stopsound @s");
                    }
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:satorugojo")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            }
        }
    }
}
