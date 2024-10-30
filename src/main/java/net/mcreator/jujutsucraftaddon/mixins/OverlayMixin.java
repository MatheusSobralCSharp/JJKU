package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.BFMasteryProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BlackFlashedProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ItadoriClan2Procedure;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = RangeAttackProcedure.class)
public abstract class OverlayMixin {

    public OverlayMixin() {
    }


    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 0.998),
            remap = false
    )
    private static double injection(double constant, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString().startsWith("jujutsucraft")) {

            if (Math.random() < ((float) (((JujutsucraftaddonModVariables.PlayerVariables) entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance)) / ((float) 1000)) {
                if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                    if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                        return 0.001;
                    }
                } else {
                    return 0.001;
                }
            }
        }

        return constant;
    }


    @Inject(method = "execute",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;getCapability(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;",
                    ordinal = 4),
            remap = false)
    private static void injectProcedure(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft"))  {
            if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                        BlackFlashedProcedure.execute(world, x, y, z, entity);
                        BFMasteryProcedure.execute(entity);
                        entity.getPersistentData().putDouble("cnt_bf", 0);
                        ItadoriClan2Procedure.execute(world, entity);
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ImpactFramesVariable == 0) {
                            if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.OUT_LINER.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.OUT_LINER.get(), Mth.nextInt(RandomSource.create(), 10, 20), 1, false, false));

                            }
                        }

                    }
                }
            } else {
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                    BlackFlashedProcedure.execute(world, x, y, z, entity);
                    BFMasteryProcedure.execute(entity);
                    entity.getPersistentData().putDouble("cnt_bf", 0);
                    ItadoriClan2Procedure.execute(world, entity);

                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ImpactFramesVariable == 0) {
                        if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(JujutsucraftaddonModMobEffects.OUT_LINER.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.OUT_LINER.get(), Mth.nextInt(RandomSource.create(), 10, 20), 1, false, false));

                        }
                    }
                }
            }
        }
    }
}


