
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;

public class PotatowarModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotatowarMod.MODID);

	public static final RegistryObject<CreativeModeTab> POTATO_TAB = REGISTRY.register("potato_tab",()-> CreativeModeTab.builder()
			.title(Component.translatable(PotatowarMod.MODID+".potato_tab"))
			.icon(()->new ItemStack(PotatowarModItems.FORGOTTEN_WORLDS.get().asItem()))
			.displayItems((item,output) -> {
				PotatowarModItems.REGISTRY.ITEMS_LIST.forEach((itemList)->{
					output.accept(itemList.get());
				});
			})
			.build());
}
