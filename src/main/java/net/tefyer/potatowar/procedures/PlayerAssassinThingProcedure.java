package net.tefyer.potatowar.procedures;

import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class PlayerAssassinThingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return " " + (entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).AssassinThing;
	}
}
