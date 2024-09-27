package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.EntityTreeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.BlockDestroyAllDirectionProcedure;
import net.mcreator.jujutsucraft.procedures.MalevolentShrineActiveProcedure;
import net.mcreator.jujutsucraft.procedures.MeimeiDomainExpansionProcedure;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = MalevolentShrineActiveProcedure.class, remap = false)
public abstract class MalevolentShrineActiveMixin {
    public MalevolentShrineActiveMixin(){}
    /**
     * @author Satushi
     * @reason Changing Shrine
     */
    @Overwrite
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            String STR1;
            double x_pos;
            double y_pos;
            double z_pos;
            double range;
            double dis;
            double count_A;
            double var10000;
            int var10001;
            double num1;
            double num2;
            double x_center;
            double y_center;
            double z_center;
            double old_skill;
            double old_cooldown;
            double dust_amount;
            LivingEntity _livEnt;
            label158: {
                STR1 = "";
                boolean logic_a = false;
                boolean failed = false;
                boolean logic_attack = false;
                x_pos = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                range = 0.0;
                dis = 0.0;
                count_A = 0.0;
                num1 = 0.0;
                num2 = 0.0;
                x_center = 0.0;
                y_center = 0.0;
                z_center = 0.0;
                old_skill = 0.0;
                old_cooldown = 0.0;
                dust_amount = 0.0;
                double dust_amount_old = 0.0;
                var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label158;
                    }
                }

                var10001 = 0;
            }

            range = var10000 * (double)(var10001 > 0 ? 18 : 2);
            old_skill = entity.getPersistentData().getDouble("skill");
            old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
            entity.getPersistentData().putDouble("y_knockback", -0.1);

            for(int index0 = 0; index0 < 4; ++index0) {
                int var10002;
                CompoundTag var39;
                label149: {
                    num1 = count_A % 2.0 == 0.0 ? 1.0 : -1.0;
                    num2 = count_A % 4.0 <= 1.0 ? 1.0 : -1.0;
                    x_pos = entity.getPersistentData().getDouble("x_pos_doma") + range * 0.25 * num1;
                    y_pos = entity.getPersistentData().getDouble("y_pos_doma") + range * 0.25 - 15.0;
                    z_pos = entity.getPersistentData().getDouble("z_pos_doma") + range * 0.25 * num2;
                    var39 = entity.getPersistentData();
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                            var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                            break label149;
                        }


                    }

                    var10002 = 0;
                }

                var39.putDouble("skill", (double)(var10002 % 2 == 1 ? 105 : 106));
                entity.getPersistentData().putDouble("Damage", 10.5);
                entity.getPersistentData().putDouble("Range", range * 0.5);
                entity.getPersistentData().putDouble("effect", 1.0);
                entity.getPersistentData().putDouble("effectConfirm", 1.0);
                entity.getPersistentData().putDouble("knockback", (Math.random() - 0.5) * 0.1);
                entity.getPersistentData().putBoolean("swing", false);
                entity.getPersistentData().putBoolean("attack", false);
                entity.getPersistentData().putBoolean("DomainAttack", true);
                RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                ++count_A;
            }

            int var40;
            label141: {
                entity.getPersistentData().putDouble("y_knockback", 0.0);
                entity.getPersistentData().putDouble("skill", old_skill);
                entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var40 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label141;
                    }
                }

                var40 = 0;
            }

            if (var40 > 0) {
                if (entity.getPersistentData().getDouble("dust_amount") <= 0.0) {
                    entity.getPersistentData().putDouble("dust_amount", 1.0);
                }

                x_center = entity.getPersistentData().getDouble("x_pos_doma");
                y_center = entity.getPersistentData().getDouble("y_pos_doma");
                z_center = entity.getPersistentData().getDouble("z_pos_doma");
                num1 = 0.0;

                ServerLevel _level;
                int index3;
                for(index3 = 0; index3 < 512; ++index3) {
                    count_A = Math.toRadians(Math.random() * 360.0);
                    dis = range * 0.5 * (Math.random() * 2.0 - 1.0);
                    x_pos = x_center + Math.sin(count_A) * dis;
                    y_pos = y_center + Math.random() * range * 0.2;
                    z_pos = z_center + Math.cos(count_A) * dis;
                    if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                        entity.getPersistentData().putDouble("dust_amount", Math.min(entity.getPersistentData().getDouble("dust_amount") + 1.0, 200.0));
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 2, 1.5, 1.5, 1.5, 0.0);
                        }


                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
                                if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                                        && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone() && entity instanceof ServerPlayer _plr26
                                        && _plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()) {
                                    _level = (ServerLevel)world;
                                    _level.sendParticles((SimpleParticleType) JujutsucraftaddonModParticleTypes.KAI.get(), x_pos, y_pos, z_pos, 2, 1.5, 1.5, 1.5, 0.0);
                                    _level.sendParticles((SimpleParticleType) JujutsucraftaddonModParticleTypes.HAITI.get(), x_pos, y_pos, z_pos, 2, 1.5, 1.5, 1.5, 0.0);
                                }
                            }
                        } else if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_SLASH.get(), x_pos, y_pos, z_pos, 2, 1.5, 1.5, 1.5, 0.0);
                        }

                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 2, 1.5, 1.5, 1.5, 0.5);
                        }

                        entity.getPersistentData().putBoolean("noParticle", true);
                        entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                        entity.getPersistentData().putDouble("BlockRange", 16.0);
                        entity.getPersistentData().putDouble("BlockDamage", 99.0);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, Math.max(y_pos, y_center + 8.0), z_pos, entity);
                        if (num1 < 32.0 || num1 / 512.0 < Math.random()) {
                            break;
                        }
                    }

                    ++num1;
                }

                dust_amount = (double)Math.round(entity.getPersistentData().getDouble("dust_amount") / 200.0 * 10.0);
                if (entity instanceof Player) {
                    label117: {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                var40 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                break label117;
                            }
                        }

                        var40 = 0;
                    }

                    if (var40 % 10 == 0) {
                        String _setval = "DUST";
                        String final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.OVERLAY1 = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        _setval = "";
                        String final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.OVERLAY2 = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        STR1 = "§l§4";
                        num1 = 0.0;

                        for(int index2 = 0; index2 < 10; ++index2) {
                            if (num1 == dust_amount) {
                                STR1 = STR1 + "§r§7";
                            }

                            ++num1;
                            STR1 = STR1 + "■";
                        }

                        String finalSTR = STR1;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.OVERLAY2 = finalSTR;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }

                x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                if (entity.getPersistentData().getDouble("skill") == 107.0) {
                    for(index3 = 0; index3 < (int)(dust_amount + 1.0); ++index3) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.WHITE_ASH, x_pos, y_pos, z_pos, 50, range / 6.0, range / 6.0, range / 6.0, 0.5);
                        }
                    }
                } else {
                    for(index3 = 0; index3 < (int)(dust_amount + 1.0); ++index3) {
                        if (world instanceof ServerLevel) {
                            _level = (ServerLevel)world;
                            _level.sendParticles(ParticleTypes.ASH, x_pos, y_pos, z_pos, 50, range / 6.0, range / 6.0, range / 6.0, 0.5);
                        }
                    }
                }
            }

        }
    }
}
