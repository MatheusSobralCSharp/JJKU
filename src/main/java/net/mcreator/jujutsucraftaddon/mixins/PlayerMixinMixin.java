package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixinMixin {
    @Inject(
            method = "getDisplayName",
            at = @At("RETURN"),
            cancellable = true
    )
    private void onGetName(CallbackInfoReturnable<Component> cir) {
        Player player = (Player) (Object) this;
        if (player.isAlive()) {
            player.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                if ("Kenjaku".equals(capability.Clans)) {
                    String tag = capability.tag1;
                    if (tag != null) {
                        String skinName = switch (tag) {
                            case "One" -> capability.SkinName1;
                            case "Two" -> capability.SkinName2;
                            case "Three" -> capability.SkinName3;
                            default -> null;
                        };
                        if (skinName != null && !skinName.isEmpty()) {
                            cir.setReturnValue(Component.literal(skinName));
                        }
                    }
                }
            });
        }
    }
}