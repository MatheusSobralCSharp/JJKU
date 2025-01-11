package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.SukunaFingerFoodEatenProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.CongratulationsProcedure;
import net.mcreator.jujutsucraftaddon.procedures.FingerEatedProcedure;
import net.mcreator.jujutsucraftaddon.procedures.RejectProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SukunaFingerFoodEatenProcedure.class, priority = 3000)
public abstract class SukunaFingerFoodEatenProcedureMixin {

    /**
     * @author Satushi
     * @reason Changing Finger when used for the first time, add animations and spawn Sukuna at the first time
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            boolean success = false;
            boolean sukuna = false;
            double num1 = 0.0;
            double cursed_technique = 0.0;
            double num2 = 0.0;
            double level_control = 0.0;
            double tick = 0.0;
            double cursed_technique2 = 0.0;
            LivingEntity _livEnt33;
            LivingEntity _livEnt36;

            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
                    || (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21
                    || (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1 || (entity instanceof Player _plr && _plr.getAbilities().instabuild)) {
                if (!(entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                        && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone())) {
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
                        if (Math.random() < (1) / ((float) 2)) {
                            FingerEatedProcedure.execute(world, x, y, z, entity);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_SPAWNING.get(), 60, 1, false, false));

                        } else {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HAHAHAHA.get(), 120, 254, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 254, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 254, false, false));
                            RejectProcedure.execute(world, x, y, z, entity);
                        }
                    } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
                        if (Math.random() < (1) / ((float) 3)) {
                            FingerEatedProcedure.execute(world, x, y, z, entity);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_SPAWNING.get(), 60, 1, false, false));
                        } else {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HAHAHAHA.get(), 120, 254, false, false));

                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 254, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 254, false, false));

                            RejectProcedure.execute(world, x, y, z, entity);
                        }
                    } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Trait).equals("The Fallen One")) {
                        FingerEatedProcedure.execute(world, x, y, z, entity);
                    } else if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Perfect Vessel")) {
                        if (Math.random() < (1) / ((float) 3)) {
                            FingerEatedProcedure.execute(world, x, y, z, entity);
                        }
                    } else {
                        if (Math.random() < (5) / ((float) 100)) {
                            FingerEatedProcedure.execute(world, x, y, z, entity);
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_SPAWNING.get(), 60, 1, false, false));
                        } else {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HAHAHAHA.get(), 120, 254, false, false));

                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 254, false, false));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 120, 254, false, false));
                            RejectProcedure.execute(world, x, y, z, entity);
                        }
                    }
                } else {
                    FingerEatedProcedure.execute(world, x, y, z, entity);
                }
            }  else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Nuh Uh"), false);
                CongratulationsProcedure.execute(world, x, y, z);
            }

        }
        ci.cancel();
    }
}
