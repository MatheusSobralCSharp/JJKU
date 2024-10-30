package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class ProcedureMaki1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Speed Mode")) {
			if (entity.isShiftKeyDown()) {
				if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.INVISIBILITY))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 60, 254, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 6, false, false));
				}
			}
			if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Barrage Attack")
					&& (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:cursed_spirit_armoury_chestplate")) {
				if (entity.isShiftKeyDown()) {
					entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerSelectCurseTechniqueName = "Six Eyes Cut";
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).equals("Six Eyes Cut")) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex10 = new CompoundTag();
						entity.saveWithoutId(dataIndex10);
						return dataIndex10.getCompound("ForgeData").getDouble("PRESS_Z");
					}
				}.getValue() == 1) {
					if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get()))) {
						if (entity.isShiftKeyDown()) {
							{
								final Vec3 _center = new Vec3(x, y, z);
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 20, 25); index0++) {
											if (world instanceof ServerLevel _serverLevel) {
												Entity entitytospawn = JujutsucraftModEntities.CURSED_SPIRIT_GRADE_33.get().spawn(_serverLevel, BlockPos.containing((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ())),
														MobSpawnType.MOB_SUMMONED);
												if (entitytospawn != null) {
													entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
												}
												CompoundTag dataIndex20 = new CompoundTag();
												(entitytospawn).saveWithoutId(dataIndex20);
												dataIndex20.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
												(entitytospawn).load(dataIndex20);
												CompoundTag dataIndex22 = new CompoundTag();
												(entitytospawn).saveWithoutId(dataIndex22);
												dataIndex22.getCompound("ForgeData").putBoolean("CursedSpirit", true);
												(entitytospawn).load(dataIndex22);
												CompoundTag dataIndex24 = new CompoundTag();
												(entitytospawn).saveWithoutId(dataIndex24);
												dataIndex24.getCompound("ForgeData").putBoolean("jjkChara", true);
												(entitytospawn).load(dataIndex24);
												if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.COOLDOWN_TOJI.get(), 300, 1, false, false));
											}
										}
										break;
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
