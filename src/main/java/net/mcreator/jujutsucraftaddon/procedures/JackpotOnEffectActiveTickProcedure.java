package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.List;
import java.util.Iterator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class JackpotOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide()) {
            if (entity instanceof AbstractClientPlayer player) {
                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                if (animation != null && !animation.isActive()) {
                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "tucadonca"))));
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
                            JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("tucadonca"), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
                    }
                }
            }
        }
    }
}
