
package net.mcreator.jujutsucraftaddon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;
import net.mcreator.jujutsucraftaddon.client.model.ModelCiclo2;

import com.mojang.blaze3d.vertex.PoseStack;

public class CleaveWebRenderer extends MobRenderer<CleaveWebEntity, ModelCiclo2<CleaveWebEntity>> {
	public CleaveWebRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCiclo2(context.bakeLayer(ModelCiclo2.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(CleaveWebEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(10f, 10f, 10f);
	}

	@Override
	public ResourceLocation getTextureLocation(CleaveWebEntity entity) {
		return new ResourceLocation("jujutsucraftaddon:textures/entities/cowebwhite.png");
	}
}
