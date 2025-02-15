package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.EntityMalevolentShrineEntity;
import net.mcreator.jujutsucraft.entity.EntitySkullEntity;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.AIMalevolentShrineProcedure;
import net.mcreator.jujutsucraft.procedures.LogicOwnerExistProcedure;
import net.mcreator.jujutsucraftaddon.entity.MalevolentShrineEntity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;

@Mixin(value = AIMalevolentShrineProcedure.class, priority = -10000)
public abstract class AIMalevolentShrineMixin {

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(LevelAccessor world, double x, double y, double z, Entity entity, CallbackInfo ci) {
        ci.cancel();

        if (entity != null) {
            boolean flag = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double pitch = 0.0;
            double dis = 0.0;
            Entity entity_a = null;
            entity.setDeltaMovement(new Vec3(0.0, Math.min(entity.getDeltaMovement().y(), 0.0), 0.0));
            ServerLevel _level;
            if (entity instanceof EntityMalevolentShrineEntity || entity instanceof MalevolentShrineEntity) {
                if (!entity.getPersistentData().getBoolean("flag_start")) {
                    entity.getPersistentData().putBoolean("flag_start", true);
                    yaw = entity.getYRot();
                    pitch = entity.getXRot();
                    int index0 = 0;

                    while (true) {
                        if (index0 >= 18) {
                            entity.setYRot((float) yaw);
                            entity.setXRot((float) pitch);
                            entity.setYBodyRot(entity.getYRot());
                            entity.setYHeadRot(entity.getYRot());
                            entity.yRotO = entity.getYRot();
                            entity.xRotO = entity.getXRot();
                            if (entity instanceof LivingEntity _entity) {
                                _entity.yBodyRotO = _entity.getYRot();
                                _entity.yHeadRotO = _entity.getYRot();
                            }
                            break;
                        }

                        x_pos = entity.getX() + Math.cos(Math.toRadians(entity.getYRot() + 90.0F)) * ((double) entity.getBbWidth() - 2.5);
                        y_pos = entity.getY();
                        z_pos = entity.getZ() + Math.sin(Math.toRadians(entity.getYRot() + 90.0F)) * ((double) entity.getBbWidth() - 2.5);

                        for (int index1 = 0; index1 < 100 && !world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude(); ++index1) {
                            --y_pos;
                        }

                        if (world instanceof ServerLevel _level2) {
                            _level2.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level2, 4, "", Component.literal(""), _level2.getServer(), null)).withSuppressedOutput(), "summon jujutsucraft:entity_skull ~ ~ ~ {Invulnerable:1b,Rotation:[" + entity.getYRot() + "F,0F]}");
                        }

                        if (!world.getEntitiesOfClass(EntitySkullEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                            return true;
                        }).isEmpty()) {
                            entity_a = world.getEntitiesOfClass(EntitySkullEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 1.0, 1.0, 1.0), (e) -> {
                                return true;
                            }).stream().sorted(((new Object() {
                                Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                    return Comparator.comparingDouble((_entcnd) -> {
                                        return _entcnd.distanceToSqr(_x, _y, _z);
                                    });
                                }
                            })).compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse(null);
                            entity_a.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged_ranged"));
                            entity_a.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                        }

                        entity.setYRot(entity.getYRot() + 20.0F);
                        entity.setXRot(0.0F);
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity _entity) {
                            _entity.yBodyRotO = _entity.getYRot();
                            _entity.yHeadRotO = _entity.getYRot();
                        }

                        ++index0;
                    }
                }

                if (world instanceof ServerLevel) {
                    _level = (ServerLevel) world;
                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)).withSuppressedOutput(), "particle dust 0.251 0.000 0.000 4 ~ ~ ~ 4 0 4 1 30 force");
                }
            }

            flag = false;
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                    public Entity apply(LevelAccessor levelAccessor, String uuid) {
                        if (levelAccessor instanceof ServerLevel serverLevel) {
                            try {
                                return serverLevel.getEntity(UUID.fromString(uuid));
                            } catch (Exception var5) {
                            }
                        }

                        return null;
                    }
                }).apply(world, entity.getPersistentData().getString("OWNER_UUID"));
                if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                    label85:
                    {
                        flag = true;
                        if (entity_a instanceof LivingEntity _livEnt32) {
                            if (_livEnt32.hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                break label85;
                            }
                        }

                        if (entity_a.getPersistentData().getDouble("select") == 0.0) {
                            entity.getPersistentData().putBoolean("flag", true);
                        }
                    }

                    if (entity instanceof EntityMalevolentShrineEntity || entity instanceof MalevolentShrineEntity && entity_a.getPersistentData().getDouble("brokenBrain") >= 1.0 && entity_a.getPersistentData().getDouble("cnt1") >= 45.0) {
                        if (!entity.getPersistentData().getBoolean("flag_a")) {
                            entity.getPersistentData().putBoolean("flag_a", true);
                            Level _level2;
                            if (world instanceof Level) {
                                _level2 = (Level) world;
                                if (!_level2.isClientSide()) {
                                    _level2.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                                } else {
                                    _level2.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:stone_crash")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                                }
                            }

                            if (world instanceof Level) {
                                _level2 = (Level) world;
                                if (!_level2.isClientSide()) {
                                    _level2.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.8F);
                                } else {
                                    _level2.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
                                }
                            }
                        }
                    }
                }
            }

            if (!flag) {
                entity.getPersistentData().putBoolean("flag", true);
            }

            if (entity.getPersistentData().getBoolean("flag") && !entity.level().isClientSide()) {
                entity.discard();
            }

        }
    }
}
