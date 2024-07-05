package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.mcreator.jujutsucraft.JujutsucraftMod;
import net.mcreator.jujutsucraft.procedures.AIActiveProcedure;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIActive2Procedure;

public class GojoMangaOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		net.mcreator.jujutsucraft.procedures.AIActiveProcedure.execute(world, x, y, z, entity);
		net.mcreator.jujutsucraft.procedures.AIActive2Procedure.execute(world, x, y, z, entity);
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
				return dataIndex2.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() == 0) {
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
			entity.load(dataIndex3);
		}
		if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get(), -1, 4, false, true));
		}
		if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(JujutsucraftaddonModMobEffects.BARRIERLESS_COOLDOWN.get())) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BARRIERLESS_COOLDOWN.get(), -1, 4, false, true));
		}
	}
}
