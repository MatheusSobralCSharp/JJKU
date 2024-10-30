package net.mcreator.jujutsucraftaddon;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TextureSyncPacket {
    private final String texture;
    private final String displayName;

    // Constructor
    public TextureSyncPacket(String texture, String displayName) {
        this.texture = texture;
        this.displayName = displayName;
    }

    // Encoding the packet data
    public static void encode(TextureSyncPacket packet, FriendlyByteBuf buffer) {
        buffer.writeUtf(packet.texture);
        buffer.writeUtf(packet.displayName);
    }

    // Decoding the packet data
    public static TextureSyncPacket decode(FriendlyByteBuf buffer) {
        String texture = buffer.readUtf();
        String displayName = buffer.readUtf();
        return new TextureSyncPacket(texture, displayName);
    }

    // Handling the packet when received
    public static void handle(TextureSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        contextSupplier.get().enqueueWork(() -> {
            String texture = packet.texture;
            String displayName = packet.displayName;
            System.out.println("Received texture: " + texture + " from: " + displayName);
            NetworkEvent.Context context = contextSupplier.get();

            if (context.getSender() != null) {
                ServerPlayer player = context.getSender();

                // Ensure capability is present before accessing it
                player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    // Initialize values if they are null to prevent NullPointerException
                    if (capability.MobTexture == null) {
                        capability.MobTexture = "";
                    }
                    if (capability.MobTexture2 == null) {
                        capability.MobTexture2 = "";
                    }
                    if (capability.MobTexture3 == null) {
                        capability.MobTexture3 = "";
                    }

                    // Check and set textures accordingly
                    if (capability.MobTexture.isEmpty()) {
                        capability.SkinName1 = displayName;
                        capability.MobTexture = texture.toLowerCase();
                    } else if (capability.MobTexture2.isEmpty()) {
                        capability.SkinName2 = displayName;
                        capability.MobTexture2 = texture.toLowerCase();
                    } else if (capability.MobTexture3.isEmpty()) {
                        capability.SkinName3 = displayName;
                        capability.MobTexture3 = texture.toLowerCase();
                    }

                    // Set ShadowName and Shadow even if other textures are already set
                    capability.ShadowName = displayName;
                    capability.Shadow = texture.toLowerCase();

                    // Sync player variables and add null checks for any NBT processing
                    try {
                        capability.syncPlayerVariables(player);
                    } catch (Exception e) {
                        System.out.println("Failed to sync player variables: " + e.getMessage());
                        e.printStackTrace();
                    }
                });
            }
        });
        contextSupplier.get().setPacketHandled(true);
    }

    // This method is client-side only, so it must be annotated or restricted to run only on the client
    @OnlyIn(Dist.CLIENT)
    public static String sendTextureToServer(LivingEntity livingEntity) {
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
        ResourceLocation resourceLocation = livingRenderer.getTextureLocation(livingEntity);

        String textureLocation = resourceLocation.toString().toLowerCase();
        String displayName = livingEntity.getDisplayName().getString();

        // Send the texture information to the server
        JujutsucraftaddonModNetworkHandler.sendToServer(new TextureSyncPacket(textureLocation, displayName));

        return textureLocation;
    }
}
