package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;

public class CursedPowerLevelScrollRightclickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CursedLevel + 100;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.CursedLevel = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player) {
            ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
        }
    }
}
