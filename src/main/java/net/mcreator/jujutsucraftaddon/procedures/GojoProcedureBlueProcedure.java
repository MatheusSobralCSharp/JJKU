package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import java.util.List;
import java.util.Comparator;

public class GojoProcedureBlueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
				&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_1"))).isDone()) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex1 = new CompoundTag();
						entity.saveWithoutId(dataIndex1);
						return dataIndex1.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 206) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:blue")) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex3 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex3);
										return dataIndex3.getCompound("ForgeData").getDouble("blue");
									}
								}.getValue() != 1) {
									CompoundTag dataIndex4 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex4);
									dataIndex4.getCompound("ForgeData").putDouble("blue", 1);
									entityiterator.load(dataIndex4);
								}
							}
						}
					}
				}
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() == 206) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:blue")) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex8 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex8);
										return dataIndex8.getCompound("ForgeData").getDouble("blue");
									}
								}.getValue() != 3) {
									CompoundTag dataIndex9 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex9);
									dataIndex9.getCompound("ForgeData").putDouble("blue", 3);
									entityiterator.load(dataIndex9);
								}
							}
						}
					}
				}
			}
		}
	}
}
