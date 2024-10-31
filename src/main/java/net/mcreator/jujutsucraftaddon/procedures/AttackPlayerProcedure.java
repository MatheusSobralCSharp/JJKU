package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.UiUiEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.FakeClonesEntity;
import net.mcreator.jujutsucraftaddon.entity.CloneEntity;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class AttackPlayerProcedure {
    @SubscribeEvent
    public static void onEntityAttacked(LivingHurtEvent event) {
        if (event != null && event.getEntity() != null) {
            execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
        }
    }

    public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
        execute(null, world, x, y, z, damagesource, entity, sourceentity, amount);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity sourceentity, double amount) {
        if (damagesource == null || entity == null || sourceentity == null)
            return;
        if (entity instanceof LivingEntity) {
            if (sourceentity.isAlive()) {
                if (entity.isAlive()) {
                    CeLevelProcedure.execute(sourceentity);
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            KashimoDefenseProcedure.execute(world, x, y, z, entity);
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 30) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            MiguelAttackedProcedure.execute(world, entity, sourceentity);
                        }
                    }
                    if (entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(JujutsucraftaddonModMobEffects.COUNTER.get())) {
                        CounterProcedureProcedure.execute(world, damagesource, entity, sourceentity);
                        if (event != null && event.isCancelable()) {
                            event.setCanceled(true);
                        } else if (event != null && event.hasResult()) {
                            event.setResult(Event.Result.DENY);
                        }
                    }
                    if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
                                if (Math.random() <= 0.2) {
                                    TodoHitProcedure2Procedure.execute(world, x, y, z, entity, sourceentity);
                                }
                            } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
                                MegumiHitProcedure.execute(world, entity, sourceentity);
                            }
                        }
                        if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())
                                ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier()
                                : 0) >= 19) {
                            if (!(entity instanceof ServerPlayer _plr10 && _plr10.level() instanceof ServerLevel
                                    && _plr10.getAdvancements().getOrStartProgress(_plr10.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:world_slash_advancement"))).isDone()) && entity instanceof ServerPlayer _plr11
                                    && _plr11.level() instanceof ServerLevel && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
                                WorldSlashQuestProcedure.execute(world, entity);
                            }
                        }
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BrainDamage == 5) {
                            BrainEffectTwoProcedure.execute(world, entity);
                        }
                        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED) == true) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
                                    || (entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 21) {
                                if (Math.random() <= 0.05) {
                                    if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                                            && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1"))).isDone()) {
                                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_SUKUNA_HEALTH_POSSESSION))) {
                                            SukunaKeybindOnKeyPressedProcedure.execute(world, x, y, z, entity);
                                        }
                                    }
                                }
                            }
                        }
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                            ChangeMimicryProcedure.execute(entity, sourceentity);
                        }
                        if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) == false) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != -1) {
                                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.INFINITY_EFFECT.get()) == false) {
                                        if (!((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Death Painting")) {
                                            if (amount > 5) {
                                                LimbssProcedure.execute(world, entity, amount);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_LIMB_LOSS) == true) {
                            if (!(new Object() {
                                public boolean checkGamemode(Entity _ent) {
                                    if (_ent instanceof ServerPlayer _serverPlayer) {
                                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                                    } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
                                                && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                                    }
                                    return false;
                                }
                            }.checkGamemode(entity))) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Limb > 0) {
                                    if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get()))) {
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.LIMBS_EFFECT.get(), -1, 1, false, false));
                                    }
                                }
                            }
                        }
                        if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                            if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) == false) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SimpleDomain == true) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get(), 20,
                                                (int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())
                                                        ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()).getAmplifier()
                                                        : 0) + 1),
                                                false, false));
                                }
                            }
                        }
                        if (entity.getPersistentData().getDouble("brokenBrain") == 2) {
                            if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(MobEffects.CONFUSION))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60, 245, false, false));
                            }
                        }
                    }
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Subrace).equals("Disaster Curses")) {
                        ((LivingHurtEvent) event).setAmount(((float) (amount / 1.2)));
                    }
                    if (entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
                            ((LivingHurtEvent) event).setAmount(((float) (amount / 1.1)));
                        }
                    }
                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1) {
                        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_BLACK_FLASH_REWORKED) == true) {
                            CounterBFProcedure.execute(world, sourceentity);
                        }
                    }
                    if (entity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(JujutsucraftaddonModMobEffects.TRAINING.get())) {
                        if (amount > 80) {
                            TrainingFailedProcedure.execute(world, x, y, z, entity);
                        }
                    }
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
                            if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) == false
                                    && (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false
                                    && (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) == false) {
                                MegumiProcedure.execute(world, x, y, z, entity, sourceentity, amount);
                            }
                        }
                    }
                    if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                            LineSukunaProcedure.execute(world, x, y, z, sourceentity);
                        }
                    }
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
                        if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                            LineGojoProcedure.execute(world, x, y, z, sourceentity);
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                        if (entity instanceof ServerPlayer _plr47 && _plr47.level() instanceof ServerLevel
                                && _plr47.getAdvancements().getOrStartProgress(_plr47.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
                            if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
                                if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                                    YutaCondition2Procedure.execute(world, x, y, z, entity);
                                }
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).CEShield == 1) {
                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel > 0) {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower > 100) {
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                    capability.PlayerCursePower = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower
                                            - 100 / (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel);
                                    capability.syncPlayerVariables(entity);
                                });
                                ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                                if (entity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal("Reduced 50% Of Damage"), false);
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 16) {
                        MahoragaAdaptedProcedure.execute(world, damagesource, entity);
                        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("" + damagesource)) > 50) {
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                    if (sourceentity instanceof CloneEntity || sourceentity instanceof FakeClonesEntity) {
                        if (sourceentity instanceof LivingEntity _entity)
                            _entity.swing(InteractionHand.MAIN_HAND, true);
                    }
                    if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (entityiterator instanceof UiUiEntity) {
                                    if ((entityiterator.getPersistentData().getString("OWNER_UUID")).equals(entity.getStringUUID())) {
                                        {
                                            Entity _ent = entityiterator;
                                            _ent.teleportTo(x, y, z);
                                            if (_ent instanceof ServerPlayer _serverPlayer)
                                                _serverPlayer.connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
                                        }
                                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 400,
                                                    (int) ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())
                                                            ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier()
                                                            : 0) + 3),
                                                    false, false));
                                    }
                                }
                            }
                        }
                    }
                    if (sourceentity instanceof LivingEntity _livEnt68 && _livEnt68.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get())) {
                        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.YUUN.get()) {
                            ((LivingHurtEvent) event).setAmount(((float) (amount * 2)));
                        }
                    }
                    if (entity.getPersistentData().getDouble("IsMahoraga") == 1
                            && (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()).toString()).contains("mahoraga")) {
                        MahoragaLogicProcedure.execute(world, entity, sourceentity);
                    }
                    if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.WUKONG_STAFF.get()
                                || ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder Blitz")) {
                            SummonCloneProcedure.execute(world, x, y, z, sourceentity);
                        }
                    }
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKM_WUKONG) == true) {
                        if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) > 19) {
                            if (entity.getPersistentData().getDouble("Wukong") == 0) {
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:wukongtheme")), SoundSource.MASTER, 1, 1, false);
                                    }
                                }
                                entity.getPersistentData().putDouble("Wukong", 1);
                            }
                        }
                    }
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NPC_FISTS) == true) {
                        if ((ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()).startsWith("jujutsucraft")) {
                            NpcFistsProcedure.execute(world, entity, sourceentity);
                        }
                    }
                    if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:eight_handled_swrod_divergent_sila_divine_general_mahoraga")) {
                        if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble(("skill" + new java.text.DecimalFormat("##.##").format(new Object() {
                            public double getValue() {
                                CompoundTag dataIndex = new CompoundTag();
                                sourceentity.saveWithoutId(dataIndex);
                                return dataIndex.getCompound("ForgeData").getDouble("skill");
                            }
                        }.getValue()))) >= 100) {
                            if (!(new Object() {
                                public double getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            sourceentity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                                        }
                                    }.getValue())));
                                }
                            }.getValue() == 1)) {
                                ((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
                                        .setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 1));
                                {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entity.saveWithoutId(dataIndex);
                                    dataIndex.getCompound("ForgeData").putDouble(("adapted" + new java.text.DecimalFormat("##.##").format(new Object() {
                                        public double getValue() {
                                            CompoundTag dataIndex = new CompoundTag();
                                            sourceentity.saveWithoutId(dataIndex);
                                            return dataIndex.getCompound("ForgeData").getDouble("skill");
                                        }
                                    }.getValue())), 1);
                                    entity.load(dataIndex);
                                }
                            }
                        }
                    }
                    if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                        if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            SlashProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
                        }
                        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_OST_PLAYER) == true) {
                            SongsProcedure.execute(world, x, y, z, entity, sourceentity);
                        }
                        if (sourceentity instanceof ServerPlayer _plr98 && _plr98.level() instanceof ServerLevel
                                && _plr98.getAdvancements().getOrStartProgress(_plr98.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cursed_fists"))).isDone()
                                && (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                FistSukunaProcedure.execute(world, sourceentity);
                            } else if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) == false) {
                                FistsProcedureProcedure.execute(world, x, y, z, entity, sourceentity);
                            }
                        }
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 5) {
                            if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()) == false) {
                                if (sourceentity instanceof ServerPlayer _plr103 && _plr103.level() instanceof ServerLevel
                                        && _plr103.getAdvancements().getOrStartProgress(_plr103.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:sorcerer_strongest_of_modern"))).isDone()) {
                                    YutaConditionProcedure.execute(world, x, y, z, sourceentity);
                                }
                            }
                        }
                    } else if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (!(sourceentity instanceof LivingEntity _livEnt105 && _livEnt105.hasEffect(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get()))) {
                            if (sourceentity.getPersistentData().getDouble("skill_domain") == 1) {
                                if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SHRINE_EFFECT.get(), -1, 1, false, false));
                            }
                        }
                        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            WhenHitPlayerProcedure.execute(world, x, y, z, entity, sourceentity);
                            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10) {
                                ChosoExtensionProcedure.execute(world, entity, sourceentity);
                            } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
                                CutRCTProcedure.execute(world, entity);
                            } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 24) {
                                if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Uraume")) {
                                    WhenHitUraumeProcedure.execute(world, entity);
                                }
                            }
                        }
                        if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 27) {
                                ConfiscationAndGuiltyProcedure.execute(world, entity, sourceentity);
                            } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 26) {
                                entity.setSecondsOnFire(15);
                                (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
                                        .setDamageValue((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getDamageValue() - 1));
                            } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6) {
                                if ((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.ZONE.get())) {
                                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel >= 3) {
                                        if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 20) {
                                            SummonAllShadowsProcedure.execute(world, x, y, z, entity, sourceentity);
                                            {
                                                double _setval = 0;
                                                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                                    capability.OutputLevel = _setval;
                                                    capability.syncPlayerVariables(sourceentity);
                                                });
                                            }
                                        }
                                    }
                                }
                            } else if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
                                TojiRCTCutProcedure.execute(world, x, y, z, entity, sourceentity);
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BLACK_FLASH_CUT.get(), 60, 1, false, false));
                                ((LivingHurtEvent) event).setAmount(((float) (amount + Mth.nextInt(RandomSource.create(), 1, 10))));
                            }
                        }
                        if (((sourceentity instanceof LivingEntity) && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                            if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_AIR_COMBAT) == true) {
                                AirCombatProcedure.execute(world, x, y, z, entity, sourceentity);
                            }
                        }
                    }
                    if (((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .contains(Component.translatable("dialoguesoul2").getString())
                            || ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                            .contains(Component.translatable("dialoguesoul1").getString())) {
                        if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())
                                || sourceentity instanceof LivingEntity _livEnt132 && _livEnt132.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                            if (Math.random() <= 0.5) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.HAITI.get()), x, y, z, 1, 1, 1, 1, 1);
                            } else {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.KAI.get()), x, y, z, 1, 1, 1, 1, 1);
                            }
                            ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(),
                                        (120 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getDuration() : 0)),
                                        (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1), false, true));
                        }
                    }
                    if (sourceentity.getPersistentData().getDouble("Kyoka") == 5) {
                        if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.KYOKA.get()) {
                            SpawnCloneDefensiveProcedure.execute(world, x, y, z, entity);
                            {
                                Entity _ent = entity;
                                _ent.teleportTo((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)));
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport((entity.getX()), (entity.getY()), (sourceentity.getZ() + Mth.nextInt(RandomSource.create(), -10, 10)), _ent.getYRot(), _ent.getXRot());
                            }
                            sourceentity.hurt(damagesource, (float) amount);
                            if (event != null && event.isCancelable()) {
                                event.setCanceled(true);
                            } else if (event != null && event.hasResult()) {
                                event.setResult(Event.Result.DENY);
                            }
                        }
                    }
                    if (sourceentity.getPersistentData().getDouble("Jogoat") == 1) {
                        RemoveNegativeStatusProcedure.execute(world, sourceentity);
                    }
                    if (sourceentity.getPersistentData().getBoolean("CursedSpirit") == false) {
                        ProfessionAttackProcedure.execute(world, x, y, z, damagesource, entity, sourceentity, amount);
                    }
                    if (sourceentity instanceof LivingEntity _livEnt149 && _livEnt149.hasEffect(JujutsucraftaddonModMobEffects.MEDITATION_STATE.get())) {
                        if (entity.getPersistentData().getDouble("Spirit") == 1) {
                            if (amount < 400) {
                                sourceentity.getPersistentData().putDouble("PointsSpirit", (sourceentity.getPersistentData().getDouble("PointsSpirit") + amount));
                                if (entity instanceof LivingEntity _entity)
                                    _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
                            } else {
                                if (entity instanceof LivingEntity _entity)
                                    _entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
                                if (event != null && event.isCancelable()) {
                                    event.setCanceled(true);
                                } else if (event != null && event.hasResult()) {
                                    event.setResult(Event.Result.DENY);
                                }
                            }
                        }
                    }
                    if (entity.getPersistentData().getBoolean("CursedSpirit") == true && entity.getPersistentData().getBoolean("CurseUser") == false) {
                        Mahito3Procedure.execute(world, damagesource, entity, sourceentity, amount);
                    }
                    if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get())) == false) {
                        if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                            if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) == false) {
                                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 19
                                        && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                                    if (Math.random() <= 0.1) {
                                        SpawnFakeCloneProcedure.execute(world, x, y, z, entity);
                                        {
                                            Entity _ent = entity;
                                            _ent.teleportTo(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)));
                                            if (_ent instanceof ServerPlayer _serverPlayer)
                                                _serverPlayer.connection.teleport(x, y, (z + Mth.nextInt(RandomSource.create(), 1, 4)), _ent.getYRot(), _ent.getXRot());
                                        }
                                        if (event != null && event.isCancelable()) {
                                            event.setCanceled(true);
                                        } else if (event != null && event.hasResult()) {
                                            event.setResult(Event.Result.DENY);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (sourceentity instanceof IgrisEntity || sourceentity instanceof Shadow1Entity) {
                        AttackedShadowsProcedure.execute(x, y, z, sourceentity);
                    }
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Wukong")) {
                        WukongProcedure.execute(world, entity, sourceentity);
                    }
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Wukong")) {
                        {
                            final Vec3 _center = new Vec3(x, y, z);
                            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo_no_move")))) {
                                    if (!entityiterator.level().isClientSide())
                                        entityiterator.discard();
                                    if (event != null && event.isCancelable()) {
                                        event.setCanceled(true);
                                    } else if (event != null && event.hasResult()) {
                                        event.setResult(Event.Result.DENY);
                                    }
                                } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                    if (!entityiterator.level().isClientSide())
                                        entityiterator.discard();
                                    if (event != null && event.isCancelable()) {
                                        event.setCanceled(true);
                                    } else if (event != null && event.hasResult()) {
                                        event.setResult(Event.Result.DENY);
                                    }
                                }
                            }
                        }
                        sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                (float) amount);
                        ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 120,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) + 1), false, false));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 60,
                                    (int) ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())
                                            ? ((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier()
                                            : 0) + 1),
                                    false, false));
                    }
                    if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
                        sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))),
                                (float) amount);
                        ((LivingHurtEvent) event).setAmount(((float) (amount / 2)));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 4, false, false));
                    }
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sung")) {
                        {
                            double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower / 1.1);
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                capability.PlayerCursePower = _setval;
                                capability.syncPlayerVariables(entity);
                            });
                        }
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.WEAKNESS) ? _livEnt.getEffect(MobEffects.WEAKNESS).getAmplifier() : 0) + 1),
                                    false, false));
                    }
                    if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).IsVessel) {
                        if ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 24
                                    || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 12
                                    || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 39
                                    || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7
                                    || (sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 38) {
                                if (Math.random() <= 0.03) {
                                    {
                                        double _setval = ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 5);
                                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(entity);
                                        });
                                    }
                                    {
                                        double _setval = ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + 5);
                                        sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                            capability.PlayerCursePower = _setval;
                                            capability.syncPlayerVariables(sourceentity);
                                        });
                                    }
                                }
                                if (Math.random() <= 0.4) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 0, false, false));
                                }
                                if (Math.random() <= 0.4) {
                                    ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                                }
                            }
                        }
                    }
                    if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Rejected Zenin")) {
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == -1) {
                            ((LivingHurtEvent) event).setAmount(((float) (amount * 1.2)));
                            if (Math.random() <= 0.1) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 60,
                                            (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 1), false,
                                            false));
                            }
                        }
                    }
                    if ((sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
                        if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                            if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
                                if (Math.random() < (1) / ((float) 20)) {
                                    DestroyBlocksProcedure.execute(world, x, y, z, entity, sourceentity);
                                } else {
                                    RightClickAirProcedure.execute(world, x, y, z, entity, sourceentity);
                                }
                            }
                        }
                        if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
                            if (Math.random() < (1) / ((float) 20)) {
                                DestroyBlocksProcedure.execute(world, x, y, z, entity, sourceentity);
                            } else {
                                RightClickAirProcedure.execute(world, x, y, z, entity, sourceentity);
                            }
                        }
                    }
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 7) {
                        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Thunder God")) {
                            if (Math.random() < (1) / ((float) 25)) {
                                if (world instanceof ServerLevel _serverLevel) {
                                    Entity entitytospawn = EntityType.LIGHTNING_BOLT.spawn(_serverLevel, BlockPos.containing((entity.getX()), (entity.getY()), (entity.getZ())), MobSpawnType.MOB_SUMMONED);
                                    if (entitytospawn != null) {
                                        entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                    }
                                    entity.hurt(damagesource, (float) (amount + 40));
                                }
                                if (world instanceof Level _level) {
                                    if (!_level.isClientSide()) {
                                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.WEATHER, 1, 2);
                                    } else {
                                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.WEATHER, 1, 2, false);
                                    }
                                }
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_WHITE.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0, 0, 0, 1);
                            } else if (Math.random() < (1) / ((float) 10)) {
                                if (world instanceof ServerLevel _level)
                                    _level.sendParticles((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLACK.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), 1, 0, 0, 0, 1);
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.FATIGUE.get(), 40,
                                            (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.FATIGUE.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.FATIGUE.get()).getAmplifier() : 0) + 0), false,
                                            false));
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Shikigami Defensive")) {
                            if (Math.random() < (1) / ((float) 5)) {
                                MegumiHitProcedure.execute(world, entity, sourceentity);
                            }
                        }
                    }
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Shikigami Offensive")) {
                            MegumiHit3Procedure.execute(world, entity, sourceentity);
                        }
                    }
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
                        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("Combat Mode")) {
                            TeleportAttackProcedure.execute(entity, sourceentity);
                        }
                    }
                    if ((sourceentity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 31) {
                        if (((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("New Shadow Style: Offensive")) {
                            if (Math.random() < (1) / ((float) 10)) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 40,
                                            (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier() : 0)
                                                    + 0),
                                            false, false));
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 40,
                                            (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getAmplifier() : 0)
                                                    + 0),
                                            false, false));
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 40,
                                            (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get())
                                                    ? _livEnt.getEffect(JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get()).getAmplifier()
                                                    : 0) + 0),
                                            false, false));
                            }
                        }
                    }
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 31) {
                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Mode).equals("New Shadow Style: Defensive")) {
                            if (sourceentity instanceof LivingEntity && ((LivingEntity) sourceentity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                if (Math.random() < (1) / ((float) 2)) {
                                    if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()))) {
                                        if (entity instanceof LivingEntity _entity)
                                            _entity.removeEffect(JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get());
                                    }
                                }
                            }
                            if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
                                if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftModMobEffects.NEUTRALIZATION.get()))) {
                                    if (Math.random() < (1) / ((float) 5)) {
                                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.GUARD.get(), 40,
                                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JujutsucraftModMobEffects.GUARD.get()) ? _livEnt.getEffect(JujutsucraftModMobEffects.GUARD.get()).getAmplifier() : 0) + 3), false,
                                                    false));
                                    }
                                }
                            }
                        }
                    }
                    Completed10Procedure.execute(world, x, y, z, entity, sourceentity);
                }
            }
        }
    }
}
