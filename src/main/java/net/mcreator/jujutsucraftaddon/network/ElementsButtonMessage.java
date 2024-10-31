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

import net.mcreator.jujutsucraftaddon.world.inventory.ElementsMenu;
import net.mcreator.jujutsucraftaddon.procedures.SetEarthProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SelectWindProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SelectWaterProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SelectLightningProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SelectFireProcedure;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ElementsButtonMessage {
    private final int buttonID, x, y, z;
    private HashMap<String, String> textstate;

    public ElementsButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
        this.textstate = readTextState(buffer);
    }

    public ElementsButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
        this.textstate = textstate;

    }

    public static void buffer(ElementsButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
        writeTextState(message.textstate, buffer);
    }

    public static void handler(ElementsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        HashMap guistate = ElementsMenu.guistate;
        for (Map.Entry<String, String> entry : textstate.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            guistate.put(key, value);
        }
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            SelectLightningProcedure.execute(entity);
        }
        if (buttonID == 1) {

            SelectFireProcedure.execute(entity);
        }
        if (buttonID == 2) {

            SetEarthProcedure.execute(entity);
        }
        if (buttonID == 3) {

            SelectWaterProcedure.execute(entity);
        }
        if (buttonID == 4) {

            SelectWindProcedure.execute(entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(ElementsButtonMessage.class, ElementsButtonMessage::buffer, ElementsButtonMessage::new, ElementsButtonMessage::handler);
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
