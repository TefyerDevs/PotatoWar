package net.tefyer.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.tefyer.potatowar.network.PotatowarModVariables;

import java.util.List;
import java.util.Comparator;

public class TownCenterUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		double RaidSpawnX = 0;
		double RaidSpawnZ = 0;
		double Cooldown = 0;
		if (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") <= 0 && entity.getPersistentData().getBoolean("potatowar:RaidActive") == false && entity.getPersistentData().getBoolean("potatowar:RaidCooldown") == false) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))) && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
						entity.getPersistentData().putDouble("potatowar:TownPoints", (entity.getPersistentData().getDouble("potatowar:TownPoints") + Mth.nextInt(RandomSource.create(), 1, 3)));
					} else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato")))
							&& !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
						entity.getPersistentData().putDouble("potatowar:TownPoints", (entity.getPersistentData().getDouble("potatowar:TownPoints") + Mth.nextInt(RandomSource.create(), 3, 5)));
					}
				}
			}
			entity.getPersistentData().putDouble("potatowar:TownCenterCheckCooldown", 100);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Raid score is: " + entity.getPersistentData().getDouble("potatowar:TownPoints"))), false);
			if (entity.getPersistentData().getDouble("potatowar:TownPoints") >= 200) {
				entity.getPersistentData().putDouble("potatowar:TownPoints", 0);
				RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
				if (RandomNum == 1) {
					RaidSpawnX = entity.getX() + 48;
				} else {
					RaidSpawnX = entity.getX() - 48;
				}
				RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
				if (RandomNum == 1) {
					RaidSpawnZ = entity.getZ() + 48;
				} else {
					RaidSpawnZ = entity.getZ() - 48;
				}
				PotatowarModVariables.MapVariables.get(world).RaidX = entity.getX();
				PotatowarModVariables.MapVariables.get(world).syncData(world);
				PotatowarModVariables.MapVariables.get(world).RaidZ = entity.getZ();
				PotatowarModVariables.MapVariables.get(world).syncData(world);
				SpawnRaidersTeir1Procedure.execute(world, RaidSpawnX, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), RaidSpawnZ);
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
							if (entityiterator instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal("A raid is happening!"), false);
							entity.getPersistentData().putBoolean("potatowar:RaidActive", true);
						}
					}
				}
			}
		} else if (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") > 0) {
			entity.getPersistentData().putDouble("potatowar:TownCenterCheckCooldown", (entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown") - 1));
		}
	}
}
