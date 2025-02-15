package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class AnimationHeianOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;

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

        if (entity instanceof ErrorEntity) {
            ((ErrorEntity) entity).setAnimation("heianform");
        }
    }
}
