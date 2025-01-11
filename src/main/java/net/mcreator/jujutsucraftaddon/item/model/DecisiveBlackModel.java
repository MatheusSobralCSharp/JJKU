package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.DecisiveBlackItem;

public class DecisiveBlackModel extends GeoModel<DecisiveBlackItem> {
	@Override
	public ResourceLocation getAnimationResource(DecisiveBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/decisive.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DecisiveBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/decisive.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DecisiveBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/darktext.png");
	}
}
