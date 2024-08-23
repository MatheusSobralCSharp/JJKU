
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JujutsucraftaddonModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<CreativeModeTab> ARMORS = REGISTRY.register("armors",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.armors")).icon(() -> new ItemStack(JujutsucraftaddonModItems.GOJO_TRAINING_FINAL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.DECISIVE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.DECISIVE_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.DECISIVE_BLACK_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.DECISIVE_BLACK_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.SUNG_JIN_WOO_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.SUNG_JIN_WOO_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.WHITE_CAPE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.WHITE_CAPE_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.RED_CAPE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.RED_CAPE_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.PURPLE_CAPE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.PURPLE_CAPE_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.KIMONO_BLACK_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.KIMONO_BLACK_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.KIMONO_WHITE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.KIMONO_WHITE_LEGGINGS.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_TWO_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_ARMOR_THREE_CHESTPLATE.get());
				tabData.accept(JujutsucraftaddonModItems.KENJAKU_ARMOR_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.INUMAKI_ARMOR_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.MUGIWARA_HELMET.get());
				tabData.accept(JujutsucraftaddonModItems.GOJO_CHESTPLATE.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> JUJUTSU_ADDON_CREATURES = REGISTRY.register("jujutsu_addon_creatures",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_addon_creatures")).icon(() -> new ItemStack(Items.PANDA_SPAWN_EGG)).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.MAKI_PREPARATION_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_MANGA_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_NO_SHIRT_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.ITADORI_SHINJUKU_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.YUTA_CULLING_GAMES_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.SUKUNA_FUSHIGURO_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.GEGE_AKUTAMI_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.SHOKO_IERI_SCHOOL_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.GOJO_MANGA_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.RIKO_AMANAI_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.TANJERINA_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.UI_UI_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.IRONKK_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.HUSSEIN_DONG_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.GOJO_SCHOOL_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.HAKARI_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.ANGELL_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.KASHIMO_FEMBOY_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.URAUME_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.ADJUCHA_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.SATUSHI_SPAWN_EGG.get());
				tabData.accept(JujutsucraftaddonModItems.ANTI_VEIL_SPAWN_EGG.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> ITEMS = REGISTRY.register("items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.items")).icon(() -> new ItemStack(JujutsucraftaddonModItems.SPECIAL_GRADE_1_RECOMMENDATION.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.S_OULBOOK.get());
				tabData.accept(JujutsucraftaddonModItems.RANDOM_CT_CHANGER.get());
				tabData.accept(JujutsucraftaddonModItems.SPECIAL_GRADE_1_RECOMMENDATION.get());
				tabData.accept(JujutsucraftaddonModItems.FAMOUS_GRADE_RECOMMENDATION.get());
				tabData.accept(JujutsucraftaddonModItems.STRONGEST_OF_HISTORY_RECOMMENDATION.get());
				tabData.accept(JujutsucraftaddonModItems.MODERN_ERA_SORCERER.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> WEAPONS = REGISTRY.register("weapons",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.weapons")).icon(() -> new ItemStack(JujutsucraftaddonModItems.ARMORY_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU.get());
				tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU_TWO.get());
				tabData.accept(JujutsucraftaddonModItems.SWORD_OKKOTSU_THREE.get());
				tabData.accept(JujutsucraftaddonModItems.WARSTAFF.get());
				tabData.accept(JujutsucraftaddonModItems.ITADORI_ARMS.get());
				tabData.accept(JujutsucraftaddonModItems.BULLET.get());
				tabData.accept(JujutsucraftaddonModItems.SWORD_KUSAKABE.get());
				tabData.accept(JujutsucraftaddonModItems.BLOOD_EDGE.get());
				tabData.accept(JujutsucraftaddonModItems.YUUN.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> JUJUTSU_ADDON = REGISTRY.register("jujutsu_addon",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_addon")).icon(() -> new ItemStack(JujutsucraftaddonModItems.EVIDENCE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.RACE_CHANGER.get());
				tabData.accept(JujutsucraftaddonModItems.STEEL_ARM.get());
				tabData.accept(JujutsucraftaddonModItems.CLAN_CHANGER.get());
				tabData.accept(JujutsucraftaddonModItems.CELLPHONE.get());
				tabData.accept(JujutsucraftaddonModItems.ITADORI_DRINKS.get());
				tabData.accept(JujutsucraftaddonModItems.KENJAKU_BALL.get());
				tabData.accept(JujutsucraftaddonModItems.JUJUTSU_COIN.get());
				tabData.accept(JujutsucraftaddonModBlocks.NO_DOMAIN.get().asItem());
				tabData.accept(JujutsucraftaddonModItems.CURSED_WOMB.get());
				tabData.accept(JujutsucraftaddonModItems.VIBRASLAP.get());
				tabData.accept(JujutsucraftaddonModBlocks.VEIL_BLOCK.get().asItem());
				tabData.accept(JujutsucraftaddonModItems.KOGANE_POINTS.get());
				tabData.accept(JujutsucraftaddonModItems.TENGEN.get());
				tabData.accept(JujutsucraftaddonModItems.TRAIT_RECOMMENDATION.get());
				tabData.accept(JujutsucraftaddonModItems.MOB_TAMER.get());
				tabData.accept(JujutsucraftaddonModItems.YUTA_RING.get());
				tabData.accept(JujutsucraftaddonModItems.VEIL_TALISMAN.get());
				tabData.accept(JujutsucraftaddonModItems.ITEM_DOMAIN_SIZE_SET.get());
				tabData.accept(JujutsucraftaddonModItems.NUH_UH_1.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> JUJUTSU_SCROLLS = REGISTRY.register("jujutsu_scrolls",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.jujutsucraftaddon.jujutsu_scrolls")).icon(() -> new ItemStack(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(JujutsucraftaddonModItems.SIMPLE_DOMAIN_SCROLL.get());
				tabData.accept(JujutsucraftaddonModItems.HEALTH_SCROLL.get());
				tabData.accept(JujutsucraftaddonModItems.KOKUSEN_SCROLL.get());
				tabData.accept(JujutsucraftaddonModItems.REVERSE_LEVEL_SCROLL.get());
				tabData.accept(JujutsucraftaddonModItems.CURSED_POWER_LEVEL_SCROLL.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(JujutsucraftaddonModItems.TESTING_VERSION_SPAWN_EGG.get());
			tabData.accept(JujutsucraftaddonModItems.YE_SPAWN_EGG.get());
		}
	}
}
