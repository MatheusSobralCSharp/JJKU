package net.mcreator.jujutsucraftaddon.mixins;

import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin {

    @Inject(method = "getTextureLocation(Lnet/minecraft/client/player/AbstractClientPlayer;)Lnet/minecraft/resources/ResourceLocation;", at = @At("HEAD"), cancellable = true)
    public void getTextureLocation(AbstractClientPlayer player, CallbackInfoReturnable<ResourceLocation> cir) {
        // Access player's capability once and store it
        player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            if ("Kenjaku".equals(capability.Clans)) { // Check if the player's clan is "Kenjaku"
                String tag = capability.tag1; // Store the tag to simplify checking

                // Check the tag value and set the appropriate texture
                if (tag != null) {
                    switch (tag) {
                        case "One":
                            if (capability.MobTexture != null && !capability.MobTexture.isEmpty()) {
                                cir.setReturnValue(new ResourceLocation(capability.MobTexture));
                            }
                            break;
                        case "Two":
                            if (capability.MobTexture2 != null && !capability.MobTexture2.isEmpty()) {
                                cir.setReturnValue(new ResourceLocation(capability.MobTexture2));
                            }
                            break;
                        case "Three":
                            if (capability.MobTexture3 != null && !capability.MobTexture3.isEmpty()) {
                                cir.setReturnValue(new ResourceLocation(capability.MobTexture3));
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }
}
