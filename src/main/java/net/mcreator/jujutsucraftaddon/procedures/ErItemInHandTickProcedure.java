package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import java.util.List;
import java.util.Comparator;

public class ErItemInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt1: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex1 = new CompoundTag();
						entity.saveWithoutId(dataIndex1);
						return dataIndex1.getCompound("ForgeData").getDouble("cnt1");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt2: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						entity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getDouble("cnt2");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt3: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex5 = new CompoundTag();
						entity.saveWithoutId(dataIndex5);
						return dataIndex5.getCompound("ForgeData").getDouble("cnt3");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt4: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						entity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getDouble("cnt4");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt5: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex9 = new CompoundTag();
						entity.saveWithoutId(dataIndex9);
						return dataIndex9.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("cnt6: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex11 = new CompoundTag();
						entity.saveWithoutId(dataIndex11);
						return dataIndex11.getCompound("ForgeData").getDouble("cnt6");
					}
				}.getValue()))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("Range: " + (new Object() {
					public double getValue() {
						CompoundTag dataIndex13 = new CompoundTag();
						entity.saveWithoutId(dataIndex13);
						return dataIndex13.getCompound("ForgeData").getDouble("Range");
					}
				}.getValue()))), false);
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:blue")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt1: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex16 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex16);
									return dataIndex16.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("skill: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex18 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex18);
									return dataIndex18.getCompound("ForgeData").getDouble("cnt1");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt2: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex20 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex20);
									return dataIndex20.getCompound("ForgeData").getDouble("cnt2");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt3: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex22 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex22);
									return dataIndex22.getCompound("ForgeData").getDouble("cnt3");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt4: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex24 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex24);
									return dataIndex24.getCompound("ForgeData").getDouble("cnt4");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt5: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex26 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex26);
									return dataIndex26.getCompound("ForgeData").getDouble("cnt5");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("cnt6: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex28 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex28);
									return dataIndex28.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue()))), false);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Range: " + (new Object() {
								public double getValue() {
									CompoundTag dataIndex30 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex30);
									return dataIndex30.getCompound("ForgeData").getDouble("Range");
								}
							}.getValue()))), false);
					}
				}
			}
		}
	}
}
