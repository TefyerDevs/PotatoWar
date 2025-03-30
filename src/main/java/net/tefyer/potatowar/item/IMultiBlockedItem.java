package net.tefyer.potatowar.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public interface IMultiBlockedItem {
    void addMultiBlockData(Level level);
    void checkMultiblock(LevelAccessor world, int x, int y, int z, Entity entity);
}
