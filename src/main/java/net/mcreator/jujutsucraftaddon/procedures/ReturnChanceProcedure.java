package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class ReturnChanceProcedure {
    public static String execute() {
        File file = new File("");
        double randomnumber = 0;
        com.google.gson.JsonObject mainObject = new com.google.gson.JsonObject();
        file = new File((FMLPaths.GAMEDIR.get().toString() + "/config"), File.separator + "JujutsuRates.json");
        return "" + mainObject.get("Maki").getAsDouble();
    }
}
