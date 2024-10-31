package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Comparator;

public class GojoMoveBlueProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player || entity instanceof ServerPlayer) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
                if (entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel
                        && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:gojo_training_part_3"))).isDone()) {
                    if (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.AWAKENING.get())) {
                        if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())) {
                            if (new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble("skill");
                                }
                            }.getValue() == 201) {
                                {
                                    final Vec3 _center = new Vec3(x, y, z);
                                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                                            .toList();
                                    for (Entity entityiterator : _entfound) {
                                        if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:blue") && entityiterator instanceof LivingEntity _livEnt8
                                                && _livEnt8.hasEffect(JujutsucraftaddonModMobEffects.BLUE_EFFECT.get())) {
                                            {
                                                Entity _ent = entityiterator;
                                                _ent.teleportTo(
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getX()),
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getY()),
                                                        (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
                                                                .getBlockPos().getZ()));
                                                if (_ent instanceof ServerPlayer _serverPlayer)
                                                    _serverPlayer.connection
                                                            .teleport(
                                                                    (entity.level()
                                                                            .clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
                                                                                    entity))
                                                                            .getBlockPos().getX()),
                                                                    (entity.level()
                                                                            .clip(new ClipContext(
                                                                                    entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
                                                                            .getBlockPos().getY()),
                                                                    (entity.level().clip(
                                                                                    new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
                                                                            .getBlockPos().getZ()),
                                                                    _ent.getYRot(), _ent.getXRot());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
