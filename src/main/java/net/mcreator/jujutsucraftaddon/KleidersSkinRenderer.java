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

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class KleidersSkinRenderer extends PlayerRenderer implements KleidersIgnoreCancel {
	private final ResourceLocation PLAYER_SKIN;

	public KleidersSkinRenderer(EntityRendererProvider.Context context, boolean useSmallArms, ResourceLocation skin) {
		super(context, useSmallArms);
		this.PLAYER_SKIN = skin;
	}

	public void clearLayers() {
		this.layers.clear();
	}

	public ResourceLocation getTextureLocation(AbstractClientPlayer p_117783_) {
		return this.PLAYER_SKIN;
	}

	@Nullable
	protected RenderType getRenderType(AbstractClientPlayer p_115322_, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		ResourceLocation resourcelocation = this.getTextureLocation(p_115322_);
		return RenderType.entityTranslucentCull(resourcelocation);
	}

	public static void hidePlayerModelPiece(PlayerModel model, int piece) {
		switch (piece) {
			case 0 -> model.hat.visible = false;
			case 1 -> model.jacket.visible = false;
			case 2 -> model.leftPants.visible = false;
			case 3 -> model.rightPants.visible = false;
			case 4 -> model.leftSleeve.visible = false;
			case 5 -> model.rightSleeve.visible = false;
			case 6 -> model.head.visible = false;
			case 7 -> model.body.visible = false;
			case 8 -> model.leftLeg.visible = false;
			case 9 -> model.rightLeg.visible = false;
			case 10 -> model.leftArm.visible = false;
			case 11 -> model.rightArm.visible = false;
		}

	}
}
