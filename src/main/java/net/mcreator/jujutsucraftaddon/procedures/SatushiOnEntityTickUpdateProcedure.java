package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class SatushiOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        SatushiOnInitialEntitySpawnProcedure.execute(entity);
        SukunaMangaRCTProcedure.execute(world, entity);
        HusseinDongOnEntityTickUpdateProcedure.execute(entity);
    }
}
