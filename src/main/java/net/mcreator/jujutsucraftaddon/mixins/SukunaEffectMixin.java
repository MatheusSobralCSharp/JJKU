package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.KeyChangeTechniqueOnKeyPressedProcedure;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KeyChangeTechniqueOnKeyPressedProcedure.class)
public abstract class SukunaEffectMixin {
    public SukunaEffectMixin() {
    }

    @Inject(method = "execute", at = @At("TAIL"), remap = false)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7.0) {
            if (entity.isShiftKeyDown()) {
                if (((JujutsucraftModVariables.PlayerVariables) entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == 15.0) {
                    String name = Component.translatable("jujutsu.technique.kashimo_domain").getString();
                    double cost = 200.0;
                    boolean _setval = false;

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PhysicalAttack = _setval;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PassiveTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechniqueCost = cost;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechnique = 20;
                        capability.syncPlayerVariables(entity);
                    });

                    entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction) null).ifPresent((capability) -> {
                        capability.PlayerSelectCurseTechniqueName = name;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        }
    }
}
