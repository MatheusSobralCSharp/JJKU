
package net.mcreator.jujutsucraftaddon.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.procedures.YutaRingItemInInventoryTickProcedure;

import java.util.List;

public class YutaRingItem extends Item {
	public YutaRingItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.jujutsucraftaddon.yuta_ring.description_0"));
		list.add(Component.translatable("item.jujutsucraftaddon.yuta_ring.description_1"));
		list.add(Component.translatable("item.jujutsucraftaddon.yuta_ring.description_2"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		YutaRingItemInInventoryTickProcedure.execute(world, entity, itemstack);
	}
}
