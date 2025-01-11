package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PVPReward5Procedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward5 = ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy()).copy();
		JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
		JujutsucraftaddonModVariables.MapVariables.get(world).PVPReward5Rate = DoubleArgumentType.getDouble(arguments, "Rate");
		JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
		JujutsucraftaddonModVariables.MapVariables.get(world).PVPAmount5 = DoubleArgumentType.getDouble(arguments, "Amount");
		JujutsucraftaddonModVariables.MapVariables.get(world).syncData(world);
	}
}
