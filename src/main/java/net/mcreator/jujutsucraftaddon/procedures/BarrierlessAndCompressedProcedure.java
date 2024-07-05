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
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 2) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entity.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() > 0) {
						JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 36;
						JujutsucraftModVariables.MapVariables.get(world).syncData(world);
						CompoundTag dataIndex4 = new CompoundTag();
						entity.saveWithoutId(dataIndex4);
						dataIndex4.getCompound("ForgeData").putDouble("cnt2", 1);
						entity.load(dataIndex4);
					}
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
					if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) != 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 1200, 1, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 1200,
									(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) + 2),
									false, false));
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
				if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							return dataIndex12.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() > 0) {
						JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
						JujutsucraftModVariables.MapVariables.get(world).syncData(world);
						if (!(new Object() {
							public double getValue() {
								CompoundTag dataIndex14 = new CompoundTag();
								entity.saveWithoutId(dataIndex14);
								return dataIndex14.getCompound("ForgeData").getDouble("x_pos_doma");
							}
						}.getValue() == entity.getX())) {
							CompoundTag dataIndex17 = new CompoundTag();
							entity.saveWithoutId(dataIndex17);
							dataIndex17.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
							entity.load(dataIndex17);
						}
						if (!(new Object() {
							public double getValue() {
								CompoundTag dataIndex18 = new CompoundTag();
								entity.saveWithoutId(dataIndex18);
								return dataIndex18.getCompound("ForgeData").getDouble("z_pos_doma");
							}
						}.getValue() == entity.getZ())) {
							CompoundTag dataIndex21 = new CompoundTag();
							entity.saveWithoutId(dataIndex21);
							dataIndex21.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
							entity.load(dataIndex21);
						}
					}
				}
			} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
					if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) != 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 3600, 0, false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 3600,
									(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()) ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier() : 0) + 2),
									false, false));
					}
				}
			}
		}
	}
}
