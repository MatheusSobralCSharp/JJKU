package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;

public class SorcererSpawnedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
            }
        }.getValue() != 1) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("cnt_target", 1);
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("jjkChara", true);
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("JujutsuSorcerer", true);
                entity.load(dataIndex);
            }
        }
        if (entity instanceof ItadoriShinjukuEntity) {
            ItadoriShinjukuEffectsProcedure.execute(entity);
        }
    }
}
