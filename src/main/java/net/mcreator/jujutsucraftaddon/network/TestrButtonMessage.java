
package net.mcreator.jujutsucraftaddon.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.world.inventory.TestrMenu;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowTechniqueProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowRangeProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowPowerProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowHealthProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BindingVowChantsProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestrButtonMessage {
	private final int buttonID, x, y, z;

	public TestrButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TestrButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TestrButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TestrButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = TestrMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BindingVowPowerProcedure.execute(entity);
		}
		if (buttonID == 1) {

			BindingVowHealthProcedure.execute(entity);
		}
		if (buttonID == 2) {

			BindingVowTechniqueProcedure.execute(entity);
		}
		if (buttonID == 3) {

			BindingVowRangeProcedure.execute(entity);
		}
		if (buttonID == 4) {

			BindingVowChantsProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		JujutsucraftaddonMod.addNetworkMessage(TestrButtonMessage.class, TestrButtonMessage::buffer, TestrButtonMessage::new, TestrButtonMessage::handler);
	}
}
