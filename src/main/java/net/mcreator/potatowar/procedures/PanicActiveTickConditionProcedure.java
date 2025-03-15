package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.potatowar.PotatowarMod;

public class PanicActiveTickConditionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:PanicCooldown")) {
			if (entity instanceof Mob _entity)
				_entity.getNavigation().moveTo((x + Mth.nextInt(RandomSource.create(), 1, 5)), y, (z + Mth.nextInt(RandomSource.create(), 1, 5)), 1.5);
			entity.getPersistentData().putBoolean("potatowar:PanicCooldown", false);
			PotatowarMod.queueServerWork(100, () -> {
				entity.getPersistentData().putBoolean("potatowar:PanicCooldown", true);
			});
		}
	}
}
