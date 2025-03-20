package net.tefyer.potatowar.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public abstract class ItemStackedItem {

    public abstract ItemStack getItemStack(int sltid, Entity entity);
}
