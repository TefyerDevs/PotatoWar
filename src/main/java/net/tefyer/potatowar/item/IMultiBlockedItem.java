package net.tefyer.potatowar.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public interface IMultiBlockedItem {
    void addMultiBlockData();
    void checkMultiblock(LevelAccessor world, int x, int y, int z, Entity entity);
}
