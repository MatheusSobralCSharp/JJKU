package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.item.YuunItem;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class YuunRightclickedProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        double particleRadius = 0;
        double particleAmount = 0;
        {
            final Vec3 _center = new Vec3(
                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
                    (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof LivingEntity) {
                    if (!(entityiterator == entity)) {
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rushhr")), SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:rushhr")), SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                        if (world.isClientSide()) {
                            if (entity instanceof AbstractClientPlayer player) {
                                var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                                if (animation != null && !animation.isActive()) {
                                    animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "playful"))));
                                }
                            }
                        }
                        if (!world.isClientSide()) {
                            if (entity instanceof Player && world instanceof ServerLevel srvLvl_) {
                                List<Connection> connections = srvLvl_.getServer().getConnection().getConnections();
                                synchronized (connections) {
                                    Iterator<Connection> iterator = connections.iterator();
                                    while (iterator.hasNext()) {
                                        Connection connection = iterator.next();
                                        if (!connection.isConnecting() && connection.isConnected())
                                            JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("playful"), entity.getId(), false), connection,
                                                    NetworkDirection.PLAY_TO_CLIENT);
                                    }
                                }
                            }
                        }
                        if (itemstack.getItem() instanceof YuunItem)
                            itemstack.getOrCreateTag().putString("geckoAnim", "ab5");
                        if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.RCT_CUT.get(), 240, 1, false, false));
                        if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(JujutsucraftaddonModMobEffects.BERSERK.get()))) {
                            if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                                _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.BERSERK.get(), 240, 1, false, false));
                        }
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 60, 1, false, false));
                        entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("jujutsucraft:damage_curse")))), 60);
                        {
                            Entity _ent = entity;
                            _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()));
                            if (_ent instanceof ServerPlayer _serverPlayer)
                                _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ()), _ent.getYRot(), _ent.getXRot());
                        }
                        entity.setDeltaMovement(new Vec3((1 * Math.cos((entity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((entity.getYRot() + 90) * (Math.PI / 180)))));
                        entityiterator.setDeltaMovement(new Vec3((1 * Math.cos((entity.getYRot() + 90) * (Math.PI / 180))), 0, (1 * Math.sin((entity.getYRot() + 90) * (Math.PI / 180)))));
                        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120,
                                    (int) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) + 10), false, false));
                    }
                }
            }
        }
    }
}
