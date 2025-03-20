package net.tefyer.potatowar.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.tefyer.potatowar.init.PotatowarModBlocks;

import java.util.HashMap;
import java.util.Map;

public class Multiblock implements IMultiblock{
    Map<BlockPos, Block> blocks = new HashMap<>();

    public Block replaceBlock;

    public Multiblock(Block replaceBlock) {
        this.replaceBlock = replaceBlock;
    }
    public Multiblock() {}

    @Override
    public boolean checkMultiblock(LevelAccessor world, BlockPos pos) {
        for(Map.Entry<BlockPos, Block> entry: blocks.entrySet()){
            BlockPos checkPos = new BlockPos(entry.getKey().getX() + pos.getX(),
                    entry.getKey().getY() + pos.getY(),
                    entry.getKey().getZ() + pos.getZ());

            if(world.getBlockState(checkPos).getBlock() != entry.getValue()){
                 return false;
             }
        }

        return true;
    }

    public boolean checkMultiblock(LevelAccessor world, int x, int y, int z) {
        return checkMultiblock(world, new BlockPos(x,y,z));
    }

    public boolean replaceBlocks(LevelAccessor world, int x, int y, int z){
        return replaceBlocks(world, new BlockPos(x,y,z));
    }
    public boolean replaceBlocks(LevelAccessor world, BlockPos pos){
        if(replaceBlock == null)
            return false;

        for(Map.Entry<BlockPos, Block> entry: blocks.entrySet()){
            BlockPos checkPos = new BlockPos(entry.getKey().getX() + pos.getX(),
                    entry.getKey().getY() + pos.getY(),
                    entry.getKey().getZ() + pos.getZ());


            world.setBlock(BlockPos.containing(checkPos.getX() , checkPos.getY(), checkPos.getZ()), replaceBlock.defaultBlockState(), 3);
        }
        return true;
    }

    @Override
    public Map<BlockPos, Block> getBlockData() {
        return blocks;
    }
    public <T extends Block> boolean addBlockData(int x, int y, int z, T block) {
        return addBlockData(new BlockPos(x,y,z),block);
    }

    @Override
    public <T extends Block> boolean addBlockData(BlockPos pos, T block) {
        if(blocks.containsKey(pos) && blocks.get(pos) != null)
            return false;
        blocks.put(pos,block);
        return true;
    }
}
