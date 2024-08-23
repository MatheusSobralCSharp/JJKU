package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BFMasteryProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BlackFlashedProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.Objects;

@Mixin(value = RangeAttackProcedure.class)
public abstract class OverlayMixin {

    public OverlayMixin() {
    }


    @ModifyConstant(
            method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V",
            constant = @Constant(doubleValue = 0.998),
            remap = false
    )
    private static double injection(double constant, LevelAccessor world, double x, double y, double z, Entity entity) {
        if ((Math.random() <= 0.001 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance)) {
            if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                    return 0.001;
                }
            } else if (!(world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                return 0.001;
            }
        }
        return 0.998;
    }

    @Inject(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getCapability(Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;", ordinal = 5), remap = false)
    private static void injectProcedure(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
            if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
                    if (world instanceof Level _level6) {
                        if (!_level6.isClientSide()) {
                            _level6.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level6.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
                BlackFlashedProcedure.execute(world, x, y, z, entity);
                BFMasteryProcedure.execute(entity);
                entity.getPersistentData().putDouble("cnt_bf", 0);
            }
        } else {
            if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
                if (world instanceof Level _level6) {
                    if (!_level6.isClientSide()) {
                        _level6.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level6.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            }
            BlackFlashedProcedure.execute(world, x, y, z, entity);
            BFMasteryProcedure.execute(entity);
            entity.getPersistentData().putDouble("cnt_bf", 0);
        }
    }
}


