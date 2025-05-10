package net.tefyer.potatowar.client.entity;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tefyer.potatowar.client.entity.custom.PotatoManRenderer;
import net.tefyer.potatowar.entity.EntityRegistry;
import net.tefyer.potatowar.entity.custom.PotatoManEntity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EntityRender {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {

        event.registerEntityRenderer(EntityRegistry.POTATO_MAN.get(), PotatoManRenderer::new);
    }
}
