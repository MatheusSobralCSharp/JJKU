package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class BarrierlessAndCompressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 0) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() > 0) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex3 = new CompoundTag();
								entity.saveWithoutId(dataIndex3);
								return dataIndex3.getCompound("ForgeData").getDouble("cnt2");
							}
						}.getValue() != 1) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainSizeVariable != 33) {
								JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 33;
								JujutsucraftModVariables.MapVariables.get(world).syncData(world);
								{
									double _setval = 33;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DomainSizeVariable = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							CompoundTag dataIndex5 = new CompoundTag();
							entity.saveWithoutId(dataIndex5);
							dataIndex5.getCompound("ForgeData").putDouble("cnt2", 1);
							entity.load(dataIndex5);
						}
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex6 = new CompoundTag();
								entity.saveWithoutId(dataIndex6);
								return dataIndex6.getCompound("ForgeData").getDouble("Range");
							}
						}.getValue() != 66) {
							CompoundTag dataIndex7 = new CompoundTag();
							entity.saveWithoutId(dataIndex7);
							dataIndex7.getCompound("ForgeData").putDouble("Range", 66);
							entity.load(dataIndex7);
						}
					}
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
					if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) == false) {
						if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainSizeVariable != 22) {
							JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
							JujutsucraftModVariables.MapVariables.get(world).syncData(world);
							{
								double _setval = 22;
								entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.DomainSizeVariable = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 1200, 1, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 1200,
									(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) + 0),
									false, false));
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex16 = new CompoundTag();
							entity.saveWithoutId(dataIndex16);
							return dataIndex16.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() > 0) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex17 = new CompoundTag();
								entity.saveWithoutId(dataIndex17);
								return dataIndex17.getCompound("ForgeData").getDouble("cnt1");
							}
						}.getValue() >= 1) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainSizeVariable != 12) {
								JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
								JujutsucraftModVariables.MapVariables.get(world).syncData(world);
								{
									double _setval = 12;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DomainSizeVariable = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							if (!(new Object() {
								public double getValue() {
									CompoundTag dataIndex19 = new CompoundTag();
									entity.saveWithoutId(dataIndex19);
									return dataIndex19.getCompound("ForgeData").getDouble("x_pos_doma");
								}
							}.getValue() == entity.getX())) {
								CompoundTag dataIndex22 = new CompoundTag();
								entity.saveWithoutId(dataIndex22);
								dataIndex22.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
								entity.load(dataIndex22);
							}
							if (!(new Object() {
								public double getValue() {
									CompoundTag dataIndex23 = new CompoundTag();
									entity.saveWithoutId(dataIndex23);
									return dataIndex23.getCompound("ForgeData").getDouble("z_pos_doma");
								}
							}.getValue() == entity.getZ())) {
								CompoundTag dataIndex26 = new CompoundTag();
								entity.saveWithoutId(dataIndex26);
								dataIndex26.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
								entity.load(dataIndex26);
							}
						}
					}
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
					if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) == false) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 3600, 0, false, false));
						if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainSizeVariable != 22) {
							JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 22;
							JujutsucraftModVariables.MapVariables.get(world).syncData(world);
							{
								double _setval = 22;
								entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.DomainSizeVariable = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 3600,
									(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) + 0),
									false, false));
					}
				}
			}
		}
	}
}
