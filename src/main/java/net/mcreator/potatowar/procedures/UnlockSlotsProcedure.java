package net.mcreator.potatowar.procedures;

import net.minecraft.world.entity.Entity;

public class UnlockSlotsProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getBoolean("potatoWar:SlotsLocked") == true;
	}
}
