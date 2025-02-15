package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DashEffectExpiresProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 7) {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get(), 60, 1, false, false));
        } else {
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get(), 40, 1, false, false));
        }
    }
}
