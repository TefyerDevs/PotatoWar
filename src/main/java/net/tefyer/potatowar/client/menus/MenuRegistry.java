package net.tefyer.potatowar.client.menus;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tefyer.potatowar.PotatowarMod;
import net.tefyer.potatowar.client.menus.custom.ItemQuestMenu;

public class MenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, PotatowarMod.MODID);

    public static final RegistryObject<MenuType<ItemQuestMenu>> ITEMQUEST =
            MENUS.register("itemquest", ()-> IForgeMenuType.create(ItemQuestMenu::new));

    public static void registerMenus(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}
