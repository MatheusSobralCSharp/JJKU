package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;

import java.util.List;
import java.util.Comparator;

public class SwordJinWooRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(200 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((new Object() {
						public String getValue() {
							CompoundTag dataIndex1 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex1);
							return dataIndex1.getCompound("ForgeData").getString("OWNER_UUID");
						}
					}.getValue()).equals(entity.getStringUUID())) {
						if (entityiterator instanceof IgrisEntity) {
							((IgrisEntity) entityiterator).setAnimation("kneel");
						}
						if (entityiterator instanceof Shadow1Entity) {
							((Shadow1Entity) entityiterator).setAnimation("kneel");
						}
					}
				}
			}
		} else {
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftaddonModEntities.IGRIS.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
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
				(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 20));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				{
					Entity _entity = (entitytospawn);
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
					}
				}
				CompoundTag dataIndex41 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex41);
				dataIndex41.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex40 = new CompoundTag();
						entity.saveWithoutId(dataIndex40);
						return dataIndex40.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex41);
				CompoundTag dataIndex44 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex44);
				dataIndex44.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex43 = new CompoundTag();
						entity.saveWithoutId(dataIndex43);
						return dataIndex43.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex44);
				CompoundTag dataIndex46 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex46);
				dataIndex46.getCompound("ForgeData").putDouble("IsMahoraga", 1);
				(entitytospawn).load(dataIndex46);
				CompoundTag dataIndex48 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex48);
				dataIndex48.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
				(entitytospawn).load(dataIndex48);
				CompoundTag dataIndex50 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex50);
				dataIndex50.getCompound("ForgeData").putBoolean("Player", true);
				(entitytospawn).load(dataIndex50);
				CompoundTag dataIndex53 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex53);
				dataIndex53.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex52 = new CompoundTag();
						entity.saveWithoutId(dataIndex52);
						return dataIndex52.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex53);
				CompoundTag dataIndex56 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex56);
				dataIndex56.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex55 = new CompoundTag();
						entity.saveWithoutId(dataIndex55);
						return dataIndex55.getCompound("ForgeData").getBoolean("CursedSpirit");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex56);
				CompoundTag dataIndex59 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex59);
				dataIndex59.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex58 = new CompoundTag();
						entity.saveWithoutId(dataIndex58);
						return dataIndex58.getCompound("ForgeData").getBoolean("CurseUser");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex59);
			}
			if (world instanceof ServerLevel _serverLevel) {
				Entity entitytospawn = JujutsucraftaddonModEntities.SHADOW_1.get().spawn(_serverLevel, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entitytospawn != null) {
					entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
				}
				CompoundTag dataIndex63 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex63);
				dataIndex63.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
				(entitytospawn).load(dataIndex63);
				CompoundTag dataIndex66 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex66);
				dataIndex66.putString("Owner", (entity.getStringUUID()));
				(entitytospawn).load(dataIndex66);
				(entitytospawn).setCustomName(Component.literal((entity.getDisplayName().getString())));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_KNOCKBACK).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
						.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 20));
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE)
						.setBaseValue(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.KNOCKBACK_RESISTANCE).getBaseValue());
				((LivingEntity) (entitytospawn)).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.FOLLOW_RANGE).setBaseValue(256);
				if ((entitytospawn) instanceof LivingEntity _entity)
					_entity.setHealth((entitytospawn) instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
				{
					Entity _entity = (entitytospawn);
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("jujutsucraft:mahoraga_wheel_helmet"))));
					}
				}
				CompoundTag dataIndex95 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex95);
				dataIndex95.getCompound("ForgeData").putDouble("IsMahoraga", 1);
				(entitytospawn).load(dataIndex95);
				CompoundTag dataIndex98 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex98);
				dataIndex98.getCompound("ForgeData").putDouble("friend_num", (new Object() {
					public double getValue() {
						CompoundTag dataIndex97 = new CompoundTag();
						entity.saveWithoutId(dataIndex97);
						return dataIndex97.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex98);
				CompoundTag dataIndex101 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex101);
				dataIndex101.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
					public double getValue() {
						CompoundTag dataIndex100 = new CompoundTag();
						entity.saveWithoutId(dataIndex100);
						return dataIndex100.getCompound("ForgeData").getDouble("friend_num");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex101);
				CompoundTag dataIndex103 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex103);
				dataIndex103.getCompound("ForgeData").putBoolean("UseCursedTechnique", true);
				(entitytospawn).load(dataIndex103);
				CompoundTag dataIndex105 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex105);
				dataIndex105.getCompound("ForgeData").putBoolean("Player", true);
				(entitytospawn).load(dataIndex105);
				CompoundTag dataIndex108 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex108);
				dataIndex108.getCompound("ForgeData").putBoolean("JujutsuSorcerer", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex107 = new CompoundTag();
						entity.saveWithoutId(dataIndex107);
						return dataIndex107.getCompound("ForgeData").getBoolean("JujutsuSorcerer");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex108);
				CompoundTag dataIndex111 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex111);
				dataIndex111.getCompound("ForgeData").putBoolean("CursedSpirit", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex110 = new CompoundTag();
						entity.saveWithoutId(dataIndex110);
						return dataIndex110.getCompound("ForgeData").getBoolean("CursedSpirit");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex111);
				CompoundTag dataIndex114 = new CompoundTag();
				(entitytospawn).saveWithoutId(dataIndex114);
				dataIndex114.getCompound("ForgeData").putBoolean("CurseUser", (new Object() {
					public boolean getValue() {
						CompoundTag dataIndex113 = new CompoundTag();
						entity.saveWithoutId(dataIndex113);
						return dataIndex113.getCompound("ForgeData").getBoolean("CurseUser");
					}
				}.getValue()));
				(entitytospawn).load(dataIndex114);
			}
			if (new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SURVIVAL;
					}
					return false;
				}
			}.checkGamemode(entity)) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 300);
			}
		}
	}
}
