package net.mcreator.jujutsucraftaddon.procedures;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.Entity;

public class ClanIshigoriProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
        if (entity == null)
            return;
        {
            String _setval = StringArgumentType.getString(arguments, "Ishigori");
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Clans = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
    }
}
