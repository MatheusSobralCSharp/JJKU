package net.mcreator.jujutsucraftaddon.mixins;

import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.mcreator.jujutsucraft.entity.BlueEntity;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.entity.PurpleEntity;
import net.mcreator.jujutsucraft.entity.RedEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import javax.annotation.Nullable;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;
import javax.print.attribute.standard.Severity;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = PlayAnimationIfPossibleProcedure.class, remap = false)
public abstract class AnimationProcedureMixin {
    public AnimationProcedureMixin() {

    }
    /**
     * @author Sat
     * @reason None
     */
    @Overwrite

    private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity) {
        if (damagesource != null && entity != null) {
            boolean sword = false;
            Entity entiry_a = null;
            String STR1 = "";
            double rnd = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            double NUM3 = 0.0;
            if (damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:start_animation")))) {
                entiry_a = entity;
                LivingEntity _livEnt;
                ItemStack var10000;
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                NUM1 = var10000.getOrCreateTag().getDouble("P_ANIME1");
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entiry_a;
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
                ModifierLayer animation;
                LivingEntity _living;
                AbstractClientPlayer player;
                if (NUM3 >= 0.0 && NUM3 <= 4.0) {
                    if (entiry_a instanceof LivingEntity) {
                        _livEnt = (LivingEntity) entiry_a;
                        var10000 = _livEnt.getMainHandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    boolean var24;
                    label426: {
                        if (!(var10000.getItem() instanceof SwordItem)) {
                            if (entiry_a instanceof LivingEntity) {
                                _living = (LivingEntity)entiry_a;
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
                                            _livEnt = (LivingEntity)entiry_a;
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
                                    player = (AbstractClientPlayer)entiry_a;
                                    animation = (ModifierLayer) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_right"))));
                                    }
                                }
                            } else if (Math.random() > 0.5) {
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer)entiry_a;
                                    animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_" + STR1))));
                                    }
                                }
                            } else {
                                rnd = Math.ceil(Math.random() * 3.0);
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer)entiry_a;
                                    animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", rnd == 1.0 ? "punch_both" : "punch_" + STR1))));
                                    }
                                }
                            }
                        } else if (NUM3 == 4.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_overhead"))));
                            }
                        }
                    } else if (NUM2 != 0.0 && !(NUM2 >= 100.0)) {
                        if (NUM2 % 2.0 == 1.0) {
                            if (sword) {
                                rnd = Math.ceil(Math.random() * 3.0);
                                if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                    player = (AbstractClientPlayer)entiry_a;
                                    animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                    if (animation != null) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", rnd == 1.0 ? "sword_overhead" : "sword_to_" + STR1))));
                                    }
                                }
                            } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "punch_" + STR1))));
                                }
                            }
                        }
                    } else if (sword) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_" + STR1))));
                            }
                        }
                    } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                        player = (AbstractClientPlayer)entiry_a;
                        animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                        if (animation != null) {
                            String var10006 = Math.random() > 0.5 ? "kick_" : "punch_";
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", var10006 + STR1))));
                        }
                    }
                } else if (NUM3 == 20.0) {
                    if (NUM1 == 220.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "red"))));
                            }
                        }
                    } else if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                        player = (AbstractClientPlayer)entiry_a;
                        animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                        if (animation != null) {
                            if (!(entiry_a instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(JujutsucraftaddonModMobEffects.GOJO_IMBUED_POWER.get())))  {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "domain_expansion1"))));
                            }
                        }
                    }
                } else if (NUM1 < 0.0) {
                    if (NUM1 >= -5.0) {
                        if (NUM1 == -1.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "backstep"))));
                                }
                            }
                        } else if (NUM1 == -2.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "death"))));
                                }
                            }
                        } else if (NUM1 == -3.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "right_arm_up"))));
                                }
                            }
                        } else if (NUM1 == -4.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "both_arm_front"))));
                                }
                            }
                        } else if (NUM1 == -5.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "sword_to_right"))));
                            }
                        }
                    } else if (NUM1 >= -10.0) {
                        if (NUM1 == -6.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_" + STR1))));
                                }
                            }
                        } else if (NUM1 == -7.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "punch_" + STR1))));
                                }
                            }
                        } else if (NUM1 == -8.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "rotation"))));
                                }
                            }
                        } else if (NUM1 == -9.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "guard"))));
                                }
                            }
                        } else if (NUM1 == -10.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null && !animation.isActive()) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "fall1"))));
                            }
                        }
                    } else if (NUM1 >= -15.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "dance" + Math.round(NUM1 + 16.0)))));
                            }
                        }
                    } else if (NUM1 >= -20.0) {
                        if (NUM1 == -16.0) {
                            if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                                player = (AbstractClientPlayer)entiry_a;
                                animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                                if (animation != null) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "simple_domain1"))));
                                }
                            }
                        } else if (NUM1 == -17.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "simple_domain2"))));
                            }
                        }
                    }
                } else {
                    if (NUM1 == 107.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                if (entiry_a.getPersistentData().getDouble("skill") != 215) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "open"))));
                                }
                            }
                        }
                    } else if (NUM1 == 207.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "red"))));
                            }
                        }
                    } else if (NUM1 == 618.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                        player = (AbstractClientPlayer)entiry_a;
                        animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "ten_shadows_technique_mahoraga"))));
                        }
                    }

                    if (NUM1 == 1706.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "kick_flying"))));
                            }
                        }
                    } else if (NUM1 == 1715.0) {
                        if (world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                            player = (AbstractClientPlayer)entiry_a;
                            animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                            if (animation != null) {
                                animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "wifi"))));
                            }
                        }
                    } else if (NUM1 == 2015.0 && world.isClientSide() && entiry_a instanceof AbstractClientPlayer) {
                        player = (AbstractClientPlayer)entiry_a;
                        animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraft", "player_animation"));
                        if (animation != null) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraft", "plus_ultra"))));
                        }
                    }
                }

                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME1", 0.0);
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                if (entiry_a instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entiry_a;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                if (var10000.getItem() == ((Block) JujutsucraftModBlocks.IN_BARRIER.get()).asItem()) {
                    Entity _entity = entiry_a;
                    if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().armor.set(3, ItemStack.EMPTY);
                        _player.getInventory().setChanged();
                    } else if (_entity instanceof LivingEntity) {
                        _living = (LivingEntity)_entity;
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



