package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

public class SukunaFushiguroOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex0 = new CompoundTag();
				entity.saveWithoutId(dataIndex0);
				return dataIndex0.getCompound("ForgeData").getDouble("UseCursedTechnique");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex1 = new CompoundTag();
			entity.saveWithoutId(dataIndex1);
			dataIndex1.getCompound("ForgeData").putDouble("UseCursedTechnique", 1);
			entity.load(dataIndex1);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex2 = new CompoundTag();
				entity.saveWithoutId(dataIndex2);
				return dataIndex2.getCompound("ForgeData").getDouble("JujutsuSorcerer");
			}
		}.getValue() != 1) {
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex3 = new CompoundTag();
					entity.saveWithoutId(dataIndex3);
					return dataIndex3.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				dataIndex4.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
				entity.load(dataIndex4);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex5 = new CompoundTag();
					entity.saveWithoutId(dataIndex5);
					return dataIndex5.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex6 = new CompoundTag();
				entity.saveWithoutId(dataIndex6);
				dataIndex6.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
				entity.load(dataIndex6);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex7 = new CompoundTag();
					entity.saveWithoutId(dataIndex7);
					return dataIndex7.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				dataIndex8.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
				entity.load(dataIndex8);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex9 = new CompoundTag();
					entity.saveWithoutId(dataIndex9);
					return dataIndex9.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex10 = new CompoundTag();
				entity.saveWithoutId(dataIndex10);
				dataIndex10.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
				entity.load(dataIndex10);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex11 = new CompoundTag();
					entity.saveWithoutId(dataIndex11);
					return dataIndex11.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex12 = new CompoundTag();
				entity.saveWithoutId(dataIndex12);
				dataIndex12.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
				entity.load(dataIndex12);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex13 = new CompoundTag();
					entity.saveWithoutId(dataIndex13);
					return dataIndex13.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex14 = new CompoundTag();
				entity.saveWithoutId(dataIndex14);
				dataIndex14.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
				entity.load(dataIndex14);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex15 = new CompoundTag();
					entity.saveWithoutId(dataIndex15);
					return dataIndex15.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex16 = new CompoundTag();
				entity.saveWithoutId(dataIndex16);
				dataIndex16.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
				entity.load(dataIndex16);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex17 = new CompoundTag();
					entity.saveWithoutId(dataIndex17);
					return dataIndex17.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex18 = new CompoundTag();
				entity.saveWithoutId(dataIndex18);
				dataIndex18.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
				entity.load(dataIndex18);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex19 = new CompoundTag();
					entity.saveWithoutId(dataIndex19);
					return dataIndex19.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex20 = new CompoundTag();
				entity.saveWithoutId(dataIndex20);
				dataIndex20.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
				entity.load(dataIndex20);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex21 = new CompoundTag();
					entity.saveWithoutId(dataIndex21);
					return dataIndex21.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
				}
			}.getValue() != -2) {
				CompoundTag dataIndex22 = new CompoundTag();
				entity.saveWithoutId(dataIndex22);
				dataIndex22.getCompound("ForgeData").putDouble("TenShadowsTechnique14", (-2));
				entity.load(dataIndex22);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex23 = new CompoundTag();
					entity.saveWithoutId(dataIndex23);
					return dataIndex23.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex24 = new CompoundTag();
				entity.saveWithoutId(dataIndex24);
				dataIndex24.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
				entity.load(dataIndex24);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex25 = new CompoundTag();
					entity.saveWithoutId(dataIndex25);
					return dataIndex25.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex26 = new CompoundTag();
				entity.saveWithoutId(dataIndex26);
				dataIndex26.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
				entity.load(dataIndex26);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex27 = new CompoundTag();
					entity.saveWithoutId(dataIndex27);
					return dataIndex27.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex28 = new CompoundTag();
				entity.saveWithoutId(dataIndex28);
				dataIndex28.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
				entity.load(dataIndex28);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex29 = new CompoundTag();
					entity.saveWithoutId(dataIndex29);
					return dataIndex29.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex30 = new CompoundTag();
				entity.saveWithoutId(dataIndex30);
				dataIndex30.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
				entity.load(dataIndex30);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex31 = new CompoundTag();
					entity.saveWithoutId(dataIndex31);
					return dataIndex31.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex32 = new CompoundTag();
				entity.saveWithoutId(dataIndex32);
				dataIndex32.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
				entity.load(dataIndex32);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex33 = new CompoundTag();
					entity.saveWithoutId(dataIndex33);
					return dataIndex33.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex34 = new CompoundTag();
				entity.saveWithoutId(dataIndex34);
				dataIndex34.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
				entity.load(dataIndex34);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex35 = new CompoundTag();
					entity.saveWithoutId(dataIndex35);
					return dataIndex35.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex36 = new CompoundTag();
				entity.saveWithoutId(dataIndex36);
				dataIndex36.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
				entity.load(dataIndex36);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex37 = new CompoundTag();
					entity.saveWithoutId(dataIndex37);
					return dataIndex37.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex38 = new CompoundTag();
				entity.saveWithoutId(dataIndex38);
				dataIndex38.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
				entity.load(dataIndex38);
			}
			if (new Object() {
				public double getValue() {
					CompoundTag dataIndex39 = new CompoundTag();
					entity.saveWithoutId(dataIndex39);
					return dataIndex39.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
				}
			}.getValue() != 1) {
				CompoundTag dataIndex40 = new CompoundTag();
				entity.saveWithoutId(dataIndex40);
				dataIndex40.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
				entity.load(dataIndex40);
			}
			CompoundTag dataIndex41 = new CompoundTag();
			entity.saveWithoutId(dataIndex41);
			dataIndex41.getCompound("ForgeData").putDouble("FlagSukuna", 1);
			entity.load(dataIndex41);
			CompoundTag dataIndex42 = new CompoundTag();
			entity.saveWithoutId(dataIndex42);
			dataIndex42.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
			entity.load(dataIndex42);
		}
	}
}
