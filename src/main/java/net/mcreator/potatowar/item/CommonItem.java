package net.mcreator.potatowar.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CommonItem extends Item {
    public CommonItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}