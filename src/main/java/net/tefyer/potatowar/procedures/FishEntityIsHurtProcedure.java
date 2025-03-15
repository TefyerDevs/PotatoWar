package net.tefyer.potatowar.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class FishEntityIsHurtProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double Attack = 0;
		Attack = Mth.nextInt(RandomSource.create(), 1, 1);
		if (Attack == 1) {
			{
				Entity _ent = entity;
				_ent.teleportTo(((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerX),
						((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerY + 20),
						((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerZ));
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerX),
							((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerY + 20),
							((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PlayerZ), _ent.getYRot(), _ent.getXRot());
			}
		}
	}
}
