package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.AIBlueProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SetCustomizedProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIBlueProcedure.class)
public abstract class BlueDestructionMixin {
    public BlueDestructionMixin() {
    }

    @Inject(method = "execute", at = @At("HEAD"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        SetCustomizedProcedure.execute(world, x, y, z, entity);
    }

}
