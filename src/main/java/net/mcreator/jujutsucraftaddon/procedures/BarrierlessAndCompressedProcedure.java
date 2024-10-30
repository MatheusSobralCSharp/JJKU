package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

public class BarrierlessAndCompressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 2) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex = new CompoundTag();
					entity.saveWithoutId(dataIndex);
					return dataIndex.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 0) {
				if (entity.getPersistentData().getDouble("cnt3") >= 20) {
					if (entity.getPersistentData().getDouble("cnt2") != 1) {
						JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 60;
						JujutsucraftModVariables.MapVariables.get(world).syncData(world);
						{
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							dataIndex.getCompound("ForgeData").putDouble("Range", 198);
							entity.load(dataIndex);
						}
						{
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							dataIndex.getCompound("ForgeData").putDouble("cnt2", 1);
							entity.load(dataIndex);
						}
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex = new CompoundTag();
						entity.saveWithoutId(dataIndex);
						return dataIndex.getCompound("ForgeData").getDouble("select");
					}
				}.getValue() > 0) {
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
					JujutsucraftModVariables.MapVariables.get(world).syncData(world);
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							return dataIndex.getCompound("ForgeData").getDouble("x_pos_doma");
						}
					}.getValue() == entity.getX())) {
						{
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							dataIndex.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
							entity.load(dataIndex);
						}
					}
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							return dataIndex.getCompound("ForgeData").getDouble("z_pos_doma");
						}
					}.getValue() == entity.getZ())) {
						{
							CompoundTag dataIndex = new CompoundTag();
							entity.saveWithoutId(dataIndex);
							dataIndex.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
							entity.load(dataIndex);
						}
					}
				}
			}
		}
	}
}
