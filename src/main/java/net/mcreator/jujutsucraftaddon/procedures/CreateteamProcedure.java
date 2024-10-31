package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;

public class CreateteamProcedure {
    public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
        if (world instanceof Level _level)
            _level.getScoreboard().addPlayerTeam((StringArgumentType.getString(arguments, "teamName")));
    }
}
