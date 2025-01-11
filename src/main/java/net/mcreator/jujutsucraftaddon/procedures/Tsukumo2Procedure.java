package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class Tsukumo2Procedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex0 = new CompoundTag();
                entity.saveWithoutId(dataIndex0);
                return dataIndex0.getCompound("ForgeData").getDouble("skill");
            }
        }.getValue() > 0) {
          
        }
    }
}
