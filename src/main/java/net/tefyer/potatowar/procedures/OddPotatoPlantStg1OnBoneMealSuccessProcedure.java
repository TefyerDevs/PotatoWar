package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.init.PotatowarModBlocks;

public class OddPotatoPlantStg1OnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), PotatowarModBlocks.ODDPOTATO_2.get().defaultBlockState(), 3);
	}
}
