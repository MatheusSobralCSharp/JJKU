package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
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
						if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Cleave")) {
							entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.PlayerSelectCurseTechniqueName = "Cleave: Spiderweb";
								capability.syncPlayerVariables(entity);
							});
						}
						{
							final Vec3 _center = new Vec3(x, y, z);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof CleaveWebEntity) {
									CompoundTag dataIndex6 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex6);
									dataIndex6.getCompound("ForgeData").putBoolean("PRESS_Z", true);
									entityiterator.load(dataIndex6);
									CompoundTag dataIndex7 = new CompoundTag();
									entityiterator.saveWithoutId(dataIndex7);
									dataIndex7.getCompound("ForgeData").putDouble("skill", 105);
									entityiterator.load(dataIndex7);
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
							CompoundTag dataIndex10 = new CompoundTag();
							entity.saveWithoutId(dataIndex10);
							return dataIndex10.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue() == 106 && (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex11 = new CompoundTag();
							entity.saveWithoutId(dataIndex11);
							return dataIndex11.getCompound("ForgeData").getBoolean("PRESS_Z");
						}
					}.getValue()) == false) {
						if (entity.isShiftKeyDown()) {
							if (!(!world.getEntitiesOfClass(CleaveWebEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 10, 10, 10), e -> true).isEmpty())) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									CompoundTag dataIndex19 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex19);
									dataIndex19.getCompound("ForgeData").putDouble("friend_num", (new Object() {
										public double getValue() {
											CompoundTag dataIndex18 = new CompoundTag();
											entity.saveWithoutId(dataIndex18);
											return dataIndex18.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex19);
									CompoundTag dataIndex22 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex22);
									dataIndex22.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
										public double getValue() {
											CompoundTag dataIndex21 = new CompoundTag();
											entity.saveWithoutId(dataIndex21);
											return dataIndex21.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex22);
									CompoundTag dataIndex25 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex25);
									dataIndex25.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
										public double getValue() {
											CompoundTag dataIndex24 = new CompoundTag();
											entity.saveWithoutId(dataIndex24);
											return dataIndex24.getCompound("ForgeData").getDouble("friend_num");
										}
									}.getValue()));
									(entitytospawn).load(dataIndex25);
									CompoundTag dataIndex28 = new CompoundTag();
									(entitytospawn).saveWithoutId(dataIndex28);
									dataIndex28.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
									(entitytospawn).load(dataIndex28);
								}
							}
						}
					}
				}
			}
		}
	}
}
