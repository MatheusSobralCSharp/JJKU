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
				CompoundTag dataIndex = new CompoundTag();
				entity.saveWithoutId(dataIndex);
				return dataIndex.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 107)) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					return dataIndex.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() > 0 && new Object() {
				public double getValue() {
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					return dataIndex.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() < 100) {
				{
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					dataIndex.getCompound("ForgeData").putDouble("cnt6", (new Object() {
						public double getValue() {
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							return dataIndex.getCompound("ForgeData").getDouble("cnt6");
						}
					}.getValue() + 1));
					entity.load(dataIndex);
				}
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
