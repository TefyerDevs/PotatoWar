package net.tefyer.potatowar.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LogBuildingBlock extends ModFlammableRotatedPillarBlock {

    public LogBuildingBlock() {
        super(Properties.copy(Blocks.OAK_LOG));
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
