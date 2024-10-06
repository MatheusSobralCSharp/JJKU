package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class MeiMeiAxeProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 11) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
				if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mei_mei_axe")) {
					{
						final Vec3 _center = new Vec3(x, y, z);
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (!(entityiterator instanceof UiUiEntity)) {
									if (!world.getEntitiesOfClass(UiUiEntity.class, AABB.ofSize(new Vec3(x, y, z), 40, 40, 40), e -> true).isEmpty() == false) {
										if (world instanceof ServerLevel _serverLevel) {
											Entity entitytospawn = JujutsucraftaddonModEntities.UI_UI.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
											if (entitytospawn != null) {
												entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
											}
											CompoundTag dataIndex8 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex8);
											dataIndex8.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
											(entitytospawn).load(dataIndex8);
											CompoundTag dataIndex11 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex11);
											dataIndex11.putString("Owner", (entity.getStringUUID()));
											(entitytospawn).load(dataIndex11);
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR)
													.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
													.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
													.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
													.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 10));
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
													.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
											((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
											if ((entitytospawn) instanceof LivingEntity _entity)
												_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
											if ((entitytospawn) instanceof LivingEntity _entity) {
												ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
												_setstack.setCount(1);
												_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
												if (_entity instanceof Player _player)
													_player.getInventory().setChanged();
											}
											{
												Entity _entity = (entitytospawn);
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(0, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.FEET, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
												}
											}
											{
												Entity _entity = (entitytospawn);
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(1, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.LEGS, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
												}
											}
											{
												Entity _entity = (entitytospawn);
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(2, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.CHEST, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
												}
											}
											{
												Entity _entity = (entitytospawn);
												if (_entity instanceof Player _player) {
													_player.getInventory().armor.set(3, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
													_player.getInventory().setChanged();
												} else if (_entity instanceof LivingEntity _living) {
													_living.setItemSlot(EquipmentSlot.HEAD, (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
												}
											}
											CompoundTag dataIndex50 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex50);
											dataIndex50.getCompound("ForgeData").putDouble("friend_num", (new Object() {
												public double getValue() {
													CompoundTag dataIndex49 = new CompoundTag();
													entity.saveWithoutId(dataIndex49);
													return dataIndex49.getCompound("ForgeData").getDouble("friend_num");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex50);
											CompoundTag dataIndex53 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex53);
											dataIndex53.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
												public double getValue() {
													CompoundTag dataIndex52 = new CompoundTag();
													entity.saveWithoutId(dataIndex52);
													return dataIndex52.getCompound("ForgeData").getDouble("friend_num");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex53);
											CompoundTag dataIndex55 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex55);
											dataIndex55.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
											(entitytospawn).load(dataIndex55);
											CompoundTag dataIndex57 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex57);
											dataIndex57.getCompound("ForgeData").putBoolean("Player", true);
											(entitytospawn).load(dataIndex57);
											CompoundTag dataIndex59 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex59);
											dataIndex59.putBoolean("Player", true);
											(entitytospawn).load(dataIndex59);
											CompoundTag dataIndex62 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex62);
											dataIndex62.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
												public boolean getValue() {
													CompoundTag dataIndex61 = new CompoundTag();
													entity.saveWithoutId(dataIndex61);
													return dataIndex61.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex62);
											CompoundTag dataIndex65 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex65);
											dataIndex65.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
												public boolean getValue() {
													CompoundTag dataIndex64 = new CompoundTag();
													entity.saveWithoutId(dataIndex64);
													return dataIndex64.getCompound("ForgeData").getBoolean("CursedSpirit");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex65);
											CompoundTag dataIndex68 = new CompoundTag();
											(entitytospawn).saveWithoutId(dataIndex68);
											dataIndex68.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
												public boolean getValue() {
													CompoundTag dataIndex67 = new CompoundTag();
													entity.saveWithoutId(dataIndex67);
													return dataIndex67.getCompound("ForgeData").getBoolean("CurseUser");
												}
											}.getValue()));
											(entitytospawn).load(dataIndex68);
										}
									}
								} else if (entityiterator instanceof UiUiEntity) {
									if (entityiterator.getPersistentData().getDouble("UiUi") == 0) {
										CompoundTag dataIndex72 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex72);
										dataIndex72.getCompound("ForgeData").putDouble("UiUi", 1);
										entityiterator.load(dataIndex72);
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Ui Ui: Agressive"), false);
									} else if (entityiterator.getPersistentData().getDouble("UiUi") == 1) {
										CompoundTag dataIndex75 = new CompoundTag();
										entityiterator.saveWithoutId(dataIndex75);
										dataIndex75.getCompound("ForgeData").putDouble("UiUi", 0);
										entityiterator.load(dataIndex75);
										if (entity instanceof Player _player && !_player.level().isClientSide())
											_player.displayClientMessage(Component.literal("Ui Ui: Defensive"), false);
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
