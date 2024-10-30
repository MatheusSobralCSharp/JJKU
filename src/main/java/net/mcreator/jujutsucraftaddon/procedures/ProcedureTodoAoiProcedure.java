package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;

import java.util.List;
import java.util.Comparator;

public class ProcedureTodoAoiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
			if (entity.isShiftKeyDown()) {
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
						.equals(Component.translatable("jujutsu.technique.boogie_woogie").getString())) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = "Clap";
						capability.syncPlayerVariables(entity);
					});
				}
				if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
						.equals(Component.translatable("jujutsu.technique.todo_ultra").getString())) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = "We Are The Exception";
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Clap")) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
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
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
					if (!(entity instanceof ServerPlayer _plr19 && _plr19.level() instanceof ServerLevel
							&& _plr19.getAdvancements().getOrStartProgress(_plr19.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"))).isDone())) {
						if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
								&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
							if (!(!(!world.getEntitiesOfClass(ItadoriYujiShibuyaEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty()))) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftModEntities.ITADORI_YUJI_SHIBUYA.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
										{
											CompoundTag dataIndex = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex);
											dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
											(entitytospawn).load(dataIndex);
										}
										{
											CompoundTag dataIndex = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex);
											dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													entity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("friend_num");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex);
										}
										{
											CompoundTag dataIndex = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex);
											dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													entity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("friend_num");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex);
										}
										{
											CompoundTag dataIndex = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex);
											dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
												public double getValue() {
													CompoundTag dataIndex = new CompoundTag();
													entity.saveWithoutId(dataIndex);
													return dataIndex.getCompound("ForgeData").getDouble("friend_num");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex);
										}
										_serverLevel.addFreshEntity(entitytospawn);
									}
								}
							}
						}
					} else if (entity instanceof ServerPlayer _plr34 && _plr34.level() instanceof ServerLevel
							&& _plr34.getAdvancements().getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:strong_sorcerer_grade"))).isDone()) {
						if (!(!world.getEntitiesOfClass(ItadoriShinjukuEntity.class, AABB.ofSize(new Vec3(x, y, z), 60, 60, 60), e -> true).isEmpty())) {
							if (world instanceof ServerLevel _serverLevel) {
								Entity entitytospawn = JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
								if (entitytospawn != null) {
									entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
								}
								{
									CompoundTag dataIndex = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex);
									dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
									(entitytospawn).load(dataIndex);
								}
								{
									CompoundTag dataIndex = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex);
									dataIndex.getCompound("ForgeData").putString("Owner", (entity.getStringUUID()));
									(entitytospawn).load(dataIndex);
								}
								{
									CompoundTag dataIndex = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex);
									dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex = new CompoundTag();
											entity.saveWithoutId(dataIndex);
											return dataIndex.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex);
								}
								{
									CompoundTag dataIndex = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex);
									dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex = new CompoundTag();
											entity.saveWithoutId(dataIndex);
											return dataIndex.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex);
								}
								{
									CompoundTag dataIndex = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex);
									dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
										public double getValue() {
											CompoundTag dataIndex = new CompoundTag();
											entity.saveWithoutId(dataIndex);
											return dataIndex.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex);
								}
							}
						}
					}
				}
			}
		}
	}
}
