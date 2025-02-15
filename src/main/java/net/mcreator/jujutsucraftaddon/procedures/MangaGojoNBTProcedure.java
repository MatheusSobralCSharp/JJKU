package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.entity.GojoMangaEntity;
import net.minecraft.world.entity.Entity;

public class MangaGojoNBTProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof GojoMangaEntity) {
            entity.getPersistentData().putBoolean("UseCursedTechnique", true);
            entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
            entity.getPersistentData().putBoolean("infinity", true);
        }
    }
}
