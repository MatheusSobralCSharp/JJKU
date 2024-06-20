package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jujutsucraftaddon.item.YuunItem;

public class YuunEntitySwingsItemProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.getItem() instanceof YuunItem)
			itemstack.getOrCreateTag().putString("geckoAnim", ("attack" + Mth.nextInt(RandomSource.create(), 1, 4)));
	}
}
