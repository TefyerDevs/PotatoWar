package net.tefyer.potatowar.items;

import net.minecraftforge.eventbus.api.IEventBus;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.api.deferredregister.ItemDeferredRegister;
import net.tefyer.potatowar.api.item.kit.KitType;
import net.tefyer.potatowar.items.custom.KitItem;

public class ItemRegistry {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(PotatowarMod.MODID);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    public static void registerItems(IEventBus modEventBus) {

        // register items here:

        for (KitType value : KitType.values()) {
            ITEMS.registerKit(value.toString(),() -> new KitItem(value));
        }

        register(modEventBus);
        // ^ cannot add new items after this
    }

}
