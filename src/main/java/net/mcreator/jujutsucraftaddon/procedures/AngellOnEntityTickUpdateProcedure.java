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
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() == 0) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					return dataIndex.getCompound("ForgeData").getDouble("UseCursedTechnique");
				}
			}.getValue() == 0) {
				{
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					dataIndex.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
					entity.load(dataIndex);
				}
				{
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					dataIndex.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
					entity.load(dataIndex);
				}
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
