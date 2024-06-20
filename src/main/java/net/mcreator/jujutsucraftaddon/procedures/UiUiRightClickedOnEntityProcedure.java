package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class UiUiRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).InfusedDomain == true
				&& (ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString()).equals("jujutsucraft:mei_mei_axe")) {
			if (!(entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false)) {
				if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) == false) {
					if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
						_toTame.tame(_owner);
					if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
						_toTame.tame(_owner);
					if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
						_toTame.tame(_owner);
					CompoundTag dataIndex8 = new CompoundTag();
					entity.saveWithoutId(dataIndex8);
					dataIndex8.getCompound("ForgeData").putDouble("friend_num", (new Object() {
						public double getValue() {
							CompoundTag dataIndex7 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex7);
							return dataIndex7.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex8);
					CompoundTag dataIndex10 = new CompoundTag();
					entity.saveWithoutId(dataIndex10);
					dataIndex10.getCompound("ForgeData").putDouble("friend_num2", (new Object() {
						public double getValue() {
							CompoundTag dataIndex9 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex9);
							return dataIndex9.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex10);
					CompoundTag dataIndex12 = new CompoundTag();
					entity.saveWithoutId(dataIndex12);
					dataIndex12.getCompound("ForgeData").putDouble("friend_num_worker", (new Object() {
						public double getValue() {
							CompoundTag dataIndex11 = new CompoundTag();
							sourceentity.saveWithoutId(dataIndex11);
							return dataIndex11.getCompound("ForgeData").getDouble("friend_num");
						}
					}.getValue()));
					entity.load(dataIndex12);
				}
			}
		}
	}
}
