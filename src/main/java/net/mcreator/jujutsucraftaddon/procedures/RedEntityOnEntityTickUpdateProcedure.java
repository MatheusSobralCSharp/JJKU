package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraftaddon.entity.BlueEntityEntity;

import java.util.List;
import java.util.Comparator;

public class RedEntityOnEntityTickUpdateProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(300 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof BlueEntityEntity) {
                    if (entity instanceof Mob _entity)
                        _entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 480);
                }
            }
        }
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (new Object() {
                    public double getValue() {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        return dataIndex.getCompound("ForgeData").getDouble("blue");
                    }
                }.getValue() == 1) {
                    if (!entity.level().isClientSide())
                        entity.discard();
                    {
                        Entity _ent = entity;
                        if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                            _ent.getServer().getCommands().performPrefixedCommand(
                                    new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
                                            _ent.level().getServer(), _ent),
                                    ("execute as @s at @s unless entity @e[nbt={ForgeData:{purple:2d}},distance=..300] run summon jujutsucraft:purple ~ ~ ~ {ForgeData:{BlockDamage:0.0d,BlockRange:0.0d,COOLDOWN_TICKS:10.0d,Damage:378000d,DomainAttack:0b,ExtinctionBlock:0b,attack:0b,NameRanged_ranged:0.8395166333921098d,cnt1:1.0d,cnt3:1.0d,cnt6:"
                                            + ((world.getLevelData().getGameRules().getInt(JujutsucraftaddonModGameRules.JJKU_PURPLE_RANGE)) + ""
                                            + ".0d,cnt_brokenBrain:0.0d,Name_Ranged:0.821,cnt_bullet_hit:-4.0d,cnt_life:6.0d,cnt_target:0.0d,effect:0.0d,effectConfirm:0.0d,explode:1b,ignore:0b,knockback:0.0d,noEffect:0b,noParticle:0b,projectile_type:0.0d,skill:215.0d,swing:0b},Attributes:[{Name:\"minecraft:generic.max_health\",Base:20000.0d}],ActiveEffects:[{Id:5,Amplifier:20,Duration:-1,ShowParticles:false}]}")));
                        }
                    }
                    if (world instanceof Level _level) {
                        if (!_level.isClientSide()) {
                            _level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1);
                        } else {
                            _level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:purplexplode")), SoundSource.NEUTRAL, 5, 1, false);
                        }
                    }
                    if (!entityiterator.level().isClientSide())
                        entityiterator.discard();
                }
            }
        }
        entity.noPhysics = true;
    }
}
