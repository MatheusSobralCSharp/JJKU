package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = KeyChangeTechniqueOnKeyPressedProcedure.class, priority = 3000)
public abstract class KeyChangeTechniqueOnKeyPressedProcedureMixin {

    /**
     * @author Satushi
     * @reason Adds The Other CT's and changes the proprieties of them
     */

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

        if ((Objects.requireNonNull(entity).getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 2) {
            if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get()))
                    && ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get(), -1, 1, false, false));
                }
            }
        } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 1) {
            if (!(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get()))
                    && ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
                if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OVERPOWERED_STUFF)) {
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_POWERS.get(), -1, 1, false, false));
                }
            }
        }

        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                .equals(Component.translatable("jujutsu.technique.purple").getString())) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 5) && ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
                if (entity.isShiftKeyDown()) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialogueun").getString());
                        capability.syncPlayerVariables(entity);
                    });
                } else {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguepurple").getString());
                        capability.syncPlayerVariables(entity);
                    });
                }
            }

        }


        String name = "";
        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Itadori")) {
                if (entity instanceof ServerPlayer _plr25 && _plr25.level() instanceof ServerLevel
                        && _plr25.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr25.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:soul_research")))).isDone() && entity instanceof ServerPlayer _plr26
                        && _plr26.level() instanceof ServerLevel && _plr26.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr26.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained")))).isDone()) {
                    if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .equals(Component.translatable("jujutsu.technique.malevolent_shrine").getString())) {
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerSelectCurseTechniqueName = "Jujutsu Kaisen";
                            capability.syncPlayerVariables(entity);
                        });
                    } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .equals(Component.translatable("jujutsu.technique.dismantle").getString())) {
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguesoul1").getString());
                            capability.syncPlayerVariables(entity);
                        });
                    } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .equals(Component.translatable("jujutsu.technique.cleave").getString())) {
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                            capability.PlayerSelectCurseTechniqueName = (Component.translatable("dialoguesoul2").getString());
                            capability.syncPlayerVariables(entity);
                        });
                    }

                }
            }

        }

        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
            if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                    .equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Mahito Clone";
                        capability.syncPlayerVariables(entity);
                    });
                }

                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Ice Clone";
                        capability.syncPlayerVariables(entity);
                    });
                }

                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 14) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Wood Clone";
                        capability.syncPlayerVariables(entity);
                    });
                }

                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 8) {
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.PlayerSelectCurseTechniqueName = "Water Clone";
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        }

        if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2) == -1) {
            if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.REGENERATION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, -1, 2, false, false));
            }
        } else if (entity.getPersistentData().getDouble("CursedSpirit") == 1 && entity.getPersistentData().getDouble("CurseUser") == 0) {
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

    @ModifyConstant(
            method = "execute",
            constant = @Constant(doubleValue = 0.1),
            remap = false
    )
    private static double modifyConstant(double constant, LevelAccessor world) {
        if (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SIX_EYES_LEVEL) > 1) {
            return (double) world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SIX_EYES_LEVEL) / 10;
        } else {
            return 0.1;
        }
    }

    @Inject(method = "execute(Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V", at = @At("RETURN"), remap = false)
    private static void modifyCurseTechniqueCost(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo cir) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                if (livingEntity.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                    double newCost = Math.round(capability.PlayerSelectCurseTechniqueCost * (double) (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_LEVEL)) / 10);
                    capability.PlayerSelectCurseTechniqueCost = newCost;
                    capability.syncPlayerVariables(entity);
                }
            });
        }
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7.0) {
            if (entity.isShiftKeyDown()) {
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                    String name = Component.translatable("jujutsu.technique.kashimo_domain").getString();
                    double cost = 200.0;
                    boolean _setval = false;

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PhysicalAttack = _setval;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PassiveTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechniqueCost = cost;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechnique = 20;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechniqueName = name;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        }
    }

}
