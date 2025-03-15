package net.mcreator.potatowar.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;

import net.mcreator.potatowar.entity.TownCenterMobEntity;

import java.util.List;
import java.util.Comparator;

public class SetItemsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double RandomNum = 0;
		ItemStack questItem1 = ItemStack.EMPTY;
		ItemStack QuestItem2 = ItemStack.EMPTY;
		RandomNum = Mth.nextInt(RandomSource.create(), 1, 5);
		entity.getPersistentData().putDouble("potatoWar:FactionID", 1);
		entity.getPersistentData().putBoolean("potatowar:AssassinQuest", false);
		entity.getPersistentData().putDouble("potatowar:CivilianID", (Mth.nextDouble(RandomSource.create(), 1, 1000)));
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof TownCenterMobEntity) {
					entity.getPersistentData().putDouble("HomeX", (entityiterator.getX()));
					entity.getPersistentData().putDouble("HomeZ", (entityiterator.getZ()));
					if (entityiterator instanceof Player || entityiterator instanceof ServerPlayer) {
						if (entityiterator instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(("Home location set: " + ("X " + (entity.getPersistentData().getDouble("HomeX") + "" + ("Z " + entity.getPersistentData().getDouble("HomeZ")))))), false);
					}
				}
			}
		}
		if (RandomNum >= 5) {
			entity.getPersistentData().putBoolean("potatowar:AssassinQuest", true);
			entity.getPersistentData().putString("potatowar:AssassinName", AssassinNameProcedure.execute());
			entity.getPersistentData().putString("potatowar:AssassinThing", AssassinThingProcedure.execute());
			RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
			if (RandomNum == 1) {
				entity.getPersistentData().putDouble("potatowar:AssassinX", (entity.getX() + 100 + Mth.nextInt(RandomSource.create(), 1, 500)));
			} else {
				entity.getPersistentData().putDouble("potatowar:AssassinX", ((entity.getX() - 100) - Mth.nextInt(RandomSource.create(), 1, 500)));
			}
			RandomNum = Mth.nextInt(RandomSource.create(), 1, 2);
			if (RandomNum == 1) {
				entity.getPersistentData().putDouble("potatowar:AssassinZ", (entity.getZ() + 100 + Mth.nextInt(RandomSource.create(), 1, 500)));
			} else {
				entity.getPersistentData().putDouble("potatowar:AssassinZ", ((entity.getZ() - 100) - Mth.nextInt(RandomSource.create(), 1, 500)));
			}
		} else if (RandomNum >= 4) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 1);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 10, 60)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 3, 7)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 1, 7)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 10, 30)));
			entity.getPersistentData().putDouble("PotatoWar:CivilianID", (Mth.nextDouble(RandomSource.create(), 0, 1000)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		} else if (RandomNum >= 3) {
			entity.getPersistentData().putDouble("potatoWar:QuestNum", 2);
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 2)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 3)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 3, 10)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 3, 8)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", 1);
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 5, 12)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 3, 8)));
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
			entity.getPersistentData().putDouble("potatoWar:ItemType1", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType2", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:ItemType3", (Mth.nextInt(RandomSource.create(), 1, 4)));
			entity.getPersistentData().putDouble("potatoWar:itemcount1", (Mth.nextInt(RandomSource.create(), 5, 20)));
			entity.getPersistentData().putDouble("potatoWar:itemcount2", (Mth.nextInt(RandomSource.create(), 5, 30)));
			entity.getPersistentData().putDouble("potatoWar:itemcount3", (Mth.nextInt(RandomSource.create(), 2, 15)));
			entity.getPersistentData().putDouble("potatoWar:RewardType", (Mth.nextInt(RandomSource.create(), 1, 5)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount1", (Mth.nextInt(RandomSource.create(), 10, 25)));
			entity.getPersistentData().putDouble("potatoWar:RewardCount2", (Mth.nextInt(RandomSource.create(), 2, 3)));
			entity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
		}
	}
}
