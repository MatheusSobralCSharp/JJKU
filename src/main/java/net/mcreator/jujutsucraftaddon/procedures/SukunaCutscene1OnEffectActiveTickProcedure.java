package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.entity.ErroEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class SukunaCutscene1OnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ErroEntity) {
			((ErroEntity) entity).setAnimation("sukunawaken1");
		}
		if (entity instanceof Mob) {
			try {
				((Mob) entity).setTarget(null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 254, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 260,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1), false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 260,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier() : 0) + 1), false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 260,
					(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier() : 0) + 0), false,
					false));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get()))) {
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 260, 254, false, false));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 260,
								(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier() : 0) + 1), false,
								false));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 260,
								(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0) + 1),
								false, false));
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 260,
								(int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())
										? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier()
										: 0) + 0),
								false, false));
				}
			}
		}
		entity.getPersistentData().putDouble("cnt_x", 0);
		entity.getPersistentData().putDouble("cnt_start", 0);
	}
}
