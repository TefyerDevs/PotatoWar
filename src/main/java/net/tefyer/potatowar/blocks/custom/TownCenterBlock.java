package net.tefyer.potatowar.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.tefyer.api.block.ITownCenter;
import net.tefyer.potatowar.blocks.BlockRegistry;
import net.tefyer.potatowar.blocks.custom.blockentities.TownCenterBlockEntity;
import org.jetbrains.annotations.Nullable;

public class TownCenterBlock extends BaseEntityBlock implements ITownCenter {
    public TownCenterBlock() {
        super(BlockBehaviour.Properties.of());
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return BlockRegistry.TOWN_CENTER_BE.get().create(pPos,pState);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
                                                                            BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType,BlockRegistry.TOWN_CENTER_BE.get(), TownCenterBlockEntity::tick);
    }
}
