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

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;


public class PlayerAnimHandler {
	public PlayerAnimHandler() {
	}
	public static <T extends LivingEntity> void preSprintingAnim(Entity entity, PlayerModel playerModel) {
		playerModel.head.setPos(0.0F, 0.0F, 0.0F);
		playerModel.body.setPos(0.0F, 0.0F, 0.0F);
	}

	public static <T extends LivingEntity> void sprintingAnim(Entity entity, PlayerModel playerModel) {

		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
			if (entity.isSprinting() && !entity.isVisuallySwimming() && !entity.isCrouching()) {
				if (entity.isSprinting() && !entity.isVisuallySwimming() && !entity.isCrouching()) {
					float animationProgress = entity.tickCount % 120 / 40.0F; // Slower transitions (increase denominator)

					// Check if the player has an item in the main hand
					if (entity instanceof LivingEntity livingEntity) {
						ItemStack mainHandItem = livingEntity.getMainHandItem();
						ItemStack offhandItem = livingEntity.getOffhandItem();
						if (!mainHandItem.isEmpty()) {
							if (!offhandItem.isEmpty()) {
								// Increase right arm rotation for showing the weapon
								float rightArmRotationY = (float) Math.sin(animationProgress * Math.PI * 2) * 0.35F; // Increased dynamic movement
								float rightArmRotationX = 1F; // Increased arm lift
								playerModel.rightArm.setRotation(rightArmRotationX, rightArmRotationY, 1.0F); // Apply increased rotation
							} else {
								// Increase right arm rotation for showing the weapon
								float rightArmRotationY = (float) Math.sin(animationProgress * Math.PI * 2) * 0.35F; // Increased dynamic movement
								float rightArmRotationX = 1F; // Increased arm lift
								playerModel.rightArm.setRotation(rightArmRotationX, rightArmRotationY, 1.0F); // Apply increased rotation
							}
						} else {
							// Default dynamic arm movement when no item is held
							float rightArmRotationY = (float) Math.sin(animationProgress * Math.PI * 2) * 0.25F;
							playerModel.rightArm.setRotation(1.2F, rightArmRotationY, 0.0F);
						}
					}

					// Mirror effect for the left arm
					float leftArmRotationY = (float) Math.sin(animationProgress * Math.PI * 2) * 0.25F;
					playerModel.leftArm.setRotation(1.2F, -leftArmRotationY, 0.0F);

					// Positioning the arms
					playerModel.rightArm.setPos(-5.0F, 3.5F, -5.0F);
					playerModel.leftArm.setPos(5.0F, 3.5F, -5.0F);

					// Head position and rotation
					playerModel.head.xRot = 0.0F;
					playerModel.head.setPos(0.0F, 1.133333F, -6.0F);

					// Body adjustments for dynamic movement
					playerModel.body.setRotation(0.5F, 0.0F, 0.0F);
					playerModel.body.setPos(0.0F, 2.0F, -5.5F);


				}

			}
		}

	}
}
