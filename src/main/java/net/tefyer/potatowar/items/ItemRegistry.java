package net.tefyer.potatowar.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.api.deferredregister.ItemDeferredRegister;
import net.tefyer.api.item.kit.KitType;
import net.tefyer.potatowar.items.custom.KitItem;

public class ItemRegistry {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(PotatowarMod.MODID);


    public static final RegistryObject<Item> BLACK_JADE = ITEMS.register("black_jade",()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",()-> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHEST_MALITIA_MARKER = ITEMS.register("chest_malitia_marker",
            ChestMalitiaMarker::new);

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
