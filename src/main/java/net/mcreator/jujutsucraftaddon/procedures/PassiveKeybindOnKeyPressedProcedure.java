package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Comparator;

public class PassiveKeybindOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (entity.isShiftKeyDown()) {
				if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					dataIndex3.getCompound("ForgeData").putDouble("skill", 205);
					entity.load(dataIndex3);
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					dataIndex4.getCompound("ForgeData").putDouble("PRESS_Z", 1);
					entity.load(dataIndex4);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
			if (entity.isShiftKeyDown()) {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putDouble("skill", 604);
				entity.load(dataIndex8);
				CompoundTag dataIndex9 = new CompoundTag();
				entity.saveWithoutId(dataIndex9);
				dataIndex9.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex9);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
					}
				}
			} else {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if ((new Object() {
							public String getValue() {
								CompoundTag dataIndex11 = new CompoundTag();
								entityiterator.saveWithoutId(dataIndex11);
								return dataIndex11.getCompound("ForgeData").getString("OWNER_UUID");
							}
						}.getValue()).equals(entity.getStringUUID())) {
							if (entityiterator.getPersistentData().getDouble("NoAttac1") == 0) {
								entityiterator.getPersistentData().putDouble("NoAttac1", 1);
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.AI.get(), -1, 1, false, false));
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Disabled Shikigami Attack"), false);
							} else if (entityiterator.getPersistentData().getDouble("NoAttac1") == 1) {
								entityiterator.getPersistentData().putDouble("NoAttac1", 0);
								if (entityiterator instanceof LivingEntity _entity)
									_entity.removeEffect(JujutsucraftaddonModMobEffects.AI.get());
								if (entity instanceof Player _player && !_player.level().isClientSide())
									_player.displayClientMessage(Component.literal("Enabled Shikigami Attack"), false);
							}
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
			CompoundTag dataIndex23 = new CompoundTag();
			entity.saveWithoutId(dataIndex23);
			dataIndex23.getCompound("ForgeData").putDouble("skill", 1006);
			entity.load(dataIndex23);
			CompoundTag dataIndex25 = new CompoundTag();
			entity.saveWithoutId(dataIndex25);
			dataIndex25.getCompound("ForgeData").putDouble("cnt5", (new Object() {
				public double getValue() {
					CompoundTag dataIndex24 = new CompoundTag();
					entity.saveWithoutId(dataIndex24);
					return dataIndex24.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() + 1));
			entity.load(dataIndex25);
			CompoundTag dataIndex27 = new CompoundTag();
			entity.saveWithoutId(dataIndex27);
			dataIndex27.getCompound("ForgeData").putDouble("cnt1", (new Object() {
				public double getValue() {
					CompoundTag dataIndex26 = new CompoundTag();
					entity.saveWithoutId(dataIndex26);
					return dataIndex26.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() + 1));
			entity.load(dataIndex27);
			CompoundTag dataIndex28 = new CompoundTag();
			entity.saveWithoutId(dataIndex28);
			dataIndex28.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex28);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18) {
			CompoundTag dataIndex31 = new CompoundTag();
			entity.saveWithoutId(dataIndex31);
			dataIndex31.getCompound("ForgeData").putDouble("skill", 1810);
			entity.load(dataIndex31);
			CompoundTag dataIndex32 = new CompoundTag();
			entity.saveWithoutId(dataIndex32);
			dataIndex32.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex32);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 29) {
			CompoundTag dataIndex35 = new CompoundTag();
			entity.saveWithoutId(dataIndex35);
			dataIndex35.getCompound("ForgeData").putDouble("skill", 2905);
			entity.load(dataIndex35);
			CompoundTag dataIndex36 = new CompoundTag();
			entity.saveWithoutId(dataIndex36);
			dataIndex36.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex36);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
			CompoundTag dataIndex39 = new CompoundTag();
			entity.saveWithoutId(dataIndex39);
			dataIndex39.getCompound("ForgeData").putDouble("skill", 2005);
			entity.load(dataIndex39);
			CompoundTag dataIndex40 = new CompoundTag();
			entity.saveWithoutId(dataIndex40);
			dataIndex40.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex40);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19) {
			CompoundTag dataIndex43 = new CompoundTag();
			entity.saveWithoutId(dataIndex43);
			dataIndex43.getCompound("ForgeData").putDouble("skill", 1905);
			entity.load(dataIndex43);
			CompoundTag dataIndex45 = new CompoundTag();
			entity.saveWithoutId(dataIndex45);
			dataIndex45.getCompound("ForgeData").putDouble("cnt5", (new Object() {
				public double getValue() {
					CompoundTag dataIndex44 = new CompoundTag();
					entity.saveWithoutId(dataIndex44);
					return dataIndex44.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() + 1));
			entity.load(dataIndex45);
			CompoundTag dataIndex47 = new CompoundTag();
			entity.saveWithoutId(dataIndex47);
			dataIndex47.getCompound("ForgeData").putDouble("cnt1", (new Object() {
				public double getValue() {
					CompoundTag dataIndex46 = new CompoundTag();
					entity.saveWithoutId(dataIndex46);
					return dataIndex46.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() + 1));
			entity.load(dataIndex47);
			CompoundTag dataIndex48 = new CompoundTag();
			entity.saveWithoutId(dataIndex48);
			dataIndex48.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex48);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 10000 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 13) {
			CompoundTag dataIndex51 = new CompoundTag();
			entity.saveWithoutId(dataIndex51);
			dataIndex51.getCompound("ForgeData").putDouble("skill", 1305);
			entity.load(dataIndex51);
			CompoundTag dataIndex52 = new CompoundTag();
			entity.saveWithoutId(dataIndex52);
			dataIndex52.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex52);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 9) {
			CompoundTag dataIndex55 = new CompoundTag();
			entity.saveWithoutId(dataIndex55);
			dataIndex55.getCompound("ForgeData").putDouble("skill", 910);
			entity.load(dataIndex55);
			CompoundTag dataIndex56 = new CompoundTag();
			entity.saveWithoutId(dataIndex56);
			dataIndex56.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex56);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
			CompoundTag dataIndex59 = new CompoundTag();
			entity.saveWithoutId(dataIndex59);
			dataIndex59.getCompound("ForgeData").putDouble("skill", 3005);
			entity.load(dataIndex59);
			CompoundTag dataIndex60 = new CompoundTag();
			entity.saveWithoutId(dataIndex60);
			dataIndex60.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex60);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
			CompoundTag dataIndex63 = new CompoundTag();
			entity.saveWithoutId(dataIndex63);
			dataIndex63.getCompound("ForgeData").putDouble("skill", 2705);
			entity.load(dataIndex63);
			CompoundTag dataIndex64 = new CompoundTag();
			entity.saveWithoutId(dataIndex64);
			dataIndex64.getCompound("ForgeData").putDouble("PRESS_Z", 1);
			entity.load(dataIndex64);
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
				}
			}
		} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
			if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == false) {
				CompoundTag dataIndex67 = new CompoundTag();
				entity.saveWithoutId(dataIndex67);
				dataIndex67.getCompound("ForgeData").putDouble("skill", 705);
				entity.load(dataIndex67);
				CompoundTag dataIndex68 = new CompoundTag();
				entity.saveWithoutId(dataIndex68);
				dataIndex68.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				entity.load(dataIndex68);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique 1 1 true");
					}
				}
			}
		}
	}
}
