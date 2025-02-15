package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIActiveProcedure;
import net.mcreator.jujutsucraft.procedures.AISukunaProcedure;
import net.mcreator.jujutsucraft.procedures.AIZeninMakiProcedure;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparation2Entity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class SorcererSpawnedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

//        if (entity instanceof ItadoriShinjukuEntity) {
//            if (entity instanceof LivingEntity _entity && _entity.hasEffect(JujutsucraftModMobEffects.ZONE.get()) && (((LivingEntity) entity).getHealth() <= ((LivingEntity) entity).getMaxHealth() / 2)) {
//                AISukunaProcedure.execute(world, x, y, z, entity);
//            } else {
//                AIActiveProcedure.execute(world, x, y, z, entity);
//            }
//            ItadoriShinjukuEffectsProcedure.execute(entity);
//            if (entity.getPersistentData().getDouble("cnt_x") != 0) {
//                if (Math.random() < (1) / ((float) 20)) {
//                    AIBaseProcedure.execute(world, entity);
//                }
//            }
//        }

        if (entity instanceof MakiPreparationEntity) {
            AIZeninMakiProcedure.execute(world, x, y, z, entity);
        } else if (entity instanceof MakiPreparation2Entity) {
            AIZeninMakiProcedure.execute(world, x, y, z, entity);
        }

    }
}
