package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class KokusenScrollRightclickedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash"))).isDone())) {
            if (entity instanceof ServerPlayer _player) {
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:mastery_black_flash"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria())
                        _player.getAdvancements().award(_adv, criteria);
                }
            }
            if (entity instanceof Player _player) {
                ItemStack _stktoremove = new ItemStack(JujutsucraftaddonModItems.KOKUSEN_SCROLL.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
            }
        }
    }
}
