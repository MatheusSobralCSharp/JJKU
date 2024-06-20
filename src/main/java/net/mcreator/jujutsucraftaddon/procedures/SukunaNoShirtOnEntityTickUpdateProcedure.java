package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class SukunaNoShirtOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("UseCursedTechnique");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
			entity.load(dataIndex1);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("CurseUser");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("CurseUser", 1);
			entity.load(dataIndex3);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("FlagSukuna");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex5 = new CompoundTag();
			entity.saveWithoutId(dataIndex5);
			dataIndex5.getCompound("ForgeData").putDouble("FlagSukuna", 1);
			entity.load(dataIndex5);
		}
		SukunaMangaRCTProcedure.execute(world, entity);
		SukunaWaekProcedure.execute(entity);
	}
}
