package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.effect.MobEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(value = SimpleDomainEffectStartedappliedProcedure.class, remap = false)
public abstract class SimpleDomainVowMixin {
    public SimpleDomainVowMixin(){
    }
    /**
     * @author Satushi
     * @reason Change Simple Domain Logic To Upgrade Range
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            double x_pos;
            double y_pos;
            double z_pos;
            double num1;
            double num2;
            int var10000;
            label44: {
                x_pos = 0.0;
                y_pos = 0.0;
                z_pos = 0.0;
                num1 = 0.0;
                num2 = 0.0;
                double num3 = 0.0;
                double pitch = 0.0;
                double yaw = 0.0;
                double tick = 0.0;
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                        break label44;
                    }
                }

                var10000 = 0;
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleQuest == 4) {
                if (entity.getPersistentData().getDouble("cnt_simpledomain") < 18000.0) {
                    label68 : {
                        entity.getPersistentData().putDouble("cnt_simpledomain", entity.getPersistentData().getDouble("cnt_m") + 1.0);
                    }
                } else if (entity.getPersistentData().getDouble("cnt_simpledomain") == 18000.0) {
                    if (entity instanceof ServerPlayer _player) {
                        Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:perfect_simple_domain"));
                        AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            for (String criteria : _ap.getRemainingCriteria())
                                _player.getAdvancements().award(_adv, criteria);
                        }
                    }

                    {
                        double _setval = 3;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.SimpleDomainLevel = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    {
                        double _setval = 5;
                        entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.SimpleQuest = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                }

            }

            if (var10000 > 0) {
                int var10002;
                double var30;
                label37: {
                    num1 = Math.toRadians(Math.random() * 360.0);
                    var30 = (double)entity.getBbWidth();
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                            var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                            break label37;
                        }
                    }

                    var10002 = 0;
                }

                num2 = var30 + 0.025 * (double)var10002;
                num2 = Math.min(num2, entity.getPersistentData().getDouble("skill") == 3105.0 ? 16.0 : 4.0);
                double num3 = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomainLevel;

                for(int index0 = 0; index0 < 72; ++index0) {
                    x_pos = x + Math.sin(num1) * num2 * num3;
                    y_pos = y;
                    z_pos = z + Math.cos(num1) * num2 * num3;
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.749 0.984 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                    }

                    num1 += Math.toRadians(Math.random() * 10.0);
                }
            }

        }
    }
}