package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RedEntity.class)
public abstract class RedEntityJujutsuMixin extends PathfinderMob {
    public RedEntityJujutsuMixin(EntityType<? extends PathfinderMob> type, ServerLevel world) {
        super(type, world);
    }

    /**
     * Overwrites the getDimensions method to scale the dimensions based on SizeByNBTProcedure.
     */
    @Override
    public EntityDimensions getDimensions(Pose pose) {
        EntityDimensions originalDimensions = super.getDimensions(pose);  // Get the original dimensions
        float scale = (float) SizeByNBTProcedure.execute((RedEntity) (Object) this);  // Get scale from SizeByNBTProcedure
        return originalDimensions.scale(scale);  // Return scaled dimensions
    }
}
