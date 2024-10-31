package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.entity.VeilEntity;

public class VeilBlockOnTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (!(!world.getEntitiesOfClass(VeilEntity.class, AABB.ofSize(new Vec3(x, y, z), 1000, 1000, 1000), e -> true).isEmpty())) {
            world.destroyBlock(BlockPos.containing(x, y, z), false);
        }
    }
}
