package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class BuildersFatiugeActiveTickConditionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _player)
			_player.setGameMode(GameType.ADVENTURE);
	}
}
