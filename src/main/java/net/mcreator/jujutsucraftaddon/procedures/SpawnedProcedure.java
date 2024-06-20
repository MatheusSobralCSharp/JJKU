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

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

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
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:purple")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get(), -1, 1, false, false));
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("CursedSpirit");
			}
		}.getValue() == 1) {
			if (!(entity instanceof LivingEntity _livEnt3 && _livEnt3.hasEffect(MobEffects.REGENERATION))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_REGEN)), false, false));
			}
		}
		if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:blue")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity _livEnt7 && _livEnt7.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {
						if (new Object() {
							public double getValue() {
								CompoundTag dataIndex8 = new CompoundTag();
								entity.saveWithoutId(dataIndex8);
								return dataIndex8.getCompound("ForgeData").getDouble("Buffedd");
							}
						}.getValue() != 1) {
							if (!(entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get()))) {
								if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get(), 300, 1, false, false));
								CompoundTag dataIndex11 = new CompoundTag();
								entity.saveWithoutId(dataIndex11);
								dataIndex11.getCompound("ForgeData").putDouble("Buffedd", 1);
								entity.load(dataIndex11);
							}
						}
					}
				}
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
							CompoundTag dataIndex58 = new CompoundTag();
							entity.saveWithoutId(dataIndex58);
							return dataIndex58.getString("forge:spawn_type");
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
							CompoundTag dataIndex61 = new CompoundTag();
							entity.saveWithoutId(dataIndex61);
							return dataIndex61.getString("forge:spawn_type");
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
						CompoundTag dataIndex65 = new CompoundTag();
						entity.saveWithoutId(dataIndex65);
						return dataIndex65.getString("forge:spawn_type");
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
						CompoundTag dataIndex69 = new CompoundTag();
						entity.saveWithoutId(dataIndex69);
						return dataIndex69.getString("forge:spawn_type");
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
						CompoundTag dataIndex73 = new CompoundTag();
						entity.saveWithoutId(dataIndex73);
						return dataIndex73.getString("forge:spawn_type");
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
					CompoundTag dataIndex116 = new CompoundTag();
					entity.saveWithoutId(dataIndex116);
					return dataIndex116.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex117 = new CompoundTag();
					entity.saveWithoutId(dataIndex117);
					return dataIndex117.getString("forge:spawn_type");
				}
			}.getValue()).equals("NATURAL")) {
				if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RATE))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex119 = new CompoundTag();
					entity.saveWithoutId(dataIndex119);
					return dataIndex119.getCompound("ForgeData").getDouble("CurseUser");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex120 = new CompoundTag();
					entity.saveWithoutId(dataIndex120);
					return dataIndex120.getString("forge:spawn_type");
				}
			}.getValue()).equals("NATURAL")) {
				if (Math.random() >= 0.01 * (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_CURSE_USERS_RATE))) {
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex122 = new CompoundTag();
					entity.saveWithoutId(dataIndex122);
					return dataIndex122.getCompound("ForgeData").getDouble("JujutsuSorcerer");
				}
			}.getValue() == 1 && (new Object() {
				public String getValue() {
					CompoundTag dataIndex123 = new CompoundTag();
					entity.saveWithoutId(dataIndex123);
					return dataIndex123.getString("forge:spawn_type");
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
					CompoundTag dataIndex126 = new CompoundTag();
					entity.saveWithoutId(dataIndex126);
					return dataIndex126.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex127 = new CompoundTag();
					entity.saveWithoutId(dataIndex127);
					return dataIndex127.getCompound("ForgeData").getDouble("CurseUser");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex128 = new CompoundTag();
					entity.saveWithoutId(dataIndex128);
					return dataIndex128.getCompound("ForgeData").getDouble("JujutsuSorcerer");
				}
			}.getValue() == 1) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex129 = new CompoundTag();
						entity.saveWithoutId(dataIndex129);
						return dataIndex129.getCompound("ForgeData").getDouble("buff");
					}
				}.getValue() != 1) {
					((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(
							((100 / (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY))) * ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue()));
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
					CompoundTag dataIndex135 = new CompoundTag();
					entity.saveWithoutId(dataIndex135);
					dataIndex135.getCompound("ForgeData").putDouble("buff", 1);
					entity.load(dataIndex135);
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SPAWN_OVERWORLD) == true) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).startsWith("jujutsucraft")) {
				if ((new Object() {
					public String getValue() {
						CompoundTag dataIndex138 = new CompoundTag();
						entity.saveWithoutId(dataIndex138);
						return dataIndex138.getString("forge:spawn_type");
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
						CompoundTag dataIndex141 = new CompoundTag();
						entity.saveWithoutId(dataIndex141);
						return dataIndex141.getString("forge:spawn_type");
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
