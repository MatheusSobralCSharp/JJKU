
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.jujutsucraftaddon.client.gui.YutaStorageScreen;
import net.mcreator.jujutsucraftaddon.client.gui.WorldSkillScreen;
import net.mcreator.jujutsucraftaddon.client.gui.TestrScreen;
import net.mcreator.jujutsucraftaddon.client.gui.StorageArmoryScreen;
import net.mcreator.jujutsucraftaddon.client.gui.RaceChangeScreen;
import net.mcreator.jujutsucraftaddon.client.gui.KoganeUIScreen;
import net.mcreator.jujutsucraftaddon.client.gui.KenjakuBodySwapScreen;
import net.mcreator.jujutsucraftaddon.client.gui.EvidenceGUIScreen;
import net.mcreator.jujutsucraftaddon.client.gui.CursedEnergySelectorScreen;
import net.mcreator.jujutsucraftaddon.client.gui.ClanChangeScreen;
import net.mcreator.jujutsucraftaddon.client.gui.CTChangerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JujutsucraftaddonModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(JujutsucraftaddonModMenus.EVIDENCE_GUI.get(), EvidenceGUIScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.RACE_CHANGE.get(), RaceChangeScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.YUTA_STORAGE.get(), YutaStorageScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORAGE_ARMORY.get(), StorageArmoryScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.CLAN_CHANGE.get(), ClanChangeScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.TESTR.get(), TestrScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.WORLD_SKILL.get(), WorldSkillScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.CT_CHANGER.get(), CTChangerScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.KENJAKU_BODY_SWAP.get(), KenjakuBodySwapScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.KOGANE_UI.get(), KoganeUIScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.CURSED_ENERGY_SELECTOR.get(), CursedEnergySelectorScreen::new);
		});
	}
}
