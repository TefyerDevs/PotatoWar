package net.tefyer.potatowar.multiblock.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;

public class MultiBlockUtils {

    public static void replaceBlockAtOffset(LevelAccessor world, BlockPos basePos, BlockPos offsetPos, Block blockType){
        BlockPos checkPos = new BlockPos(basePos.getX() + offsetPos.getX(),
                basePos.getY() + offsetPos.getY(),
                basePos.getZ() + offsetPos.getZ());


        world.setBlock(BlockPos.containing(checkPos.getX() , checkPos.getY(), checkPos.getZ()), blockType.defaultBlockState(), 3);
    }
}
