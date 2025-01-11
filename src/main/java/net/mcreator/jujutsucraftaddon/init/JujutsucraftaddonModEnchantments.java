
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.jujutsucraftaddon.enchantment.UltraInstinctEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.GodOfDestructionEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.FullCounterEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.CEVisionEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.CEStealingEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.CEInfusionEnchantment;
import net.mcreator.jujutsucraftaddon.enchantment.CEHealthRegenerationEnchantment;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<Enchantment> CE_INFUSION = REGISTRY.register("ce_infusion", () -> new CEInfusionEnchantment());
	public static final RegistryObject<Enchantment> CE_HEALTH_REGENERATION = REGISTRY.register("ce_health_regeneration", () -> new CEHealthRegenerationEnchantment());
	public static final RegistryObject<Enchantment> CE_STEALING = REGISTRY.register("ce_stealing", () -> new CEStealingEnchantment());
	public static final RegistryObject<Enchantment> CE_VISION = REGISTRY.register("ce_vision", () -> new CEVisionEnchantment());
	public static final RegistryObject<Enchantment> FULL_COUNTER = REGISTRY.register("full_counter", () -> new FullCounterEnchantment());
	public static final RegistryObject<Enchantment> GOD_OF_DESTRUCTION = REGISTRY.register("god_of_destruction", () -> new GodOfDestructionEnchantment());
	public static final RegistryObject<Enchantment> ULTRA_INSTINCT = REGISTRY.register("ultra_instinct", () -> new UltraInstinctEnchantment());
}
