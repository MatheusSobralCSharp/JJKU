package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

public class HidingEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer _player)
            _player.setGameMode(GameType.SPECTATOR);
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get(), 1200, 1, false, false));
    }
}
