package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.entity.SatushiEntity;

public class ItadoriShinjukuEntityIsHurtProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(entity instanceof SatushiEntity)) {
			if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
				if (!(new Object() {
					public String getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getString("OWNER_UUID");
					}
				}.getValue()).equals(entity.getStringUUID())) {
					if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
				}
			}
		}
	}
}
