package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KugisakiNailProcedure;
import net.mcreator.jujutsucraft.procedures.KugisakiRightClickProcedure;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;


@Mixin(value = KugisakiRightClickProcedure.class, remap = false)
public abstract class KugisakiRightMixin {
    public KugisakiRightMixin() {

    }

    /**
     * @author Sat
     * @reason None
     */

    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity != null) {
            boolean logic_a;
            Player _plr;
            label83:
            {
                double old_select = 0.0;
                double old_skill = 0.0;
                logic_a = false;
                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    if (!(entity instanceof LivingEntity)) {
                        break label83;
                    }
                }

                LivingEntity _livEnt1 = (LivingEntity) entity;
                if (!_livEnt1.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                    break label83;
                }


                if (entity instanceof Player) {
                    _plr = (Player) entity;
                    if (!_plr.level().isClientSide()) {
                        _plr.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                        return;
                    }
                }

                return;
            }

            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
            LazyOptional<IItemHandler> var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction) null);
            Objects.requireNonNull(_iitemhandlerref);
            var10000.ifPresent(_iitemhandlerref::set);
            if (_iitemhandlerref.get() != null) {
                for (int _idx = 0; _idx < ((IItemHandler) _iitemhandlerref.get()).getSlots(); ++_idx) {
                    ItemStack itemstackiterator = ((IItemHandler) _iitemhandlerref.get()).getStackInSlot(_idx).copy();
                    if (itemstackiterator.getItem() == JujutsucraftModItems.NAIL.get()) {
                        logic_a = true;
                        break;
                    }
                }
            }

            Player _player;
            label84:
            {
                if (!logic_a || !(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange >= 10.0)) {
                    if (!(entity instanceof Player)) {
                        break label84;
                    }

                    _plr = (Player) entity;
                    if (!_plr.getAbilities().instabuild) {
                        break label84;
                    }
                }

                KugisakiNailProcedure.execute(world, x, y, z, entity);
                if (entity instanceof Player) {
                    _player = (Player) entity;
                    _player.getCooldowns().addCooldown(itemstack.getItem(), 3);
                }

                return;
            }

            if (entity instanceof Player) {
                _player = (Player) entity;
                if (!_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                }
            }

        }
    }
}