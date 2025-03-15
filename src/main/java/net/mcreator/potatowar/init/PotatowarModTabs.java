
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.potatowar.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.potatowar.PotatowarMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotatowarModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotatowarMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(PotatowarModItems.POTATO_MAN_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.PROTOTYPE_1_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_MILITA_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_MILITA_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.PROTO_DEFENDER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.UNKNOWN_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.LOST_HAZZY_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HAZZYCLONE_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.FISH_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.CORRUPTEDPLAYER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_MILITARY_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_KNIGHT_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_SCOUT_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_MILITARY_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_KNIGHT_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_SCOUT_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.GLITCH_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.MILITARY_TRAINER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.ARMY_GENERAL_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.FRIED_POTATO_MAN_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.BESERKER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.TOWN_CENTER_MOB_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.RAID_LEADER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_ARCHER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_2_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_3_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_4_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_5_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.REMNANT_6_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.SCOUT_LEADER_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.POTATO_OUTLAW_SPAWN_EGG.get());
			tabData.accept(PotatowarModItems.HUMAN_OUTLAW_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(PotatowarModItems.FORGOTTEN_WORLDS.get());
			tabData.accept(PotatowarModItems.DIGITAL_WORLD.get());
			tabData.accept(PotatowarModItems.DIGITAL_ASSISTANT.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(PotatowarModBlocks.DIGITAL_BLOCK.get().asItem());
			tabData.accept(PotatowarModBlocks.POTATO_BLOCK.get().asItem());
			tabData.accept(PotatowarModItems.BLOCKRANDOMIZE.get());
			tabData.accept(PotatowarModItems.TOWN_CENTER.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(PotatowarModItems.ARMY_KIT.get());
			tabData.accept(PotatowarModItems.MILITA_KIT.get());
			tabData.accept(PotatowarModItems.SCOUT_KIT.get());
			tabData.accept(PotatowarModItems.KNIGHT_KIT.get());
			tabData.accept(PotatowarModItems.MILITARY_ARMOR_HELMET.get());
			tabData.accept(PotatowarModItems.MILITARY_KIT.get());
			tabData.accept(PotatowarModItems.FRYER_KIT.get());
			tabData.accept(PotatowarModItems.BESERKER_KIT.get());
			tabData.accept(PotatowarModItems.TEDDY.get());
			tabData.accept(PotatowarModItems.MEMORIES.get());
			tabData.accept(PotatowarModItems.CORRUPTED_PLAYER_DATA.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(PotatowarModItems.BLANK_KIT.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(PotatowarModBlocks.ODD_POTATO_PLANT_STG_1.get().asItem());
		}
	}
}
