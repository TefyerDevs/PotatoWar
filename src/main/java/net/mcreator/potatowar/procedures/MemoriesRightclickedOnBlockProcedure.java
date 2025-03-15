package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.block.ForgottenWorldsPortalBlock;

public class MemoriesRightclickedOnBlockProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Direction direction) {
		if (direction == null)
			return InteractionResult.PASS;
		double portalX = 0;
		double portalY = 0;
		double portalZ = 0;
		portalX = x + direction.getStepX();
		portalY = y + direction.getStepY();
		portalZ = z + direction.getStepZ();
		if (world.isEmptyBlock(BlockPos.containing(portalX, portalY, portalZ))) {
			if (world instanceof Level _level)
				ForgottenWorldsPortalBlock.portalSpawn(_level, BlockPos.containing(portalX, portalY, portalZ));
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.FAIL;
	}
}
