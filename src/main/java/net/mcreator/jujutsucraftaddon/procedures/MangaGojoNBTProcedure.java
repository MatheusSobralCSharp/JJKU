package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.GojoMangaEntity;

public class MangaGojoNBTProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof GojoMangaEntity) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
			entity.load(dataIndex1);
			CompoundTag dataIndex2 = new CompoundTag();
			entity.saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
			entity.load(dataIndex2);
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putBoolean("infinity", true);
			entity.load(dataIndex3);
		}
	}
}
