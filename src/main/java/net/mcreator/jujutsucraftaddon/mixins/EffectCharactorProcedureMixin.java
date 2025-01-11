package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.mcreator.jujutsucraft.entity.KashimoHajimeEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaCullingGameEntity;
import net.mcreator.jujutsucraft.entity.OkkotsuYutaEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.EffectCharactorProcedure;
import net.mcreator.jujutsucraftaddon.entity.IgrisEntity;
import net.mcreator.jujutsucraftaddon.entity.Shadow1Entity;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

@Mixin(value = EffectCharactorProcedure.class, priority = 3000)
public abstract class EffectCharactorProcedureMixin {
    /**
     * @author Satushi
     * @reason Fixing/Changes
     */
    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, Entity entityiterator, CallbackInfo ci) {
        if (entity != null && entityiterator != null) {
            ItemStack item_A = ItemStack.EMPTY;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double NUM1 = 0.0;
            String STR1 = "";
            boolean cursed_technique = false;
            boolean logic_start = false;
            boolean logic_a = false;
            Entity entity_a = null;
            Entity entity_b = null;
            entity_a = entityiterator;
            int index1;
            if (entity_a instanceof LivingEntity) {
                label459: {
                    cursed_technique = entity.getPersistentData().getDouble("skill") > 100.0 && !entity.getPersistentData().getBoolean("attack");
                    x_pos = entity_a.getX();
                    y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5;
                    z_pos = entity_a.getZ();
                    ItemStack var10000;
                    int index2;
                    LivingEntity _livEnt;
                    Player _player;
                    if (entity.getPersistentData().getBoolean("attack")) {
                        label427: {
                            label460: {
                                if (entity instanceof Player) {
                                    if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 7.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 7.0) {
                                        break label460;
                                    }
                                } else if (!(entity instanceof KashimoHajimeEntity)) {
                                    break label460;
                                }

                                NUM1 = entity_a.getPersistentData().getDouble("Thunder");
                                ServerLevel _level;
                                if (entity.getPersistentData().getDouble("cnt5") != 0.0 && !(entity.getPersistentData().getDouble("cnt5") >= 100.0)) {
                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel)world;
                                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
                                    }

                                    entity_a.getPersistentData().putDouble("Thunder", entity_a.getPersistentData().getDouble("Thunder") + 0.25);
                                } else {
                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel)world;
                                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 5, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
                                    }

                                    entity_a.getPersistentData().putDouble("Thunder", entity_a.getPersistentData().getDouble("Thunder") + 1.0);
                                }

                                if (NUM1 < 5.0 && entity_a.getPersistentData().getDouble("Thunder") >= 5.0 || entity_a.getPersistentData().getDouble("Thunder") >= 15.0) {
                                    if (world instanceof ServerLevel) {
                                        _level = (ServerLevel)world;
                                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 10, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.25);
                                    }

                                    if (world instanceof Level) {
                                        Level _level4 = (Level)world;
                                        if (!_level4.isClientSide()) {
                                            _level4.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                                        } else {
                                            _level4.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                                        }
                                    }
                                }
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity)entity;
                                var10000 = _livEnt.getMainHandItem();
                            } else {
                                var10000 = ItemStack.EMPTY;
                            }

                            item_A = var10000;
                            if (entity instanceof Player) {
                                _player = (Player)entity;
                                if (_player.getCooldowns().isOnCooldown(item_A.getItem())) {
                                    break label427;
                                }
                            }

                            if (item_A.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                                NUM1 = 0.0;

                                for(index2 = 0; index2 < 200; ++index2) {
                                    ++NUM1;
                                    STR1 = item_A.getOrCreateTag().getString("TARGET" + Math.round(NUM1));
                                    if (STR1.isEmpty()) {
                                        break;
                                    }

                                    if (STR1.equals(entity_a.getStringUUID())) {
                                        if (entity_a instanceof LivingEntity) {
                                            LivingEntity _entity = (LivingEntity)entity_a;
                                            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                                        }

                                        if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                                            entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    CompoundTag var39;
                    if (cursed_technique) {
                        label429: {
                            if (entity_a instanceof Player) {
                                if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 5.0 && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 5.0) {
                                    break label429;
                                }
                            } else if (!(entity_a instanceof OkkotsuYutaEntity) && !(entity_a instanceof OkkotsuYutaCullingGameEntity)) {
                                break label429;
                            }

                            if (entity.getPersistentData().getDouble("skill") != 705.0) {
                                Iterator var21;
                                String criteria;
                                Advancement _adv;
                                AdvancementProgress _ap;
                                ServerPlayer _player2;
                                if (entity.getPersistentData().getDouble("skill") >= 305.0 && entity.getPersistentData().getDouble("skill") < 320.0) {
                                    if (entity_a instanceof ServerPlayer) {
                                        _player2 = (ServerPlayer)entity_a;
                                        _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"));
                                        _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                                        if (!_ap.isDone()) {
                                            var21 = _ap.getRemainingCriteria().iterator();

                                            while(var21.hasNext()) {
                                                criteria = (String)var21.next();
                                                _player2.getAdvancements().award(_adv, criteria);
                                            }
                                        }
                                    }
                                } else if (entity.getPersistentData().getDouble("skill") == 3810.0 && (entity_a instanceof Player || entity_a instanceof OkkotsuYutaCullingGameEntity)) {
                                    if (entity_a instanceof ServerPlayer) {
                                        _player2 = (ServerPlayer)entity_a;
                                        _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"));
                                        _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                                        if (!_ap.isDone()) {
                                            var21 = _ap.getRemainingCriteria().iterator();

                                            while(var21.hasNext()) {
                                                criteria = (String)var21.next();
                                                _player2.getAdvancements().award(_adv, criteria);
                                            }
                                        }
                                    }
                                } else {
                                    if (entity_a instanceof Player) {
                                        logic_a = true;
                                        AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
                                        LazyOptional<IItemHandler> var37 = entity_a.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction) null);

                                        // Check and set the capability if present
                                        var37.ifPresent(_iitemhandlerref::set);

                                        if (_iitemhandlerref.get() != null) {
                                            for (index2 = 0; index2 < _iitemhandlerref.get().getSlots(); ++index2) {
                                                ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(index2).copy();
                                                if (itemstackiterator.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()
                                                        && itemstackiterator.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                                    logic_a = false;
                                                    break;
                                                }
                                            }
                                        }

                                        item_A = new ItemStack(JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get());
                                    } else {
                                        logic_a = false;
                                        NUM1 = 0.0;

                                        for(index1 = 0; index1 < 4; ++index1) {
                                            if (entity_a instanceof LivingEntity) {
                                                LivingEntity _entGetArmor = (LivingEntity)entity_a;
                                                var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int)NUM1));
                                            } else {
                                                var10000 = ItemStack.EMPTY;
                                            }

                                            item_A = var10000;
                                            if (item_A.getOrCreateTag().getDouble("skill") == 0.0 || item_A.getOrCreateTag().getDouble("skill") == entity.getPersistentData().getDouble("skill")) {
                                                logic_a = true;
                                                break;
                                            }

                                            ++NUM1;
                                            if (NUM1 > 3.0) {
                                                NUM1 = 0.0;
                                            }
                                        }

                                        if (!logic_a) {
                                            logic_a = true;
                                            NUM1 = Math.floor(Math.random() * 4.0);
                                            if (entity_a instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity_a;
                                                var10000 = _livEnt.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, (int)NUM1));
                                            } else {
                                                var10000 = ItemStack.EMPTY;
                                            }

                                            item_A = var10000;
                                        }
                                    }

                                    if (logic_a) {
                                        double var10002;
                                        label324: {
                                            entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
                                                public Entity apply(LevelAccessor levelAccessor, String uuid) {
                                                    if (levelAccessor instanceof ServerLevel serverLevel) {
                                                        try {
                                                            return serverLevel.getEntity(UUID.fromString(uuid));
                                                        } catch (Exception var5) {
                                                        }
                                                    }

                                                    return null;
                                                }
                                            }).apply(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
                                            entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                                            item_A.getOrCreateTag().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                                            item_A.getOrCreateTag().putDouble("effect", entity.getPersistentData().getDouble("effect"));
                                            var39 = item_A.getOrCreateTag();
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                    var10002 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                                    break label324;
                                                }
                                            }

                                            var10002 = 0.0;
                                        }

                                        var39.putDouble("COOLDOWN_TICKS", (double)Math.round(Math.max(Math.max(var10002, entity.getPersistentData().getDouble("COOLDOWN_TICKS")) * 2.0, 50.0)));
                                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                            item_A.getOrCreateTag().putString("SHIKIGAMI_NAME", ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString());
                                            var39 = item_A.getOrCreateTag();
                                            if (entity instanceof LivingEntity) {
                                                _livEnt = (LivingEntity)entity;
                                                var10002 = (double)_livEnt.getMaxHealth();
                                            } else {
                                                var10002 = -1.0;
                                            }

                                            var39.putDouble("SHIKIGAMI_HP", var10002);
                                        }

                                        if (entity_a instanceof Player) {
                                            String var10001 = entity_b.getDisplayName().getString();
                                            item_A.setHoverName(Component.literal(var10001 + Component.translatable("jujutsu.message.cursed_technique").getString() + " (" + Component.translatable("jujutsu.overlay.cost").getString() + ": " + Math.round(item_A.getOrCreateTag().getDouble("COOLDOWN_TICKS")) + ")"));
                                            if (entity_a instanceof Player) {
                                                _player = (Player)entity_a;
                                                ItemStack _setstack = item_A.copy();
                                                _setstack.setCount(1);
                                                ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (entity.getPersistentData().getDouble("skill") == 2815.0 && entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity_a.isAlive() && !entity_a.level().isClientSide()) {
                        entity_a.discard();
                    }

                    if (entity_a instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity_a;
                        var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    label423: {
                        item_A = var10000;
                        if (entity_a instanceof Player) {
                            _player = (Player)entity_a;
                            if (_player.getCooldowns().isOnCooldown(item_A.getItem())) {
                                break label423;
                            }
                        }

                        if (item_A.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_A.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                            logic_start = false;
                            if (cursed_technique) {
                                var39 = entity.getPersistentData();
                                STR1 = "skill" + Math.round(var39.getDouble("skill"));
                                logic_start = true;
                            } else if (entity.getPersistentData().getDouble("skill_domain") != 0.0) {
                                var39 = entity.getPersistentData();
                                STR1 = "domain" + Math.round(var39.getDouble("skill_domain"));
                                logic_start = true;
                            }

                            if (logic_start && item_A.getOrCreateTag().getDouble(STR1) == 0.0) {
                                NUM1 = 1.0;

                                for(index2 = 0; index2 < 800; ++index2) {
                                    if (item_A.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals("") || item_A.getOrCreateTag().getString("DATA" + Math.round(NUM1)).equals(STR1)) {
                                        item_A.getOrCreateTag().putString("DATA" + Math.round(NUM1), STR1);
                                        item_A.getOrCreateTag().putDouble(STR1, 1.0);
                                        if (entity_a instanceof Player) {
                                            Player _player3 = (Player)entity_a;
                                            if (!_player3.level().isClientSide()) {
                                                _player3.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.adaptation_start").getString()), false);
                                            }
                                        }
                                        break;
                                    }

                                    ++NUM1;
                                }
                            }
                        }
                    }

                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    item_A = var10000;
                    if (entity instanceof Player) {
                        _player = (Player)entity;
                        if (_player.getCooldowns().isOnCooldown(item_A.getItem())) {
                            break label459;
                        }
                    }

                    if (item_A.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || item_A.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                        label458: {
                            if (entity instanceof Player) {
                                if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                    break label458;
                                }
                            } else if (!((entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) || (entity instanceof IgrisEntity) || (entity instanceof Shadow1Entity))) {
                                break label458;
                            }

                            if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                var39 = item_A.getOrCreateTag();
                                CompoundTag var38 = entity_a.getPersistentData();
                                if (var39.getDouble("skill" + Math.round(var38.getDouble("skill"))) >= 100.0 && !entity_a.level().isClientSide() && entity_a.getServer() != null) {
                                    entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                                }
                            }
                        }
                    }
                }
            }

            if (!entity_a.isAlive() && entity_a instanceof Player && !(entity instanceof Player)) {
                entity_b = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) ? (new BiFunction<LevelAccessor, String, Entity>() {
                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                            try {
                                return serverLevel.getEntity(UUID.fromString(uuid));
                            } catch (Exception var5) {
                            }
                        }

                        return null;
                    }
                }).apply(world, entity.getPersistentData().getString("OWNER_UUID")) : entity;
                entity_b = entity_b instanceof LivingEntity ? entity_b : entity;
                if (!(entity_b instanceof Player)) {
                    NUM1 = 1.0;

                    for(index1 = 0; index1 < 128; ++index1) {
                        STR1 = "pName" + Math.round(NUM1);
                        if (entity_b.getPersistentData().getString(STR1).equals("")) {
                            entity_b.getPersistentData().putString(STR1, entity_a.getDisplayName().getString());
                            break;
                        }

                        ++NUM1;
                    }
                }
            }

        }
        ci.cancel();
    }
}
