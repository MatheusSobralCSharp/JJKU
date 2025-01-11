package net.mcreator.jujutsucraftaddon.item.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.item.SukunaRobeItem;

public class SukunaRobeModel extends GeoModel<SukunaRobeItem> {
	@Override
	public ResourceLocation getAnimationResource(SukunaRobeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "animations/sukunarobe.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SukunaRobeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "geo/sukunarobe.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SukunaRobeItem object) {
		return new ResourceLocation("jujutsucraftaddon", "textures/item/innate_sukuna.png");
	}
}
