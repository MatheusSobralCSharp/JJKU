package net.mcreator.jujutsucraftaddon.network;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.procedures.FireAspectProcedure;
import net.mcreator.jujutsucraftaddon.procedures.LootingProcedure;
import net.mcreator.jujutsucraftaddon.procedures.LureProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SharpnessProcedure;
import net.mcreator.jujutsucraftaddon.world.inventory.EnchantYorozuMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

import java.util.HashMap;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantYorozuButtonMessage {
    private final int buttonID, x, y, z;

    public EnchantYorozuButtonMessage(FriendlyByteBuf buffer) {
        this.buttonID = buffer.readInt();
        this.x = buffer.readInt();
        this.y = buffer.readInt();
        this.z = buffer.readInt();
    }

    public EnchantYorozuButtonMessage(int buttonID, int x, int y, int z) {
        this.buttonID = buttonID;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void buffer(EnchantYorozuButtonMessage message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.buttonID);
        buffer.writeInt(message.x);
        buffer.writeInt(message.y);
        buffer.writeInt(message.z);
    }

    public static void handler(EnchantYorozuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
        HashMap guistate = EnchantYorozuMenu.guistate;
        // security measure to prevent arbitrary chunk generation
        if (!world.hasChunkAt(new BlockPos(x, y, z)))
            return;
        if (buttonID == 0) {

            SharpnessProcedure.execute(world, entity);
        }
        if (buttonID == 1) {

            LootingProcedure.execute(world, entity);
        }
        if (buttonID == 2) {

            FireAspectProcedure.execute(world, entity);
        }
        if (buttonID == 3) {

            LureProcedure.execute(world, entity);
        }
    }

    @SubscribeEvent
    public static void registerMessage(FMLCommonSetupEvent event) {
        JujutsucraftaddonMod.addNetworkMessage(EnchantYorozuButtonMessage.class, EnchantYorozuButtonMessage::buffer, EnchantYorozuButtonMessage::new, EnchantYorozuButtonMessage::handler);
    }
}
