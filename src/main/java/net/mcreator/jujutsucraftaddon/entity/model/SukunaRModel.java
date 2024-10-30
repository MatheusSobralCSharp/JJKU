package net.mcreator.jujutsucraftaddon.entity.model;

import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.GeoModel;

public class SukunaRModel extends GeoModel<SukunaREntity> {
	@Override
	public ResourceLocation getAnimationResource(SukunaREntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "animations/human.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SukunaREntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "geo/human.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SukunaREntity entity) {
		LivingEntity ownerEntity = entity.getOwner();

		if (ownerEntity != null) {
			EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
			EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(ownerEntity);
			ResourceLocation ownerTexture = livingRenderer.getTextureLocation(ownerEntity);

			if (entity instanceof SukunaREntity) {
				entity.getEntityData().set(SukunaREntity.DATA_Testing, ownerTexture.toString());
			}

			return ownerTexture;
		}

		String dataTestingTexture = entity.getEntityData().get(SukunaREntity.DATA_Testing).toLowerCase();

		if (!dataTestingTexture.isEmpty()) {
			return new ResourceLocation(dataTestingTexture);
		}

		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}