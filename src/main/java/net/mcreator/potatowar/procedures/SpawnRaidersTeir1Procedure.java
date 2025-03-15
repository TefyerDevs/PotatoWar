package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.potatowar.init.PotatowarModEntities;

public class SpawnRaidersTeir1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 8); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_MILITARY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 10); index1++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_MILITA.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 1, 15); index2++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_SCOUT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 2); index3++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_KNIGHT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = PotatowarModEntities.RAID_LEADER.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}
