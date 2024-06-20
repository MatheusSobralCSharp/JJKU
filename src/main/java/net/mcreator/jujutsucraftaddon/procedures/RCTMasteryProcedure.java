package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class RCTMasteryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double cooldown1 = 0;
		double cooldown2 = 0;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn == true) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd1 == 0) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2 <= 0) {
					{
						double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2 + 1;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cd2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2 > 0) {
					{
						double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2
								- (1 + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage);
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cd2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
				CompoundTag dataIndex3 = new CompoundTag();
				entity.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("PRESS_M", 0);
				entity.load(dataIndex3);
				{
					double _setval = 6000;
					entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cd1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd1 > 0
					&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2 == 1) {
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) == false) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 20, 0, false, false));
				}
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("PRESS_M");
					}
				}.getValue() == 0) {
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					dataIndex7.getCompound("ForgeData").putDouble("PRESS_M", 1);
					entity.load(dataIndex7);
				} else if (new Object() {
					public double getValue() {
						CompoundTag dataIndex8 = new CompoundTag();
						entity.saveWithoutId(dataIndex8);
						return dataIndex8.getCompound("ForgeData").getDouble("PRESS_M");
					}
				}.getValue() == 1) {
					RCTLevelTwoProcedure.execute(world, entity);
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex9 = new CompoundTag();
							entity.saveWithoutId(dataIndex9);
							return dataIndex9.getCompound("ForgeData").getDouble("NBT_CursePowerAmount");
						}
					}.getValue() <= 500) {
						{
							boolean _setval = false;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTMasteryOn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						CompoundTag dataIndex10 = new CompoundTag();
						entity.saveWithoutId(dataIndex10);
						dataIndex10.getCompound("ForgeData").putBoolean("PRESS_M", false);
						entity.load(dataIndex10);
					}
					{
						double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd1 - 1;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.cd1 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd1 > 0
					&& (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).cd2 < 1) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Your RCT Mastery is On Cooldown"), true);
			}
		}
	}
}
