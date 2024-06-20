package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.YuunItem;

public class YuunItemModel extends GeoModel<YuunItem> {
	@Override
	public ResourceLocation getAnimationResource(YuunItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/yuundark.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(YuunItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/yuundark.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(YuunItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/playful_cloud.png");
	}
}
