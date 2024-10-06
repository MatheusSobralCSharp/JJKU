package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.sounds.SoundSource;
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
import net.minecraftforge.registries.ForgeRegistries;
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

            if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()))){
                 if (entity.getPersistentData().getBoolean("HR")) {
                     Outline3Procedure.execute(world, x, y, z, entity);
                 }
            }


            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer != (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer
                    + (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEPlus){
                if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()))){
                    CEFixProcedure.execute(world, entity);
                }
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BGM){
                if (entity.level().getGameTime() % 7200 == 0) {
                    if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.MUSIC.get()))) {
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MUSIC.get(), 60, 1, false, false));
                    }
                }

            }


            if (entity.level().getGameTime() % 7200 == 0){
                if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                        && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
                    if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                            && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone())){
                        if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_VC.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_VC.get(), 60, 1, false, false));
                        }
                    }
                }
            }



            if (entity.getPersistentData().getBoolean("PRESS_BURNOUT")) {
                CounterBurnoutProcedure.execute(entity);
            }

            if (entity.getPersistentData().getBoolean("Meditation")) {
                MeditationPassiveProcedure.execute(world, entity);
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
                AutoRCTNewProcedure.execute(entity);
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                ExtensionTickProcedure.execute(world, x, y, z, entity);
            }
    }
}