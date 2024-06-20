package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;

public class SizeOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 15) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex1 = new CompoundTag();
					entity.saveWithoutId(dataIndex1);
					return dataIndex1.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 1501 && entity.isShiftKeyDown()) {
				((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
						.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() - 0.05));
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("skill");
				}
			}.getValue() == 1501 && !entity.isShiftKeyDown()) {
				if ((new Object() {
					public boolean getValue() {
						CompoundTag dataIndex7 = new CompoundTag();
						entity.saveWithoutId(dataIndex7);
						return dataIndex7.getCompound("ForgeData").getBoolean("PRESS_M");
					}
				}.getValue()) == true) {
					((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size")))
							.setBaseValue((((LivingEntity) entity).getAttribute(ForgeRegistries.ATTRIBUTES.getValue(new ResourceLocation("jujutsucraft:size"))).getBaseValue() + 0.05));
				}
			}
		}
	}
}
