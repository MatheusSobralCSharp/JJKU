package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.nbt.CompoundTag;

public class HusseinDongOnEntityTickUpdateProcedure {
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
			CompoundTag dataIndex3 = new CompoundTag();
			entity.saveWithoutId(dataIndex3);
			dataIndex3.getCompound("ForgeData").putDouble("JujutsuSorcerer", 1);
			entity.load(dataIndex3);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex4 = new CompoundTag();
				entity.saveWithoutId(dataIndex4);
				return dataIndex4.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex5 = new CompoundTag();
			entity.saveWithoutId(dataIndex5);
			dataIndex5.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
			entity.load(dataIndex5);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex6 = new CompoundTag();
				entity.saveWithoutId(dataIndex6);
				return dataIndex6.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex7 = new CompoundTag();
			entity.saveWithoutId(dataIndex7);
			dataIndex7.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
			entity.load(dataIndex7);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex8 = new CompoundTag();
				entity.saveWithoutId(dataIndex8);
				return dataIndex8.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex9 = new CompoundTag();
			entity.saveWithoutId(dataIndex9);
			dataIndex9.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
			entity.load(dataIndex9);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex10 = new CompoundTag();
				entity.saveWithoutId(dataIndex10);
				return dataIndex10.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex11 = new CompoundTag();
			entity.saveWithoutId(dataIndex11);
			dataIndex11.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
			entity.load(dataIndex11);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex12 = new CompoundTag();
				entity.saveWithoutId(dataIndex12);
				return dataIndex12.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex13 = new CompoundTag();
			entity.saveWithoutId(dataIndex13);
			dataIndex13.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
			entity.load(dataIndex13);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex14 = new CompoundTag();
				entity.saveWithoutId(dataIndex14);
				return dataIndex14.getCompound("ForgeData").getDouble("TenShadowsTechnique11");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex15 = new CompoundTag();
			entity.saveWithoutId(dataIndex15);
			dataIndex15.getCompound("ForgeData").putDouble("TenShadowsTechnique11", 1);
			entity.load(dataIndex15);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex16 = new CompoundTag();
				entity.saveWithoutId(dataIndex16);
				return dataIndex16.getCompound("ForgeData").getDouble("TenShadowsTechnique12");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex17 = new CompoundTag();
			entity.saveWithoutId(dataIndex17);
			dataIndex17.getCompound("ForgeData").putDouble("TenShadowsTechnique12", 1);
			entity.load(dataIndex17);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex18 = new CompoundTag();
				entity.saveWithoutId(dataIndex18);
				return dataIndex18.getCompound("ForgeData").getDouble("TenShadowsTechnique13");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex19 = new CompoundTag();
			entity.saveWithoutId(dataIndex19);
			dataIndex19.getCompound("ForgeData").putDouble("TenShadowsTechnique13", 1);
			entity.load(dataIndex19);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex20 = new CompoundTag();
				entity.saveWithoutId(dataIndex20);
				return dataIndex20.getCompound("ForgeData").getDouble("TenShadowsTechnique10");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex21 = new CompoundTag();
			entity.saveWithoutId(dataIndex21);
			dataIndex21.getCompound("ForgeData").putDouble("TenShadowsTechnique10", 1);
			entity.load(dataIndex21);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex22 = new CompoundTag();
				entity.saveWithoutId(dataIndex22);
				return dataIndex22.getCompound("ForgeData").getDouble("TenShadowsTechnique14");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex23 = new CompoundTag();
			entity.saveWithoutId(dataIndex23);
			dataIndex23.getCompound("ForgeData").putDouble("TenShadowsTechnique14", 1);
			entity.load(dataIndex23);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex24 = new CompoundTag();
				entity.saveWithoutId(dataIndex24);
				return dataIndex24.getCompound("ForgeData").getDouble("TenShadowsTechnique4");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex25 = new CompoundTag();
			entity.saveWithoutId(dataIndex25);
			dataIndex25.getCompound("ForgeData").putDouble("TenShadowsTechnique4", 1);
			entity.load(dataIndex25);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex26 = new CompoundTag();
				entity.saveWithoutId(dataIndex26);
				return dataIndex26.getCompound("ForgeData").getDouble("TenShadowsTechnique6");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex27 = new CompoundTag();
			entity.saveWithoutId(dataIndex27);
			dataIndex27.getCompound("ForgeData").putDouble("TenShadowsTechnique6", 1);
			entity.load(dataIndex27);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex28 = new CompoundTag();
				entity.saveWithoutId(dataIndex28);
				return dataIndex28.getCompound("ForgeData").getDouble("TenShadowsTechnique7");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex29 = new CompoundTag();
			entity.saveWithoutId(dataIndex29);
			dataIndex29.getCompound("ForgeData").putDouble("TenShadowsTechnique7", 1);
			entity.load(dataIndex29);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex30 = new CompoundTag();
				entity.saveWithoutId(dataIndex30);
				return dataIndex30.getCompound("ForgeData").getDouble("TenShadowsTechnique8");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex31 = new CompoundTag();
			entity.saveWithoutId(dataIndex31);
			dataIndex31.getCompound("ForgeData").putDouble("TenShadowsTechnique8", 1);
			entity.load(dataIndex31);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex32 = new CompoundTag();
				entity.saveWithoutId(dataIndex32);
				return dataIndex32.getCompound("ForgeData").getDouble("TenShadowsTechnique9");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex33 = new CompoundTag();
			entity.saveWithoutId(dataIndex33);
			dataIndex33.getCompound("ForgeData").putDouble("TenShadowsTechnique9", 1);
			entity.load(dataIndex33);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex34 = new CompoundTag();
				entity.saveWithoutId(dataIndex34);
				return dataIndex34.getCompound("ForgeData").getDouble("TenShadowsTechnique5");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex35 = new CompoundTag();
			entity.saveWithoutId(dataIndex35);
			dataIndex35.getCompound("ForgeData").putDouble("TenShadowsTechnique5", 1);
			entity.load(dataIndex35);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex36 = new CompoundTag();
				entity.saveWithoutId(dataIndex36);
				return dataIndex36.getCompound("ForgeData").getDouble("TenShadowsTechnique1");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex37 = new CompoundTag();
			entity.saveWithoutId(dataIndex37);
			dataIndex37.getCompound("ForgeData").putDouble("TenShadowsTechnique1", 1);
			entity.load(dataIndex37);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex38 = new CompoundTag();
				entity.saveWithoutId(dataIndex38);
				return dataIndex38.getCompound("ForgeData").getDouble("TenShadowsTechnique2");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex39 = new CompoundTag();
			entity.saveWithoutId(dataIndex39);
			dataIndex39.getCompound("ForgeData").putDouble("TenShadowsTechnique2", 1);
			entity.load(dataIndex39);
		}
		if (new Object() {
			public double getValue() {
				CompoundTag dataIndex40 = new CompoundTag();
				entity.saveWithoutId(dataIndex40);
				return dataIndex40.getCompound("ForgeData").getDouble("TenShadowsTechnique3");
			}
		}.getValue() != 1) {
			CompoundTag dataIndex41 = new CompoundTag();
			entity.saveWithoutId(dataIndex41);
			dataIndex41.getCompound("ForgeData").putDouble("TenShadowsTechnique3", 1);
			entity.load(dataIndex41);
		}
		if (Math.random() <= 0.005) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
		}
	}
}
