
package net.mcreator.jujutsucraftaddon.command;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

import net.mcreator.jujutsucraftaddon.procedures.ChangeRaceProcedureUserProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ChangeRaceProcedureSpiritProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ChangeRaceProcedureProcedure;

@Mod.EventBusSubscriber
public class JjkuChangeRaceCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("jjkuChangeRace").requires(s -> s.hasPermission(4)).then(Commands.literal("CursedSpirit").then(Commands.argument("Player", EntityArgument.entity()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ChangeRaceProcedureSpiritProcedure.execute(arguments);
			return 0;
		}))).then(Commands.literal("JujutsuSorcerer").then(Commands.argument("Player", EntityArgument.entity()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ChangeRaceProcedureProcedure.execute(arguments);
			return 0;
		}))).then(Commands.literal("CurseUser").then(Commands.argument("Player", EntityArgument.entity()).executes(arguments -> {
			Level world = arguments.getSource().getUnsidedLevel();
			double x = arguments.getSource().getPosition().x();
			double y = arguments.getSource().getPosition().y();
			double z = arguments.getSource().getPosition().z();
			Entity entity = arguments.getSource().getEntity();
			if (entity == null && world instanceof ServerLevel _servLevel)
				entity = FakePlayerFactory.getMinecraft(_servLevel);
			Direction direction = Direction.DOWN;
			if (entity != null)
				direction = entity.getDirection();

			ChangeRaceProcedureUserProcedure.execute(arguments);
			return 0;
		}))));
	}
}
