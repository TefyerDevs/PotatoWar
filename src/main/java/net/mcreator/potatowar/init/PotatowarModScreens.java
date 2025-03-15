
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.potatowar.client.gui.ShowCurrentQuestScreen;
import net.mcreator.potatowar.client.gui.MilitaryTrainerKitsScreen;
import net.mcreator.potatowar.client.gui.ItemquestScreen;
import net.mcreator.potatowar.client.gui.HireMilitaryUnitScreen;
import net.mcreator.potatowar.client.gui.ConfrimAbandonQuestScreen;
import net.mcreator.potatowar.client.gui.AssassinQuestScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PotatowarModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PotatowarModMenus.ITEMQUEST.get(), ItemquestScreen::new);
			MenuScreens.register(PotatowarModMenus.HIRE_MILITARY_UNIT.get(), HireMilitaryUnitScreen::new);
			MenuScreens.register(PotatowarModMenus.MILITARY_TRAINER_KITS.get(), MilitaryTrainerKitsScreen::new);
			MenuScreens.register(PotatowarModMenus.ASSASSIN_QUEST.get(), AssassinQuestScreen::new);
			MenuScreens.register(PotatowarModMenus.SHOW_CURRENT_QUEST.get(), ShowCurrentQuestScreen::new);
			MenuScreens.register(PotatowarModMenus.CONFRIM_ABANDON_QUEST.get(), ConfrimAbandonQuestScreen::new);
		});
	}
}
