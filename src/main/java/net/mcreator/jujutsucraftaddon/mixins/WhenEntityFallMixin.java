package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.ItadoriYujiShinjukuEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.WhenEntityFallProcedure;
import net.mcreator.jujutsucraftaddon.entity.ItadoriShinjukuEntity;
import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = WhenEntityFallProcedure.class, priority = -10000)
public class WhenEntityFallMixin {

    /**
     * @author Satushi
     * @reason Change Some Stuff in Respawn
     */

    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;D)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, double x, double y, double z, Entity entity, double distance, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double distance_power = 0.0;
            double curse_energy_color = 0.0;
            distance_power = distance;
            distance_power -= 5.0;
            if (distance_power > 0.0) {
                curse_energy_color = 0.0;
                LivingEntity _entGetArmor;
                if (entity instanceof Player) {
                    if (entity.isShiftKeyDown()) {
                        if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX > 5000.0) {
                            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 5.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 5.0) {
                                curse_energy_color = 1.0;
                            } else {
                                curse_energy_color = 3.0;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            if (_entGetArmor.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                curse_energy_color = 2.0;
                            }
                        }
                    }
                } else {
                    if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity) {
                        curse_energy_color = 3.0;
                    }

                    if (entity instanceof ItadoriYujiShinjukuEntity || entity instanceof ItadoriShinjukuEntity) {
                        curse_energy_color = 1.0;
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            curse_energy_color = 2.0;
                        }
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity;
                    if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                        curse_energy_color = 4.0;
                    }
                }

                if (curse_energy_color > 0.0) {
                    distance_power = Math.sqrt(distance_power + 1.0);
                    ServerLevel _level;
                    if (curse_energy_color == 1.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 2.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 3.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    }else if (curse_energy_color == 5.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    } else if (curse_energy_color == 4.0) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                        }
                    }

                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), distance_power, 0.0, distance_power, Math.min(distance_power * 0.1, 1.5));
                    }

                    if (world instanceof ServerLevel) {
                        _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), (int)(Math.min(Math.pow(distance_power, 2.5) + 20.0, 100.0) * 0.25), (double)entity.getBbWidth() * 0.25, 0.0, (double)entity.getBbWidth() * 0.25, 0.5 + Math.min(distance_power * 0.25, 1.5));
                    }

                    Level _level2;
                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.explode((Entity)null, entity.getX(), entity.getY(), entity.getZ(), 0.0F, Level.ExplosionInteraction.NONE);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)(distance_power * 0.5), 1.0F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                        }
                    }

                    if (world instanceof Level) {
                        _level2 = (Level)world;
                        if (!_level2.isClientSide()) {
                            _level2.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F);
                        } else {
                            _level2.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, (float)distance_power, 0.5F, false);
                        }
                    }

                    entity.getPersistentData().putDouble("BlockRange", Math.min(distance_power, 4.0) + (double)entity.getBbWidth());
                    entity.getPersistentData().putDouble("BlockDamage", 0.25 * distance_power);
                    entity.getPersistentData().putBoolean("noParticle", true);
                    BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
                    if (distance_power > 4.0 && entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        if (!_entGetArmor.level().isClientSide()) {
                            _entGetArmor.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 15, 4, false, false));
                        }
                    }

                    ItemStack var10000;
                    if (!(entity instanceof Player)) {
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("P_ANIME1", -10.0);
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                    }

                    PlayAnimationProcedure.execute(entity);
                    if (entity instanceof Player) {
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("P_ANIME1", -10.0);
                        if (entity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)entity;
                            var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                    }

                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    }
                }
            }

        }
    }
}
