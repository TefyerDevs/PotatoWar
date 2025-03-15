package net.tefyer.potatowar.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class ChangerepupProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation + 50;
			entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PotatoReputation = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("Reputation Up"), false);
	}
}
