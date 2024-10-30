package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.JackpotEffectStartedappliedProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = JackpotEffectStartedappliedProcedure.class, remap = false)
public abstract class UIJujutsuCraftMixin {
    public UIJujutsuCraftMixin() {

    }

    /**
     * @author Sat
     * @reason ERROR
     */
    @Overwrite
        public static void execute(LevelAccessor world, Entity entity) {
            if (entity != null) {
                double var10000;
                double level;
                double tick;
                LivingEntity _entity;

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    _entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 5020, (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.LUCK) ? _livEnt.getEffect(MobEffects.LUCK).getAmplifier() : 0) + 1), false, false));
                }

                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Hakari")) {
                    if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.JACKPOT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.JACKPOT.get()).getDuration() : 0) < 5020) {
                        if (entity instanceof LivingEntity _entity2 && !_entity2.level().isClientSide())
                            _entity2.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.JACKPOT.get(), 5020,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.JACKPOT.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier() : 0) + 1), false, false));
                    }
                }



                label34: {
                    level = 0.0;
                    tick = 0.0;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier();
                            break label34;
                        }
                    }

                    var10000 = 0.0;
                }

                label29: {
                    level = var10000;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getDuration();
                            break label29;
                        }
                    }

                    var10000 = 0.0;
                }

                tick = var10000;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), (int)tick, (int)(4.0 + level), false, false));
                    }



                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.JACKPOT.get(), 2, 4, false, false));
                    }
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 40, (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.5);
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 40, (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.5);
                }

            }
        }
    }