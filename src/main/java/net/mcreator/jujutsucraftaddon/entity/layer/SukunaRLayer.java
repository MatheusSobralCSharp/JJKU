package net.mcreator.jujutsucraftaddon.entity.layer;

import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SukunaRLayer extends GeoRenderLayer<SukunaREntity> {
	private static final ResourceLocation LAYER = new ResourceLocation("jujutsucraftaddon", "textures/entities/sukunamark1.png");

	public SukunaRLayer(GeoRenderer<SukunaREntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, SukunaREntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		RenderType normalRenderType = RenderType.entityCutout(LAYER);
		// Adjust pose stack if necessary (translation, rotation, etc.)
		poseStack.pushPose();
		// Add any transformations here if needed, for example:
		// poseStack.translate(0.0, 0.0, 0.0); // adjust this based on where you want the layer
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, normalRenderType, bufferSource.getBuffer(normalRenderType), partialTick, packedLight, packedOverlay, 1, 1, 1, 1);
		poseStack.popPose();
	}
}