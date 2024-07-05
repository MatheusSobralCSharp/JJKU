package net.mcreator.jujutsucraftaddon.mixins;


import net.mcreator.jujutsucraft.entity.CrowEntity;
import net.mcreator.jujutsucraft.entity.UraumeEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.LogicAttackDomainProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = LogicAttackProcedure.class, remap = false)
public abstract class ItemStackMixin {
    public ItemStackMixin(){
    }
    /**
     * @author Satushi
     * @reason Yes
     */
    @Overwrite
    public static boolean execute(LevelAccessor world, Entity entity, Entity entityiterator) {
        if (entity != null && entityiterator != null) {
            double velocity = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            boolean logic_attack = false;
            boolean player_iterator = false;
            boolean player_target = false;
            Entity entity_iterator = null;
            Entity entity_attacker_owner = null;
            Entity entity_iterator_owner = null;
            Entity entity_attacker = null;
            Entity entity_a = null;
            logic_attack = false;
            if (entity != entityiterator && entityiterator instanceof LivingEntity) {
                entity_iterator = entityiterator;

                int index3;
                for(index3 = 0; index3 < 100 && !entity_iterator.getPersistentData().getString("OWNER_UUID").isEmpty() && entity_iterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))); ++index3) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, entity_iterator.getPersistentData().getString("OWNER_UUID"));
                    if (!(entity_a instanceof LivingEntity)) {
                        break;
                    }

                    entity_iterator = entity_a;
                }

                entity_attacker = entity;

                for(index3 = 0; index3 < 100 && !entity_attacker.getPersistentData().getString("OWNER_UUID").isEmpty() && entity_attacker.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))); ++index3) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, entity_attacker.getPersistentData().getString("OWNER_UUID"));
                    if (!(entity_a instanceof LivingEntity)) {
                        break;
                    }

                    entity_attacker = entity_a;
                }

                entity_iterator_owner = entity_iterator;

                for(index3 = 0; index3 < 100 && !entity_iterator_owner.getPersistentData().getString("OWNER_UUID").isEmpty(); ++index3) {
                    entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                        public Entity apply(LevelAccessor levelAccessor, String uuid) {
                            if (levelAccessor instanceof ServerLevel serverLevel) {
                                try {
                                    return serverLevel.getEntity(UUID.fromString(uuid));
                                } catch (Exception var5) {
                                }
                            }

                            return null;
                        }
                    }).apply(world, entity_iterator_owner.getPersistentData().getString("OWNER_UUID"));
                    if (!(entity_a instanceof LivingEntity)) {
                        break;
                    }

                    entity_iterator_owner = entity_a;
                }

                entity_attacker_owner = entity;
                index3 = 0;

                while(true) {
                    if (index3 < 100 && !entity_attacker_owner.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                        entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                            public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                if (levelAccessor instanceof ServerLevel serverLevel) {
                                    try {
                                        return serverLevel.getEntity(UUID.fromString(uuid));
                                    } catch (Exception var5) {
                                    }
                                }

                                return null;
                            }
                        }).apply(world, entity_attacker_owner.getPersistentData().getString("OWNER_UUID"));
                        if (entity_a instanceof LivingEntity) {
                            entity_attacker_owner = entity_a;
                            ++index3;
                            continue;
                        }
                    }

                    if (entity.getPersistentData().getBoolean("onlyLiving") && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                        return false;
                    }

                    if (entityiterator instanceof Player) {
                        Player _plr = (Player)entityiterator;
                        if (_plr.getAbilities().instabuild) {
                            return false;
                        }
                    }

                    if (new Object() {
                        public boolean checkGameMode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                            } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                            } else {
                                return false;
                            }
                        }
                    }.checkGameMode(entityiterator) || entityiterator.isInvulnerable()) {
                        return false;
                    }

                    if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entity.getFirstPassenger() == entityiterator || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entityiterator.getFirstPassenger() == entity) {
                        return false;
                    }

                    logic_attack = true;
                    player_target = entity_attacker_owner instanceof Player || entity_attacker_owner.getPersistentData().getBoolean("Player");
                    player_iterator = entity_iterator_owner instanceof Player || entity_iterator_owner.getPersistentData().getBoolean("Player");
                    if (player_target && player_iterator) {
                        if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                            logic_attack = false;
                        }
                    } else if (!entity_attacker_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !entity_attacker.getPersistentData().getBoolean("JujutsuSorcerer")) {
                        if (!entity_attacker_owner.getPersistentData().getBoolean("CursedSpirit") && !entity_attacker.getPersistentData().getBoolean("CursedSpirit")) {
                            if ((entity_attacker_owner.getPersistentData().getBoolean("CurseUser") || entity_attacker.getPersistentData().getBoolean("CurseUser")) && (entity_iterator_owner.getPersistentData().getBoolean("CurseUser") || entity_iterator.getPersistentData().getBoolean("CurseUser"))) {
                                logic_attack = false;
                            }
                        } else if (entity_iterator_owner.getPersistentData().getBoolean("CursedSpirit") || entity_iterator.getPersistentData().getBoolean("CursedSpirit")) {
                            logic_attack = false;
                        }
                    } else if (entity_iterator_owner.getPersistentData().getBoolean("JujutsuSorcerer") || entity_iterator.getPersistentData().getBoolean("JujutsuSorcerer")) {
                        logic_attack = false;
                    }

                    LivingEntity _livEnt;
                    LivingEntity _livEnt59;
                    LivingEntity _livEnt132;
                    label458: {
                        label570: {
                            if (entity_attacker_owner instanceof LivingEntity) {
                                _livEnt132 = (LivingEntity)entity_attacker_owner;
                                if (_livEnt132.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label570;
                                }
                            }

                            if (entity_attacker instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity_attacker;
                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label570;
                                }
                            }

                            if (entity_iterator_owner instanceof LivingEntity) {
                                LivingEntity _livEnt50 = (LivingEntity)entity_iterator_owner;
                                if (_livEnt50.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label570;
                                }
                            }

                            if (!(entity_iterator instanceof LivingEntity)) {
                                break label458;
                            }

                            _livEnt59 = (LivingEntity)entity_iterator;
                            if (!_livEnt59.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                break label458;
                            }
                        }

                        logic_attack = true;
                    }

                    if (logic_attack) {
                        label438: {
                            label572: {
                                if (entity_attacker_owner instanceof UraumeEntity) {
                                    if (entity_iterator_owner instanceof Player && (((JujutsucraftModVariables.PlayerVariables)entity_iterator_owner.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21.0 || ((JujutsucraftModVariables.PlayerVariables)entity_iterator_owner.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21.0) && entity_iterator_owner instanceof ServerPlayer) {
                                        ServerPlayer _plr54 = (ServerPlayer)entity_iterator_owner;
                                        if (_plr54.level() instanceof ServerLevel && _plr54.getAdvancements().getOrStartProgress(_plr54.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
                                            break label572;
                                        }
                                    }

                                    if (entity_iterator_owner instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity_iterator_owner;
                                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                            break label572;
                                        }
                                    }
                                }

                                if (!(entity_iterator_owner instanceof UraumeEntity)) {
                                    break label438;
                                }

                                if (entity_attacker_owner instanceof Player && (((JujutsucraftModVariables.PlayerVariables)entity_attacker_owner.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 21.0 || ((JujutsucraftModVariables.PlayerVariables)entity_attacker_owner.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21.0) && entity_attacker_owner instanceof ServerPlayer) {
                                    ServerPlayer _plr58 = (ServerPlayer)entity_attacker_owner;
                                    if (_plr58.level() instanceof ServerLevel && _plr58.getAdvancements().getOrStartProgress(_plr58.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
                                        break label572;
                                    }
                                }

                                if (!(entity_attacker_owner instanceof LivingEntity)) {
                                    break label438;
                                }

                                _livEnt59 = (LivingEntity)entity_attacker_owner;
                                if (!_livEnt59.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                    break label438;
                                }
                            }

                            logic_attack = false;
                        }

                        if ((entity_attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_1"))) || entity_attacker_owner instanceof Player && entity_attacker_owner.getPersistentData().getBoolean("CurseUser")) && (entity_iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_1"))) || entity_iterator_owner instanceof Player && entity_iterator_owner.getPersistentData().getBoolean("CurseUser")) || entity_attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_2"))) && entity_iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_2"))) || entity_attacker_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_3"))) && entity_iterator_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:group_3")))) {
                            if (!world.isClientSide() && world.getServer().getGameRules().getBoolean(JujutsucraftaddonModGameRules.ENABLE_SUKUNA_PVP)) {
                                logic_attack = true;
                            } else {
                                logic_attack = false;
                            }
                        }
                    }

                    LivingEntity var10000;
                    Mob _mobEnt;
                    if (!logic_attack) {
                        if (player_target) {
                            if (entity_iterator instanceof Mob) {
                                _mobEnt = (Mob)entity_iterator;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000 instanceof LivingEntity && entity_iterator.getPersistentData().getDouble("cnt_target") > 6.0) {
                                label577: {
                                    if (entity_iterator instanceof Mob) {
                                        _mobEnt = (Mob)entity_iterator;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (!(var10000 instanceof Player)) {
                                        if (entity_iterator instanceof Mob) {
                                            _mobEnt = (Mob)entity_iterator;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (!var10000.getPersistentData().getBoolean("Player")) {
                                            break label577;
                                        }
                                    }

                                    logic_attack = true;
                                }
                            }
                        }

                        if (player_iterator) {
                            if (entity_attacker instanceof Mob) {
                                _mobEnt = (Mob)entity_attacker;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000 instanceof LivingEntity && entity_attacker.getPersistentData().getDouble("cnt_target") > 6.0) {
                                label592: {
                                    if (entity_attacker instanceof Mob) {
                                        _mobEnt = (Mob)entity_attacker;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (!(var10000 instanceof Player)) {
                                        if (entity_attacker instanceof Mob) {
                                            _mobEnt = (Mob)entity_attacker;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (!var10000.getPersistentData().getBoolean("Player")) {
                                            break label592;
                                        }
                                    }

                                    logic_attack = true;
                                }
                            }
                        }
                    }

                    if (entity instanceof CrowEntity && entityiterator instanceof CrowEntity) {
                        logic_attack = false;
                    }

                    if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                        if (entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged") || entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                            logic_attack = false;
                        }

                        if (entity.getPersistentData().getBoolean("betrayal") && entity.getPersistentData().getDouble("NameRanged_ranged") != entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                            return true;
                        }
                    }

                    if (entity.getPersistentData().getDouble("NameRanged") != 0.0 && (entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged") || entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged"))) {
                        logic_attack = false;
                    }

                    if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                        if (entityiterator instanceof Mob) {
                            _mobEnt = (Mob)entityiterator;
                            var10000 = _mobEnt.getTarget();
                        } else {
                            var10000 = null;
                        }

                        if (var10000 instanceof LivingEntity && entityiterator.getPersistentData().getDouble("cnt_target") > 6.0) {
                            double var33 = entity.getPersistentData().getDouble("friend_num");
                            LivingEntity var10001;
                            if (entityiterator instanceof Mob) {
                                _mobEnt = (Mob)entityiterator;
                                var10001 = _mobEnt.getTarget();
                            } else {
                                var10001 = null;
                            }

                            if (var33 == var10001.getPersistentData().getDouble("friend_num")) {
                                logic_attack = true;
                            }
                        }
                    }

                    if (entity instanceof Mob) {
                        _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                    } else {
                        var10000 = null;
                    }

                    label617: {
                        if (var10000 != entityiterator || !(entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                            if (entityiterator instanceof Mob) {
                                _mobEnt = (Mob)entityiterator;
                                var10000 = _mobEnt.getTarget();
                            } else {
                                var10000 = null;
                            }

                            if (var10000 != entity || !(entityiterator.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                if (entity_attacker_owner instanceof Mob) {
                                    _mobEnt = (Mob)entity_attacker_owner;
                                    var10000 = _mobEnt.getTarget();
                                } else {
                                    var10000 = null;
                                }

                                if (var10000 != entityiterator || !(entity_attacker_owner.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                    if (entity_iterator_owner instanceof Mob) {
                                        _mobEnt = (Mob) entity_iterator_owner;
                                        var10000 = _mobEnt.getTarget();
                                    } else {
                                        var10000 = null;
                                    }

                                    if (var10000 != entity || !(entity_iterator_owner.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                        if (entity_attacker_owner instanceof Mob) {
                                            _mobEnt = (Mob) entity_attacker_owner;
                                            var10000 = _mobEnt.getTarget();
                                        } else {
                                            var10000 = null;
                                        }

                                        if (var10000 != entity_iterator_owner || !(entity_attacker_owner.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                            if (entity_iterator_owner instanceof Mob) {
                                                _mobEnt = (Mob) entity_iterator_owner;
                                                var10000 = _mobEnt.getTarget();
                                            } else {
                                                var10000 = null;
                                            }

                                            if (var10000 != entity_attacker_owner || !(entity_iterator_owner.getPersistentData().getDouble("cnt_target") > 6.0)) {
                                                break label617;
                                            }
                                        }

                                        logic_attack = true;
                                        break label617;
                                    }
                                }

                                logic_attack = true;
                                break label617;
                            }
                        }

                        logic_attack = true;
                    }

                    if (entity_attacker_owner == entity_iterator_owner) {
                        logic_attack = false;
                    }

                    if (entity_attacker.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity_attacker.getPersistentData().getBoolean("Ambush") || entity_iterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && !entity_iterator.getPersistentData().getBoolean("Ambush")) {
                        logic_attack = true;
                    }

                    if (entity.getPersistentData().getDouble("friend_num") != 0.0 && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                        logic_attack = false;
                    }

                    if (entityiterator instanceof LivingEntity) {
                        _livEnt132 = (LivingEntity)entityiterator;
                        if (_livEnt132.hasEffect((MobEffect)JujutsucraftModMobEffects.PRAYER_SONG.get())) {
                            int var34;
                            label290: {
                                if (entityiterator instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                                        var34 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                        break label290;
                                    }
                                }

                                var34 = 0;
                            }

                            if (var34 > 0 && (!(entity.getPersistentData().getDouble("skill") >= 305.0) || !(entity.getPersistentData().getDouble("skill") <= 310.0)) && entity.getPersistentData().getDouble("skill") != 205.0 && entity.getPersistentData().getDouble("skill") != 705.0) {
                                logic_attack = false;
                            }
                        }
                    }

                    if (entity.getPersistentData().getBoolean("DomainAttack")) {
                        logic_attack = LogicAttackDomainProcedure.execute(entity, entityiterator);
                    }

                    if (entity.getPersistentData().getDouble("target_type") != 0.0) {
                        velocity = Math.sqrt(Math.pow(entityiterator.getDeltaMovement().x(), 2.0) + Math.pow(entityiterator.getDeltaMovement().y(), 2.0) + Math.pow(entityiterator.getDeltaMovement().z(), 2.0));
                        if (entity.getPersistentData().getDouble("target_type") == 1.0) {
                            logic_attack = velocity > 1.0;
                        } else if (entity.getPersistentData().getDouble("target_type") == 2.0 && velocity < 0.1 && !entityiterator.isSprinting()) {
                            logic_attack = false;
                        }
                    }
                    break;
                }
            }

            return logic_attack;
        } else {
            return false;
        }
    }
}