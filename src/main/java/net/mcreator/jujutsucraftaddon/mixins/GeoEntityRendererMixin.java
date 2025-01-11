package net.mcreator.jujutsucraftaddon.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Pseudo
@Mixin({GeoEntityRenderer.class})
public class GeoEntityRendererMixin {
    public GeoEntityRendererMixin() {
    }


}