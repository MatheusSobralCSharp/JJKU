package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.GojoItem;

public class GojoModel extends GeoModel<GojoItem> {
	@Override
	public ResourceLocation getAnimationResource(GojoItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/decisivegojo.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GojoItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/decisivegojo.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GojoItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/gojofinal2.png");
	}
}
