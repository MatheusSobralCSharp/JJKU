
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.jujutsucraftaddon.block.VeilBlockBlock;
import net.mcreator.jujutsucraftaddon.block.NoDomainBlock;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<Block> NO_DOMAIN = REGISTRY.register("no_domain", () -> new NoDomainBlock());
	public static final RegistryObject<Block> VEIL_BLOCK = REGISTRY.register("veil_block", () -> new VeilBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
