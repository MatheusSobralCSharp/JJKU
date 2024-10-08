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

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class Quest14StartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Itadori Yuji: AH KUGISAKI!!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Kechizu: AH, BROTHER!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Eso: You-... YOU SAW IIT???!!!!!!!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Kechizu: I'm Sorry BROTHER!!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Itadori Yuji: EH, WHO? SORRY, I GUESS..?!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Eso: I WILL KILL YOU!!"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Kugisaki Nobara: Why Do You Even Dress Like That, Then? "), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Eso: Extreme Corrosion Technique: WINGED KING"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Eso: I WILL KILL YOU."), false);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex12 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex12);
				dataIndex12.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex12);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex25 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex25);
				dataIndex25.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex24 = new CompoundTag();
						entity.saveWithoutId(dataIndex24);
						return dataIndex24.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex25);
				CompoundTag dataIndex28 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex28);
				dataIndex28.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex27 = new CompoundTag();
						entity.saveWithoutId(dataIndex27);
						return dataIndex27.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex28);
				for (int index0 = 0; index0 < 20; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.NOBARA_KUGISAKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex34 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex34);
				dataIndex34.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex34);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex47 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex47);
				dataIndex47.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex46 = new CompoundTag();
						entity.saveWithoutId(dataIndex46);
						return dataIndex46.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex47);
				CompoundTag dataIndex50 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex50);
				dataIndex50.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex49 = new CompoundTag();
						entity.saveWithoutId(dataIndex49);
						return dataIndex49.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex50);
				for (int index1 = 0; index1 < 20; index1++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.ESO.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 12));
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
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.KECHIZU.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
				for (int index3 = 0; index3 < 20; index3++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
