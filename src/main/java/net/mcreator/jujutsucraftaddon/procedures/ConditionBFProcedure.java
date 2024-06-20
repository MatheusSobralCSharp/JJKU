package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

public class ConditionBFProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_BLACK_FLASH_CUTSCENE) == false;
	}
}
