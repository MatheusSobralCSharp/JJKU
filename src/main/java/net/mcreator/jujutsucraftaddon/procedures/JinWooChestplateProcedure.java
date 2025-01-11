package net.mcreator.jujutsucraftaddon.procedures;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.item.SungJinWooItem;

public class JinWooChestplateProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!entity.onGround()) {
			if (itemstack.getItem() instanceof SungJinWooItem armor && armor instanceof GeoItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "float2");
		} else if (entity.onGround()) {
			if (itemstack.getItem() instanceof SungJinWooItem armor && armor instanceof GeoItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "empty");
		}
	}
}
