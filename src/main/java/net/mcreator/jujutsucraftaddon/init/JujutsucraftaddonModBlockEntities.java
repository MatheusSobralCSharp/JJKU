
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.jujutsucraftaddon.block.entity.VeilBlockBlockEntity;
import net.mcreator.jujutsucraftaddon.block.entity.SnowDomainBlockEntity;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> VEIL_BLOCK = register("veil_block", JujutsucraftaddonModBlocks.VEIL_BLOCK, VeilBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SNOW_DOMAIN = register("snow_domain", JujutsucraftaddonModBlocks.SNOW_DOMAIN, SnowDomainBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
