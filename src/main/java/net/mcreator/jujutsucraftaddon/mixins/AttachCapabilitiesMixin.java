package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.WhenPlayerJointheWorldProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ConcorrentSpawnProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(value = WhenPlayerJointheWorldProcedure.class, remap = false)
public class AttachCapabilitiesMixin {

    /**
     * @author Satushi
     * @reason Rewrite
     */


    @Overwrite
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (entity.isAlive()) {
                ConcorrentSpawnProcedure.execute(entity, world, x, y, z);
            }
        }

    }

}
