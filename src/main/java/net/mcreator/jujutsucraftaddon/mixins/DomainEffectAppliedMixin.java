package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.DomainExpansionEffectStartedappliedProcedure;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;


@Mixin(value = DomainExpansionEffectStartedappliedProcedure.class)
public abstract class DomainEffectAppliedMixin {
    public DomainEffectAppliedMixin() {
    }

    @Inject(
            method = {"execute"},
            at = {@At("HEAD")},
            remap = false
    )
    private static void execute(Entity entity, CallbackInfo ci) {
        if (entity == null) {
            return;
        }

        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessCount <= 199) {
            {
                double _setval = (entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).BarrierlessCount + 1;
                entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.BarrierlessCount = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        } else if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                && _plr0.getAdvancements().getOrStartProgress(Objects.requireNonNull(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected")))).isDone())) {
            if (entity instanceof ServerPlayer _player) {
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:barrierless_domain_perfected"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(Objects.requireNonNull(_adv));
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria())
                        _player.getAdvancements().award(_adv, criteria);
                }
            }
        }
        if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OstVariable == 0) {
            if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 20) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.HOUR_CINDERELLA.get(), 100, 1, false, false));
            }
        }

    }
}