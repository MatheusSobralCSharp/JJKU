package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
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

@Mixin(value = AIActive2Procedure.class, priority = -10000)
public abstract class CursedTechniqueRikaMixin {

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean logic_guard = false;
            boolean logic_heal = false;
            boolean logic_heal_cancel = false;
            boolean test = false;
            boolean target = false;
            boolean logic_avoid = false;
            boolean using = false;
            boolean output = false;
            double x_knockback = 0.0;
            double y_knockback = 0.0;
            double z_knockback = 0.0;
            double dis = 0.0;
            double old_skill = 0.0;
            double limit = 0.0;
            double distance = 0.0;
            logic_guard = false;
            logic_heal = false;
            logic_heal_cancel = true;
            logic_avoid = false;
            test = entity.getPersistentData().getDouble("cnt_target") % 5.0 == 4.0;
            LivingEntity var10000;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var10000 = _mobEnt.getTarget();
            } else {
                var10000 = null;
            }

            target = var10000 instanceof LivingEntity;
            distance = 99.0;
            Iterator var32;
            Entity entityiterator;
            LivingEntity _livEnt;
            Vec3 _center;
            List _entfound;
            int var49;
            double var50;
            if (entity.getPersistentData().getDouble("skill") == 0.0) {
                if (target) {
                    distance = GetDistanceProcedure.execute(world, entity);
                    if (test) {
                        logic_heal_cancel = false;
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000.getPersistentData().getDouble("Damage") > 0.0) {
                            logic_heal_cancel = true;
                            if (test) {
                                logic_guard = true;
                            }
                        }
                    }

                    if (test) {
                        if (!logic_guard) {
                            label561: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                        break label561;
                                    }
                                }

                                label539: {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                            var49 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                            break label539;
                                        }
                                    }

                                    var49 = 0;
                                }

                                if (var49 > 0) {
                                    logic_guard = true;
                                }
                            }
                        }

                        if (!logic_guard) {
                            _center = new Vec3(x, y, z);
                            Vec3 final_center = _center;
                            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> {
                                return true;
                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                return _entcnd.distanceToSqr(final_center);
                            })).toList();
                            var32 = _entfound.iterator();

                            label532:
                            while(true) {
                                do {
                                    do {
                                        if (!var32.hasNext()) {
                                            break label532;
                                        }

                                        entityiterator = (Entity)var32.next();
                                    } while(entity == entityiterator);

                                    if (entityiterator instanceof Projectile) {
                                        Projectile _projEnt = (Projectile)entityiterator;
                                        var50 = _projEnt.getDeltaMovement().length();
                                    } else {
                                        var50 = 0.0;
                                    }

                                    if (var50 > 0.0) {
                                        logic_avoid = true;
                                        logic_guard = true;
                                        break label532;
                                    }
                                } while(entityiterator.getPersistentData().getDouble("skill") == 0.0 && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))));

                                if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                    logic_avoid = true;
                                    logic_guard = true;
                                    break;
                                }
                            }
                        }

                        if (!logic_guard) {
                            _center = new Vec3(x, y, z);
                            Vec3 final_center1 = _center;
                            _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> {
                                return true;
                            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                                return _entcnd.distanceToSqr(final_center1);
                            })).toList();
                            var32 = _entfound.iterator();

                            label510:
                            while(true) {
                                do {
                                    do {
                                        do {
                                            if (!var32.hasNext()) {
                                                break label510;
                                            }

                                            entityiterator = (Entity)var32.next();
                                        } while(entity == entityiterator);
                                    } while(entityiterator.getPersistentData().getDouble("skill") == 0.0);
                                } while(!(entityiterator.getPersistentData().getDouble("Damage") > 0.0) && !entityiterator.getPersistentData().getBoolean("PRESS_Z"));

                                if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                    logic_avoid = true;
                                    logic_guard = true;
                                    break;
                                }
                            }
                        }

                        if (logic_avoid) {
                            label564: {
                                if (entity.getPersistentData().getDouble("skill") != 0.0) {
                                    logic_avoid = false;
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                        label483: {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                                    var49 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                                    break label483;
                                                }
                                            }

                                            var49 = 0;
                                        }

                                        if (var49 < 6) {
                                            logic_avoid = false;
                                        }
                                        break label564;
                                    }
                                }

                                logic_avoid = false;
                            }
                        }

                        if (entity.getPersistentData().getBoolean("CursedSpirit") && entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                logic_avoid = true;
                            }
                        }
                    }

                    logic_heal_cancel = logic_heal_cancel || logic_guard;
                    if (!logic_avoid) {
                        if (distance < 2.0) {
                            logic_avoid = true;
                        }

                        label469: {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var49 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label469;
                                }
                            }

                            var49 = 0;
                        }

                        if ((var49 > 10 || entity.getPersistentData().getDouble("cnt_x") < 0.0) && entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                if (distance < 6.0) {
                                    logic_avoid = true;
                                }

                                if (distance < 24.0) {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob)entity;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000.getPersistentData().getDouble("skill") > -900.0) {
                                            logic_avoid = true;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:no_guard")))) {
                        logic_guard = false;
                    }

                    logic_heal_cancel = logic_heal_cancel || logic_avoid;
                } else {
                    logic_heal_cancel = false;
                }
            }

            if (logic_guard) {
                StartGuardProcedure.execute(entity);
                entity.setShiftKeyDown(true);
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
                    label566: {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000.getPersistentData().getBoolean("attack")) {
                                break label566;
                            }
                        }

                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            CommandSourceStack var10001;
                            float var10002;
                            Commands var52;
                            label440: {
                                var52 = _ent.getServer().getCommands();
                                var10001 = new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent);
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var10002 = (float)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label440;
                                    }
                                }

                                var10002 = 0.0F;
                            }

                            var52.performPrefixedCommand(var10001, "effect give @s jujutsucraft:domain_amplification 1 " + Math.round(var10002 + 4) + " false");
                        }
                    }
                }
            } else {
                entity.setShiftKeyDown(false);
            }

            if (logic_avoid && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:no_guard")))) {
                if (entity.onGround() && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                    entity.getPersistentData().putBoolean("PRESS_S", true);
                    WhenBackStepProcedure.execute(x, y, z, entity);
                    entity.getPersistentData().putBoolean("PRESS_S", false);
                }

                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                        entity.getPersistentData().putDouble("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                    }
                }
            }

            if (test && (logic_avoid || Math.random() < 0.2) && GetDistanceProcedure.execute(world, entity) > 8.0 && entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                    KeySpaceOnKeyPressedProcedure.execute(world, x, y, z, entity);
                }
            }

            float var53;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                var53 = _livEnt.getMaxHealth();
            } else {
                var53 = -1.0F;
            }

            if (world instanceof ServerLevel _server) {
                limit = (double) (var53 >= 800.0F ? 400 * _server.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY) : 200 * _server.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SYSTEM_UPGRADE_DIFFICULTY));
            }


            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique")))) {
                output = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")));
                float var48;
                if (!logic_heal_cancel) {
                    if (distance < 8.0) {
                        label570: {
                            logic_heal_cancel = true;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var53 = _livEnt.getHealth();
                            } else {
                                var53 = -1.0F;
                            }

                            var50 = (double)var53;
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var48 = _livEnt.getMaxHealth();
                            } else {
                                var48 = -1.0F;
                            }

                            if (var50 <= (double)var48 * 0.5) {
                                logic_heal_cancel = false;
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    break label570;
                                }
                            }

                            label416: {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                        var49 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                        break label416;
                                    }
                                }

                                var49 = 0;
                            }

                            if (var49 >= 1) {
                                logic_heal_cancel = false;
                            }
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var53 = _livEnt.getHealth();
                    } else {
                        var53 = -1.0F;
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var48 = _livEnt.getMaxHealth();
                    } else {
                        var48 = -1.0F;
                    }

                    if (var53 >= var48) {
                        logic_heal_cancel = true;
                    }
                }

                if (entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0 >= limit) {
                    logic_heal_cancel = true;
                    output = false;
                }

                if (output) {
                    output = false;
                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:cant_combat"))) || entity.getPersistentData().getDouble("cnt_target") <= 6.0) {
                        dis = (double)(entity.getBbWidth() * 1.0F);
                        using = false;
                        _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
                        Vec3 final_center2 = _center;
                        _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis * 3.0 / 2.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(final_center2);
                        })).toList();
                        var32 = _entfound.iterator();

                        while(var32.hasNext()) {
                            entityiterator = (Entity)var32.next();
                            if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entityiterator.isAlive() && entity != entityiterator) {
                                using = false;
                                if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                    if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                        using = true;
                                    }
                                } else if (!entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entityiterator;
                                        var53 = _livEnt.getHealth();
                                    } else {
                                        var53 = -1.0F;
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entityiterator;
                                        var48 = _livEnt.getMaxHealth();
                                    } else {
                                        var48 = -1.0F;
                                    }

                                    if (var53 < var48) {
                                        using = true;
                                    }
                                }

                                if (using) {
                                    output = true;
                                    logic_heal_cancel = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                if (logic_heal_cancel) {
                    logic_heal = false;
                } else {
                    logic_heal = true;
                    if (output) {
                        entity.getPersistentData().putDouble("cnt_reverse_test", Math.max(entity.getPersistentData().getDouble("cnt_reverse_test"), 100.0));
                    }
                }

                entity.getPersistentData().putDouble("cnt_reverse_test", entity.getPersistentData().getDouble("cnt_reverse_test") + 1.0);
                if (logic_heal) {
                    if (entity.getPersistentData().getDouble("cnt_reverse_test") > 100.0) {
                        label589: {
                            entity.getPersistentData().putDouble("cnt_reverse_test", 0.0);
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                    break label589;
                                }
                            }

                            if (!entity.getPersistentData().getBoolean("PRESS_M")) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (!_livEnt.level().isClientSide()) {
                                        _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 18, 9, false, false));
                                    }
                                }

                                entity.getPersistentData().putDouble("cnt_reverse", 15.0);
                                KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                            }
                        }
                    }
                } else if (!target) {
                    entity.getPersistentData().putDouble("cnt_reverse_lim", Math.max(entity.getPersistentData().getDouble("cnt_reverse_lim") - 0.1, 0.0));
                }

                if (entity.getPersistentData().getBoolean("PRESS_M")) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                            entity.getPersistentData().putDouble("cnt_reverse_lim", entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0);
                        }
                    }

                    entity.getPersistentData().putDouble("cnt_reverse", Math.max(entity.getPersistentData().getDouble("cnt_reverse") - 1.0, 0.0));
                    if (!logic_heal) {
                        label379: {
                            if (!(entity.getPersistentData().getDouble("cnt_reverse") <= 0.0) && !(entity.getPersistentData().getDouble("cnt_reverse_lim") >= limit)) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var53 = _livEnt.getHealth();
                                } else {
                                    var53 = -1.0F;
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var48 = _livEnt.getMaxHealth();
                                } else {
                                    var48 = -1.0F;
                                }

                                if (!(var53 >= var48) || output) {
                                    break label379;
                                }
                            }

                            entity.getPersistentData().putDouble("cnt_reverse", 0.0);
                            KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                        }
                    }
                }
            }

            if (target && entity.getPersistentData().getDouble("skill") == 0.0) {
                entity.getPersistentData().putDouble("cnt_weapon", entity.getPersistentData().getDouble("cnt_weapon") + 1.0);
                if (entity.getPersistentData().getDouble("cnt_weapon") > 200.0) {
                    entity.getPersistentData().putDouble("cnt_weapon", 0.0);
                    ItemStack var54;
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var54 = _livEnt.getMainHandItem();
                    } else {
                        var54 = ItemStack.EMPTY;
                    }

                    label576: {
                        ItemStack var51;
                        ItemCooldowns var55;
                        if (var54.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                            if (!(entity instanceof Player)) {
                                break label576;
                            }

                            Player _plrCldCheck107 = (Player)entity;
                            var55 = _plrCldCheck107.getCooldowns();
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var51 = _livEnt.getMainHandItem();
                            } else {
                                var51 = ItemStack.EMPTY;
                            }

                            if (!var55.isOnCooldown(var51.getItem())) {
                                break label576;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            var54 = _livEnt.getOffhandItem();
                        } else {
                            var54 = ItemStack.EMPTY;
                        }

                        if (var54.getItem() != JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                            return;
                        }

                        if (entity instanceof Player) {
                            Player _plrCldCheck111 = (Player)entity;
                            var55 = _plrCldCheck111.getCooldowns();
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var51 = _livEnt.getOffhandItem();
                            } else {
                                var51 = ItemStack.EMPTY;
                            }

                            if (var55.isOnCooldown(var51.getItem())) {
                                return;
                            }
                        }
                    }

                    if (distance > 8.0) {
                        SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
                    } else {
                        entity.getPersistentData().putDouble("cnt_weapon", 160.0);
                    }
                }
            }

        }
    }
}

