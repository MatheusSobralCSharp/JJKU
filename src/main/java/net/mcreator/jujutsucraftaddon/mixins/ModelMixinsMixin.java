package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.model.Rika2Model;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Rika2Model.class, remap = false)
public abstract class ModelMixinsMixin {
    public ModelMixinsMixin() {
    }

    @Inject(method = "getAnimationResource", at = @At("RETURN"), cancellable = true)
    private void getAnimationResource(Rika2Entity entity, CallbackInfoReturnable<ResourceLocation> cir) {
        ResourceLocation modifiedLocation = new ResourceLocation("jujutsucraftaddon", "animations/rika2.animation.json");
        cir.setReturnValue(modifiedLocation);
    }
}