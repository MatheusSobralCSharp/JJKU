package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class DomainTimeEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
        JujutsucraftModVariables.MapVariables.get(world).syncData(world);
        entity.getPersistentData().putDouble("cnt2", 0);
    }
}
