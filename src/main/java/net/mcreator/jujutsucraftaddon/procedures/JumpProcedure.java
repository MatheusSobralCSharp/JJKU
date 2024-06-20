package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JumpProcedure {
	@SubscribeEvent
	public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT) == true) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("JujutsuSorcerer");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					entity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("CurseUser");
				}
			}.getValue() == 1 || new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("CursedSpirit");
				}
			}.getValue() == 1) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s run effect give @s jujutsucraft:double_jump_effect infinite 4 true");
					}
				}
			}
		}
	}
}
