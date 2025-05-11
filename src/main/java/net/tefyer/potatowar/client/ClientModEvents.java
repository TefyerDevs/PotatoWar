package net.tefyer.potatowar.client;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.tefyer.potatowar.client.menus.MenuRegistry;
import net.tefyer.potatowar.client.screen.custom.ItemQuestScreen;
import net.tefyer.potatowar.commands.SummonPotatoMan;

import static net.tefyer.potatowar.PotatowarMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        MenuScreens.register(MenuRegistry.ITEMQUEST.get(), ItemQuestScreen::new);
    }
}