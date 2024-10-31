package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class TestProcedureDomainProcedure {
    public static void execute(LevelAccessor world) {
        JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
        JujutsucraftModVariables.MapVariables.get(world).syncData(world);
    }
}
