package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MahoragaBreakerProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("Mahoraga");
			}
		}.getValue() == 1) {
			if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
				((EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) entity).setAnimation("sword_overhead");
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @e[distance=..30] run effect clear @e[distance=..30] jujutsucraft:domain_expansion");
				}
			}
			JujutsucraftaddonMod.queueServerWork(20, () -> {
				for (int index0 = 0; index0 < 1; index0++) {
					if (!entity.level().isClientSide())
						entity.discard();
					break;
				}
			});
		}
	}
}
