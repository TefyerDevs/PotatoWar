package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.potatowar.network.PotatowarModVariables;

public class SheildsProcedure {
	public static void execute(LevelAccessor world) {
		PotatowarModVariables.WorldVariables.get(world).BossShield = 2;
		PotatowarModVariables.WorldVariables.get(world).syncData(world);
	}
}
