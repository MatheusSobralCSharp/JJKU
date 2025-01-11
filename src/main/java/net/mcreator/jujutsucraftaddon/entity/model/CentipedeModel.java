package net.mcreator.jujutsucraftaddon.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.entity.CentipedeEntity;

public class CentipedeModel extends GeoModel<CentipedeEntity> {
	@Override
	public ResourceLocation getAnimationResource(CentipedeEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "animations/centipedes.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CentipedeEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "geo/centipedes.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CentipedeEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}
