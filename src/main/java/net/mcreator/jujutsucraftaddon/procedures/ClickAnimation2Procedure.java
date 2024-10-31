package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Iterator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class ClickAnimation2Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1) {
            if (!((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("kusakabe"))) {
                if (!((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("nyoi"))) {
                    if (!((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")
                            || (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud"))) {
                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 34))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("attack" + Mth.nextInt(RandomSource.create(), 2, 34))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            } else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 10))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("sword" + Mth.nextInt(RandomSource.create(), 1, 10))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 34))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("attack" + Mth.nextInt(RandomSource.create(), 2, 34))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            } else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 10, 24))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("sword" + Mth.nextInt(RandomSource.create(), 10, 24))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                            if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 34))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("attack" + Mth.nextInt(RandomSource.create(), 2, 34))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            } else if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (entity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
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
                                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                            new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("sword" + Mth.nextInt(RandomSource.create(), 1, 24))), entity.getId(), false), connection,
                                                            NetworkDirection.PLAY_TO_CLIENT);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")) {
                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 2))))));
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
                                                JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                        new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("soul" + Mth.nextInt(RandomSource.create(), 1, 2))), entity.getId(), false), connection,
                                                        NetworkDirection.PLAY_TO_CLIENT);
                                        }
                                    }
                                }
                            }
                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 2, 3))))));
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
                                                JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                        new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("soul" + Mth.nextInt(RandomSource.create(), 2, 3))), entity.getId(), false), connection,
                                                        NetworkDirection.PLAY_TO_CLIENT);
                                        }
                                    }
                                }
                            }
                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 4, 5))))));
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
                                                JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                        new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("soul" + Mth.nextInt(RandomSource.create(), 4, 5))), entity.getId(), false), connection,
                                                        NetworkDirection.PLAY_TO_CLIENT);
                                        }
                                    }
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {
                        if (world.isClientSide()) {
                            if (entity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
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
                                            JujutsucraftaddonMod.PACKET_HANDLER.sendTo(
                                                    new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")), entity.getId(), false), connection,
                                                    NetworkDirection.PLAY_TO_CLIENT);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (world.isClientSide()) {
                        if (entity instanceof AbstractClientPlayer player) {
                            var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("nyoi" + Mth.nextInt(RandomSource.create(), 1, 9))))));
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
                                        JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("nyoi" + Mth.nextInt(RandomSource.create(), 1, 9))), entity.getId(), false),
                                                connection, NetworkDirection.PLAY_TO_CLIENT);
                                }
                            }
                        }
                    }
                }
            } else {
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("kusa" + Mth.nextInt(RandomSource.create(), 1, 6))))));
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
                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("kusa" + Mth.nextInt(RandomSource.create(), 1, 6))), entity.getId(), false),
                                            connection, NetworkDirection.PLAY_TO_CLIENT);
                            }
                        }
                    }
                }
            }
        } else {
            if (world.isClientSide()) {
                if (entity instanceof AbstractClientPlayer player) {
                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                    if (animation != null && !animation.isActive()) {
                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sukuna" + Mth.nextInt(RandomSource.create(), 1, 16))))));
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
                                JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal(("sukuna" + Mth.nextInt(RandomSource.create(), 1, 16))), entity.getId(), false),
                                        connection, NetworkDirection.PLAY_TO_CLIENT);
                        }
                    }
                }
            }
        }
    }
}
