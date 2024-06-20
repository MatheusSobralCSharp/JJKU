package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SwordKusakabeTwoProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sword_kusakabe") && sourceentity instanceof ServerPlayer _plr2
				&& _plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki"))).isDone()) {
			if (!(new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("skill_domain");
				}
			}.getValue() > 0 || new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 0 || new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue() == new Object() {
				public double getValue() {
					CompoundTag dataIndex6 = new CompoundTag();
					entity.saveWithoutId(dataIndex6);
					return dataIndex6.getCompound("ForgeData").getDouble("friend_num");
				}
			}.getValue() || (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false))) {
				if (!(new Object() {
					public double getValue() {
						CompoundTag dataIndex8 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex8);
						return dataIndex8.getCompound("ForgeData").getDouble("CursedSpirit");
					}
				}.getValue() == new Object() {
					public double getValue() {
						CompoundTag dataIndex9 = new CompoundTag();
						entity.saveWithoutId(dataIndex9);
						return dataIndex9.getCompound("ForgeData").getDouble("CursedSpirit");
					}
				}.getValue() || new Object() {
					public double getValue() {
						CompoundTag dataIndex10 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex10);
						return dataIndex10.getCompound("ForgeData").getDouble("JujutsuSorcerer");
					}
				}.getValue() == new Object() {
					public double getValue() {
						CompoundTag dataIndex11 = new CompoundTag();
						entity.saveWithoutId(dataIndex11);
						return dataIndex11.getCompound("ForgeData").getDouble("JujutsuSorcerer");
					}
				}.getValue() || new Object() {
					public double getValue() {
						CompoundTag dataIndex12 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex12);
						return dataIndex12.getCompound("ForgeData").getDouble("CurseUser");
					}
				}.getValue() == new Object() {
					public double getValue() {
						CompoundTag dataIndex13 = new CompoundTag();
						entity.saveWithoutId(dataIndex13);
						return dataIndex13.getCompound("ForgeData").getDouble("CurseUser");
					}
				}.getValue())) {
					if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:sword_ogi") && sourceentity instanceof ServerPlayer _plr16
							&& _plr16.level() instanceof ServerLevel && _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki"))).isDone()) {
						CompoundTag dataIndex17 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex17);
						dataIndex17.getCompound("ForgeData").putDouble("PRESS_Z", 1);
						sourceentity.load(dataIndex17);
						CompoundTag dataIndex18 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex18);
						dataIndex18.getCompound("ForgeData").putDouble("skill", 202);
						sourceentity.load(dataIndex18);
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						{
							Entity _ent = sourceentity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10 255 true");
							}
						}
						if (sourceentity instanceof Player _player)
							_player.getCooldowns().addCooldown((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 300);
					}
				}
			}
		}
	}
}
