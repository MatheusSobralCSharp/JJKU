package net.mcreator.jujutsucraftaddon.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.entity.BlueEntityEntity;

public class BlueEntityModel extends GeoModel<BlueEntityEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlueEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "animations/hollow.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "geo/hollow.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueEntityEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}
