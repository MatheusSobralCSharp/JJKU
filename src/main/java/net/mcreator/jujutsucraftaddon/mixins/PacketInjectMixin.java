package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonModNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(JujutsucraftaddonMod.class)
public abstract class PacketInjectMixin {
    public PacketInjectMixin(){
    }

    @Inject(at = @At("TAIL") , method = "<init>")
    private void injectNetworkHandler(CallbackInfo info) {
        // This method will run after the mod's constructor is finished
        JujutsucraftaddonModNetworkHandler.registerMessages();
    }

}
