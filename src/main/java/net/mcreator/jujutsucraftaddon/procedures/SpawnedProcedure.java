package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.SukunaNoShirtEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaMangaEntity;
import net.mcreator.jujutsucraftaddon.entity.ShokoIeriSchoolEntity;
import net.mcreator.jujutsucraftaddon.entity.RikoAmanaiEntity;
import net.mcreator.jujutsucraftaddon.entity.MakiPreparationEntity;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SpawnedProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:domain_expansion_entity")) {
			CompoundTag dataIndex2 = new CompoundTag();
			entity.saveWithoutId(dataIndex2);
			dataIndex2.getCompound("ForgeData").putDouble("DomainExpansionSizer", Math.round(JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius + 3));
			entity.load(dataIndex2);
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:purple")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), -1, 1, false, false));
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex5 = new CompoundTag();
				entity.saveWithoutId(dataIndex5);
				return dataIndex5.getCompound("ForgeData").getDouble("CursedSpirit");
			}
		}.getValue() == 1) {
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RCT) == true) {
				CompoundTag dataIndex7 = new CompoundTag();
				entity.saveWithoutId(dataIndex7);
				dataIndex7.getCompound("ForgeData").putDouble("RCT", 1);
				entity.load(dataIndex7);
			}
			if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.REGENERATION))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_REGEN)), false, false));
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_CHANGER) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:zenin_naoya")) {
					if (!(!world.getEntitiesOfClass(MakiPreparationEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (Math.random() <= 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.MAKI_PREPARATION.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:geto_suguru")) {
					if (!(!world.getEntitiesOfClass(RikoAmanaiEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (Math.random() <= 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.RIKO_AMANAI.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru_school_days")) {
					if (!(!world.getEntitiesOfClass(ShokoIeriSchoolEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = JujutsucraftaddonModEntities.SHOKO_IERI_SCHOOL.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
					}
				}
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_perfect")) {
					if (!(!world.getEntitiesOfClass(ItadoriShinjukuEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.YUTA_CULLING_GAMES.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
					if (!(!world.getEntitiesOfClass(SukunaNoShirtEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (Math.random() < 0.05) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.SUKUNA_NO_SHIRT.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
					if (!(!world.getEntitiesOfClass(SukunaMangaEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
						if (Math.random() < 0.01) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = JujutsucraftaddonModEntities.SUKUNA_MANGA.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ()), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_ARMORY_SPIRIT) == true) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:cursed_spirit_grade_37")) {
					if (!(new Object() {
						public String getValue() {
							CompoundTag dataIndex56 = new CompoundTag();
							entity.saveWithoutId(dataIndex56);
							return dataIndex56.getString("forge:spawn_type");
						}
					}.getValue()).equals("COMMAND")) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_STEVENSON) == true) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:stevenson_screen")) {
					if (!(new Object() {
						public String getValue() {
							CompoundTag dataIndex59 = new CompoundTag();
							entity.saveWithoutId(dataIndex59);
							return dataIndex59.getString("forge:spawn_type");
						}
					}.getValue()).equals("COMMAND")) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")
					|| (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex63 = new CompoundTag();
						entity.saveWithoutId(dataIndex63);
						return dataIndex63.getString("forge:spawn_type");
					}
				}.getValue()).equals("NATURAL")) {
					if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_RATE))) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru_school_days") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex67 = new CompoundTag();
						entity.saveWithoutId(dataIndex67);
						return dataIndex67.getString("forge:spawn_type");
					}
				}.getValue()).equals("NATURAL")) {
					if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_GOJO_RATE))) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:fushiguro_toji") || (ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:fushiguro_toji_bug")) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex71 = new CompoundTag();
						entity.saveWithoutId(dataIndex71);
						return dataIndex71.getString("forge:spawn_type");
					}
				}.getValue()).equals("NATURAL")) {
					if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_TOJI_RATE))) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_CHANGER) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:hakari_kinji")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, -1, 1, false, false));
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(500);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kashimo_hajime")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(500);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:uraume")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(400);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(400);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if (entity instanceof ItadoriShinjukuEntity) {
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ITADORI_ARMS.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.ITADORI_ARMS.get()).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:kusakabe_yatsuya")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(400);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:todo_aoi")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(400);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:choso")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(400);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:miguel_dancer")) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(500);
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run item replace entity @s weapon.mainhand with jujutsucraft:black_rope");
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100000, 25, false, false));
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex114 = new CompoundTag();
					entity.saveWithoutId(dataIndex114);
					return dataIndex114.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex115 = new CompoundTag();
					entity.saveWithoutId(dataIndex115);
					return dataIndex115.getString("forge:spawn_type");
				}
			}.getValue()).equals("NATURAL")) {
				if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RATE))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex117 = new CompoundTag();
					entity.saveWithoutId(dataIndex117);
					return dataIndex117.getCompound("ForgeData").getDouble("CurseUser");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex118 = new CompoundTag();
					entity.saveWithoutId(dataIndex118);
					return dataIndex118.getString("forge:spawn_type");
				}
			}.getValue()).equals("NATURAL")) {
				if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSE_USERS_RATE))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex120 = new CompoundTag();
					entity.saveWithoutId(dataIndex120);
					return dataIndex120.getCompound("ForgeData").getDouble("JujutsuSorcerer");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex121 = new CompoundTag();
					entity.saveWithoutId(dataIndex121);
					return dataIndex121.getString("forge:spawn_type");
				}
			}.getValue()).equals("NATURAL")) {
				if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SORCERERS_RATE))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex124 = new CompoundTag();
					entity.saveWithoutId(dataIndex124);
					return dataIndex124.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex125 = new CompoundTag();
					entity.saveWithoutId(dataIndex125);
					return dataIndex125.getCompound("ForgeData").getDouble("CurseUser");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex126 = new CompoundTag();
					entity.saveWithoutId(dataIndex126);
					return dataIndex126.getCompound("ForgeData").getDouble("JujutsuSorcerer");
				}
			}.getValue() == 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex127 = new CompoundTag();
						entity.saveWithoutId(dataIndex127);
						return dataIndex127.getCompound("ForgeData").getDouble("buff");
					}
				}.getValue() != 1) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(
							((100 / (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY))) * ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue()));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex133 = new CompoundTag();
					entity.saveWithoutId(dataIndex133);
					dataIndex133.getCompound("ForgeData").putDouble("buff", 1);
					entity.load(dataIndex133);
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_OVERWORLD) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex136 = new CompoundTag();
						entity.saveWithoutId(dataIndex136);
						return dataIndex136.getString("forge:spawn_type");
					}
				}.getValue()).equals("NATURAL")) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_VANILLA) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft") == false) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex139 = new CompoundTag();
						entity.saveWithoutId(dataIndex139);
						return dataIndex139.getString("forge:spawn_type");
					}
				}.getValue()).equals("NATURAL")) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			}
		}
	}
}
