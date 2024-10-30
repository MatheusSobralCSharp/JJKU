package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.AIBlackFlashProcedure;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.procedures.EffectsBlackFlashProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = AIBlackFlashProcedure.class, remap = false)
public abstract class PlayerMixin {
    /**
     * @author Satushi
     * @reason Removing Black Flash Particles
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double rad = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double soundPitch = 0.0;
            double rad_now = 0.0;
            double num1 = 0.0;
            double num2 = 0.0;
            double num3 = 0.0;
            double pitch = 0.0;
            double loop_num = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            int index2;
            Level _level8;
            ServerLevel _level;
            EffectsBlackFlashProcedure.execute(world, x, y, z, entity);
            if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                    soundPitch = 0.75;

                    for(index2 = 0; index2 < 3; ++index2) {
                        if (world instanceof Level) {
                            Level _level1 = (Level) world;
                            if (!_level1.isClientSide()) {
                                _level1.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                            } else {
                                _level1.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                            }
                        }

                        soundPitch += 0.25;
                    }
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x, y + 1.0, z, 3, 0.5, 1.0, 0.5, 0.0);
                }

            } else if (entity.getPersistentData().getDouble("cnt1") < 17.0) {
                if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
                    soundPitch = 0.75;

                    for(index2 = 0; index2 < 3; ++index2) {
                        if (world instanceof Level) {
                            Level _level3 = (Level)world;
                            if (!_level3.isClientSide()) {
                                _level3.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                            } else {
                                _level3.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                            }
                        }

                        if (world instanceof Level) {
                            Level _level4 = (Level)world;
                            if (!_level4.isClientSide()) {
                                _level4.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch);
                            } else {
                                _level4.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, 1.0F, (float)soundPitch, false);
                            }
                        }

                        soundPitch += 0.25;
                    }

                    entity.getPersistentData().putDouble("BlockRange", 20.0);
                    entity.getPersistentData().putDouble("BlockDamage", 5.0);
                    BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                }

                loop_num = 5.0 + entity.getPersistentData().getDouble("cnt1") * 2.0;

                for(index2 = 0; index2 < 2; ++index2) {
                    rad_now = Math.toRadians(Math.random() * 360.0);
                    pitch = Math.toRadians(0.0);
                    num1 = (Math.random() - 0.5) * 1.6;
                    num2 = (Math.random() - 0.5) * 1.6;
                    num3 = (Math.random() - 0.5) * 1.6;
                    entity.getPersistentData().putDouble("x_pos", x);
                    entity.getPersistentData().putDouble("y_pos", y + 1.0);
                    entity.getPersistentData().putDouble("z_pos", z);
                    entity.getPersistentData().putDouble("cnt2", 0.0);

                    for(int index3 = 0; index3 < (int)loop_num; ++index3) {
                        x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(rad_now) * (Math.cos(pitch) + Math.abs(Math.sin(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().getDouble("cnt2") + 1.0);
                        y_pos = entity.getPersistentData().getDouble("y_pos") + Math.sin(pitch) * (entity.getPersistentData().getDouble("cnt2") + 1.0) * -1.0;
                        z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(rad_now) * (Math.cos(pitch) + Math.abs(Math.cos(rad_now) * Math.sin(pitch))) * (entity.getPersistentData().getDouble("cnt2") + 1.0);
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftaddonModParticleTypes.KOKUSEN_4.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                        }



//                        if (world instanceof ServerLevel) {
//                            _level = (ServerLevel)world;
//                            DustParticleOptions dustOptions = new DustParticleOptions(new Vector3f(0.6F, 0.0F, 0.0F), 2.0F);
//
//                            // Send particles at specified position with spread
//                            _level.sendParticles(dustOptions, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
//                        }
//
//                        if (world instanceof ServerLevel) {
//                            _level = (ServerLevel)world;
//                            DustParticleOptions dustOptions = new DustParticleOptions(new Vector3f(0.0F, 0.0F, 0.0F), 2.0F);
//
//                            // Send particles at specified position with spread
//                            _level.sendParticles(dustOptions, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
//                        }


                        if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                            if (!world.getBlockState(BlockPos.containing(x_pos + 1.0, y_pos + 0.0, z_pos + 0.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos + -1.0, y_pos + 0.0, z_pos + 0.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + 1.0, z_pos + 0.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + -1.0, z_pos + 0.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + 0.0, z_pos + 1.0)).canOcclude() || !world.getBlockState(BlockPos.containing(x_pos + 0.0, y_pos + 0.0, z_pos + -1.0)).canOcclude()) {
                                world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))));
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
                            }
                        }

                        entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 0.25);
                        if (entity.getPersistentData().getDouble("cnt2") % 4.0 < 2.0) {
                            entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + num1);
                            entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + num2);
                            entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + num3);
                        } else {
                            entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") - num1);
                            entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - num2);
                            entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") - num3);
                        }
                    }
                }
            } else if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                x_pos = x + Math.random() * 16.0 - 8.0;
                y_pos = y;
                z_pos = z + Math.random() * 16.0 - 8.0;

                if (world instanceof Level) {
                    Level _level5 = (Level)world;
                    if (!_level5.isClientSide()) {
                        _level5.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F);
                    } else {
                        _level5.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
                    }
                }

                if (entity.getPersistentData().getDouble("cnt1") > 25.0 && !entity.level().isClientSide()) {
                    entity.discard();
                }
            }

        }
    }
}
