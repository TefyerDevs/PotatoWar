package net.tefyer.potatowar.api.deferredregister;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockDeferredRegister implements IDeferredRegister {
    public final DeferredRegister<Item> ITEMS;
    public final DeferredRegister<Block> BlOCKS;

    public BlockDeferredRegister(String id) {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
        BlOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, id);
    }

    public <T extends Block>RegistryObject<T> register(String id, Supplier<T> block){
        return BlOCKS.register(id,block);
    }

    @Override
    public void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
        BlOCKS.register(modEventBus);
    }
}
