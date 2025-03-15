package net.tefyer.potatowar.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class SetItemsHumanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		ItemStack questItem1 = ItemStack.EMPTY;
		ItemStack QuestItem2 = ItemStack.EMPTY;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 4);
		entity.getPersistentData().putDouble("potatoWar:FactionID", 2);
		if (RandomNum >= 4) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 1);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 20, 60)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 1, 7)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 3) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 2);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 2)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 2, 6)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 2, 9)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 2, 5)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 2) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 3);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 10, 20)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 15, 50)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 5, 15)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 2, 9)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 1) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 4);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 2)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 5, 8)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 25, 50)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 2, 4)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 3, 12)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		}
	}
}
