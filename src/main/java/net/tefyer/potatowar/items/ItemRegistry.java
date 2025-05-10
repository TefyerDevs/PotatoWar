package net.tefyer.potatowar.items;

import net.minecraftforge.eventbus.api.IEventBus;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.api.deferredregister.ItemDeferredRegister;

public class ItemRegistry {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(PotatowarMod.MODID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static void registerItems(IEventBus modEventBus) {

        // register items here:

        register(modEventBus);
        // ^ cannot add new items after this
    }

}
