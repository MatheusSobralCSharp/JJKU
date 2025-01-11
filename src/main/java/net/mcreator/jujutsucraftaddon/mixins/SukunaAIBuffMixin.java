package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.entity.ErrorEntity;
import net.mcreator.jujutsucraftaddon.entity.SukunaMangaEntity;
import net.mcreator.jujutsucraftaddon.procedures.SpiderWebProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AISukunaProcedure.class, priority = 3000)
public abstract class SukunaAIBuffMixin {
    public SukunaAIBuffMixin() {
    }

    /**
     * @author Satushi
     * @reason Adds The Spider Web Cleave to Sukuna Entity
     */

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            ItemStack item_head = ItemStack.EMPTY;
            boolean domain = false;
            boolean infinity = false;
            boolean fushiguro_body = false;
            boolean mahoraga_exist = false;
            boolean vsMahoraga = false;
            double rnd = 0.0;
            double tick = 0.0;
            double NUM_SUM = 0.0;
            double distance = 0.0;
            if (entity.isAlive()) {
                AIActiveProcedure.execute(world, x, y, z, entity);
                fushiguro_body = entity instanceof SukunaFushiguroEntity || entity instanceof SukunaMangaEntity || entity instanceof net.mcreator.jujutsucraftaddon.entity.SukunaFushiguroEntity;
                ItemStack var10000;
                LivingEntity _livEnt15;
                if (entity instanceof LivingEntity) {
                    _livEnt15 = (LivingEntity)entity;
                    var10000 = _livEnt15.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                item_head = var10000;
                if (fushiguro_body && !entity.getPersistentData().getBoolean("flag_start")) {
                    entity.getPersistentData().putBoolean("flag_start", true);
                    rnd = 4.0;

                    for(int index0 = 0; index0 < 7; ++index0) {
                        entity.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(rnd), 1.0);
                        ++rnd;
                    }

                    entity.getPersistentData().putDouble("TenShadowsTechnique1", -2.0);
                    entity.getPersistentData().putDouble("TenShadowsTechnique5", -2.0);
                    entity.getPersistentData().putDouble("TenShadowsTechnique14", 1.0);
                }

                LivingEntity _livEnt80;
                label627: {
                    if (entity instanceof LivingEntity) {
                        _livEnt15 = (LivingEntity)entity;
                        if (_livEnt15.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label627;
                        }
                    }

                    label670: {
                        if (!(entity instanceof SukunaPerfectEntity || entity instanceof ErrorEntity)) {
                            label651: {
                                if (entity instanceof SukunaFushiguroEntity) {
                                    SukunaFushiguroEntity _datEntL11 = (SukunaFushiguroEntity)entity;
                                    if ((Boolean)_datEntL11.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                        break label651;
                                    }
                                }

                                if (fushiguro_body) {
                                    rnd = 30.0;
                                } else {
                                    rnd = 25.0;
                                }
                                break label670;
                            }
                        }

                        rnd = 35.0;
                        entity.getPersistentData().putDouble("KnockbackFix", 1.0);
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt80 = (LivingEntity)entity;
                        if (!_livEnt80.level().isClientSide()) {
                            _livEnt80.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, (int)Math.round(rnd), false, false));
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt80 = (LivingEntity)entity;
                        if (!_livEnt80.level().isClientSide()) {
                            _livEnt80.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), Integer.MAX_VALUE, (int)Math.round(Math.min(Math.max(rnd - 11.0, 0.0), 19.0)), false, false));
                        }
                    }
                }

                label592: {
                    if (entity instanceof LivingEntity) {
                        _livEnt15 = (LivingEntity)entity;
                        if (_livEnt15.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label592;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt80 = (LivingEntity)entity;
                        if (!_livEnt80.level().isClientSide()) {
                            _livEnt80.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                Mob _mobEnt;
                LivingEntity var46;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var46 = _mobEnt.getTarget();
                } else {
                    var46 = null;
                }

                LivingEntity _livEnt93;
                LivingEntity _entity;
                LivingEntity _livEnt107;
                if (var46 instanceof JogoEntity && entity.getPersistentData().getDouble("cnt_target") >= 6.0) {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var46 = _mobEnt.getTarget();
                    } else {
                        var46 = null;
                    }

                    if (var46.getPersistentData().getDouble("skill") == 415.0) {
                        if (!entity.getPersistentData().getBoolean("flag2")) {
                            entity.getPersistentData().putBoolean("flag2", true);
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt93 = (LivingEntity)entity;
                            if (!_livEnt93.level().isClientSide()) {
                                _livEnt93.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                            }
                        }
                    } else if (entity.getPersistentData().getBoolean("flag2")) {
                        if (GetDistanceProcedure.execute(world, entity) < 32.0) {
                            if (GetDistanceProcedure.execute(world, entity) < 6.0 && entity.onGround()) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt93 = (LivingEntity)entity;
                                    _livEnt93.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                                }

                                entity.getPersistentData().putBoolean("PRESS_S", true);
                                WhenBackStepProcedure.execute(x, y, z, entity);
                                entity.getPersistentData().putBoolean("PRESS_S", false);
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt93 = (LivingEntity)entity;
                                _livEnt93.removeEffect(MobEffects.MOVEMENT_SPEED);
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt93 = (LivingEntity)entity;
                                if (!_livEnt93.level().isClientSide()) {
                                    _livEnt93.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                                }
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var46 = _mobEnt.getTarget();
                            } else {
                                var46 = null;
                            }

                            _livEnt107 = var46;
                            if (_livEnt107 instanceof LivingEntity) {
                                _entity = (LivingEntity)_livEnt107;
                                _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var46 = _mobEnt.getTarget();
                            } else {
                                var46 = null;
                            }

                            _livEnt107 = var46;
                            if (_livEnt107 instanceof LivingEntity) {
                                _entity = (LivingEntity)_livEnt107;
                                if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                                }
                            }
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var46 = _mobEnt.getTarget();
                        } else {
                            var46 = null;
                        }

                        if (var46.isPassenger()) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var46 = _mobEnt.getTarget();
                            } else {
                                var46 = null;
                            }

                            if (var46.getVehicle() instanceof MeteorEntity && entity instanceof LivingEntity) {
                                _livEnt107 = (LivingEntity)entity;
                                if (!_livEnt107.level().isClientSide()) {
                                    _livEnt107.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                                }
                            }
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("mode") > 20.0) {
                    AIAttackProcedure.execute(world, x, y, z, entity);
                } else {
                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var46 = _mobEnt.getTarget();
                    } else {
                        var46 = null;
                    }

                    if (var46 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") >= 6.0) {
                        if (fushiguro_body) {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var46 = _mobEnt.getTarget();
                            } else {
                                var46 = null;
                            }

                            if (!(var46 instanceof GojoSatoruEntity)) {
                                float var49;
                                if (entity instanceof LivingEntity) {
                                    _livEnt93 = (LivingEntity)entity;
                                    var49 = _livEnt93.getHealth();
                                } else {
                                    var49 = -1.0F;
                                }

                                double var50 = (double)var49;
                                float var10001;
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity)entity;
                                    var10001 = _entity.getMaxHealth();
                                } else {
                                    var10001 = -1.0F;
                                }

                                if (var50 <= (double)var10001 * 0.3) {
                                    label654: {
                                        if (entity instanceof SukunaFushiguroEntity) {
                                            SukunaFushiguroEntity _datEntL50 = (SukunaFushiguroEntity)entity;
                                            if ((Boolean)_datEntL50.getEntityData().get(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                                break label654;
                                            }
                                        }

                                        if (entity instanceof SukunaFushiguroEntity) {
                                            SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity;
                                            _datEntSetL.getEntityData().set(SukunaFushiguroEntity.DATA_perfect_mode, true);
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity)entity;
                                            if (!_entity.level().isClientSide()) {
                                                _entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 10, 10, false, false));
                                            }
                                        }

                                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                                            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
                                        }

                                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                                            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _entity = (LivingEntity)entity;
                                            _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                                        }

                                        entity.getPersistentData().putDouble("cnt_reverse_lim", 0.0);
                                        entity.getPersistentData().putDouble("skill", 1.0);
                                        ReturnShadowProcedure.execute(world, x, y, z, entity);
                                        entity.getPersistentData().putDouble("skill", 0.0);
                                    }
                                }
                            }
                        }

                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var46 = _mobEnt.getTarget();
                        } else {
                            var46 = null;
                        }

                        boolean var51;
                        label566: {
                            _entity = var46;
                            if (_entity instanceof LivingEntity) {
                                _livEnt80 = (LivingEntity)_entity;
                                if (_livEnt80.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                    var51 = true;
                                    break label566;
                                }
                            }

                            var51 = false;
                        }

                        infinity = var51;
                        entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                        entity.getPersistentData().putDouble("cnt_rest", 0.0);
                        if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                            label680: {
                                mahoraga_exist = entity.getPersistentData().getDouble("TenShadowsTechnique14") == -1.0;
                                if (entity instanceof Mob) {
                                    _mobEnt = (Mob)entity;
                                    var46 = _mobEnt.getTarget();
                                } else {
                                    var46 = null;
                                }

                                vsMahoraga = var46 instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
                                if (vsMahoraga && entity.getPersistentData().getDouble("cnt_target") >= 1200.0 && entity.getPersistentData().getDouble("cnt_target") <= 2400.0) {
                                    entity.getPersistentData().putBoolean("flag_domain", true);
                                }

                                domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !mahoraga_exist;
                                ResetCounterProcedure.execute(entity);
                                if (fushiguro_body && entity.getPersistentData().getDouble("cnt_target") > 200.0 && entity.getPersistentData().getDouble("TenShadowsTechnique14") >= 1.0 && item_head.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                                    if (entity instanceof Player) {
                                        Player _player = (Player)entity;
                                        _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                        _player.getInventory().setChanged();
                                    } else if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity)entity;
                                        _entity.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                    }
                                }

                                label553: {
                                    label552: {
                                        if (!entity.getPersistentData().getBoolean("flag1") && vsMahoraga && entity instanceof LivingEntity) {
                                            _livEnt80 = (LivingEntity)entity;
                                            if (_livEnt80.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                break label552;
                                            }
                                        }

                                        if (!entity.getPersistentData().getBoolean("flag2")) {
                                            break label553;
                                        }
                                    }

                                    if (distance < 48.0 && entity instanceof LivingEntity) {
                                        _livEnt93 = (LivingEntity)entity;
                                        if (!_livEnt93.level().isClientSide()) {
                                            _livEnt93.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0, false, false));
                                        }
                                    }
                                }

                                label543: {
                                    distance = GetDistanceProcedure.execute(world, entity);
                                    if (LogicStartProcedure.execute(entity)) {
                                        if (Math.random() > (infinity ? 0.75 : 0.1) && distance < 48.0) {
                                            break label543;
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _livEnt80 = (LivingEntity)entity;
                                            if (_livEnt80.hasEffect(MobEffects.HUNGER)) {
                                                break label543;
                                            }
                                        }
                                    }

                                    if (!domain) {
                                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                                        CalculateAttackProcedure.execute(world, x, y, z, entity);
                                        break label680;
                                    }
                                }

                                if (fushiguro_body) {
                                    boolean var48;
                                    CompoundTag var52;
                                    label529: {
                                        entity.getPersistentData().putBoolean("flag_mahoraga", entity.getPersistentData().getDouble("TenShadowsTechnique14") == 1.0);
                                        var52 = entity.getPersistentData();
                                        if (entity.getPersistentData().getBoolean("flag_mahoraga")) {
                                            float var10002;
                                            if (entity instanceof LivingEntity) {
                                                _entity = (LivingEntity)entity;
                                                var10002 = _entity.getHealth();
                                            } else {
                                                var10002 = -1.0F;
                                            }

                                            double var47 = (double)var10002;
                                            float var10003;
                                            if (entity instanceof LivingEntity) {
                                                _livEnt93 = (LivingEntity)entity;
                                                var10003 = _livEnt93.getMaxHealth();
                                            } else {
                                                var10003 = -1.0F;
                                            }

                                            if (var47 < (double)var10003 * 0.6 || item_head.getOrCreateTag().getDouble("skill205") >= 100.0 && infinity) {
                                                var48 = true;
                                                break label529;
                                            }
                                        }

                                        var48 = false;
                                    }

                                    var52.putBoolean("flag_mahoraga", var48);
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var46 = _mobEnt.getTarget();
                                    } else {
                                        var46 = null;
                                    }

                                    if (var46 instanceof GojoSatoruEntity && entity.getPersistentData().getDouble("brokenBrain") < 1.0) {
                                        entity.getPersistentData().putBoolean("flag_mahoraga", false);
                                    }
                                }

                                if (fushiguro_body) {
                                    label663: {
                                        label683: {
                                            if (entity.getPersistentData().getBoolean("flag_mahoraga") || Math.random() < 0.2 && !infinity) {
                                                label682: {
                                                    if (entity instanceof LivingEntity) {
                                                        _livEnt93 = (LivingEntity)entity;
                                                        if (_livEnt93.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                            break label682;
                                                        }
                                                    }

                                                    if (!domain && entity.getPersistentData().getDouble("TenShadowsTechnique14") == 1.0) {
                                                        break label683;
                                                    }
                                                }
                                            }

                                            if (!entity.getPersistentData().getBoolean("flag_agito") || !(entity.getPersistentData().getDouble("TenShadowsTechnique13") >= 0.0)) {
                                                break label663;
                                            }
                                        }

                                        AIFushiguroMegumiProcedure.execute(world, x, y, z, entity);
                                        break label680;
                                    }
                                }

                                entity.getPersistentData().putDouble("cnt_x", 0.0);
                                if (domain) {
                                    rnd = 20.0;
                                    tick = 20.0;
                                } else {
                                    if (entity.getPersistentData().getBoolean("flag2")) {
                                        if (entity instanceof Mob) {
                                            Mob _mobEnt2 = (Mob)entity;
                                            var46 = _mobEnt2.getTarget();
                                        } else {
                                            var46 = null;
                                        }

                                        LivingEntity var31;
                                        int var53;
                                        label445: {
                                            var31 = var46;
                                            if (var31 instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)var31;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                    var53 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                                    break label445;
                                                }
                                            }

                                            var53 = 0;
                                        }

                                        if (var53 <= 20) {
                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob)entity;
                                                var46 = _mobEnt.getTarget();
                                            } else {
                                                var46 = null;
                                            }

                                            label438: {
                                                var31 = var46;
                                                if (var31 instanceof LivingEntity) {
                                                    LivingEntity _livEnt = (LivingEntity)var31;
                                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                                        var53 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getDuration();
                                                        break label438;
                                                    }
                                                }

                                                var53 = 0;
                                            }

                                            if (var53 <= 20) {
                                                entity.getPersistentData().putBoolean("flag2", false);
                                                rnd = 7.0;
                                                tick = 250.0;
                                            }
                                        }
                                    } else {
                                        label643: {
                                            if (!entity.getPersistentData().getBoolean("flag1")) {
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob)entity;
                                                    var46 = _mobEnt.getTarget();
                                                } else {
                                                    var46 = null;
                                                }

                                                if (!(var46 instanceof GojoSatoruEntity) && entity instanceof LivingEntity) {
                                                    _livEnt107 = (LivingEntity)entity;
                                                    if (_livEnt107.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().getBoolean("Failed")) {
                                                        entity.getPersistentData().putBoolean("flag1", true);
                                                        rnd = 7.0;
                                                        tick = 250.0;
                                                        break label643;
                                                    }
                                                }
                                            }

                                            for(int index1 = 0; index1 < 256; ++index1) {
                                                rnd = (double)(4L + Math.round(Math.random() * 16.0));
                                                if (rnd == 5.0) {
                                                    tick = 50.0;
                                                    break;
                                                }

                                                if (rnd == 6.0) {
                                                    tick = 50.0;
                                                    if (!infinity && !vsMahoraga) {
                                                        if (entity instanceof Mob) {
                                                            _mobEnt = (Mob)entity;
                                                            var46 = _mobEnt.getTarget();
                                                        } else {
                                                            var46 = null;
                                                        }

                                                        if (!(var46 instanceof GojoSatoruEntity)) {
                                                            if (entity instanceof Mob) {
                                                                _mobEnt = (Mob)entity;
                                                                var46 = _mobEnt.getTarget();
                                                            } else {
                                                                var46 = null;
                                                            }

                                                            if (!(var46 instanceof JogoEntity) && !(distance > 4.0)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 7.0) {
                                                    tick = 250.0;
                                                    if (!infinity) {
                                                        if (entity instanceof Mob) {
                                                            _mobEnt = (Mob)entity;
                                                            var46 = _mobEnt.getTarget();
                                                        } else {
                                                            var46 = null;
                                                        }

                                                        if (!(var46 instanceof GojoSatoruEntity)) {
                                                            if (entity instanceof Mob) {
                                                                _mobEnt = (Mob)entity;
                                                                var46 = _mobEnt.getTarget();
                                                            } else {
                                                                var46 = null;
                                                            }

                                                            if (!(var46 instanceof JogoEntity) && !(entity.getPersistentData().getDouble("cnt_target") <= 200.0) && (!vsMahoraga || entity.getPersistentData().getBoolean("flag1")) && !(Math.random() < 0.9) && !entity.getPersistentData().getBoolean("flag2") && !(distance < 5.0)) {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                } else if (rnd == 20.0) {
                                                    tick = 20.0;
                                                    if (!mahoraga_exist && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                if (rnd > 0.0) {
                                    if (rnd == 20.0 && entity.getPersistentData().getDouble("brokenBrain") == 0.0) {
                                        entity.getPersistentData().putDouble("skill", 1.0);
                                        ReturnShadowProcedure.execute(world, x, y, z, entity);
                                    }

                                    if (mahoraga_exist && rnd == 7.0) {
                                        tick = 100.0;
                                        entity.getPersistentData().putDouble("skill", 1007.0);
                                    } else {
                                        entity.getPersistentData().putDouble("skill", 100.0 + rnd);
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity)entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                                        }
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entity = (LivingEntity)entity;
                                        if (!_entity.level().isClientSide()) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                        }
                                    }
                                } else {
                                    CalculateAttackProcedure.execute(world, x, y, z, entity);
                                }
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt80 = (LivingEntity)entity;
                            if (_livEnt80.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                entity.getPersistentData().putBoolean("flag1", false);
                                entity.getPersistentData().putBoolean("flag2", false);
                            }
                        }
                    } else {
                        entity.getPersistentData().putBoolean("flag1", false);
                        entity.getPersistentData().putBoolean("flag2", false);
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        entity.getPersistentData().putDouble("cnt_rest", entity.getPersistentData().getDouble("cnt_rest") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_rest") > 120.0) {
                            entity.getPersistentData().putDouble("cnt_rest", 0.0);
                            entity.getPersistentData().putDouble("skill", 1.0);
                            ReturnShadowProcedure.execute(world, x, y, z, entity);
                            entity.getPersistentData().putDouble("skill", 0.0);
                        }
                    }
                }
            }

        }
        SpiderWebProcedure.execute(world, x, y, z, entity);
        ci.cancel();
    }
}