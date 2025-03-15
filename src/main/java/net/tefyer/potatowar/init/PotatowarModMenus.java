
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.tefyer.potatowar.world.inventory.ShowCurrentQuestMenu;
import net.tefyer.potatowar.world.inventory.MilitaryTrainerKitsMenu;
import net.tefyer.potatowar.world.inventory.ItemquestMenu;
import net.tefyer.potatowar.world.inventory.HireMilitaryUnitMenu;
import net.tefyer.potatowar.world.inventory.ConfrimAbandonQuestMenu;
import net.tefyer.potatowar.world.inventory.AssassinQuestMenu;
import net.tefyer.potatowar.PotatowarMod;

public class PotatowarModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, PotatowarMod.MODID);
	public static final RegistryObject<MenuType<ItemquestMenu>> ITEMQUEST = REGISTRY.register("itemquest", () -> IForgeMenuType.create(ItemquestMenu::new));
	public static final RegistryObject<MenuType<HireMilitaryUnitMenu>> HIRE_MILITARY_UNIT = REGISTRY.register("hire_military_unit", () -> IForgeMenuType.create(HireMilitaryUnitMenu::new));
	public static final RegistryObject<MenuType<MilitaryTrainerKitsMenu>> MILITARY_TRAINER_KITS = REGISTRY.register("military_trainer_kits", () -> IForgeMenuType.create(MilitaryTrainerKitsMenu::new));
	public static final RegistryObject<MenuType<AssassinQuestMenu>> ASSASSIN_QUEST = REGISTRY.register("assassin_quest", () -> IForgeMenuType.create(AssassinQuestMenu::new));
	public static final RegistryObject<MenuType<ShowCurrentQuestMenu>> SHOW_CURRENT_QUEST = REGISTRY.register("show_current_quest", () -> IForgeMenuType.create(ShowCurrentQuestMenu::new));
	public static final RegistryObject<MenuType<ConfrimAbandonQuestMenu>> CONFRIM_ABANDON_QUEST = REGISTRY.register("confrim_abandon_quest", () -> IForgeMenuType.create(ConfrimAbandonQuestMenu::new));
}
