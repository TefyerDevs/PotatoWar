
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.tefyer.potatowar.deferredregister.ItemDeferredRegister;
import net.tefyer.potatowar.item.*;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;

import net.tefyer.potatowar.PotatowarMod;

public class PotatowarModItems {
	public static final ItemDeferredRegister REGISTRY = new  ItemDeferredRegister(PotatowarMod.MODID);
	// KITS
	public static final RegistryObject<Item> BLANK_KIT = REGISTRY.registerKit("blank_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("blank_kit").build());
	public static final RegistryObject<Item> BESERKER_KIT = REGISTRY.registerKit("beserker_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("beserker_kit").build());
	public static final RegistryObject<Item> MILITARY_KIT = REGISTRY.registerKit("military_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("military_kit").build());
	public static final RegistryObject<Item> SCOUT_KIT = REGISTRY.registerKit("scout_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("scout_kit").build());
	public static final RegistryObject<Item> KNIGHT_KIT = REGISTRY.registerKit("knight_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("knight_kit").build());
	public static final RegistryObject<Item> ARMY_KIT = REGISTRY.registerKit("army_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("army_kit").build());
	public static final RegistryObject<Item> FRYER_KIT = REGISTRY.registerKit("fryer_kit",()->  new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("fryer_kit").build());
	public static final RegistryObject<Item> MILITA_KIT = REGISTRY.registerKit("milita_kit",()-> new NormalItem.Builder().setRarity(Rarity.COMMON).setSize(1).setItemId("milita_kit").build());

	// SPAWN EGGS
	public static final RegistryObject<Item> POTATO_MAN_SPAWN_EGG = REGISTRY.register("potato_man_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_MAN, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_SPAWN_EGG = REGISTRY.register("human_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN, -16724788, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> PROTOTYPE_1_SPAWN_EGG = REGISTRY.register("prototype_1_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.PROTOTYPE_1, -39424, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_MILITA_SPAWN_EGG = REGISTRY.register("potato_milita_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_MILITA, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_MILITA_SPAWN_EGG = REGISTRY.register("human_milita_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN_MILITA, -16737895, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> PROTO_DEFENDER_SPAWN_EGG = REGISTRY.register("proto_defender_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.PROTO_DEFENDER, -1, -16711732, new Item.Properties()));
	public static final RegistryObject<Item> UNKNOWN_SPAWN_EGG = REGISTRY.register("unknown_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.UNKNOWN, -39424, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> DIGITAL_ASSISTANT = REGISTRY.register("digital_assistant", () -> new DigitalAssistantItem());
	public static final RegistryObject<Item> LOST_HAZZY_SPAWN_EGG = REGISTRY.register("lost_hazzy_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.LOST_HAZZY, -65536, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> HAZZYCLONE_SPAWN_EGG = REGISTRY.register("hazzyclone_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HAZZYCLONE, -65536, -16777216, new Item.Properties()));
	public static final RegistryObject<Item> FISH_SPAWN_EGG = REGISTRY.register("fish_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.FISH, -13312, -256, new Item.Properties()));
	public static final RegistryObject<Item> CORRUPTEDPLAYER_SPAWN_EGG = REGISTRY.register("corruptedplayer_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.CORRUPTEDPLAYER, -1, -10092544, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_MILITARY_SPAWN_EGG = REGISTRY.register("human_military_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN_MILITARY, -16737895, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_KNIGHT_SPAWN_EGG = REGISTRY.register("human_knight_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN_KNIGHT, -16737895, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_SCOUT_SPAWN_EGG = REGISTRY.register("human_scout_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN_SCOUT, -16737895, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_MILITARY_SPAWN_EGG = REGISTRY.register("potato_military_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_MILITARY, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_KNIGHT_SPAWN_EGG = REGISTRY.register("potato_knight_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_KNIGHT, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_SCOUT_SPAWN_EGG = REGISTRY.register("potato_scout_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_SCOUT, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> GLITCH_SPAWN_EGG = REGISTRY.register("glitch_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.GLITCH, -16724788, -16711936, new Item.Properties()));
	public static final RegistryObject<Item> MILITARY_TRAINER_SPAWN_EGG = REGISTRY.register("military_trainer_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.MILITARY_TRAINER, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> ARMY_GENERAL_SPAWN_EGG = REGISTRY.register("army_general_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.ARMY_GENERAL, -16737895, -16764058, new Item.Properties()));
	public static final RegistryObject<Item> FRIED_POTATO_MAN_SPAWN_EGG = REGISTRY.register("fried_potato_man_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.FRIED_POTATO_MAN, -3440896, -7907072, new Item.Properties()));
	public static final RegistryObject<Item> BESERKER_SPAWN_EGG = REGISTRY.register("beserker_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.BESERKER, -16737895, -16764007, new Item.Properties()));
	public static final RegistryObject<Item> TOWN_CENTER_MOB_SPAWN_EGG = REGISTRY.register("town_center_mob_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.TOWN_CENTER_MOB, -16777216, -13421773, new Item.Properties()));
	public static final RegistryObject<Item> RAID_LEADER_SPAWN_EGG = REGISTRY.register("raid_leader_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.RAID_LEADER, -16751002, -16764058, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_ARCHER_SPAWN_EGG = REGISTRY.register("potato_archer_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_ARCHER, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_SPAWN_EGG = REGISTRY.register("remnant_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_2_SPAWN_EGG = REGISTRY.register("remnant_2_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT_2, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_3_SPAWN_EGG = REGISTRY.register("remnant_3_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT_3, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_4_SPAWN_EGG = REGISTRY.register("remnant_4_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT_4, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_5_SPAWN_EGG = REGISTRY.register("remnant_5_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT_5, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> REMNANT_6_SPAWN_EGG = REGISTRY.register("remnant_6_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.REMNANT_6, -6710887, -10066330, new Item.Properties()));
	public static final RegistryObject<Item> POTATO_OUTLAW_SPAWN_EGG = REGISTRY.register("potato_outlaw_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.POTATO_OUTLAW, -256, -26368, new Item.Properties()));
	public static final RegistryObject<Item> HUMAN_OUTLAW_SPAWN_EGG = REGISTRY.register("human_outlaw_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.HUMAN_OUTLAW, -16737895, -16750951, new Item.Properties()));
	public static final RegistryObject<Item> SCOUT_LEADER_SPAWN_EGG = REGISTRY.register("scout_leader_spawn_egg", () -> new ForgeSpawnEggItem(PotatowarModEntities.SCOUT_LEADER, -16737895, -16764058, new Item.Properties()));

	// RES
	public static final RegistryObject<Item> RUBY = REGISTRY.register("ruby", () -> new NormalItem.Builder().setRarity(Rarity.COMMON).setItemId("blood_ruby").build());
	public static final RegistryObject<Item> TOPAZ = REGISTRY.register("topaz", () -> new NormalItem.Builder().setRarity(Rarity.COMMON).setItemId("black_jade").build());

	public static final RegistryObject<Item> FORGOTTEN_WORLDS = REGISTRY.register("forgotten_worlds", ForgottenWorldsItem::new);
	public static final RegistryObject<Item> POTATO_SWORD = REGISTRY.register("potato_sword", () -> new PotatoSwordItem(Tiers.DIAMOND, 15,-2.4F,new Item.Properties()));
	public static final RegistryObject<Item> DIGITAL_WORLD = REGISTRY.register("digital_world", DigitalWorldItem::new);
	public static final RegistryObject<Item> GREAT_STICK_OF_TESTING = REGISTRY.register("great_stick_of_testing", GreatStickOfTestingItem::new);
	public static final RegistryObject<Item> MILITARY_ARMOR_HELMET = REGISTRY.register("military_armor_helmet", MilitaryArmorItem.Helmet::new);

	public static final RegistryObject<Item> BLOCKRANDOMIZE = REGISTRY.register("blockrandomize", () -> new BlockrandomizeItem());
	public static final RegistryObject<Item> TEDDY = REGISTRY.register("teddy", () -> new TeddyItem());
	public static final RegistryObject<Item> MEMORY_SHARD = REGISTRY.register("memory_shard", () -> new NormalItem.Builder().setRarity(Rarity.RARE).setItemId("memory_shard").build());
	public static final RegistryObject<Item> MEMORIES = REGISTRY.register("memories", () -> new MemoriesItem());
	public static final RegistryObject<Item> CORRUPTED_PLAYER_DATA = REGISTRY.register("corrupted_player_data", () -> new CorruptedPlayerDataItem());
	public static final RegistryObject<Item> TOWN_CENTER = REGISTRY.register("town_center", () -> new TownCenterItem());


	public static final RegistryObject<Item> RAW_RUBBER = REGISTRY.register("raw_rubber", () -> new NormalItem.Builder().setRarity(Rarity.COMMON).build());
	public static final RegistryObject<Item> CONDESED_RUBBER = REGISTRY.register("condesed_rubber", () -> new NormalItem.Builder().setRarity(Rarity.COMMON).build());

	public static void registerBlocks(){
		for(RegistryObject<Block> block: PotatowarModBlocks.REGISTRY.getEntries()){
			block(block);
		}
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
