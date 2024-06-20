package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class GegeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
		entity.load(dataIndex0);
		CompoundTag dataIndex1 = new CompoundTag();
		entity.saveWithoutId(dataIndex1);
		dataIndex1.getCompound("ForgeData").putBoolean("CurseUser", true);
		entity.load(dataIndex1);
	}
}
