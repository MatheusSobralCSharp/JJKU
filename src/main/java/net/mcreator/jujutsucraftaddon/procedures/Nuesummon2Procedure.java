package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class Nuesummon2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 617) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..10] title {\"text\":\"Merged Beast Agito\",\"color\":\"dark_red\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 220 && new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Muryo Kusho.\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:muryokusho")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:muryokusho")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex8 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex8);
					return dataIndex8.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 120 && new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Fukuma Mizushi!\",\"color\":\"dark_red\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"dark_red\",\"bold\":true}");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:fukumamizushi")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:fukumamizushi")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex13 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex13);
					return dataIndex13.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 620 && new Object() {
				public double getValue() {
					CompoundTag dataIndex14 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex14);
					return dataIndex14.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Kango Aneitei!\",\"color\":\"black\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"black\",\"bold\":true}");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kango")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:kango")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex18 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex18);
					return dataIndex18.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 1520 && new Object() {
				public double getValue() {
					CompoundTag dataIndex19 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex19);
					return dataIndex19.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:jihei")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:jihei")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Jihei Endonka!\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex23 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex23);
					return dataIndex23.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 820 && new Object() {
				public double getValue() {
					CompoundTag dataIndex24 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex24);
					return dataIndex24.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:taun")), SoundSource.NEUTRAL, 2, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:taun")), SoundSource.NEUTRAL, 2, 1, false);
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Tauun Heisen\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex28 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex28);
					return dataIndex28.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 618 && new Object() {
				public double getValue() {
					CompoundTag dataIndex29 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex29);
					return dataIndex29.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent),
								"execute as @s at @s run title @a[distance=..15] title {\"text\":\"With this treasure, I summon...\",\"color\":\"white\",\"bold\":true}");
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:furubeyurayura")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:furubeyurayura")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex32 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex32);
					return dataIndex32.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 710 && new Object() {
				public double getValue() {
					CompoundTag dataIndex33 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex33);
					return dataIndex33.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Turn UP The Volume!\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Because This Is A Funeral For The Living!!\",\"color\":\"light_purple\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex36 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex36);
					return dataIndex36.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 420 && new Object() {
				public double getValue() {
					CompoundTag dataIndex37 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex37);
					return dataIndex37.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gak")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gak")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Gaikan Tecchisen\",\"color\":\"gold\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"gold\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex41 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex41);
					return dataIndex41.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 520 && new Object() {
				public double getValue() {
					CompoundTag dataIndex42 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex42);
					return dataIndex42.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:okkotsudomainvc")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:okkotsudomainvc")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Shingan Soai\",\"color\":\"white\",\"bold\":true}");
					}
				}
				{
					Entity _ent = sourceentity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"white\",\"bold\":true}");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex46 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex46);
					return dataIndex46.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 510 && new Object() {
				public double getValue() {
					CompoundTag dataIndex47 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex47);
					return dataIndex47.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rikasummon")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rikasummon")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex49 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex49);
					return dataIndex49.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 515 && new Object() {
				public double getValue() {
					CompoundTag dataIndex50 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex50);
					return dataIndex50.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purelove")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purelove")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
