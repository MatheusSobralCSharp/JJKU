package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class MahitoExtensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Knockback Attack")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Soul Transfiguration";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Human Bullet")) {
			entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSelectCurseTechniqueName = "Explosive Human Bullet";
				capability.syncPlayerVariables(entity);
			});
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Soul Transfiguration")) {
			if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(JujutsucraftaddonModMobEffects.SIZE.get()))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SIZE.get(), 600, 1, false, false));
				}
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Hands")) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
				entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerSelectCurseTechniqueName = "Idel Mutation: Instant Spirit Body of Distorted Killing";
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
				.equals("Idel Mutation: Instant Spirit Body of Distorted Killing")) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
					CompoundTag dataIndex12 = new CompoundTag();
					entity.saveWithoutId(dataIndex12);
					dataIndex12.getCompound("ForgeData").putDouble("skill", 1515);
					entity.load(dataIndex12);
					{
						double _setval = 1;
						entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.OutputLevel = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex13 = new CompoundTag();
				entity.saveWithoutId(dataIndex13);
				return dataIndex13.getCompound("ForgeData").getDouble("cnt6");
			}
		}.getValue() >= 5 && new Object() {
			public double getValue() {
				CompoundTag dataIndex14 = new CompoundTag();
				entity.saveWithoutId(dataIndex14);
				return dataIndex14.getCompound("ForgeData").getDouble("cnt6");
			}
		}.getValue() < 20) {
			CompoundTag dataIndex16 = new CompoundTag();
			entity.saveWithoutId(dataIndex16);
			dataIndex16.getCompound("ForgeData").putDouble("cnt6", (new Object() {
				public double getValue() {
					CompoundTag dataIndex15 = new CompoundTag();
					entity.saveWithoutId(dataIndex15);
					return dataIndex15.getCompound("ForgeData").getDouble("cnt6");
				}
			}.getValue() + 1));
			entity.load(dataIndex16);
		}
	}
}
