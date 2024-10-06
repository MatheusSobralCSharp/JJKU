package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;

public class QuakeOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			double baseIntensity = 6.0;
			double randomFactor = entity.level().random.nextFloat(); // Random factor for chaotic effect
			double shakeIntensity = baseIntensity * (0.7 + randomFactor * 1.5); // More intense randomness

			// Randomly adjust the player's yaw and pitch with a larger variation
			entity.setYRot((float) (entity.getYRot() + (entity.level().random.nextFloat() - 0.5) * shakeIntensity * 3));
			entity.setXRot((float) (entity.getXRot() + (entity.level().random.nextFloat() - 0.5) * shakeIntensity * 2));

			// Sync body and head rotations with the new yaw
			entity.setYBodyRot(entity.getYRot());
			entity.setYHeadRot(entity.getYRot());
			entity.yRotO = entity.getYRot();
			entity.xRotO = entity.getXRot();

			if (entity instanceof LivingEntity _entity) {
				_entity.yBodyRotO = _entity.getYRot();
				_entity.yHeadRotO = _entity.getYRot();
			}

			QuakeEffectTradeBackProcedure.execute(world, entity);
		}
	}
}

