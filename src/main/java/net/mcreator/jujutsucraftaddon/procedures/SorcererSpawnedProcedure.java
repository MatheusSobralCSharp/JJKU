package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;

public class SorcererSpawnedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("cnt_target", 1);
			entity.load(dataIndex1);
			CompoundTag dataIndex2 = new CompoundTag();
			entity.saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putBoolean("jjkChara", true);
			entity.load(dataIndex2);
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
			entity.load(dataIndex3);
			CompoundTag dataIndex4 = new CompoundTag();
			entity.saveWithoutId(dataIndex4);
			dataIndex4.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
			entity.load(dataIndex4);
		}
		if (entity instanceof ItadoriShinjukuEntity) {
			ItadoriShinjukuEffectsProcedure.execute(entity);
		}
	}
}
