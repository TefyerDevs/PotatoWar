package net.mcreator.potatowar.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class HumanTrainerSetNBTProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 5);
		entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 10, 64)));
		entity.getPersistentData().putDouble("potatoWar:FactionID", 2);
		if (RandomNum >= 5) {
			entity.getPersistentData().putDouble("potatowar:KitID", 5);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 2, 5)));
		} else if (RandomNum >= 4) {
			entity.getPersistentData().putDouble("potatowar:KitID", 4);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 5, 10)));
		} else if (RandomNum >= 3) {
			entity.getPersistentData().putDouble("potatowar:KitID", 3);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 15, 30)));
		} else if (RandomNum >= 2) {
			entity.getPersistentData().putDouble("potatowar:KitID", 2);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 5, 10)));
		} else if (RandomNum >= 1) {
			entity.getPersistentData().putDouble("potatowar:KitID", 1);
			entity.getPersistentData().putDouble("potatowar:KitPrice", (Mth.nextInt(RandomSource.create(), 30, 45)));
		}
	}
}
