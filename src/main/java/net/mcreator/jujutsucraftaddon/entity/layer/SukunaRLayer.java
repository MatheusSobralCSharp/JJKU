package net.mcreator.jujutsucraftaddon.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SukunaRLayer extends GeoRenderLayer<SukunaREntity> {
    private static final ResourceLocation LAYER = new ResourceLocation("jujutsucraftaddon", "textures/entities/sukunamark1.png");

    public SukunaRLayer(GeoRenderer<SukunaREntity> entityRenderer) {
        super(entityRenderer);
    }

    @Override
    public void render(PoseStack poseStack, SukunaREntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType normalRenderType = RenderType.entityCutout(LAYER);
        poseStack.pushPose();
        getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, normalRenderType, bufferSource.getBuffer(normalRenderType), partialTick, packedLight, packedOverlay, 1, 1, 1, 1);
        poseStack.popPose();
    }
}