package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.entity.CentipedeEntity;

public class CentipedeOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CentipedeEntity) {
			((CentipedeEntity) entity).setAnimation("animation.centipedes.subir");
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SQUID_INK, x, y, z, 5, 3, 3, 3, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:spawncentipede")), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:spawncentipede")), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
	}
}
