package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AnimationEffectProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone < 3) {
            ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    new ResourceLocation("jujutsucraft:start_animation")
            );

            DamageSource damageSource = new DamageSource(
                    world.registryAccess()
                            .registryOrThrow(Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(damageTypeKey)
            );

            entity.hurt(damageSource, 1.0F);

            {
                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CustceneDone + 1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.CustceneDone = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}
