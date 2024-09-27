package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Comparator;

public class SukunaPowersOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double timer3 = 0;
		if ((new Object() {
			public boolean getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getBoolean("FlagSukuna");
			}
		}.getValue()) == true) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if (entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
						&& _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
					if (entity.isShiftKeyDown()) {
						if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
								.equals(Component.translatable("jujutsu.technique.cleave").getString())) {
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguecw").getString());
								capability.syncPlayerVariables(entity);
							});
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof CleaveWebEntity) {
									CompoundTag dataIndex8 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex8);
									dataIndex8.getCompound("ForgeData").putBoolean("PRESS_Z", true);
									entityiterator.load(dataIndex8);
									CompoundTag dataIndex9 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex9);
									dataIndex9.getCompound("ForgeData").putDouble("skill", 105);
									entityiterator.load(dataIndex9);
									{
										Entity _ent = entityiterator;
										if (!_ent.level().isClientSide() && _ent.getServer() != null) {
											_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
													_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
													"execute as @s run jjc_cursepower -100 @s");
										}
									}
								}
							}
						}
					}
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex12 = new CompoundTag();
							entity.saveWithoutId(dataIndex12);
							return dataIndex12.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 106) {
						if (entity.isShiftKeyDown()) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (!(new Object() {
											public String getValue() {
												CompoundTag dataIndex15 = new CompoundTag();
												entityiterator.saveWithoutId(dataIndex15);
												return dataIndex15.getCompound("ForgeData").getString("OWNER_UUID");
											}
										}.getValue()).equals(entity.getStringUUID())) {
											if (!world.getEntitiesOfClass(CleaveWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty() == false) {
												if (world instanceof ServerLevel _serverLevel) {
													Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
													if (entitytospawn != null) {
														entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
													}
													CompoundTag dataIndex20 = new CompoundTag();
													(entitytospawn).saveWithoutId(dataIndex20);
													dataIndex20.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
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
													CompoundTag dataIndex29 = new CompoundTag();
													(entitytospawn).saveWithoutId(dataIndex29);
													dataIndex29.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
														public double getValue() {
															CompoundTag dataIndex28 = new CompoundTag();
															entity.saveWithoutId(dataIndex28);
															return dataIndex28.getCompound("ForgeData").getDouble("friend_num");
														}
													}.getValue()));
													(entitytospawn).load(dataIndex29);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
