
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jujutsucraftaddon.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.jujutsucraftaddon.client.model.Modelinventory_curse;
import net.mcreator.jujutsucraftaddon.client.model.Modelarmor3;
import net.mcreator.jujutsucraftaddon.client.model.ModelSatushi;
import net.mcreator.jujutsucraftaddon.client.model.ModelCiclo2;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JujutsucraftaddonModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSatushi.LAYER_LOCATION, ModelSatushi::createBodyLayer);
		event.registerLayerDefinition(Modelinventory_curse.LAYER_LOCATION, Modelinventory_curse::createBodyLayer);
		event.registerLayerDefinition(ModelCiclo2.LAYER_LOCATION, ModelCiclo2::createBodyLayer);
		event.registerLayerDefinition(Modelarmor3.LAYER_LOCATION, Modelarmor3::createBodyLayer);
	}
}
