
package net.mcreator.jujutsucraftaddon.client.renderer;

import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.jujutsucraftaddon.entity.model.ErrorModel;
import net.mcreator.jujutsucraftaddon.entity.layer.ErrorLayer;
import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class ErrorRenderer extends GeoEntityRenderer<ErrorEntity> {
	public ErrorRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ErrorModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ErrorLayer(this));
		this.addRenderLayer(new ErrorRenderer2(this, this));
		this.addRenderLayer(new ErrorRenderer3(this, this));
	}

	@Override
	public RenderType getRenderType(ErrorEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		if (animatable.getOwner() != null) {
			EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
			EntityRenderer<? super LivingEntity> livingRenderer = entityRenderDispatcher.getRenderer(Objects.requireNonNull(animatable.getOwner()));
			ResourceLocation resourceLocation = livingRenderer.getTextureLocation(animatable.getOwner());
			return RenderType.entityTranslucent(resourceLocation);
		} else {
			return RenderType.entityTranslucent(texture);
		}
	}

	@Override
	public void preRender(PoseStack poseStack, ErrorEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
						  float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

class ErrorRenderer2 extends BlockAndItemGeoLayer<ErrorEntity> {

	private final ErrorRenderer ErrorRenderer;

	public ErrorRenderer2(ErrorRenderer ErrorRenderer, GeoRenderer<ErrorEntity> renderer) {
		super(renderer);
		this.ErrorRenderer = ErrorRenderer;
	}

	@Nullable
	@Override
	protected ItemStack getStackForBone(GeoBone bone, ErrorEntity animatable) {
		return switch (bone.getName()) {
			case "HandLeft" -> ErrorRenderer.getAnimatable().getMainHandItem();
			case "HandRight" -> ErrorRenderer.getAnimatable().getOffhandItem();
			default -> null;
		};
	}

	@Override
	protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, ErrorEntity animatable) {
		return switch (bone.getName()) {
			case "HandLeft", "HandRight" -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
			default -> ItemDisplayContext.NONE;
		};
	}

	@Override
	protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, ErrorEntity animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
		if (stack.equals(ErrorRenderer.getAnimatable().getMainHandItem())) {
			poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
			if (stack.getItem() instanceof ShieldItem) {
				poseStack.translate(0.0, 0.125, -0.25);
			}
		} else if (stack.equals(ErrorRenderer.getAnimatable().getOffhandItem())) {
			poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
			if (stack.getItem() instanceof ShieldItem) {
				poseStack.translate(0.0, 0.125, 0.25);
				poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
			}
		}

		super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
	}
}

class ErrorRenderer3 extends ItemArmorGeoLayer<ErrorEntity> {
	private final ErrorRenderer ErrorRenderer2;

    public ErrorRenderer3(ErrorRenderer ErrorRenderer2, GeoRenderer<ErrorEntity> geoRenderer) {
		super(geoRenderer);
		this.ErrorRenderer2 = ErrorRenderer2;
    }

	@Nullable
	protected ItemStack getArmorItemForBone(GeoBone bone, ErrorEntity animatable) {
		ItemStack var10000;
		switch (bone.getName()) {
			case "armorLeftFoot":
			case "armorRightFoot":
			case "left_leg_boot":
			case "right_leg_boot":
				var10000 = this.bootsStack;
				break;
			case "armorLeftLeg":
			case "armorRightLeg":
				var10000 = this.leggingsStack;
				break;
			case "armorBody":
			case "armorArmRight":
			case "armorArmLeft":
				var10000 = this.chestplateStack;
				;
				break;
			case "armorHead":
				var10000 = this.helmetStack;
				break;
			default:
				var10000 = null;
		}

		return var10000;
	}

	@Nonnull
	protected EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, ErrorEntity animatable) {
		EquipmentSlot var10000;
		switch (bone.getName()) {
			case "armorLeftFoot":
			case "armorRightFoot":
			case "left_leg_boot":
			case "right_leg_boot":
				var10000 = EquipmentSlot.FEET;
				break;
			case "armorLeftLeg":
			case "armorRightLeg":
				var10000 = EquipmentSlot.LEGS;
				break;
			case "armorArmRight":
				var10000 = EquipmentSlot.MAINHAND;
				break;
			case "armorArmLeft":
				var10000 = EquipmentSlot.OFFHAND;
				break;
			case "armorBody":
				var10000 = EquipmentSlot.CHEST;
				break;
			case "armorHead":
				var10000 = EquipmentSlot.HEAD;
				break;
			default:
				var10000 = super.getEquipmentSlotForBone(bone, stack, animatable);
		}

		return var10000;
	}

	@Nonnull
	protected ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, ErrorEntity animatable, HumanoidModel<?> baseModel) {
		ModelPart var10000;
		if ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot") || ((ForgeRegistries.ITEMS.getKey(((Object) animatable instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem()).toString()).contains("zenin_boot")))  {
			switch (bone.getName()) {
				case "armorLeftLeg":
				case "left_leg_boot":
					var10000 = baseModel.leftLeg;
					break;
				case "armorRightLeg":
				case "right_leg_boot":
					var10000 = baseModel.rightLeg;
					break;
				case "armorArmRight":
					var10000 = baseModel.rightArm;
					break;
				case "armorArmLeft":
					var10000 = baseModel.leftArm;
					break;
				case "armorBody":
					var10000 = baseModel.body;
					break;
				case "armorHead":
					var10000 = baseModel.head;
					break;
				default:
					var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
			}
			return var10000;
		} else {
			switch (bone.getName()) {
				case "armorLeftFoot":
				case "armorLeftLeg":
					var10000 = baseModel.leftLeg;
					break;
				case "armorRightFoot":
				case "armorRightLeg":
					var10000 = baseModel.rightLeg;
					break;
				case "armorArmRight":
					var10000 = baseModel.rightArm;
					break;
				case "armorArmLeft":
					var10000 = baseModel.leftArm;
					break;
				case "armorBody":
					var10000 = baseModel.body;
					break;
				case "armorHead":
					var10000 = baseModel.head;
					break;
				default:
					var10000 = super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
			}
		}
		return var10000;
	}
}

