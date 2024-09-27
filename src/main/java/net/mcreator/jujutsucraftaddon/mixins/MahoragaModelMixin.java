package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.mcreator.jujutsucraft.procedures.PlayerTickSecondTechniqueProcedure;
import net.mcreator.jujutsucraftaddon.procedures.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.LiquidBlock;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Objects;


@Mixin(value = PlayerTickSecondTechniqueProcedure.class)
public abstract class MahoragaModelMixin {
    public MahoragaModelMixin() {
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {

       if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).water == 1) {
           BlockPos belowPos = entity.blockPosition().below();
           FluidState fluidStateBelow = entity.level().getFluidState(belowPos);
           boolean isJustAboveWater = ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() instanceof LiquidBlock);
           if (isJustAboveWater && !entity.isInWater()) {
               if (entity.getDeltaMovement().y() <= 0) {
                   entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
                   entity.setOnGround(true);
                   entity.setPos(entity.getX(), belowPos.getY() + 1.0, entity.getZ());

               }
           }
       }

       //Holding Key Stuff
       if (entity.getPersistentData().getBoolean("HR")) {
           Outline3Procedure.execute(world, x, y, z, entity);
       }

        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer != (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer
                + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEPlus) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 200) {
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer
                            + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEPlus);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePowerFormer = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * 20);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePowerMAX = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer == 400) {
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer
                            + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEPlus);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePowerFormer = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
                {
                    double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer * 20);
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerCursePowerMAX = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        }





        if (entity.getPersistentData().getBoolean("PRESS_BURNOUT")) {
            CounterBurnoutProcedure.execute(entity);
        }

        if (entity.getPersistentData().getBoolean("Meditation")) {
            MeditationPassiveProcedure.execute(world, entity);
        }

        if (entity.isSprinting()) {
            AnimationsProcedure.execute(world, entity);
        }

        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
            AutoRCTNewProcedure.execute(entity);
        }

        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
            ExtensionTickProcedure.execute(world, x, y, z, entity);
        }

        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2) == -1) {
            if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.REGENERATION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
            }
        } else if (entity.getPersistentData().getDouble("CursedSpirit") == 1 && entity.getPersistentData().getDouble("CurseUser") == 0 ) {
            if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RCT)) {
                if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Disaster Curses")) {
                    if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.REGENERATION))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 3, false, false));
                    }
                } else {
                    if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(MobEffects.REGENERATION))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
                    }
                }
            }
        }
    }
}