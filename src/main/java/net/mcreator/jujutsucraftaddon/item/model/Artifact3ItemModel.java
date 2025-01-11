package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.Artifact3Item;

public class Artifact3ItemModel extends GeoModel<Artifact3Item> {
	@Override
	public ResourceLocation getAnimationResource(Artifact3Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/artifact.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(Artifact3Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/artifact.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(Artifact3Item animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/amuleto3.png");
	}
}
