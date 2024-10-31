package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.AISukunaProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SpiderWebProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AISukunaProcedure.class)
public abstract class SukunaAIBuffMixin {
    public SukunaAIBuffMixin() {
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        SpiderWebProcedure.execute(world, x, y, z, entity);
    }
}