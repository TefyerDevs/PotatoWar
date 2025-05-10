package net.tefyer.potatowar.api.item;

import net.minecraft.world.item.Item;
import net.tefyer.potatowar.items.custom.KitItem;

public class PWItem extends Item {
    public PWItem(Properties pProperties) {
        super(pProperties);
    }

    public boolean isKit(){
        return this instanceof KitItem;
    }
}
