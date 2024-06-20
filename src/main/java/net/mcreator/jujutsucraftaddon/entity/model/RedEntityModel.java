package net.mcreator.jujutsucraftaddon.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.entity.RedEntityEntity;

public class RedEntityModel extends GeoModel<RedEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(RedEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "animations/hollow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "geo/hollow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}
