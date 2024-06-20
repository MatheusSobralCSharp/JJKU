package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Direction;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class LimbsEffectOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS) == true) {
			if (entity.isAlive()) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 1) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "leftarmgone"))));
							}
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							entity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() >= 1) {
						CompoundTag dataIndex4 = new CompoundTag();
						entity.saveWithoutId(dataIndex4);
						dataIndex4.getCompound("ForgeData").putDouble("select", 0);
						entity.load(dataIndex4);
						CompoundTag dataIndex5 = new CompoundTag();
						entity.saveWithoutId(dataIndex5);
						dataIndex5.getCompound("ForgeData").putDouble("PRESS_Z", 0);
						entity.load(dataIndex5);
						CompoundTag dataIndex6 = new CompoundTag();
						entity.saveWithoutId(dataIndex6);
						dataIndex6.getCompound("ForgeData").putDouble("skill", 0);
						entity.load(dataIndex6);
					}
					if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() - 0.35), (entity.getY() + 1.3), (entity.getZ() - 0.2), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + 0.35), (entity.getY() + 1.3), (entity.getZ() - 0.2), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.WEST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 1.3), (entity.getZ() + 0.5), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 1.3), (entity.getZ() - 0.5), 0, 0, 0, 0, 0.1);
					}
					if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MobEffects.CONFUSION))) {
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 120,
										(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
												? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
												: 0) + 1),
										false, false));
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0,
									false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 4, false, false));
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 2) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "leftleggone"))));
							}
						}
					}
					if (!(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 120,
										(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
												? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
												: 0) + 1),
										false, false));
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0,
									false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 0, false, false));
					}
					if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() - 0.1), (entity.getY() + 0.5), (entity.getZ()), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + 0.1), (entity.getY() + 0.5), (entity.getZ()), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.WEST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 0.5), (entity.getZ() + 0.1), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 0.5), (entity.getZ() - 0.1), 0, 0, 0, 0, 0.1);
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 3) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rightarmgone"))));
							}
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex69 = new CompoundTag();
							entity.saveWithoutId(dataIndex69);
							return dataIndex69.getCompound("ForgeData").getDouble("select");
						}
					}.getValue() >= 1) {
						CompoundTag dataIndex70 = new CompoundTag();
						entity.saveWithoutId(dataIndex70);
						dataIndex70.getCompound("ForgeData").putDouble("select", 0);
						entity.load(dataIndex70);
						CompoundTag dataIndex71 = new CompoundTag();
						entity.saveWithoutId(dataIndex71);
						dataIndex71.getCompound("ForgeData").putDouble("PRESS_Z", 0);
						entity.load(dataIndex71);
						CompoundTag dataIndex72 = new CompoundTag();
						entity.saveWithoutId(dataIndex72);
						dataIndex72.getCompound("ForgeData").putDouble("skill", 0);
						entity.load(dataIndex72);
					}
					if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + 0.35), (entity.getY() + 1.3), (entity.getZ() - 0.2), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() - 0.35), (entity.getY() + 1.3), (entity.getZ() - 0.2), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.WEST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 1.3), (entity.getZ() - 0.5), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 1.3), (entity.getZ() + 0.5), 0, 0, 0, 0, 0.1);
					}
					if (!(entity instanceof LivingEntity _livEnt97 && _livEnt97.hasEffect(MobEffects.CONFUSION))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0,
									false, false));
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 120,
										(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
												? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
												: 0) + 1),
										false, false));
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 120, 4, false, false));
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 4) {
					if (world.isClientSide()) {
						if (entity instanceof AbstractClientPlayer player) {
							var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
							if (animation != null) {
								animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rightleggone"))));
							}
						}
					}
					if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() + 0.1), (entity.getY() + 0.5), (entity.getZ()), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX() - 0.1), (entity.getY() + 0.5), (entity.getZ()), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.WEST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 0.5), (entity.getZ() - 0.1), 0, 0, 0, 0, 0.1);
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), (entity.getX()), (entity.getY() + 0.5), (entity.getZ() + 0.1), 0, 0, 0, 0, 0.1);
					}
					if (!(entity instanceof LivingEntity _livEnt128 && _livEnt128.hasEffect(MobEffects.MOVEMENT_SLOWDOWN))) {
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.NEUTRALIZATION.get(), 120,
										(int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())
												? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier()
												: 0) + 1),
										false, false));
						}
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 1, entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) ? _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() : 0,
									false, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 0, false, false));
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 1) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex135 = new CompoundTag();
							entity.saveWithoutId(dataIndex135);
							return dataIndex135.getCompound("ForgeData").getDouble("PRESS_M");
						}
					}.getValue() == 1) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity _livEnt136 && _livEnt136.hasEffect(MobEffects.REGENERATION)) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen >= 60) {
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Limb = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "leftarmrecover"))));
								}
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Arm Recovered"), false);
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get());
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 3) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex143 = new CompoundTag();
							entity.saveWithoutId(dataIndex143);
							return dataIndex143.getCompound("ForgeData").getDouble("PRESS_M");
						}
					}.getValue() == 1) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity _livEnt144 && _livEnt144.hasEffect(MobEffects.REGENERATION)) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen >= 60) {
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Limb = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rightarmrecover"))));
								}
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Arm Recovered"), false);
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get());
					}
				}
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 2) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex151 = new CompoundTag();
							entity.saveWithoutId(dataIndex151);
							return dataIndex151.getCompound("ForgeData").getDouble("PRESS_M");
						}
					}.getValue() == 1) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity _livEnt152 && _livEnt152.hasEffect(MobEffects.REGENERATION)) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen >= 60) {
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Limb = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "leftlegrecover"))));
								}
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Leg Recovered"), false);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get());
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb == 4) {
					if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex159 = new CompoundTag();
							entity.saveWithoutId(dataIndex159);
							return dataIndex159.getCompound("ForgeData").getDouble("PRESS_M");
						}
					}.getValue() == 1) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity _livEnt160 && _livEnt160.hasEffect(MobEffects.REGENERATION)) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
						{
							double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen + 1;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTRegen >= 60) {
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Limb = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isClientSide()) {
							if (entity instanceof AbstractClientPlayer player) {
								var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
								if (animation != null) {
									animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rightlegrecover"))));
								}
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Leg Recovered"), false);
						{
							double _setval = 0;
							entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.RCTRegen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get());
					}
				}
			}
		}
	}
}
