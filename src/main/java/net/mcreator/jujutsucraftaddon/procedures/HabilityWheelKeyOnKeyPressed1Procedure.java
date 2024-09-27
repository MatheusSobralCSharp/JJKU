package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

public class HabilityWheelKeyOnKeyPressed1Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 0) {
			if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Reverse Cursed Technique Burnout: Selected"), false);
				CompoundTag dataIndex3 = new CompoundTag();
				entity.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("Selectore", 1);
				entity.load(dataIndex3);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 1) {
			if (entity.isShiftKeyDown() == false) {
				RCTBurnoutKeyProcedure.execute(entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Domain Expansion Barrierless: Selected"), false);
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putDouble("Selectore", 2);
				entity.load(dataIndex8);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex9 = new CompoundTag();
				entity.saveWithoutId(dataIndex9);
				return dataIndex9.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 2) {
			if (entity.isShiftKeyDown() == false) {
				BarrierlessKeyOnKeyPressedProcedure.execute(world, entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Reverse Cursed Mastery: Selected"), false);
				CompoundTag dataIndex13 = new CompoundTag();
				entity.saveWithoutId(dataIndex13);
				dataIndex13.getCompound("ForgeData").putDouble("Selectore", 3);
				entity.load(dataIndex13);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex14 = new CompoundTag();
				entity.saveWithoutId(dataIndex14);
				return dataIndex14.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 3) {
			if (entity.isShiftKeyDown() == false) {
				RCTMasteryKeyOnKeyPressedProcedure.execute(world, entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Reverse Cursed Technique Output: Selected"), false);
				CompoundTag dataIndex18 = new CompoundTag();
				entity.saveWithoutId(dataIndex18);
				dataIndex18.getCompound("ForgeData").putDouble("Selectore", 4);
				entity.load(dataIndex18);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex19 = new CompoundTag();
				entity.saveWithoutId(dataIndex19);
				return dataIndex19.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 4) {
			if (entity.isShiftKeyDown() == false) {
				RCTOutputKeyOnKeyPressedProcedure.execute(entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Extension Cursed Technique: Selected"), false);
				CompoundTag dataIndex23 = new CompoundTag();
				entity.saveWithoutId(dataIndex23);
				dataIndex23.getCompound("ForgeData").putDouble("Selectore", 5);
				entity.load(dataIndex23);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex24 = new CompoundTag();
				entity.saveWithoutId(dataIndex24);
				return dataIndex24.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 5) {
			if (entity.isShiftKeyDown() == false) {
				ExtensionDomainKeyOnPressedProcedure.execute(world, entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Simple Domain Technique: Selected"), false);
				CompoundTag dataIndex28 = new CompoundTag();
				entity.saveWithoutId(dataIndex28);
				dataIndex28.getCompound("ForgeData").putDouble("Selectore", 6);
				entity.load(dataIndex28);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex29 = new CompoundTag();
				entity.saveWithoutId(dataIndex29);
				return dataIndex29.getCompound("ForgeData").getDouble("Selectore");
			}
		}.getValue() == 6) {
			if (entity.isShiftKeyDown() == false) {
				SimpleDomainKeyOnKeyPressedProcedure.execute(entity);
			} else if (entity.isShiftKeyDown()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Reverse Cursed Technique Output: Selected"), false);
				CompoundTag dataIndex33 = new CompoundTag();
				entity.saveWithoutId(dataIndex33);
				dataIndex33.getCompound("ForgeData").putDouble("Selectore", 0);
				entity.load(dataIndex33);
			}
		}
	}
}
