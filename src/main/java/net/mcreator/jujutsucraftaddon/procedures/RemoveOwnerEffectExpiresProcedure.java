package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class RemoveOwnerEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			CompoundTag dataIndex = new CompoundTag();
			entity.saveWithoutId(dataIndex);
			dataIndex.putString("Owner", "");
			entity.load(dataIndex);
		}
	}
}
