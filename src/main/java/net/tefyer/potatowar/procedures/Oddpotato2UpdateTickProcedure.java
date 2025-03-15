package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.init.PotatowarModBlocks;

public class Oddpotato2UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.041667) {
			world.setBlock(BlockPos.containing(x, y, z), PotatowarModBlocks.ODDPOTATO_3.get().defaultBlockState(), 3);
		}
	}
}
