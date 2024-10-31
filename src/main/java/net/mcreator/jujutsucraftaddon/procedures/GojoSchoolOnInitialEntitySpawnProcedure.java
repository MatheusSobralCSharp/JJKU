package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;

public class GojoSchoolOnInitialEntitySpawnProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 3, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 18, false, false));
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 2, false, false));
        {
            Entity _entity = entity;
            if (_entity instanceof Player _player) {
                _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModItems.SUNGLASSES_HELMET.get()));
                _player.getInventory().setChanged();
            } else if (_entity instanceof LivingEntity _living) {
                _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModItems.SUNGLASSES_HELMET.get()));
            }
        }
    }
}
