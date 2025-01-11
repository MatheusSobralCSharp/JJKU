/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.jujutsucraftaddon as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.jujutsucraftaddon;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;


public class PacketHandler {
//	public static final String PROTOCOL_VERSION = "2.2";
//	private static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
//			new ResourceLocation(JujutsucraftaddonMod.MODID, "main_channel"),
//			() -> PROTOCOL_VERSION,
//			PROTOCOL_VERSION::equals,
//			PROTOCOL_VERSION::equals
//	);
//
//	private static int packetId = 0; // A dynamic counter for packet IDs
//
//	/**
//	 * Registers all packets in the mod.
//	 */
//	public static void registerMessages() {
//		registerMessage(TextureSyncPacket.class, TextureSyncPacket::encode, TextureSyncPacket::decode, TextureSyncPacket::handle);
//		// Add more packets here as needed in the future
//	}
//
//	/**
//	 * Dynamically registers a packet with the network channel.
//	 *
//	 * @param packetClass The class of the packet.
//	 * @param encoder     A function to encode the packet.
//	 * @param decoder     A function to decode the packet.
//	 * @param handler     A consumer to handle the packet.
//	 * @param <T>         The packet type.
//	 */
//	private static <T> void registerMessage(Class<T> packetClass, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> handler) {
//		INSTANCE.registerMessage(
//				packetId++, // Incrementing ID ensures unique registration
//				packetClass,
//				encoder,
//				decoder,
//				handler
//		);
//	}
//
//	/**
//	 * Gets the SimpleChannel instance for this mod.
//	 *
//	 * @return The network channel instance.
//	 */
//	public static SimpleChannel getChannel() {
//		return INSTANCE;
//	}
//
//	/**
//	 * Sends a packet to a specific target.
//	 *
//	 * @param target  The packet target (e.g., specific player or dimension).
//	 * @param message The packet to send.
//	 */
//	public static void send(PacketDistributor.PacketTarget target, Object message) {
//		INSTANCE.send(target, message);
//	}
//
//	/**
//	 * Sends a packet to the server. THIS CASE I USED FOR SEND THE TEXTURE TO THE SERVER THEN RETURN TO THE CLIENT
//	 *
//	 * @param message The packet to send.
//	 */
//	public static void sendToServer(Object message) {
//		INSTANCE.sendToServer(message);
//	}
}
