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
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class WorldSlashQuestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
				&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_19"))).isDone()) {
			if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
					&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:save_me_mahoraga"))).isDone()) {
				if (!(entity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
						&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone())) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							entity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
						}
					}.getValue() == -2) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex4 = new CompoundTag();
								entity.saveWithoutId(dataIndex4);
								return dataIndex4.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
							}
						}.getValue() == -2) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 50) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_SLASH_EFFECT.get(), 1000, 4, false, false));
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 1000, 3, false, false));
								if (entity instanceof LivingEntity _entity)
									_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
								{
									double _setval = 5;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.OutputLevel = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = true;
									entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WorldSlash = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								CompoundTag dataIndex10 = new CompoundTag();
								entity.saveWithoutId(dataIndex10);
								dataIndex10.getCompound("ForgeData").putBoolean("PRESS_Z", true);
								entity.load(dataIndex10);
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
												_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run effect give @s jujutsucraft:cursed_technique");
									}
								}
								CompoundTag dataIndex12 = new CompoundTag();
								entity.saveWithoutId(dataIndex12);
								dataIndex12.getCompound("ForgeData").putDouble("skill", 105);
								entity.load(dataIndex12);
								if (entity instanceof ServerPlayer _player) {
									Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"));
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
