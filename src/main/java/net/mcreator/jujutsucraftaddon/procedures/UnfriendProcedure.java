package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class UnfriendProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putString("OWNER_UUID", "");
		entity.load(dataIndex0);
		CompoundTag dataIndex2 = new CompoundTag();
		entity.saveWithoutId(dataIndex2);
		dataIndex2.getCompound("ForgeData").putDouble("friend_num", (Mth.nextDouble(RandomSource.create(), 0, 1)));
		entity.load(dataIndex2);
		CompoundTag dataIndex4 = new CompoundTag();
		entity.saveWithoutId(dataIndex4);
		dataIndex4.getCompound("ForgeData").putDouble("friend_num2", (Mth.nextDouble(RandomSource.create(), 0, 1)));
		entity.load(dataIndex4);
		CompoundTag dataIndex6 = new CompoundTag();
		entity.saveWithoutId(dataIndex6);
		dataIndex6.getCompound("ForgeData").putDouble("friend_num_worker", (Mth.nextDouble(RandomSource.create(), 0, 1)));
		entity.load(dataIndex6);
		{
			String _setval = "";
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TeamName = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Left The Team!"), false);
	}
}
