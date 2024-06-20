package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.KimonoBlackItem;

public class KimonoBlackModel extends GeoModel<KimonoBlackItem> {
	@Override
	public ResourceLocation getAnimationResource(KimonoBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/kimonoblack.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(KimonoBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/kimonoblack.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(KimonoBlackItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/naobitooo.png");
	}
}
