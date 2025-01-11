package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.ArtifactItem;

public class ArtifactItemModel extends GeoModel<ArtifactItem> {
	@Override
	public ResourceLocation getAnimationResource(ArtifactItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ArtifactItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ArtifactItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto.png");
	}
}
