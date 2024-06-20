package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class JJKUFrienddProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "Friend")) {
				CompoundTag dataIndex1 = new CompoundTag();
				entityiterator.saveWithoutId(dataIndex1);
				dataIndex1.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
				entityiterator.load(dataIndex1);
				CompoundTag dataIndex3 = new CompoundTag();
				entityiterator.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex2 = new CompoundTag();
						entity.saveWithoutId(dataIndex2);
						return dataIndex2.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				entityiterator.load(dataIndex3);
				CompoundTag dataIndex5 = new CompoundTag();
				entityiterator.saveWithoutId(dataIndex5);
				dataIndex5.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex4 = new CompoundTag();
						entity.saveWithoutId(dataIndex4);
						return dataIndex4.getCompound("ForgeData").getDouble("friend_num2");
					}
				}.getValue()));
				entityiterator.load(dataIndex5);
				CompoundTag dataIndex7 = new CompoundTag();
				entityiterator.saveWithoutId(dataIndex7);
				dataIndex7.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("friend_num_worker");
					}
				}.getValue()));
				entityiterator.load(dataIndex7);
				{
					String _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).TeamName;
					entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.TeamName = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				if (entityiterator instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Now you are in: " + entity.getDisplayName().getString() + " Team")), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\"Successful Invited: " + "" + entityiterator.getDisplayName().getString())), false);
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
