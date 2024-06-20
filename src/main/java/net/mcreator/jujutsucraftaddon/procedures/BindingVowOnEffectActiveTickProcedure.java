package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class BindingVowOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW_COOLDOWN.get()))) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) == 3) {
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex2 = new CompoundTag();
						entity.saveWithoutId(dataIndex2);
						return dataIndex2.getCompound("ForgeData").getBoolean("PRESS_Z");
					}
				}.getValue()) == true) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							entity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("bindingskill");
						}
					}.getValue() == 0) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:zone 60 1 true");
							}
						}
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						dataIndex6.getCompound("ForgeData").putDouble("bindingskill", (new Object() {
							public double getValue() {
								CompoundTag dataIndex5 = new CompoundTag();
								entity.saveWithoutId(dataIndex5);
								return dataIndex5.getCompound("ForgeData").getDouble("skill");
							}
						}.getValue()));
						entity.load(dataIndex6);
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) == 4) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash == true) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex8 = new CompoundTag();
							entity.saveWithoutId(dataIndex8);
							return dataIndex8.getCompound("ForgeData").getDouble("PRESS_Z");
						}
					}.getValue() == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex9 = new CompoundTag();
								entity.saveWithoutId(dataIndex9);
								return dataIndex9.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() < 50) {
							CompoundTag dataIndex11 = new CompoundTag();
							entity.saveWithoutId(dataIndex11);
							dataIndex11.getCompound("ForgeData").putDouble("cnt6", (new Object() {
								public double getValue() {
									CompoundTag dataIndex10 = new CompoundTag();
									entity.saveWithoutId(dataIndex10);
									return dataIndex10.getCompound("ForgeData").getDouble("cnt6");
								}
							}.getValue() + 1));
							entity.load(dataIndex11);
						}
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).WorldSlash == false) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							return dataIndex12.getCompound("ForgeData").getDouble("PRESS_Z");
						}
					}.getValue() == 1) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex13 = new CompoundTag();
								entity.saveWithoutId(dataIndex13);
								return dataIndex13.getCompound("ForgeData").getDouble("cnt6");
							}
						}.getValue() <= 3) {
							CompoundTag dataIndex14 = new CompoundTag();
							entity.saveWithoutId(dataIndex14);
							dataIndex14.getCompound("ForgeData").putDouble("cnt5", 4);
							entity.load(dataIndex14);
							CompoundTag dataIndex15 = new CompoundTag();
							entity.saveWithoutId(dataIndex15);
							dataIndex15.getCompound("ForgeData").putDouble("cnt6", 4);
							entity.load(dataIndex15);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.BINDING_VOW.get()).getAmplifier() : 0) == 5) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex17 = new CompoundTag();
						entity.saveWithoutId(dataIndex17);
						return dataIndex17.getCompound("ForgeData").getDouble("PRESS_Z");
					}
				}.getValue() == 1) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex18 = new CompoundTag();
							entity.saveWithoutId(dataIndex18);
							return dataIndex18.getCompound("ForgeData").getDouble("Range");
						}
					}.getValue() < 200) {
						CompoundTag dataIndex20 = new CompoundTag();
						entity.saveWithoutId(dataIndex20);
						dataIndex20.getCompound("ForgeData").putDouble("Range", (new Object() {
							public double getValue() {
								CompoundTag dataIndex19 = new CompoundTag();
								entity.saveWithoutId(dataIndex19);
								return dataIndex19.getCompound("ForgeData").getDouble("Range");
							}
						}.getValue() + 1));
						entity.load(dataIndex20);
					}
				}
			}
		}
	}
}
