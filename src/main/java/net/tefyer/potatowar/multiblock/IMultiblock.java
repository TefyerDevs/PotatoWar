package net.tefyer.potatowar.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

import java.util.Map;

public interface IMultiblock {

    boolean checkMultiblock(LevelAccessor world, BlockPos pos);

    Map<BlockPos, Block> getBlockData();

    <T extends Block> boolean addBlockData(BlockPos pos, T block);
}
