package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.init.PotatowarModBlocks;

public class OddPotatoPlantStg1UpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.041667) {
			world.setBlock(BlockPos.containing(x, y, z), PotatowarModBlocks.ODDPOTATO_3.get().defaultBlockState(), 3);
		}
	}
}
