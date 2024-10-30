package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.SukunaNoShirtEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaFushiguroEntity;
import net.mcreator.jujutsucraftaddon.entity.ShokoIeriSchoolEntity;
import net.mcreator.jujutsucraftaddon.entity.RikoAmanaiEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.entity.ZeninNaoyaEntity;
import net.mcreator.jujutsucraft.entity.SukunaPerfectEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruSchoolDaysEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.GetoSuguruEntity;
import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;

public class SpawnedProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof DomainExpansionEntityEntity) {
			entity.getPersistentData().putDouble("DomainExpansionSizer", Math.round(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius + 3));
		}
		if (entity.getPersistentData().getDouble("CursedSpirit") == 1) {
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RCT)) {
				entity.getPersistentData().putDouble("RCT", 1);
			}
			if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.REGENERATION))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_REGEN)), false, false));
			}
		}
		if (entity instanceof GojoSatoruSchoolDaysEntity) {
			if (!(!world.getEntitiesOfClass(ShokoIeriSchoolEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = JujutsucraftaddonModEntities.SHOKO_IERI_SCHOOL.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_CHANGER) == true) {
			if (entity instanceof ZeninNaoyaEntity) {
				if (!(!world.getEntitiesOfClass(MakiPreparationEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
					if (Math.random() <= 0.05) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.MAKI_PREPARATION.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			if (entity instanceof GetoSuguruEntity) {
				if (!(!world.getEntitiesOfClass(RikoAmanaiEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
					if (Math.random() <= 0.05) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.RIKO_AMANAI.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			if (entity instanceof SukunaPerfectEntity) {
				if (!(!world.getEntitiesOfClass(ItadoriShinjukuEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
					if (Math.random() < 0.1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.YUTA_CULLING_GAMES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			if (entity instanceof GojoSatoruEntity) {
				if (!(!world.getEntitiesOfClass(SukunaNoShirtEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
					if (Math.random() < 0.05) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.SUKUNA_NO_SHIRT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
			if (entity instanceof SukunaFushiguroEntity) {
				if (!(!world.getEntitiesOfClass(SukunaMangaEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
					if (Math.random() < 0.01) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.SUKUNA_MANGA.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
			}
		}
		KenjakuDomainSummoningProcedure.execute(world, x, y, z, entity);
	}
}
