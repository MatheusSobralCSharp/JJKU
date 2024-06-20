package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

import java.util.List;
import java.util.Comparator;

public class NoDomainUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.BROKEN_BRAIN.get()))) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex1 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex1);
							return dataIndex1.getCompound("ForgeData").getDouble("brokenBrain");
						}
					}.getValue() != 2) {
						CompoundTag dataIndex2 = new CompoundTag();
						entityiterator.saveWithoutId(dataIndex2);
						dataIndex2.getCompound("ForgeData").putDouble("brokenBrain", 2);
						entityiterator.load(dataIndex2);
					}
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BROKEN_BRAIN.get(), 1000, 1, false, false));
				}
			}
		}
	}
}
