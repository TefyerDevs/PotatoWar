package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class ProtoDefenderEntityDiesProcedure {
	public static void execute(LevelAccessor world) {
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Generator Destroyed"), false);
		PotatowarModVariables.WorldVariables.get(world).BossShield = PotatowarModVariables.WorldVariables.get(world).BossShield - 1;
		PotatowarModVariables.WorldVariables.get(world).syncData(world);
	}
}
