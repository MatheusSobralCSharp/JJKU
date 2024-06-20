package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import java.util.List;
import java.util.Comparator;

public class RikaSpawnedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(50 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == sourceentity)) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:rika_2") && (new Object() {
						public String getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getString("OWNER_UUID");
						}
					}.getValue()).equals(sourceentity.getStringUUID())) {
						if (!(entityiterator instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.REGENERATION))) {
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100000, 2, false, false));
						}
						if (!(new Object() {
							public double getValue() {
								CompoundTag dataIndex6 = new CompoundTag();
								sourceentity.saveWithoutId(dataIndex6);
								return dataIndex6.getCompound("ForgeData").getDouble("friend_num_worker");
							}
						}.getValue() == new Object() {
							public double getValue() {
								CompoundTag dataIndex7 = new CompoundTag();
								entityiterator.saveWithoutId(dataIndex7);
								return dataIndex7.getCompound("ForgeData").getDouble("friend_num_worker");
							}
						}.getValue())) {
							CompoundTag dataIndex9 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex9);
							dataIndex9.getCompound("ForgeData").putDouble("friend_num", (new Object() {
								public double getValue() {
									CompoundTag dataIndex8 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex8);
									return dataIndex8.getCompound("ForgeData").getDouble("friend_num");
								}
							}.getValue()));
							entityiterator.load(dataIndex9);
							CompoundTag dataIndex11 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex11);
							dataIndex11.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
								public double getValue() {
									CompoundTag dataIndex10 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex10);
									return dataIndex10.getCompound("ForgeData").getDouble("friend_num");
								}
							}.getValue()));
							entityiterator.load(dataIndex11);
							CompoundTag dataIndex13 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex13);
							dataIndex13.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
								public double getValue() {
									CompoundTag dataIndex12 = new CompoundTag();
									sourceentity.saveWithoutId(dataIndex12);
									return dataIndex12.getCompound("ForgeData").getDouble("friend_num");
								}
							}.getValue()));
							entityiterator.load(dataIndex13);
						}
					}
				}
			}
		}
	}
}
