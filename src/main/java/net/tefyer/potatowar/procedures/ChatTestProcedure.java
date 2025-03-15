package net.tefyer.potatowar.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class ChatTestProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Assassin Name: " + (entity.getPersistentData().getString("potatowar:AssassinName") + "" + ("Assassin Thing: " + entity.getPersistentData().getString("potatowar:AssassinThing"))))), false);
	}
}
