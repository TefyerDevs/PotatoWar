package net.tefyer.potatowar.blocks;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.api.deferredregister.BlockDeferredRegister;
import net.tefyer.potatowar.blocks.custom.TownCenterBlock;
import net.tefyer.potatowar.blocks.custom.blockentities.TownCenterBlockEntity;

public class BlockRegistry {
    public static final BlockDeferredRegister BLOCKS = new BlockDeferredRegister(PotatowarMod.MODID);

    public static final RegistryObject<Block> TOWN_CENTER = BLOCKS.registerBlock("town_center", TownCenterBlock::new);
    public static final RegistryObject<BlockEntityType<TownCenterBlockEntity>> TOWN_CENTER_BE =
            BLOCKS.registerBlockEntity("town_center_be", ()-> BlockEntityType.Builder.of(TownCenterBlockEntity::new,TOWN_CENTER.get())
                    .build(null));


    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }

    public static void registerBlocks(IEventBus modEventBus) {


        // register blocks here:


        register(modEventBus);
        // ^ cannot add new block after this
    }
}
