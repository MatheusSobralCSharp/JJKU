package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;

public class SwordJinWooRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(Shadow1Entity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty() == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = JujutsucraftaddonModEntities.SHADOW_1.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			CompoundTag dataIndex8 = new CompoundTag();
			entity.saveWithoutId(dataIndex8);
			dataIndex8.getCompound("ForgeData").putBoolean("Beru", true);
			entity.load(dataIndex8);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
				}
			}
		}
		if (!world.getEntitiesOfClass(IgrisEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 100, 100, 100), e -> true).isEmpty() == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = JujutsucraftaddonModEntities.IGRIS.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			CompoundTag dataIndex18 = new CompoundTag();
			entity.saveWithoutId(dataIndex18);
			dataIndex18.getCompound("ForgeData").putBoolean("Igris", true);
			entity.load(dataIndex18);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Arise\",\"color\":\"dark_purple\",\"bold\":true}");
				}
			}
		}
	}
}
