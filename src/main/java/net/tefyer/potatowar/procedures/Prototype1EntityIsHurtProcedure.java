package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.init.PotatowarModEntities;

public class Prototype1EntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:SheildsDeployed") == false && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < 75) {
			entity.getPersistentData().putBoolean("potatowar:SheildsDeployed", true);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.PROTO_DEFENDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.PROTO_DEFENDER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("You thought it was going to be this easy to defeat me?"), false);
		}
	}
}
