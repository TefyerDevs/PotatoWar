package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.entity.TownCenterMobEntity;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class RaiderAIProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:OutsideRaidPosition") == true && entity.getPersistentData().getBoolean("potatowar:Raider") == true) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo(PotatowarModVariables.MapVariables.get(world).RaidX, y, PotatowarModVariables.MapVariables.get(world).RaidZ, 1.2);
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof TownCenterMobEntity) {
						entity.getPersistentData().putBoolean("potatowar:OutsideRaidPosition", false);
						entityiterator.getPersistentData().putBoolean("potatowar:RaidActive", false);
					}
				}
			}
		}
	}
}
