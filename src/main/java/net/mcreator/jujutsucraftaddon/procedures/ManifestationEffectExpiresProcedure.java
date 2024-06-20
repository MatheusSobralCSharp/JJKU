package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class ManifestationEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
			if (!entity.level().isClientSide())
				entity.discard();
		} else if (!(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCurseTechnique2 = 5;
				capability.syncPlayerVariables(entity);
			});
			if (Math.random() <= 0.5) {
				if (Math.random() <= 0.5) {
					{
						double _setval = 0;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.KenjakuCT1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						double _setval = 0;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.KenjakuCT2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			{
				double _setval = 6000;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TimeLeft = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
