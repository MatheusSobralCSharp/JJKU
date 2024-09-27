package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class MeditationPassiveProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double repeats = 0;
		String endtext = "";
		if (entity instanceof LivingEntity) {
			if (entity.getPersistentData().getDouble("cnt_m") < 6000) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null && !animation.isActive()) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "meditation"))));
						}
					}
				}
				entity.getPersistentData().putDouble("cnt_m", (entity.getPersistentData().getDouble("cnt_m") + 1));
				repeats = Math.round(6000 - entity.getPersistentData().getDouble("cnt_m") * 0.25);
				endtext = "Meditating..";
				for (int index0 = 0; index0 < (int) repeats; index0++) {
					endtext = "\u25A0" + endtext + "\u25A0";
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(endtext), true);
			} else if (entity.getPersistentData().getDouble("cnt_m") >= 6000) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Meditation Finished! Reward: 50 Skill Points "), true);
				{
					double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).sp + 50;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.getPersistentData().putDouble("cnt_m", 0);
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest == 2) {
					{
						double _setval = 3;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.SimpleQuest = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				entity.getPersistentData().putBoolean("Meditation", false);
			}
		}
	}
}
