package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.procedures.RangeAttackProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BFMasteryProcedure;
import net.mcreator.jujutsucraftaddon.procedures.BlackFlashedProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ItadoriClan2Procedure;
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
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

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
        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft"))  {
            if ((Math.random() <= 0.001 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance)) {
                if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED))) {
                    if (entity.getPersistentData().getDouble("cnt_bf") >= 50.0) {
                        return 0.001;
                    } else {
                        return 0.001;
                    }
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
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER)) {
                        if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
                            if (world instanceof Level _level6) {
                                if (!_level6.isClientSide()) {
                                    _level6.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1);
                                } else {
                                    _level6.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1, false);
                                }
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                        BlackFlashedProcedure.execute(world, x, y, z, entity);
                        BFMasteryProcedure.execute(entity);
                        entity.getPersistentData().putDouble("cnt_bf", 0);
                        ItadoriClan2Procedure.execute(world, entity);
                    }
                }
            } else {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER) == true) {
                    if (!((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.ZONE.get()))) {
                        if (world instanceof Level _level6) {
                            if (!_level6.isClientSide()) {
                                _level6.playSound(null, BlockPos.containing(x, y, z), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level6.playLocalSound(x, y, z, Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:blackflashtheme"))), SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                    }
                }
                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                    BlackFlashedProcedure.execute(world, x, y, z, entity);
                    BFMasteryProcedure.execute(entity);
                    entity.getPersistentData().putDouble("cnt_bf", 0);
                    ItadoriClan2Procedure.execute(world, entity);
                }
            }
        }
    }
}


