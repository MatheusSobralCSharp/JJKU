package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;

public class ProfessionDeath2Procedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (new Object() {
            public double getValue() {
                CompoundTag dataIndex = new CompoundTag();
                entity.saveWithoutId(dataIndex);
                return dataIndex.getCompound("ForgeData").getDouble("JujutsuSorcerer");
            }
        }.getValue() == 1) {
            {
                double _setval = (sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).ProfessionEXP + 1;
                sourceentity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.ProfessionEXP = _setval;
                    capability.syncPlayerVariables(sourceentity);
                });
            }
        }
    }
}
