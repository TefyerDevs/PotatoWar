package net.tefyer.potatowar.generator.custom;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.init.PotatowarModItems;

import java.util.Objects;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PotatowarMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        PotatowarModItems.REGISTRY.KITS.forEach((item -> {
            if(item.getId().getPath().contains("blank_kit"))
                basicItem(item.get());
            else
               basicItemMultiTextureable(item.get(), "blank_kit");
        }));
    }


    public ItemModelBuilder basicItemMultiTextureable(Item item, String base_item) {
        return basicItemMultiTextureable(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)),base_item);
    }

    public ItemModelBuilder basicItemMultiTextureable(ResourceLocation item, String base_item) {
        return this.getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer1", new ResourceLocation(item.getNamespace(), "item/kit/" + item.getPath()+"_overlay"))
                .texture("layer0",new ResourceLocation(item.getNamespace(), "item/" + base_item));
    }


}
