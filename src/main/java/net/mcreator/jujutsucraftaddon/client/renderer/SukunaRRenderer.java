
package net.mcreator.jujutsucraftaddon.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.jujutsucraftaddon.entity.model.SukunaRModel;
import net.mcreator.jujutsucraftaddon.entity.layer.SukunaRLayer;
import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SukunaRRenderer extends GeoEntityRenderer<SukunaREntity> {
	public SukunaRRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SukunaRModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new SukunaRLayer(this));
	}


	@Override
	public RenderType getRenderType(SukunaREntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SukunaREntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
