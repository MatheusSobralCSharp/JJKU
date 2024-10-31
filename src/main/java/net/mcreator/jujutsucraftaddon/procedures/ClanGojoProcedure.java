package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ClanGojoProcedure {
    public static void execute(CommandContext<CommandSourceStack> arguments) {
        {
            String _setval = "Gojo";
            (new Object() {
                public Entity getEntity() {
                    try {
                        return EntityArgument.getEntity(arguments, "Player");
                    } catch (CommandSyntaxException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }.getEntity()).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.Clans = _setval;
                capability.syncPlayerVariables((new Object() {
                    public Entity getEntity() {
                        try {
                            return EntityArgument.getEntity(arguments, "Player");
                        } catch (CommandSyntaxException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }
                }.getEntity()));
            });
        }
    }
}
