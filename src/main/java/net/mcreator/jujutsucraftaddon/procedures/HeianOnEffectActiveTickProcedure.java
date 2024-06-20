package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

public class HeianOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 107)) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() > 0 && new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					entity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() < 100) {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				dataIndex4.getCompound("ForgeData").putDouble("cnt6", (new Object() {
					public double getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						entity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getDouble("cnt6");
					}
				}.getValue() + 1));
				entity.load(dataIndex4);
			}
		}
		if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.REGENERATION))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 1, false, false));
		}
		if (!(entity instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(MobEffects.DIG_SPEED))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, -1, 6, false, false));
		}
	}
}
