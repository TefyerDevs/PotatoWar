package net.tefyer.potatowar.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tefyer.potatowar.init.PotatowarModBlockEntities;

public class CompresserBlockEntity extends BlockEntity {
    public CompresserBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(PotatowarModBlockEntities.COMPRESSER_BE.get(), pPos, pBlockState);
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {

    }
}
