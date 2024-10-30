package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.model.Rika2Model;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Rika2Model.class)
public abstract class ModelMixinsMixin {
    public ModelMixinsMixin() {
    }

    @Inject(method = "getAnimationResource*", at = @At("RETURN"), cancellable = true, remap = false)
    private void getAnimationResource(Rika2Entity entity, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation modifiedLocation = new ResourceLocation("jujutsucraftaddon", "animations/rika2.animation.json");
        cir.setReturnValue(modifiedLocation);
    }
}