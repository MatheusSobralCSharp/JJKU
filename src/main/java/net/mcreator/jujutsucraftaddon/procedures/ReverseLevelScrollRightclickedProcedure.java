package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ReverseLevelScrollRightclickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        {
            double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount + 100;
            entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                capability.RCTCount = _setval;
                capability.syncPlayerVariables(entity);
            });
        }
        if (entity instanceof Player _player) {
            ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get());
            _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
        }
    }
}
