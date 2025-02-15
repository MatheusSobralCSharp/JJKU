package net.mcreator.jujutsucraftaddon;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "jujutsucraftaddon", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class VersionChecker {
    private static final String REQUIRED_VERSION = "7.76"; // Change this to your required version
    private static final String MOD_ID = "jujutsucraftaddon";

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (!isCorrectVersion()) {
                player.connection.disconnect(Component.literal(
                        "Wrong mod version! Please install version " + REQUIRED_VERSION));
            }
        }
    }

    private static boolean isCorrectVersion() {
        return ModList.get().isLoaded(MOD_ID) &&
                ModList.get().getModContainerById(MOD_ID)
                        .map(mod -> mod.getModInfo().getVersion().toString().equals(REQUIRED_VERSION))
                        .orElse(false);
    }
}