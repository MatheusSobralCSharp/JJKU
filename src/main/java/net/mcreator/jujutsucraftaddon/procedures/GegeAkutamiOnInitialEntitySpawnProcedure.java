package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

public class GegeAkutamiOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		CompoundTag dataIndex0 = new CompoundTag();
		entity.saveWithoutId(dataIndex0);
		dataIndex0.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
		entity.load(dataIndex0);
		CompoundTag dataIndex1 = new CompoundTag();
		entity.saveWithoutId(dataIndex1);
		dataIndex1.getCompound("ForgeData").putBoolean("CurseUser", true);
		entity.load(dataIndex1);
		CompoundTag dataIndex2 = new CompoundTag();
		entity.saveWithoutId(dataIndex2);
		dataIndex2.getCompound("ForgeData").putBoolean("FlagSukuna", true);
		entity.load(dataIndex2);
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100000, 3, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100000, 32, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100000, 3, false, false));
	}
}
