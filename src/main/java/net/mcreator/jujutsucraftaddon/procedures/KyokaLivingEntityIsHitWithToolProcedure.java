package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

public class KyokaLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (Math.random() <= 0.2) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex0 = new CompoundTag();
					entity.saveWithoutId(dataIndex0);
					return dataIndex0.getCompound("ForgeData").getDouble("Kyoka");
				}
			}.getValue() == 0) {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				dataIndex2.getCompound("ForgeData").putDouble("Kyoka", (new Object() {
					public double getValue() {
						CompoundTag dataIndex1 = new CompoundTag();
						entity.saveWithoutId(dataIndex1);
						return dataIndex1.getCompound("ForgeData").getDouble("Kyoka");
					}
				}.getValue() + 1));
				entity.load(dataIndex2);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(
							"\u8DDD\u96E2\u306F\u5BFE\u7B49\u306A\u6226\u3044\u306B\u304A\u3044\u3066\u306E\u307F\u610F\u5473\u3092\u6301\u3064\u3002\u3042\u306A\u305F\u3068\u79C1\u3067\u306F\u3001\u8DDD\u96E2\u306F\u307E\u3063\u305F\u304F\u610F\u5473\u3092\u6301\u305F\u306A\u3044"),
							false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u5B8C\u5168\u50AC\u7720: 20%"), false);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("Kyoka");
				}
			}.getValue() == 1) {
				CompoundTag dataIndex7 = new CompoundTag();
				entity.saveWithoutId(dataIndex7);
				dataIndex7.getCompound("ForgeData").putDouble("Kyoka", (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("Kyoka");
					}
				}.getValue() + 1));
				entity.load(dataIndex7);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u305D\u3093\u306A\u5F37\u3044\u8A00\u8449\u306F\u4F7F\u3046\u3079\u304D\u3067\u306A\u3044\u3001\u5F31\u304F\u898B\u3048\u308B\u3060\u3051\u3060"), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u5B8C\u5168\u50AC\u7720: 40%"), false);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					return dataIndex10.getCompound("ForgeData").getDouble("Kyoka");
				}
			}.getValue() == 2) {
				CompoundTag dataIndex12 = new CompoundTag();
				entity.saveWithoutId(dataIndex12);
				dataIndex12.getCompound("ForgeData").putDouble("Kyoka", (new Object() {
					public double getValue() {
						CompoundTag dataIndex11 = new CompoundTag();
						entity.saveWithoutId(dataIndex11);
						return dataIndex11.getCompound("ForgeData").getDouble("Kyoka");
					}
				}.getValue() + 1));
				entity.load(dataIndex12);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u9032\u5316\u306B\u306F\u6050\u6016\u304C\u5FC5\u8981"), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u5B8C\u5168\u50AC\u7720: 60%"), false);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex15 = new CompoundTag();
					entity.saveWithoutId(dataIndex15);
					return dataIndex15.getCompound("ForgeData").getDouble("Kyoka");
				}
			}.getValue() == 3) {
				CompoundTag dataIndex17 = new CompoundTag();
				entity.saveWithoutId(dataIndex17);
				dataIndex17.getCompound("ForgeData").putDouble("Kyoka", (new Object() {
					public double getValue() {
						CompoundTag dataIndex16 = new CompoundTag();
						entity.saveWithoutId(dataIndex16);
						return dataIndex16.getCompound("ForgeData").getDouble("Kyoka");
					}
				}.getValue() + 1));
				entity.load(dataIndex17);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u3059\u3079\u3066\u306E\u751F\u304D\u7269\u306F\u81EA\u5206\u3088\u308A\u3082\u5927\u304D\u306A\u3082\u306E\u3092\u4FE1\u3058\u305F\u3044"), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u5B8C\u5168\u50AC\u7720: 80%"), false);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex20 = new CompoundTag();
					entity.saveWithoutId(dataIndex20);
					return dataIndex20.getCompound("ForgeData").getDouble("Kyoka");
				}
			}.getValue() == 4) {
				CompoundTag dataIndex22 = new CompoundTag();
				entity.saveWithoutId(dataIndex22);
				dataIndex22.getCompound("ForgeData").putDouble("Kyoka", (new Object() {
					public double getValue() {
						CompoundTag dataIndex21 = new CompoundTag();
						entity.saveWithoutId(dataIndex21);
						return dataIndex21.getCompound("ForgeData").getDouble("Kyoka");
					}
				}.getValue() + 1));
				entity.load(dataIndex22);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u3044\u3064\u304B\u3089\u79C1\u304C\u6C34\u6708\u4EAC\u9999\u3092\u4F7F\u3063\u3066\u3044\u306A\u3044\u3068\u932F\u899A\u3057\u3066\u3044\u305F\uFF1F"), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u5B8C\u5168\u50AC\u7720: 100%"), false);
			}
		}
	}
}
