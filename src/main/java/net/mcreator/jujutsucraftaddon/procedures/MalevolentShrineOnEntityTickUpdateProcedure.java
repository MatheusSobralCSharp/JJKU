package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.procedures.AIMalevolentShrineProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class MalevolentShrineOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles(JujutsucraftaddonModParticleTypes.SMOKE_WHITE.get(), x, (y - 20), z, 0, 0, 0, 0, 1);
            AIMalevolentShrineProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
        }
    }
}
