package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.Advancement;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TakabaProcedure {
    @SubscribeEvent
    public static void onAdvancement(AdvancementEvent event) {
        execute(event, event.getEntity().level(), event.getAdvancement(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Advancement advancement, Entity entity) {
        execute(null, world, advancement, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Advancement advancement, Entity entity) {
        if (advancement == null || entity == null)
            return;
        if (world instanceof Level _lvl0 && _lvl0.getServer() != null && _lvl0.getServer().getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:kakucho_jutsushiki")).equals(advancement)) {
            {
                double _setval = 2;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.SimpleDomainLevel = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}
