package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SpawnLevel1Procedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SpawnLevel1Procedure.class)
public abstract class MobSpawning1Mixin {
    public MobSpawning1Mixin() {
    }

    @Inject(
            method = "execute",
            at = @At("RETURN"),
            cancellable = true,
            remap = false
    )
    private static void modifyMobSpawnChance(LevelAccessor world, CallbackInfoReturnable<Boolean> cir) {
        double spawnRateModifier = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_MOB_SPAWNING_RATE);

        double NUM1 = 0.0;
        NUM1 = JujutsucraftModVariables.MapVariables.get(world).STRONGEST_PLAYER;
        if (NUM1 <= 1.0) {
            NUM1 = 0.25;
        } else if (NUM1 <= 2.0) {
            NUM1 = 0.5;
        } else if (NUM1 <= 4.0) {
            NUM1 = 0.75;
        } else {
            NUM1 = 1.0;
        }

        boolean modifiedSpawnChance = Math.random() < NUM1 / spawnRateModifier;

        // Set the return value to the modified spawn chance
        cir.setReturnValue(modifiedSpawnChance);
    }

}
