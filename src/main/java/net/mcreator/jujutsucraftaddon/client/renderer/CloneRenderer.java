package net.mcreator.jujutsucraftaddon.client.renderer;

import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.loading.FMLPaths;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

public class CloneRenderer extends HumanoidMobRenderer<CloneEntity, HumanoidModel<CloneEntity>> {
//    private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
//    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
//    private final HumanoidModel<CloneEntity> slimModel;
//    private final HumanoidModel<CloneEntity> defaultModel;


    public CloneRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(CloneEntity entity) {
        String shadowTexturePath = entity.getEntityData().get(CloneEntity.DATA_Testing).toLowerCase();

        if (!shadowTexturePath.isEmpty()) {
            return new ResourceLocation(shadowTexturePath);
        }

        LivingEntity livingEntity = entity.getOwner();
        if (livingEntity != null) {
            EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
            EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
            return livingRenderer.getTextureLocation(livingEntity);
        }

        return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
    }
}
//
//    private ResourceLocation getCustomSkin(String skinUrl) {
//        if (skinUrl.startsWith("jujutsucraft:")) {
//            return new ResourceLocation(skinUrl);
//        }
//
//        // Otherwise, validate the URL and attempt to download
//        if (!skinUrl.startsWith("http://") && !skinUrl.startsWith("https://")) {
//            return new ResourceLocation("test:textures/entities/clone_empty.png");
//        }
//
//        String skinHash = Integer.toHexString(skinUrl.hashCode());
//        return downloadAndRegisterSkin(skinUrl, skinHash);
//    }
//
//    private ResourceLocation downloadAndRegisterSkin(String skinUrl, String skinHash) {
//        ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
//        File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
//        File skinFile = new File(skinDir, skinHash + ".png");
//
//        if (!skinDir.exists()) {
//            skinDir.mkdirs();
//        }
//
//        if (!skinFile.exists()) {
//            try {
//                downloadSkin(skinUrl, skinFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//                return DefaultPlayerSkin.getDefaultSkin(UUID.randomUUID());
//            }
//        }
//
//        HttpTexture httpTexture = new HttpTexture(skinFile, skinUrl, DefaultPlayerSkin.getDefaultSkin(UUID.randomUUID()), false, null);
//        textureManager.register(resourceLocation, httpTexture);
//
//        return resourceLocation;
//    }
//
//
//    @Override
//    public void render(CloneEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
//        if (entity.isTame() && entity.getEntityData().get(CloneEntity.DATA_Testing).isEmpty()) {
//            if (entity.isTame() && entity.getOwnerUUID() != null) {
//                UUID ownerUUID = entity.getOwnerUUID();
//                this.model = getModel(ownerUUID);
//            }
//        } else {
//
//        }
//        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
//    }
//
//    private HumanoidModel<CloneEntity> getModel(UUID uuid) {
//        boolean isSlim = isSlimSkin(uuid);
//        return isSlim ? slimModel : defaultModel;
//    }
//
//    private ResourceLocation getPlayerSkin(UUID uuid) {
//        GameProfile profile = new GameProfile(uuid, null);
//        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures = sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);
//
//        if (textures.containsKey(MinecraftProfileTexture.Type.SKIN)) {
//            MinecraftProfileTexture profileTexture = textures.get(MinecraftProfileTexture.Type.SKIN);
//            String skinUrl = profileTexture.getUrl();
//            String skinHash = profileTexture.getHash();
//            ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
//            File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
//            File skinFile = new File(skinDir, skinHash + ".png");
//
//            if (!skinDir.exists()) {
//                skinDir.mkdirs();
//            }
//
//            if (!skinFile.exists()) {
//                try {
//                    downloadSkin(skinUrl, skinFile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return DefaultPlayerSkin.getDefaultSkin(uuid);
//                }
//            }
//
//            // Register the texture with Minecraft's texture manager using HttpTexture
//            HttpTexture httpTexture = new HttpTexture(skinFile, skinUrl, DefaultPlayerSkin.getDefaultSkin(uuid), false, null);
//            textureManager.register(resourceLocation, httpTexture);
//
//
//
//            return resourceLocation;
//        } else {
//            return DefaultPlayerSkin.getDefaultSkin(uuid);
//        }
//    }
//
//    private void downloadSkin(String skinUrl, File skinFile) throws IOException {
//        HttpURLConnection connection = (HttpURLConnection) new URL(skinUrl).openConnection();
//        connection.setRequestMethod("GET");
//        connection.setConnectTimeout(5000);
//        connection.setReadTimeout(5000);
//
//        try (InputStream inputStream = connection.getInputStream()) {
//            Files.copy(inputStream, skinFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//        } finally {
//            connection.disconnect();
//        }
//    }
//
//    private boolean isSlimSkin(UUID uuid) {
//        GameProfile profile = new GameProfile(uuid, null);
//        profile = sessionService.fillProfileProperties(profile, false);
//        if (profile.getProperties().containsKey("textures")) {
//            for (Property property : profile.getProperties().get("textures")) {
//                String value = new String(java.util.Base64.getDecoder().decode(property.getValue()));
//                if (value.contains("\"slim\"")) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

