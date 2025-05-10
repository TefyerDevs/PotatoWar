package net.tefyer.potatowar.dataGen.custom;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.items.ItemRegistry;
import net.tefyer.potatowar.items.custom.KitItem;
import net.tefyer.potatowar.tags.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {


    public ModItemTagGenerator(PackOutput packOutput,
                               CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_,
                               @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, p_275729_, p_275322_, PotatowarMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        KitItem[] items = new KitItem[ItemRegistry.ITEMS.KITS.size()-1];
        for (int i = 1; i < ItemRegistry.ITEMS.KITS.size(); i++) {
            items[i-1] = (KitItem) ItemRegistry.ITEMS.KITS.get(i).get();
        }

        this.tag(ModTags.Items.POTATO_KITS).add(items);
    }
}
