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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Comparator;

public class UiUiOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
		entity.load(dataIndex0);
		CompoundTag dataIndex1 = new CompoundTag();
		entity.saveWithoutId(dataIndex1);
		dataIndex1.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
		entity.load(dataIndex1);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1000000, 25, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000000, 3, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000000, 3, false, false));
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run scale set pehkui:base 0.83 @s");
			}
		}
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run scale set pehkui:base 0.83 @s");
			}
		}
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty() || !world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
			if (entity instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Player _owner)
				_toTame.tame(_owner);
			if (entity instanceof TamableAnimal _toTame && ((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Player _owner)
				_toTame.tame(_owner);
			CompoundTag dataIndex15 = new CompoundTag();
			entity.saveWithoutId(dataIndex15);
			dataIndex15.getCompound("ForgeData").putDouble("friend_num", (new Object() {
				public double getValue() {
					CompoundTag dataIndex14 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex14);
					return dataIndex14.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex15);
			CompoundTag dataIndex18 = new CompoundTag();
			entity.saveWithoutId(dataIndex18);
			dataIndex18.getCompound("ForgeData").putDouble("friend_num", (new Object() {
				public double getValue() {
					CompoundTag dataIndex17 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex17);
					return dataIndex17.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex18);
			CompoundTag dataIndex21 = new CompoundTag();
			entity.saveWithoutId(dataIndex21);
			dataIndex21.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
				public double getValue() {
					CompoundTag dataIndex20 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex20);
					return dataIndex20.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex21);
			CompoundTag dataIndex24 = new CompoundTag();
			entity.saveWithoutId(dataIndex24);
			dataIndex24.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
				public double getValue() {
					CompoundTag dataIndex23 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex23);
					return dataIndex23.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex24);
			CompoundTag dataIndex27 = new CompoundTag();
			entity.saveWithoutId(dataIndex27);
			dataIndex27.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
				public double getValue() {
					CompoundTag dataIndex26 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex26);
					return dataIndex26.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex27);
			CompoundTag dataIndex30 = new CompoundTag();
			entity.saveWithoutId(dataIndex30);
			dataIndex30.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
				public double getValue() {
					CompoundTag dataIndex29 = new CompoundTag();
					((Entity) world.getEntitiesOfClass(ServerPlayer.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).saveWithoutId(dataIndex29);
					return dataIndex29.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			entity.load(dataIndex30);
		}
	}
}
