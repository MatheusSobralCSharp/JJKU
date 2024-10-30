package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.Dagon2Entity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.procedures.CounterKeybindOnKeyPressedProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;

@Mixin(value = GuardEffectStartedappliedProcedure.class, remap = false)
public abstract class GuardEffectMixin {
    public GuardEffectMixin() {
    }

    /**
     * @author Satushi
     * @reason Adding Guard
     */
    @Overwrite
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            boolean logic_a = false;
            boolean logic_b = false;
            boolean SUCCESS = false;
            double num1 = 0.0;
            double num2 = 0.0;
            double speed = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double num3 = 0.0;
            double x_power = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double dis = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            if (entity.isAlive()) {
                if (LogicStartPassiveProcedure.execute(entity)) {
                    label90:
                    {
                        if (entity instanceof LivingEntity) {
                            LivingEntity _livEnt1 = (LivingEntity) entity;
                            if (_livEnt1.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                break label90;
                            }
                        }

                        num1 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                        num2 = ((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                        CompoundTag var10000;
                        int var10003;
                        LivingEntity _livEnt;
                        if (entity instanceof LivingEntity) {
                            _livEnt = (LivingEntity) entity;
                            if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                label72:
                                {
                                    var10000 = entity.getPersistentData();
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity) entity;
                                        if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                            var10003 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                            break label72;
                                        }
                                    }

                                    var10003 = 0;
                                }
                            }
                        }

                        if (num1 == 8.0 || num2 == 8.0 || entity instanceof Dagon2Entity) {
                            label61:
                            {
                                var10000 = entity.getPersistentData();
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    if (_livEnt.hasEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get())) {
                                        var10003 = _livEnt.getEffect((MobEffect) JujutsucraftModMobEffects.GUARD.get()).getAmplifier();
                                        break label61;
                                    }
                                }

                                var10003 = 0;
                            }

                            var10000.putDouble("Damage", (double) (6 + var10003 * 3) * 0.25);
                            num1 = Math.toRadians(Math.random() * 360.0);
                            num2 = (double) entity.getBbWidth() + 1.5;

                            for (int index0 = 0; index0 < 72; ++index0) {
                                if (Math.random() < 0.5) {
                                    x_pos = entity.getX() + Math.sin(num1) * num2;
                                    y_pos = entity.getY() + (double) entity.getBbHeight() * 0.5;
                                    z_pos = entity.getZ() + Math.cos(num1) * num2;
                                    if (world instanceof ServerLevel) {
                                        ServerLevel _level = (ServerLevel) world;
                                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity) null)).withSuppressedOutput(), "particle jujutsucraft:particle_water_no_gravity ~ ~ ~ 0.1 0.1 0.1 0 1 force");
                                    }
                                }

                                num1 += Math.toRadians(Math.random() * 10.0);
                            }

                            entity.getPersistentData().putDouble("Range", ((double) entity.getBbWidth() + 1.5) * 2.0 + 2.0);
                            entity.getPersistentData().putDouble("knockback", 0.25);
                            entity.getPersistentData().putDouble("projectile_type", 1.0);
                            entity.getPersistentData().putBoolean("onlyRanged", true);
                            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double) entity.getBbHeight() * 0.5, entity.getZ(), entity);
                            entity.getPersistentData().putBoolean("onlyRanged", false);
                            entity.getPersistentData().putDouble("knockback", 0.25);
                            entity.getPersistentData().putDouble("effect", 1.0);
                            KnockbackProcedure.execute(world, entity.getX(), entity.getY() + (double) entity.getBbHeight() * 0.5, entity.getZ(), entity);
                            entity.getPersistentData().putDouble("knockback", 0.0);
                            entity.getPersistentData().putDouble("effect", 0.0);
                        }

                        if (num1 == 38.0 || num2 == 38.0 || entity instanceof UroTakakoEntity) {
                            UroCounterProcedure.execute(world, entity);
                        }
                    }
                }

                if (entity.getPersistentData().getDouble("skill") == 0.0) {
                    GuardSetDamageProcedure.execute(entity);
                }
            }

        }

        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft")) {
            if ((entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.GUARD.get())
                    ? Objects.requireNonNull(((LivingEntity) entity).getEffect(JujutsucraftModMobEffects.GUARD.get())).getAmplifier()
                    : 0) <= 0) {
                if (entity.getPersistentData().getDouble("cnt_counter") == 0.0) {
                    CounterKeybindOnKeyPressedProcedure.execute(world, entity);
                }

                entity.getPersistentData().putDouble("cnt_counter", (entity.getPersistentData().getDouble("cnt_counter") + 1));
            }
        }
    }
}
