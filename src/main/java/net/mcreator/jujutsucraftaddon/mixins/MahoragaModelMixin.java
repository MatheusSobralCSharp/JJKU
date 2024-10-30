package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.mcreator.jujutsucraft.procedures.PlayerTickEvent2Procedure;
import net.mcreator.jujutsucraft.procedures.StartGuardProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.*;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;


@Mixin(value = PlayerTickEvent2Procedure.class, remap = false)
public abstract class MahoragaModelMixin {
    public MahoragaModelMixin() {
    }


    /**
     * @author Satushi
     * @reason Testing Changes
     */
    @Overwrite
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
        }

    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            boolean changeTechnique = false;
            double PlayerCT2 = 0.0;
            double PlayerCT1 = 0.0;
            String old_name = "";
            boolean _setval;
            if (entity.isAlive()) {
                PlayerCT1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                PlayerCT2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                if (entity.isShiftKeyDown()) {
                    StartGuardProcedure.execute(entity);
                    if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity) entity;
                        _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
                    }

                    if (!((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                        _setval = true;
                        boolean final_setval2 = _setval;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                            capability.flag_shift = final_setval2;
                            capability.syncPlayerVariables(entity);
                        });
                        changeTechnique = true;
                    }
                } else if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).flag_shift) {
                    _setval = false;
                    boolean final_setval3 = _setval;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.flag_shift = final_setval3;
                        capability.syncPlayerVariables(entity);
                    });
                    changeTechnique = true;
                }

                if (changeTechnique && PlayerCT1 == 6.0) {
                    old_name = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                    _setval = true;
                    boolean final_setval = _setval;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.noChangeTechnique = final_setval;
                        capability.syncPlayerVariables(entity);
                    });
                    KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                    if (!old_name.equals(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName)) {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), Objects.requireNonNull(_ent.level().getServer()), _ent), "playsound ui.button.click master @s");
                        }
                    }
                }

                if ((Objects.requireNonNull(entity).getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).water == 1) {
                    BlockPos belowPos = entity.blockPosition().below();
                    FluidState fluidStateBelow = entity.level().getFluidState(belowPos);
                    boolean isJustAboveWater = ((world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))).getBlock() instanceof LiquidBlock);
                    if (isJustAboveWater && !entity.isInWater()) {
                        if (entity.getDeltaMovement().y() <= 0) {
                            entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.0, 0.0, 1.0));
                            entity.setOnGround(true);
                            entity.setPos(entity.getX(), belowPos.getY() + 1.0, entity.getZ());

                        }
                    }
                }


                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BGM) {
                    if (entity.level().getGameTime() % 7200 == 0) {
                        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.MUSIC.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.MUSIC.get(), 60, 1, false, false));
                        }
                    }
                }

                if (entity.level().getGameTime() % 12000 == 0) {
                    if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6) {
                        if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKUR_REGENERATE_SHIKIGAMI)) {
                            if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.REGENERATE_SHIKIGAMI.get()))) {
                                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.REGENERATE_SHIKIGAMI.get(), 60, 1, false, false));
                            }
                        }
                    }
                }


                if (entity.level().getGameTime() % 7200 == 0) {
                    if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_SUKUNA_POSSESSION_ENABLED)) {
                        if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
                                && ((ServerPlayer) entity).getAdvancements().getOrStartProgress(Objects.requireNonNull(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_1")))).isDone()) {
                            if (!(entity instanceof ServerPlayer _plr1 && _plr1.level() instanceof ServerLevel
                                    && _plr1.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:enchained")))).isDone())) {
                                if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA_VC.get()))) {
                                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.SUKUNA_VC.get(), 60, 1, false, false));
                                }
                            }
                        }
                    }
                }

                if (entity instanceof LivingEntity _livEnt49 && _livEnt49.hasEffect(JujutsucraftaddonModMobEffects.ANIMATION.get())) {
                    ClickAnimation2Procedure.execute(world, entity);
                }


                if (entity.getPersistentData().getBoolean("PRESS_BURNOUT")) {
                    CounterBurnoutProcedure.execute(entity);
                }


                if (entity.getPersistentData().getBoolean("Meditation")) {
                    MeditationPassiveProcedure.execute(world, entity);
                }

                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).RCTMasteryOn) {
                    AutoRCTNewProcedure.execute(entity);
                }

                if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain) {
                    ExtensionTickProcedure.execute(world, x, y, z, entity);
                }

                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_flag_power) {
                    _setval = false;
                    boolean final_setval1 = _setval;
                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.p_flag_power = final_setval1;
                        capability.syncPlayerVariables(entity);
                    });
                    entity.setDeltaMovement(new Vec3(((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_x_power, ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_y_power, ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).p_z_power));
                }

            }

        }
    }

}