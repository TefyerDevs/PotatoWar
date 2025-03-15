package net.mcreator.potatowar.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Q2I1Procedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack Reward2 = ItemStack.EMPTY;
		ItemStack Reward1 = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack Item2 = ItemStack.EMPTY;
		ItemStack Item3 = ItemStack.EMPTY;
		if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 4) {
			return new ItemStack(Items.ROTTEN_FLESH);
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 3) {
			return new ItemStack(Items.BONE_MEAL);
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 2) {
			return new ItemStack(Items.STRING);
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 1) {
			return new ItemStack(Items.SPIDER_EYE);
		}
		return new ItemStack(Blocks.AIR);
	}
}
