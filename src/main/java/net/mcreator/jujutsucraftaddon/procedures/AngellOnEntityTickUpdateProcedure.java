package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.mcreator.jujutsucraftaddon.entity.KashimoFemboyEntity;
import net.mcreator.jujutsucraftaddon.entity.HakariEntity;
import net.mcreator.jujutsucraftaddon.entity.AngellEntity;
import net.mcreator.jujutsucraft.procedures.AIOkkotsuProcedure;
import net.mcreator.jujutsucraft.procedures.AIKashimoHajimeProcedure;

import java.util.List;
import java.util.Comparator;

public class AngellOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
			net.mcreator.jujutsucraft.procedures.AIHakariProcedure.execute(world, x, y, z, entity);
		} else if (entity instanceof AngellEntity) {
			AngellOnInitialEntitySpawnProcedure.execute(entity);
		} else if (entity instanceof YutaCullingGamesEntity) {
			YutaCullingSpawnProcedure.execute(entity);
			AIOkkotsuProcedure.execute(world, x, y, z, entity);
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entity instanceof KashimoFemboyEntity) {
					AIKashimoHajimeProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
