package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.world.level.LevelAccessor;

public class RedEffectEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        world.addParticle(JujutsucraftaddonModParticleTypes.RED.get(), x, y, z, 0, 1, 0);
    }
}
