package net.tefyer.api.item.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.tefyer.potatowar.items.ChestMalitiaMarker;

public class ItemUtils {

    public static void setPos(ItemStack marker, String id, BlockPos blockPos) {
        int[] pos = new int[3];

        pos[0] = blockPos.getX();
        pos[1] = blockPos.getY();
        pos[2] = blockPos.getZ();

        assert marker.getTag() != null;
        marker.getTag().putIntArray(id, pos);

    }
    public static BlockPos getPos(ItemStack marker, String id) {
        assert marker.getTag() != null;
        int[] pos = marker.getTag().getIntArray(id);
        return new BlockPos(pos[0],pos[1],pos[3]);
    }


    public static boolean ifExist(ItemStack marker, String id) {
        try{
            marker.getTag().getIntArray(id);
        } catch(NullPointerException e){
            return false;
        }
        return true;
    }
}
