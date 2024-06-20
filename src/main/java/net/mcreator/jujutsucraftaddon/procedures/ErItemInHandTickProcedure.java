package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

public class ErItemInHandTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt1: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex0 = new CompoundTag();
					entity.saveWithoutId(dataIndex0);
					return dataIndex0.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt2: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					entity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("cnt2");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt3: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("cnt3");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt4: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex6 = new CompoundTag();
					entity.saveWithoutId(dataIndex6);
					return dataIndex6.getCompound("ForgeData").getDouble("cnt4");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt5: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex8 = new CompoundTag();
					entity.saveWithoutId(dataIndex8);
					return dataIndex8.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("cnt6: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					return dataIndex10.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue()))), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Range: " + (new Object() {
				public double getValue() {
					CompoundTag dataIndex12 = new CompoundTag();
					entity.saveWithoutId(dataIndex12);
					return dataIndex12.getCompound("ForgeData").getDouble("Range");
				}
			}.getValue()))), false);
	}
}
