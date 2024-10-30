
package net.mcreator.jujutsucraftaddon.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.world.inventory.KenjakuBodySwapMenu;
import net.mcreator.jujutsucraftaddon.procedures.RemoveUserProcedure;
import net.mcreator.jujutsucraftaddon.procedures.KenjakuCTClickProcedure;
import net.mcreator.jujutsucraftaddon.procedures.CTSet2Procedure;
import net.mcreator.jujutsucraftaddon.procedures.CTSet1Procedure;
import net.mcreator.jujutsucraftaddon.procedures.CTNameClicked2Procedure;
import net.mcreator.jujutsucraftaddon.procedures.CTNameClicked1Procedure;
import net.mcreator.jujutsucraftaddon.procedures.Body3Procedure;
import net.mcreator.jujutsucraftaddon.procedures.Body2Procedure;
import net.mcreator.jujutsucraftaddon.procedures.Body1Procedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KenjakuBodySwapButtonMessage {
	private final int buttonID, x, y, z;
	private HashMap<String, String> textstate;

	public KenjakuBodySwapButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.textstate = readTextState(buffer);
	}

	public KenjakuBodySwapButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.textstate = textstate;

	}

	public static void buffer(KenjakuBodySwapButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		writeTextState(message.textstate, buffer);
	}

	public static void handler(KenjakuBodySwapButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			HashMap<String, String> textstate = message.textstate;
			handleButtonAction(entity, buttonID, x, y, z, textstate);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
		Level world = entity.level();
		HashMap guistate = KenjakuBodySwapMenu.guistate;
		for (Map.Entry<String, String> entry : textstate.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			guistate.put(key, value);
		}
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			KenjakuCTClickProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			CTSet1Procedure.execute(world, entity);
		}
		if (buttonID == 2) {

			CTSet2Procedure.execute(world, entity);
		}
		if (buttonID == 3) {

			CTNameClicked2Procedure.execute(entity);
		}
		if (buttonID == 4) {

			CTNameClicked1Procedure.execute(entity);
		}
		if (buttonID == 5) {

			Body1Procedure.execute(entity);
		}
		if (buttonID == 6) {

			Body2Procedure.execute(entity);
		}
		if (buttonID == 7) {

			Body3Procedure.execute(entity);
		}
		if (buttonID == 8) {

			RemoveUserProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		JujutsucraftaddonMod.addNetworkMessage(KenjakuBodySwapButtonMessage.class, KenjakuBodySwapButtonMessage::buffer, KenjakuBodySwapButtonMessage::new, KenjakuBodySwapButtonMessage::handler);
	}

	public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
		buffer.writeInt(map.size());
		for (Map.Entry<String, String> entry : map.entrySet()) {
			buffer.writeComponent(Component.literal(entry.getKey()));
			buffer.writeComponent(Component.literal(entry.getValue()));
		}
	}

	public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
		int size = buffer.readInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String key = buffer.readComponent().getString();
			String value = buffer.readComponent().getString();
			map.put(key, value);
		}
		return map;
	}
}
