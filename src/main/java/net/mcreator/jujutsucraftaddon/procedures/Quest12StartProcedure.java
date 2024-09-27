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

public class Quest12StartProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Fushiguro Megumi: We Should Give Gojou-Sensei A Call."), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Noritoshi Kamo: Wait.. A Second"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Toge Inumaki: Tuna Mayo."), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Hanami: STOP THIS, FOOLISH CHILDREN."), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Hanami: ALL I WANT... IS TO PROTECT THIS PLANET."), false);
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_MEGUMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex8 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex8);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex20 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex20);
				dataIndex20.getCompound("ForgeData").putDouble("TenShadowsTechnique14", (-2));
				(entitytospawn).load(dataIndex20);
				CompoundTag dataIndex23 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex23);
				dataIndex23.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex22 = new CompoundTag();
						entity.saveWithoutId(dataIndex22);
						return dataIndex22.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex23);
				CompoundTag dataIndex26 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex26);
				dataIndex26.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex25 = new CompoundTag();
						entity.saveWithoutId(dataIndex25);
						return dataIndex25.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex26);
				for (int index0 = 0; index0 < 20; index0++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.KAMO_NORITOSHI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex32 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex32);
				dataIndex32.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex32);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex44 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex44);
				dataIndex44.getCompound("ForgeData").putDouble("TenShadowsTechnique14", (-2));
				(entitytospawn).load(dataIndex44);
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
			Entity entitytospawn = JujutsucraftModEntities.INUMAKI_TOGE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex56 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex56);
				dataIndex56.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex56);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex69 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex69);
				dataIndex69.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex68 = new CompoundTag();
						entity.saveWithoutId(dataIndex68);
						return dataIndex68.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex69);
				CompoundTag dataIndex72 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex72);
				dataIndex72.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex71 = new CompoundTag();
						entity.saveWithoutId(dataIndex71);
						return dataIndex71.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex72);
				for (int index2 = 0; index2 < 20; index2++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.NISHIMIYA_MOMO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex78 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex78);
				dataIndex78.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex78);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex91 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex91);
				dataIndex91.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex90 = new CompoundTag();
						entity.saveWithoutId(dataIndex90);
						return dataIndex90.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex91);
				CompoundTag dataIndex94 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex94);
				dataIndex94.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex93 = new CompoundTag();
						entity.saveWithoutId(dataIndex93);
						return dataIndex93.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex94);
				for (int index3 = 0; index3 < 20; index3++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.ZENIN_MAKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex100 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex100);
				dataIndex100.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex100);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 7));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex113 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex113);
				dataIndex113.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex112 = new CompoundTag();
						entity.saveWithoutId(dataIndex112);
						return dataIndex112.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex113);
				CompoundTag dataIndex116 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex116);
				dataIndex116.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex115 = new CompoundTag();
						entity.saveWithoutId(dataIndex115);
						return dataIndex115.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex116);
				for (int index4 = 0; index4 < 20; index4++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex122 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex122);
				dataIndex122.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex122);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex135 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex135);
				dataIndex135.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex134 = new CompoundTag();
						entity.saveWithoutId(dataIndex134);
						return dataIndex134.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex135);
				CompoundTag dataIndex138 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex138);
				dataIndex138.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex137 = new CompoundTag();
						entity.saveWithoutId(dataIndex137);
						return dataIndex137.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex138);
				for (int index5 = 0; index5 < 20; index5++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.TODO_AOI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				CompoundTag dataIndex144 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex144);
				dataIndex144.getCompound("ForgeData").putString("OWNER_UUID", ((entitytospawn).getStringUUID()));
				(entitytospawn).load(dataIndex144);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				CompoundTag dataIndex157 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex157);
				dataIndex157.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex156 = new CompoundTag();
						entity.saveWithoutId(dataIndex156);
						return dataIndex156.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex157);
				CompoundTag dataIndex160 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex160);
				dataIndex160.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex159 = new CompoundTag();
						entity.saveWithoutId(dataIndex159);
						return dataIndex159.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex160);
				for (int index6 = 0; index6 < 20; index6++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		if (world instanceof ServerLevel _serverLevel) {
			Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, (z + 5)), MobSpawnType.MOB_SUMMONED);
			if (entitytospawn != null) {
				entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 20));
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 29, false, false));
				CompoundTag dataIndex174 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex174);
				dataIndex174.getCompound("ForgeData").putDouble("Quest12", 1);
				(entitytospawn).load(dataIndex174);
				if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
				for (int index7 = 0; index7 < 20; index7++) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.BLOOD_RED.get()), x, y, (z + 5), 3, 3, 3, 3, 1);
				}
				_serverLevel.addFreshEntity(entitytospawn);
			}
		}
		{
			double _setval = 13;
			entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.History = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
