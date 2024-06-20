
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.jujutsucraftaddon.world.inventory.YutaStorageMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.WorldSkillMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.TestrMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.StorageArmoryMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.RaceChangeMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.KoganeUIMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.KenjakuBodySwapMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.EvidenceGUIMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.CursedEnergySelectorMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.ClanChangeMenu;
import net.mcreator.jujutsucraftaddon.world.inventory.CTChangerMenu;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<MenuType<EvidenceGUIMenu>> EVIDENCE_GUI = REGISTRY.register("evidence_gui", () -> IForgeMenuType.create(EvidenceGUIMenu::new));
	public static final RegistryObject<MenuType<RaceChangeMenu>> RACE_CHANGE = REGISTRY.register("race_change", () -> IForgeMenuType.create(RaceChangeMenu::new));
	public static final RegistryObject<MenuType<YutaStorageMenu>> YUTA_STORAGE = REGISTRY.register("yuta_storage", () -> IForgeMenuType.create(YutaStorageMenu::new));
	public static final RegistryObject<MenuType<StorageArmoryMenu>> STORAGE_ARMORY = REGISTRY.register("storage_armory", () -> IForgeMenuType.create(StorageArmoryMenu::new));
	public static final RegistryObject<MenuType<ClanChangeMenu>> CLAN_CHANGE = REGISTRY.register("clan_change", () -> IForgeMenuType.create(ClanChangeMenu::new));
	public static final RegistryObject<MenuType<TestrMenu>> TESTR = REGISTRY.register("testr", () -> IForgeMenuType.create(TestrMenu::new));
	public static final RegistryObject<MenuType<WorldSkillMenu>> WORLD_SKILL = REGISTRY.register("world_skill", () -> IForgeMenuType.create(WorldSkillMenu::new));
	public static final RegistryObject<MenuType<CTChangerMenu>> CT_CHANGER = REGISTRY.register("ct_changer", () -> IForgeMenuType.create(CTChangerMenu::new));
	public static final RegistryObject<MenuType<KenjakuBodySwapMenu>> KENJAKU_BODY_SWAP = REGISTRY.register("kenjaku_body_swap", () -> IForgeMenuType.create(KenjakuBodySwapMenu::new));
	public static final RegistryObject<MenuType<KoganeUIMenu>> KOGANE_UI = REGISTRY.register("kogane_ui", () -> IForgeMenuType.create(KoganeUIMenu::new));
	public static final RegistryObject<MenuType<CursedEnergySelectorMenu>> CURSED_ENERGY_SELECTOR = REGISTRY.register("cursed_energy_selector", () -> IForgeMenuType.create(CursedEnergySelectorMenu::new));
}
