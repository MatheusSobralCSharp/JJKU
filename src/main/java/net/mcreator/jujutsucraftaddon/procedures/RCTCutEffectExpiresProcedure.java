package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class RCTCutEffectExpiresProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 25);
        if (world instanceof ServerLevel _level)
            _level.sendParticles(JujutsucraftaddonModParticleTypes.BLOOD_RED.get(), x, (y + 1), z, 5, 0, 0, 0, 1);
    }
}
