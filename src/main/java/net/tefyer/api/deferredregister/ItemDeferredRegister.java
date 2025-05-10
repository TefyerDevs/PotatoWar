package net.tefyer.api.deferredregister;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ItemDeferredRegister implements IDeferredRegister{
    public final DeferredRegister<Item> ITEMS;

    public final List<RegistryObject<Item>> KITS = new ArrayList<>();
    public final List<RegistryObject<Item>> ITEMS_LIST = new ArrayList<>();

    public ItemDeferredRegister(String id) {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
    }

    public <T extends Item> RegistryObject<T> register(String id, Supplier<T> items){
        return addToItemList(ITEMS.register(id,items));
    }

    public <T extends Item> RegistryObject<T> registerKit(String id, Supplier<T> items){
        return addToKitList(register(id,items));
    }

    private <T extends Item> RegistryObject<T> addToKitList(RegistryObject<T> item) {
        KITS.add((RegistryObject<Item>) item);
        return item;
    }
    private <T extends Item> RegistryObject<T> addToItemList(RegistryObject<T> item) {
        ITEMS_LIST.add((RegistryObject<Item>) item);
        return item;
    }

    @Override
    public void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
    }
}
