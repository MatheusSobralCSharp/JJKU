
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
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna7Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna6Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna5Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna4Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna3Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna2Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeSukuna1Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeGojo6Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeGojo4Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeGojo3Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeGojo2Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StoryModeGojo1Screen;
import net.mcreator.jujutsucraftaddon.client.gui.StorageArmoryScreen;
import net.mcreator.jujutsucraftaddon.client.gui.SkillTreeScreen;
import net.mcreator.jujutsucraftaddon.client.gui.SkillTreeSPScreen;
import net.mcreator.jujutsucraftaddon.client.gui.RaceChangeScreen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest9Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest8Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest7Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest6Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest5Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest4Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest3Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest2Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest1Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest14Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest13Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest12Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest11Screen;
import net.mcreator.jujutsucraftaddon.client.gui.Quest10Screen;
import net.mcreator.jujutsucraftaddon.client.gui.ProfessionGUIScreen;
import net.mcreator.jujutsucraftaddon.client.gui.NewTabScreen;
import net.mcreator.jujutsucraftaddon.client.gui.KoganeUIScreen;
import net.mcreator.jujutsucraftaddon.client.gui.KenjakuBodySwapScreen;
import net.mcreator.jujutsucraftaddon.client.gui.GojoTrainScreen;
import net.mcreator.jujutsucraftaddon.client.gui.EvidenceGUIScreen;
import net.mcreator.jujutsucraftaddon.client.gui.EnchantYorozuScreen;
import net.mcreator.jujutsucraftaddon.client.gui.ElementsScreen;
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
			MenuScreens.register(JujutsucraftaddonModMenus.PROFESSION_GUI.get(), ProfessionGUIScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.ELEMENTS.get(), ElementsScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.SKILL_TREE.get(), SkillTreeScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_1.get(), Quest1Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_2.get(), Quest2Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_3.get(), Quest3Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_4.get(), Quest4Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_5.get(), Quest5Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_6.get(), Quest6Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_7.get(), Quest7Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_8.get(), Quest8Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_9.get(), Quest9Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_10.get(), Quest10Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_11.get(), Quest11Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_12.get(), Quest12Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_13.get(), Quest13Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.QUEST_14.get(), Quest14Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.SKILL_TREE_SP.get(), SkillTreeSPScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.GOJO_TRAIN.get(), GojoTrainScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_GOJO_1.get(), StoryModeGojo1Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_GOJO_2.get(), StoryModeGojo2Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_GOJO_3.get(), StoryModeGojo3Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_GOJO_4.get(), StoryModeGojo4Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_GOJO_6.get(), StoryModeGojo6Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_1.get(), StoryModeSukuna1Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_2.get(), StoryModeSukuna2Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_3.get(), StoryModeSukuna3Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_4.get(), StoryModeSukuna4Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_5.get(), StoryModeSukuna5Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_6.get(), StoryModeSukuna6Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.STORY_MODE_SUKUNA_7.get(), StoryModeSukuna7Screen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.ENCHANT_YOROZU.get(), EnchantYorozuScreen::new);
			MenuScreens.register(JujutsucraftaddonModMenus.NEW_TAB.get(), NewTabScreen::new);
		});
	}
}
