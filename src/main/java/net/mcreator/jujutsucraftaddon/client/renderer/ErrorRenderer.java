package net.mcreator.jujutsucraftaddon.client.renderer;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.properties.Property;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraftaddon.entity.ErroEntity;
import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;
import net.mcreator.jujutsucraftaddon.entity.layer.ErrorLayer;
import net.mcreator.jujutsucraftaddon.entity.model.ErrorModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.UUID;

public class ErrorRenderer extends GeoEntityRenderer<ErrorEntity> {
    private static final MinecraftSessionService sessionService = Minecraft.getInstance().getMinecraftSessionService();
    private final TextureManager textureManager = Minecraft.getInstance().getTextureManager();
    private final GeoModel<ErrorEntity> slimModel;
    private final GeoModel<ErrorEntity> defaultModel;
    private GeoModel<ErrorEntity> currentModel;

    public ErrorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ErrorModel());
        this.shadowRadius = 0.5f;
        this.addRenderLayer(new ErrorLayer(this));
        this.addRenderLayer(new ErrorRenderer2(this, this));
        this.addRenderLayer(new ErrorRenderer3(this, this));
        this.slimModel = new ErrorModel();
        this.defaultModel = new ErrorModel();
        this.currentModel = this.defaultModel;
    }

    @Override
    public ResourceLocation getTextureLocation(ErrorEntity entity) {
        if (entity.getOwnerUUID() != null) {
            LivingEntity livingEntity = entity.getOwner();
            if (livingEntity != null) {
                EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
                EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(livingEntity);
                return livingRenderer.getTextureLocation(livingEntity);
            }
        }

        return new ResourceLocation("jujutsucraftaddon:textures/entities/pmcskin3d-steve.png");
    }

    @Override
    public RenderType getRenderType(ErrorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }


    @Override
    public void preRender(PoseStack poseStack, ErrorEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
                          float blue, float alpha) {
        float scale = 1f;
        this.scaleHeight = scale;
        this.scaleWidth = scale;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

//
//    @Override
//    public void render(ErrorEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
////        if (entity.getOwnerUUID() != null) {
////            UUID ownerUUID = entity.getOwnerUUID();
////            this.currentModel = getModel(ownerUUID);
////        }
//        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
//    }

//    private GeoModel<ErrorEntity> getModel(UUID uuid) {
//        boolean isSlim = isSlimSkin(uuid);
//        return isSlim ? slimModel : defaultModel;
//    }

//    private ResourceLocation getPlayerSkin(UUID uuid) {
//        GameProfile profile = new GameProfile(uuid, null);
//        Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> textures = sessionService.getTextures(sessionService.fillProfileProperties(profile, false), false);
//        if (textures.containsKey(MinecraftProfileTexture.Type.SKIN)) {
//            MinecraftProfileTexture profileTexture = textures.get(MinecraftProfileTexture.Type.SKIN);
//            String skinUrl = profileTexture.getUrl();
//            String skinHash = profileTexture.getHash();
//            ResourceLocation resourceLocation = new ResourceLocation("skins/" + skinHash);
//            File skinDir = new File(FMLPaths.GAMEDIR.get().toFile(), "cached_skins");
//            File skinFile = new File(skinDir, skinHash + ".png");
//            if (!skinDir.exists()) {
//                skinDir.mkdirs();
//            }
//            if (!skinFile.exists()) {
//                try {
//                    downloadSkin(skinUrl, skinFile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return DefaultPlayerSkin.getDefaultSkin(uuid);
//                }
//            }
//            // Register the texture with Minecraft's texture manager using HttpTexture
//            HttpTexture httpTexture = new HttpTexture(skinFile, skinUrl, DefaultPlayerSkin.getDefaultSkin(uuid), false, null);
//            textureManager.register(resourceLocation, httpTexture);
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
}

class ErrorRenderer2 extends BlockAndItemGeoLayer<ErrorEntity> {

    private final ErrorRenderer ErrorRenderer;

    public ErrorRenderer2(ErrorRenderer ErrorRenderer, GeoRenderer<ErrorEntity> renderer) {
        super(renderer);
        this.ErrorRenderer = ErrorRenderer;
    }

