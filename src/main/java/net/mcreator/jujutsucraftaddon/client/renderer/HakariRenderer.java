package net.mcreator.jujutsucraftaddon.client.renderer;

import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class HakariRenderer extends HumanoidMobRenderer<HakariEntity, HumanoidModel<HakariEntity>> {
    public HakariRenderer(EntityRendererProvider.Context context) {
        super(context, new HumanoidModel<HakariEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(HakariEntity entity) {
        return new ResourceLocation("jujutsucraftaddon:textures/entities/hakari.png");
    }
}
