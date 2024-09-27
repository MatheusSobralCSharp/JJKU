package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class Quest1StartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Fushiguro Toji: I was hoping to finish you off with that strike. Must be getting rusty."), false);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftaddonModEntities.GOJO_SCHOOL.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
			}
			CompoundTag dataIndex4 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex4);
			dataIndex4.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
			(entitytospawn).load(dataIndex4);
			CompoundTag dataIndex6 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex6);
			dataIndex6.getCompound("ForgeData").putDouble("Quest", 1);
			(entitytospawn).load(dataIndex6);
			CompoundTag dataIndex9 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex9);
			dataIndex9.getCompound("ForgeData").putDouble("friend_num", (new Object() {
				public double getValue() {
					CompoundTag dataIndex8 = new CompoundTag();
					entity.saveWithoutId(dataIndex8);
					return dataIndex8.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex9);
			CompoundTag dataIndex12 = new CompoundTag();
			(entitytospawn).saveWithoutId(dataIndex12);
			dataIndex12.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
				public double getValue() {
					CompoundTag dataIndex11 = new CompoundTag();
					entity.saveWithoutId(dataIndex11);
					return dataIndex11.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue()));
			(entitytospawn).load(dataIndex12);
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.GETO_SUGURU.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex17 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex17);
				dataIndex17.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex17);
				CompoundTag dataIndex20 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex20);
				dataIndex20.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex19 = new CompoundTag();
						entity.saveWithoutId(dataIndex19);
						return dataIndex19.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex20);
				CompoundTag dataIndex23 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex23);
				dataIndex23.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex22 = new CompoundTag();
						entity.saveWithoutId(dataIndex22);
						return dataIndex22.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex23);
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				for (int index0 = 0; index0 < 20; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SQUID_INK, x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		{
			double _setval = 1;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.History = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
