package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.player.AbstractClientPlayer;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class SukunaAnimationsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 1 && new Object() {
			public double getValue() {
				CompoundTag dataIndex1 = new CompoundTag();
				entity.saveWithoutId(dataIndex1);
				return dataIndex1.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 107 && new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("cnt5");
			}
		}.getValue() == 0) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "fuga"))));
					}
				}
			}
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "fuga"))));
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("Fuga");
				}
			}.getValue() != 2) {
				CompoundTag dataIndex6 = new CompoundTag();
				entity.saveWithoutId(dataIndex6);
				dataIndex6.getCompound("ForgeData").putDouble("Fuga", 2);
				entity.load(dataIndex6);
			}
		} else if (new Object() {
			public double getValue() {
				CompoundTag dataIndex7 = new CompoundTag();
				entity.saveWithoutId(dataIndex7);
				return dataIndex7.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 0 && new Object() {
			public double getValue() {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				return dataIndex8.getCompound("ForgeData").getDouble("cnt1");
			}
		}.getValue() > 10) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("Fuga");
				}
			}.getValue() == 2) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "fuga2"))));
						}
					}
				}
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "fuga2"))));
						}
					}
				}
				CompoundTag dataIndex12 = new CompoundTag();
				entity.saveWithoutId(dataIndex12);
				dataIndex12.getCompound("ForgeData").putDouble("Fuga", 1);
				entity.load(dataIndex12);
			}
		}
	}
}
