package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;

public class ProcedureFixProcedure {
    public static void execute(LevelAccessor world) {
        JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
        JujutsucraftModVariables.MapVariables.get(world).syncData(world);
    }
}
