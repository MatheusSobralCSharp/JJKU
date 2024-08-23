package net.mcreator.jujutsucraftaddon.mixins;


import net.mcreator.jujutsucraft.procedures.CursedTechniqueOnPotionActiveTickProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = CursedTechniqueOnPotionActiveTickProcedure.class)
public abstract class CursedTechniqeMixin {
    public CursedTechniqeMixin() {
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Output > 0) {
            if (entity.getPersistentData().getDouble("cnt6") > 0
                    && entity.getPersistentData().getDouble("cnt6") < (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Output) {
                entity.getPersistentData().putDouble("cnt6", (entity.getPersistentData().getDouble("cnt6") + 1));
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 2) {
            if (entity.getPersistentData().getDouble("select") > 0) {
                entity.getPersistentData().putDouble("cnt2", 1.0);
            }
        }
    }
}