package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.potatowar.network.PotatowarModVariables;

public class RaidLocationProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Raid location is: " + ("X: " + (PotatowarModVariables.MapVariables.get(world).RaidX + "" + (" Z: " + PotatowarModVariables.MapVariables.get(world).RaidZ))))), false);
	}
}
