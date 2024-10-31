package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;

public class IgrisRightClickedOnEntityProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof IgrisEntity) {
            ((IgrisEntity) entity).setAnimation("kneel");
        }
        if (entity instanceof Shadow1Entity) {
            ((Shadow1Entity) entity).setAnimation("kneel");
        }
    }
}
