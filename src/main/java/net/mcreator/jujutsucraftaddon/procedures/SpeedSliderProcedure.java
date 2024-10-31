package net.mcreator.jujutsucraftaddon.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import java.util.HashMap;

public class SpeedSliderProcedure {
    public static void execute(Entity entity, HashMap guistate) {
        if (entity == null || guistate == null)
            return;
        ((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
                .setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED).getBaseValue() / new Object() {
                    double convert(String s) {
                        try {
                            return Double.parseDouble(s.trim());
                        } catch (Exception e) {
                        }
                        return 0;
                    }
                }.convert(guistate.containsKey("textin:speedslider") ? (String) guistate.get("textin:speedslider") : "")));
    }
}
