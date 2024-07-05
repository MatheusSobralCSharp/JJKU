package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.client.screens.OverlayDefaultOverlay;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import net.mcreator.jujutsucraft.procedures.OverlayHaveTechniqueProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = JackpotEffectStartedappliedProcedure.class, remap = false)
public abstract class UIJujutsuCraftMixin {
    public UIJujutsuCraftMixin() {

    }

    /**
     * @author Sat
     * @reason ERROR
     */
    @Overwrite
        public static void execute(LevelAccessor world, Entity entity) {
            if (entity != null) {
                double var10000;
                double level;
                double tick;
                LivingEntity _entity;
                label34: {
                    level = 0.0;
                    tick = 0.0;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect) JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier();
                            break label34;
                        }
                    }

                    var10000 = 0.0;
                }

                label29: {
                    level = var10000;
                    if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        if (_entity.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                            var10000 = (double)_entity.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getDuration();
                            break label29;
                        }
                    }

                    var10000 = 0.0;
                }

                tick = var10000;
                if (entity instanceof LivingEntity) {
                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), (int)tick, (int)(4.0 + level), false, false));
                    }

                    _entity = (LivingEntity)entity;
                    if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect) JujutsucraftaddonModMobEffects.JACKPOT.get(), 2, 4, false, false));
                    }
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 40, (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.5);
                }

                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel)world;
                    _level.sendParticles((SimpleParticleType) JujutsucraftModParticleTypes.PARTICLE_FIRE_SPARK.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 40, (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.5);
                }

            }
        }
    }