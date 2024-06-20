package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModItems;

public class ChangeMimicryProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.SWORD_OKKOTSU.get()) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex2 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex2);
					return dataIndex2.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() > 1) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("skill", (new Object() {
					public double getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue()));
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JujutsucraftaddonModItems.SWORD_OKKOTSU_TWO.get()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("skill") == 0) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex10 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex10);
						return dataIndex10.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 1) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("skill", (new Object() {
						public double getValue() {
							CompoundTag dataIndex11 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex11);
							return dataIndex11.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue()));
				}
			}
		}
	}
}
