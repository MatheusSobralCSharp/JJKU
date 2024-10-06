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
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class MeditationStateEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Your Training With Your Inner-Spirit Starts Now... Good Luck!"), false);
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_TOJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex7 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex7);
					dataIndex7.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex7);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.SUKUNA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					CompoundTag dataIndex27 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex27);
					dataIndex27.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex27);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex35 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex35);
					dataIndex35.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex35);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 3) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.INUMAKI_TOGE.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex49 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex49);
					dataIndex49.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex49);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 4) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex63 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex63);
					dataIndex63.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex63);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA_CULLING_GAME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex77 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex77);
					dataIndex77.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex77);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.FUSHIGURO_MEGUMI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex91 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex91);
					dataIndex91.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex91);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.KASHIMO_HAJIME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex105 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex105);
					dataIndex105.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex105);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 8) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.DAGON_2.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex119 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex119);
					dataIndex119.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex119);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.TSUKUMO_YUKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex133 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex133);
					dataIndex133.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex133);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.CHOSO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex147 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex147);
					dataIndex147.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex147);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.MEI_MEI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex161 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex161);
					dataIndex161.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex161);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 12) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ISHIGORI_RYU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex175 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex175);
					dataIndex175.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex175);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.NANAMI_KENTO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex189 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex189);
					dataIndex189.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex189);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 14) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex203 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex203);
					dataIndex203.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex203);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex217 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex217);
					dataIndex217.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex217);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 16) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex231 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex231);
					dataIndex231.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex231);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 17) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.TAKABA_FUMIHIKO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex245 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex245);
					dataIndex245.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex245);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.GETO_SUGURU_CURSE_USER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex259 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex259);
					dataIndex259.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex259);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ZENIN_NAOYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex273 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex273);
					dataIndex273.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex273);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.TODO_AOI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex287 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex287);
					dataIndex287.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex287);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex301 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex301);
					dataIndex301.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex301);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		}
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 22) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ZENIN_JINICHI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex315 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex315);
					dataIndex315.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex315);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.URAUME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					CompoundTag dataIndex335 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex335);
					dataIndex335.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex335);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 25) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_01.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex343 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex343);
					dataIndex343.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex343);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ZENIN_OGI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex357 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex357);
					dataIndex357.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex357);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.HIGURUMA_HIROMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex371 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex371);
					dataIndex371.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex371);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 28) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.KURUSU_HANA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex385 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex385);
					dataIndex385.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex385);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 29) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.HAKARI_KINJI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex399 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex399);
					dataIndex399.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex399);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.MIGUEL_DANCER.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex413 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex413);
					dataIndex413.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex413);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 31) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.KUSAKABE_YATSUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex427 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex427);
					dataIndex427.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex427);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 32) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.ZENIN_CHOJURO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex441 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex441);
					dataIndex441.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex441);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 33) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.YAGA_MASAMICHI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex455 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex455);
					dataIndex455.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex455);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 34) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.NOBARA_KUGISAKI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex469 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex469);
					dataIndex469.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex469);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 35) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.YOSHINO_JUNPEI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex483 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex483);
					dataIndex483.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex483);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 36) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.NISHIMIYA_MOMO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex497 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex497);
					dataIndex497.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex497);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 37) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.DHRUV_LAKDAWALLA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex511 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex511);
					dataIndex511.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex511);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 38) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.URO_TAKAKO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex525 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex525);
					dataIndex525.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex525);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 39) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.YOROZU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex539 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex539);
					dataIndex539.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex539);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 40) {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftModEntities.INO_TAKUMA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(10000);
					((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(30);
					CompoundTag dataIndex553 = new CompoundTag();
					(entitytospawn).saveWithoutId(dataIndex553);
					dataIndex553.getCompound("ForgeData").putDouble("Spirit", 1);
					(entitytospawn).load(dataIndex553);
					if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 253, false, false));
					if ((entitytospawn) instanceof LivingEntity _entity)
						_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
					_serverLevel.addFreshEntity(entitytospawn);
				}
			}
		}
	}
}
