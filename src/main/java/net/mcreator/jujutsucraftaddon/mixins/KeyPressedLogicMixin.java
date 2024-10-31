package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModGameRules;
import net.mcreator.jujutsucraft.init.JujutsucraftModItems;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Iterator;

@Mixin(value = StartCursedTechniqueProcedure.class, remap = false)
public abstract class KeyPressedLogicMixin {
    public KeyPressedLogicMixin() {

    }

    /**
     * @author Satushi
     * @reason Changes
     */
    @Overwrite
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            String STR1 = "";
            boolean logic_a = false;
            boolean CREATIVE = false;
            boolean item_use = false;
            boolean noUseCursePower = false;
            ItemStack item_a = ItemStack.EMPTY;
            double Level = 0.0;
            double Tick = 0.0;
            double NUM1 = 0.0;
            double skill = 0.0;
            double T1 = 0.0;
            double S1 = 0.0;
            double T2 = 0.0;
            double cost = 0.0;
            ItemStack var10000;
            LivingEntity _livEnt11;
            if (entity instanceof LivingEntity) {
                _livEnt11 = (LivingEntity) entity;
                var10000 = _livEnt11.getMainHandItem();
            } else {
                var10000 = ItemStack.EMPTY;
            }

            LivingEntity _livEnt12;
            LivingEntity _livEnt13;
            if (var10000.getOrCreateTag().getBoolean("used_item")) {
                if (entity instanceof LivingEntity) {
                    _livEnt13 = (LivingEntity) entity;
                    var10000 = _livEnt13.getMainHandItem();
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                item_a = var10000;
                item_use = true;
            } else {
                if (entity instanceof LivingEntity) {
                    _livEnt12 = (LivingEntity) entity;
                    var10000 = _livEnt12.getOffhandItem();
                } else {
                    var10000 = ItemStack.EMPTY;
                }

                if (var10000.getOrCreateTag().getBoolean("used_item")) {
                    if (entity instanceof LivingEntity) {
                        _livEnt13 = (LivingEntity) entity;
                        var10000 = _livEnt13.getOffhandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    item_a = var10000;
                    item_use = true;
                }
            }

            if (item_use) {
                item_a.getOrCreateTag().putBoolean("used_item", false);
                STR1 = item_a.getDisplayName().getString();
                skill = item_a.getOrCreateTag().getDouble("skill");
                cost = item_a.getOrCreateTag().getDouble("COOLDOWN_TICKS");
                if (item_a.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                    noUseCursePower = true;
                }
            } else {
                boolean _setval = true;
                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                    capability.noChangeTechnique = _setval;
                    capability.syncPlayerVariables(entity);
                });
                KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            Player _player;
            label334:
            {
                if (item_use) {
                    label341:
                    {
                        if (entity instanceof LivingEntity) {
                            _livEnt11 = (LivingEntity) entity;
                            if (_livEnt11.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label334;
                            }
                        }

                        label342:
                        {
                            if (entity instanceof LivingEntity) {
                                _livEnt12 = (LivingEntity) entity;
                                if (_livEnt12.hasEffect((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    break label342;
                                }
                            }

                            if (!(entity instanceof LivingEntity)) {
                                break label341;
                            }

                            _livEnt13 = (LivingEntity) entity;
                            if (!_livEnt13.hasEffect((MobEffect) JujutsucraftModMobEffects.UNSTABLE.get())) {
                                break label341;
                            }
                        }

                        if (!noUseCursePower) {
                            break label334;
                        }
                    }
                } else if (!LogicStartProcedure.execute(entity)) {
                    break label334;
                }

                if (!(new Object() {
                    public boolean checkGamemode(Entity _ent) {
                        if (_ent instanceof ServerPlayer _serverPlayer) {
                            return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
                        } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                            return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.SPECTATOR;
                        } else {
                            return false;
                        }
                    }
                }).checkGamemode(entity)) {
                    CREATIVE = ((new Object() {
                        public boolean checkGamemode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                            } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                            } else {
                                return false;
                            }
                        }
                    })).checkGamemode(entity);
                    if (noUseCursePower) {
                        NUM1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - 0.0;
                    } else {
                        NUM1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - (item_use ? cost : ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
                    }

                    if (!(NUM1 >= 0.0) && !CREATIVE) {
                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                            }

                            return;
                        }

                        return;
                    } else {
                        double _setval2;
                        if (!CREATIVE) {
                            _setval2 = NUM1;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.PlayerCursePower = _setval2;
                                capability.syncPlayerVariables(entity);
                            });
                        }

                        if (item_use) {
                            T1 = (double) Math.round(Math.floor(skill / 100.0));
                            T2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                            S1 = (double) Math.round(Math.floor(skill % 100.0));
                        } else {
                            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 18
                                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade Semi 1 (Mammoth)")) {
                                    T1 = 1;
                                    S1 = 50;
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade Semi 1 (Slug)")) {
                                    T1 = 1;
                                    S1 = 59;
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade 1 (Blindness)")) {
                                    if (entity.isShiftKeyDown()) {
                                        T1 = 23;
                                        S1 = 5;
                                    } else if (!entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = Mth.nextInt(RandomSource.create(), 51, 52);
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Samurai")) {
                                    if (entity.isShiftKeyDown()) {
                                        T1 = 22;
                                        S1 = 4;
                                    } else if (!entity.isShiftKeyDown()) {
                                        T1 = 15;
                                        S1 = 16;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Tamamo-no-Mae Incarnate")) {
                                    if (entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = 55;
                                    } else if (!entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = 56;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Ganesha")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = 60;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade Semi 1 (Teruteru Bozu)")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 10;
                                        S1 = 5;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade 1 (Kuchisake-Onna)")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = 53;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Cursed Spirit Grade 1 (Forest)")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 1;
                                        S1 = 54;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Jogo")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 4;
                                        S1 = 5;
                                    } else {
                                        T1 = 4;
                                        S1 = 7;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Mahito")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 15;
                                        S1 = 5;
                                    } else {
                                        T1 = 15;
                                        S1 = 9;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Dagon")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 8;
                                        S1 = 9;
                                    } else {
                                        T1 = 8;
                                        S1 = 10;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains("Zenin Naoya")) {
                                    if (!entity.isShiftKeyDown()) {
                                        T1 = 19;
                                        S1 = 5;
                                    } else {
                                        T1 = 19;
                                        S1 = 10;
                                    }
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                        .equals(Component.translatable("jujutsu.technique.attack1").getString())) {
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerSelectCurseTechniqueName = (Component.translatable("jujutsu.technique.kaori1").getString());
                                        capability.syncPlayerVariables(entity);
                                    });
                                    T1 = 41;
                                    S1 = 10;
                                } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)
                                        .equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                                        capability.PlayerSelectCurseTechniqueName = ("Anti-Gravity Push");
                                        capability.syncPlayerVariables(entity);
                                    });
                                    T1 = 1;
                                    S1 = 60;
                                }

                                STR1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                                T2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                            } else {
                                if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("jujutsu.technique.kashimo_domain").getString())) {
                                    T1 = 7;
                                    S1 = 20;
                                } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6
                                        && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {

                                    if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("entity.jujutsucraft.divine_dog_white").getString()) || ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("entity.jujutsucraft.divine_dog_black").getString())) {
                                        AttackBeastProcedure.execute(world, x, y, z, entity);
                                    } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("entity.jujutsucraft.nue").getString())) {
                                        T1 = 7;
                                        S1 = 5;
                                    } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("entity.jujutsucraft.piercing_ox").getString())) {
                                        AttackPiecingOxProcedure.execute(world, x, y, z, entity);
                                    } else if (((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName).contains(Component.translatable("entity.jujutsucraft.max_elephant").getString())) {
                                        T1 = 8;
                                        S1 = 5;
                                    }
                                } else {
                                    STR1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                                    T1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                                    T2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                                    S1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
                                }
                            }
                        }

                        entity.getPersistentData().putDouble("skill", item_use ? skill : T1 * 100.0 + S1);
                        ResetCounterProcedure.execute(entity);
                        LivingEntity _entity;
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (!_entity.level().isClientSide()) {
                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, 0, false, false));
                            }
                        }

                        if ((T1 != 2.0 || S1 != 5.0) && (T1 != 9.0 || S1 != 10.0) && (T1 != 18.0 || !(S1 >= 10.0) || !(S1 < 15.0)) && !CREATIVE) {
                            if (S1 == 20.0) {
                                Tick = 20.0;
                            } else {
                                Tick = Math.max((item_use ? cost : ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCostOrgin) / 2.0, 20.0);
                                if (STR1.equals(Component.translatable("jujutsu.technique.attack1").getString())) {
                                    Tick = 5.0;
                                } else if (STR1.equals(Component.translatable("jujutsu.technique.attack2").getString())) {
                                    Tick = 15.0;
                                } else if (STR1.equals(Component.translatable("jujutsu.technique.attack3").getString())) {
                                    Tick = 20.0;
                                } else {
                                    if (STR1.equals(Component.translatable("jujutsu.technique.attack4").getString())) {
                                        Tick = 100.0;
                                    } else if (STR1.equals(Component.translatable("jujutsu.technique.attack5").getString())) {
                                        Tick = 200.0;
                                    }

                                    if (!STR1.equals(Component.translatable("jujutsu.technique.attack6").getString()) && !STR1.equals(Component.translatable("jujutsu.technique.flying_kick").getString())) {
                                        if (STR1.equals(Component.translatable("jujutsu.technique.attack7").getString())) {
                                            Tick = 80.0;
                                        }
                                    } else {
                                        Tick = 60.0;
                                    }
                                }

                                if (T1 == 5.0 && S1 == 5.0) {
                                    Tick = 20.0;
                                }

                                if (T1 == 6.0 && S1 >= 5.0 && S1 < 20.0 && !STR1.equals(Component.translatable("jujutsu.technique.choso3").getString())) {
                                    Tick = 5.0;
                                }

                                if (T1 == 7.0 && (S1 == 5.0 || S1 == 10.0)) {
                                    Tick = 20.0;
                                }

                                if ((T1 == 19.0 || T2 == 19.0) && LogicStartPassiveProcedure.execute(entity) && S1 < 5.0) {
                                    Tick = 5.0;
                                }

                                if (T1 == 39.0 && S1 >= 8.0) {
                                    Tick = 20.0;
                                }

                                if (T1 == 40.0 && (S1 == 6.0 || S1 == 7.0)) {
                                    Tick = 20.0;
                                }
                            }
                        } else {
                            Tick = 1.0;
                        }

                        double _setval3 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber + (double) Math.round(Tick);
                        double final_setval1 = _setval3;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerTechniqueUsedNumber = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        Advancement _adv;
                        AdvancementProgress _ap;
                        Iterator var36;
                        String criteria;
                        ServerPlayer _player2;
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber > (double) ((T1 != 27.0 && T2 != 27.0 ? 4000 : 2000) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                            _player2 = (ServerPlayer) entity;
                            _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_simple_domain"));
                            _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                var36 = _ap.getRemainingCriteria().iterator();

                                while (var36.hasNext()) {
                                    criteria = (String) var36.next();
                                    _player2.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }

                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerTechniqueUsedNumber > (double) ((T1 != 27.0 && T2 != 27.0 ? 12000 : 100) * (1 + world.getLevelData().getGameRules().getInt(JujutsucraftModGameRules.JUJUTSUUPGRADEDIFFICULTY) / 10)) && entity instanceof ServerPlayer) {
                            _player2 = (ServerPlayer) entity;
                            _adv = _player2.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:mastery_domain_expansion"));
                            _ap = _player2.getAdvancements().getOrStartProgress(_adv);
                            if (!_ap.isDone()) {
                                var36 = _ap.getRemainingCriteria().iterator();

                                while (var36.hasNext()) {
                                    criteria = (String) var36.next();
                                    _player2.getAdvancements().award(_adv, criteria);
                                }
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            var10000 = _entity.getMainHandItem();
                        } else {
                            var10000 = ItemStack.EMPTY;
                        }

                        LivingEntity _livEnt;
                        if (var10000.getItem() == JujutsucraftModItems.LOUDSPEAKER.get()) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var10000 = _livEnt.getMainHandItem();
                            } else {
                                var10000 = ItemStack.EMPTY;
                            }

                            var10000.getOrCreateTag().putBoolean("Used", true);
                        }

                        if (!noUseCursePower) {
                            if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PhysicalAttack && !item_use) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    var10000 = _entity.getMainHandItem();
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                if (var10000.getOrCreateTag().getDouble("Power") > 0.0) {
                                    ItemStack var10003;
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        var10003 = _livEnt.getMainHandItem();
                                    } else {
                                        var10003 = ItemStack.EMPTY;
                                    }

                                    Tick += 10.0 * (1.0 + var10003.getOrCreateTag().getDouble("Power") * 2.0);
                                }

                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {

                                        if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_COOLDOWN)) == false) {
                                            if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower) / 3, 0, false, false));
                                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1 && entity.getPersistentData().getBoolean("CurseUser") == false
                                                    && entity.getPersistentData().getBoolean("CursedSpirit") == true) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower) / 2, 0, false, false));
                                            } else {
                                                _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), 0, false, false));
                                            }
                                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower > 1) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.WEAKNESS, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), (int) Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), false, false));
                                            }

                                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3 > 1) {
                                                _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.POISON, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3) * 5, (int) Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3), false, false));
                                                _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.WEAKNESS, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3) * 5, 0, false, false));
                                            }
                                        }

                                    }


                                    return;
                                }
                            } else if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                if (!_entity.level().isClientSide()) {

                                    if ((world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_NO_COOLDOWN)) == false) {
                                        if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Profession).equals("Sage")) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower) / 3, 0, false, false));
                                        } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Timer1 == 1 && entity.getPersistentData().getBoolean("CurseUser") == false
                                                && entity.getPersistentData().getBoolean("CursedSpirit") == true) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower) / 2, 0, false, false));
                                        } else {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), 0, false, false));
                                        }

                                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower > 1) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.WEAKNESS, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), (int) Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).VowPower), false, false));
                                            _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.WEAKNESS, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3) * 5, 0, false, false));
                                        }

                                        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3 > 1) {
                                            _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.POISON, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3) * 5, (int) Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3), false, false));
                                            _entity.addEffect(new MobEffectInstance((MobEffect) MobEffects.WEAKNESS, (int) Math.round(Tick * (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Vow3) * 5, 0, false, false));
                                        }
                                    }
                                    if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true) {
                                        if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 3) {
                                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true
                                                    && ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Inumaki")) {
                                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100,
                                                        (int) ((entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt2.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) * 1.1), false, false));
                                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))), 70);
                                            } else {
                                                _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40,
                                                        (int) ((entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.DAMAGE_BOOST) ? _livEnt2.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() : 0) * 1.05), false, false));
                                                entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_combat")))), 100);
                                            }
                                        }
                                    }

                                }


                                return;
                            }

                            return;
                        } else {
                            entity.getPersistentData().putDouble("COOLDOWN_TICKS", Math.max(entity.getPersistentData().getDouble("COOLDOWN_TICKS"), (double) Math.round(Tick)));
                            return;
                        }
                    }
                }
            }

            if (entity instanceof Player) {
                _player = (Player) entity;
                if (!_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), true);
                }
            }

        }
    }
}

