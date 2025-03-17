package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class EntityUtils {
	public static boolean canSeSky(LevelAccessor world, double x, double y, double z) {
		return world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z));
	}
}
