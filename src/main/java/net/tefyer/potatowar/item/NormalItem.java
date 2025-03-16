package net.tefyer.potatowar.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class NormalItem  extends Item {
    public NormalItem(Rarity rarity) {
        super(new Item.Properties().stacksTo(1).rarity(rarity));
    }

    public static class Builder{
        public Rarity rarity;

        public Builder setRarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public NormalItem build(){
            return new NormalItem(this.rarity);
        }
    }
}
