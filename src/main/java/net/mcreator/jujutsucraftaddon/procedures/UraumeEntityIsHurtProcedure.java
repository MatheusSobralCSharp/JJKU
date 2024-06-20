package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

public class UraumeEntityIsHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			if (!((entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) || new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue() == new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue())) {
				if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
			}
		} else if (!(sourceentity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.POISON))) {
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 59, false, false));
		}
	}
}
