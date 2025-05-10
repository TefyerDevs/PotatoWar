package net.tefyer.potatowar.items.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.tefyer.api.item.kit.KitType;
import net.tefyer.api.item.PWItem;

public class KitItem extends PWItem {
    KitType type;
    public KitItem(KitType type) {
        super(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1));
        this.type = type;
    }

    public KitType getType() {
        return type;
    }
}
