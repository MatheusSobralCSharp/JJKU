package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.WhenPlayerJointheWorldProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ConcorrentSpawnProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(value = WhenPlayerJointheWorldProcedure.class, priority = -10000)
public abstract class WhenPlayerJointheWorldProcedureMixin {

    /**
     * @author Satushi
     * @reason Remove and Fix some stuff when joined
     */


    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();
        if (entity != null) {
            if (entity.isAlive()) {
                ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
                if (entityTypeKey == null || !entityTypeKey.toString().startsWith("jujutsucraft")) {
                    ConcorrentSpawnProcedure.execute(entity, world, x, y, z);
                }

            }
        }
    }
}
