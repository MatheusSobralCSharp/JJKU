package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class GojoKunaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("Fight");
			}
		}.getValue() == 0) {
			if ((ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString()).equals("jujutsucraft:sukuna_fushiguro")) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:murasakii")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:murasakii")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				CompoundTag dataIndex3 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex3);
				dataIndex3.getCompound("ForgeData").putDouble("Fight", 1);
				sourceentity.load(dataIndex3);
			}
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("skill");
			}
		}.getValue() == 215) {
			if (!(new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() == 50)) {
				CompoundTag dataIndex7 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex7);
				dataIndex7.getCompound("ForgeData").putDouble("cnt5", (new Object() {
					public double getValue() {
						CompoundTag dataIndex6 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex6);
						return dataIndex6.getCompound("ForgeData").getDouble("cnt5");
					}
				}.getValue() + 1));
				sourceentity.load(dataIndex7);
				CompoundTag dataIndex8 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putDouble("PRESS_Z", 1);
				sourceentity.load(dataIndex8);
			} else if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					sourceentity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("cnt5");
				}
			}.getValue() == 50) {
				CompoundTag dataIndex10 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex10);
				dataIndex10.getCompound("ForgeData").putDouble("PRESS_Z", 0);
				sourceentity.load(dataIndex10);
			}
		}
	}
}
