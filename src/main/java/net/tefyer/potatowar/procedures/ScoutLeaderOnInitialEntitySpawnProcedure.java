package net.tefyer.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.init.PotatowarModEntities;

import java.util.List;
import java.util.Comparator;

public class ScoutLeaderOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ScoutCount = 0;
		entity.getPersistentData().putDouble("potatowar:LeaderID", (Mth.nextDouble(RandomSource.create(), 1, 1000)));
		for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 10); index0++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_SCOUT.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 5); index1++) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.HUMAN_MILITARY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) && !(entityiterator == entity)) {
					entityiterator.getPersistentData().putDouble("potatowar:LeaderID", (entity.getPersistentData().getDouble("potatowar:LeaderID")));
					ScoutCount = ScoutCount + 1;
				}
			}
		}
		if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))) {
			entity.getPersistentData().putDouble("potatowar:LeaderID", (entity.getPersistentData().getDouble("potatowar:LeaderID")));
			ScoutCount = ScoutCount + 1;
		}
	}
}
