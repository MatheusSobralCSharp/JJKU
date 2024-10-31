package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class Buff2Procedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("jujutsucraft:ten_shadows_technique"))) && (new Object() {
            public String getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getString("OWNER_UUID");
            }
        }.getValue()).equals(sourceentity.getStringUUID()) && (new Object() {
            public boolean getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getBoolean("Buffed");
            }
        }.getValue()) == false) {
            ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
                    .setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2.5));
            {
                Entity _ent = sourceentity;
                if (!_ent.level().isClientSide() && _ent.getServer() != null) {
                    _ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
                            _ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -500 @s");
                }
            }
            if (entity instanceof LivingEntity _entity)
                _entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
            {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                dataIndex.getCompound("ForgeData").putBoolean("Buffed", true);
                entity.load(dataIndex);
            }
        }
    }
}
