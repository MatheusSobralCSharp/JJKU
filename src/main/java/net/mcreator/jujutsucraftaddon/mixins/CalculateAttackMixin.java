package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.CursedSpiritGrade14Entity;
import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.GojoSatoruEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = CalculateAttackProcedure.class, priority = -10000)
public abstract class CalculateAttackMixin {
    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean success;
            boolean danger;
            boolean cooltime;
            boolean logic_attack;
            boolean can_run_attack;
            boolean can_bullet_attack;
            boolean can_jump_attack;
            double rnd;
            boolean var10000;
            double distance1;
            double ticks;
            double level;
            LivingEntity _entity;
            label364: {
                success = false;
                danger = false;
                cooltime = false;
                logic_attack = false;
                can_run_attack = false;
                can_bullet_attack = false;
                can_jump_attack = false;
                rnd = 0.0;
                distance1 = 0.0;
                ticks = 0.0;
                level = 0.0;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                        var10000 = true;
                        break label364;
                    }
                }

                var10000 = false;
            }

            LivingEntity _livEnt47;
            label390: {
                label358: {
                    label357: {
                        cooltime = var10000;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label357;
                            }
                        }

                        if (entity.getPersistentData().getDouble("skill") == 0.0) {
                            if (!(entity instanceof LivingEntity)) {
                                break label358;
                            }

                            _livEnt47 = (LivingEntity)entity;
                            if (!_livEnt47.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) || !cooltime) {
                                break label358;
                            }
                        }
                    }

                    success = false;
                    break label390;
                }

                success = false;
                distance1 = GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity);
                Vec3 _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var27 = _entfound.iterator();

                label343: {
                    Entity entityiterator;
                    double var37;
                    do {
                        do {
                            do {
                                if (!var27.hasNext()) {
                                    break label343;
                                }

                                entityiterator = (Entity)var27.next();
                            } while(entity == entityiterator);

                            logic_attack = LogicAttackProcedure.execute(world, entity, entityiterator);
                        } while(!logic_attack);

                        if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 && entityiterator.getPersistentData().getDouble("skill") > 0.0 && entityiterator.isAlive()) {
                            danger = true;
                            break label343;
                        }

                        if (entityiterator instanceof Projectile) {
                            Projectile _projEnt = (Projectile)entityiterator;
                            var37 = _projEnt.getDeltaMovement().length();
                        } else {
                            var37 = 0.0;
                        }
                    } while(!(var37 > 0.0) && (!logic_attack || !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))));

                    danger = true;
                }

                LivingEntity _livEnt;
                int var38;
                label316: {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            var38 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                            break label316;
                        }
                    }

                    var38 = 0;
                }

                label311: {
                    if (var38 >= 8) {
                        label308: {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                    var38 = _entity.getEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                    break label308;
                                }
                            }

                            var38 = 0;
                        }

                        if (var38 != 1 && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:cant_barrage_attack")))) {
                            var10000 = false;
                            break label311;
                        }
                    }

                    var10000 = true;
                }

                label293: {
                    label384: {
                        can_bullet_attack = !var10000;
                        can_jump_attack = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:jumping_attackable"))) && !cooltime && !danger;
                        if (!cooltime) {
                            label380: {
                                label289: {
                                    if (entity instanceof LivingEntity) {
                                        LivingEntity _livEnt2 = (LivingEntity)entity;
                                        if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                            var38 = _livEnt2.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                            break label289;
                                        }
                                    }

                                    var38 = 0;
                                }

                                if (var38 <= 3 && !(entity instanceof CursedSpiritGrade14Entity) && !(entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)) {
                                    label372: {
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity _livEnt21 = (LivingEntity)entity;
                                            if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                                                break label372;
                                            }
                                        }

                                        if (!(entity instanceof GojoSatoruEntity)) {
                                            if (!(entity instanceof LivingEntity)) {
                                                break label380;
                                            }

                                            LivingEntity _livEnt23 = (LivingEntity)entity;
                                            if (!_livEnt23.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                break label380;
                                            }
                                        }

                                        if (!(distance1 > 8.0)) {
                                            break label380;
                                        }
                                    }
                                }

                                label276: {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                            var38 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                            break label276;
                                        }
                                    }

                                    var38 = 0;
                                }

                                if (var38 < 1) {
                                    if (!(entity instanceof LivingEntity)) {
                                        break label384;
                                    }

                                    _entity = (LivingEntity)entity;
                                    if (!_entity.hasEffect(MobEffects.HUNGER)) {
                                        break label384;
                                    }
                                }
                            }
                        }

                        var10000 = false;
                        break label293;
                    }

                    var10000 = true;
                }

                can_run_attack = var10000;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && !can_run_attack && !can_jump_attack) {
                        break label390;
                    }
                }

                for(int index0 = 0; index0 < 128; ++index0) {
                    rnd = (double)Math.round(Math.ceil(Math.random() * 5.0));
                    if ((rnd != 1.0 || !(Math.random() < 0.5)) && (rnd != 2.0 || !(Math.random() < 0.5)) && (rnd != 3.0 || can_bullet_attack) && (rnd != 4.0 || can_jump_attack) && (rnd != 5.0 || can_run_attack)) {
                        if (distance1 > 16.0) {
                            if (rnd == 4.0 || rnd == 5.0) {
                                success = true;
                                break;
                            }
                        } else if (distance1 > 8.0) {
                            if (rnd == 5.0) {
                                success = true;
                                break;
                            }
                        } else if (distance1 > 6.0) {
                            if (rnd >= 4.0) {
                                success = true;
                                break;
                            }
                        } else if (rnd != 4.0) {
                            success = true;
                            break;
                        }

                        if (danger && (rnd == 3.0 || !(Math.random() < 0.75)) && rnd != 2.0 && rnd != 4.0) {
                            success = true;
                            break;
                        }
                    }
                }
            }

            if (entity.getPersistentData().getDouble("mode") == 0.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                if (success) {
                    entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
                    entity.getPersistentData().putDouble("mode", 20.0 + rnd);
                    entity.getPersistentData().putDouble("skill", 1.0);
                } else {
                    entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            } else {
                entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
                entity.getPersistentData().putDouble("cnt9", success ? rnd : 0.0);
            }

            if (success) {
                level = 1.0;
                if (rnd == 1.0) {
                    ticks = 5.0;
                } else if (rnd == 2.0) {
                    ticks = 15.0;
                } else if (rnd == 3.0) {
                    ticks = 20.0;
                } else if (rnd == 4.0) {
                    ticks = 100.0;
                    level = 0.0;
                } else if (rnd == 5.0) {
                    ticks = 200.0;
                    level = 0.0;
                } else {
                    ticks = 10.0;
                }

                Mob _mobEnt;
                LivingEntity var39;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var39 = _mobEnt.getTarget();
                } else {
                    var39 = null;
                }

                if (!(var39 instanceof Player)) {
                    ticks = Math.max(ticks * 0.5, 10.0);
                }

                ItemStack var40;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    var40 = _entity.getItemBySlot(EquipmentSlot.CHEST);
                } else {
                    var40 = ItemStack.EMPTY;
                }

                if (var40.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                    ticks *= 0.5;
                }

                if (level > 0.0) {
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                            _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks / 2), 0, false, false));
                        }
                    }
                } else if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(ticks / 2), 0, false, false));
                    }
                }

                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var39 = _mobEnt.getTarget();
                    } else {
                        var39 = null;
                    }

                    _entity = var39;
                    if (_entity instanceof LivingEntity) {
                        _livEnt47 = (LivingEntity)_entity;
                        if (_livEnt47.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity)entity;
                                _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                            }

                            KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
                        }
                    }
                }
            }

        }
    }
}
