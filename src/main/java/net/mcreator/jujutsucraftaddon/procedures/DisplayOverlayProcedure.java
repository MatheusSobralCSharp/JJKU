package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class DisplayOverlayProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double raytrace_distance = 0;
		String found_entity_name = "";
		boolean entity_found = false;
		if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
				{
					final Vec3 _center = new Vec3(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())), 4,
								4, 4), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ())))
								.findFirst().orElse(null)) instanceof LivingEntity) {
							if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
									4, 4, 4), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos()
													.getZ())))
									.findFirst().orElse(null)) == entity)) {
								if ((((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												4, 4, 4),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 0) {
									{
										String _setval = "Power: "
												+ (((Entity) world
														.getEntitiesOfClass(LivingEntity.class, AABB
																.ofSize(new Vec3(
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getX()),
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getY()),
																		(entity.level().clip(
																				new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																				.getBlockPos().getZ())),
																		4, 4, 4),
																e -> true)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)) instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0);
										entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.DataSixEyesOne = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												4, 4, 4),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof Player
										|| ((Entity) world.getEntitiesOfClass(LivingEntity.class,
												AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4),
												e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null)) instanceof ServerPlayer)) {
									if (new Object() {
										public double getValue() {
											CompoundTag dataIndex41 = new CompoundTag();
											((Entity) world
													.getEntitiesOfClass(LivingEntity.class,
															AABB.ofSize(
																	new Vec3(
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getX()),
																			(entity.level()
																					.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE,
																							entity))
																					.getBlockPos().getY()),
																			(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL,
																					ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())),
																	4, 4, 4),
															e -> true)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null)).saveWithoutId(dataIndex41);
											return dataIndex41.getCompound("ForgeData").getDouble("skill");
										}
									}.getValue() > 10) {
										if (new Object() {
											public double getValue() {
												CompoundTag dataIndex46 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex46);
												return dataIndex46.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1600, 1607)) {
											{
												String _setval = "Technique: " + "Mahorga CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex52 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex52);
												return dataIndex52.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 200, 220)) {
											{
												String _setval = "Technique: " + "Gojo CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex58 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex58);
												return dataIndex58.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2100, 2102)) {
											{
												String _setval = "Technique: " + "Itadori CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex64 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex64);
												return dataIndex64.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 600, 620)) {
											{
												String _setval = "Technique: " + "Fushiguro CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex70 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex70);
												return dataIndex70.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 300, 320)) {
											{
												String _setval = "Technique: " + "Inumaki CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex76 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex76);
												return dataIndex76.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), -100, -96)) {
											{
												String _setval = "Technique: " + "Maki CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex82 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex82);
												return dataIndex82.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 500, 520)) {
											{
												String _setval = "Technique: " + "Okkotsu CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex88 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex88);
												return dataIndex88.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2900, 2920)) {
											{
												String _setval = "Technique: " + "Hakari CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex94 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex94);
												return dataIndex94.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2000, 2020)) {
											{
												String _setval = "Technique: " + "Todo CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex100 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex100);
												return dataIndex100.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1900, 1920)) {
											{
												String _setval = "Technique: " + "Naoya CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex106 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex106);
												return dataIndex106.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2200, 2220)) {
											{
												String _setval = "Technique: " + "Jinichi CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex112 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex112);
												return dataIndex112.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2600, 2620)) {
											{
												String _setval = "Technique: " + "Ogi CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex118 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex118);
												return dataIndex118.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1300, 1320)) {
											{
												String _setval = "Technique: " + "Nanami CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex124 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex124);
												return dataIndex124.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1100, 1120)) {
											{
												String _setval = "Technique: " + "Meimei CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex130 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex130);
												return dataIndex130.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 900, 920)) {
											{
												String _setval = "Technique: " + "Tsukumo CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex136 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex136);
												return dataIndex136.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1800, 1820)) {
											{
												String _setval = "Technique: " + "Geto CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex142 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex142);
												return dataIndex142.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 3100, 3105)) {
											{
												String _setval = "Technique: " + "Kusakabe CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex148 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex148);
												return dataIndex148.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2700, 2720)) {
											{
												String _setval = "Technique: " + "Higuruma CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex154 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex154);
												return dataIndex154.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1200, 1220)) {
											{
												String _setval = "Technique: " + "Ishigori CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex160 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex160);
												return dataIndex160.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 700, 715)) {
											{
												String _setval = "Technique: " + "Kashimo CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex166 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex166);
												return dataIndex166.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1700, 1715)) {
											{
												String _setval = "Technique: " + "Takaba CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex172 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex172);
												return dataIndex172.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2800, 2820)) {
											{
												String _setval = "Technique: " + "Angel CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex178 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex178);
												return dataIndex178.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 3000, 3005)) {
											{
												String _setval = "Technique: " + "Miguel CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex184 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex184);
												return dataIndex184.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 100, 120)) {
											{
												String _setval = "Technique: " + "Sukuna CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex190 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex190);
												return dataIndex190.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2400, 2420)) {
											{
												String _setval = "Technique: " + "Uraume CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex196 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex196);
												return dataIndex196.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 800, 820)) {
											{
												String _setval = "Technique: " + "Dagon CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex202 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex202);
												return dataIndex202.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1400, 1420)) {
											{
												String _setval = "Technique: " + "Hanami CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex208 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex208);
												return dataIndex208.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1500, 1520)) {
											{
												String _setval = "Technique: " + "Mahito CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex214 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex214);
												return dataIndex214.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 400, 420)) {
											{
												String _setval = "Technique: " + "Jogo CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex220 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex220);
												return dataIndex220.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 1000, 1020)) {
											{
												String _setval = "Technique: " + "Choso CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										} else if (new Object() {
											public double getValue() {
												CompoundTag dataIndex226 = new CompoundTag();
												((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).saveWithoutId(dataIndex226);
												return dataIndex226.getCompound("ForgeData").getDouble("skill");
											}
										}.getValue() == Mth.nextInt(RandomSource.create(), 2300, 2320)) {
											{
												String _setval = "Technique: " + "Kurourushi CT";
												entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
													capability.Technique = _setval;
													capability.syncPlayerVariables(entity);
												});
											}
										}
									}
								} else if (((Entity) world.getEntitiesOfClass(LivingEntity.class,
										AABB.ofSize(new Vec3(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())),
												4, 4, 4),
										e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof Player
										|| ((Entity) world.getEntitiesOfClass(LivingEntity.class,
												AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4),
												e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null)) instanceof ServerPlayer) {
									{
										String _setval = (((Entity) world
												.getEntitiesOfClass(LivingEntity.class,
														AABB.ofSize(
																new Vec3(
																		(entity.level()
																				.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE,
																						entity))
																				.getBlockPos().getX()),
																		(entity.level()
																				.clip(new ClipContext(
																						entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																				.getBlockPos().getY()),
																		(entity.level().clip(
																				new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																				.getBlockPos().getZ())),
																4, 4, 4),
														e -> true)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null)).getDisplayName().getString() + " Technique: ")
												+ ""
												+ (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())),
														4, 4, 4), e -> true).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
															}
														}.compareDistOf(
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getX()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getY()),
																(entity.level()
																		.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(20)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity))
																		.getBlockPos().getZ())))
														.findFirst().orElse(null)).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
										entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Technique = _setval;
											capability.syncPlayerVariables(entity);
										});
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
