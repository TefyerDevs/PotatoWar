package net.tefyer.potatowar.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class AbandonQuestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasQuest = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.getPersistentData().putDouble("potatowar:CivilianID", 0);
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
