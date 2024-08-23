package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.FushiguroMegumiEntity;
import net.mcreator.jujutsucraft.entity.FushiguroMegumiShibuyaEntity;
import net.mcreator.jujutsucraft.entity.KenjakuEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables.MapVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionBattleProcedure;
import net.mcreator.jujutsucraft.procedures.DomainExpansionCreateBarrierProcedure;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.RotateEntityProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.BarrierlessAndCompressedProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Mixin(value = DomainExpansionCreateBarrierProcedure.class, remap = false)
public abstract class FormationBarrierMixin {
    public FormationBarrierMixin() {

    }

    /**
     * @author Satushi
     * @reason Changes
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            String STR1 = "";
            double x_dis = 0.0;
            double loop_num = 0.0;
            double x_pos = 0.0;
            double z_dis = 0.0;
            double domainRadius = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double y_dis = 0.0;
            double dis = 0.0;
            double pitch = 0.0;
            double yaw = 0.0;
            double power = 0.0;
            boolean reStart = false;
            boolean update_pos = false;
            boolean old_failed = false;
            CompoundTag var10000;
            double var10002;
            LivingEntity _entity;
            Mob _mobEnt;
            LivingEntity var69;

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessDomain) {
                BarrierlessAndCompressedProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt3") < 20.0) {
                entity.getPersistentData().putDouble("select", 0.0);
                if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                    entity.getPersistentData().putDouble("cnt4", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                }

                byte var10003;
                label340: {
                    var10000 = entity.getPersistentData();
                    var10002 = entity.getPersistentData().getDouble("cnt3");
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                            var10003 = 2;
                            break label340;
                        }
                    }

                    var10003 = 1;
                }

                var10000.putDouble("cnt3", var10002 + (double)var10003);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var69 = _mobEnt.getTarget();
                } else {
                    var69 = null;
                }

                if (var69 instanceof LivingEntity) {
                    entity.getPersistentData().putDouble("cnt3", 20.0);
                } else {
                    Player _player;
                    if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                        power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt3")) * 0.25);
                        STR1 = Component.translatable("jujutsu.message.long_press").getString();

                        for(int index0 = 0; index0 < (int)power; ++index0) {
                            STR1 = "■" + STR1 + "■";
                        }

                        if (entity instanceof Player) {
                            _player = (Player)entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(STR1), true);
                            }
                        }

                        if (entity.getPersistentData().getDouble("cnt3") >= 20.0 && entity instanceof Player) {
                            _player = (Player)entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(""), true);
                            }
                        }
                    } else {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().getDouble("cnt4");
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                        if (entity instanceof Player) {
                            _player = (Player)entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(""), true);
                            }
                        }

                        entity.getPersistentData().putDouble("select", 0.0);
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            } else {
                domainRadius = MapVariables.get(world).DomainExpansionRadius;
                entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
                entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), 0.0), 0.0));
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                    }
                }

                if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                    entity.getPersistentData().putDouble("cnt7", 1.0);
                    Iterator var39;
                    ServerPlayer _plr59;
                    if (entity instanceof Player && Math.random() < 0.01 && entity instanceof ServerPlayer) {
                        _plr59 = (ServerPlayer)entity;
                        Advancement _adv = _plr59.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"));
                        AdvancementProgress _ap = _plr59.getAdvancements().getOrStartProgress(_adv);
                        if (!_ap.isDone()) {
                            var39 = _ap.getRemainingCriteria().iterator();

                            while(var39.hasNext()) {
                                String criteria = (String)var39.next();
                                _plr59.getAdvancements().award(_adv, criteria);
                            }
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var69 = _mobEnt.getTarget();
                    } else {
                        var69 = null;
                    }

                    LivingEntity var74;
                    double var76;
                    LivingEntity var78;
                    if (var69 instanceof LivingEntity) {
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var69 = _mobEnt.getTarget();
                        } else {
                            var69 = null;
                        }

                        Level var75 = var69.level();
                        ClipContext var10001 = new ClipContext (entity.getEyePosition(1.0F), var69.getEyePosition(1.0F), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var78 = _mobEnt.getTarget();
                        } else {
                            var78 = null;
                        }

                        Vec3 var80 = var78.getEyePosition(1.0F);
                        LivingEntity var10004;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10004 = _mobEnt.getTarget();
                        } else {
                            var10004 = null;
                        }

                        Vec3 var81 = var10004.getEyePosition(1.0F);
                        LivingEntity var10005;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10005 = _mobEnt.getTarget();
                        } else {
                            var10005 = null;
                        }

                        var81 = var81.add(var10005.getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var83 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10007 = _mobEnt.getTarget();
                        } else {
                            var10007 = null;
                        }

                        var10001 = new ClipContext(var80, var81, var83, var10006, var10007);
                        var76 = (double)var75.clip(var10001).getBlockPos().getX();
                        LivingEntity var70;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var70 = _mobEnt.getTarget();
                        } else {
                            var70 = null;
                        }

                        Level var71 = var70.level();
                        ClipContext var72 = new ClipContext(var80, var81, var83, var10006, var10007);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10004 = _mobEnt.getTarget();
                        } else {
                            var10004 = null;
                        }

                        var81 = var10004.getEyePosition(1.0F);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10005 = _mobEnt.getTarget();
                        } else {
                            var10005 = null;
                        }

                        Vec3 var85 = var10005.getEyePosition(1.0F);
                        LivingEntity var84;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var84 = _mobEnt.getTarget();
                        } else {
                            var84 = null;
                        }

                        var85 = var85.add(var84.getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var86 = Block.OUTLINE;
                        ClipContext.Fluid var87 = Fluid.NONE;
                        LivingEntity var10008;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10008 = _mobEnt.getTarget();
                        } else {
                            var10008 = null;
                        }

                        var72 = new ClipContext (var81, var85, var86, var87, var10008);
                        double var73 = (double)var71.clip(var72).getBlockPos().getY();
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var74 = _mobEnt.getTarget();
                        } else {
                            var74 = null;
                        }

                        Level var77 = var74.level();
                        ClipContext var82 = new ClipContext(var81, var85, var86, var87, var10008);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10005 = _mobEnt.getTarget();
                        } else {
                            var10005 = null;
                        }

                        var85 = var10005.getEyePosition(1.0F);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var84 = _mobEnt.getTarget();
                        } else {
                            var84 = null;
                        }

                        Vec3 var88 = var84.getEyePosition(1.0F);
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10007 = _mobEnt.getTarget();
                        } else {
                            var10007 = null;
                        }

                        var88 = var88.add(var10007.getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var90 = Block.OUTLINE;
                        ClipContext.Fluid var89 = Fluid.NONE;
                        LivingEntity var10009;
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob)entity;
                            var10009 = _mobEnt.getTarget();
                        } else {
                            var10009 = null;
                        }

                        var82 = new ClipContext(var85, var88, var90, var89, var10009);
                        RotateEntityProcedure.execute(var76, var73, (double)var77.clip(var82).getBlockPos().getZ(), entity);
                    }

                    LivingEntity _livEnt63;
                    label533: {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                break label533;
                            }
                        }

                        yaw = (double)entity.getYRot();
                        pitch = (double)entity.getXRot();
                        entity.setYRot(entity.getYRot());
                        entity.setXRot(0.0F);
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity) {
                            _livEnt63 = (LivingEntity)entity;
                            _livEnt63.yBodyRotO = _livEnt63.getYRot();
                            _livEnt63.yHeadRotO = _livEnt63.getYRot();
                        }

                        entity.getPersistentData().putDouble("x_pos_doma", (double)Math.round(entity.getX() + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
                        var10000 = entity.getPersistentData();
                        if (entity instanceof Mob) {
                            _mobEnt = (Mob) entity;
                            var74 = _mobEnt.getTarget();
                        } else {
                            var74 = null;
                        }

                        if (var74 instanceof LivingEntity) {
                            var10002 = entity.getY();
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var78 = _mobEnt.getTarget();
                            } else {
                                var78 = null;
                            }

                            var10002 = Math.min(var10002, var78.getY());
                        } else {
                            var10002 = entity.getY();
                        }

                        var10000.putDouble("y_pos_doma", (double)Math.round(var10002));
                        entity.getPersistentData().putDouble("z_pos_doma", (double)Math.round(entity.getZ() + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * domainRadius * 0.5));
                        entity.setYRot((float)yaw);
                        entity.setXRot((float)pitch);
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity) {
                            _livEnt63 = (LivingEntity)entity;
                            _livEnt63.yBodyRotO = _livEnt63.getYRot();
                            _livEnt63.yHeadRotO = _livEnt63.getYRot();
                        }
                    }

                    label503: {
                        label567: {
                            if (entity.getPersistentData().getDouble("select") == 1.0 || entity.getPersistentData().getDouble("select") == 18.0) {
                                if (!(entity instanceof Player)) {
                                    if (entity instanceof KenjakuEntity) {
                                        break label567;
                                    }

                                    if (entity instanceof LivingEntity) {
                                        _livEnt63 = (LivingEntity)entity;
                                        if (_livEnt63.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                            break label567;
                                        }
                                    }
                                } else {
                                    label551: {
                                        label536: {
                                            if (entity instanceof ServerPlayer) {
                                                _plr59 = (ServerPlayer)entity;
                                                if (_plr59.level() instanceof ServerLevel && _plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_open_barrier_type_domain"))).isDone()) {
                                                    break label536;
                                                }
                                            }

                                            if (!(entity instanceof LivingEntity)) {
                                                break label551;
                                            }

                                            LivingEntity _livEnt60 = (LivingEntity)entity;
                                            if (!_livEnt60.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                break label551;
                                            }
                                        }

                                        if (!entity.isShiftKeyDown()) {
                                            break label567;
                                        }
                                    }
                                }
                            }

                            if (!(entity instanceof FushiguroMegumiEntity) && !(entity instanceof FushiguroMegumiShibuyaEntity)) {
                                entity.getPersistentData().putDouble("cnt2", 0.0);
                                break label503;
                            }

                            entity.getPersistentData().putDouble("cnt2", -1.0);
                            break label503;
                        }

                        entity.getPersistentData().putDouble("cnt2", 1.0);
                    }

                    reStart = false;
                    update_pos = false;
                    entity.getPersistentData().putBoolean("Failed", false);
                    entity.getPersistentData().putBoolean("Cover", false);
                    int index1 = 0;

                    label472:
                    while(index1 < 2) {
                        entity.getPersistentData().putDouble("x_pos_doma2", (double)Math.round((float)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX()));
                        entity.getPersistentData().putDouble("y_pos_doma2", (double)Math.round((float)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY()));
                        entity.getPersistentData().putDouble("z_pos_doma2", (double)Math.round((float)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ()));
                        Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());
                        List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(domainRadius * 2.0 * 2.0 / 2.0), (e) -> {
                            return true;
                        }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                            return _entcnd.distanceToSqr(_center);
                        })).toList();
                        var39 = _entfound.iterator();

                        while(true) {
                            LivingEntity _livEnt123;
                            LivingEntity _livEnt;
                            Entity entityiterator;
                            int var79;
                            do {
                                while(true) {
                                    do {
                                        LivingEntity _livEnt88;
                                        do {
                                            if (!var39.hasNext()) {
                                                if (!reStart || entity.getPersistentData().getBoolean("Failed") || update_pos) {
                                                    break label472;
                                                }

                                                entity.teleportTo(x_pos, y_pos, z_pos);
                                                if (entity instanceof ServerPlayer) {
                                                    ServerPlayer _serverPlayer = (ServerPlayer)entity;
                                                    _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                                                }

                                                entity.getPersistentData().putDouble("x_pos_doma", x_pos);
                                                entity.getPersistentData().putDouble("y_pos_doma", y_pos);
                                                entity.getPersistentData().putDouble("z_pos_doma", z_pos);
                                                update_pos = true;
                                                ++index1;
                                                continue label472;
                                            }

                                            entityiterator = (Entity)var39.next();
                                            dis = Math.sqrt(Math.pow(entity.getX() - entityiterator.getX(), 2.0) + Math.pow(entity.getY() - entityiterator.getY(), 2.0) + Math.pow(entity.getZ() - entityiterator.getZ(), 2.0));
                                            if (dis < domainRadius) {
                                                if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                                                    _livEnt88 = (LivingEntity)entityiterator;
                                                    if (!_livEnt88.level().isClientSide()) {
                                                        _livEnt88.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)(domainRadius * 2.0 + 1.0), 9, false, false));
                                                    }
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt88 = (LivingEntity)entityiterator;
                                                    if (_livEnt88.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        continue;
                                                    }
                                                }

                                                if (entityiterator.getPersistentData().getDouble("select") == 0.0 && entityiterator instanceof LivingEntity) {
                                                    _livEnt123 = (LivingEntity)entityiterator;
                                                    if (!_livEnt123.level().isClientSide()) {
                                                        _livEnt123.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), (int)(domainRadius * 2.0 + 20.0), (int)(entity.getPersistentData().getDouble("select") + 10.0), false, false));
                                                    }
                                                }
                                            }
                                        } while(entity.getPersistentData().getDouble("brokenBrain") != 0.0);

                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt88 = (LivingEntity)entityiterator;
                                            if (_livEnt88.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                break;
                                            }
                                        }
                                    } while(entityiterator.getPersistentData().getDouble("select") == 0.0);

                                    dis = Math.sqrt(Math.pow(entity.getX() - entityiterator.getPersistentData().getDouble("x_pos_doma"), 2.0) + Math.pow(entity.getY() - entityiterator.getPersistentData().getDouble("y_pos_doma"), 2.0) + Math.pow(entity.getZ() - entityiterator.getPersistentData().getDouble("z_pos_doma"), 2.0));
                                    if (dis < domainRadius - 1.0) {
                                        if (entity != entityiterator) {
                                            label451: {
                                                label546: {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _livEnt123 = (LivingEntity)entityiterator;
                                                        if (_livEnt123.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                            label445: {
                                                                if (entityiterator instanceof LivingEntity) {
                                                                    _livEnt = (LivingEntity)entityiterator;
                                                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                        var79 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                                        break label445;
                                                                    }
                                                                }

                                                                var79 = 0;
                                                            }

                                                            if (var79 <= 0) {
                                                                break label451;
                                                            }
                                                            break label546;
                                                        }
                                                    }

                                                    if (entityiterator.getPersistentData().getDouble("select") == 0.0 || !(entityiterator.getPersistentData().getDouble("cnt2") > 0.0)) {
                                                        break label451;
                                                    }
                                                }

                                                if (!update_pos) {
                                                    entityiterator.getPersistentData().putDouble("x_pos_doma", entity.getPersistentData().getDouble("x_pos_doma"));
                                                    entityiterator.getPersistentData().putDouble("y_pos_doma", entity.getPersistentData().getDouble("y_pos_doma"));
                                                    entityiterator.getPersistentData().putDouble("z_pos_doma", entity.getPersistentData().getDouble("z_pos_doma"));
                                                    update_pos = true;
                                                    break;
                                                }
                                            }

                                            entity.getPersistentData().putDouble("x_pos_doma", entityiterator.getPersistentData().getDouble("x_pos_doma"));
                                            entity.getPersistentData().putDouble("y_pos_doma", entityiterator.getPersistentData().getDouble("y_pos_doma"));
                                            entity.getPersistentData().putDouble("z_pos_doma", entityiterator.getPersistentData().getDouble("z_pos_doma"));
                                            update_pos = true;
                                        }
                                        break;
                                    }

                                    if (dis < domainRadius * 2.0 && !reStart && entity != entityiterator) {
                                        label545: {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt123 = (LivingEntity)entityiterator;
                                                if (_livEnt123.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                    label424: {
                                                        if (entityiterator instanceof LivingEntity) {
                                                            _livEnt = (LivingEntity)entityiterator;
                                                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                var79 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                                break label424;
                                                            }
                                                        }

                                                        var79 = 0;
                                                    }

                                                    if (var79 != 0) {
                                                        continue;
                                                    }
                                                    break label545;
                                                }
                                            }

                                            if (entityiterator.getPersistentData().getDouble("select") == 0.0 || !(entityiterator.getPersistentData().getDouble("cnt2") <= 0.0)) {
                                                continue;
                                            }
                                        }

                                        reStart = true;
                                        x_pos = entityiterator.getPersistentData().getDouble("x_pos_doma");
                                        y_pos = entityiterator.getPersistentData().getDouble("y_pos_doma");
                                        z_pos = entityiterator.getPersistentData().getDouble("z_pos_doma");
                                    }
                                }
                            } while(entity == entityiterator);

                            entity.getPersistentData().putBoolean("Failed", true);
                            if (entityiterator instanceof LivingEntity) {
                                _livEnt123 = (LivingEntity)entityiterator;
                                if (_livEnt123.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    label466: {
                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entityiterator;
                                            if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var79 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                break label466;
                                            }
                                        }

                                        var79 = 0;
                                    }

                                    if (var79 == 0) {
                                        entity.getPersistentData().putDouble("cnt5", 1.0);
                                    }
                                }
                            }

                            if (entityiterator instanceof LivingEntity) {
                                _livEnt123 = (LivingEntity)entityiterator;
                                if (_livEnt123.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entityiterator.getPersistentData().getBoolean("Cover")) {
                                    entityiterator.getPersistentData().putBoolean("Failed", true);
                                }
                            }
                        }
                    }

                    Vec3 _center = new Vec3(entity.getX(), entity.getY(), entity.getZ());
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(10.0), (e) -> {
                        return true;
                    }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                        return _entcnd.distanceToSqr(_center);
                    })).toList();
                    Iterator var59 = _entfound.iterator();

                    label377:
                    while(true) {
                        Entity entityiterator;
                        do {
                            do {
                                do {
                                    do {
                                        if (!var59.hasNext()) {
                                            break label377;
                                        }

                                        entityiterator = (Entity)var59.next();
                                    } while(entity == entityiterator);
                                } while(entityiterator.isInvulnerable());

                                x_dis = entityiterator.getX() - entity.getX();
                                y_dis = entityiterator.getY() - entity.getY();
                                z_dis = entityiterator.getZ() - entity.getZ();
                                dis = Math.sqrt(Math.pow(x_dis, 2.0) + Math.pow(z_dis, 2.0));
                            } while(!(dis > 0.0));
                        } while(!(dis < 10.0));

                        x_dis /= dis;
                        var76 = y_dis / dis;
                        z_dis /= dis;
                        x_pos = entityiterator.getX();
                        y_pos = entityiterator.getY();
                        z_pos = entityiterator.getZ();
                        loop_num = Math.ceil(10.0 - dis);

                        for(int index2 = 0; index2 < (int)Math.round(loop_num); ++index2) {
                            dis = Math.sqrt(Math.pow(x_pos - entity.getPersistentData().getDouble("x_pos_doma"), 2.0) + Math.pow(y_pos - entity.getPersistentData().getDouble("y_pos_doma"), 2.0) + Math.pow(z_pos - entity.getPersistentData().getDouble("z_pos_doma"), 2.0));
                            if (dis > MapVariables.get(world).DomainExpansionRadius - 3.0) {
                                break;
                            }

                            x_pos += x_dis;
                            z_pos += z_dis;
                            if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                                ++y_pos;
                            }
                        }

                        entityiterator.teleportTo(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                            ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                            _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityiterator.getYRot(), entityiterator.getXRot());
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("brokenBrain") == 0.0) {
                    if (entity.getPersistentData().getBoolean("Failed") && entity.getPersistentData().getDouble("cnt5") > 0.0) {
                        if (entity.getPersistentData().getDouble("cnt1") > 1.0) {
                            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") < 34.0 ? 34.0 : Math.max(50.0, domainRadius * 2.0) + 5.0);
                        }
                    } else {
                        old_failed = entity.getPersistentData().getBoolean("Failed");
                        entity.getPersistentData().putBoolean("Failed", false);
                        x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                        y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                        z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                        entity.getPersistentData().putDouble("cnt_cover", entity.getPersistentData().getDouble("cnt1"));
                        DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        entity.getPersistentData().putBoolean("Failed", old_failed);
                    }

                    if (entity.getPersistentData().getDouble("cnt1") >= Math.max(34.0, domainRadius * 2.0 + 1.0)) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 200.0;
                        double final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        entity.getPersistentData().putBoolean("StartDomainAttack", true);
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity)entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), entity.getPersistentData().getDouble("select") == 29.0 ? 3600 : 1200, (int)entity.getPersistentData().getDouble("cnt2"), true, false));
                            }
                        }

                        entity.getPersistentData().putDouble("skill", 0.0);
                        _setval = 0.0;
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerSelectCurseTechnique = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        boolean _setval2 = true;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.noChangeTechnique = _setval2;
                            capability.syncPlayerVariables(entity);
                        });
                        KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    }
                } else if (entity.getPersistentData().getDouble("cnt1") >= 5.0) {
                    if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.5)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ(), 5, 0.1, 0.1, 0.1, 0.1);
                    }

                    if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
                        if (world instanceof Level) {
                            Level _level = (Level)world;
                            if (!_level.isClientSide()) {
                                _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.1F);
                            } else {
                                _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.1F, false);
                            }
                        }

                        entity.getPersistentData().putDouble("brokenBrain", 2.0);
                        entity.getPersistentData().putDouble("select", 0.0);
                        entity.getPersistentData().putDouble("skill", 0.0);
                    }
                }
            }

        }
    }
}
