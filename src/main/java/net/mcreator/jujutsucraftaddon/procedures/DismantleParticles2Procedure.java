package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class DismantleParticles2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (Math.random() <= 0.2) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HORIZONTAL_SLASH_BLACK.get()), x, y, z, 0, 0, 0, 0, 2);
        } else if (Math.random() <= 0.4) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI_10.get()), x, y, z, 0, 0, 0, 0, 2);
        } else if (Math.random() <= 0.6) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI_10.get()), x, y, z, 0, 0, 0, 0, 2);
        } else if (Math.random() <= 0.8) {
            if (world instanceof ServerLevel _level)
                _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.VERTICAL_HAITI.get()), x, y, z, 0, 0, 0, 0, 2);
        }
    }
}
