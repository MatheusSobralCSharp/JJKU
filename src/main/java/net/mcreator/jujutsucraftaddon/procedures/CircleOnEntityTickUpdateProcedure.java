package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class CircleOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        JujutsucraftaddonMod.queueServerWork(160, () -> {
            if (!entity.level().isClientSide())
                entity.discard();
        });
    }
}
