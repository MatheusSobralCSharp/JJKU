package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModMobEffects;

import java.util.List;
import java.util.Comparator;

public class SpawnGojoProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;
        {
            final Vec3 _center = new Vec3(x, y, z);
            List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if ((ForgeRegistries.ENTITY_TYPES.getKey(entityiterator.getType()).toString()).equals("jujutsucraft:gojo_satoru")) {
                    {
                        CompoundTag dataIndex = new CompoundTag();
                        entityiterator.saveWithoutId(dataIndex);
                        dataIndex.getCompound("ForgeData").putDouble("GojoBurn", 1);
                        entityiterator.load(dataIndex);
                    }
                    ((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(1000);
                    if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 10, false, false));
                    if (entityiterator instanceof LivingEntity _entity)
                        _entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
                    if (entityiterator instanceof Mob _entity && entity instanceof LivingEntity _ent)
                        _entity.setTarget(_ent);
                    if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                        _entity.addEffect(new MobEffectInstance(JujutsucraftaddonModMobEffects.TRAINING.get(), 6001, 1, false, false));
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Satoru Gojo: My Student's Watching, So I'm Going to Show Off..."), false);
                }
            }
        }
        if (entity instanceof Player _player)
            _player.closeContainer();
    }
}
