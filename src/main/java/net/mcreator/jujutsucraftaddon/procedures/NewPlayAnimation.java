package net.mcreator.jujutsucraftaddon.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.CooldownTimeEffectExpiresProcedure;
import net.mcreator.jujutsucraft.procedures.CooldownTimeEffectStartedappliedProcedure;
import net.mcreator.jujutsucraft.procedures.CooldownTimeOnEffectActiveTickProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationEntityProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class NewPlayAnimation {
    public static void execute(Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
        if (damagesource != null && entity != null) {
            if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation")))) {
                boolean sword = false;
                Entity entiry_a = null;
                String STR1 = "";
                double rnd = 0.0;
                double NUM1 = 0.0;
                double NUM2 = 0.0;
                double NUM3 = 0.0;
                entiry_a = entity;
                LivingEntity _livEnt;
                ItemStack var10000;
                ModifierLayer animation;
                LivingEntity _living;
                AbstractClientPlayer player;


                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                    // Ab Animations
                    if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_1.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab1player"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_2.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab2player"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get()) && (!(((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())))) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_GOJO.get())) {
                        if ((entiry_a.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 4) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "murasaki2"))));
                            }
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_3.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab3player"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIM_4.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "ab4player"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("dodge" + Mth.nextInt(RandomSource.create(), 1, 21))))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.JACKPOT.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "tucadonca"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "soka"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("counterhr" + Mth.nextInt(RandomSource.create(), 1, 7))))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "heianform"))));
                        }
                        return;
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_CUT.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 2
                                || (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 3) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "rapiddismantle"))));
                                }
                                return;
                            } else {


                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "maximum3"))));
                                }
                                return;

                            }

                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 1) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "spiderwebanim"))));
                                }
                                return;
                            }

                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Moveset == 4) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("worldslash" + Mth.nextInt(RandomSource.create(), 1, 4))))));
                                }
                                return;
                            }
                        }
                    } else if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get())) {
                        player = (AbstractClientPlayer) entiry_a;
                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki >= 1
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki < 20) {
                            if (world.isClientSide()) {
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "swordnpc"))));
                                }
                            }


                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationYuzuki = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationYuzuki >= 20) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationYuzuki = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 1) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword4"))));
                                    }
                                }
                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 2) {
                            if (world.isClientSide()) {

                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword3"))));
                                }

                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 3) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "defensesword2"))));
                                    }
                                }
                            }

                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 4
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 24) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "red"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 24) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 106
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 116) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "cleaveweb"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 116) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense >= 99
                                && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense < 109) {
                            if (world.isClientSide()) {
                                if (entity instanceof AbstractClientPlayer) {
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "barragekick"))));
                                    }
                                }
                            }

                            {
                                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense + 1;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).AnimationDefense == 109) {
                            {
                                double _setval = 0;
                                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.AnimationDefense = _setval;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }
                    }

                    if (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get())) {
                        if ((entiry_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 1) {
                            player = (AbstractClientPlayer) entiry_a;
                            if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("kusakabe"))) {
                                if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).contains("nyoi"))) {
                                    if (!((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")
                                            || (ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud"))) {
                                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                                            if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {

                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                                }
                                                return;

                                            } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 10))))));
                                                }
                                                return;


                                            }
                                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                                            if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {

                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                                }
                                                return;


                                            } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 10, 24))))));
                                                }


                                            }
                                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                                            if ((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {

                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 39))))));
                                                }
                                                return;


                                            } else if (!((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                                    || (entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {


                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
                                                }


                                            }
                                        }
                                    } else if ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")) {
                                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                                            if (world.isClientSide()) {

                                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                                if (animation != null && !animation.isActive()) {
                                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                                }

                                            }

                                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {


                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                            }


                                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {

                                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                            if (animation != null && !animation.isActive()) {
                                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 5))))));
                                            }


                                        }
                                    } else if ((ForgeRegistries.ITEMS.getKey((entiry_a instanceof LivingEntity _livEnt2 ? _livEnt2.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {


                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
                                        }


                                    }
                                } else {


                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("nyoi" + Mth.nextInt(RandomSource.create(), 1, 9))))));
                                    }


                                }
                            } else {


                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("kusa" + Mth.nextInt(RandomSource.create(), 1, 6))))));
                                }


                            }
                        } else {

                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sukuna" + Mth.nextInt(RandomSource.create(), 1, 26))))));
                            }


                        }
                    }
                }

                if (!(((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.SOKA_MONA.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_TWO.get())) || (((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.ANIMATION_HEIAN.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.JACKPOT.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.DODGE.get()) || ((LivingEntity) entiry_a).hasEffect(JujutsucraftaddonModMobEffects.WORLD_CUT.get()))) {
                    if (entiry_a instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entiry_a;
                        var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    NUM1 = var10000.getOrCreateTag().getDouble("P_ANIME1");
                    if (entiry_a instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entiry_a;
                        var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    NUM2 = var10000.getOrCreateTag().getDouble("P_ANIME2");
                    if (NUM1 <= -50.0 && NUM1 >= -100.0) {
                        NUM1 += 100.0;
                    }

                    NUM3 = NUM1 >= 0.0 ? NUM1 % 100.0 : 100.0;
                    STR1 = Math.random() > 0.5 ? "right" : "left";
                    if (NUM3 >= 0.0 && NUM3 <= 4.0) {
                        if (entiry_a instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entiry_a;
                            var10000 = _livEnt.getMainHandItem();
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        boolean var24;
                        label426:
                        {
                            if (!(var10000.getItem() instanceof SwordItem)) {
                                if (entiry_a instanceof LivingEntity) {
                                    _living = (LivingEntity) entiry_a;
                                    var10000 = _living.getMainHandItem();
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                if (!(var10000.getItem() instanceof AxeItem)) {
                                    if (entiry_a instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entiry_a;
                                        var10000 = _livEnt.getMainHandItem();
                                    } else {
                                        var10000 = ItemStack.EMPTY;
                                    }

                                    if (!var10000.is(ItemTags.create(new ResourceLocation("forge:sword_type")))) {
                                        if (entiry_a instanceof LivingEntity) {
                                            _livEnt = (LivingEntity) entiry_a;
                                            var10000 = _livEnt.getMainHandItem();
                                        } else {
                                            var10000 = ItemStack.EMPTY;
                                        }

                                        if (!var10000.is(ItemTags.create(new ResourceLocation("forge:sword")))) {
                                            if (entiry_a instanceof LivingEntity) {
                                                _livEnt = (LivingEntity) entiry_a;
                                                var10000 = _livEnt.getMainHandItem();
                                            } else {
                                                var10000 = ItemStack.EMPTY;
                                            }

                                            if (!var10000.is(ItemTags.create(new ResourceLocation("forge:whip")))) {
                                                var24 = false;
                                                break label426;
                                            }
                                        }
                                    }
                                }
                            }

                            var24 = true;
                        }


                        sword = var24;
                        if (NUM3 != 0.0 && NUM3 != 2.0 && NUM3 != 3.0) {
                            if (NUM3 == 1.0) {
                                if (sword) {
                                    if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                        player = (AbstractClientPlayer) entiry_a;
                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                        if (animation != null) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_right"))));
                                        }
                                    }
                                } else if (Math.random() > 0.5) {
                                    if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                        player = (AbstractClientPlayer) entiry_a;
                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                        if (animation != null) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_" + STR1))));
                                        }
                                    }
                                } else {
                                    rnd = Math.ceil(Math.random() * 3.0);
                                    if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                        player = (AbstractClientPlayer) entiry_a;
                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                        if (animation != null) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", rnd == 1.0 ? "punch_both" : "punch_" + STR1))));
                                        }
                                    }
                                }
                            } else if (NUM3 == 4.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_overhead"))));
                                }
                            }
                        } else if (NUM2 != 0.0 && !(NUM2 >= 100.0)) {
                            if (NUM2 % 2.0 == 1.0) {
                                if (sword) {
                                    rnd = Math.ceil(Math.random() * 3.0);
                                    if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                        player = (AbstractClientPlayer) entiry_a;
                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                        if (animation != null) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", rnd == 1.0 ? "sword_overhead" : "sword_to_" + STR1))));
                                        }
                                    }
                                } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "punch_" + STR1))));
                                    }
                                }
                            }
                        } else if (sword) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_" + STR1))));
                                }
                            }
                        } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                String var10006 = Math.random() > 0.5 ? "kick_" : "punch_";
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", var10006 + STR1))));
                            }
                        }
                    } else if (NUM3 == 20.0) {
                        if (NUM1 == 220.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "red"))));
                                }
                            }
                        } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "domain_expansion1"))));
                            }
                        }
                    } else if (NUM1 < 0.0) {
                        if (NUM1 >= -5.0) {
                            if (NUM1 == -1.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "backstep"))));
                                    }
                                }
                            } else if (NUM1 == -2.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "death"))));
                                    }
                                }
                            } else if (NUM1 == -3.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "right_arm_up"))));
                                    }
                                }
                            } else if (NUM1 == -4.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                        player = (AbstractClientPlayer) entiry_a;
                                        animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                        if (animation != null) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "both_arm_front"))));
                                        }
                                    }
                                }
                            } else if (NUM1 == -5.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_right"))));
                                }
                            }
                        } else if (NUM1 >= -10.0) {
                            if (NUM1 == -6.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_" + STR1))));
                                    }
                                }
                            } else if (NUM1 == -7.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "punch_" + STR1))));
                                    }
                                }
                            } else if (NUM1 == -8.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "rotation"))));
                                    }
                                }
                            } else if (NUM1 == -9.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "guard"))));
                                    }
                                }
                            } else if (NUM1 == -10.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "fall1"))));
                                }
                            }
                        } else if (NUM1 >= -15.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "dance" + Math.round(NUM1 + 16.0)))));
                                }
                            }
                        } else if (NUM1 >= -20.0) {
                            if (NUM1 == -16.0) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer) entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "simple_domain1"))));
                                    }
                                }
                            } else if (NUM1 == -17.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "simple_domain2"))));
                                }
                            }
                        }
                    } else {
                        if (NUM1 == 107.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "open"))));
                                }
                            }
                        } else if (NUM1 == 207.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "red"))));
                                }
                            }
                        } else if (NUM1 == 618.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "ten_shadows_technique_mahoraga"))));
                            }
                        }

                        if (NUM1 == 1706.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_flying"))));
                                }
                            }
                        } else if (NUM1 == 1715.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer) entiry_a;
                                animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "wifi"))));
                                }
                            }
                        } else if (NUM1 == 2015.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer) entiry_a;
                            animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "plus_ultra"))));
                            }
                        }
                    }
                }

                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME1", 0.0);
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity) entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                if (var10000.getItem() == ((Block) JujutsucraftModBlocks.IN_BARRIER.get()).asItem()) {
                    Entity _entity = entiry_a;
                    if (_entity instanceof Player) {
                        Player _player = (Player) _entity;
                        _player.getInventory().armor.set(3, ItemStack.EMPTY);
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity) {
                        _living = (LivingEntity) _entity;
                        _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                    }
                }

                if (event != null && event.isCancelable()) {
                    event.setCanceled(true);
                }
            }

        }
    }
}
