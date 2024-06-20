package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.AdjuchaEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class ProcedureTodoAoiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
			if (entity.isShiftKeyDown()) {
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Boogie Woogie")) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = "Clap";
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Plus Ultra")) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = "We Are The Exception";
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Clap")) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								{
									Entity _ent = entityiterator;
									_ent.setYRot(0);
									_ent.setXRot(5);
									_ent.setYBodyRot(_ent.getYRot());
									_ent.setYHeadRot(_ent.getYRot());
									_ent.yRotO = _ent.getYRot();
									_ent.xRotO = _ent.getXRot();
									if (_ent instanceof LivingEntity _entity) {
										_entity.yBodyRotO = _entity.getYRot();
										_entity.yHeadRotO = _entity.getYRot();
									}
								}
								{
									Entity _ent = entity;
									_ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
								}
								{
									Entity _ent = entityiterator;
									_ent.teleportTo(x, y, z);
									if (_ent instanceof ServerPlayer _serverPlayer)
										_serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
								}
							}
						}
					}
				}
			}
			if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("We Are The Exception")) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
								&& _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"))).isDone()) {
							if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraftaddon:itadori_shinjuku")) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex18 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex18);
										return dataIndex18.getCompound("ForgeData").getDouble("friend_num_worker");
									}
								}.getValue() != new Object() {
									public double getValue() {
										CompoundTag dataIndex19 = new CompoundTag();
										entity.saveWithoutId(dataIndex19);
										return dataIndex19.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()) {
									CompoundTag dataIndex21 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex21);
									dataIndex21.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex20 = new CompoundTag();
											entity.saveWithoutId(dataIndex20);
											return dataIndex20.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex21);
									CompoundTag dataIndex23 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex23);
									dataIndex23.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex22 = new CompoundTag();
											entity.saveWithoutId(dataIndex22);
											return dataIndex22.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex23);
									CompoundTag dataIndex25 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex25);
									dataIndex25.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
										public double getValue() {
											CompoundTag dataIndex24 = new CompoundTag();
											entity.saveWithoutId(dataIndex24);
											return dataIndex24.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex25);
								}
							} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:itadori_yuji_shibuya")) {
								if (new Object() {
									public double getValue() {
										CompoundTag dataIndex27 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex27);
										return dataIndex27.getCompound("ForgeData").getDouble("friend_num_worker");
									}
								}.getValue() != new Object() {
									public double getValue() {
										CompoundTag dataIndex28 = new CompoundTag();
										entity.saveWithoutId(dataIndex28);
										return dataIndex28.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()) {
									CompoundTag dataIndex30 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex30);
									dataIndex30.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex29 = new CompoundTag();
											entity.saveWithoutId(dataIndex29);
											return dataIndex29.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex30);
									CompoundTag dataIndex32 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex32);
									dataIndex32.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex31 = new CompoundTag();
											entity.saveWithoutId(dataIndex31);
											return dataIndex31.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex32);
									CompoundTag dataIndex34 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex34);
									dataIndex34.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
										public double getValue() {
											CompoundTag dataIndex33 = new CompoundTag();
											entity.saveWithoutId(dataIndex33);
											return dataIndex33.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									entityiterator.load(dataIndex34);
								}
							}
						}
					}
				}
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
					if (!(entity instanceof ServerPlayer _plr37 && _plr37.level() instanceof ServerLevel
							&& _plr37.getAdvancements().getOrStartProgress(_plr37.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"))).isDone())) {
						if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
								&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
							if (!(!world.getEntitiesOfClass(ItadoriYujiShibuyaEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									CompoundTag dataIndex42 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex42);
									dataIndex42.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
									(entitytospawn).load(dataIndex42);
									CompoundTag dataIndex45 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex45);
									dataIndex45.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex44 = new CompoundTag();
											entity.saveWithoutId(dataIndex44);
											return dataIndex44.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex45);
									CompoundTag dataIndex48 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex48);
									dataIndex48.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex47 = new CompoundTag();
											entity.saveWithoutId(dataIndex47);
											return dataIndex47.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex48);
									CompoundTag dataIndex51 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex51);
									dataIndex51.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
										public double getValue() {
											CompoundTag dataIndex50 = new CompoundTag();
											entity.saveWithoutId(dataIndex50);
											return dataIndex50.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex51);
								}
							}
						}
					} else if (entity instanceof ServerPlayer _plr53 && _plr53.level() instanceof ServerLevel
							&& _plr53.getAdvancements().getOrStartProgress(_plr53.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"))).isDone()) {
						if (!(!world.getEntitiesOfClass(ItadoriShinjukuEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _serverLevel) {
								Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entitytospawn != null) {
									entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								}
								CompoundTag dataIndex57 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex57);
								dataIndex57.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
								(entitytospawn).load(dataIndex57);
								CompoundTag dataIndex60 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex60);
								dataIndex60.getCompound("ForgeData").putDouble("friend_num", (new Object() {
									public double getValue() {
										CompoundTag dataIndex59 = new CompoundTag();
										entity.saveWithoutId(dataIndex59);
										return dataIndex59.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex60);
								CompoundTag dataIndex63 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex63);
								dataIndex63.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
									public double getValue() {
										CompoundTag dataIndex62 = new CompoundTag();
										entity.saveWithoutId(dataIndex62);
										return dataIndex62.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex63);
								CompoundTag dataIndex66 = new CompoundTag();
								(entitytospawn).saveWithoutId(dataIndex66);
								dataIndex66.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
									public double getValue() {
										CompoundTag dataIndex65 = new CompoundTag();
										entity.saveWithoutId(dataIndex65);
										return dataIndex65.getCompound("ForgeData").getDouble("friend_num");
									}
								}.getValue()));
								(entitytospawn).load(dataIndex66);
							}
						}
					}
				}
			}
		}
	}
}
