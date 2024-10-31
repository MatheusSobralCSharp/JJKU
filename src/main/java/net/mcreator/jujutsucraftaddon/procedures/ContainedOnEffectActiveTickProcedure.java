package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.SukunaREntity;

public class ContainedOnEffectActiveTickProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof SukunaREntity) {
            ((SukunaREntity) entity).setAnimation("sukunacontain");
        }
    }
}
