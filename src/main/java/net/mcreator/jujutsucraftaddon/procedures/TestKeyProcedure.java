package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class TestKeyProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("brokenBrain");
			}
		}.getValue() != 2) {
			if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
					&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"))).isDone()) {
				if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) == false) {
					if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex4 = new CompoundTag();
								entity.saveWithoutId(dataIndex4);
								return dataIndex4.getCompound("ForgeData").getDouble("cnt3");
							}
						}.getValue() < 20) {
							if (new Object() {
								public double getValue() {
									CompoundTag dataIndex5 = new CompoundTag();
									entity.saveWithoutId(dataIndex5);
									return dataIndex5.getCompound("ForgeData").getDouble("cnt3");
								}
							}.getValue() == 0) {
								if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) == false) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run jjc_cursepower -1250 @s");
										}
									}
								} else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run jjc_cursepower -625 @s");
										}
									}
								}
							}
							CompoundTag dataIndex10 = new CompoundTag();
							entity.saveWithoutId(dataIndex10);
							dataIndex10.getCompound("ForgeData").putDouble("PRESS_Z", 1);
							entity.load(dataIndex10);
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							dataIndex12.getCompound("ForgeData").putDouble("select", ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique));
							entity.load(dataIndex12);
							CompoundTag dataIndex13 = new CompoundTag();
							entity.saveWithoutId(dataIndex13);
							dataIndex13.getCompound("ForgeData").putDouble("StartDomainAttack", 1);
							entity.load(dataIndex13);
							CompoundTag dataIndex15 = new CompoundTag();
							entity.saveWithoutId(dataIndex15);
							dataIndex15.getCompound("ForgeData").putDouble("skill",
									(20 + 100 * (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique));
							entity.load(dataIndex15);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), (-1), 1, false, false));
							CompoundTag dataIndex18 = new CompoundTag();
							entity.saveWithoutId(dataIndex18);
							dataIndex18.getCompound("ForgeData").putDouble("cnt3", (new Object() {
								public double getValue() {
									CompoundTag dataIndex17 = new CompoundTag();
									entity.saveWithoutId(dataIndex17);
									return dataIndex17.getCompound("ForgeData").getDouble("cnt3");
								}
							}.getValue() + 1));
							entity.load(dataIndex18);
						}
					}
				}
			}
		}
	}
}
