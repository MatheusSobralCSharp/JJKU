package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GojoExtensionBlueProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 201) {
				if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
					if (sourceentity instanceof ServerPlayer _plr2 && _plr2.level() instanceof ServerLevel
							&& _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_4"))).isDone()) {
						if (entity instanceof LivingEntity) {
							{
								Entity _ent = entity;
								_ent.teleportTo((entity.getX()), (entity.getY() + 5), (entity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 5), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
							{
								Entity _ent = sourceentity;
								_ent.teleportTo((entity.getX()), (entity.getY() + 1), (entity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((entity.getX()), (entity.getY() + 1), (entity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get(), 60, 1));
							if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_RAMPAGE.get(), 100, 1));
							for (int index0 = 0; index0 < 1; index0++) {
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~ ~ ~5 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~ ~ ~-5 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~5 ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~-5 ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~2 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~3 ~ ~2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~-3 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~-3 ~ ~2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~3 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
									}
								}
								{
									Entity _ent = entity;
									if (!_ent.level().isClientSide() && _ent.getServer() != null) {
										_ent.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
														_ent.getDisplayName(), _ent.level().getServer(), _ent),
												"execute as @s run summon jujutsucraft:blue ~-2 ~ ~-2 {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:0.75d,DomainAttack:0b,ExtinctionBlock:0b,NameRanged_ranged:0.5972934831260017d,Player:1b,Range:67.5d,free:1b,attack:0b,blue:1.0d,circle:1b,cnt1:29.0d,cnt2:1.0d,cnt6:5.0d,cnt_brokenBrain:0.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,flag_start:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:206.0d,swing:0b},\"pehkui:scale_data_types\":{\"pehkui:base\":{scale:5f,initial:5f,target:5f}},Attributes:[{Name:\"minecraft:generic.max_health\",Base:500},{Name:\"minecraft:generic.armor\",Base:20}],Health:500}");
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
