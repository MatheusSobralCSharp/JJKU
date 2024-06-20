package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class DomainBreakOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 105) {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				dataIndex2.getCompound("ForgeData").putDouble("skill", 1);
				entity.load(dataIndex2);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cursed_technique");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex4 = new CompoundTag();
					entity.saveWithoutId(dataIndex4);
					return dataIndex4.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 215) {
				CompoundTag dataIndex5 = new CompoundTag();
				entity.saveWithoutId(dataIndex5);
				dataIndex5.getCompound("ForgeData").putDouble("skill", 1);
				entity.load(dataIndex5);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cursed_technique");
					}
				}
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					return dataIndex7.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 405) {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putDouble("skill", 1);
				entity.load(dataIndex8);
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect clear @s jujutsucraft:cursed_technique");
					}
				}
			}
		} else if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex11 = new CompoundTag();
					entity.saveWithoutId(dataIndex11);
					return dataIndex11.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() == 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(JujutsucraftaddonModMobEffects.DOMAIN_BREAK.get());
			}
		}
	}
}
