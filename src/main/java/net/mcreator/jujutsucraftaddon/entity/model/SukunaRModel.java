package net.mcreator.jujutsucraftaddon.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;

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

		// If there's an owner, retrieve the owner's texture
		if (ownerEntity != null) {
			EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
			EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(ownerEntity);
			ResourceLocation ownerTexture = livingRenderer.getTextureLocation(ownerEntity);

			// Set the owner texture to the entity's data using DATA_Testing
			if (entity instanceof SukunaREntity) {
				entity.getEntityData().set(SukunaREntity.DATA_Testing, ownerTexture.toString());
			}

			return ownerTexture; // Return the owner's texture resource location
		}

		// If there is no owner, check the DATA_Testing value
		String dataTestingTexture = entity.getEntityData().get(SukunaREntity.DATA_Testing).toLowerCase();

		// If DATA_Testing is not empty, use that texture
		if (!dataTestingTexture.isEmpty()) {
			return new ResourceLocation(dataTestingTexture);
		}

		// If DATA_Testing is empty, fall back to the entity's own texture
		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}