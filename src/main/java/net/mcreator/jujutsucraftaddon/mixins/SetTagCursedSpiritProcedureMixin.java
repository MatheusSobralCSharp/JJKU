package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.procedures.SetTagCursedSpritProcedure;
import net.mcreator.jujutsucraft.procedures.SetTagProcedure;
import net.mcreator.jujutsucraftaddon.entity.PartialRikaEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(value = SetTagCursedSpritProcedure.class, priority = -10000)
public class SetTagCursedSpiritProcedureMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            double NUM1 = 0.0;
            double size = 0.0;
            SetTagProcedure.execute(world, entity);
            entity.getPersistentData().putBoolean("CursedSpirit", true);
            if (entity instanceof CursedSpiritGrade16Entity) {
                Entity _ent = entity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel)_ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {Silent:1b}");
                }
            }

            if (entity instanceof CursedSpiritGrade21Entity || entity instanceof CursedSpiritGrade22Entity || entity instanceof CursedSpiritGrade23Entity || entity instanceof CursedSpiritGrade25Entity || entity instanceof CursedSpiritGrade26Entity || entity instanceof CursedSpiritGrade27Entity || entity instanceof CursedSpiritGrade28Entity || entity instanceof CursedSpiritGrade13Entity) {
                entity.setMaxUpStep(entity.getStepHeight() * 2.0F);
            }

            if (entity instanceof RikaEntity || entity instanceof Rika2Entity || entity instanceof PartialRikaEntity) {
                ((LivingEntity)entity).getAttribute((Attribute) JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.5);
            }

        }
    }
}
