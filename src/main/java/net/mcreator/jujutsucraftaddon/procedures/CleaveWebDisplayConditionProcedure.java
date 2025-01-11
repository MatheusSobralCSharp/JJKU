package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;

public class CleaveWebDisplayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof CleaveWebEntity _datEntI ? _datEntI.getEntityData().get(CleaveWebEntity.DATA_b) : 0) == 1;
	}
}
