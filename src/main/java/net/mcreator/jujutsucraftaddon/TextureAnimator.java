/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.jujutsucraftaddon as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.jujutsucraftaddon;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticles;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

import javax.annotation.Nullable;

public class TextureAnimator extends TextureSheetParticle {
	private static final ResourceLocation TEXTURE = new ResourceLocation(JujutsucraftaddonMod.MODID, "textures/entities/dismantle.png");
	final int entityId;
	public float quadSize;

	public RandomSource getRandomSource() {
		return this.random;
	}

	float roll;
	@Nullable
    Entity entity;
	@Nullable
    Vec3 offset;
	public TextureAnimator(ClientLevel pLevel, double pX, double pY, double pZ, int entityId) {
		super(pLevel, pX, pY, pZ);

		this.lifetime = 20;

		this.hasPhysics = false;

		this.entityId = entityId;
	}

	public void updateSize(float width, float height) {
		this.setSize(width, height);
	}

	@Override
	public void tick() {
		super.tick();

		this.quadSize = 0.5F;

		this.roll = (this.random.nextFloat() - 0.5F) * 360.0F;

		if (this.entity == null) {
			this.entity = this.level.getEntity(this.entityId);
		} else {
			this.quadSize = 0.1F * (this.random.nextFloat() * 0.5F + 0.5F) * (this.entity.getBbWidth() + this.entity.getBbHeight()) * 20.0F;
			this.setSize(this.quadSize, this.quadSize);

			Vec3 center = this.entity.position().add(0.0D, this.entity.getBbHeight() / 2, 0.0D);
			this.offset = center.add((HelperMethods.RANDOM.nextDouble() - 0.5D) * this.entity.getBbWidth(),
					(HelperMethods.RANDOM.nextDouble() - 0.5D) * this.entity.getBbHeight(),
					(HelperMethods.RANDOM.nextDouble() - 0.5D) * this.entity.getBbWidth());

			this.setPos(this.offset.x, this.offset.y, this.offset.z);
		}

		if (this.entity == null || this.entity.isRemoved() || !this.entity.isAlive()) {
			this.remove();
		}
	}

	@Override
	public void render(@NotNull VertexConsumer pBuffer, @NotNull Camera pRenderInfo, float pPartialTicks) {
		if (this.offset == null) return;

		Minecraft mc = Minecraft.getInstance();

		PoseStack poseStack = new PoseStack();

		Vec3 cam = pRenderInfo.getPosition();
		poseStack.translate(this.offset.x - cam.x, this.offset.y - cam.y, this.offset.z - cam.z);

		poseStack.mulPose(Axis.YN.rotationDegrees(pRenderInfo.getYRot()));
		poseStack.mulPose(Axis.XP.rotationDegrees(pRenderInfo.getXRot() - 90.0F));
		poseStack.mulPose(Axis.YP.rotationDegrees(this.roll));

		poseStack.scale(1.0F, 1.0F, 0.2F);

		RenderType type = RenderType.entityTranslucent(TEXTURE);

		VertexConsumer consumer = mc.renderBuffers().bufferSource().getBuffer(type);
		Matrix4f matrix4f = poseStack.last().pose();

		consumer.vertex(matrix4f, -this.quadSize / 2.0F, 0.0F, -1.0F)
				.color(1.0F, 1.0F, 1.0F, 1.0F)
				.uv(0.0F, 0.0F)
				.overlayCoords(OverlayTexture.NO_OVERLAY)
				.uv2(LightTexture.FULL_SKY)
				.normal(0.0F, 1.0F, 0.0F)
				.endVertex();
		consumer.vertex(matrix4f, -this.quadSize / 2.0F, 0.0F, 1.0F)
				.color(1.0F, 1.0F, 1.0F, 1.0F)
				.uv(0.0F, 1.0F)
				.overlayCoords(OverlayTexture.NO_OVERLAY)
				.uv2(LightTexture.FULL_SKY)
				.normal(0.0F, 1.0F, 0.0F)
				.endVertex();
		consumer.vertex(matrix4f, this.quadSize / 2.0F, 0.0F, 1.0F)
				.color(1.0F, 1.0F, 1.0F, 1.0F)
				.uv(1.0F, 1.0F)
				.overlayCoords(OverlayTexture.NO_OVERLAY)
				.uv2(LightTexture.FULL_SKY)
				.normal(0.0F, 1.0F, 0.0F)
				.endVertex();
		consumer.vertex(matrix4f, this.quadSize / 2.0F, 0.0F, -1.0F)
				.color(1.0F, 1.0F, 1.0F, 1.0F)
				.uv(1.0F, 0.0F)
				.overlayCoords(OverlayTexture.NO_OVERLAY)
				.uv2(LightTexture.FULL_SKY)
				.normal(0.0F, 1.0F, 0.0F)
				.endVertex();

		super.tick();
		ParticleHelper.applyTextureAnimation(this.level, this, this.random);
	}

	@Override
	public @NotNull ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_LIT;
	}

	public static ParticleProvider<SimpleParticleType> Provider(SpriteSet spriteSet) {
		return new Provider(spriteSet);
	}

	public static class Provider implements ParticleProvider<SimpleParticleType> {
		public Provider(SpriteSet ignored) {
		}

		@Override
		public TextureAnimator createParticle(@NotNull SimpleParticleType type, @NotNull ClientLevel level, double x, double y, double z,
											double xSpeed, double ySpeed, double zSpeed) {
			return new TextureAnimator(level, x, y, z, (int) xSpeed);
		}
	}
}
