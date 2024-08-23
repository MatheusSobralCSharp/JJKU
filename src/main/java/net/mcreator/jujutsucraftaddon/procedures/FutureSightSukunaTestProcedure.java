package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

import java.util.List;
import java.util.Comparator;

public class FutureSightSukunaTestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(new Object() {
						public String getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound((new Object() {
								public String getValue() {
									CompoundTag dataIndex1 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex1);
									return dataIndex1.getCompound("ForgeCaps").getString("jujutsucraft:player_variables");
								}
							}.getValue())).getString("PlayerSelectCurseTechniqueName");
						}
					}.getValue()).equals("")) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((new Object() {
								public String getValue() {
									CompoundTag dataIndex4 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex4);
									return dataIndex4.getCompound((new Object() {
										public String getValue() {
											CompoundTag dataIndex3 = new CompoundTag();
											entityiterator.saveWithoutId(dataIndex3);
											return dataIndex3.getCompound("ForgeCaps").getString("jujutsucraft:player_variables");
										}
									}.getValue())).getString("PlayerSelectCurseTechniqueName");
								}
							}.getValue())), false);
					}
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get(), 60, 1, false, false));
	}
}
