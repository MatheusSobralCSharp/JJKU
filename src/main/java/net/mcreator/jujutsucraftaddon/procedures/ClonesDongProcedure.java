package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;

public class ClonesDongProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("UseCursedTechnique");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex1 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
			sourceentity.load(dataIndex1);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("CT");
			}
		}.getValue() < 1) {
			CompoundTag dataIndex3 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("CT", 1);
			sourceentity.load(dataIndex3);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex5 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex5);
			dataIndex5.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
			sourceentity.load(dataIndex5);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex6 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex6);
				return dataIndex6.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex7 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex7);
			dataIndex7.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
			sourceentity.load(dataIndex7);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex8 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex8);
				return dataIndex8.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex9 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex9);
			dataIndex9.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
			sourceentity.load(dataIndex9);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex10 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex10);
				return dataIndex10.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex11 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex11);
			dataIndex11.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
			sourceentity.load(dataIndex11);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex12 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex12);
				return dataIndex12.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex13 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex13);
			dataIndex13.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
			sourceentity.load(dataIndex13);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex14 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex14);
				return dataIndex14.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex15 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex15);
			dataIndex15.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
			sourceentity.load(dataIndex15);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex16 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex16);
				return dataIndex16.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex17 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex17);
			dataIndex17.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
			sourceentity.load(dataIndex17);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex18 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex18);
				return dataIndex18.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex19 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex19);
			dataIndex19.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
			sourceentity.load(dataIndex19);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex20 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex20);
				return dataIndex20.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex21 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex21);
			dataIndex21.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
			sourceentity.load(dataIndex21);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex22 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex22);
				return dataIndex22.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex23 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex23);
			dataIndex23.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
			sourceentity.load(dataIndex23);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex24 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex24);
				return dataIndex24.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex25 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex25);
			dataIndex25.getCompound("ForgeData").putDouble("TenShadowsTechnique14", 1);
			sourceentity.load(dataIndex25);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex26 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex26);
				return dataIndex26.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex27 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex27);
			dataIndex27.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
			sourceentity.load(dataIndex27);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex28 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex28);
				return dataIndex28.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex29 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex29);
			dataIndex29.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
			sourceentity.load(dataIndex29);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex30 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex30);
				return dataIndex30.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex31 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex31);
			dataIndex31.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
			sourceentity.load(dataIndex31);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex32 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex32);
				return dataIndex32.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex33 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex33);
			dataIndex33.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
			sourceentity.load(dataIndex33);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex34 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex34);
				return dataIndex34.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex35 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex35);
			dataIndex35.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
			sourceentity.load(dataIndex35);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex36 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex36);
				return dataIndex36.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex37 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex37);
			dataIndex37.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
			sourceentity.load(dataIndex37);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex38 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex38);
				return dataIndex38.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex39 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex39);
			dataIndex39.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
			sourceentity.load(dataIndex39);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex40 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex40);
				return dataIndex40.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex41 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex41);
			dataIndex41.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
			sourceentity.load(dataIndex41);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex42 = new CompoundTag();
				sourceentity.saveWithoutId(dataIndex42);
				return dataIndex42.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex43 = new CompoundTag();
			sourceentity.saveWithoutId(dataIndex43);
			dataIndex43.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
			sourceentity.load(dataIndex43);
		}
		if (Math.random() <= 0.005) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
