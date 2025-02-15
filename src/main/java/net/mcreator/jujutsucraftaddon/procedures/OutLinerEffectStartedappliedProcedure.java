package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class OutLinerEffectStartedappliedProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide()) {
            if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
                Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak.json"));
            }
        }
    }
}
