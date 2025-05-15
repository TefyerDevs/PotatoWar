package net.tefyer.api.block.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tefyer.potatowar.blocks.custom.blockentities.TownCenterBlockEntity;

public interface ITownCenterBlockEntity {
    void tick(Level level, BlockPos pos, BlockState state, TownCenterBlockEntity townCenterBlockEntity);
}
