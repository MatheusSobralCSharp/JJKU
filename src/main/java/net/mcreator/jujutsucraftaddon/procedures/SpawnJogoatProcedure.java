package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;

public class SpawnJogoatProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 0) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex12 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex12);
						dataIndex12.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex12);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Beat Jogoat!"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 1) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.HANAMI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex50 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex50);
						dataIndex50.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex50);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.MAHITO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.CHOSO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Smash Hanami In The Wall"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 2) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.KENJAKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex105 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex105);
						dataIndex105.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex105);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Beat That Jin-Itadori Wife"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 3) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex126 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex126);
						dataIndex126.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex126);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.OKKOTSU_YUTA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Train Your Pupils"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.SUKUNA_FUSHIGURO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex160 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex160);
						dataIndex160.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex160);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("12/24"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 0) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_01.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 3, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex188 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex188);
						dataIndex188.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex188);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Give This Weak Curse a \"Showtime\""), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 1) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.JOGO.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex209 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex209);
						dataIndex209.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex209);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Who Is That Curse?"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 2) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.EIGHT_HANDLED_SWROD_DIVERGENT_SILA_DIVINE_GENERAL_MAHORAGA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2));
						CompoundTag dataIndex230 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex230);
						dataIndex230.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex230);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Take Care Of Mahoraga And Give Him a Beat"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 3) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						CompoundTag dataIndex251 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex251);
						dataIndex251.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex251);
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.ZENIN_MAKI_CULLING_GAME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Beat Those Two Brats"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 4) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.YOROZU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex285 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex285);
						dataIndex285.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex285);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Time For A Test-Drive"), false);
				if (entity instanceof Player _player)
					_player.closeContainer();
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 5) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.GOJO_SATORU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex306 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex306);
						dataIndex306.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex306);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				CompoundTag dataIndex318 = new CompoundTag();
				entity.saveWithoutId(dataIndex318);
				dataIndex318.getCompound("ForgeData").putDouble("IsMahoraga", 1);
				entity.load(dataIndex318);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "mahoraga");
					}
				}
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Arrogant, Gojo Satoru"), false);
			} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 6) {
				if (world instanceof ServerLevel _serverLevel) {
					Entity entitytospawn = JujutsucraftModEntities.KASHIMO_HAJIME.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entitytospawn != null) {
						entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
						if ((entitytospawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 28, false, false));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex330 = new CompoundTag();
						(entitytospawn).saveWithoutId(dataIndex330);
						dataIndex330.getCompound("ForgeData").putDouble("GH", 1);
						(entitytospawn).load(dataIndex330);
						((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 3));
						if ((entitytospawn) instanceof LivingEntity _entity)
							_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						if ((entitytospawn) instanceof Mob _entity && entity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						_serverLevel.addFreshEntity(entitytospawn);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Don't Disappoint Me"), false);
			}
		}
	}
}
