package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.GuardEffectExpiresProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(GuardEffectExpiresProcedure.class)
public abstract class GuardEffect2Mixin {
    public GuardEffect2Mixin(){}

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(Entity entity, CallbackInfo ci){
        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft"))  {
            entity.getPersistentData().putDouble("cnt_counter", 0);
        }
    }
}
