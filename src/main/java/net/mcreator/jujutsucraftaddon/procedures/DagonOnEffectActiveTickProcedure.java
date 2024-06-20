package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;

public class DagonOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double yRadius = 0;
		double masterRadius = 0;
		if (!entity.isShiftKeyDown()) {
			loop = 0;
			particleAmount = 16;
			xRadius = 2;
			zRadius = 2;
			while (loop < particleAmount) {
				world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WATER.get()), (entity.getX() + 0.5 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (entity.getY() + 1),
						(entity.getZ() + 0.5 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
				loop = loop + 1;
			}
		} else if (entity.isShiftKeyDown()) {
			loop = 0;
			particleAmount = 2000;
			masterRadius = 10;
			while (loop < particleAmount) {
				yRadius = masterRadius;
				world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.WATER.get()), (entity.getX() + 0.5 + Math.sin(((Math.PI * 10 * zRadius) / particleAmount) * loop) * zRadius),
						(entity.getY() + 1 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * yRadius), (entity.getZ() + 0.5 + Math.cos(((Math.PI * 10 * xRadius) / particleAmount) * loop) * xRadius), 0, 0, 0);
				xRadius = Math.cos(((Math.PI * 2) / particleAmount) * loop) * yRadius;
				zRadius = Math.cos(((Math.PI * 2) / particleAmount) * loop) * yRadius;
				loop = loop + 1;
			}
		}
		if (entity.isInWater()) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 3, false, false));
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsCursedSpirit == true) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex12 = new CompoundTag();
					entity.saveWithoutId(dataIndex12);
					return dataIndex12.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() > 0 && new Object() {
				public double getValue() {
					CompoundTag dataIndex13 = new CompoundTag();
					entity.saveWithoutId(dataIndex13);
					return dataIndex13.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() < 30) {
				CompoundTag dataIndex15 = new CompoundTag();
				entity.saveWithoutId(dataIndex15);
				dataIndex15.getCompound("ForgeData").putDouble("cnt6", (new Object() {
					public double getValue() {
						CompoundTag dataIndex14 = new CompoundTag();
						entity.saveWithoutId(dataIndex14);
						return dataIndex14.getCompound("ForgeData").getDouble("cnt6");
					}
				}.getValue() + 1));
				entity.load(dataIndex15);
			}
		}
	}
}
