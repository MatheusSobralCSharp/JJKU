package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class BuffProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof Monster && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 100) {
			if (!(new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					entity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1)) {
				CompoundTag dataIndex3 = new CompoundTag();
				entity.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("CursedSpirit", 1);
				entity.load(dataIndex3);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("CursedSpirit");
			}
		}.getValue() == 1 && (new Object() {
			public String getValue() {
				CompoundTag dataIndex5 = new CompoundTag();
				entity.saveWithoutId(dataIndex5);
				return dataIndex5.getCompound("ForgeData").getString("OWNER_UUID");
			}
		}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
			public boolean getValue() {
				CompoundTag dataIndex7 = new CompoundTag();
				entity.saveWithoutId(dataIndex7);
				return dataIndex7.getCompound("ForgeData").getBoolean("Buffed");
			}
		}.getValue()) == false) {
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:height 0.5 " + entity.getStringUUID());
			}
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:width 0.5 " + entity.getStringUUID());
			}
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
					.setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2.5));
			{
				Entity _ent = sourceentity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -500 @s");
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			CompoundTag dataIndex15 = new CompoundTag();
			entity.saveWithoutId(dataIndex15);
			dataIndex15.getCompound("ForgeData").putBoolean("Buffed", true);
			entity.load(dataIndex15);
		}
	}
}
