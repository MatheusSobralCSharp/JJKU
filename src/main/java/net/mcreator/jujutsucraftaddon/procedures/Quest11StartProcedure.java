package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class Quest11StartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Itadori Yuji: NANAMIN!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Kento Nanami: I'll Reprimand You Later. Give Me A Report On The Situation At Hand."), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Mahito: What's This? You're Looking Super Lively, Aren't You, Shaman?"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Mahito: It's Good That We Both Made It Out Safe. Wanna Go In For A Hug?"), false);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex7 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex7);
				dataIndex7.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex7);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex20 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex20);
				dataIndex20.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex19 = new CompoundTag();
						entity.saveWithoutId(dataIndex19);
						return dataIndex19.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex20);
				CompoundTag dataIndex23 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex23);
				dataIndex23.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex22 = new CompoundTag();
						entity.saveWithoutId(dataIndex22);
						return dataIndex22.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex23);
				for (int index0 = 0; index0 < 20; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.NANAMI_KENTO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex29 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex29);
				dataIndex29.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex29);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex42 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex42);
				dataIndex42.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex41 = new CompoundTag();
						entity.saveWithoutId(dataIndex41);
						return dataIndex41.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex42);
				CompoundTag dataIndex45 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex45);
				dataIndex45.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex44 = new CompoundTag();
						entity.saveWithoutId(dataIndex44);
						return dataIndex44.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex45);
				for (int index1 = 0; index1 < 20; index1++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 4));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
				for (int index2 = 0; index2 < 20; index2++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		{
			double _setval = 12;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.History = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
