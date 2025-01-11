package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class RemovedProcedure {
	public static void execute(LevelAccessor world, Entity entity, String effect) {
		if (entity == null || effect == null)
			return;
		if (effect.contains("jackpot")) {
			if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Hakari")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.JACKPOT.get(), 5020,
							(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.JACKPOT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier() : 0) + 0), false, false));
			}
		}
	}
}
