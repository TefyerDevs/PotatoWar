package net.mcreator.potatowar.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class KitItem  extends Item {
    public KitItem(Rarity rarity) {
        super(new Item.Properties().stacksTo(1).rarity(rarity));
    }

    public static class Builder{
        public Rarity rarity;

        public Builder setRarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public KitItem build(){
            return new KitItem(this.rarity);
        }
    }
}
