package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraft.entity.RikaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = AIOkkotsuProcedure.class, priority = 3000)
public abstract class AIOkkotsuMixin {

    /**
     * @author Satushi
     * @reason Adds The Spider Web Cleave to Sukuna Entity
     */

    @Inject(method = "execute", at = @At("HEAD"), remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            ItemStack ITEM1 = ItemStack.EMPTY;
            boolean StrongEnemy = false;
            boolean PureLoveCannon = false;
            boolean use_copy = false;
            boolean domain = false;
            boolean awaked = false;
            double rnd = 0.0;
            double tick = 0.0;
            double NUM_COPY = 0.0;
            double copyNum = 0.0;
            double distance = 0.0;
            double level_strength = 0.0;
            double level_resistance = 0.0;
            double level_physical_gifted = 0.0;
            if (entity.isAlive()) {
                LivingEntity _livEnt;
                LivingEntity _livEnt50;
                label547: {
                    AIActiveProcedure.execute(world, x, y, z, entity);
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                            break label547;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt50 = (LivingEntity)entity;
                        if (!_livEnt50.level().isClientSide()) {
                            _livEnt50.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity ? 20 : 18, false, false));
                        }
                    }
                }

                label542: {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                            break label542;
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt50 = (LivingEntity)entity;
                        if (!_livEnt50.level().isClientSide()) {
                            _livEnt50.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 3, false, false));
                        }
                    }
                }

                ItemStack var46;
                if (entity.getPersistentData().getDouble("mode") > 20.0) {
                    AIAttackProcedure.execute(world, x, y, z, entity);
                } else {
                    LivingEntity var10000;
                    if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    LivingEntity _entGetArmor;
                    Entity _ent;
                    CompoundTag _nbtTag;
                    if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                        entity.getPersistentData().putDouble("cnt_rika", 0.0);
                        entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                            entity.getPersistentData().putDouble("cnt_x", 0.0);
                            Mob _mobEnt;
                            if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity) {
                                CompoundTag var52 = entity.getPersistentData();
                                float var10002;
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    var10002 = _livEnt.getHealth();
                                } else {
                                    var10002 = -1.0F;
                                }

                                double var48 = (double)var10002;
                                float var10003;
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var10003 = _entGetArmor.getMaxHealth();
                                } else {
                                    var10003 = -1.0F;
                                }

                                boolean var51;
                                label526: {
                                    if (var48 < (double)var10003 * 0.5) {
                                        int var49;
                                        label523: {
                                            if (entity instanceof LivingEntity) {
                                                _entGetArmor = (LivingEntity)entity;
                                                if (_entGetArmor.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                    var49 = _entGetArmor.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                    break label523;
                                                }
                                            }

                                            var49 = 0;
                                        }

                                        var49 -= 10;
                                        LivingEntity var50;
                                        if (entity instanceof Mob) {
                                            _mobEnt = (Mob)entity;
                                            var50 = _mobEnt.getTarget();
                                        } else {
                                            var50 = null;
                                        }

                                        int var53;
                                        label517: {
                                            _livEnt = var50;
                                            if (_livEnt instanceof LivingEntity) {
                                                _livEnt50 = (LivingEntity)_livEnt;
                                                if (_livEnt50.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                    var53 = _livEnt50.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                    break label517;
                                                }
                                            }

                                            var53 = 0;
                                        }

                                        if (var49 <= var53) {
                                            var51 = true;
                                            break label526;
                                        }
                                    }

                                    var51 = false;
                                }

                                var52.putBoolean("flag_domain", var51);
                                domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            _livEnt = var10000;
                            if (_livEnt instanceof Mob) {
                                _mobEnt = (Mob)_livEnt;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            label509: {
                                if (!(var10000 instanceof RikaEntity)) {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    _livEnt = var10000;
                                    if (_livEnt instanceof Mob) {
                                        _mobEnt = (Mob)_livEnt;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (!(var10000 instanceof Rika2Entity)) {
                                        break label509;
                                    }
                                }

                                if (LocateRikaProcedure.execute(world, entity)) {
                                    TechniqueRika2Procedure.execute(world, entity);
                                }
                            }

                            double var55;
                            if (entity instanceof OkkotsuYutaEntity) {
                                boolean var56;
                                label501: {
                                    label500: {
                                        if (LocateRikaProcedure.execute(world, entity)) {
                                            float var54;
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                var54 = _livEnt.getHealth();
                                            } else {
                                                var54 = -1.0F;
                                            }

                                            var55 = (double)var54;
                                            float var10001;
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                var10001 = _livEnt.getMaxHealth();
                                            } else {
                                                var10001 = -1.0F;
                                            }

                                            if (var55 <= (double)var10001 * 0.2) {
                                                break label500;
                                            }

                                            if (entity instanceof Mob) {
                                                _mobEnt = (Mob)entity;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000.getPersistentData().getDouble("skill") % 100.0 == 15.0) {
                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob)entity;
                                                    var10000 = _mobEnt.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                if (var10000.getPersistentData().getDouble("skill") != 1815.0) {
                                                    break label500;
                                                }

                                                if (entity instanceof Mob) {
                                                    _mobEnt = (Mob)entity;
                                                    var10000 = _mobEnt.getTarget();
                                                } else {
                                                    var10000 = null;
                                                }

                                                if (var10000.getPersistentData().getDouble("cnt9") >= 20.0) {
                                                    if (entity instanceof Mob) {
                                                        _mobEnt = (Mob)entity;
                                                        var10000 = _mobEnt.getTarget();
                                                    } else {
                                                        var10000 = null;
                                                    }

                                                    if (var10000.getPersistentData().getDouble("cnt9") <= 25.0) {
                                                        break label500;
                                                    }
                                                }
                                            }
                                        }

                                        var56 = false;
                                        break label501;
                                    }

                                    var56 = true;
                                }

                                PureLoveCannon = var56;
                            }

                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            int var57;
                            label482: {
                                _entGetArmor = var10000;
                                if (_entGetArmor instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)_entGetArmor;
                                    if (_entGetArmor.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var57 = _entGetArmor.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label482;
                                    }
                                }

                                var57 = 0;
                            }

                            int var47;
                            label477: {
                                var55 = (double)var57;
                                if (entity instanceof LivingEntity) {
                                    _livEnt50 = (LivingEntity)entity;
                                    if (_livEnt50.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                        var47 = _livEnt50.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                        break label477;
                                    }
                                }

                                var47 = 0;
                            }

                            StrongEnemy = var55 >= (double)var47 * 0.5 || entity.getPersistentData().getDouble("cnt_target") > 600.0;
                            ResetCounterProcedure.execute(entity);
                            rnd = 0.0;
                            if (LogicStartProcedure.execute(entity) || domain) {
                                if (domain) {
                                    entity.getPersistentData().putBoolean("flag_domain", false);
                                    rnd = 20.0;
                                    tick = 20.0;
                                } else if ((LocateRikaProcedure.execute(world, entity) || !StrongEnemy) && !PureLoveCannon) {
                                    if (Math.random() > 0.75) {
                                        rnd = 10.0;
                                        tick = 75.0;
                                    } else if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() > 0.95 && entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity && StrongEnemy) {
                                        rnd = 20.0;
                                        tick = 20.0;
                                    } else {
                                        int index1;
                                        if (Math.random() > 0.8) {
                                            distance = GetDistanceProcedure.execute(world, entity);

                                            for(index1 = 0; index1 < 256; ++index1) {
                                                rnd = (double)Math.round(Math.random() * 10.0);
                                                if (rnd == 3.0) {
                                                    tick = 20.0;
                                                    if (!(distance < 6.0)) {
                                                        break;
                                                    }
                                                } else if (rnd == 5.0) {
                                                    tick = 250.0;
                                                    if (!(Math.random() < 0.5)) {
                                                        break;
                                                    }
                                                } else if (rnd == 6.0) {
                                                    tick = 60.0;
                                                    if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity  && !(distance < 6.0)) {
                                                        break;
                                                    }
                                                } else if (rnd == 7.0) {
                                                    tick = 100.0;
                                                    if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity && !(distance > 6.0)) {
                                                        break;
                                                    }
                                                } else if (rnd == 10.0) {
                                                    tick = 10.0;
                                                    if (!(Math.random() < 0.5)) {
                                                        break;
                                                    }
                                                }
                                            }
                                        } else {
                                            label563: {
                                                if (entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof YutaCullingGamesEntity  && Math.random() > 0.8 && GetDistanceProcedure.execute(world, entity) < 4.0 && entity instanceof LivingEntity) {
                                                    _livEnt50 = (LivingEntity)entity;
                                                    if (_livEnt50.hasEffect((MobEffect) JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                                                        use_copy = true;
                                                        rnd = 106.0;
                                                        tick = 50.0;
                                                        break label563;
                                                    }
                                                }

                                                use_copy = false;
                                                NUM_COPY = Math.floor(Math.random() * 4.0);

                                                for(index1 = 0; index1 < 4; ++index1) {
                                                    if (entity instanceof LivingEntity) {
                                                        _entGetArmor = (LivingEntity)entity;
                                                        var46 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int)NUM_COPY));
                                                    } else {
                                                        var46 = ItemStack.EMPTY;
                                                    }

                                                    ITEM1 = var46;
                                                    if (ITEM1.getOrCreateTag().getDouble("skill") > 0.0) {
                                                        use_copy = true;
                                                        rnd = ITEM1.getOrCreateTag().getDouble("skill");
                                                        tick = ITEM1.getOrCreateTag().getDouble("COOLDOWN_TICKS");
                                                        break;
                                                    }

                                                    ++NUM_COPY;
                                                    if (NUM_COPY > 3.0) {
                                                        NUM_COPY = 0.0;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt50 = (LivingEntity)entity;
                                        if (!_livEnt50.level().isClientSide()) {
                                            _livEnt50.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                                        }
                                    }

                                    if (PureLoveCannon) {
                                        rnd = 15.0;
                                        tick = 500.0;
                                    } else {
                                        rnd = 10.0;
                                        tick = 75.0;
                                    }
                                }
                            }

                            if (rnd > 0.0) {
                                entity.getPersistentData().putDouble("skill", (double)Math.round(use_copy ? rnd : 500.0 + rnd));
                                if (entity instanceof LivingEntity) {
                                    _livEnt50 = (LivingEntity)entity;
                                    if (!_livEnt50.level().isClientSide()) {
                                        _livEnt50.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                                    }
                                }

                                if (entity instanceof LivingEntity) {
                                    _livEnt50 = (LivingEntity)entity;
                                    if (!_livEnt50.level().isClientSide()) {
                                        _livEnt50.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                                    }
                                }

                                if (rnd == 15.0) {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt50 = (LivingEntity)entity;
                                        var46 = _livEnt50.getMainHandItem();
                                    } else {
                                        var46 = ItemStack.EMPTY;
                                    }

                                    if (var46.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity)entity;
                                            var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var46 = ItemStack.EMPTY;
                                        }

                                        if (var46.getItem() == ItemStack.EMPTY.getItem()) {
                                            _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                                            }

                                            if (entity instanceof LivingEntity) {
                                                _entGetArmor = (LivingEntity)entity;
                                                var46 = _entGetArmor.getMainHandItem();
                                            } else {
                                                var46 = ItemStack.EMPTY;
                                            }

                                            _nbtTag = var46.getTag();
                                            if (_nbtTag != null) {
                                                if (entity instanceof LivingEntity) {
                                                    _entGetArmor = (LivingEntity)entity;
                                                    var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                                } else {
                                                    var46 = ItemStack.EMPTY;
                                                }

                                                var46.setTag(_nbtTag.copy());
                                            }

                                            _ent = entity;
                                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with air");
                                            }
                                        }
                                    }
                                }
                            } else if (PureLoveCannon) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt50 = (LivingEntity)entity;
                                    if (!_livEnt50.level().isClientSide()) {
                                        _livEnt50.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 19, false, false));
                                    }
                                }

                                entity.getPersistentData().putDouble("cnt_x", 5.0);
                            } else {
                                CalculateAttackProcedure.execute(world, x, y, z, entity);
                                if (entity instanceof LivingEntity) {
                                    _livEnt50 = (LivingEntity)entity;
                                    var46 = _livEnt50.getMainHandItem();
                                } else {
                                    var46 = ItemStack.EMPTY;
                                }

                                if (var46.getItem() == ItemStack.EMPTY.getItem()) {
                                    if (entity instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity)entity;
                                        var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                    } else {
                                        var46 = ItemStack.EMPTY;
                                    }

                                    if (var46.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with jujutsucraft:sword_okkotsu_yuta");
                                        }

                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity)entity;
                                            var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var46 = ItemStack.EMPTY;
                                        }

                                        _nbtTag = var46.getTag();
                                        if (_nbtTag != null) {
                                            if (entity instanceof LivingEntity) {
                                                _entGetArmor = (LivingEntity)entity;
                                                var46 = _entGetArmor.getMainHandItem();
                                            } else {
                                                var46 = ItemStack.EMPTY;
                                            }

                                            var46.setTag(_nbtTag.copy());
                                        }

                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with air");
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        entity.getPersistentData().putDouble("cnt_rika", entity.getPersistentData().getDouble("cnt_rika") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_rika") % 200.0 == 190.0) {
                            if (LocateRikaProcedure.execute(world, entity)) {
                                TechniqueRika2Procedure.execute(world, entity);
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt50 = (LivingEntity)entity;
                                var46 = _livEnt50.getMainHandItem();
                            } else {
                                var46 = ItemStack.EMPTY;
                            }

                            if (var46.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                                if (entity instanceof LivingEntity) {
                                    _entGetArmor = (LivingEntity)entity;
                                    var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                } else {
                                    var46 = ItemStack.EMPTY;
                                }

                                if (var46.getItem() == ItemStack.EMPTY.getItem()) {
                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _entGetArmor = (LivingEntity)entity;
                                        var46 = _entGetArmor.getMainHandItem();
                                    } else {
                                        var46 = ItemStack.EMPTY;
                                    }

                                    _nbtTag = var46.getTag();
                                    if (_nbtTag != null) {
                                        if (entity instanceof LivingEntity) {
                                            _entGetArmor = (LivingEntity)entity;
                                            var46 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                        } else {
                                            var46 = ItemStack.EMPTY;
                                        }

                                        var46.setTag(_nbtTag.copy());
                                    }

                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s weapon.mainhand with air");
                                    }
                                }
                            }
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var46 = _livEnt.getMainHandItem();
                    } else {
                        var46 = ItemStack.EMPTY;
                    }

                    if (var46.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "item replace entity @s weapon.mainhand with air");
                    }
                }
            }

        }
        ci.cancel();
    }
}
