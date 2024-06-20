package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;

public class SummonUraumeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("Started");
				}
			}.getValue() == 0) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftaddonModEntities.URAUME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					}
					CompoundTag dataIndex5 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex5);
					dataIndex5.getCompound("ForgeData").putString("OWNER_UUID", (sourceentity.getStringUUID()));
					(entitytospawn).load(dataIndex5);
					CompoundTag dataIndex8 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex8);
					dataIndex8.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex7 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex7);
							return dataIndex7.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex8);
					CompoundTag dataIndex11 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex11);
					dataIndex11.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
						public double getValue() {
							CompoundTag dataIndex10 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex10);
							return dataIndex10.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex11);
					CompoundTag dataIndex14 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex14);
					dataIndex14.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
						public double getValue() {
							CompoundTag dataIndex13 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex13);
							return dataIndex13.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					(entitytospawn).load(dataIndex14);
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Uraume..."), false);
				CompoundTag dataIndex17 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex17);
				dataIndex17.getCompound("ForgeData").putDouble("Started", 1);
				sourceentity.load(dataIndex17);
			}
		}
	}
}
