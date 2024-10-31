package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;

public class Shadow1RightClickedOnEntityProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
            if (entity instanceof Shadow1Entity) {
                ((Shadow1Entity) entity).setAnimation("kneel");
            }
        }
    }
}
