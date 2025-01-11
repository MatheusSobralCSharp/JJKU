package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.procedures.AISukunaProcedure;

public class SukunaMangaOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("CurseUser");
			}
		}.getValue() == 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("CurseUser", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("FlagSukuna");
			}
		}.getValue() == 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("FlagSukuna", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique14", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
				entity.load(dataIndex);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() <= 0) {
			{
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
				entity.load(dataIndex);
			}
		}
		if (Math.random() < (1) / ((float) 100000)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.CURSE_POWER_BLUE_DARK.get()), x, (y - 134), z, 0, 3, 3, 3, 1);
		}
		AISukunaProcedure.execute(world, x, y, z, entity);
	}
}
