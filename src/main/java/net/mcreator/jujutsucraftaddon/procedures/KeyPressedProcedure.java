package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class KeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()
				&& entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
				&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone()) {
			if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
				if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
					if ((entity.getPersistentData().getString("Mode")).equals("") || (entity.getPersistentData().getString("Mode")).equals("Itadori")) {
						entity.getPersistentData().putString("Mode", "Blood");
						{
							double _setval = 10;
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerCurseTechnique2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Your CT Mode is: " + "Blood")), false);
					} else if ((entity.getPersistentData().getString("Mode")).equals("Blood")) {
						entity.getPersistentData().putString("Mode", "Shrine");
						{
							double _setval = 1;
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerCurseTechnique2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Your CT Mode is: " + "Shrine")), false);
					} else if ((entity.getPersistentData().getString("Mode")).equals("Shrine")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Your CT Mode is: " + "Itadori")), false);
						{
							double _setval = 21;
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerCurseTechnique2 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						entity.getPersistentData().putString("Mode", "Itadori");
					}
				}
			}
		}
	}
}
