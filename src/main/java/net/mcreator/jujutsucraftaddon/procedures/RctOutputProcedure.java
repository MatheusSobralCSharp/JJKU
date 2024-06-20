package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class RctOutputProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsJujutsuSorcerer == true) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex0 = new CompoundTag();
					entity.saveWithoutId(dataIndex0);
					return dataIndex0.getCompound("ForgeData").getDouble("PRESS_M");
				}
			}.getValue() == 1) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
							RCTLevelTwoProcedure.execute(world, entity);
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 40,
										(int) ((entity instanceof LivingEntity && ((LivingEntity) entityiterator).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
												? ((LivingEntity) entityiterator).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
												: 0)
												+ (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
														? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
														: 0)),
										false, false));
						}
					}
				}
			}
		}
	}
}
