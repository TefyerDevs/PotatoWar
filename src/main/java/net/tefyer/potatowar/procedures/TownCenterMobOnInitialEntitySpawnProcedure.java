package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.tefyer.potatowar.network.PotatowarModVariables;

public class TownCenterMobOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("potatowar:TownName", TownNameProcedure.execute(world, x, y, z, entity));
		entity.getPersistentData().putString("potatowar:CreatorName", PotatowarModVariables.PlayerName);
		if (!world.isClientSide() && world.getServer() != null)
			world.getServer().getPlayerList().broadcastSystemMessage(Component.literal((entity.getPersistentData().getString("potatowar:CreatorName") + "" + ("Founded the town of " + entity.getPersistentData().getString("potatowar:TownName")))),
					false);
	}
}
