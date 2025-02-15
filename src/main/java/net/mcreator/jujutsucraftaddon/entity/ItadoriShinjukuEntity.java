package net.mcreator.jujutsucraftaddon.entity;

import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.*;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.procedures.AIBaseProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ItadoriShinjukuEffectsProcedure;
import net.mcreator.jujutsucraftaddon.procedures.ItadoriShinjukuEntityIsHurtProcedure;
import net.mcreator.jujutsucraftaddon.procedures.SorcererSpawnedProcedure;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ItadoriShinjukuEntity extends Monster {
    public ItadoriShinjukuEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(JujutsucraftaddonModEntities.ITADORI_SHINJUKU.get(), world);
    }

    public ItadoriShinjukuEntity(EntityType<ItadoriShinjukuEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0.6f);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
            protected double getAttackReachSqr(LivingEntity entity) {
                return (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth());
            }

            public boolean canUse() {
                double x = ItadoriShinjukuEntity.this.getX();
                double y = ItadoriShinjukuEntity.this.getY();
                double z = ItadoriShinjukuEntity.this.getZ();
                Entity entity = ItadoriShinjukuEntity.this;
                Level world = ItadoriShinjukuEntity.this.level();
                return super.canUse() && LogicAttackTargetProcedure.execute(entity);
            }
        });
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this, new Class[0]));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Monster.class, false, false) {
            public boolean canUse() {
                double x = ItadoriShinjukuEntity.this.getX();
                double y = ItadoriShinjukuEntity.this.getY();
                double z = ItadoriShinjukuEntity.this.getZ();
                Entity entity = ItadoriShinjukuEntity.this;
                Level world = ItadoriShinjukuEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = ItadoriShinjukuEntity.this.getX();
                double y = ItadoriShinjukuEntity.this.getY();
                double z = ItadoriShinjukuEntity.this.getZ();
                Entity entity = ItadoriShinjukuEntity.this;
                Level world = ItadoriShinjukuEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Player.class, false, false) {
            public boolean canUse() {
                double x = ItadoriShinjukuEntity.this.getX();
                double y = ItadoriShinjukuEntity.this.getY();
                double z = ItadoriShinjukuEntity.this.getZ();
                Entity entity = ItadoriShinjukuEntity.this;
                Level world = ItadoriShinjukuEntity.this.level();
                return super.canUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }

            public boolean canContinueToUse() {
                double x = ItadoriShinjukuEntity.this.getX();
                double y = ItadoriShinjukuEntity.this.getY();
                double z = ItadoriShinjukuEntity.this.getZ();
                Entity entity = ItadoriShinjukuEntity.this;
                Level world = ItadoriShinjukuEntity.this.level();
                return super.canContinueToUse() && LogicAttackTargetStartProcedure.execute(world, entity);
            }
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new FloatGoal(this));
        this.goalSelector.addGoal(8, new MoveBackToVillageGoal(this, 0.6, false));
        this.goalSelector.addGoal(9, new OpenDoorGoal(this, true));
        this.goalSelector.addGoal(10, new OpenDoorGoal(this, false));
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public double getMyRidingOffset() {
        return -0.35D;
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        double x = this.getX();
        double y = this.getY();
        double z = this.getZ();
        Level world = this.level();
        Entity entity = this;
        Entity sourceentity = damagesource.getEntity();
        Entity immediatesourceentity = damagesource.getDirectEntity();

        ItadoriShinjukuEntityIsHurtProcedure.execute(entity, sourceentity);
        return super.hurt(damagesource, amount);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
        SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
        SetTagJujutsuSorcererProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
        return retval;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.hasEffect(JujutsucraftModMobEffects.ZONE.get()) && (((LivingEntity) this).getHealth() <= ((LivingEntity) this).getMaxHealth() / 2)) {
            AISukunaProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
            if (this.getPersistentData().getDouble("cnt_x") != 0) {
                if (Math.random() < (1) / ((float) 10)) {
                    AIBaseProcedure.execute(this.level(), this);
                }
            }
        } else {
            AIItadoriYujiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
            if (this.getPersistentData().getDouble("cnt_x") != 0) {
                if (Math.random() < (1) / ((float) 10)) {
                    AIBaseProcedure.execute(this.level(), this);
                }
            }
        }
        ItadoriShinjukuEffectsProcedure.execute(this);
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 900);
        builder = builder.add(Attributes.ARMOR, 30);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
        builder = builder.add(Attributes.FOLLOW_RANGE, 256);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 2);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 8);
        return builder;
    }

}
