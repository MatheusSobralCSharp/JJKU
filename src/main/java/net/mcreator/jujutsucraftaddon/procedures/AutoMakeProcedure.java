package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

public class AutoMakeProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sorcerer_grade_special"))).isDone()) {
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique11", (-2));
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique5", (-2));
                entity.load(dataIndex);
            }
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putDouble("TenShadowsTechnique9", (-2));
                entity.load(dataIndex);
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Auto-Made Agito"), false);
        }
    }
}
