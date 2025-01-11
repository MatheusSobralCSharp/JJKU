package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.GameRules;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;

import javax.annotation.Nullable;

import java.util.Arrays;
import java.util.Objects;

@Mod.EventBusSubscriber
public class SpawnedProcedure {
    @SubscribeEvent
    public static void onEntitySpawned(EntityJoinLevelEvent event) {
        execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity))
            return;

        if (world instanceof ServerLevel serverLevel) {
            if (serverLevel.getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_VANILLA)) {
                if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:vanilla_mob")))) {
                    cancelEvent(event);
                }
            }
        }

        ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (entityTypeKey == null || !entityTypeKey.toString().startsWith("jujutsucraft"))
            return;


        handleMahoragaLogic(world, x, y, z, entity);

        if (entity instanceof RedEntity redEntity) {
            Pose pose = redEntity.getPose();
            redEntity.getDimensions(pose).scale((float)SizeByNBTProcedure.execute(entity));
        }

        boolean isServerSide = !livingEntity.level().isClientSide();

        if (isServerSide) {
            livingEntity.addEffect(new MobEffectInstance(
                    JujutsucraftaddonModMobEffects.RESPAWNED_JUJUTSU.get(), 20, 1, false, false
            ));
        }

        MobSpawnType spawnType = entity instanceof PathfinderMob ? ((PathfinderMob) entity).getSpawnType() : null;
        if (spawnType != null) {
            handleEntitySpawnLogic(event, world, entity, spawnType, entityTypeKey);
        }

    }

    private static void handleEntitySpawnLogic(Event event, LevelAccessor world, Entity entity, MobSpawnType
            spawnType, ResourceLocation entityTypeKey) {
        String spawnTypeName = spawnType.toString();
        boolean isCommandSpawn = "COMMAND".equals(spawnTypeName);

        if (!isCommandSpawn) {
            cancelEventIfRuleMet(event, world, JujutsucraftaddonModGameRules.JJKU_NO_STEVENSON, entity instanceof StevensonScreenEntity);
            cancelEventIfRuleMet(event, world, JujutsucraftaddonModGameRules.JJKU_NO_ARMORY_SPIRIT, entity instanceof CursedSpiritGrade37Entity);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_SUKUNA_RATE, SukunaEntity.class, SukunaFushiguroEntity.class, SukunaPerfectEntity.class);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_GOJO_RATE, GojoSatoruSchoolDaysEntity.class, GojoSatoruEntity.class);
            cancelEventIfChanceFails(event, world, entity, spawnTypeName, JujutsucraftaddonModGameRules.JJKU_TOJI_RATE, FushiguroTojiEntity.class, FushiguroTojiBugEntity.class);
            cancelEventIfPersistentData(event, world, entity, "CursedSpirit", JujutsucraftaddonModGameRules.JJKU_CURSED_SPIRIT_RATE, spawnTypeName);
            cancelEventIfPersistentData(event, world, entity, "CurseUser", JujutsucraftaddonModGameRules.JJKU_CURSE_USERS_RATE, spawnTypeName);
            cancelEventIfPersistentData(event, world, entity, "JujutsuSorcerer", JujutsucraftaddonModGameRules.JJKU_SORCERERS_RATE, spawnTypeName);
        }

        handleBuffModification(world, entity);
    }

    private static void handleBuffModification(LevelAccessor world, Entity entity) {
        if (entity.getPersistentData().getDouble("CursedSpirit") == 1
                || entity.getPersistentData().getDouble("CurseUser") == 1
                || entity.getPersistentData().getDouble("JujutsuSorcerer") == 1) {

            CompoundTag forgeData = entity.getPersistentData().getCompound("ForgeData");
            if (forgeData.getDouble("buff") != 1) {
                LivingEntity livingEntity = (LivingEntity) entity;
                AttributeInstance maxHealthAttr = livingEntity.getAttribute(Attributes.MAX_HEALTH);
                if (maxHealthAttr != null) {
                    double gameDifficulty = world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_DIFFICULTY);
                    double newMaxHealth = 100.0 / gameDifficulty * maxHealthAttr.getBaseValue();
                    maxHealthAttr.setBaseValue(newMaxHealth);
                    livingEntity.setHealth(livingEntity.getMaxHealth());
                }
                forgeData.putDouble("buff", 1);
                entity.getPersistentData().put("ForgeData", forgeData);
            }
        }
    }

    private static void handleMahoragaLogic(LevelAccessor world, double x, double y, double z, Entity entity) {
        KenjakuDomainSummoningProcedure.execute(world, x, y, z, entity);
        if (entity.getPersistentData().getDouble("Mahoraga") == 1
                && entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity
                && entity instanceof LivingEntity livingEntity
                && !livingEntity.level().isClientSide()) {
            livingEntity.addEffect(new MobEffectInstance(
                    JujutsucraftaddonModMobEffects.MAHO_EFFECTO.get(), 40, 1, false, false
            ));
        }
    }


    private static void cancelEventIfRuleMet(Event event, LevelAccessor
            world, GameRules.Key<GameRules.BooleanValue> rule, boolean condition) {
        if (world.getLevelData().getGameRules().getBoolean(rule) && condition) {
            cancelEvent(event);
        }
    }

    private static void cancelEventIfChanceFails(Event event, LevelAccessor world, Entity entity, String
            spawnTypeName, GameRules.Key<GameRules.IntegerValue> rule, Class<?>... entityClasses) {
        if (Arrays.stream(entityClasses).anyMatch(clazz -> clazz.isInstance(entity))
                && Math.random() >= 0.01 * world.getLevelData().getGameRules().getInt(rule)) {
            if (entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                if (entity.getPersistentData().getDouble("friend_num") == 0) {
                    if (entity.getPersistentData().getDouble("Spirit") == 0) {
                        cancelEvent(event);
                    }
                }
            }
        }
    }

    private static void cancelEventIfPersistentData(Event event, LevelAccessor world, Entity entity, String
            key, GameRules.Key<GameRules.IntegerValue> rule, String spawnTypeName) {
        if (entity.getPersistentData().getDouble(key) == 1
                && Math.random() >= 0.01 * world.getLevelData().getGameRules().getInt(rule)) {
            if (entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
                if (entity.getPersistentData().getDouble("friend_num") == 0) {
                    if (entity.getPersistentData().getDouble("Spirit") == 0) {
                        cancelEvent(event);
                    }
                }
            }
        }
    }

    private static void cancelEvent(Event event) {
        if (event != null) {
            if (event.isCancelable()) {
                event.setCanceled(true);
            } else if (event.hasResult()) {
                event.setResult(Event.Result.DENY);
            }
        }
    }


}
