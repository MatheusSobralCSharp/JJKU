package net.mcreator.jujutsucraftaddon.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jujutsucraftaddon.entity.MalevolentShrineEntity;

public class MalevolentShrineModel extends GeoModel<MalevolentShrineEntity> {
	@Override
	public ResourceLocation getAnimationResource(MalevolentShrineEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "animations/malevolent_shrine_incomplete.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MalevolentShrineEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "geo/malevolent_shrine_incomplete.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MalevolentShrineEntity entity) {
		return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
	}

}
