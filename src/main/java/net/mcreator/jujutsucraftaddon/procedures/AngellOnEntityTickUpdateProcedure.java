package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.mcreator.jujutsucraftaddon.entity.AngellEntity;

public class AngellOnEntityTickUpdateProcedure {
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
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("UseCursedTechnique");
				}
			}.getValue() == 0) {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				dataIndex2.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
				entity.load(dataIndex2);
				CompoundTag dataIndex3 = new CompoundTag();
				entity.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
				entity.load(dataIndex3);
			}
		}
		if (entity instanceof HakariEntity) {
			HakariOnInitialEntitySpawnProcedure.execute(entity);
		} else if (entity instanceof AngellEntity) {
			AngellOnInitialEntitySpawnProcedure.execute(entity);
		} else if (entity instanceof YutaCullingGamesEntity) {
			YutaCullingSpawnProcedure.execute(entity);
		}
	}
}
