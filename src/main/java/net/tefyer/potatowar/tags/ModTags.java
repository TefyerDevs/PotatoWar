package net.tefyer.potatowar.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tefyer.potatowar.PotatowarMod;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(PotatowarMod.MODID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> POTATO_KITS = tag("potato_kit");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(PotatowarMod.MODID, name));
        }
    }
}
