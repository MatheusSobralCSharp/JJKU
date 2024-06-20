package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class WorldSlashQuestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
			}
		}.getValue() == -2) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
				}
			}.getValue() == -2) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											"execute if predicate jujutsucraftaddon:effects/orca/fingers/f20 as @s run advancement grant @s only jujutsucraftaddon:world_slash_advancement");
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BINDING_VOW.get(), 200, 4, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.WORLD_SLASH_EFFECT.get(), 200, 4, false, false));
					CompoundTag dataIndex6 = new CompoundTag();
					entity.saveWithoutId(dataIndex6);
					dataIndex6.getCompound("ForgeData").putBoolean("PRESS_Z", true);
					entity.load(dataIndex6);
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:cursed_technique");
						}
					}
					CompoundTag dataIndex8 = new CompoundTag();
					entity.saveWithoutId(dataIndex8);
					dataIndex8.getCompound("ForgeData").putDouble("skill", 105);
					entity.load(dataIndex8);
				}
			}
		}
	}
}
