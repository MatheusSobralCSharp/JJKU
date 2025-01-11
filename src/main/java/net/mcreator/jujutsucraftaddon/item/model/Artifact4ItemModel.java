package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.Artifact4Item;

public class Artifact4ItemModel extends GeoModel<Artifact4Item> {
	@Override
	public ResourceLocation getAnimationResource(Artifact4Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Artifact4Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Artifact4Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto5.png");
	}
}
