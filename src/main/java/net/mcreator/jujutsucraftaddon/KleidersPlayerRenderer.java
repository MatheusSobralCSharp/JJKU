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
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class KleidersPlayerRenderer extends LivingEntityRenderer implements KleidersIgnoreCancel {
	private final ResourceLocation PLAYER_SKIN;

	public KleidersPlayerRenderer(EntityRendererProvider.Context context, ResourceLocation skin, EntityModel model) {
		this(context, false, skin);
		this.model = model;
	}

	@Nullable
	protected RenderType getRenderType(LivingEntity p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		ResourceLocation resourcelocation = this.getTextureLocation((Entity)p_115322_);
		return RenderType.entityTranslucentCull(resourcelocation);
	}

	public KleidersPlayerRenderer(EntityRendererProvider.Context context, boolean useSmallArms, ResourceLocation skin) {
		super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.5F);
		this.PLAYER_SKIN = skin;
	}

	public ResourceLocation getTextureLocation(Entity entity) {
		return this.PLAYER_SKIN;
	}

	public void render(AbstractClientPlayer entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		try {
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		} catch (Exception var8) {
			matrixStackIn.popPose();
		}

	}

	public ResourceLocation getTextureLocation(AbstractClientPlayer entity) {
		return this.PLAYER_SKIN;
	}
}