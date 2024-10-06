
package net.mcreator.jujutsucraftaddon.client.renderer;

import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class CloneRenderer extends HumanoidMobRenderer<CloneEntity, HumanoidModel<CloneEntity>> {
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
