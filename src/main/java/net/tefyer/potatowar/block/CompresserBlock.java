package net.tefyer.potatowar.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.tefyer.potatowar.init.PotatowarModBlockEntities;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompresserBlock extends BaseEntityBlock {
    public CompresserBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return PotatowarModBlockEntities.COMPRESSER_BE.get().create(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, @NotNull BlockState pState, @NotNull BlockEntityType<T> pType) {
        if(pLevel.isClientSide()){
            return null;
        }
        return createTickerHelper(pType, PotatowarModBlockEntities.COMPRESSER_BE.get(),
                (pLevel1,pPos,pState1,pBlockEntity)->pBlockEntity.tick(pLevel1,pPos,pState1));
    }
}
