package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import java.util.List;
import java.util.Comparator;

public class CleaveWebOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
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
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000000, 254, false, false));
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						entityiterator.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getBoolean("FlagSukuna");
					}
				}.getValue()) == true) {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					dataIndex5.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex4 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex4);
							return dataIndex4.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex5);
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					dataIndex7.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
						public double getValue() {
							CompoundTag dataIndex6 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex6);
							return dataIndex6.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex7);
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					dataIndex9.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
						public double getValue() {
							CompoundTag dataIndex8 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex8);
							return dataIndex8.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex9);
					if (entity instanceof TamableAnimal _toTame && entityiterator instanceof Player _owner)
						_toTame.tame(_owner);
					if (entityiterator instanceof TamableAnimal _toTame && entity instanceof Player _owner)
						_toTame.tame(_owner);
				}
			}
		}
	}
}
