package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.*;

@Mixin(value = KeyChangeTechniqueOnKeyPressedProcedure.class, remap = false)
public abstract class RedPowerMixin {
    public RedPowerMixin() {
    }

    /**
     * @author Sat
     * @reason Testing
     */

    @Overwrite
        public static void execute(LevelAccessor world,double x, double y, double z, Entity entity){
            if (entity != null) {
                double cost = 0.0;
                double old_select = 0.0;
                String name = "";
                if (entity instanceof Player) {
                    double _setval;
                    if (!((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).noChangeTechnique) {
                        _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique + (double) (entity.isShiftKeyDown() ? -1 : 1);
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechnique = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    String _setval1 = Component.translatable("jujutsu.overlay.cost").getString();
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.OverlayCost = _setval1;
                        capability.syncPlayerVariables(entity);
                    });
                    String _setval3 = Component.translatable("jujutsu.overlay.curse_power").getString();
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.OverlayCursePower = _setval3;
                        capability.syncPlayerVariables(entity);
                    });
                    LivingEntity _livEnt97;
                    ItemStack var33;
                    double var35;
                    if (Math.round(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique) > 10L) {
                        KeyChangeTechniqueOnKeyPressed2Procedure.execute(world, x, y, z, entity);
                    } else {
                        cost = 0.0;
                        name = "-----";

                        for (int index0 = 0; index0 < 52; ++index0) {
                            boolean _septal = false;
                            boolean final_septal1 = _septal;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PassiveTechnique = final_septal1;
                                capability.syncPlayerVariables(entity);
                            });
                            _septal = false;
                            boolean final_septal = _septal;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PhysicalAttack = final_septal;
                                capability.syncPlayerVariables(entity);
                            });
                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1.0) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique >= 0.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique <= 4.0) {
                                    long var10000 = Math.round(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique + 1.0);
                                    name = Component.translatable("jujutsu.technique.attack" + var10000).getString();
                                    cost = 0.0;
                                    _septal = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique <= 2.0;
                                    boolean final_septal2 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PhysicalAttack = final_septal2;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1.0) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                    name = Component.translatable("jujutsu.technique.dismantle").getString();
                                    cost = 100.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                    name = Component.translatable("jujutsu.technique.cleave").getString();
                                    cost = 100.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                    name = Component.translatable("jujutsu.technique.open").getString();
                                    cost = 500.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                    name = Component.translatable("jujutsu.technique.malevolent_shrine").getString();
                                    cost = 1250.0;
                                }
                            } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2.0) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                    _septal = true;
                                    boolean final_septal3 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PassiveTechnique = final_septal3;
                                        capability.syncPlayerVariables(entity);
                                    });
                                    name = Component.translatable("jujutsu.technique.infinity").getString();
                                    cost = 0.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                    name = Component.translatable("jujutsu.technique.blue").getString();
                                    cost = 250.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                    name = Component.translatable("jujutsu.technique.red").getString();
                                    cost = 500.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                                    name = Component.translatable("jujutsu.technique.purple").getString();
                                    cost = 1000.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                    name = Component.translatable("jujutsu.technique.unlimited_void").getString();
                                    cost = 1250.0;
                                }
                            } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 3.0) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                    name = Component.translatable("jujutsu.technique.explode").getString();
                                    cost = 400.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                    name = Component.translatable("jujutsu.technique.get_crushed").getString();
                                    cost = 250.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                    name = Component.translatable("jujutsu.technique.crumble_away").getString();
                                    cost = 500.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 8.0) {
                                    name = Component.translatable("jujutsu.technique.dont_move").getString();
                                    cost = 150.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 9.0) {
                                    name = Component.translatable("jujutsu.technique.blast_away").getString();
                                    cost = 300.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                    name = Component.translatable("effect.domain_expansion").getString();
                                    cost = 1000.0;
                                }
                            } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 4.0) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                    name = Component.translatable("jujutsu.technique.flame_fire").getString();
                                    cost = 180.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                    name = Component.translatable("jujutsu.technique.flame_fire2").getString();
                                    cost = 120.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                    name = Component.translatable("jujutsu.technique.ember_insects").getString();
                                    cost = 150.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 8.0) {
                                    name = Component.translatable("jujutsu.technique.flame_fire3").getString();
                                    cost = 150.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 9.0) {
                                    name = Component.translatable("jujutsu.technique.flame_fire4").getString();
                                    cost = 500.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                                    name = Component.translatable("jujutsu.technique.meteor").getString();
                                    cost = 1250.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                    name = Component.translatable("jujutsu.technique.coffinofthe_iron_mountain").getString();
                                    cost = 1250.0;
                                }
                            } else {
                                ServerPlayer _plr40;
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 5.0) {
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 3.0) {
                                        name = Component.translatable("jujutsu.technique.attack6").getString();
                                        cost = 50.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                        name = Component.translatable("jujutsu.technique.copy1").getString();
                                        cost = 500.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                        name = Component.translatable("advancements.skill_copy_dhruv_lakdawalla.title").getString();
                                        cost = 120.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                        name = Component.translatable("advancements.skill_copy_takako_uro.title").getString();
                                        cost = 200.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 10.0) {
                                        String var32;
                                        label506:
                                        {
                                            if (entity instanceof ServerPlayer) {
                                                _plr40 = (ServerPlayer) entity;
                                                if (_plr40.level() instanceof ServerLevel && _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_curseis_lifted"))).isDone()) {
                                                    var32 = "entity.jujutsucraft.rika_2";
                                                    break label506;
                                                }
                                            }

                                            var32 = "entity.jujutsucraft.rika";
                                        }

                                        name = Component.translatable(var32).getString();
                                        cost = 150.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                                        name = Component.translatable("entity.jujutsucraft.pure_love_cannon").getString();
                                        cost = 1000.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 19.0) {
                                        name = Component.translatable("jujutsu.technique.rika2").getString();
                                        cost = 0.0;
                                        _septal = true;
                                        boolean final_septal4 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PhysicalAttack = final_septal4;
                                            capability.syncPlayerVariables(entity);
                                        });
                                        _septal = false;
                                        boolean final_septal5 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal5;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                        name = Component.translatable("jujutsu.technique.okkotsu20").getString();
                                        cost = 1250.0;
                                    }
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6.0) {
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 4.0) {
                                        name = Component.translatable("jujutsu.technique.cancel").getString();
                                        cost = 0.0;
                                        _septal = true;
                                        boolean final_septal7 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PhysicalAttack = final_septal7;
                                            capability.syncPlayerVariables(entity);
                                        });
                                        _septal = true;
                                        boolean final_septal6 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal6;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                        name = Component.translatable("entity.jujutsucraft.divine_dog_white").getString();
                                        cost = 100.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                        name = Component.translatable("entity.jujutsucraft.divine_dog_black").getString();
                                        cost = 100.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique != 8.0) {
                                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 9.0) {
                                            name = Component.translatable("entity.jujutsucraft.great_serpent").getString();
                                            cost = 300.0;
                                        } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 10.0) {
                                            name = Component.translatable("entity.jujutsucraft.toad").getString();
                                            cost = 150.0;
                                        } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                            name = Component.translatable("entity.jujutsucraft.divine_dog_totality").getString();
                                            cost = 400.0;
                                        }
                                    } else {
                                        label548:
                                        {
                                            label492:
                                            {
                                                if (entity.isShiftKeyDown()) {
                                                    if (entity instanceof ServerPlayer) {
                                                        _plr40 = (ServerPlayer) entity;
                                                        if (_plr40.level() instanceof ServerLevel && _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_nue_titan"))).isDone()) {
                                                            break label492;
                                                        }
                                                    }

                                                    if (entity instanceof Player) {
                                                        Player _plr = (Player) entity;
                                                        if (_plr.getAbilities().instabuild) {
                                                            break label492;
                                                        }
                                                    }
                                                }

                                                name = Component.translatable("entity.jujutsucraft.nue").getString();
                                                cost = 250.0;
                                                break label548;
                                            }

                                            name = Component.translatable("entity.jujutsucraft.nue_totality").getString();
                                            cost = 500.0;
                                        }
                                    }

                                    ServerPlayer _plr64;
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 11.0) {
                                        label478:
                                        {
                                            label564:
                                            {
                                                if (entity.isShiftKeyDown()) {
                                                    label474:
                                                    {
                                                        label473:
                                                        {
                                                            if (entity instanceof ServerPlayer) {
                                                                _plr40 = (ServerPlayer) entity;
                                                                if (_plr40.level() instanceof ServerLevel && _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_max_elephant"))).isDone() && entity.getPersistentData().getDouble("TenShadowsTechnique7") >= 0.0) {
                                                                    break label473;
                                                                }
                                                            }

                                                            if (!(entity.getPersistentData().getDouble("TenShadowsTechnique7") > 0.0)) {
                                                                break label474;
                                                            }
                                                        }

                                                        if (entity instanceof ServerPlayer) {
                                                            _plr64 = (ServerPlayer) entity;
                                                            if (_plr64.level() instanceof ServerLevel && _plr64.getAdvancements().getOrStartProgress(_plr64.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_max_elephant_piercing_blood"))).isDone()) {
                                                                break label564;
                                                            }
                                                        }
                                                    }

                                                    if (entity instanceof Player) {
                                                        Player _plr = (Player) entity;
                                                        if (_plr.getAbilities().instabuild) {
                                                            break label564;
                                                        }
                                                    }
                                                }

                                                name = Component.translatable("entity.jujutsucraft.max_elephant").getString();
                                                cost = 750.0;
                                                break label478;
                                            }

                                            name = Component.translatable("jujutsu.technique.choso3").getString();
                                            cost = 200.0;
                                        }
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 12.0) {
                                        name = Component.translatable("entity.jujutsucraft.rabbit_escape").getString();
                                        cost = 125.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 13.0) {
                                        name = Component.translatable("entity.jujutsucraft.round_deer").getString();
                                        cost = 600.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 14.0) {
                                        name = Component.translatable("entity.jujutsucraft.piercing_ox").getString();
                                        cost = 400.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                                        name = Component.translatable("entity.jujutsucraft.tiger_funeral").getString();
                                        cost = 400.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 17.0) {
                                        name = Component.translatable("entity.jujutsucraft.merged_beast_agito").getString();
                                        cost = 600.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 18.0) {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt97 = (LivingEntity) entity;
                                            var33 = _livEnt97.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var33 = ItemStack.EMPTY;
                                        }

                                        if (var33.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                            name = Component.translatable("entity.jujutsucraft.eight_handled_swrod_divergent_sila_divine_general_mahoraga").getString();
                                            cost = 0.0;
                                        } else {
                                            label447:
                                            {
                                                label565:
                                                {
                                                    if (entity.isShiftKeyDown()) {
                                                        label443:
                                                        {
                                                            label442:
                                                            {
                                                                if (entity instanceof ServerPlayer) {
                                                                    _plr64 = (ServerPlayer) entity;
                                                                    if (_plr64.level() instanceof ServerLevel && _plr64.getAdvancements().getOrStartProgress(_plr64.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_mahoraga"))).isDone() && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 0.0) {
                                                                        break label442;
                                                                    }
                                                                }

                                                                if (!(entity.getPersistentData().getDouble("TenShadowsTechnique14") > 0.0)) {
                                                                    break label443;
                                                                }
                                                            }

                                                            if (entity instanceof ServerPlayer) {
                                                                ServerPlayer _plr67 = (ServerPlayer) entity;
                                                                if (_plr67.level() instanceof ServerLevel && _plr67.getAdvancements().getOrStartProgress(_plr67.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_mahoraga_wheel"))).isDone()) {
                                                                    break label565;
                                                                }
                                                            }
                                                        }

                                                        if (entity instanceof Player) {
                                                            Player _plr = (Player) entity;
                                                            if (_plr.getAbilities().instabuild) {
                                                                break label565;
                                                            }
                                                        }
                                                    }

                                                    name = Component.translatable("entity.jujutsucraft.eight_handled_swrod_divergent_sila_divine_general_mahoraga").getString();
                                                    cost = 1000.0;
                                                    break label447;
                                                }

                                                name = Component.translatable("item.jujutsucraft.mahoraga_wheel_helmet").getString();
                                                cost = 1000.0;
                                            }
                                        }
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                        name = Component.translatable("jujutsu.technique.chimera_shadow_garden").getString();
                                        cost = 1250.0;
                                    }
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7.0) {
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                        name = Component.translatable("jujutsu.technique.kashimo1").getString();
                                        cost = 200.0;
                                        _septal = true;
                                        boolean final_septal9 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PhysicalAttack = final_septal9;
                                            capability.syncPlayerVariables(entity);
                                        });
                                        _septal = true;
                                        boolean final_septal8 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal8;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 10.0) {
                                        name = Component.translatable("jujutsu.technique.kashimo2").getString();
                                        cost = 100.0;
                                        _septal = true;
                                        boolean final_septal11 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PhysicalAttack = final_septal11;
                                            capability.syncPlayerVariables(entity);
                                        });
                                        _septal = true;
                                        boolean final_septal10 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal10;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                                        name = Component.translatable("effect.mythical_beast_amber_effect").getString();
                                        cost = 0.0;
                                        _septal = true;
                                        boolean final_septal12 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal12;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }

                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 16.0) {
                                        name = Component.translatable("jujutsu.technique.kashimo_ah").getString();
                                        cost = 100.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 17.0) {
                                        name = Component.translatable("jujutsu.technique.kashimo_energy_wave").getString();
                                        cost = 250.0;
                                    }
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 8.0) {
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                        name = Component.translatable("jujutsu.technique.dagon1").getString();
                                        cost = 100.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                        name = Component.translatable("jujutsu.technique.dagon2").getString();
                                        cost = 150.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                        name = Component.translatable("jujutsu.technique.dagon3").getString();
                                        cost = 150.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 9.0) {
                                        name = Component.translatable("jujutsu.technique.dagon5").getString();
                                        cost = 250.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 10.0) {
                                        name = Component.translatable("entity.jujutsucraft.bathynomus_giganteus").getString();
                                        cost = 400.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                        name = Component.translatable("jujutsu.technique.dagon20").getString();
                                        cost = 1250.0;
                                    }
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 9.0) {
                                    label536:
                                    {
                                        boolean satushi;
                                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 4.0) {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt97 = (LivingEntity) entity;
                                                var33 = _livEnt97.getMainHandItem();
                                            } else {
                                                var33 = ItemStack.EMPTY;
                                            }

                                            if (var33.getItem() == JujutsucraftModItems.GARUDA_ITEM.get()) {
                                                satushi = true;
                                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                                    capability.PhysicalAttack = satushi;
                                                    capability.syncPlayerVariables(entity);
                                                });
                                                name = Component.translatable("jujutsu.technique.attack7").getString();
                                                cost = 50.0;
                                                break label536;
                                            }
                                        }

                                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                            if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity) entity;
                                                var33 = _livEnt.getMainHandItem();
                                            } else {
                                                var33 = ItemStack.EMPTY;
                                            }

                                            if (var33.getItem() == JujutsucraftModItems.GARUDA_ITEM_BALL.get()) {
                                                name = Component.translatable("jujutsu.technique.shoot").getString();
                                                cost = 500.0;
                                                break label536;
                                            }
                                        }

                                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                            name = Component.translatable("entity.jujutsucraft.garuda").getString();
                                            cost = 75.0;
                                        } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 10.0) {
                                            satushi = true;
                                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                                capability.PassiveTechnique = satushi;
                                                capability.syncPlayerVariables(entity);
                                            });
                                            name = Component.translatable("effect.star_rage").getString();
                                            cost = 0.0;
                                        } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                            name = Component.translatable("jujutsu.technique.tsukumo_domain").getString();
                                            cost = 1250.0;
                                        }
                                    }
                                } else {
                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 10.0) {
                                        name = "-----";
                                        cost = 0.0;
                                        break;
                                    }

                                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 5.0) {
                                        name = Component.translatable("jujutsu.technique.choso1").getString();
                                        cost = 120.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 6.0) {
                                        _septal = true;
                                        boolean final_septal13 = _septal;
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                            capability.PassiveTechnique = final_septal13;
                                            capability.syncPlayerVariables(entity);
                                        });
                                        name = Component.translatable("jujutsu.technique.choso2").getString();
                                        cost = 25.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 7.0) {
                                        name = Component.translatable("jujutsu.technique.choso3").getString();
                                        cost = 200.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 8.0) {
                                        name = Component.translatable("jujutsu.technique.choso4").getString();
                                        cost = 100.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 9.0) {
                                        byte var34;
                                        label404:
                                        {
                                            _septal = true;
                                            boolean final_septal14 = _septal;
                                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                                capability.PassiveTechnique = final_septal14;
                                                capability.syncPlayerVariables(entity);
                                            });
                                            name = Component.translatable("jujutsu.technique.choso5").getString();
                                            if (entity instanceof LivingEntity) {
                                                _livEnt97 = (LivingEntity) entity;
                                                if (_livEnt97.hasEffect((MobEffect) JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                                                    var34 = 0;
                                                    break label404;
                                                }
                                            }

                                            var34 = 100;
                                        }

                                        cost = (double) var34;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 16.0) {
                                        name = Component.translatable("jujutsu.technique.choso6").getString();
                                        cost = 400.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 18.0) {
                                        name = Component.translatable("item.jujutsucraft.wing_king_chestplate").getString();
                                        cost = 150.0;
                                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 20.0) {
                                        name = Component.translatable("effect.domain_expansion").getString();
                                        cost = 1250.0;
                                    }
                                }
                            }

                            if (name.equals("-----")) {
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique >= 0.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique <= 2.0) {
                                    var35 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
                                    name = Component.translatable("jujutsu.technique.attack" + Math.round(var35 + 1.0)).getString();
                                    _septal = true;
                                    boolean final_septal16 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PhysicalAttack = final_septal16;
                                        capability.syncPlayerVariables(entity);
                                    });
                                    cost = 10.0;
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 21.0) {
                                    name = Component.translatable("jujutsu.technique.cancel_domain").getString();
                                    _septal = true;
                                    boolean final_septal15 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PhysicalAttack = final_septal15;
                                        capability.syncPlayerVariables(entity);
                                    });
                                    cost = 0.0;
                                }
                            }

                            if (!name.equals("-----")) {
                                old_select = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
                                ChangeTechniqueTestProcedure.execute(world, x, y, z, entity);
                                if (old_select == ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique) {
                                    break;
                                }

                                name = "-----";
                            } else {
                                double _septal10 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique + (double) (entity.isShiftKeyDown() ? -1 : 1);
                                double final_septal17 = _septal10;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                    capability.PlayerSelectCurseTechnique = final_septal17;
                                    capability.syncPlayerVariables(entity);
                                });
                                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique < 0.0) {
                                    double _septal11 = 50.0;
                                    double final_septal18 = _septal11;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PlayerSelectCurseTechnique = final_septal18;
                                        capability.syncPlayerVariables(entity);
                                    });
                                    _septal = !((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique;
                                    boolean final_septal19 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.SecondTechnique = final_septal19;
                                        capability.syncPlayerVariables(entity);
                                    });
                                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique > 50.0) {
                                    double _septal5 = 0.0;
                                    double final_septal20 = _septal5;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.PlayerSelectCurseTechnique = final_septal20;
                                        capability.syncPlayerVariables(entity);
                                    });
                                    _septal = !((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique;
                                    boolean final_septal21 = _septal;
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                        capability.SecondTechnique = final_septal21;
                                        capability.syncPlayerVariables(entity);
                                    });
                                }
                            }
                        }

                        _setval = cost;
                        double final_setval2 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechniqueCostOrgin = final_setval2;
                            capability.syncPlayerVariables(entity);
                        });
                        String finalName = name;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechniqueName = finalName;
                            capability.syncPlayerVariables(entity);
                        });
                        _setval = cost;
                        double final_setval3 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechniqueCost = final_setval3;
                            capability.syncPlayerVariables(entity);
                        });
                        boolean _setval16 = false;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.noChangeTechnique = _setval16;
                            capability.syncPlayerVariables(entity);
                        });
                    }

                    int var10002;
                    LivingEntity _livEnt;
                    label537:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                                break label537;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt97 = (LivingEntity) entity;
                            if (_livEnt97.hasEffect((MobEffect) JujutsucraftModMobEffects.STAR_RAGE.get()) && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PhysicalAttack) {
                                label379:
                                {
                                    var35 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.STAR_RAGE.get())) {
                                            var10002 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                                            break label379;
                                        }
                                    }

                                    var10002 = 0;
                                }

                                _setval = (double) Math.round(var35 + (double) (9 * (var10002 + 1)));
                                double final_setval1 = _setval;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                    capability.PlayerSelectCurseTechniqueCost = final_setval1;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            _setval = (double) Math.round(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost * (double) (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_LEVEL)) /10 );
                            double final_setval2 = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PlayerSelectCurseTechniqueCost = final_setval2;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                            label363:
                            {
                                var35 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost;
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                                        var10002 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get()).getAmplifier();
                                        break label363;
                                    }
                                }

                                var10002 = 0;
                            }

                            _setval = (double) Math.round(var35 * Math.pow((double) (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SIX_EYES_LEVEL)) /10, (double) (var10002 + 1)));
                            double final_setval3 = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PlayerSelectCurseTechniqueCost = final_setval3;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entity;
                        var33 = _livEnt.getMainHandItem();
                    } else {
                        var33 = ItemStack.EMPTY;
                    }

                    if (var33.getItem() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                        if (entity instanceof LivingEntity) {
                            _livEnt97 = (LivingEntity) entity;
                            var33 = _livEnt97.getMainHandItem();
                        } else {
                            var33 = ItemStack.EMPTY;
                        }

                        if (!var33.getOrCreateTag().getBoolean("Used")) {
                            _setval = 0.0;
                            double final_setval = _setval;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PlayerSelectCurseTechniqueCost = final_setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                    }
                }

            }
        }
    }
