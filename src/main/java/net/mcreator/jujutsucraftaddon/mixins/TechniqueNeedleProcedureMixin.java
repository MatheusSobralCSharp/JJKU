package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.NeedleEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
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

@Mixin(value = TechniqueNeedleProcedure.class, priority = 3000)
public abstract class TechniqueNeedleProcedureMixin {
    /**
     * @author Satushi
     * @reason Changes Damage Fix
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            Entity entity_a = null;
            boolean SUCCESS = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double dis = 0.0;
            double old_skill = 0.0;
            double HP = 0.0;
            double range = 0.0;
            double tick = 0.0;
            double MAX_ST = 0.0;
            double picth = 0.0;
            double yaw = 0.0;
            double NUM1 = 0.0;
            double NUM2 = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            LivingEntity _livEnt;
            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
                }
            }

            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity)entity;
                if (!_livEnt.level().isClientSide()) {
                    _livEnt.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
                }
            }

            ItemStack var10000;
            if (!(entity instanceof Player)) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME1", 207.0);
            }

            PlayAnimationProcedure.execute(entity);
            if (entity instanceof Player) {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                var10000.getOrCreateTag().putDouble("P_ANIME1", 207.0);
            }

            LivingEntity var42;
            Mob _mobEnt;
            if (entity instanceof Mob) {
                _mobEnt = (Mob)entity;
                var42 = _mobEnt.getTarget();
            } else {
                var42 = null;
            }

            if (var42 instanceof LivingEntity) {
                EntityAnchorArgument.Anchor var10001 = EntityAnchorArgument.Anchor.EYES;
                Vec3 var10002;
                LivingEntity var10004;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10004 = _mobEnt.getTarget();
                } else {
                    var10004 = null;
                }

                double var43 = var10004.getX();
                LivingEntity var10005;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10005 = _mobEnt.getTarget();
                } else {
                    var10005 = null;
                }

                double var44 = var10005.getY();
                LivingEntity var10006;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var44 += (double)var10006.getBbHeight() * 0.5;
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var10006 = _mobEnt.getTarget();
                } else {
                    var10006 = null;
                }

                var10002 = new Vec3(var43, var44, var10006.getZ());
                entity.lookAt(var10001, var10002);
            }

            dis = 6.0;

            Entity _ent;
            int index1;
            for(index1 = 0; index1 < 10; ++index1) {
                x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
                y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
                z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), ClipContext.Block.VISUAL, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var39 = _entfound.iterator();

                while(var39.hasNext()) {
                    _ent = (Entity)var39.next();
                    if (entity != _ent && LogicAttackProcedure.execute(world, entity, _ent) && !_ent.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        SUCCESS = true;
                        x_pos = _ent.getX();
                        y_pos = _ent.getY();
                        z_pos = _ent.getZ();
                        break;
                    }
                }

                if (SUCCESS) {
                    break;
                }

                dis += 6.0;
            }

            NUM1 = Math.random() * 720.0;
            NUM2 = Math.random() * 3.0;
            x_pos += Math.sin(Math.toRadians(NUM1)) * NUM2;
            z_pos += Math.cos(Math.toRadians(NUM1)) * NUM2;

            for(index1 = 0; index1 < 255 && !(y_pos < 0.0); ++index1) {
                if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                    --y_pos;
                } else {
                    if (!world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).is(BlockTags.create(new ResourceLocation("jujutsucraft:barrier")))) {
                        break;
                    }

                    ++y_pos;
                }
            }

            int var41;
            label193: {
                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var41 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label193;
                    }
                }

                var41 = 0;
            }

            HP = (double)(20 + var41 * 2);
            if (world instanceof ServerLevel) {
                ServerLevel _level = (ServerLevel)world;
                Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.NEEDLE.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                if (entityToSpawn != null) {
                    entityToSpawn.setYRot((float)(NUM1 + 90.0));
                    entityToSpawn.setYBodyRot((float)(NUM1 + 90.0));
                    entityToSpawn.setYHeadRot((float)(NUM1 + 90.0));
                    entityToSpawn.setXRot((float)(Math.random() * 20.0));
                    if ((entityToSpawn) instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt1.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0, false, false));

                }
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> {
                return true;
            }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                return _entcnd.distanceToSqr(_center);
            })).toList();
            Iterator var51 = _entfound.iterator();

            while(var51.hasNext()) {
                Entity entityiterator = (Entity)var51.next();
                if (entityiterator instanceof NeedleEntity && entityiterator.getPersistentData().getDouble("NameRanged_ranged") == 0.0) {
                    SetRangedAmmoProcedure.execute(entity, entityiterator);
                    _ent = entityiterator;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:1b}");
                    }

                    ((LivingEntity)entityiterator).getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                    ((LivingEntity)entityiterator).getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(((LivingEntity)entityiterator).getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() + entity.getPersistentData().getDouble("cnt1") * 0.02);
                    if (entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        _entity.setHealth((float)HP);
                    }
                    break;
                }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                if (entity instanceof Mob) {
                    _mobEnt = (Mob)entity;
                    var42 = _mobEnt.getTarget();
                } else {
                    var42 = null;
                }

                if (var42 instanceof LivingEntity) {
                    entity.getPersistentData().putBoolean("PRESS_Z", false);
                    if (GetDistanceNearestEnemyProcedure.execute(world, x, y, z, entity) > 6.0) {
                        label247: {
                            if (entity instanceof Mob) {
                                _mobEnt = (Mob)entity;
                                var42 = _mobEnt.getTarget();
                            } else {
                                var42 = null;
                            }

                            if (var42.getPersistentData().getDouble("skill") != 0.0) {
                                label240: {
                                    if (entity instanceof Mob) {
                                        _mobEnt = (Mob)entity;
                                        var42 = _mobEnt.getTarget();
                                    } else {
                                        var42 = null;
                                    }

                                    if (var42.getPersistentData().getDouble("skill") != 0.0) {
                                        if (entity instanceof Mob) {
                                            Mob _mobEnt3 = (Mob)entity;
                                            var42 = _mobEnt3.getTarget();
                                        } else {
                                            var42 = null;
                                        }

                                        if (var42.getPersistentData().getBoolean("attack")) {
                                            break label240;
                                        }
                                    }

                                    if (entity instanceof Mob) {
                                        Mob _mobEnt2 = (Mob)entity;
                                        var42 = _mobEnt2.getTarget();
                                    } else {
                                        var42 = null;
                                    }

                                    if (var42.getPersistentData().getDouble("Damage") != 0.0) {
                                        break label247;
                                    }
                                }
                            }

                            entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                    }
                }

                if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                    if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = _setval;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                } else {
                    entity.getPersistentData().putDouble("skill", 0.0);
                }

                if (entity.getPersistentData().getDouble("cnt2") > 60.0) {
                    entity.getPersistentData().putDouble("skill", 0.0);
                }
            }

        }
        ci.cancel();
    }
}
