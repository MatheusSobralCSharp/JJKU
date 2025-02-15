package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.SelectTechniqueButtonMessage;
import net.mcreator.jujutsucraftaddon.procedures.CustomCursedTechniqueChangerRightclickedProcedureProcedure;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SelectTechniqueButtonMessage.class, priority = -10000)
public abstract class SelectedProcedureMixin {

    /**
     * @author Satushi
     * @reason Handle Actions of the Selection Techniques
     */


    @Inject(
            method = {"handleButtonAction"},
            at = {@At("RETURN")},
            cancellable = true,
            remap = false
    )
    private static void onHandleButtonAction(Player entity, int buttonID, int x, int y, int z, CallbackInfo ci) {
        Level world = entity.level();
        if (buttonID == 100) {
            CustomCursedTechniqueChangerRightclickedProcedureProcedure.execute(world, x, y, z, entity);
        }

    }
}


