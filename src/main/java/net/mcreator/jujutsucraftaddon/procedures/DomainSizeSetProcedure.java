package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DomainSizeSetProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = (DoubleArgumentType.getDouble(arguments, "DomainSize"));
		JujutsucraftModVariables.MapVariables.get(world).syncData(world);
	}
}
