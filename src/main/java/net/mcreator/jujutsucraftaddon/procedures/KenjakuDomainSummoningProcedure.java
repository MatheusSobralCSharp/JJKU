package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class KenjakuDomainSummoningProcedure {
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
		if (!(entity.getPersistentData().getString("OWNER_UUID")).equals("")) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						if (entityiterator.isShiftKeyDown()) {
							if (((entityiterator.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Kenjaku")) {
								if ((entity.getPersistentData().getString("OWNER_UUID")).equals(entityiterator.getStringUUID())) {
									if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:hanami")) {
										CompoundTag dataIndex6 = new CompoundTag();
										entity.saveWithoutId(dataIndex6);
										dataIndex6.getCompound("ForgeData").putDouble("skill", 1420);
										entity.load(dataIndex6);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
													(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
															? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
															: 0) + 1),
													false, false));
										CompoundTag dataIndex8 = new CompoundTag();
										entity.saveWithoutId(dataIndex8);
										dataIndex8.getCompound("ForgeData").putDouble("PRESS_Z", 1);
										entity.load(dataIndex8);
									} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:cursed_spirit_grade_05")) {
										CompoundTag dataIndex10 = new CompoundTag();
										entity.saveWithoutId(dataIndex10);
										dataIndex10.getCompound("ForgeData").putDouble("skill", 2520);
										entity.load(dataIndex10);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
													(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
															? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
															: 0) + 1),
													false, false));
										CompoundTag dataIndex12 = new CompoundTag();
										entity.saveWithoutId(dataIndex12);
										dataIndex12.getCompound("ForgeData").putDouble("PRESS_Z", 1);
										entity.load(dataIndex12);
									} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:dagon_2")) {
										CompoundTag dataIndex14 = new CompoundTag();
										entity.saveWithoutId(dataIndex14);
										dataIndex14.getCompound("ForgeData").putDouble("skill", 820);
										entity.load(dataIndex14);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
													(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
															? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
															: 0) + 1),
													false, false));
										CompoundTag dataIndex16 = new CompoundTag();
										entity.saveWithoutId(dataIndex16);
										dataIndex16.getCompound("ForgeData").putDouble("PRESS_Z", 1);
										entity.load(dataIndex16);
									} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:mahito")) {
										CompoundTag dataIndex18 = new CompoundTag();
										entity.saveWithoutId(dataIndex18);
										dataIndex18.getCompound("ForgeData").putDouble("skill", 1520);
										entity.load(dataIndex18);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
													(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
															? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
															: 0) + 1),
													false, false));
										CompoundTag dataIndex20 = new CompoundTag();
										entity.saveWithoutId(dataIndex20);
										dataIndex20.getCompound("ForgeData").putDouble("PRESS_Z", 1);
										entity.load(dataIndex20);
									} else if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:jogo")) {
										CompoundTag dataIndex22 = new CompoundTag();
										entity.saveWithoutId(dataIndex22);
										dataIndex22.getCompound("ForgeData").putDouble("skill", 420);
										entity.load(dataIndex22);
										if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
											_entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 1000,
													(int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
															? _livEnt.getEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier()
															: 0) + 1),
													false, false));
										CompoundTag dataIndex24 = new CompoundTag();
										entity.saveWithoutId(dataIndex24);
										dataIndex24.getCompound("ForgeData").putDouble("PRESS_Z", 1);
										entity.load(dataIndex24);
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
