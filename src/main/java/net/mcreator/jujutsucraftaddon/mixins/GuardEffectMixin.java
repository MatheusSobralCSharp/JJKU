package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.Dagon2Entity;
import net.mcreator.jujutsucraft.entity.UroTakakoEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.procedures.CounterKeybindOnKeyPressedProcedure;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = GuardEffectStartedappliedProcedure.class)
public abstract class GuardEffectMixin {
    public GuardEffectMixin(){
    }

    /**
     * @author Satushi
     * @reason Adding Guard
     */
    @Inject(method = "execute", at = @At("HEAD"), remap = false)
    private static void execute(LevelAccessor world, Entity entity, CallbackInfo ci) {
        if (!(Objects.requireNonNull(ForgeRegistries.ENTITY_TYPES.getKey(entity.getType())).toString()).startsWith("jujutsucraft"))  {
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
