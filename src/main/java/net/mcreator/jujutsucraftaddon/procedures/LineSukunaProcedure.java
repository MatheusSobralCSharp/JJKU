package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class LineSukunaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("PRESS_Z");
			}
		}.getValue() == 0) {
			if (Math.random() < 0.005) {
				CompoundTag dataIndex2 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex2);
				dataIndex2.getCompound("ForgeData").putDouble("Lines", (Mth.nextInt(RandomSource.create(), 1, 2)));
				sourceentity.load(dataIndex2);
				if (new Object() {
					public double getValue() {
						CompoundTag dataIndex3 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex3);
						return dataIndex3.getCompound("ForgeData").getDouble("Lines");
					}
				}.getValue() == 1) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gabare")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:gabare")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				} else if (new Object() {
					public double getValue() {
						CompoundTag dataIndex5 = new CompoundTag();
						sourceentity.saveWithoutId(dataIndex5);
						return dataIndex5.getCompound("ForgeData").getDouble("Lines");
					}
				}.getValue() == 2) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna")), SoundSource.NEUTRAL, 2, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraftaddon:laughsukuna")), SoundSource.NEUTRAL, 2, 1, false);
						}
					}
				}
			}
		}
	}
}
