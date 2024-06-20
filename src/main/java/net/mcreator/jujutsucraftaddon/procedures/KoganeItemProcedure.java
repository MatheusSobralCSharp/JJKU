package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

public class KoganeItemProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CULLING_GAMES) == true) {
			if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JujutsucraftaddonModItems.KOGANE_POINTS.get())) : false)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(JujutsucraftaddonModItems.KOGANE_POINTS.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
