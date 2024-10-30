package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.item.YuunItem;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.List;
import java.util.Iterator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class WuStaffEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.getOrCreateTag().putDouble("Test", (Mth.nextInt(RandomSource.create(), 1, 10)));
		if (itemstack.getOrCreateTag().getDouble("Test") > 0) {
			if (itemstack.getOrCreateTag().getBoolean("Mode") == true) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null && !animation.isActive()) {
							animation.setAnimation(
									new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")))))));
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
									JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(
											Component.literal(("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test")))), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
							}
						}
					}
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("playsound jujutsucraftaddon:wu" + itemstack.getOrCreateTag().getDouble("Test") + " master @s"));
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("playsound jujutsucraftaddon:wu" + itemstack.getOrCreateTag().getDouble("Test") + " master @s")), false);
			if (itemstack.getItem() instanceof YuunItem)
				itemstack.getOrCreateTag().putString("geckoAnim", ("wu" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("Test"))));
			itemstack.getOrCreateTag().putDouble("Test", 0);
		}
	}
}
