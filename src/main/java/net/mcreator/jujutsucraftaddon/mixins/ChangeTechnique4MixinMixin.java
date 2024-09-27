package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyChangeTechniqueOnKeyPressedProcedure.class)
public abstract class ChangeTechnique4MixinMixin {
    @Inject(
            method = {"execute"},
            at = {@At("TAIL")},
            cancellable = true,
            remap = false
    )
    private static void onExecute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity == null) {
            ci.cancel();
        }

        String name = "";
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
                if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                        && _plr25.getAdvancements().getOrStartProgress(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research"))).isDone() && entity instanceof ServerPlayer _plr26
                        && _plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained"))).isDone()) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
                        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .equals(Component.translatable("jujutsu.technique.attack3").getString())) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                                {
                                    double _setval = 10;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCurseTechnique2 = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Soul Blood"), false);
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
                                {
                                    double _setval = 1;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCurseTechnique2 = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Soul Shrine"), false);
                            }
                        }
                    } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                                {
                                    double _setval = 21;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCurseTechnique2 = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Itadori Mode"), false);
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 3) {
                                {
                                    double _setval = 1;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCurseTechnique2 = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Soul Shrine"), false);
                            }
                        }
                    } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
                        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                .contains(Component.translatable("jujutsu.technique.malevolent_shrine").getString())) {
                            if (entity.isShiftKeyDown()){
                                {
                                    double _setval = 21;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerCurseTechnique2 = _setval;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Itadori Mode"), false);

                            }
                        }
                    }
                }

                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                        .equals(Component.translatable("jujutsu.technique.malevolent_shrine").getString())) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Jujutsu Kaisen";
                        capability.syncPlayerVariables(entity);
                    });
                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                        .equals(Component.translatable("jujutsu.technique.dismantle").getString())) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Soul Dismantle";
                        capability.syncPlayerVariables(entity);
                    });
                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                        .equals(Component.translatable("jujutsu.technique.cleave").getString())) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Soul Cleave";
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

        }

    }
}
