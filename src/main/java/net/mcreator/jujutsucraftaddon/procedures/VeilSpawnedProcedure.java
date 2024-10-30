package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModBlocks;
import net.mcreator.jujutsucraftaddon.entity.AntiVeilEntity;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class VeilSpawnedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		String oldblock = "";
		Direction direction = Direction.NORTH;
		double X = 0;
		double Y = 0;
		double Z = 0;
		boolean Pass = false;
		if (!world.getEntitiesOfClass(AntiVeilEntity.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).isEmpty() == false) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.VEIL_TALISMAN.get()) {
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getBoolean("VeilEnabled");
					}
				}.getValue()) != true) {
					X = entity.getX();
					Y = entity.getY();
					Z = entity.getZ();
					int horizontalRadiusSphere = (int) Math.round(DoubleArgumentType.getDouble(arguments, "VeilSize")) - 1;
					int verticalRadiusSphere = (int) Math.round(DoubleArgumentType.getDouble(arguments, "VeilSize")) - 1;
					int yIterationsSphere = verticalRadiusSphere;
					for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
						for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
							for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
								double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
										+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
								if (distanceSq <= 1.0) {
									if (Math.sqrt(Math.pow(X - x + xi, 2) + Math.pow(Y - y + i, 2) + Math.pow(Z - z + zi, 2)) >= DoubleArgumentType.getDouble(arguments, "VeilSize") - 3) {
										if (world instanceof ServerLevel _origLevel) {
											LevelAccessor _worldorig = world;
											world = _origLevel.getServer().getLevel(Level.OVERWORLD);
											if (world != null) {
												oldblock = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()).toString();
												direction = new Object() {
													public Direction getDirection(BlockState _bs) {
														Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
														if (_prop instanceof DirectionProperty _dp)
															return _bs.getValue(_dp);
														_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
														return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
																? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
																: Direction.NORTH;
													}
												}.getDirection((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))));
												{
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockState _bs = JujutsucraftaddonModBlocks.VEIL_BLOCK.get().defaultBlockState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
														if (_property != null && _bs.getValue(_property) != null)
															try {
																_bs = _bs.setValue(_property, (Comparable) entry.getValue());
															} catch (Exception e) {
															}
													}
													BlockEntity _be = world.getBlockEntity(_bp);
													CompoundTag _bnbt = null;
													if (_be != null) {
														_bnbt = _be.saveWithFullMetadata();
														_be.setRemoved();
													}
													world.setBlock(_bp, _bs, 3);
													if (_bnbt != null) {
														_be = world.getBlockEntity(_bp);
														if (_be != null) {
															try {
																_be.load(_bnbt);
															} catch (Exception ignored) {
															}
														}
													}
												}
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null)
														_blockEntity.getPersistentData().putString("direction", ("" + direction));
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null)
														_blockEntity.getPersistentData().putString("oldblock", oldblock);
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (!world.isClientSide()) {
													BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
													BlockEntity _blockEntity = world.getBlockEntity(_bp);
													BlockState _bs = world.getBlockState(_bp);
													if (_blockEntity != null)
														_blockEntity.getPersistentData().putString("ownerUUID", (entity.getStringUUID()));
													if (world instanceof Level _level)
														_level.sendBlockUpdated(_bp, _bs, _bs, 3);
												}
												if (BoolArgumentType.getBool(arguments, "LetPeoplePass") == true) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putBoolean("pass", true);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
												} else if (BoolArgumentType.getBool(arguments, "LetPeoplePass") == false) {
													if (!world.isClientSide()) {
														BlockPos _bp = BlockPos.containing(x + xi, y + i, z + zi);
														BlockEntity _blockEntity = world.getBlockEntity(_bp);
														BlockState _bs = world.getBlockState(_bp);
														if (_blockEntity != null)
															_blockEntity.getPersistentData().putBoolean("pass", false);
														if (world instanceof Level _level)
															_level.sendBlockUpdated(_bp, _bs, _bs, 3);
													}
												}
											}
											world = _worldorig;
										}
									}
								}
							}
						}
					}
					if (world instanceof ServerLevel _origLevel) {
						LevelAccessor _worldorig = world;
						world = _origLevel.getServer().getLevel(entity.level().dimension());
						if (world != null) {
							if (world instanceof ServerLevel _level) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity entitytospawn = JujutsucraftaddonModEntities.VEIL.get().spawn(_serverLevel, BlockPos.containing(X, Y, Z), MobSpawnType.MOB_SUMMONED);
									if (entitytospawn != null) {
										entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
									}
									(entitytospawn).getPersistentData().putDouble("TemporaryVeilsSize", Math.round(DoubleArgumentType.getDouble(arguments, "VeilSize")));
									(entitytospawn).getPersistentData().putDouble("TemporaryVeilsTimer", (DoubleArgumentType.getDouble(arguments, "VeilDurationInMinutes") * 60 * 20));
									{
										CompoundTag dataIndex = new CompoundTag();
										(entitytospawn).saveWithoutId(dataIndex);
										dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
										(entitytospawn).load(dataIndex);
									}
									{
										CompoundTag dataIndex = new CompoundTag();
										entity.saveWithoutId(dataIndex);
										dataIndex.getCompound("ForgeData").putString("VeilUUID", ((entitytospawn).getStringUUID()));
										entity.load(dataIndex);
									}
									{
										CompoundTag dataIndex = new CompoundTag();
										entity.saveWithoutId(dataIndex);
										dataIndex.getCompound("ForgeData").putBoolean("VeilEnabled", true);
										entity.load(dataIndex);
									}
								}
							}
						}
						world = _worldorig;
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Veil Creating...."), false);
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.VEIL_TALISMAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You Already Have a Veil ( Respawn or Reset for Make Another )"), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You Can't Create a Veil, get one Talisman"), false);
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("There is a Anti-Veil Talisman Closer.."), false);
		}
	}
}
