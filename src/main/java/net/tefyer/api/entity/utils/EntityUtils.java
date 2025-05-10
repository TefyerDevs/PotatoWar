package net.tefyer.api.entity.utils;

import net.minecraft.world.entity.Entity;
public class EntityUtils {
    public static final <T extends Entity> boolean checkMinMaxEntityX(T entity, String id, int max, int min){
        return entity.getX() >= entity.getPersistentData().getDouble(id) + max || entity.getX()
                <= entity.getPersistentData().getDouble(id) - min;
    }
    public static final <T extends Entity> boolean checkMinMaxEntityY(T entity, String id, int max, int min){
        return entity.getY() >= entity.getPersistentData().getDouble(id) + max || entity.getY()
                <= entity.getPersistentData().getDouble(id) - min;
    }
    public static final <T extends Entity> boolean checkMinMaxEntityZ(T entity, String id, int max, int min){
        return entity.getZ() >= entity.getPersistentData().getDouble(id) + max || entity.getZ()
                <= entity.getPersistentData().getDouble(id) - min;
    }
}
