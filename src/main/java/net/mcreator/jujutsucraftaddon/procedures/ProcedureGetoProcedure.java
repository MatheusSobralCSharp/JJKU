package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.List;
import java.util.Comparator;

public class ProcedureGetoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity)) {
					if (new Object() {
						public double getValue() {
							CompoundTag dataIndex1 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex1);
							return dataIndex1.getCompound("ForgeData").getDouble("CursedSpirit");
						}
					}.getValue() == 1 && (new Object() {
						public String getValue() {
							CompoundTag dataIndex2 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex2);
							return dataIndex2.getCompound("ForgeData").getString("OWNER_UUID");
						}
					}.getValue()).equals(entity.getStringUUID()) && (new Object() {
						public boolean getValue() {
							CompoundTag dataIndex4 = new CompoundTag();
							entityiterator.saveWithoutId(dataIndex4);
							return dataIndex4.getCompound("ForgeData").getBoolean("Buffed");
						}
					}.getValue()) == false) {
						((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
								.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() * 2));
						((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH)
								.setBaseValue((((LivingEntity) entityiterator).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue() * 2.5));
						{
							Entity _ent = entityiterator;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "execute as @s unless predicate jujutsucraftaddon:effects/orca/sixeyes run jjc_cursepower -500 @s");
							}
						}
						if (entityiterator instanceof LivingEntity _entity)
							_entity.setHealth(entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
						CompoundTag dataIndex12 = new CompoundTag();
						entityiterator.saveWithoutId(dataIndex12);
						dataIndex12.getCompound("ForgeData").putBoolean("Buffed", true);
						entityiterator.load(dataIndex12);
					}
				}
			}
		}
	}
}
