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
					CompoundTag dataIndex0 = new CompoundTag();
					entity.saveWithoutId(dataIndex0);
					return dataIndex0.getCompound("ForgeData").getDouble("select");
				}
			}.getValue() > 0) {
				if (entity.getPersistentData().getDouble("cnt3") >= 20) {
					if (entity.getPersistentData().getDouble("cnt2") != 1) {
						JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 60;
						JujutsucraftModVariables.MapVariables.get(world).syncData(world);
						CompoundTag dataIndex4 = new CompoundTag();
						entity.saveWithoutId(dataIndex4);
						dataIndex4.getCompound("ForgeData").putDouble("Range", 198);
						entity.load(dataIndex4);
						CompoundTag dataIndex5 = new CompoundTag();
						entity.saveWithoutId(dataIndex5);
						dataIndex5.getCompound("ForgeData").putDouble("cnt2", 1);
						entity.load(dataIndex5);
					}
				}
			}
		} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).DomainType == 1) {
			if (((entity instanceof LivingEntity) && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) == false) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						entity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getDouble("select");
					}
				}.getValue() > 0) {
					JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius = 12;
					JujutsucraftModVariables.MapVariables.get(world).syncData(world);
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex9 = new CompoundTag();
							entity.saveWithoutId(dataIndex9);
							return dataIndex9.getCompound("ForgeData").getDouble("x_pos_doma");
						}
					}.getValue() == entity.getX())) {
						CompoundTag dataIndex12 = new CompoundTag();
						entity.saveWithoutId(dataIndex12);
						dataIndex12.getCompound("ForgeData").putDouble("x_pos_doma", (entity.getX()));
						entity.load(dataIndex12);
					}
					if (!(new Object() {
						public double getValue() {
							CompoundTag dataIndex13 = new CompoundTag();
							entity.saveWithoutId(dataIndex13);
							return dataIndex13.getCompound("ForgeData").getDouble("z_pos_doma");
						}
					}.getValue() == entity.getZ())) {
						CompoundTag dataIndex16 = new CompoundTag();
						entity.saveWithoutId(dataIndex16);
						dataIndex16.getCompound("ForgeData").putDouble("z_pos_doma", (entity.getZ()));
						entity.load(dataIndex16);
					}
				}
			}
		}
	}
}
