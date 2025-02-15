package net.mcreator.jujutsucraftaddon.procedures;

import net.mcreator.jujutsucraftaddon.entity.CleaveWebEntity;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModEntities;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Comparator;
import java.util.List;

public class WSCleaveWebProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
                && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:cleave_web_advancement"))).isDone()) {
            if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).OutputLevel <= 3) {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            {
                                Entity _ent = entityiterator;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:dismantle ~ ~ ~ 0 0 0 1 1 force");
                                }
                            }
                            if (!(new Object() {
                                public String getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                                }
                            }.getValue()).equals(entity.getStringUUID())) {
                                if (!!world.getEntitiesOfClass(CleaveWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        LevelAccessor _worldorig = world;
                                        world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                        if (world != null) {
                                            Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                            if (entitytospawn != null) {
                                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                if ((entitytospawn) instanceof CleaveWebEntity _datEntSetI)
                                                    _datEntSetI.getEntityData().set(CleaveWebEntity.DATA_b, 1);
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("BlockRange", 40);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("BlockDamage", 40);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putBoolean("ExtinctionBlock", true);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putBoolean("noEffect", true);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(10);
                                                (entitytospawn).getPersistentData().putDouble("BlockRange", 60);
                                                (entitytospawn).getPersistentData().putDouble("BlockDamage", 60);
                                                (entitytospawn).getPersistentData().putBoolean("ExtinctionBlock", true);
                                                (entitytospawn).getPersistentData().putBoolean("noEffect", true);
                                                _serverLevel.addFreshEntity(entitytospawn);
                                            }
                                        }
                                        world = _worldorig;
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                {
                    final Vec3 _center = new Vec3(x, y, z);
                    List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                    for (Entity entityiterator : _entfound) {
                        if (!(entityiterator == entity)) {
                            {
                                Entity _ent = entityiterator;
                                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null,
                                            4, _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "particle jjkueffects:dismantle ~ ~ ~ 0 0 0 1 1 force");
                                }
                            }
                            if (!(new Object() {
                                public String getValue() {
                                    CompoundTag dataIndex = new CompoundTag();
                                    entityiterator.saveWithoutId(dataIndex);
                                    return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
                                }
                            }.getValue()).equals(entity.getStringUUID())) {
                                if (!!world.getEntitiesOfClass(CleaveWebEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty()) {
                                    if (world instanceof ServerLevel _serverLevel) {
                                        LevelAccessor _worldorig = world;
                                        world = _serverLevel.getServer().getLevel(entity.level().dimension());
                                        if (world != null) {
                                            Entity entitytospawn = JujutsucraftaddonModEntities.CLEAVE_WEB.get().create(_serverLevel, null, null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
                                            if (entitytospawn != null) {
                                                entitytospawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                                                if ((entitytospawn) instanceof CleaveWebEntity _datEntSetI)
                                                    _datEntSetI.getEntityData().set(CleaveWebEntity.DATA_b, 1);
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putString("OWNER_UUID", (entity.getStringUUID()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
                                                        public double getValue() {
                                                            CompoundTag dataIndex = new CompoundTag();
                                                            entity.saveWithoutId(dataIndex);
                                                            return dataIndex.getCompound("ForgeData").getDouble("friend_num");
                                                        }
                                                    }.getValue()));
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("BlockRange", 120);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putDouble("BlockDamage", 60);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putBoolean("ExtinctionBlock", true);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                {
                                                    CompoundTag dataIndex = new CompoundTag();
                                                    (entitytospawn).saveWithoutId(dataIndex);
                                                    dataIndex.getCompound("ForgeData").putBoolean("noEffect", true);
                                                    (entitytospawn).load(dataIndex);
                                                }
                                                ((LivingEntity) (entitytospawn)).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).setBaseValue(20);
                                                (entitytospawn).getPersistentData().putDouble("BlockRange", 50);
                                                (entitytospawn).getPersistentData().putDouble("BlockDamage", 50);
                                                (entitytospawn).getPersistentData().putBoolean("ExtinctionBlock", true);
                                                (entitytospawn).getPersistentData().putBoolean("noEffect", true);
                                                _serverLevel.addFreshEntity(entitytospawn);
                                            }
                                        }
                                        world = _worldorig;
                                    }
                                    entity.setInvulnerable(true);
                                    if (world instanceof Level _level && !_level.isClientSide())
                                        _level.explode(null, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 7, Level.ExplosionInteraction.TNT);
                                    entity.setInvulnerable(false);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
