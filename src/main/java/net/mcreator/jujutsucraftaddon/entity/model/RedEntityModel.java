package net.mcreator.jujutsucraftaddon.entity.model;

import net.mcreator.jujutsucraftaddon.entity.RedEntityEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RedEntityModel extends GeoModel<RedEntityEntity> {
    @Override
    public ResourceLocation getAnimationResource(RedEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "animations/hollow.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(RedEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "geo/hollow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedEntityEntity entity) {
        return new ResourceLocation("jujutsucraftaddon", "textures/entities/" + entity.getTexture() + ".png");
    }

}
