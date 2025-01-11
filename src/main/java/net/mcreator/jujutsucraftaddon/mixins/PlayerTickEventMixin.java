package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayerTickEventProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerTickSecondTechniqueProcedure;
import net.mcreator.jujutsucraft.procedures.WhenPlayerActiveTickInfinityProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = PlayerTickEventProcedure.class, priority = 12000)
public abstract class PlayerTickEventMixin {
    public PlayerTickEventMixin() {
    }

    /**
     * @author Satushi
     * @reason Change Tick Fix
     */
    @Inject(at = @At("HEAD"), method = "execute(Lnet/minecraftforge/eventbus/api/Event;Lnet/minecraft/world/level/LevelAccessor;DDDLnet/minecraft/world/entity/Entity;)V", remap = false, cancellable = true)
    private static void execute(Event event, LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (entity != null) {
            double TECHNIQUE = 0.0;
            double CursePowerChange = 0.0;
            ItemStack var100001;
            ResourceLocation entityTypeKey = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());

            assert entityTypeKey != null;
            if (entityTypeKey.toString().startsWith("jujutsucraft")) {
                return;
            }


            if (entity instanceof LivingEntity _livEnt10) {
                var100001 = _livEnt10.getItemBySlot(EquipmentSlot.HEAD);
            } else {
                var100001 = ItemStack.EMPTY;
            }

            if (entity instanceof LivingEntity livingEntity) {
                boolean hasMurasakiEffect = livingEntity.hasEffect((MobEffect) JujutsucraftaddonModMobEffects.MURASAKI_EFFECT.get());
                boolean hasWorldCutEffect = livingEntity.hasEffect((MobEffect) JujutsucraftaddonModMobEffects.WORLD_CUT.get());

                if (!hasMurasakiEffect && !hasWorldCutEffect) {
                    if (var100001.getOrCreateTag().getDouble("P_ANIME1") != 0.0) {
                        ResourceKey<DamageType> damageTypeKey = ResourceKey.create(
                                Registries.DAMAGE_TYPE,
                                new ResourceLocation("jujutsucraft:start_animation")
                        );

                        DamageSource damageSource = new DamageSource(
                                world.registryAccess()
                                        .registryOrThrow(Registries.DAMAGE_TYPE)
                                        .getHolderOrThrow(damageTypeKey)
                        );

                        entity.hurt(damageSource, 1.0F);
                    }
                }
            }


            if (entity.isAlive()) {
                TECHNIQUE = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                CursePowerChange = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange;
                if (TECHNIQUE != 0.0) {
                    LivingEntity _livEnt9;
                    LivingEntity _livEnt;
                    if (CursePowerChange < 0.0) {
                        if (entity instanceof LivingEntity) {
                            _livEnt9 = (LivingEntity) entity;
                            if (_livEnt9.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                CursePowerChange *= 0.5;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt9 = (LivingEntity) entity;
                            if (_livEnt9.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                                int var10002;
                                label101:
                                {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())) {
                                            var10002 = Objects.requireNonNull(_livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.SIX_EYES.get())).getAmplifier();
                                            break label101;
                                        }
                                    }

                                    var10002 = 0;
                                }

                                CursePowerChange *= Math.pow(0.1, (double) (var10002 + 1));
                            }
                        }
                    }

                    double _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).cnt_curse1 + 1.0;
                    double final_setval3 = _setval;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.cnt_curse1 = final_setval3;
                        capability.syncPlayerVariables(entity);
                    });
                    if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).cnt_curse1 >= 10.0) {
                        _setval = 0.0;
                        double final_setval4 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.cnt_curse1 = final_setval4;
                            capability.syncPlayerVariables(entity);
                        });
                        float var10000;
                        if (entity instanceof LivingEntity) {
                            _livEnt9 = (LivingEntity) entity;
                            var10000 = _livEnt9.getHealth();
                        } else {
                            var10000 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            var10001 = _livEnt.getMaxHealth();
                        } else {
                            var10001 = -1.0F;
                        }

                        if (var10000 >= var10001) {
                            double _setval3 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).cnt_curse1 + 5.0;
                            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                capability.cnt_curse1 = _setval3;
                                capability.syncPlayerVariables(entity);
                            });
                        }

                        if (entity instanceof LivingEntity) {
                            _livEnt9 = (LivingEntity) entity;
                            if (_livEnt9.hasEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get())) {
                                double _setval2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).cnt_curse1 + 2.0;
                                entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                                    capability.cnt_curse1 = _setval2;
                                    capability.syncPlayerVariables(entity);
                                });
                            }
                        }

                        CursePowerChange = CursePowerChange + 1.0 + (double) Math.round((2.0 + ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerLevel) / 1.1 * 0.2);
                    }

                    if (CursePowerChange != 0.0) {
                        _setval = (double) Math.round(Math.max(Math.min(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + CursePowerChange, ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX), 0.0));
                        double final_setval = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePower = final_setval;
                            capability.syncPlayerVariables(entity);
                        });
                        _setval = 0.0;
                        double final_setval1 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePowerChange = final_setval1;
                            capability.syncPlayerVariables(entity);
                        });
                        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower <= 0.0 && entity.getPersistentData().getBoolean("CursedSpirit")) {
                            if (entity instanceof LivingEntity) {
                                _livEnt9 = (LivingEntity) entity;
                                _livEnt9.removeEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get());
                            }

                            if (entity instanceof LivingEntity) {
                                _livEnt9 = (LivingEntity) entity;
                                _livEnt9.removeEffect((MobEffect) JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                            }

                            Entity _ent = entity;
                            if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "kill @s");
                            }
                        }
                    }

                    if (((new Object() {
                        public boolean checkGamemode(Entity _ent) {
                            if (_ent instanceof ServerPlayer _serverPlayer) {
                                return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                            } else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
                                return Objects.requireNonNull(Minecraft.getInstance().getConnection()).getPlayerInfo(_player.getGameProfile().getId()) != null && Objects.requireNonNull(Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId())).getGameMode() == GameType.CREATIVE;
                            } else {
                                return false;
                            }
                        }
                    })).checkGamemode(entity)) {
                        _setval = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerMAX;
                        double final_setval2 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.PlayerCursePower = final_setval2;
                            capability.syncPlayerVariables(entity);
                        });
                    }
                }

                if (entity instanceof ServerPlayer) {
                    ServerPlayer _plr15 = (ServerPlayer) entity;
                    if (_plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr15.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:advancement_insect")))).isDone()) {
                        int var23;
                        if (entity instanceof Player) {
                            Player _plr = (Player) entity;
                            var23 = _plr.getFoodData().getFoodLevel();
                        } else {
                            var23 = 0;
                        }

                        if (var23 < 20 && entity instanceof Player) {
                            Player _player = (Player) entity;
                            _player.getFoodData().setFoodLevel(20);
                        }
                    }
                }

                WhenPlayerActiveTickInfinityProcedure.execute(entity);

                PlayerTickSecondTechniqueProcedure.execute(world, x, y, z, entity);
                entity.getPersistentData().putDouble("NBT_CursePowerAmount", ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower);
            }


        }
        ci.cancel();
    }
}
