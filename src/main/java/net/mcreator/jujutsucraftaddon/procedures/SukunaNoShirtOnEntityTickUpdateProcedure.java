package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class SukunaNoShirtOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (Math.random() <= 0.01) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 40,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
									? _livEnt.getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
									: 0) + 0),
							false, false));
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (Math.random() <= 0.02) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 40,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
									? _livEnt.getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
									: 0) + 0),
							false, false));
			}
		}
		SukunaWaekProcedure.execute(entity);
	}
}
