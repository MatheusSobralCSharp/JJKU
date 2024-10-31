package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class DismantleWhileProjectileFlyingTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() <= 0.2) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_2.get()), x, y, z, 0, 0, 0, 0, 2);
        } else if (Math.random() <= 0.4) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.SUKUNA_SLASH.get()), x, y, z, 0, 0, 0, 0, 2);
        } else if (Math.random() <= 0.6) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_5.get()), x, y, z, 0, 0, 0, 0, 2);
        }
    }
}
