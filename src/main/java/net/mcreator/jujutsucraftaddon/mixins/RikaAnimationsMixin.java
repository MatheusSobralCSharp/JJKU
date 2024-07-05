package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.client.renderer.DivineDogTotalityRenderer;
import net.mcreator.jujutsucraft.entity.DivineDogTotalityEntity;
import net.mcreator.jujutsucraft.entity.Rika2Entity;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import net.mcreator.jujutsucraft.init.JujutsucraftModEntities;
import net.mcreator.jujutsucraft.procedures.AIRikaProcedure;
import net.mcreator.jujutsucraft.procedures.DieRikaProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAIProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackTargetProcedure;
import net.mcreator.jujutsucraft.procedures.LogicAttackTargetStartProcedure;
import net.mcreator.jujutsucraft.procedures.SetTagCursedSpritProcedure;
import net.mcreator.jujutsucraft.procedures.SizeByNBTProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationController.State;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;


@Mixin(value = DivineDogTotalityRenderer.class, remap = false)
public abstract class RikaAnimationsMixin {
    public RikaAnimationsMixin() {
    }

    @Inject(method = "getTextureLocation*", at = @At("RETURN"), cancellable = true)
    private void modifyTextureLocation(DivineDogTotalityEntity entity, CallbackInfoReturnable<ResourceLocation> cir) {
            if (entity.hasEffect(JujutsucraftaddonModMobEffects.SUKUNA.get())) {
                cir.setReturnValue(new ResourceLocation("jujutsucraftaddon:textures/entities/divinedogtotality.png"));
            }
    }
}