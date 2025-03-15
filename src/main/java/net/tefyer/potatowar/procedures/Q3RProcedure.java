package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Q3RProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack Reward2 = ItemStack.EMPTY;
		ItemStack Reward1 = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack Item2 = ItemStack.EMPTY;
		ItemStack Item3 = ItemStack.EMPTY;
		if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 4) {
			item1 = new ItemStack(Items.COCOA_BEANS).copy();
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 4) {
			item1 = new ItemStack(Items.RAW_IRON).copy();
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 3) {
			item1 = new ItemStack(Items.RAW_GOLD).copy();
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 2) {
			item1 = new ItemStack(Items.HONEYCOMB).copy();
		} else if (entity.getPersistentData().getDouble("potatoWar:ItemType1") >= 1) {
			item1 = new ItemStack(Blocks.GLOWSTONE).copy();
		}
		return item1;
	}
}
