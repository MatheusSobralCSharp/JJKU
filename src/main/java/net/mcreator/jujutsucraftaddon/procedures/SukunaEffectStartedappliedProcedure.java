package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class SukunaEffectStartedappliedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer _player)
            _player.setGameMode(GameType.SPECTATOR);
    }
}
