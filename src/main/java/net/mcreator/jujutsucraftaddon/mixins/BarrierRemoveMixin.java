package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.JujutsuBarrierUpdateTickProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = JujutsuBarrierUpdateTickProcedure.class, remap = false)
public abstract class BarrierRemoveMixin {
    public BarrierRemoveMixin() {

    }

    /**
     * @author Satushi
     * @reason Changes
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z) {
        String old_block = "";
        boolean logic_success = false;
        double cnt = 0.0;
        double x_pos = 0.0;
        double y_pos = 0.0;
        double z_pos = 0.0;
        double y_fix = 0.0;
        double y_fix_height = 0.0;
        double y_floor = 0.0;
        double test = 0.0;
        x_pos = x;
        y_pos = y;
        z_pos = z;
        ServerLevel _level;
        if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).getBlock() == JujutsucraftModBlocks.JUJUTSU_BARRIER.get() && Math.random() < 0.1) {
            if (world instanceof ServerLevel) {
                _level = (ServerLevel) world;
                _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS.get(), x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.25);
            }

            if (world instanceof ServerLevel) {
                _level = (ServerLevel) world;
                if (!_level.isClientSide()) {
                    _level.playSound((Player) null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                } else {
                    _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                }
            }
        }

        old_block = (((new Object() {
            public String getValue(LevelAccessor world, BlockPos pos, String tag) {
                BlockEntity blockEntity = world.getBlockEntity(pos);
                BlockState blockState = world.getBlockState(pos);
                String registryName = ForgeRegistries.BLOCKS.getKey(blockState.getBlock()).toString();
                String nbtData = blockEntity.serializeNBT().toString();
                return blockEntity.getPersistentData().getString(tag);
            }
        })).getValue(world, BlockPos.containing(x_pos, y_pos, z_pos), "old_block"));

        if (world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ " + old_block);
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ " + old_block);
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ " + old_block);
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ " + old_block);
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ " + old_block);
        }

        if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
            if (world instanceof ServerLevel) {
                _level = (ServerLevel)world;
                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
                _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
            }
        } else if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
            Vec3 _center = new Vec3(x_pos + 0.5, y_pos + 0.5, z_pos + 0.5);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var25 = _entfound.iterator();

            while(true) {
                while(true) {
                    Entity entityiterator;
                    do {
                        do {
                            if (!var25.hasNext()) {
                                return;
                            }

                            entityiterator = (Entity)var25.next();
                        } while(entityiterator instanceof DomainExpansionEntityEntity);
                    } while(entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))));

                    y_fix = 0.0;

                    for(int index0 = 0; index0 < 255; ++index0) {
                        ++y_fix;
                        if (!world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + y_fix, entityiterator.getZ())).canOcclude()) {
                            logic_success = true;
                            y_fix_height = 0.0;

                            for(int index1 = 0; index1 < (int)Math.max(Math.ceil((double)entityiterator.getBbHeight()), 1.0); ++index1) {
                                ++y_fix_height;
                                if (world.getBlockState(BlockPos.containing(entityiterator.getX(), entityiterator.getY() + y_fix + y_fix_height, entityiterator.getZ())).canOcclude()) {
                                    logic_success = false;
                                    break;
                                }
                            }

                            if (logic_success) {
                                entityiterator.teleportTo(entityiterator.getX(), entityiterator.getY() + y_fix, entityiterator.getZ());
                                if (entityiterator instanceof ServerPlayer) {
                                    ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                                    _serverPlayer.connection.teleport(entityiterator.getX(), entityiterator.getY() + y_fix, entityiterator.getZ(), entityiterator.getYRot(), entityiterator.getXRot());
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

    }
}

