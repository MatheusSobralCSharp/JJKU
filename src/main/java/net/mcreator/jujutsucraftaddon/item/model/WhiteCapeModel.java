package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.WhiteCapeItem;

public class WhiteCapeModel extends GeoModel<WhiteCapeItem> {
	@Override
	public ResourceLocation getAnimationResource(WhiteCapeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WhiteCapeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WhiteCapeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/text23.png");
	}
}
