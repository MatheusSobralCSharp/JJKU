package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class LeaveTeamProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putDouble("friend_num", 0);
		entity.load(dataIndex0);
		CompoundTag dataIndex1 = new CompoundTag();
		entity.saveWithoutId(dataIndex1);
		dataIndex1.getCompound("ForgeData").putDouble("friend_num2", 0);
		entity.load(dataIndex1);
		CompoundTag dataIndex2 = new CompoundTag();
		entity.saveWithoutId(dataIndex2);
		dataIndex2.getCompound("ForgeData").putDouble("friend_num_worker", 0);
		entity.load(dataIndex2);
		CompoundTag dataIndex3 = new CompoundTag();
		entity.saveWithoutId(dataIndex3);
		dataIndex3.getCompound("ForgeData").putString("OWNER_UUID", "");
		entity.load(dataIndex3);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("You Left from your Team"), false);
		{
			String _setval = "";
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TeamName = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
