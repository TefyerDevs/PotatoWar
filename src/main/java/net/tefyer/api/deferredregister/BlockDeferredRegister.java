package net.tefyer.api.deferredregister;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockDeferredRegister implements IDeferredRegister {
    public final DeferredRegister<Item> ITEMS;
    public final DeferredRegister<Block> BlOCKS;
    public final DeferredRegister<BlockEntityType<?>> BlOCK_ENTITIES;

    public BlockDeferredRegister(String id) {
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, id);
        BlOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, id);
        BlOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, id);
    }

    public <T extends Block>RegistryObject<T> registerBlock(String id, Supplier<T> block){
        return BlOCKS.register(id,block);
    }
    public <T extends BlockEntityType<?>>RegistryObject<T> registerBlockEntity(String id, Supplier<T> block){
        return BlOCK_ENTITIES.register(id,block);
    }

    @Override
    public void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
        BlOCKS.register(modEventBus);
        BlOCK_ENTITIES.register(modEventBus);
    }
}
