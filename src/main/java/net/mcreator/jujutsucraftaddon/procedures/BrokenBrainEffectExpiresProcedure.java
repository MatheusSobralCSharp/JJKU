package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class BrokenBrainEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BrainDamage = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			CompoundTag dataIndex = new CompoundTag();
			entity.saveWithoutId(dataIndex);
			dataIndex.getCompound("ForgeData").putDouble("brokenBrain", 0);
			entity.load(dataIndex);
		}
	}
}
