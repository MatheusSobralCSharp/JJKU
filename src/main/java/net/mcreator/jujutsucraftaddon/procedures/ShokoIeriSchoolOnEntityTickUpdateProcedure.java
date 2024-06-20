package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class ShokoIeriSchoolOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
			entity.load(dataIndex1);
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("UseCursedTechnique");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
			entity.load(dataIndex3);
		}
	}
}
