package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;

import java.util.List;
import java.util.Comparator;

public class SpiderWebProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Math.random() <= 0.0001) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							if (!(new Object() {
								public String getValue() {
									CompoundTag dataIndex3 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex3);
									return dataIndex3.getCompound("ForgeData").getString("OWNER_UUID");
								}
							}.getValue()).equals(entity.getStringUUID())) {
								if (!world.getEntitiesOfClass(CleaveWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() == false) {
									if (world instanceof ServerLevel _serverLevel) {
										Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
										if (entitytospawn != null) {
											entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
										}
										CompoundTag dataIndex8 = new CompoundTag();
										(entitytospawn).saveWithoutId(dataIndex8);
										dataIndex8.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
										(entitytospawn).load(dataIndex8);
										CompoundTag dataIndex11 = new CompoundTag();
										(entitytospawn).saveWithoutId(dataIndex11);
										dataIndex11.getCompound("ForgeData").putDouble("friend_num", (new Object() {
											public double getValue() {
												CompoundTag dataIndex10 = new CompoundTag();
												entity.saveWithoutId(dataIndex10);
												return dataIndex10.getCompound("ForgeData").getDouble("friend_num");
											}
										}.getValue()));
										(entitytospawn).load(dataIndex11);
										CompoundTag dataIndex14 = new CompoundTag();
										(entitytospawn).saveWithoutId(dataIndex14);
										dataIndex14.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
											public double getValue() {
												CompoundTag dataIndex13 = new CompoundTag();
												entity.saveWithoutId(dataIndex13);
												return dataIndex13.getCompound("ForgeData").getDouble("friend_num");
											}
										}.getValue()));
										(entitytospawn).load(dataIndex14);
										CompoundTag dataIndex17 = new CompoundTag();
										(entitytospawn).saveWithoutId(dataIndex17);
										dataIndex17.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
											public double getValue() {
												CompoundTag dataIndex16 = new CompoundTag();
												entity.saveWithoutId(dataIndex16);
												return dataIndex16.getCompound("ForgeData").getDouble("friend_num");
											}
										}.getValue()));
										(entitytospawn).load(dataIndex17);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
