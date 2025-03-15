package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.potatowar.network.PotatowarModVariables;

public class NodigiworldProcedure {
	public static void execute(LevelAccessor world) {
		PotatowarModVariables.MapVariables.get(world).DigiArenaSpawned = false;
		PotatowarModVariables.MapVariables.get(world).syncData(world);
	}
}
