package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class RedEffectEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.RED.get()), x, y, z, 0, 1, 0);
    }
}
