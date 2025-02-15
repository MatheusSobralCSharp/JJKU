package net.mcreator.jujutsucraftaddon.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparation2Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class CloneRenderer extends HumanoidMobRenderer<CloneEntity, HumanoidModel<CloneEntity>> {
//    private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
//    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
//    private final HumanoidModel<CloneEntity> slimModel;
//    private final HumanoidModel<CloneEntity> defaultModel;


    public CloneRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
        this.addLayer(new RenderLayer<CloneEntity, HumanoidModel<CloneEntity>>(this) {
            final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");



            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CloneEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
                ResourceLocation textureLocation;
                // Get the owner entity
                LivingEntity livingEntity = entity.getOwner();
                if (livingEntity != null) {
                    EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                    EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
                    textureLocation = livingRenderer.getTextureLocation(livingEntity);
                } else {
                    textureLocation = LAYER_TEXTURE;
                }
                VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(textureLocation));
                this.getParentModel().renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
            }
        });

    }

    @Override
    public ResourceLocation getTextureLocation(CloneEntity entity) {
        String shadowTexturePath = entity.getEntityData().get(CloneEntity.DATA_Testing).toLowerCase();

        if (!shadowTexturePath.isEmpty()) {
            return new ResourceLocation(shadowTexturePath);
        }

        LivingEntity livingEntity = entity.getOwner();
        if (livingEntity == null) {
            return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
        }

        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
        return livingRenderer.getTextureLocation(livingEntity);
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

