
package net.mcreator.jujutsucraftaddon.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.procedures.MobTamerLivingEntityIsHitWithItemProcedure;

import java.util.List;

public class MobTamerItem extends Item {
	public MobTamerItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.jujutsucraftaddon.mob_tamer.description_0"));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		MobTamerLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity, sourceentity);
		return retval;
	}
}
