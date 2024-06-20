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

public class YutaExtensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Attack")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Copy1";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Knockback Attack")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Copy2";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Barrage Attack")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Copy3";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Speed Attack")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Copy4";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Copy1")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 1) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex11 = new CompoundTag();
							entity.saveWithoutId(dataIndex11);
							return dataIndex11.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy1)) {
						CompoundTag dataIndex12 = new CompoundTag();
						entity.saveWithoutId(dataIndex12);
						dataIndex12.getCompound("ForgeData").putDouble("skill", ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy1));
						entity.load(dataIndex12);
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 1 0 true");
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Copy2")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex15 = new CompoundTag();
					entity.saveWithoutId(dataIndex15);
					return dataIndex15.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 1) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex17 = new CompoundTag();
							entity.saveWithoutId(dataIndex17);
							return dataIndex17.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy2)) {
						CompoundTag dataIndex18 = new CompoundTag();
						entity.saveWithoutId(dataIndex18);
						dataIndex18.getCompound("ForgeData").putDouble("skill", ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy2));
						entity.load(dataIndex18);
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 1 0 true");
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Copy3")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex21 = new CompoundTag();
					entity.saveWithoutId(dataIndex21);
					return dataIndex21.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 1) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex23 = new CompoundTag();
							entity.saveWithoutId(dataIndex23);
							return dataIndex23.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy3)) {
						CompoundTag dataIndex24 = new CompoundTag();
						entity.saveWithoutId(dataIndex24);
						dataIndex24.getCompound("ForgeData").putDouble("skill", ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy3));
						entity.load(dataIndex24);
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 1 0 true");
					}
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Copy4")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex27 = new CompoundTag();
					entity.saveWithoutId(dataIndex27);
					return dataIndex27.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 1) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) == false) {
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex29 = new CompoundTag();
							entity.saveWithoutId(dataIndex29);
							return dataIndex29.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy4)) {
						CompoundTag dataIndex30 = new CompoundTag();
						entity.saveWithoutId(dataIndex30);
						dataIndex30.getCompound("ForgeData").putDouble("skill", ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Copy4));
						entity.load(dataIndex30);
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cooldown_time_combat 1 0 true");
						}
					}
				}
			}
		}
	}
}
