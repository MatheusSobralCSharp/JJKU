package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.YutaCullingGamesEntity;

public class OkkotsuAttackedProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof YutaCullingGamesEntity) {
			if (sourceentity instanceof LivingEntity) {
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex2 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex2);
						return dataIndex2.getCompound("ForgeData").getDouble("skill");
					}
				}.getValue() > 2) {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("skill", (new Object() {
						public double getValue() {
							CompoundTag dataIndex3 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex3);
							return dataIndex3.getCompound("ForgeData").getDouble("skill");
						}
					}.getValue()));
				}
			}
		}
	}
}
