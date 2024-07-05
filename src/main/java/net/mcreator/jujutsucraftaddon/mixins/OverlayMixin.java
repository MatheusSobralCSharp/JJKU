package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.ItadoriYujiEntity;
import net.mcreator.jujutsucraft.entity.ItadoriYujiShibuyaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.BlackFlashedProcedure;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = RangeAttackProcedure.class, remap = false)
public abstract class OverlayMixin {
    public OverlayMixin(){

    }
    /**
     * @author Satushi
     * @reason Changes
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            Entity entity_a = null;
            double old_health = 0.0;
            double knockback = 0.0;
            double dis = 0.0;
            double x_knockback = 0.0;
            double num1 = 0.0;
            double z_knockback = 0.0;
            double damage_sorce = 0.0;
            double damage_source_player = 0.0;
            double num2 = 0.0;
            double y_knockback = 0.0;
            double attack_type = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double range = 0.0;
            boolean SwordGuard = false;
            boolean guard = false;
            boolean SwordAttack = false;
            boolean betrayal = false;
            boolean blackflashable = false;
            boolean logic_swing = false;
            boolean BlackFlash = false;
            boolean useCurse = false;
            boolean highPower = false;
            boolean logic_knockback = false;
            boolean critical_nanami = false;
            boolean critical_ice = false;
            blackflashable = entity.getPersistentData().getDouble("Damage") >= 9.0;
            highPower = entity.getPersistentData().getDouble("Damage") >= 24.0;
            CursedToolsAbility2Procedure.execute(entity);
            DamageFixProcedure.execute(entity);
            damage_source_player = entity.getPersistentData().getDouble("Damage");
            if (entity.getPersistentData().getDouble("KnockbackFix") != 0.0 && entity.getPersistentData().getBoolean("attack") && entity.getPersistentData().getDouble("knockback") >= 1.0) {
                entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("knockback") * (1.0 + Math.min(Math.max(entity.getPersistentData().getDouble("cnt6") * 0.2, entity.getPersistentData().getDouble("cnt5") * 0.005), 1.0) * entity.getPersistentData().getDouble("KnockbackFix")));
            }

            BlackFlash = false;
            double var10000;
            int var10001;
            float var10002;
            float var10003;
            LivingEntity _livEnt;
            int index0;
            int var89;
            if (blackflashable && entity.getPersistentData().getBoolean("attack")) {
                label1077: {
                    if (entity instanceof Player) {
                        if (!(entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerFormer > 150.0)) {
                            break label1077;
                        }
                    } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                        break label1077;
                    }

                    num1 = 1.0;
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                            label1006: {
                                var10000 = num1 + 2.0;
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                                        var10001 = _livEnt.getEffect(JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                        break label1006;
                                    }
                                }

                                var10001 = 0;
                            }

                            num1 = var10000 + (double)var10001;
                        }
                    }

                    label997: {
                        if (entity instanceof Player) {
                            if (!(entity instanceof ServerPlayer _plr17)) {
                                break label997;
                            }

                            if (!(_plr17.level() instanceof ServerLevel) || !_plr17.getAdvancements().getOrStartProgress(_plr17.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:black_flash"))).isDone()) {
                                break label997;
                            }
                        } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:black_flash_able")))) {
                            break label997;
                        }

                        ++num1;
                    }

                    label987: {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.SPECIAL.get())) {
                                var89 = _livEnt.getEffect(JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                break label987;
                            }
                        }

                        var89 = 0;
                    }

                    if (var89 > 0) {
                        num1 += 5.0;
                    }

                    label981: {
                        if (entity instanceof Player) {
                            if (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique != 21.0 && entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCurseTechnique2 != 21.0) {
                                break label981;
                            }
                        } else if (!(entity instanceof ItadoriYujiEntity) && !(entity instanceof ItadoriYujiShibuyaEntity)) {
                            break label981;
                        }

                        num1 += 3.0;
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getHealth();
                    } else {
                        var10002 = -1.0F;
                    }

                    var10002 = Math.max(var10002, 1.0F);
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                    } else {
                        var10003 = -1.0F;
                    }

                    num1 += (1.0F - var10002 / Math.max(var10003, 1.0F)) * 2.0F;
                    num1 += entity.getPersistentData().getDouble("cnt6") * 2.0;

                    for(index0 = 0; index0 < (int)Math.round(num1); ++index0) {
                        if (Math.random() > 0.998) {
                                BlackFlash = true;
                                break;
                        } else if (Math.random() <= 0.001 * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BFChance) {
                                BlackFlash = true;
                                break;
                        }
                    }
                }
            }

            useCurse = true;
            ItemStack var90;
            if (entity.getPersistentData().getBoolean("attack")) {
                label964: {
                    if (entity instanceof Player) {
                        if (!(entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerCursePowerFormer < 100.0)) {
                            break label964;
                        }
                    } else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                        break label964;
                    }

                    useCurse = false;
                }

                if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    var90 = _livEnt.getMainHandItem();
                } else {
                    var90 = ItemStack.EMPTY;
                }

                if (var90.getItem() != ItemStack.EMPTY.getItem()) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var90 = _livEnt.getMainHandItem();
                    } else {
                        var90 = ItemStack.EMPTY;
                    }

                    if (var90.getOrCreateTag().getDouble("CursePower") != 0.0) {
                        useCurse = true;
                    }
                }
            }

            if (entity instanceof LivingEntity) {
                _livEnt = (LivingEntity) entity;
                var90 = _livEnt.getMainHandItem();
            } else {
                var90 = ItemStack.EMPTY;
            }

            boolean var95;
            label957: {
                if (!(var90.getItem() instanceof SwordItem)) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var90 = _livEnt.getMainHandItem();
                    } else {
                        var90 = ItemStack.EMPTY;
                    }

                    if (!(var90.getItem() instanceof AxeItem)) {
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entity;
                            var90 = _livEnt.getMainHandItem();
                        } else {
                            var90 = ItemStack.EMPTY;
                        }

                        if (!var90.is(ItemTags.create(new ResourceLocation("forge:sword_type")))) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var90 = _livEnt.getMainHandItem();
                            } else {
                                var90 = ItemStack.EMPTY;
                            }

                            if (!var90.is(ItemTags.create(new ResourceLocation("forge:sword")))) {
                                var95 = false;
                                break label957;
                            }
                        }
                    }
                }

                var95 = true;
            }

            SwordAttack = var95;
            if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
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
                }).apply(world, entity.getPersistentData().getString("OWNER_UUID"));
            }

            if (!(entity_a instanceof LivingEntity)) {
                entity_a = entity;
            }

            x_pos = x;
            y_pos = y;
            z_pos = z;
            range = entity.getPersistentData().getDouble("Range");
            index0 = 0;

            label946:
            while(index0 < 2) {
                Vec3 _center = new Vec3(x_pos, y_pos, z_pos);
                List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> {
                    return true;
                }).stream().sorted(Comparator.comparingDouble((_entcnd) -> {
                    return _entcnd.distanceToSqr(_center);
                })).toList();
                Iterator var68 = _entfound.iterator();

                while(true) {
                    Entity entityiterator;
                    LivingEntity _entity;
                    ServerLevel _level = null;
                    do {
                        do {
                            do {
                                do {
                                    do {
                                        if (!var68.hasNext()) {
                                            if (!(entity instanceof LivingEntity)) {
                                                break label946;
                                            }

                                            _livEnt = (LivingEntity)entity;
                                            if (!_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) || entity.getPersistentData().getBoolean("Failed") || entity.getPersistentData().getBoolean("attack") || entity.getPersistentData().getBoolean("DomainAttack")) {
                                                break label946;
                                            }

                                            label716: {
                                                x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                                                y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                                                z_pos = entity.getPersistentData().getDouble("z_pos_doma");
                                                var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity)entity;
                                                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        var10001 = _livEnt.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                                        break label716;
                                                    }
                                                }

                                                var10001 = 0;
                                            }

                                            range = var10000 * (double)(var10001 > 0 ? 6 : 2);
                                            entity.getPersistentData().putBoolean("DomainAttack", true);
                                            ++index0;
                                            continue label946;
                                        }

                                        entityiterator = (Entity)var68.next();
                                        guard = false;
                                        logic_knockback = false;
                                        betrayal = LogicBetrayalProcedure.execute(entity, entityiterator);
                                    } while(entity == entityiterator && !betrayal);

                                    if (LogicAttackProcedure.execute(world, entity, entityiterator) || betrayal) {
                                        EffectConfirmProcedure.execute(world, x, y, z, entity, entityiterator);
                                        damage_sorce = damage_source_player;
                                        knockback = entity.getPersistentData().getDouble("knockback") / Math.max(((LivingEntity)entityiterator).getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue(), 1.0);
                                        float var96;
                                        if (BlackFlash) {
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entityiterator;
                                                var10000 = _livEnt.getHealth();
                                            } else {
                                                var10000 = -1.0;
                                            }

                                            old_health = var10000;
                                            entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))), 0.1F);
                                            if (entityiterator instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entityiterator;
                                                var96 = _livEnt.getHealth();
                                            } else {
                                                var96 = -1.0F;
                                            }

                                            if ((double)var96 < old_health) {
                                                damage_sorce *= 4.0;
                                                highPower = true;
                                            } else {
                                                BlackFlash = false;
                                            }
                                        }

                                        CursedToolsAbilityProcedure.execute(entity, entityiterator);
                                        LivingEntity _entGetArmor;
                                        if (entity.getPersistentData().getBoolean("attack")) {
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                var90 = _livEnt.getMainHandItem();
                                            } else {
                                                var90 = ItemStack.EMPTY;
                                            }

                                            if (var90.getItem() != ItemStack.EMPTY.getItem()) {
                                                if (entity instanceof LivingEntity) {
                                                    _entity = (LivingEntity)entity;
                                                    var90 = _entity.getMainHandItem();
                                                } else {
                                                    var90 = ItemStack.EMPTY;
                                                }

                                                ItemStack var93;
                                                if (var90.getOrCreateTag().getDouble("CursePower") > 0.0) {
                                                    if (entity instanceof LivingEntity) {
                                                        _entity = (LivingEntity)entity;
                                                        var93 = _entity.getMainHandItem();
                                                    } else {
                                                        var93 = ItemStack.EMPTY;
                                                    }

                                                    damage_sorce *= 1.0 + var93.getOrCreateTag().getDouble("CursePower") * 0.02;
                                                } else {
                                                    if (entity instanceof LivingEntity) {
                                                        _entGetArmor = (LivingEntity)entity;
                                                        var90 = _entGetArmor.getMainHandItem();
                                                    } else {
                                                        var90 = ItemStack.EMPTY;
                                                    }

                                                    if (var90.getOrCreateTag().getDouble("CursePower") < 0.0 && entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                                                        if (entity instanceof LivingEntity) {
                                                            _entity = (LivingEntity)entity;
                                                            var93 = _entity.getMainHandItem();
                                                        } else {
                                                            var93 = ItemStack.EMPTY;
                                                        }

                                                        damage_sorce *= 1.0 + Math.abs(var93.getOrCreateTag().getDouble("CursePower")) * 0.2;
                                                    }
                                                }
                                            }

                                            label906: {
                                                if (entity instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity)entity;
                                                    if (_livEnt.hasEffect(JujutsucraftModMobEffects.SPECIAL.get())) {
                                                        var89 = _livEnt.getEffect(JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                                        break label906;
                                                    }
                                                }

                                                var89 = 0;
                                            }

                                            if (var89 >= 1 && entityiterator instanceof LivingEntity) {
                                                _entity = (LivingEntity)entityiterator;
                                                if (_entity.hasEffect(JujutsucraftModMobEffects.SPECIAL.get())) {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entGetArmor = (LivingEntity)entityiterator;
                                                        _entGetArmor.removeEffect(JujutsucraftModMobEffects.SPECIAL.get());
                                                    }

                                                    damage_sorce *= 2.0;
                                                    knockback *= 1.0;
                                                    critical_nanami = true;
                                                }
                                            }

                                            if (entityiterator.getPercentFrozen() * 100.0F >= 5.0F) {
                                                entityiterator.setTicksFrozen(0);
                                                damage_sorce *= 1.5;
                                                knockback *= 1.0;
                                                critical_ice = true;
                                            }
                                        }

                                        label901: {
                                            if (entityiterator.getPersistentData().getDouble("skill") == 0.0) {
                                                label899: {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity)entityiterator;
                                                        if (_livEnt.hasEffect(JujutsucraftModMobEffects.GUARD.get())) {
                                                            break label899;
                                                        }
                                                    }

                                                    if (!entityiterator.getPersistentData().getBoolean("guard")) {
                                                        break label901;
                                                    }
                                                }
                                            }

                                            if (entityiterator.getPersistentData().getDouble("Damage") > 0.0) {
                                                if (!critical_ice && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity != entityiterator) {
                                                    guard = true;
                                                    damage_sorce = Math.max(damage_sorce - entityiterator.getPersistentData().getDouble("Damage"), entity.getPersistentData().getBoolean("attack") ? 0.0 : 0.1);
                                                    knockback *= Math.min(Math.max(Math.min(damage_sorce, damage_source_player) * 2.0 / Math.max(damage_source_player, 0.1), 0.5), 1.0);
                                                }

                                                if (entity == entityiterator) {
                                                    entity.getPersistentData().putDouble("skill", 0.0);
                                                }
                                            }
                                        }

                                        if (entityiterator instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entityiterator;
                                            if (_livEnt.hasEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                                                label889: {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity)entityiterator;
                                                        if (_entity.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var89 = _entity.getEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                            break label889;
                                                        }
                                                    }

                                                    var89 = 0;
                                                }

                                                if (var89 > 0 && entity_a instanceof LivingEntity) {
                                                    _entGetArmor = (LivingEntity)entity_a;
                                                    if (_entGetArmor.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                        int var94;
                                                        label881: {
                                                            if (entityiterator instanceof LivingEntity) {
                                                                _entity = (LivingEntity)entityiterator;
                                                                if (_entity.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                                    var94 = _entity.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                                    break label881;
                                                                }
                                                            }

                                                            var94 = 0;
                                                        }

                                                        num1 = 15.0 * (1.0 + (double)var94 * 0.33);
                                                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entity.getPersistentData().getBoolean("DomainAttack")) {
                                                            damage_sorce = Math.max(damage_sorce - num1, 0.0);
                                                        }

                                                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                                            entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse"))), entityiterator), (float)num1);
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        if (entity.getPersistentData().getBoolean("attack") && entityiterator.getPersistentData().getBoolean("CursedSpirit") && !useCurse) {
                                            damage_sorce = Math.min(damage_sorce, 0.01);
                                        }

                                        if (damage_sorce > 0.0 || guard) {
                                            damage_sorce *= ChangeDamage1Procedure.execute(world, entity, entityiterator);
                                            damage_sorce *= ChangeDamage2Procedure.execute(world, entity, entityiterator);
                                            if (damage_sorce > 0.0 || guard) {
                                                for(int index2 = 0; index2 < 20; ++index2) {
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity)entityiterator;
                                                        var10000 = _entity.getHealth();
                                                    } else {
                                                        var10000 = -1.0;
                                                    }

                                                    old_health = var10000;
                                                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse"))), entity_a), (float)damage_sorce);
                                                    if (!entity.getPersistentData().getBoolean("DomainAttack")) {
                                                        break;
                                                    }

                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity)entityiterator;
                                                        var96 = _entity.getHealth();
                                                    } else {
                                                        var96 = -1.0F;
                                                    }

                                                    if ((double)var96 != old_health) {
                                                        break;
                                                    }

                                                    damage_sorce += 0.05;
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity)entityiterator;
                                                    var96 = _livEnt.getHealth();
                                                } else {
                                                    var96 = -1.0F;
                                                }

                                                if ((double)var96 == old_health && guard) {
                                                    entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))), 0.1F);
                                                }

                                                if (entityiterator instanceof LivingEntity) {
                                                    _livEnt = (LivingEntity)entityiterator;
                                                    var96 = _livEnt.getHealth();
                                                } else {
                                                    var96 = -1.0F;
                                                }

                                                if ((double)var96 != old_health) {
                                                    old_cooldown = entityiterator.getPersistentData().getDouble("COOLDOWN_TICKS");
                                                    float var91;
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entGetArmor = (LivingEntity)entityiterator;
                                                        var91 = _entGetArmor.getHealth();
                                                    } else {
                                                        var91 = -1.0F;
                                                    }

                                                    var10000 = old_health - (double)var91;
                                                    double var92;
                                                    if (entityiterator instanceof LivingEntity) {
                                                        _entity = (LivingEntity)entityiterator;
                                                        var92 = _entity.getMaxHealth();
                                                    } else {
                                                        var92 = -1.0;
                                                    }

                                                    num1 = var10000 / Math.max(var92, 0.1);
                                                    if (!(entityiterator instanceof Player)) {
                                                        num1 *= 2.0;
                                                    }

                                                    if (highPower) {
                                                        num1 += 0.2;
                                                    }

                                                    label1040: {
                                                        if (entityiterator instanceof LivingEntity) {
                                                            _entity = (LivingEntity)entityiterator;
                                                            if (_entity.hasEffect(JujutsucraftModMobEffects.COMEDIAN.get())) {
                                                                break label1040;
                                                            }
                                                        }

                                                        if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
                                                            if (entity.getPersistentData().getBoolean("attack") && entityiterator instanceof LivingEntity) {
                                                                _entGetArmor = (LivingEntity)entityiterator;
                                                                if (!_entGetArmor.level().isClientSide()) {
                                                                    _entGetArmor.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 4, 0, false, false));
                                                                }
                                                            }

                                                            if (num1 >= 0.08) {
                                                                num2 = 0.0;

                                                                for(int index3 = 0; index3 < (int)Math.max(Math.round(num1 * 8.0), 1L); ++index3) {
                                                                    if (entityiterator instanceof LivingEntity) {
                                                                        _entity = (LivingEntity)entityiterator;
                                                                        if (!_entity.level().isClientSide()) {
                                                                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)Math.round(Math.max((num1 - num2 * 0.5) * 320.0, 1.0)), (int)num2, false, false));
                                                                        }
                                                                    }

                                                                    ++num2;
                                                                }

                                                                if (entityiterator instanceof LivingEntity) {
                                                                    _entGetArmor = (LivingEntity)entityiterator;
                                                                    if (!_entGetArmor.level().isClientSide()) {
                                                                        _entGetArmor.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)Math.round(Math.max(num1 * 160.0, 1.0)), 0, false, false));
                                                                    }
                                                                }

                                                                if (num1 >= 0.2) {
                                                                    label832: {
                                                                        if (entityiterator instanceof LivingEntity) {
                                                                            _entGetArmor = (LivingEntity)entityiterator;
                                                                            if (_entGetArmor.hasEffect(JujutsucraftModMobEffects.JACKPOT.get())) {
                                                                                break label832;
                                                                            }
                                                                        }

                                                                        if (entityiterator instanceof LivingEntity) {
                                                                            _entity = (LivingEntity)entityiterator;
                                                                            if (!_entity.level().isClientSide()) {
                                                                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(Math.max(num1 * 160.0, 1.0)), 0, false, false));
                                                                            }
                                                                        }
                                                                    }

                                                                    if (entityiterator.getPersistentData().getBoolean("attack") || entityiterator.getPersistentData().getDouble("skill") == 0.0) {
                                                                        entityiterator.getPersistentData().putDouble("skill", 0.0);
                                                                        if (entityiterator instanceof LivingEntity) {
                                                                            _entGetArmor = (LivingEntity)entityiterator;
                                                                            _entGetArmor.removeEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                                                                        }

                                                                        if (entityiterator instanceof Player) {
                                                                            if (entityiterator instanceof LivingEntity) {
                                                                                _entGetArmor = (LivingEntity)entityiterator;
                                                                                var90 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                                                            } else {
                                                                                var90 = ItemStack.EMPTY;
                                                                            }

                                                                            if (var90.getItem() == ItemStack.EMPTY.getItem()) {
                                                                                if (entityiterator instanceof Player _player) {
                                                                                    _player.getInventory().armor.set(3, new ItemStack(JujutsucraftModBlocks.IN_BARRIER.get()));
                                                                                    _player.getInventory().setChanged();
                                                                                } else if (entityiterator instanceof LivingEntity _living) {
                                                                                    _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(JujutsucraftModBlocks.IN_BARRIER.get()));
                                                                                }
                                                                            }

                                                                            if (entityiterator instanceof LivingEntity) {
                                                                                _entGetArmor = (LivingEntity)entityiterator;
                                                                                var90 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                                                            } else {
                                                                                var90 = ItemStack.EMPTY;
                                                                            }

                                                                            var90.getOrCreateTag().putDouble("P_ANIME1", -2.0);
                                                                            if (entityiterator instanceof LivingEntity) {
                                                                                _entGetArmor = (LivingEntity)entityiterator;
                                                                                var90 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                                                                            } else {
                                                                                var90 = ItemStack.EMPTY;
                                                                            }

                                                                            var90.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                                                                        }
                                                                    }

                                                                    label822: {
                                                                        if (entityiterator instanceof LivingEntity) {
                                                                            _entGetArmor = (LivingEntity)entityiterator;
                                                                            if (_entGetArmor.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                                                var10000 = _entGetArmor.getEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                                                                break label822;
                                                                            }
                                                                        }

                                                                        var10000 = 0.0;
                                                                    }

                                                                    num1 = var10000;
                                                                    if (num1 > 0.0 && num1 <= 600.0 && entityiterator instanceof LivingEntity) {
                                                                        _entGetArmor = (LivingEntity)entityiterator;
                                                                        _entGetArmor.removeEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    if (entityiterator instanceof LivingEntity) {
                                                        _livEnt = (LivingEntity) entityiterator;
                                                        var90 = _livEnt.getMainHandItem();
                                                    } else {
                                                        var90 = ItemStack.EMPTY;
                                                    }

                                                    label805: {
                                                        if (!(var90.getItem() instanceof SwordItem)) {
                                                            if (entityiterator instanceof LivingEntity) {
                                                                _entity = (LivingEntity)entityiterator;
                                                                var90 = _entity.getMainHandItem();
                                                            } else {
                                                                var90 = ItemStack.EMPTY;
                                                            }

                                                            if (!(var90.getItem() instanceof AxeItem)) {
                                                                if (entityiterator instanceof LivingEntity) {
                                                                    _entGetArmor = (LivingEntity)entityiterator;
                                                                    var90 = _entGetArmor.getMainHandItem();
                                                                } else {
                                                                    var90 = ItemStack.EMPTY;
                                                                }

                                                                if (!var90.is(ItemTags.create(new ResourceLocation("forge:sword_type")))) {
                                                                    if (entityiterator instanceof LivingEntity) {
                                                                        _entity = (LivingEntity)entityiterator;
                                                                        var90 = _entity.getMainHandItem();
                                                                    } else {
                                                                        var90 = ItemStack.EMPTY;
                                                                    }

                                                                    if (!var90.is(ItemTags.create(new ResourceLocation("forge:sword")))) {
                                                                        var95 = false;
                                                                        break label805;
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        var95 = true;
                                                    }

                                                    SwordGuard = var95;
                                                    if (guard) {
                                                        label1097: {
                                                            if (!entityiterator.getPersistentData().getBoolean("attack")) {
                                                                label792: {
                                                                    if (entityiterator instanceof LivingEntity) {
                                                                        _entity = (LivingEntity)entityiterator;
                                                                        if (_entity.hasEffect(JujutsucraftModMobEffects.GUARD.get())) {
                                                                            break label792;
                                                                        }
                                                                    }

                                                                    if (!entityiterator.getPersistentData().getBoolean("guard")) {
                                                                        guard = false;
                                                                        break label1097;
                                                                    }
                                                                }
                                                            }

                                                            PlayAnimationEntityGuardProcedure.execute(entityiterator);
                                                            if (SwordAttack && SwordGuard) {
                                                                if (world instanceof ServerLevel) {
                                                                    _level = (ServerLevel)world;
                                                                    _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), x, y, z, 1, 0.5, 0.5, 0.5, 0.25);
                                                                }

                                                                if (world instanceof ServerLevel) {
                                                                    if (!_level.isClientSide()) {
                                                                        _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                                                                    } else {
                                                                        _level.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:guard_sword")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                                                                    }
                                                                }

                                                                if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound entity.player.attack.strong master @a ~ ~ ~ 0.5 1 0");
                                                                }
                                                            } else {
                                                                if (world instanceof ServerLevel) {
                                                                    _level = (ServerLevel)world;
                                                                    _level.sendParticles(ParticleTypes.CRIT, x, y, z, 5, 0.1, 0.1, 0.1, 0.1);
                                                                }

                                                                if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound entity.player.attack.strong master @a ~ ~ ~ 1 1 0");
                                                                }
                                                            }

                                                            label782: {
                                                                if (entityiterator instanceof LivingEntity) {
                                                                    _entGetArmor = (LivingEntity)entityiterator;
                                                                    if (_entGetArmor.hasEffect(JujutsucraftModMobEffects.GUARD.get())) {
                                                                        var89 = _entGetArmor.getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                                                        break label782;
                                                                    }
                                                                }

                                                                var89 = 0;
                                                            }

                                                            if (var89 > 0) {
                                                                if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound jujutsucraft:guard_just master @s");
                                                                }

                                                                if (entityiterator instanceof Player _player) {
                                                                    if (!_player.level().isClientSide()) {
                                                                        _player.displayClientMessage(Component.literal("§6§lJUST GUARD"), true);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                    if (entity.getPersistentData().getBoolean("attack")) {
                                                        int index5;
                                                        if (!guard) {
                                                            num1 = 0.0;
                                                            num2 = 0.0;

                                                            for(index5 = 0; index5 < 4; ++index5) {
                                                                if (entityiterator instanceof LivingEntity) {
                                                                    _entGetArmor = (LivingEntity)entityiterator;
                                                                    var90 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int)Math.round(num1)));
                                                                } else {
                                                                    var90 = ItemStack.EMPTY;
                                                                }

                                                                if (var90.is(ItemTags.create(new ResourceLocation("forge:metallic_armor")))) {
                                                                    if (Math.round(num1) != 0L && Math.round(num1) != 3L) {
                                                                        if (Math.round(num1) == 2L) {
                                                                            num2 += 0.5;
                                                                        } else if (Math.round(num1) == 1L) {
                                                                            num2 += 0.3;
                                                                        }
                                                                    } else {
                                                                        num2 += 0.15;
                                                                    }
                                                                }

                                                                ++num1;
                                                            }

                                                            if (Math.random() < num2) {
                                                                if (SwordAttack) {
                                                                    if (world instanceof Level ServerLevel) {
                                                                        if (!ServerLevel.isClientSide()) {
                                                                            ServerLevel.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                                                        } else {
                                                                            ServerLevel.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                                                        }
                                                                    }
                                                                } else if (world instanceof Level ServerLevel) {
                                                                    if (!ServerLevel.isClientSide()) {
                                                                        ServerLevel.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 0.8F);
                                                                    } else {
                                                                        ServerLevel.playLocalSound(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 0.8F, false);
                                                                    }
                                                                }
                                                            }
                                                        }

                                                        if (entity.getPersistentData().getDouble("Damage") >= 40.0) {
                                                            num1 = 0.5 + Math.random() * 0.5;

                                                            for(index5 = 0; index5 < (int)Math.round(Math.min(1.0 + (entity.getPersistentData().getDouble("Damage") - 40.0) / 30.0, 6.0)); ++index5) {
                                                                if (!SwordAttack) {
                                                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                                        entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound jujutsucraft:strong_hit master @a ~ ~ ~ 0.75 " + num1 + " 0");
                                                                    }
                                                                } else if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                                                    entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound jujutsucraft:crush master @a ~ ~ ~ 0.25 " + num1 + " 0");
                                                                }

                                                                num1 = !entityiterator.getPersistentData().getBoolean("attack") && !guard ? Math.max(num1 - 0.1, 0.5) : Math.min(num1 + 0.25, 1.5);
                                                            }
                                                        }
                                                    }

                                                    if (damage_sorce > 0.0) {
                                                        logic_knockback = true;
                                                        EffectProcedure.execute(world, x, y, z, entity, entityiterator);
                                                    }

                                                    if (BlackFlash) {
                                                        BlackFlash = false;
                                                        BlackFlashedProcedure.execute(world, x, y, z, entity);
                                                        double _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerFame + 200.0;
                                                        double final_setval = _setval;
                                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                                            capability.PlayerFame = final_setval;
                                                            capability.syncPlayerVariables(entity);
                                                        });
                                                        _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerExperience + 200.0;
                                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                                            capability.PlayerExperience = final_setval;
                                                            capability.syncPlayerVariables(entity);
                                                        });
                                                        _setval = entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables()).PlayerTechniqueUsedNumber + 2500.0;
                                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                                                            capability.PlayerTechniqueUsedNumber = final_setval;
                                                            capability.syncPlayerVariables(entity);
                                                        });
                                                        if (world instanceof ServerLevel) {
                                                            _level = (ServerLevel)world;
                                                            Entity entityToSpawn = ((EntityType) JujutsucraftModEntities.ENTITY_BLACK_FLASH.get()).spawn(_level, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), MobSpawnType.MOB_SUMMONED);
                                                            if (entityToSpawn != null) {
                                                                entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                            }
                                                        }

                                                        if (entity instanceof LivingEntity) {
                                                            _entity = (LivingEntity)entity;
                                                            if (!_entity.level().isClientSide()) {
                                                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.ZONE.get(), 6000, 0, true, true));
                                                            }
                                                        }

                                                        if (entity instanceof ServerPlayer _player) {
                                                            Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:black_flash"));
                                                            AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                                            if (!_ap.isDone()) {
                                                                Iterator var75 = _ap.getRemainingCriteria().iterator();

                                                                while(var75.hasNext()) {
                                                                    String criteria = (String)var75.next();
                                                                    _player.getAdvancements().award(_adv, criteria);
                                                                }
                                                            }
                                                        }
                                                    }

                                                    if (critical_nanami) {
                                                        critical_nanami = false;
                                                        if (world instanceof Level) {
                                                            if (!_level.isClientSide()) {
                                                                _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                                                            } else {
                                                                _level.playLocalSound(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                                                            }
                                                        }

                                                        if (world instanceof ServerLevel) {
                                                            _level = (ServerLevel)world;
                                                            _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 1, 0.5, 0.5, 0.5, 0.25);
                                                        }

                                                        if (world instanceof ServerLevel) {
                                                            _level = (ServerLevel)world;
                                                            _level.sendParticles(ParticleTypes.CRIT, entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 25, 0.25, 0.25, 0.25, 0.5);
                                                        }
                                                    }

                                                    if (critical_ice) {
                                                        critical_ice = false;
                                                        if (world instanceof Level) {
                                                            if (!_level.isClientSide()) {
                                                                _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                                                            } else {
                                                                _level.playLocalSound(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:glass_crash")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                                                            }
                                                        }

                                                        world.levelEvent(2001, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()), Block.getId(Blocks.ICE.defaultBlockState()));
                                                    }

                                                    logic_swing = true;
                                                    entityiterator.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
                                                }
                                            }
                                        }

                                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.isAlive()) {
                                            entity.getPersistentData().putBoolean("Stop", true);
                                        }
                                    }

                                    if (entityiterator instanceof Projectile _projEnt) {
                                        var10000 = _projEnt.getDeltaMovement().length();
                                    } else {
                                        var10000 = 0.0;
                                    }

                                    if (var10000 > 0.0 && entity.getPersistentData().getDouble("projectile_type") != 0.0 && entityiterator.getPersistentData().getDouble("Damage") < entity.getPersistentData().getDouble("Damage")) {
                                        logic_swing = true;
                                        logic_knockback = true;
                                    }
                                } while(entity == entityiterator);
                            } while(knockback == 0.0);
                        } while(!logic_knockback);

                        x_knockback = entityiterator.getX() - entity.getX();
                        y_knockback = entityiterator.getY() - entity.getY();
                        z_knockback = entityiterator.getZ() - entity.getZ();
                        dis = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                    } while(dis == 0.0);

                    x_knockback = x_knockback / dis * 3.0 * knockback + entity.getPersistentData().getDouble("x_knockback");
                    y_knockback = Math.min(y_knockback / dis * 3.0 * knockback, 1.5) + entity.getPersistentData().getDouble("y_knockback");
                    z_knockback = z_knockback / dis * 3.0 * knockback + entity.getPersistentData().getDouble("z_knockback");
                    if (entityiterator.onGround()) {
                        y_knockback = Math.max(y_knockback, Math.min(0.5 * knockback, 1.5));
                    }

                    if (JujutsucraftModVariables.MapVariables.get(world).BlastGame) {
                        var10000 = x_knockback * 4.0;
                        if (entityiterator instanceof LivingEntity) {
                            _entity = (LivingEntity)entityiterator;
                            var10002 = _entity.getHealth();
                        } else {
                            var10002 = -1.0F;
                        }

                        var10002 = Math.max(var10002, 1.0F);
                        if (entityiterator instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entityiterator;
                            var10003 = _livEnt.getMaxHealth();
                        } else {
                            var10003 = -1.0F;
                        }

                        x_knockback = var10000 * (double)(1.0F - var10002 / Math.max(var10003, 1.0F));
                        var10000 = y_knockback * 4.0;
                        if (entityiterator instanceof LivingEntity) {
                            _entity = (LivingEntity)entityiterator;
                            var10002 = _entity.getHealth();
                        } else {
                            var10002 = -1.0F;
                        }

                        var10002 = Math.max(var10002, 1.0F);
                        if (entityiterator instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entityiterator;
                            var10003 = _livEnt.getMaxHealth();
                        } else {
                            var10003 = -1.0F;
                        }

                        y_knockback = var10000 * (double)(1.0F - var10002 / Math.max(var10003, 1.0F));
                        var10000 = z_knockback * 4.0;
                        if (entityiterator instanceof LivingEntity) {
                            _entity = (LivingEntity)entityiterator;
                            var10002 = _entity.getHealth();
                        } else {
                            var10002 = -1.0F;
                        }

                        var10002 = Math.max(var10002, 1.0F);
                        if (entityiterator instanceof LivingEntity) {
                            _livEnt = (LivingEntity)entityiterator;
                            var10003 = _livEnt.getMaxHealth();
                        } else {
                            var10003 = -1.0F;
                        }

                        label940: {
                            z_knockback = var10000 * (double)(1.0F - var10002 / Math.max(var10003, 1.0F));
                            if (entityiterator instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entityiterator;
                                if (_livEnt.hasEffect(JujutsucraftModMobEffects.GUARD.get())) {
                                    var89 = _livEnt.getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                    break label940;
                                }
                            }

                            var89 = 0;
                        }

                        if (var89 < 1 && Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0)) > 10.0) {
                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BLACK_FLASH_1.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 50, 2.0, 2.0, 2.0, 2.0);
                            }

                            if (world instanceof ServerLevel) {
                                _level = (ServerLevel)world;
                                _level.sendParticles(JujutsucraftModParticleTypes.PARTICLE_BROKEN_GLASS_SMALL.get(), entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), 50, 2.0, 2.0, 2.0, 2.0);
                            }

                            if (world instanceof Level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                                } else {
                                    _level.playLocalSound(entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:critical")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                                }
                            }
                        }
                    }

                    entityiterator.setDeltaMovement(new Vec3(x_knockback, y_knockback, z_knockback));
                    if (entityiterator instanceof Player) {
                        boolean _setval = true;
                        Entity finalEntityiterator = entityiterator;
                        entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.p_flag_power = _setval;
                            capability.syncPlayerVariables(finalEntityiterator);
                        });
                        double finalX_knockback = x_knockback;
                        entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.p_x_power = finalX_knockback;
                            capability.syncPlayerVariables(finalEntityiterator);
                        });
                        double finalY_knockback = y_knockback;
                        entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.p_y_power = finalY_knockback;
                            capability.syncPlayerVariables(finalEntityiterator);
                        });
                        double finalZ_knockback = z_knockback;
                        entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent((capability) -> {
                            capability.p_z_power = finalZ_knockback;
                            capability.syncPlayerVariables(finalEntityiterator);
                        });
                    }

                    entityiterator.getPersistentData().putDouble("old_x_position", entityiterator.getPersistentData().getDouble("old_x_position") - x_knockback);
                    entityiterator.getPersistentData().putDouble("old_y_position", entityiterator.getPersistentData().getDouble("old_y_position") - y_knockback);
                    entityiterator.getPersistentData().putDouble("old_z_position", entityiterator.getPersistentData().getDouble("old_z_position") - z_knockback);
                }
            }

            if (logic_swing && entity.getPersistentData().getBoolean("swing")) {
                if (SwordAttack) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        _livEnt.swing(InteractionHand.MAIN_HAND, true);
                    }
                } else if (!(Math.random() < 0.5) && !(entity instanceof Player)) {
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        _livEnt.swing(InteractionHand.OFF_HAND, true);
                    }
                } else if (entity instanceof LivingEntity) {
                    _livEnt = (LivingEntity)entity;
                    _livEnt.swing(InteractionHand.MAIN_HAND, true);
                }
            }

            entity.getPersistentData().putDouble("effect", 0.0);
            entity.getPersistentData().putDouble("effectConfirm", 0.0);
            entity.getPersistentData().putDouble("knockback", 0.0);
            entity.getPersistentData().putDouble("projectile_type", 0.0);
            entity.getPersistentData().putBoolean("swing", false);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("DomainAttack", false);
            entity.getPersistentData().putBoolean("ignore", false);
        }
    }
}

