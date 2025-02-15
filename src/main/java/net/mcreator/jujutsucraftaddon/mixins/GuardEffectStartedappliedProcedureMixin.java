package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.StartGuardProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = StartGuardProcedure.class)
public abstract class GuardEffectStartedappliedProcedureMixin {

    /**
     * @author Satushi
     * @reason Changes the guard + remove the sukuna slash guard when the effect start for balance reasons
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double level = 0.0;
            double level_jump = 0.0;
            double level_health = 0.0;
            double level_resistance = 0.0;
            double level_speed = 0.0;
            double level_power = 0.0;
            double level_armor = 0.0;
            double level_armorToughness = 0.0;
            double old_health = 0.0;
            double level_speed_set = 0.0;
            double animation_num = 0.0;
            if (entity instanceof LivingEntity) {
                LivingEntity _livEnt0 = (LivingEntity)entity;
                if (_livEnt0.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    return;
                }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt2 = (LivingEntity)entity;
                    if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) && entity.getPersistentData().getBoolean("PRESS_M")) {
                        return;
                    }
                }

                LivingEntity _entity;
                label88: {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                            break label88;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                            break label88;
                        }
                    }

                    LivingEntity _livEnt7;
                    if (entity instanceof LivingEntity) {
                        _livEnt7 = (LivingEntity)entity;
                        if (!_livEnt7.level().isClientSide()) {
                            _livEnt7.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 40, 1, false, false));
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt7 = (LivingEntity)entity;
                        if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            LivingEntity _entGetArmor;
                            if (entity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity)entity;
                                if (!_entGetArmor.level().isClientSide()) {
                                    _entGetArmor.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 40, 1, false, false));
                                }
                            }

                            animation_num = (double)Math.round(-15.0 + Math.ceil(Math.random() * 4.0));
                            ItemStack var10000;
                            if (!(entity instanceof Player)) {
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                var10000.getOrCreateTag().putDouble("P_ANIME1", animation_num);
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                            }

                            PlayAnimationProcedure.execute(entity);
                            if (entity instanceof Player) {
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                var10000.getOrCreateTag().putDouble("P_ANIME1", animation_num);
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                            }
                        }
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 40, 1, false, false));
                    }
                }
            }

        }
    }
}
