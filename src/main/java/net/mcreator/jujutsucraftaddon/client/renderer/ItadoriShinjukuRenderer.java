
package net.mcreator.jujutsucraftaddon.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;

public class ItadoriShinjukuRenderer extends HumanoidMobRenderer<ItadoriShinjukuEntity, HumanoidModel<ItadoriShinjukuEntity>> {
	public ItadoriShinjukuRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<ItadoriShinjukuEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(ItadoriShinjukuEntity entity) {
		return new ResourceLocation("jujutsucraftaddon:textures/entities/itadorishinjukuskin.png");
	}
}
