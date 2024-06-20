package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class PassiveKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("skill", 205);
					entity.load(dataIndex3);
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					dataIndex4.getCompound("ForgeData").putDouble("PRESS_Z", 1);
					entity.load(dataIndex4);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
			CompoundTag dataIndex7 = new CompoundTag();
			entity.saveWithoutId(dataIndex7);
			dataIndex7.getCompound("ForgeData").putDouble("skill", 604);
			entity.load(dataIndex7);
			CompoundTag dataIndex8 = new CompoundTag();
			entity.saveWithoutId(dataIndex8);
			dataIndex8.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex8);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
			CompoundTag dataIndex11 = new CompoundTag();
			entity.saveWithoutId(dataIndex11);
			dataIndex11.getCompound("ForgeData").putDouble("skill", 1006);
			entity.load(dataIndex11);
			CompoundTag dataIndex13 = new CompoundTag();
			entity.saveWithoutId(dataIndex13);
			dataIndex13.getCompound("ForgeData").putDouble("cnt5", (new Object() {
				public double getValue() {
					CompoundTag dataIndex12 = new CompoundTag();
					entity.saveWithoutId(dataIndex12);
					return dataIndex12.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() + 1));
			entity.load(dataIndex13);
			CompoundTag dataIndex15 = new CompoundTag();
			entity.saveWithoutId(dataIndex15);
			dataIndex15.getCompound("ForgeData").putDouble("cnt1", (new Object() {
				public double getValue() {
					CompoundTag dataIndex14 = new CompoundTag();
					entity.saveWithoutId(dataIndex14);
					return dataIndex14.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() + 1));
			entity.load(dataIndex15);
			CompoundTag dataIndex16 = new CompoundTag();
			entity.saveWithoutId(dataIndex16);
			dataIndex16.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex16);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18) {
			CompoundTag dataIndex19 = new CompoundTag();
			entity.saveWithoutId(dataIndex19);
			dataIndex19.getCompound("ForgeData").putDouble("skill", 1810);
			entity.load(dataIndex19);
			CompoundTag dataIndex20 = new CompoundTag();
			entity.saveWithoutId(dataIndex20);
			dataIndex20.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex20);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 29) {
			CompoundTag dataIndex23 = new CompoundTag();
			entity.saveWithoutId(dataIndex23);
			dataIndex23.getCompound("ForgeData").putDouble("skill", 2905);
			entity.load(dataIndex23);
			CompoundTag dataIndex24 = new CompoundTag();
			entity.saveWithoutId(dataIndex24);
			dataIndex24.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex24);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
			CompoundTag dataIndex27 = new CompoundTag();
			entity.saveWithoutId(dataIndex27);
			dataIndex27.getCompound("ForgeData").putDouble("skill", 2005);
			entity.load(dataIndex27);
			CompoundTag dataIndex28 = new CompoundTag();
			entity.saveWithoutId(dataIndex28);
			dataIndex28.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex28);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
			CompoundTag dataIndex31 = new CompoundTag();
			entity.saveWithoutId(dataIndex31);
			dataIndex31.getCompound("ForgeData").putDouble("skill", 1905);
			entity.load(dataIndex31);
			CompoundTag dataIndex33 = new CompoundTag();
			entity.saveWithoutId(dataIndex33);
			dataIndex33.getCompound("ForgeData").putDouble("cnt5", (new Object() {
				public double getValue() {
					CompoundTag dataIndex32 = new CompoundTag();
					entity.saveWithoutId(dataIndex32);
					return dataIndex32.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() + 1));
			entity.load(dataIndex33);
			CompoundTag dataIndex35 = new CompoundTag();
			entity.saveWithoutId(dataIndex35);
			dataIndex35.getCompound("ForgeData").putDouble("cnt1", (new Object() {
				public double getValue() {
					CompoundTag dataIndex34 = new CompoundTag();
					entity.saveWithoutId(dataIndex34);
					return dataIndex34.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() + 1));
			entity.load(dataIndex35);
			CompoundTag dataIndex36 = new CompoundTag();
			entity.saveWithoutId(dataIndex36);
			dataIndex36.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex36);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
			CompoundTag dataIndex39 = new CompoundTag();
			entity.saveWithoutId(dataIndex39);
			dataIndex39.getCompound("ForgeData").putDouble("skill", 1305);
			entity.load(dataIndex39);
			CompoundTag dataIndex40 = new CompoundTag();
			entity.saveWithoutId(dataIndex40);
			dataIndex40.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex40);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
			CompoundTag dataIndex43 = new CompoundTag();
			entity.saveWithoutId(dataIndex43);
			dataIndex43.getCompound("ForgeData").putDouble("skill", 910);
			entity.load(dataIndex43);
			CompoundTag dataIndex44 = new CompoundTag();
			entity.saveWithoutId(dataIndex44);
			dataIndex44.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex44);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
			CompoundTag dataIndex47 = new CompoundTag();
			entity.saveWithoutId(dataIndex47);
			dataIndex47.getCompound("ForgeData").putDouble("skill", 3005);
			entity.load(dataIndex47);
			CompoundTag dataIndex48 = new CompoundTag();
			entity.saveWithoutId(dataIndex48);
			dataIndex48.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex48);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
			CompoundTag dataIndex51 = new CompoundTag();
			entity.saveWithoutId(dataIndex51);
			dataIndex51.getCompound("ForgeData").putDouble("skill", 2705);
			entity.load(dataIndex51);
			CompoundTag dataIndex52 = new CompoundTag();
			entity.saveWithoutId(dataIndex52);
			dataIndex52.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex52);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				CompoundTag dataIndex55 = new CompoundTag();
				entity.saveWithoutId(dataIndex55);
				dataIndex55.getCompound("ForgeData").putDouble("skill", 705);
				entity.load(dataIndex55);
				CompoundTag dataIndex56 = new CompoundTag();
				entity.saveWithoutId(dataIndex56);
				dataIndex56.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex56);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
					}
				}
			}
		}
	}
}