    @Nullable
    @Override
    protected ItemStack getStackForBone(GeoBone bone, ErrorEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft" -> ErrorRenderer.getAnimatable().getMainHandItem();
            case "HandRight" -> ErrorRenderer.getAnimatable().getOffhandItem();
            default -> null;
        };
    }

    @Override
    protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, ErrorEntity animatable) {
        return switch (bone.getName()) {
            case "HandLeft", "HandRight" -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
            default -> ItemDisplayContext.NONE;
        };
    }

    @Override
    protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, ErrorEntity animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
        if (stack.equals(ErrorRenderer.getAnimatable().getMainHandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, -0.25);
            }
        } else if (stack.equals(ErrorRenderer.getAnimatable().getOffhandItem())) {
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            if (stack.getItem() instanceof ShieldItem) {
                poseStack.translate(0.0, 0.125, 0.25);
                poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            }
        }

        super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
    }
}

class ErrorRenderer3 extends ItemArmorGeoLayer<ErrorEntity> {
    private final ErrorRenderer ErrorRenderer2;

    public ErrorRenderer3(ErrorRenderer ErrorRenderer2, GeoRenderer<ErrorEntity> geoRenderer) {
        super(geoRenderer);
        this.ErrorRenderer2 = ErrorRenderer2;
    }

    @Nullable
    protected ItemStack getArmorItemForBone(GeoBone bone, ErrorEntity animatable) {
        ItemStack var10000;
        switch (bone.getName()) {
            case "armorLeftFoot":
            case "armorRightFoot":
            case "left_leg_boot":
            case "right_leg_boot":
                var10000 = this.bootsStack;
                break;
            case "armorLeftLeg":
            case "armorRightLeg":
                var10000 = this.leggingsStack;
                break;
            case "armorBody":
            case "armorArmRight":
            case "armorArmLeft":
                var10000 = this.chestplateStack;
                break;
            case "armorHead":
                var10000 = this.helmetStack;
                break;
            default:
                var10000 = null;
        }

        return var10000;
    }

    @Nonnull
    protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, ErrorEntity animatable) {
        EquipmentSlot var10000;
        switch (bone.getName()) {
            case "armorLeftFoot":
            case "armorRightFoot":
            case "left_leg_boot":
            case "right_leg_boot":
                var10000 = EquipmentSlot.FEET;
                break;
            case "armorLeftLeg":
            case "armorRightLeg":
                var10000 = EquipmentSlot.LEGS;
                break;
            case "armorArmRight":
                var10000 = EquipmentSlot.MAINHAND;
                break;
            case "armorArmLeft":
                var10000 = EquipmentSlot.OFFHAND;
                break;
            case "armorBody":
                var10000 = EquipmentSlot.CHEST;
                break;
            case "armorHead":
                var10000 = EquipmentSlot.HEAD;
                break;
            default:
                var10000 = super.getEquipmentSlotForBone(bone, stack, animatable);
        }

        return var10000;
    }

    @Nonnull
    protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, ErrorEntity animatable, HumanoidModel<?> baseModel) {
        ModelPart var10000;
        if ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot") || ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot"))) {
            switch (bone.getName()) {
                case "armorLeftLeg":
                case "left_leg_boot":
                    var10000 = baseModel.leftLeg;
                    break;
                case "armorRightLeg":
                case "right_leg_boot":
                    var10000 = baseModel.rightLeg;
                    break;
                case "armorArmRight":
                    var10000 = baseModel.rightArm;
                    break;
                case "armorArmLeft":
                    var10000 = baseModel.leftArm;
                    break;
                case "armorBody":
                    var10000 = baseModel.body;
                    break;
                case "armorHead":
                    var10000 = baseModel.head;
                    break;
                default:
                    var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
            }
            return var10000;
        } else {
            switch (bone.getName()) {
                case "armorLeftFoot":
                case "armorLeftLeg":
                    var10000 = baseModel.leftLeg;
                    break;
                case "armorRightFoot":
                case "armorRightLeg":
                    var10000 = baseModel.rightLeg;
                    break;
                case "armorArmRight":
                    var10000 = baseModel.rightArm;
                    break;
                case "armorArmLeft":
                    var10000 = baseModel.leftArm;
                    break;
                case "armorBody":
                    var10000 = baseModel.body;
                    break;
                case "armorHead":
                    var10000 = baseModel.head;
                    break;
                default:
                    var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
            }
        }
        return var10000;
    }
}

