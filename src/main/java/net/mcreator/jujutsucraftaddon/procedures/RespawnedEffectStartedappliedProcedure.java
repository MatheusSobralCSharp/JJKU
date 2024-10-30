package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.Objects;

public class RespawnedEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_RCT_LEVEL_CAP));
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RCTLimitLevel = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_HP_CAP));
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HPCap = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount < 1) {
			{
				double _setval = 1;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RCTCount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		{
			double _setval = x;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AnimationDefense = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = y;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AnimationSlash = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = z;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AnimationYuzuki = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_OPEN_FOR_SUKUNA)) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "execute as @s run advancement revoke @s only jujutsucraft:mastery_open_barrier_type_domain");
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RCT)) {
			{
				boolean _setval = true;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.rctspirit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.rctspirit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).YutaCheck == 1) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerCurseTechnique2 = 5;
				capability.syncPlayerVariables(entity);
			});
			{
				double _setval = 0;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.YutaCheck = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING)) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).MahoragaCanAdapt != 1) {
					{
						double _setval = 1;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MahoragaCanAdapt = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_MAHORAGA_CAN_ADAPT_EVERYTHING)) {
			if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).MahoragaCanAdapt != 0) {
					{
						double _setval = 0;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MahoragaCanAdapt = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_ANIMATIONS)) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run != 1) {
				{
					double _setval = 1;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_ANIMATIONS)) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run != 0) {
				{
					double _setval = 0;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
			{
				boolean _setval = false;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsVessel = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = false;
				entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsCursedSpirit = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SpeedValue > 0) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SpeedValue));
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue() + 0.1));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() + 0.1));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).getBaseValue() + 0.1));
		}
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap > 0) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute <= (entity
					.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap) {
				Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH))
						.setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HealthAttribute));
			} else {
				Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH))
						.setBaseValue(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).HPCap));
			}
		}
		if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Gifted")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue() + 0.2));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() + 0.2));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue() + 0.2));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)).getBaseValue() + 0.2));
		} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Cursed")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue() + 0.1));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue() + 0.1));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() + 0.1));
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)).getBaseValue() + 0.1));
		} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Speedy")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() + 0.1));
		} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Strong")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue() + 0.1));
		} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Resistant")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.ARMOR)).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue() + 0.1));
		} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("Healthy")) {
			Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH))
					.setBaseValue((Objects.requireNonNull(((LivingEntity) entity).getAttribute(Attributes.MAX_HEALTH)).getBaseValue() + 0.1));
		}
	}
}
