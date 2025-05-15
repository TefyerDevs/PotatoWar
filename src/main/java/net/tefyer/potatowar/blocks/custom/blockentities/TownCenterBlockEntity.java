package net.tefyer.potatowar.blocks.custom.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.tefyer.api.block.blockentities.ITownCenterBlockEntity;
import net.tefyer.potatowar.blocks.BlockRegistry;

public class TownCenterBlockEntity extends BlockEntity implements ITownCenterBlockEntity {
    public TownCenterBlockEntity( BlockPos pPos, BlockState pBlockState) {
        super(BlockRegistry.TOWN_CENTER_BE.get(), pPos, pBlockState);
    }

    @Override
    public static void tick(Level level, BlockPos pos, BlockState state,
                            TownCenterBlockEntity townCenterBlockEntity) {

    }
}
