package net.tefyer.potatowar.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;

public class PotatowarModItemGroup {

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotatowarMod.MODID);

    public static final RegistryObject<CreativeModeTab> POTATO_TAB = REGISTRY.register("potato_tab",()-> CreativeModeTab.builder()
            .title(Component.translatable(PotatowarMod.MODID+".potato_tab"))
            .icon(()->new ItemStack(PotatowarModItems.ODD_POTATO_PLANT_STG_1.get().asItem()))
            .displayItems((item,output) -> {
                PotatowarModItems.REGISTRY.ITEMS_LIST.forEach((itemList)->{
                    output.accept(itemList.get());
                });
            })
            .build());

}
