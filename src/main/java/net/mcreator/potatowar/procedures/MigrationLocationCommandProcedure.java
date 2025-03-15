package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.potatowar.network.PotatowarModVariables;

public class MigrationLocationCommandProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList()
					.broadcastSystemMessage(Component.literal(("MigrationX: " + (PotatowarModVariables.WorldVariables.get(world).MigrationX + "" + ("MigrationZ: " + PotatowarModVariables.WorldVariables.get(world).MigrationZ)))), false);
	}
}
