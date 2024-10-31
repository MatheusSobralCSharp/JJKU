package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.VeilEntity;

public class VeilDisplayConditionProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return (entity instanceof VeilEntity _datEntI ? _datEntI.getEntityData().get(VeilEntity.DATA_FlagColor) : 0) == 1;
    }
}
