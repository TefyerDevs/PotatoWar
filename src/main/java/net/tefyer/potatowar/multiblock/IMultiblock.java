package net.tefyer.potatowar.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public interface IMultiblock {


    // runs a for loop over a list to check if the multiblock is in the world.
    boolean checkMultiblock(LevelAccessor world, BlockPos pos);
    boolean checkMultiblock(LevelAccessor world, int x, int y, int z);

    // gets the block data.
    Map<BlockPos, Block> getBlockData();

    // replace all the blocks with a specific block
    public boolean replaceBlocks(LevelAccessor world, BlockPos pos);
    public boolean replaceBlocks(LevelAccessor world, int x, int y, int z);

    // adds the offset position and the block type to a list.
    <T extends Block> boolean addBlockData(BlockPos pos, T block);
    <T extends Block> boolean addBlockData(int x, int y, int z, T block);
}
