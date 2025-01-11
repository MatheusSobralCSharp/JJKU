
package net.mcreator.jujutsucraftaddon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.jujutsucraftaddon.entity.AntiVeilEntity;

public class AntiVeilRenderer extends HumanoidMobRenderer<AntiVeilEntity, HumanoidModel<AntiVeilEntity>> {
	public AntiVeilRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<AntiVeilEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(AntiVeilEntity entity) {
		return new ResourceLocation("jujutsucraftaddon:textures/entities/ejntity.png");
	}
}
