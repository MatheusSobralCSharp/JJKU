package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparation2Entity;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraft.procedures.AIZeninMakiProcedure;
import net.mcreator.jujutsucraft.procedures.AIItadoriYujiProcedure;

public class SorcererSpawnedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() != 1) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("cnt_target", 1);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putBoolean("jjkChara", true);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
				entity.load(dataIndex);
			}
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
				entity.load(dataIndex);
			}
		}
		if (entity instanceof ItadoriShinjukuEntity) {
			AIItadoriYujiProcedure.execute(world, x, y, z, entity);
			ItadoriShinjukuEffectsProcedure.execute(entity);
		}
		if (entity instanceof ItadoriShinjukuEntity) {
			AIItadoriYujiProcedure.execute(world, x, y, z, entity);
			ItadoriShinjukuEffectsProcedure.execute(entity);
		}
		if (entity instanceof MakiPreparationEntity) {
			AIZeninMakiProcedure.execute(world, x, y, z, entity);
		} else if (entity instanceof MakiPreparation2Entity) {
			AIZeninMakiProcedure.execute(world, x, y, z, entity);
		}
		if (Math.random() < (1) / ((float) 100000)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get()), x, (y - 134), z, 0, 3, 3, 3, 1);
		}
	}
}
