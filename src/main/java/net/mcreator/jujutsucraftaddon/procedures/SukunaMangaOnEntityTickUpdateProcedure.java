package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class SukunaMangaOnEntityTickUpdateProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("UseCursedTechnique");
            }
        }.getValue() == 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("CurseUser");
            }
        }.getValue() == 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("CurseUser", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("FlagSukuna");
            }
        }.getValue() == 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("FlagSukuna", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique14", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
                entity.load(dataIndex);
            }
        }
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
            }
        }.getValue() <= 0) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
                entity.load(dataIndex);
            }
        }
    }
}
