package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyReverseCursedTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = KeyReverseCursedTechniqueOnKeyPressedProcedure.class, priority = 3000)
public abstract class ReverseKeyMixin {
    public ReverseKeyMixin() {
    }

    /**
     * @author Satushi
     * @reason Giving Reverse Cursed Technique Changes
     */


    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entity, CallbackInfo ci) {
        if (entity != null) {
            double level = 0.0;
            boolean strength = false;
            boolean Player = false;
            Player = entity instanceof Player;
            if (Player && entity instanceof LivingEntity) {
                LivingEntity _livEnt1 = (LivingEntity) entity;
                if (_livEnt1.hasEffect((MobEffect) JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                    return;
                }
            }

            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BurnOutRCT) {
                entity.getPersistentData().putBoolean("PRESS_BURNOUT", true);
            }

            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == -1) {
                if (!entity.getPersistentData().getBoolean("HR")) {
                    entity.getPersistentData().putBoolean("HR", true);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Enabled HR Vision"), false);
                } else if (entity.getPersistentData().getBoolean("HR")) {
                    entity.getPersistentData().putBoolean("HR", false);
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Disabled HR Vision"), false);
                }
            }


            Player _player;
            label142:
            {
                if (entity instanceof LivingEntity) {
                    LivingEntity _livEnt2 = (LivingEntity) entity;
                    if (_livEnt2.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label142;
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    LivingEntity _livEnt;
                    LivingEntity _entity;
                    if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                        level = 1.0;
                    } else if (!Player) {
                        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique"))) && entity.getPersistentData().getDouble("skill") == 0.0) {
                            float var10000;
                            if (entity instanceof LivingEntity) {
                                _entity = (LivingEntity) entity;
                                var10000 = _entity.getMaxHealth();
                            } else {
                                var10000 = -1.0F;
                            }

                            level = (double) (var10000 > 800.0F ? 1 : 0);
                        } else {
                            level = -1.0;
                        }
                    } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 150.0 && ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 10.0) {
                        label156:
                        {
                            label128:
                            {
                                label157:
                                {
                                    if (entity instanceof ServerPlayer) {
                                        ServerPlayer _plr5 = (ServerPlayer) entity;
                                        if (_plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"))).isDone()) {
                                            break label157;
                                        }
                                    }

                                    if (!(entity instanceof LivingEntity)) {
                                        break label128;
                                    }

                                    _livEnt = (LivingEntity) entity;
                                    if (!_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                        break label128;
                                    }
                                }

                                level = 1.0;
                                break label156;
                            }

                            if (entity instanceof ServerPlayer) {
                                ServerPlayer _plr7 = (ServerPlayer) entity;
                                if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).isDone()) {
                                    level = 0.0;
                                    break label156;
                                }
                            }

                            level = -1.0;
                        }
                    } else {
                        level = -1.0;
                    }

                    Entity _ent;
                    if (!(level >= 0.0)) {
                        if (entity instanceof Player) {
                            _player = (Player) entity;
                            if (!_player.level().isClientSide()) {
                                _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.not_mastered").getString()), false);
                            }
                        }
                    } else {
                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get())) {
                                double var13;
                                int var10001;
                                label102:
                                {
                                    var13 = level + 1.0;
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get())) {
                                            var10001 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                            break label102;
                                        }
                                    }

                                    var10001 = 0;
                                }

                                level = var13 + (double) var10001;
                            }
                        }

                        if (entity instanceof LivingEntity) {
                            _entity = (LivingEntity) entity;
                            _entity.removeEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get());
                        }

                        entity.getPersistentData().putBoolean("PRESS_M", true);
                        if (entity.getPersistentData().getBoolean("CursedSpirit") || (entity.getPersistentData().getDouble("CursedSpirit") == 1)) {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).rctspirit) {
                                if (entity instanceof LivingEntity) {
                                    _entity = (LivingEntity) entity;
                                    if (!_entity.level().isClientSide()) {
                                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), Integer.MAX_VALUE, (int) (Math.round(level) * -1L), true, true));
                                    }
                                }
                            }
                        } else {
                            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTLimitLevel > 0
                                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount > 0) {
                                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount > 5000) {
                                    {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(
                                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                                            _ent.level().getServer(), _ent),
                                                    ("effect give @s jujutsucraft:reverse_cursed_technique infinite "
                                                            + Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount / 5000) + " true"));
                                        }
                                    }
                                } else {
                                    {
                                        _ent = entity;
                                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                                                    _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("effect give @s jujutsucraft:reverse_cursed_technique infinite " + 1 + " true"));
                                        }
                                    }
                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTLimitLevel > 0
                                    && (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount / 5000 > (entity
                                    .getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTLimitLevel) {
                                {
                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(
                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                                        _ent.level().getServer(), _ent),
                                                ("effect give @s jujutsucraft:reverse_cursed_technique infinite "
                                                        + Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTLimitLevel) + " true"));
                                    }
                                }
                            } else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTLimitLevel == 0) {
                                {
                                    _ent = entity;
                                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                        _ent.getServer().getCommands().performPrefixedCommand(
                                                new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                                        _ent.level().getServer(), _ent),
                                                ("effect give @s jujutsucraft:reverse_cursed_technique infinite "
                                                        + Math.round((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTCount / 5000) + " true"));
                                    }
                                }
                            }
                        }
                    }

                    _ent = entity;
                    if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                        _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound ui.button.click master @s");
                    }

                    return;
                }
            }

            if (entity instanceof Player) {
                _player = (Player) entity;
                if (!_player.level().isClientSide()) {
                    _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
                }
            }

        }
        ci.cancel();
    }
}
