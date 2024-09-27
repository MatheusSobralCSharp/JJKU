
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.jujutsucraftaddon.fluid.YokuFluid;
import net.mcreator.jujutsucraftaddon.JujutsucraftaddonMod;

public class JujutsucraftaddonModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, JujutsucraftaddonMod.MODID);
	public static final RegistryObject<FlowingFluid> YOKU = REGISTRY.register("yoku", () -> new YokuFluid.Source());
	public static final RegistryObject<FlowingFluid> FLOWING_YOKU = REGISTRY.register("flowing_yoku", () -> new YokuFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(YOKU.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_YOKU.get(), RenderType.translucent());
		}
	}
}
