
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.mcreator.jujutsucraftaddon.fluid.types.YokuFluidType;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<FluidType> YOKU_TYPE = REGISTRY.register("yoku", () -> new YokuFluidType());
}
