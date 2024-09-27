package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.WukongStaffItem;

public class WukongStaffItemModel extends GeoModel<WukongStaffItem> {
	@Override
	public ResourceLocation getAnimationResource(WukongStaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "animations/wukongstaff.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WukongStaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "geo/wukongstaff.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WukongStaffItem animatable) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/playful_cloud.png");
	}
}
