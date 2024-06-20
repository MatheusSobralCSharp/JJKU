package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Buff2Procedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && (new Object() {
			public String getValue() {
				CompoundTag dataIndex1 = new CompoundTag();
				entity.saveWithoutId(dataIndex1);
				return dataIndex1.getCompound("ForgeData").getString("OWNER_UUID");
			}
		}.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
			public boolean getValue() {
				CompoundTag dataIndex3 = new CompoundTag();
				entity.saveWithoutId(dataIndex3);
				return dataIndex3.getCompound("ForgeData").getBoolean("Buffed");
			}
		}.getValue()) == false) {
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:height 0.25 " + entity.getStringUUID());
			}
			if (world instanceof ServerLevel _level) {
				System.out.println(entity.getStringUUID());
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(0, 0, 0), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"scale add pehkui:width 0.25 " + entity.getStringUUID());
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
			CompoundTag dataIndex11 = new CompoundTag();
			entity.saveWithoutId(dataIndex11);
			dataIndex11.getCompound("ForgeData").putBoolean("Buffed", true);
			entity.load(dataIndex11);
		}
	}
}
