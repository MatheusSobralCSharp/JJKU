package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.WarstaffItem;

public class WarstaffItemModel extends GeoModel<WarstaffItem> {
	@Override
	public ResourceLocation getAnimationResource(WarstaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/g_warstaff.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WarstaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/g_warstaff.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WarstaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/texture_36.png");
	}
}
