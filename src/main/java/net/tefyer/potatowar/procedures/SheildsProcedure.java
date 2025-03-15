package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class SheildsProcedure {
	public static void execute(LevelAccessor world) {
		PotatowarModVariables.WorldVariables.get(world).BossShield = 2;
		PotatowarModVariables.WorldVariables.get(world).syncData(world);
	}
}
