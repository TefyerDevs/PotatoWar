package net.tefyer.potatowar.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public interface ItemStackedItem {

    ItemStack getItemStack(int sltid, Entity entity);
}
