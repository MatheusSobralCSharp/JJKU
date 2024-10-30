package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerRenderer.class)
public abstract class PlayerRendererMixin {
    @ModifyVariable(
            method = "renderNameTag(Lnet/minecraft/client/player/AbstractClientPlayer;Lnet/minecraft/network/chat/Component;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private Component modifyNameTag(Component component, AbstractClientPlayer abstractClientPlayer) {
        AbstractClientPlayer player = abstractClientPlayer;
        final Component[] modifiedComponent = {component};

        player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
            if ("Kenjaku".equals(capability.Clans)) {
                String tag = capability.tag1;
                if (tag != null) {
                    switch (tag) {
                        case "One":
                            if (capability.SkinName1 != null && !capability.SkinName1.isEmpty()) {
                                modifiedComponent[0] = Component.literal(capability.SkinName1);
                            }
                            break;
                        case "Two":
                            if (capability.SkinName2 != null && !capability.SkinName2.isEmpty()) {
                                modifiedComponent[0] = Component.literal(capability.SkinName2);
                            }
                            break;
                        case "Three":
                            if (capability.SkinName3 != null && !capability.SkinName3.isEmpty()) {
                                modifiedComponent[0] = Component.literal(capability.SkinName3);
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        return modifiedComponent[0];
    }
}

