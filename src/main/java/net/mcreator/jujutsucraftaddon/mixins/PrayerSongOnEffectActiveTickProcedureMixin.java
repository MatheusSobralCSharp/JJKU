package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraft.procedures.PlayAnimationProcedure;
import net.mcreator.jujutsucraft.procedures.PrayerSongOnEffectActiveTickProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = PrayerSongOnEffectActiveTickProcedure.class, priority = -10000)
public abstract class PrayerSongOnEffectActiveTickProcedureMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void injection(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double tick = 0.0;
            double level = 0.0;
            LivingEntity _livEnt17;
            if (entity.isAlive()) {
                double var10000;
                label117:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt17 = (LivingEntity) entity;
                        if (_livEnt17.hasEffect(JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            var10000 = _livEnt17.getEffect(JujutsucraftModMobEffects.PRAYER_SONG.get()).getAmplifier();
                            break label117;
                        }
                    }

                    var10000 = 0.0;
                }

                label112:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt17 = (LivingEntity) entity;
                        if (_livEnt17.hasEffect(JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            var10000 = _livEnt17.getEffect(JujutsucraftModMobEffects.PRAYER_SONG.get()).getDuration();
                            break label112;
                        }
                    }

                    var10000 = 0.0;
                }

                LivingEntity _livEnt18;
                label107:
                {
                    tick = var10000;
                    if (entity instanceof LivingEntity) {
                        _livEnt17 = (LivingEntity) entity;
                        if (_livEnt17.hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                            break label107;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt18 = (LivingEntity) entity;
                        if (!_livEnt18.level().isClientSide()) {
                            _livEnt18.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
                        }
                    }
                }

                LivingEntity _entGetArmor;
                if (entity.onGround()) {
                    label129:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt17 = (LivingEntity) entity;
                            if (_livEnt17.hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label129;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt18 = (LivingEntity) entity;
                            if (_livEnt18.hasEffect(JujutsucraftModMobEffects.GUARD.get())) {
                                break label129;
                            }
                        }

                        if (tick % 3.0 == 0.0 && world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.fall")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                            }
                        }

                        if (tick % 5.0 == 0.0 && entity instanceof Player) {
                            PlayAnimationProcedure.execute(entity);
                            ItemStack var21;
                            if (entity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity;
                                var21 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var21 = ItemStack.EMPTY;
                            }

                            var21.getOrCreateTag().putDouble("P_ANIME1", -15.0);
                            if (entity instanceof LivingEntity) {
                                _entGetArmor = (LivingEntity) entity;
                                var21 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                            } else {
                                var21 = ItemStack.EMPTY;
                            }

                            var21.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                        }
                    }
                }

                if (tick % 5.0 == 0.0) {
                    Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var20 = _entfound.iterator();

                    while (var20.hasNext()) {
                        Entity entityiterator = (Entity) var20.next();
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof LivingEntity _entity) {
                            if (!_entity.level().isClientSide()) {
                                MobEffectInstance currentEffect = _entity.getEffect(MobEffects.WEAKNESS);
                                int currentAmplifier = 0;

                                // If the Weakness effect exists, get its current amplifier and increment it by 1
                                if (currentEffect != null && currentEffect.getAmplifier() < 50) {
                                    currentAmplifier = currentEffect.getAmplifier() + 1;
                                }

                                if (Math.random() < (1) / ((float) 40)) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, currentAmplifier));
                                }

                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 0));
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.UNSTABLE.get(), 60, 0));

                                if (Math.random() < (1) / ((float) 100)) {
                                    _entity.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                                }

                            }
                        }
                    }
                }

                label127:
                {
                    if (entity instanceof LivingEntity) {
                        _livEnt17 = (LivingEntity) entity;
                        if (_livEnt17.hasEffect(JujutsucraftModMobEffects.UNSTABLE.get())) {
                            break label127;
                        }
                    }

                    if (!(entity instanceof LivingEntity)) {
                        return;
                    }

                    _livEnt18 = (LivingEntity) entity;
                    if (!_livEnt18.hasEffect(JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        return;
                    }
                }

                if (entity instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity) entity;
                    _entGetArmor.removeEffect(JujutsucraftModMobEffects.PRAYER_SONG.get());
                }
            } else if (entity instanceof LivingEntity) {
                _livEnt17 = (LivingEntity) entity;
                _livEnt17.removeEffect(JujutsucraftModMobEffects.PRAYER_SONG.get());
            }

        }
    }
}
