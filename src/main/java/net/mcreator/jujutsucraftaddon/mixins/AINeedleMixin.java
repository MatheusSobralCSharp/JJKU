package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.procedures.AINeedleProcedure;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = AINeedleProcedure.class)
public abstract class AINeedleMixin {
    public AINeedleMixin() {
    }

}
