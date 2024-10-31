package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class CTSet1Procedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()).getAmplifier() : 0) < 3) {
            {
                double _setval = ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).KenjakuCT1);
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.PlayerCurseTechnique2 = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.FATIGUE.get(),
                        (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()).getDuration() : 0) + 1200),
                        (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftaddonModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1), false, false));
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Changed Technique"), false);
            if (entity instanceof Player _player)
                _player.closeContainer();
        }
    }
}
