package net.mcreator.jujutsucraftaddon.mixins;


import net.mcreator.jujutsucraft.procedures.WhenEntitySpawnsProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;


@Mixin(value = WhenEntitySpawnsProcedure.class, remap = false)
public abstract class WhenRespawnedMixin {
    public WhenRespawnedMixin() {
    }

    /**
     * @author Satushi
     * @reason Testing
     */
    @SubscribeEvent
    @Overwrite
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        execute(event, event.getEntity());
    }

    private static void execute(@Nullable Event event, Entity entity) {

    }
}
