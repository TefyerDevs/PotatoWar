package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.init.PotatowarModBlocks;

public class Oddpotato3OnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), PotatowarModBlocks.ODDPOTATO_4.get().defaultBlockState(), 3);
	}
}
