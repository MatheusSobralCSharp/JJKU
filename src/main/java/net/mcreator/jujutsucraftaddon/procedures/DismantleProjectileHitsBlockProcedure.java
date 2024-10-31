package net.mcreator.jujutsucraftaddon.procedures;

import org.checkerframework.checker.units.qual.radians;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class DismantleProjectileHitsBlockProcedure {
    public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
        if (entity == null || immediatesourceentity == null)
            return;
        if (immediatesourceentity instanceof Projectile) {
            if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) == true) {
                Vec3 currentPos = new Vec3(immediatesourceentity.getBlockX(), immediatesourceentity.getBlockY(), immediatesourceentity.getBlockZ());
                Level level = immediatesourceentity.level();
                if (level == null)
                    return; // Ensure the level is not null
                // Set how far forward the particle should affect blocks
                int forwardRange = 30; // Modify this value to increase or decrease the range
                for (int i = 0; i < forwardRange; i++) {
                    // Calculate direction based on the source entity's rotation
                    double radians = Math.toRadians(immediatesourceentity.getYRot() + 90);
                    double xOffset = Math.cos(radians) * i; // Cosine for the x direction
                    double zOffset = Math.sin(radians) * i; // Sine for the z direction
                    Vec3 nextPos = currentPos.add(xOffset, // Calculated x-direction
                            0, // Keep the same y-level
                            zOffset // Calculated z-direction
                    );
                    BlockPos blockPos = new BlockPos((int) (nextPos.x + 1), (int) nextPos.y, (int) (nextPos.z + 1));
                    // Break blocks at the current and below positions
                    BlockState blockState = level.getBlockState(blockPos);
                    Block block = blockState.getBlock();
                    // Ensure the block isn't bedrock, barrier, or another unbreakable block
                    if (block != Blocks.BEDROCK) {
                        level.removeBlock(blockPos, false);
                        // Optionally, spawn particles or play a sound on block break
                        level.levelEvent(2001, blockPos, Block.getId(blockState)); // Block break event
                    }
                    // Break blocks below the current position
                    BlockPos blockPosY1 = blockPos.below(1);
                    BlockState blockStateY1 = level.getBlockState(blockPosY1);
                    if (block != Blocks.BEDROCK) {
                        level.removeBlock(blockPosY1, false);
                        level.levelEvent(2001, blockPosY1, Block.getId(blockStateY1)); // Block break event
                    }
                    BlockPos blockPosY2 = blockPos.below(2);
                    BlockState blockStateY2 = level.getBlockState(blockPosY2);
                    if (block != Blocks.BEDROCK) {
                        level.removeBlock(blockPosY2, false);
                        level.levelEvent(2001, blockPosY2, Block.getId(blockStateY2)); // Block break event
                    }
                }
            }
            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 20,
                        (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 0), false, false));
        }
    }
}
