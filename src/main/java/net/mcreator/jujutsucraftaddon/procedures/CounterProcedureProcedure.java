package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class CounterProcedureProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.COUNTER_CD.get()))) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "counter"))));
					}
				}
			}
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 254, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 254, false, false));
			{
				Entity _ent = entity;
				_ent.teleportTo((sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), 0, 1)));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport((sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), 0, 1)), _ent.getYRot(), _ent.getXRot());
			}
			sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)),
					(float) (((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue() * (1 - Math.min(20,
							Math.max(((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue() / 5,
									((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getValue()
											- (4 * ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getValue())
													/ (((LivingEntity) sourceentity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS).getValue() + 8)))
							/ 25)));
			sourceentity.setDeltaMovement(new Vec3((10 * Math.cos((entity.getYRot() + 90) * (Math.PI / 180))), (-100), (10 * Math.sin((entity.getYRot() + 90) * (Math.PI / 180)))));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(
						new MobEffectInstance(MobEffects.WEAKNESS, 20, (int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1), false, false));
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20,
						(int) ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) ? _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier() : 0) + 1), false, false));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD.get()), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + 1), (sourceentity.getZ()), 2, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.PUNCH.get()), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + Mth.nextInt(RandomSource.create(), 1, 2)),
						(sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.PUNCH.get()), (sourceentity.getX() + Mth.nextInt(RandomSource.create(), -2, 2)), (sourceentity.getY() + Mth.nextInt(RandomSource.create(), 1, 2)),
						(sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -1, 1)), 1, 0, 0, 0, 1);
			if (!(((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")
					|| ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna"))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COUNTER_CD.get(), 1200, 1, false, false));
			} else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")
					|| ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COUNTER_CD.get(), 300, 1, false, false));
			}
		}
	}
}
