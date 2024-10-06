package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.DomainExpansionEntityEntity;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import net.minecraftforge.registries.ForgeRegistries;
import net.mcreator.jujutsucraft.procedures.LogicStartPassiveProcedure;
import net.mcreator.jujutsucraft.procedures.WhenEntityAttackedProcedure;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.ClickAnimation2Procedure;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(value = WhenEntityAttackedProcedure.class, remap = false)
public abstract class MahoragaAdaptMixin {
    public MahoragaAdaptMixin() {
    }

    /**
     * @author Satushi
     * @reason Satushi Test
     */
    @Overwrite

    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), (double)event.getAmount());
        }

    }


    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
        if (damagesource != null && entity != null && sourceentity != null) {
            String STR1 = "";
            ItemStack item_A = ItemStack.EMPTY;
            double DamagePoint = 0.0;
            double MAX_CURSE_POWER = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            boolean cancel = false;
            boolean mahorage = false;
            boolean logic_a = false;

            if (sourceentity instanceof Player) {
                if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Run == 1) {
                    if (!((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")
                            || (ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud"))) {
                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 2, 10))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit3")), SoundSource.NEUTRAL, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit3")), SoundSource.NEUTRAL, 1, 1, false);
                                    }
                                }
                            } else if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 10))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade1")), SoundSource.NEUTRAL, 1, 2);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade1")), SoundSource.NEUTRAL, 1, 2, false);
                                    }
                                }
                            }
                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 10, 20))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit")), SoundSource.NEUTRAL, 1, (float) 0.1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit")), SoundSource.NEUTRAL, 1, (float) 0.1, false);
                                    }
                                }
                            } else if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 10, 24))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade2")), SoundSource.NEUTRAL, 1, 2);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade2")), SoundSource.NEUTRAL, 1, 2, false);
                                    }
                                }
                            }
                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                            if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("attack" + Mth.nextInt(RandomSource.create(), 15, 24))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit2")), SoundSource.NEUTRAL, 1, 2);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hit2")), SoundSource.NEUTRAL, 1, 2, false);
                                    }
                                }
                            } else if (!((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.STEEL_ARM.get()
                                    || (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.ITADORI_ARMS.get())) {
                                if (world.isClientSide()) {
                                    if (sourceentity instanceof AbstractClientPlayer player) {
                                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                        if (animation != null && !animation.isActive()) {
                                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("sword" + Mth.nextInt(RandomSource.create(), 1, 24))))));
                                        }
                                    }
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade3")), SoundSource.NEUTRAL, 1, 2);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:hitblade3")), SoundSource.NEUTRAL, 1, 2, false);
                                    }
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:split_soul_katana")) {
                        if (Math.random() < 0.3 && Math.random() > 0.1) {
                            if (world.isClientSide()) {
                                if (sourceentity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 1, 2))))));
                                    }
                                }
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing1")), SoundSource.NEUTRAL, 1, 2);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing1")), SoundSource.NEUTRAL, 1, 2, false);
                                }
                            }
                        } else if (Math.random() < 0.5 && Math.random() > 0.3) {
                            if (world.isClientSide()) {
                                if (sourceentity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 2, 3))))));
                                    }
                                }
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing2")), SoundSource.NEUTRAL, 1, 2);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing2")), SoundSource.NEUTRAL, 1, 2, false);
                                }
                            }
                        } else if (Math.random() < 0.7 && Math.random() > 0.5) {
                            if (world.isClientSide()) {
                                if (sourceentity instanceof AbstractClientPlayer player) {
                                    var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                    if (animation != null && !animation.isActive()) {
                                        animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("soul" + Mth.nextInt(RandomSource.create(), 4, 5))))));
                                    }
                                }
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 2);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:swing3")), SoundSource.NEUTRAL, 1, 2, false);
                                }
                            }
                        }
                    } else if ((ForgeRegistries.ITEMS.getKey((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:playful_cloud")) {
                        if (world.isClientSide()) {
                            if (sourceentity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", ("ab" + Mth.nextInt(RandomSource.create(), 1, 5) + "player")))));
                                }
                            }
                        }
                    }
                }
            }

            if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:animation")))) {
                LivingEntity _entGetArmor;
                LivingEntity _livEnt;
                if (sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !sourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move"))) && LogicStartPassiveProcedure.execute(entity)) {
                    NUM1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                    NUM2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                    if ((NUM1 == 38.0 || NUM2 == 38.0 || entity instanceof UroTakakoEntity) && sourceentity.getBbWidth() + sourceentity.getBbHeight() <= (entity.getBbWidth() + entity.getBbHeight()) * 4.0F && entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                            label522: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                        break label522;
                                    }
                                }

                                cancel = true;
                            }
                        }
                    }
                }

                if (cancel) {
                    if (event != null && event.isCancelable()) {
                        event.setCanceled(true);
                    } else if (event != null && event.hasResult()) {
                        event.setResult(Event.Result.DENY);
                    }
                } else if (!damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:curse"))) && !damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("forge:combat")))) {
                    cancel = false;
                    LivingEntity var10000;
                    Mob _mobEnt;
                    if (sourceentity instanceof Mob) {
                        _mobEnt = (Mob)sourceentity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    LivingEntity var10001;
                    Mob _mobEnt3;
                    if (var10000 instanceof LivingEntity) {
                        if (sourceentity instanceof Mob) {
                            _mobEnt3 = (Mob)sourceentity;
                            var10000 = _mobEnt3.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (entity instanceof Mob) {
                            Mob _mobEnt4 = (Mob)entity;
                            var10001 = _mobEnt4.getTarget();
                        } else {
                            var10001 = null;
                        }

                        if (var10000 == var10001) {
                            cancel = true;
                        }
                    }

                    if (!cancel) {
                        label523: {
                            if (sourceentity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && (sourceentity.getPersistentData().getDouble("NameRanged_ranged") == entity.getPersistentData().getDouble("NameRanged") || sourceentity.getPersistentData().getDouble("NameRanged_ranged") == entity.getPersistentData().getDouble("NameRanged_ranged"))) {
                                cancel = true;
                            }

                            if (sourceentity.getPersistentData().getDouble("NameRanged") != 0.0 && (sourceentity.getPersistentData().getDouble("NameRanged") == entity.getPersistentData().getDouble("NameRanged_ranged") || sourceentity.getPersistentData().getDouble("NameRanged") == entity.getPersistentData().getDouble("NameRanged"))) {
                                cancel = true;
                            }

                            label502: {
                                if (entity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal)entity;
                                    if (_tamEnt.isTame()) {
                                        break label502;
                                    }
                                }

                                if (!(sourceentity instanceof TamableAnimal)) {
                                    break label523;
                                }

                                TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                                if (!_tamEnt.isTame()) {
                                    break label523;
                                }
                            }

                            if (entity instanceof TamableAnimal) {
                                TamableAnimal _tamEnt = (TamableAnimal)entity;
                                var10000 = _tamEnt.getOwner();
                            } else {
                                var10000 = null;
                            }

                            if (var10000 != sourceentity) {
                                if (sourceentity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                                    var10000 = _tamEnt.getOwner();
                                } else {
                                    var10000 = null;
                                }

                                if (var10000 != entity) {
                                    if (entity instanceof TamableAnimal) {
                                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                                        var10000 = _tamEnt.getOwner();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (sourceentity instanceof TamableAnimal) {
                                        TamableAnimal _tamEnt = (TamableAnimal)sourceentity;
                                        var10001 = _tamEnt.getOwner();
                                    } else {
                                        var10001 = null;
                                    }

                                    if (var10000 != var10001) {
                                        break label523;
                                    }
                                }
                            }

                            cancel = true;
                        }
                    }

                    if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP) && (sourceentity instanceof Player || sourceentity.getPersistentData().getBoolean("Player")) && (entity instanceof Player || entity.getPersistentData().getBoolean("Player"))) {
                        label541: {
                            label505: {
                                cancel = true;
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label505;
                                    }
                                }

                                if (!(sourceentity instanceof LivingEntity)) {
                                    break label541;
                                }

                                _livEnt = (LivingEntity)sourceentity;
                                if (!_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label541;
                                }
                            }

                            cancel = false;
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    label545: {
                        if (var10000 != sourceentity || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                            if (sourceentity instanceof Mob) {
                                _mobEnt = (Mob)sourceentity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000 != entity || !(sourceentity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                break label545;
                            }
                        }

                        cancel = false;
                    }

                    if (sourceentity.getPersistentData().getDouble("friend_num") != 0.0 && sourceentity.getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                        cancel = true;
                    }

                    LivingEntity _livEnt5;
                    int var46;
                    label399: {
                        label507: {
                            if (sourceentity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity)sourceentity;
                                if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && sourceentity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)sourceentity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                        break label507;
                                    }
                                }
                            }

                            label391: {
                                if (sourceentity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)sourceentity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                        var46 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                                        break label391;
                                    }
                                }

                                var46 = 0;
                            }

                            if (var46 <= 0 && !(sourceentity.getPersistentData().getDouble("skill") <= -999.0)) {
                                break label399;
                            }
                        }

                        cancel = true;
                    }

                    if (entity instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity;
                        if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            label381: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                        var46 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                        break label381;
                                    }
                                }

                                var46 = 0;
                            }

                            if (var46 > 0) {
                                cancel = true;
                            }
                        }
                    }

                    if (entity instanceof DomainExpansionEntityEntity) {
                        cancel = true;
                    }

                    if (cancel) {
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    } else if (!damagesource.is(DamageTypes.MOB_PROJECTILE)) {
                        ItemStack var47;
                        if (sourceentity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)sourceentity;
                            var47 = _entGetArmor.getMainHandItem();
                        } else {
                            var47 = ItemStack.EMPTY;
                        }

                        item_A = var47;
                        Player _plrCldCheck76;
                        if (item_A.is(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
                            label527: {
                                if (sourceentity instanceof Player) {
                                    _plrCldCheck76 = (Player)sourceentity;
                                    if (_plrCldCheck76.getCooldowns().isOnCooldown(item_A.getItem())) {
                                        break label527;
                                    }
                                }

                                if (item_A.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || item_A.getItem() == JujutsucraftModItems.BLACK_ROPE.get()) {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (!_livEnt.level().isClientSide()) {
                                            _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0, false, false));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (!_livEnt.level().isClientSide()) {
                                            _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0, false, false));
                                        }
                                    }
                                }
                            }
                        }

                        LivingEntity _livEnt6;
                        if (sourceentity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)sourceentity;
                            if (_entGetArmor.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()) && entity instanceof LivingEntity) {
                                _livEnt6 = (LivingEntity)entity;
                                if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                    label352: {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entity;
                                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                                var46 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getAmplifier();
                                                break label352;
                                            }
                                        }

                                        var46 = 0;
                                    }

                                    int var44;
                                    double var48;
                                    label347: {
                                        var48 = (double)var46;
                                        if (sourceentity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)sourceentity;
                                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                                                var44 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get()).getAmplifier();
                                                break label347;
                                            }
                                        }

                                        var44 = 0;
                                    }

                                    label342: {
                                        NUM1 = (double)Math.round(var48 - Math.ceil((double)((var44 + 10) / 10)));
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entity;
                                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                                var48 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getDuration();
                                                break label342;
                                            }
                                        }

                                        var48 = 0.0;
                                    }

                                    NUM2 = var48;
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        _livEnt.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                                    }

                                    if (NUM1 >= 0.0) {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entity;
                                            if (!_livEnt.level().isClientSide()) {
                                                _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get(), (int)NUM2, (int)NUM1));
                                            }
                                        }

                                        if (world instanceof ServerLevel) {
                                            ServerLevel _level = (ServerLevel)world;
                                            _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x, y, z, 20, 0.5, 0.5, 0.5, 1.0);
                                        }
                                    }
                                }
                            }
                        }

                        if (sourceentity instanceof LivingEntity) {
                            _entGetArmor = (LivingEntity)sourceentity;
                            var47 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                        } else {
                            var47 = ItemStack.EMPTY;
                        }

                        item_A = var47;
                        if (sourceentity instanceof Player) {
                            _plrCldCheck76 = (Player)sourceentity;
                            if (_plrCldCheck76.getCooldowns().isOnCooldown(item_A.getItem())) {
                                return;
                            }
                        }

                        if (item_A.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_A.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                            mahorage = sourceentity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16.0 || (sourceentity.getPersistentData().getDouble("IsMahoraga") == 1.0) || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mahoraga == 1) : sourceentity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity || sourceentity instanceof IgrisEntity || sourceentity instanceof Shadow1Entity;
                            NUM1 = 0.0;
                            STR1 = "";
                            if (NUM1 == 0.0 && entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                    STR1 = "skill205";
                                    if (item_A.getOrCreateTag().getDouble(STR1) == 0.0) {
                                        NUM1 = 1.0;
                                    } else if (item_A.getOrCreateTag().getDouble(STR1) >= 100.0 && mahorage) {
                                        STR1 = "";
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entity;
                                            if (!_livEnt.level().isClientSide()) {
                                                _livEnt.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 1, 1));
                                            }
                                        }
                                    }
                                }
                            }

                            if (NUM1 == 0.0 && STR1.equals("") && mahorage) {
                                STR1 = "toLiving";
                                if (item_A.getOrCreateTag().getDouble(STR1) == 0.0) {
                                    NUM1 = 1.0;
                                } else if (item_A.getOrCreateTag().getDouble(STR1) >= 100.0) {
                                    NUM1 = (double)Math.round(Math.floor(item_A.getOrCreateTag().getDouble(STR1) / 100.0) * 2.5);
                                    if (sourceentity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)sourceentity;
                                        var47 = _livEnt.getMainHandItem();
                                    } else {
                                        var47 = ItemStack.EMPTY;
                                    }

                                    if (var47.isEnchantable()) {
                                        if (sourceentity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)sourceentity;
                                            var47 = _livEnt.getMainHandItem();
                                        } else {
                                            var47 = ItemStack.EMPTY;
                                        }

                                        double var45;
                                        CompoundTag var49;
                                        label514: {
                                            var49 = var47.getOrCreateTag();
                                            ItemStack var10003;
                                            if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                                                ItemStack var10002;
                                                if (sourceentity instanceof LivingEntity) {
                                                    LivingEntity _livEnt7 = (LivingEntity)sourceentity;
                                                    var10002 = _livEnt7.getMainHandItem();
                                                } else {
                                                    var10002 = ItemStack.EMPTY;
                                                }

                                                if (var10002.getItem() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get()) {
                                                    var45 = NUM1 * -1.0;
                                                    if (sourceentity instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity)sourceentity;
                                                        var10003 = _livEnt.getMainHandItem();
                                                    } else {
                                                        var10003 = ItemStack.EMPTY;
                                                    }

                                                    var45 = Math.min(var45, var10003.getOrCreateTag().getDouble("CursePower"));
                                                    break label514;
                                                }
                                            }

                                            if (sourceentity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)sourceentity;
                                                var10003 = _livEnt.getMainHandItem();
                                            } else {
                                                var10003 = ItemStack.EMPTY;
                                            }

                                            var45 = Math.max(NUM1, var10003.getOrCreateTag().getDouble("CursePower"));
                                        }

                                        var49.putDouble("CursePower", var45);
                                    }

                                    NUM1 = 0.0;
                                }
                            }

                            if (NUM1 > 0.0) {
                                for(int index0 = 0; index0 < 800; ++index0) {
                                    if (item_A.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("") || item_A.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                                        item_A.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                                        item_A.getOrCreateTag().putDouble(STR1, 1.0);
                                        break;
                                    }

                                    ++NUM1;
                                }

                                if (sourceentity instanceof Player) {
                                    Player _player = (Player)sourceentity;
                                    if (!_player.level().isClientSide()) {
                                        _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
