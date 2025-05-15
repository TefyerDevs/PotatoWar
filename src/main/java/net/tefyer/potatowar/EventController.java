package net.tefyer.potatowar;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tefyer.api.entity.utils.EntityUtils;

@Mod.EventBusSubscriber(modid=PotatowarMod.MODID)
public class EventController {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            EntityUtils.generateQuest(event.player);
        }
    }

}
