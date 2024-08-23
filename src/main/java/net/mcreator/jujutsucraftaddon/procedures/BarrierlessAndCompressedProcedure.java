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
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				CompoundTag dataIndex1 = new CompoundTag();
				entity.saveWithoutId(dataIndex1);
				dataIndex1.getCompound("ForgeData").putDouble("cnt2", 1);
				entity.load(dataIndex1);
				JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 40;
				JujutsucraftModVariables.MapVariables.get(world).syncData(world);
			}
		} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex4 = new CompoundTag();
						entity.saveWithoutId(dataIndex4);
						return dataIndex4.getCompound("ForgeData").getDouble("select");
					}
				}.getValue() > 0) {
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
					JujutsucraftModVariables.MapVariables.get(world).syncData(world);
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex6 = new CompoundTag();
							entity.saveWithoutId(dataIndex6);
							return dataIndex6.getCompound("ForgeData").getDouble("x_pos_doma");
						}
					}.getValue() == entity.getX())) {
						CompoundTag dataIndex9 = new CompoundTag();
						entity.saveWithoutId(dataIndex9);
						dataIndex9.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
						entity.load(dataIndex9);
					}
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex10 = new CompoundTag();
							entity.saveWithoutId(dataIndex10);
							return dataIndex10.getCompound("ForgeData").getDouble("z_pos_doma");
						}
					}.getValue() == entity.getZ())) {
						CompoundTag dataIndex13 = new CompoundTag();
						entity.saveWithoutId(dataIndex13);
						dataIndex13.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
						entity.load(dataIndex13);
					}
				}
			}
		}
	}
}
