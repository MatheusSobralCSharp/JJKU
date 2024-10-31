package net.mcreator.jujutsucraftaddon.item;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModFluids;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class YokuItem extends BucketItem {
    public YokuItem() {
        super(JujutsucraftaddonModFluids.YOKU, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.literal("[Ability] The Bath Ritual"));
    }
}
