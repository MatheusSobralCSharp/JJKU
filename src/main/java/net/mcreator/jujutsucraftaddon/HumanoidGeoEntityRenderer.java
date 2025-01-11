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

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.ItemArmorGeoLayer;

public class HumanoidGeoEntityRenderer<E extends Mob & GeoAnimatable> extends GeoEntityRenderer<E> {
	public HumanoidGeoEntityRenderer(EntityRendererProvider.Context renderManager, GeoModel<E> model) {
		super(renderManager, model);
		this.addRenderLayer(new ItemArmorGeoLayer<>(this){
			@Override
			protected @Nullable ItemStack getArmorItemForBone(GeoBone bone, E animatable) {
				return switch (bone.getName()) {
					case "armorHead" -> this.helmetStack;
					case "armorChest", "armorArmRight", "armorArmLeft" -> this.chestplateStack;
					default -> null;
				};
			}

			@Override
			protected @NotNull EquipmentSlot getEquipmentSlotForBone(GeoBone bone, ItemStack stack, E animatable) {
				return switch (bone.getName()) {
					case "armorHead" -> EquipmentSlot.HEAD;
					case "armorChest" -> EquipmentSlot.CHEST;
					case "armorArmRight" -> !animatable.isLeftHanded() ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
					case "armorArmLeft" -> animatable.isLeftHanded() ? EquipmentSlot.OFFHAND : EquipmentSlot.MAINHAND;
					default -> super.getEquipmentSlotForBone(bone, stack, animatable);
				};
			}

			@Override
			protected @NotNull ModelPart getModelPartForBone(GeoBone bone, EquipmentSlot slot, ItemStack stack, E animatable, HumanoidModel<?> baseModel) {
				return switch (bone.getName()) {
					case "armorHead" -> baseModel.head;
					case "armorChest" -> baseModel.body;
					case "armorArmRight" -> baseModel.rightArm;
					case "armorArmLeft" -> baseModel.leftArm;
					default -> super.getModelPartForBone(bone, slot, stack, animatable, baseModel);
				};
			}
		});
	}
}
