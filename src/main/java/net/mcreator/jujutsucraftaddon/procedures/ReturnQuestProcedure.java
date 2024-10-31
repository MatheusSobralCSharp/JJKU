package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class ReturnQuestProcedure {
    public static String execute(Entity entity) {
        if (entity == null)
            return "";
        return Component.translatable("dialoguequest").getString() + "" + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).QuestActive;
    }
}
