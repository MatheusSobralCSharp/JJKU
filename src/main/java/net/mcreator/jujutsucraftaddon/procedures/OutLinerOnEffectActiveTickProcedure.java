package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

public class OutLinerOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (world.isClientSide()) {
            if (Minecraft.getInstance().gameRenderer.currentEffect() == null) {
                if (Math.random() <= 0.1) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhitestrong.json"));
                } else if (Math.random() <= 0.2) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak.json"));
                } else if (Math.random() <= 0.3) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhitestrong1.json"));
                } else if (Math.random() <= 0.4) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak4.json"));
                } else if (Math.random() <= 0.5) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak2.json"));
                } else if (Math.random() <= 0.6) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhiteweak3.json"));
                } else if (Math.random() <= 0.7) {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackandwhitestrong2.json"));
                } else {
                    Minecraft.getInstance().gameRenderer.loadEffect(new ResourceLocation("jujutsucraftaddon:shaders/blackflashfinal.json"));
                }
            } else {
                Minecraft.getInstance().gameRenderer.shutdownEffect();
            }
        }
    }
}
