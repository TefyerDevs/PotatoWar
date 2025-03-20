package net.tefyer.potatowar.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tefyer.potatowar.PotatowarMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NormalItem  extends Item {
    public String itemId;

    public NormalItem(Rarity rarity,int size,String itemId) {
        super(new Item.Properties().stacksTo(size).rarity(rarity));
        this.itemId = itemId;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> toolTip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, toolTip, pIsAdvanced);
        if(itemId != null)
            toolTip.add(Component.translatable("lore."+PotatowarMod.MODID+"."+itemId));
    }

    public static class Builder{
        public Rarity rarity;
        public String itemId;
        public int size = 64;

        public Builder setRarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder setItemId(String itemId) {
            this.itemId = itemId;
            return this;
        }
        public Builder setSize(int size) {
            this.size = size;
            return this;
        }



        public NormalItem build(){
            return new NormalItem(this.rarity,this.size,this.itemId);
        }
    }
}
