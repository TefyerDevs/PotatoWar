package net.tefyer.potatowar.item.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CommonItem extends Item {
    public CommonItem() {
        super(new Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}