package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class RemoveBrokenBrain2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putDouble("brokenBrain", 0);
		entity.load(dataIndex0);
	}
}
