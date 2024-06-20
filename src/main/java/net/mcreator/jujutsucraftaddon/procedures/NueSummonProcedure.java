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
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class NueSummonProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 2920 && new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					entity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("skill_domain");
				}
			}.getValue() == 0) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null && !animation.isActive()) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "hakaridomain"))));
						}
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 220 && new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("skill_domain");
				}
			}.getValue() == 0) {
				if (world.isClientSide()) {
					if (entity instanceof AbstractClientPlayer player) {
						var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
						if (animation != null && !animation.isActive()) {
							animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "infinitevoid"))));
						}
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					return dataIndex7.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 617) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..10] title {\"text\":\"Merged Beast Agito\",\"color\":\"dark_red\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 220 && new Object() {
				public double getValue() {
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					return dataIndex10.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Muryo Kusho.\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
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
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex14 = new CompoundTag();
					entity.saveWithoutId(dataIndex14);
					return dataIndex14.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 120 && new Object() {
				public double getValue() {
					CompoundTag dataIndex15 = new CompoundTag();
					entity.saveWithoutId(dataIndex15);
					return dataIndex15.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Fukuma Mizushi!\",\"color\":\"dark_red\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
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
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex19 = new CompoundTag();
					entity.saveWithoutId(dataIndex19);
					return dataIndex19.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 620 && new Object() {
				public double getValue() {
					CompoundTag dataIndex20 = new CompoundTag();
					entity.saveWithoutId(dataIndex20);
					return dataIndex20.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Kango Aneitei!\",\"color\":\"black\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
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
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex24 = new CompoundTag();
					entity.saveWithoutId(dataIndex24);
					return dataIndex24.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 1520 && new Object() {
				public double getValue() {
					CompoundTag dataIndex25 = new CompoundTag();
					entity.saveWithoutId(dataIndex25);
					return dataIndex25.getCompound("ForgeData").getDouble("cnt1");
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
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Jihei Endonka!\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex29 = new CompoundTag();
					entity.saveWithoutId(dataIndex29);
					return dataIndex29.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 820 && new Object() {
				public double getValue() {
					CompoundTag dataIndex30 = new CompoundTag();
					entity.saveWithoutId(dataIndex30);
					return dataIndex30.getCompound("ForgeData").getDouble("cnt1");
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
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Tauun Heisen\",\"color\":\"dark_purple\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex34 = new CompoundTag();
					entity.saveWithoutId(dataIndex34);
					return dataIndex34.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 618 && new Object() {
				public double getValue() {
					CompoundTag dataIndex35 = new CompoundTag();
					entity.saveWithoutId(dataIndex35);
					return dataIndex35.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = entity;
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
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex38 = new CompoundTag();
					entity.saveWithoutId(dataIndex38);
					return dataIndex38.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 710 && new Object() {
				public double getValue() {
					CompoundTag dataIndex39 = new CompoundTag();
					entity.saveWithoutId(dataIndex39);
					return dataIndex39.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Turn UP The Volume!\",\"color\":\"aqua\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands()
								.performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
												_ent.getDisplayName(), _ent.level().getServer(), _ent),
										"execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Because This Is A Funeral For The Living!!\",\"color\":\"light_purple\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex42 = new CompoundTag();
					entity.saveWithoutId(dataIndex42);
					return dataIndex42.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 420 && new Object() {
				public double getValue() {
					CompoundTag dataIndex43 = new CompoundTag();
					entity.saveWithoutId(dataIndex43);
					return dataIndex43.getCompound("ForgeData").getDouble("cnt1");
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
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Gaikan Tecchisen\",\"color\":\"gold\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"gold\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex47 = new CompoundTag();
					entity.saveWithoutId(dataIndex47);
					return dataIndex47.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 520 && new Object() {
				public double getValue() {
					CompoundTag dataIndex48 = new CompoundTag();
					entity.saveWithoutId(dataIndex48);
					return dataIndex48.getCompound("ForgeData").getDouble("cnt1");
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
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] subtitle {\"text\":\"Shingan Soai\",\"color\":\"white\",\"bold\":true}");
					}
				}
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s at @s run title @a[distance=..15] title {\"text\":\"Ryoiki Tenkai..\",\"color\":\"white\",\"bold\":true}");
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex52 = new CompoundTag();
					entity.saveWithoutId(dataIndex52);
					return dataIndex52.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 510 && new Object() {
				public double getValue() {
					CompoundTag dataIndex53 = new CompoundTag();
					entity.saveWithoutId(dataIndex53);
					return dataIndex53.getCompound("ForgeData").getDouble("cnt1");
				}
			}.getValue() == 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rikasummon")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rikasummon")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex55 = new CompoundTag();
					entity.saveWithoutId(dataIndex55);
					return dataIndex55.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 515 && new Object() {
				public double getValue() {
					CompoundTag dataIndex56 = new CompoundTag();
					entity.saveWithoutId(dataIndex56);
					return dataIndex56.getCompound("ForgeData").getDouble("cnt1");
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
