package net.tefyer.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.entity.PotatoOutlawEntity;

import java.util.Comparator;

public class ShowAssassinProcedure {
	public static Entity execute(LevelAccessor world, double x, double y, double z) {
		return (Entity) world.getEntitiesOfClass(PotatoOutlawEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf(x, y, z)).findFirst().orElse(null);
	}
}
