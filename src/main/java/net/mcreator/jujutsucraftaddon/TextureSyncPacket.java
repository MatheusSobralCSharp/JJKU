package net.mcreator.jujutsucraftaddon;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class TextureSyncPacket {
//    private final String texture;
//    private final String displayName;
//
//    public TextureSyncPacket(String texture, String displayName) {
//        this.texture = texture;
//        this.displayName = displayName;
//    }
//
//    public static void encode(TextureSyncPacket packet, FriendlyByteBuf buffer) {
//        buffer.writeUtf(packet.texture);
//        buffer.writeUtf(packet.displayName);
//    }
//
//    public static TextureSyncPacket decode(FriendlyByteBuf buffer) {
//       String texture = buffer.readUtf(32767); // Read with a safe maximum length
//        String displayName = buffer.readUtf(32767);
//        return new TextureSyncPacket(texture, displayName);
//    }
//
//
//    public static void handle(TextureSyncPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
//        NetworkEvent.Context context = contextSupplier.get();
//        context.enqueueWork(() -> {
//            ServerPlayer player = context.getSender();
//            if (player != null) {
//                player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
//                        .ifPresent(capability -> {
//                            try {
//                                if (capability.MobTexture.isEmpty()) {
//                                    capability.SkinName1 = packet.displayName;
//                                    capability.MobTexture = packet.texture.toLowerCase();
//                                } else if (capability.MobTexture2.isEmpty()) {
//                                    capability.SkinName2 = packet.displayName;
//                                    capability.MobTexture2 = packet.texture.toLowerCase();
//                                } else if (capability.MobTexture3.isEmpty()) {
//                                    capability.SkinName3 = packet.displayName;
//                                    capability.MobTexture3 = packet.texture.toLowerCase();
//                                } else {
//
//                                }
//
//                                capability.ShadowName = packet.displayName;
//                                capability.Shadow = packet.texture.toLowerCase();
//                                capability.syncPlayerVariables(player);
//
//                            } catch (Exception e) {
//
//                            }
//                        });
//
//            }
//        });
//        context.setPacketHandled(true);
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    public static String sendTextureToServer(LivingEntity livingEntity) {
//        if (livingEntity == null) {
//            return "Invalid Entity";
//        }
//        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
//        EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
//        if (livingRenderer == null) {
//            return "Invalid Renderer";
//        }
//        ResourceLocation resourceLocation = livingRenderer.getTextureLocation(livingEntity);
//        String textureLocation = resourceLocation.toString().toLowerCase();
//        String displayName = livingEntity.getDisplayName().getString();
//
//        PacketHandler.sendToServer(new TextureSyncPacket(textureLocation, displayName));
//        return textureLocation;
//    }

}
