
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.potatowar.client.model.ModelTownCenter;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PotatowarModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelTownCenter.LAYER_LOCATION, ModelTownCenter::createBodyLayer);
	}
}
