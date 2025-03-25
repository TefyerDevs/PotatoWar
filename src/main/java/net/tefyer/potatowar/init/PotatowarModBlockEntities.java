package net.tefyer.potatowar.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.block.CompresserBlock;
import net.tefyer.potatowar.block.entity.CompresserBlockEntity;

public class PotatowarModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PotatowarMod.MODID);

    public static final RegistryObject<BlockEntityType<CompresserBlockEntity>> COMPRESSER_BE =
            REGISTRY.register("compresser_be",()-> BlockEntityType.Builder.of(CompresserBlockEntity::new, PotatowarModBlocks.COMPRESSER_BLOCK.get())
                    .build(null));

}
