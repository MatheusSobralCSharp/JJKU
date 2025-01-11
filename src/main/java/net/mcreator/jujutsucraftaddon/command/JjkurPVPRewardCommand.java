
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
import net.minecraft.commands.Commands;

import net.mcreator.jujutsucraftaddon.procedures.PVPRewardProcedure;
import net.mcreator.jujutsucraftaddon.procedures.PVPReward5Procedure;
import net.mcreator.jujutsucraftaddon.procedures.PVPReward4Procedure;
import net.mcreator.jujutsucraftaddon.procedures.PVPReward3Procedure;
import net.mcreator.jujutsucraftaddon.procedures.PVPReward2Procedure;

import com.mojang.brigadier.arguments.DoubleArgumentType;

@Mod.EventBusSubscriber
public class JjkurPVPRewardCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("jjkuSetPVPReward").requires(s -> s.hasPermission(2))
				.then(Commands.literal("Reward1").then(Commands.argument("Rate", DoubleArgumentType.doubleArg()).then(Commands.argument("Amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

					PVPRewardProcedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("Reward2").then(Commands.argument("Rate", DoubleArgumentType.doubleArg()).then(Commands.argument("Amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

					PVPReward2Procedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("Reward3").then(Commands.argument("Rate", DoubleArgumentType.doubleArg()).then(Commands.argument("Amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

					PVPReward3Procedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("Reward4").then(Commands.argument("Rate", DoubleArgumentType.doubleArg()).then(Commands.argument("Amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

					PVPReward4Procedure.execute(world, arguments, entity);
					return 0;
				})))).then(Commands.literal("Reward5").then(Commands.argument("Rate", DoubleArgumentType.doubleArg()).then(Commands.argument("Amount", DoubleArgumentType.doubleArg()).executes(arguments -> {
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

					PVPReward5Procedure.execute(world, arguments, entity);
					return 0;
				})))));
	}
}
