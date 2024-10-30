package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class GegeProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CompoundTag dataIndex = new CompoundTag();
			entity.saveWithoutId(dataIndex);
			dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
			entity.load(dataIndex);
		}
		{
			CompoundTag dataIndex = new CompoundTag();
			entity.saveWithoutId(dataIndex);
			dataIndex.getCompound("ForgeData").putBoolean("CurseUser", true);
			entity.load(dataIndex);
		}
	}
}
