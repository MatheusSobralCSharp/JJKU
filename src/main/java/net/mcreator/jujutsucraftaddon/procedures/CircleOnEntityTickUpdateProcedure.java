package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

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
