package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnUi2Procedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        return entity.getPersistentData().getDouble("UiUi") == 0;
    }
}
