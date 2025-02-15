package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerTickSecondTechniqueProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlayerTickSecondTechniqueProcedure.class, priority = -10000)
public abstract class PlayerSecondTechniqueMixin {
    public PlayerSecondTechniqueMixin() {
    }

    /**
     * @author Satushi
     * @reason Changes How Second Technique Works
     */


    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double old_select = 0.0;
            double old_technique = 0.0;
            boolean changeTechnique = false;
            boolean switched = false;
            boolean old_second = false;

            for (int index0 = 0; index0 < 2; ++index0) {
                old_second = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).SecondTechnique;
                changeTechnique = false;
                ItemStack var10000;
                if (entity instanceof LivingEntity _livEnt) {
                    var10000 = _livEnt.getMainHandItem();
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                label72:
                {
                    double _setval;
                    if (var10000.getItem() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                        if (entity instanceof LivingEntity _livEnt) {
                            var10000 = _livEnt.getMainHandItem();
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        if (!var10000.getOrCreateTag().getBoolean("Used")) {
                            boolean _setval3 = true;
                            boolean final_setval1 = _setval3;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                capability.SecondTechnique = final_setval1;
                                capability.syncPlayerVariables(entity);
                            });
                            old_second = true;
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != 3.0 || entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerSelectCurseTechniqueCost > 0.0) {
                                _setval = 3.0;
                                double final_setval2 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique = final_setval2;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label72;
                        }
                    }

                    if (entity instanceof LivingEntity _livEnt4) {
                        if (_livEnt4.hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).SecondTechnique && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != 1.0) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != 1.0) {
                                _setval = 1.0;
                                double final_setval3 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique = final_setval3;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label72;
                        }
                    }

                    if (entity instanceof LivingEntity _livEnt4) {
                        if (_livEnt4.hasEffect(JujutsucraftaddonModMobEffects.SECOND_TECHNIQUE_EFFECT.get()) && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).SecondTechnique && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique) {
                                _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique;
                                double final_setval3 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique = final_setval3;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label72;
                        }
                    }

                    if (entity instanceof LivingEntity _livEnt4) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondAllowed && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).SecondTechnique && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique) {
                                _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SecondTechnique;
                                double final_setval3 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                    capability.PlayerCurseTechnique = final_setval3;
                                    capability.syncPlayerVariables(entity);
                                });
                                changeTechnique = true;
                            }
                            break label72;
                        }
                    }

                    boolean _setval2 = false;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                        capability.SecondTechnique = _setval2;
                        capability.syncPlayerVariables(entity);
                    });
                    old_second = false;
                    if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2) {
                        _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2;
                        double final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.PlayerCurseTechnique = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        changeTechnique = true;
                    }
                }

                if (!changeTechnique) {
                    break;
                }

                double _setval = entity.isShiftKeyDown() ? 50.0 : 0.0;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.PlayerSelectCurseTechnique = _setval;
                    capability.syncPlayerVariables(entity);
                });
                boolean _setval3 = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval3;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                if (old_second == entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).SecondTechnique) {
                    break;
                }
            }

        }
    }
}
