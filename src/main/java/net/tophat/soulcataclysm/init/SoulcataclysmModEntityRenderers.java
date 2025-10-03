
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tophat.soulcataclysm.init;

import net.tophat.soulcataclysm.client.renderer.SoulInfectorRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SoulcataclysmModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SoulcataclysmModEntities.SOUL_INFECTOR.get(), SoulInfectorRenderer::new);
	}
}
