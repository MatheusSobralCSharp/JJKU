package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkDirection;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.Connection;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModParticleTypes;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

import java.util.List;
import java.util.Iterator;
import java.util.Comparator;

import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.IAnimation;

public class DashOnEffectActiveTickProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        double particleRadius = 0;
        double particleAmount = 0;
        if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get()))) {
            if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 30, 30, 30), e -> true).isEmpty() && entity.onGround()) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1, 1, false, false));
                entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + entity.getLookAngle().x * 5), (entity.getDeltaMovement().y() + 0.25 + entity.getLookAngle().y * 0.125), (entity.getDeltaMovement().z() + entity.getLookAngle().z * 5)));
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 254, false, false));
                if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 7) {
                    for (int index0 = 0; index0 < 20; index0++) {
                        world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.DASH_1.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 4), (y + 0 + 0 * 4),
                                (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 4), 0, 0, 0);
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                } else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 7) {
                    for (int index1 = 0; index1 < 20; index1++) {
                        world.addParticle((SimpleParticleType) (JujutsucraftaddonModParticleTypes.THUNDER_BLUE.get()), (x + 0 + Mth.nextDouble(RandomSource.create(), -1, 1) * 4), (y + 0 + 0 * 4),
                                (z + 0 + Mth.nextDouble(RandomSource.create(), -0.1, 0.1) * 4), 0, 0, 0);
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1, false);
                        }
                    }
                }
                if (world.isClientSide()) {
                    if (entity instanceof AbstractClientPlayer player) {
                        var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("jujutsucraftaddon", "player_animation"));
                        if (animation != null && !animation.isActive()) {
                            animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("jujutsucraftaddon", "dash"))));
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
                                    JujutsucraftaddonMod.PACKET_HANDLER.sendTo(new SetupAnimationsProcedure.JujutsucraftaddonModAnimationMessage(Component.literal("dash"), entity.getId(), false), connection, NetworkDirection.PLAY_TO_CLIENT);
                            }
                        }
                    }
                }
                if (world instanceof Level _level) {
                    if (!_level.isClientSide()) {
                        _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1);
                    } else {
                        _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1, false);
                    }
                }
            } else if (!entity.onGround()) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (entityiterator instanceof LivingEntity && entityiterator instanceof LivingEntity _livEnt26 && _livEnt26.hasEffect(MobEffects.LEVITATION) && entityiterator.isNoGravity()
                                && (!(entityiterator instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(JujutsucraftaddonModMobEffects.DASH.get()))
                                || !(entityiterator instanceof LivingEntity _livEnt29 && _livEnt29.hasEffect(JujutsucraftaddonModMobEffects.DASH_COOLDOWN.get())))) {
                            {
                                Entity _ent = entity;
                                _ent.teleportTo((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ() - 1));
                                if (_ent instanceof ServerPlayer _serverPlayer)
                                    _serverPlayer.connection.teleport((entityiterator.getX()), (entityiterator.getY() + 1), (entityiterator.getZ() - 1), _ent.getYRot(), _ent.getXRot());
                            }
                            if (world instanceof Level _level) {
                                if (!_level.isClientSide()) {
                                    _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1);
                                } else {
                                    _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:dash")), SoundSource.NEUTRAL, 1, 1, false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
