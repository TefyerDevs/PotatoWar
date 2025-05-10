package net.tefyer.potatowar.blocks;

import net.minecraftforge.eventbus.api.IEventBus;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.api.deferredregister.BlockDeferredRegister;

public class BlockRegistry {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(PotatowarMod.MODID);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    public static void registerBlocks(IEventBus modEventBus) {


        // register blocks here:


        register(modEventBus);
        // ^ cannot add new block after this
    }
}
