package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.RenderCloudProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.CloudStatus;
import net.minecraftforge.eventbus.api.Event;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RenderCloudProcedure.class)
public abstract class RenderCloudProcedureMixin {

    @Inject(
            method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/entity/Entity;)V",
            at = @At("RETURN"),
            cancellable = true,
            remap = false
    )
    private static void injection0(Event event, Entity entity, CallbackInfo ci) {
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
            ci.cancel();
        }
    }
}

