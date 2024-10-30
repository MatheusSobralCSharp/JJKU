package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.PlayerSetProfessionProcedure;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Objects;

@Mixin(value = PlayerSetProfessionProcedure.class, remap = false)
public abstract class WhenPlayerRespawnMixin {
    public WhenPlayerRespawnMixin() {
    }

     /**
      * @author Satsuhi
      * @reason Changes
      */
     @Overwrite
     public static void execute(Entity entity) {
         if (entity != null) {
             entity.getPersistentData().putBoolean("JujutsuSorcerer", false);
             entity.getPersistentData().putBoolean("CurseUser", false);
             entity.getPersistentData().putBoolean("CursedSpirit", false);
             if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == -2.0) {
                 entity.getPersistentData().putBoolean("CursedSpirit", true);
                 entity.getPersistentData().putBoolean("CurseUser", true);
             } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == -1.0) {
                 entity.getPersistentData().putDouble("CursedSpirit", 1.0);
             } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == 1.0) {
                 entity.getPersistentData().putBoolean("CurseUser", true);
             } else {
                 entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
             }

             if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 0.0) {
                 entity.getPersistentData().putBoolean("NonSorcerer", true);
             } else {
                 entity.getPersistentData().putBoolean("NonSorcerer", false);
             }

             Objects.requireNonNull(((LivingEntity) entity).getAttribute((Attribute) ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:profession")))).setBaseValue(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
         }
     }

}