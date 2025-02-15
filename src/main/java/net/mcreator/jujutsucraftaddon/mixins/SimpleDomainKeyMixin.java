package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.KeySimpleDomainOnKeyPressedProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SimpleAnimProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeySimpleDomainOnKeyPressedProcedure.class, priority = -10000)
public abstract class SimpleDomainKeyMixin {

    /**
     * @author Satushi
     * @reason Execution of Simple Domain Animation
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        SimpleAnimProcedure.execute(world, entity);
    }
}
