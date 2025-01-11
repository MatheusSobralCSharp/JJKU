package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.SungJinWooItem;

public class SungJinWooModel extends GeoModel<SungJinWooItem> {
	@Override
	public ResourceLocation getAnimationResource(SungJinWooItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/decisive2.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SungJinWooItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/decisive2.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SungJinWooItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/sungjin.png");
	}
}
