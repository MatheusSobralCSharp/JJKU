package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import java.util.List;
import java.util.stream.Collectors;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon", bus = Bus.FORGE, value = Dist.CLIENT)
public class Outline3Procedure {

	private static List<Entity> entitiesToRender = null;
	private static final double RENDER_DISTANCE = 50.0;

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null) {
			return;
		}
		Vec3 center = new Vec3(x, y, z);
		entitiesToRender = world.getEntitiesOfClass(Entity.class, new AABB(center, center).inflate(50), e -> e != entity)
				.stream()
				.sorted((e1, e2) -> Double.compare(e1.distanceToSqr(center), e2.distanceToSqr(center)))
				.collect(Collectors.toList());
	}

	@SubscribeEvent
	public static void onRenderTick(TickEvent.RenderTickEvent event) {
		if (entitiesToRender == null || entitiesToRender.isEmpty()) {
			return;
		}

		Minecraft mc = Minecraft.getInstance();
		Entity camEntity = mc.getCameraEntity();

		if (camEntity == null) {
			return;
		}

		RenderSystem.depthMask(true);
		VertexConsumer vertexConsumer = mc.renderBuffers().bufferSource().getBuffer(RenderType.lines());
		PoseStack matrixStack = new PoseStack();

		double camX = camEntity.getX();
		double camY = camEntity.getY();
		double camZ = camEntity.getZ();

		for (Entity entity : entitiesToRender) {
			if (entity.distanceToSqr(camX, camY, camZ) > RENDER_DISTANCE * RENDER_DISTANCE) {
				continue;
			}

			AABB entityAABB = entity.getBoundingBox().inflate(0.1);
			matrixStack.pushPose();
			matrixStack.translate(entity.getX() - camX, entity.getY() - camY, entity.getZ() - camZ);
			LevelRenderer.renderLineBox(matrixStack, vertexConsumer, entityAABB.move(-entity.getX(), -entity.getY() - 1, -entity.getZ()), 1.0F, 0.0F, 0.0F, 1.0F); // Black outline
			matrixStack.popPose();
		}
	}
}
