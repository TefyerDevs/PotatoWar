
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.entity.*;
import net.tefyer.potatowar.PotatowarMod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PotatowarModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,PotatowarMod.MODID);

	public static final List<RegistryObject<EntityType<?>>> ENTITIES = new ArrayList<>();

	public static final RegistryObject<EntityType<PotatoManEntity>> POTATO_MAN = register("potato_man",
			EntityType.Builder.<PotatoManEntity>of(PotatoManEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoManEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<WildPotatomanEntity>> WILD_POTATO_MAN = register("wild_potato_man",
			EntityType.Builder.<WildPotatomanEntity>of(WildPotatomanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WildPotatomanEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<HumanEntity>> HUMAN = register("human",
			EntityType.Builder.<HumanEntity>of(HumanEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<Prototype1Entity>> PROTOTYPE_1 = register("prototype_1",
			EntityType.Builder.<Prototype1Entity>of(Prototype1Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Prototype1Entity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<PotatoMilitaEntity>> POTATO_MILITA = register("potato_milita",
			EntityType.Builder.<PotatoMilitaEntity>of(PotatoMilitaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoMilitaEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<HumanMilitaEntity>> HUMAN_MILITA = register("human_milita",
			EntityType.Builder.<HumanMilitaEntity>of(HumanMilitaEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanMilitaEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<ProtoDefenderEntity>> PROTO_DEFENDER = register("proto_defender",
			EntityType.Builder.<ProtoDefenderEntity>of(ProtoDefenderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ProtoDefenderEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<UnknownEntity>> UNKNOWN = register("unknown",
			EntityType.Builder.<UnknownEntity>of(UnknownEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(UnknownEntity::new).fireImmune().sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<LostHazzyEntity>> LOST_HAZZY = register("lost_hazzy",
			EntityType.Builder.<LostHazzyEntity>of(LostHazzyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LostHazzyEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<HazzycloneEntity>> HAZZYCLONE = register("hazzyclone",
			EntityType.Builder.<HazzycloneEntity>of(HazzycloneEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HazzycloneEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<FishEntity>> FISH = register("fish",
			EntityType.Builder.<FishEntity>of(FishEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FishEntity::new).fireImmune().sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<CorruptedplayerEntity>> CORRUPTEDPLAYER = register("corruptedplayer",
			EntityType.Builder.<CorruptedplayerEntity>of(CorruptedplayerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CorruptedplayerEntity::new)
					.sized(0.6f, 1.8f));

	public static final RegistryObject<EntityType<HumanMilitaryEntity>> HUMAN_MILITARY = register("human_military",
			EntityType.Builder.<HumanMilitaryEntity>of(HumanMilitaryEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanMilitaryEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HumanKnightEntity>> HUMAN_KNIGHT = register("human_knight",
			EntityType.Builder.<HumanKnightEntity>of(HumanKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanKnightEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HumanScoutEntity>> HUMAN_SCOUT = register("human_scout",
			EntityType.Builder.<HumanScoutEntity>of(HumanScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanScoutEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotatoMilitaryEntity>> POTATO_MILITARY = register("potato_military",
			EntityType.Builder.<PotatoMilitaryEntity>of(PotatoMilitaryEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoMilitaryEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotatoKnightEntity>> POTATO_KNIGHT = register("potato_knight",
			EntityType.Builder.<PotatoKnightEntity>of(PotatoKnightEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoKnightEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotatoScoutEntity>> POTATO_SCOUT = register("potato_scout",
			EntityType.Builder.<PotatoScoutEntity>of(PotatoScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoScoutEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GlitchEntity>> GLITCH = register("glitch",
			EntityType.Builder.<GlitchEntity>of(GlitchEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GlitchEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<MilitaryTrainerEntity>> MILITARY_TRAINER = register("military_trainer",
			EntityType.Builder.<MilitaryTrainerEntity>of(MilitaryTrainerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(MilitaryTrainerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<ArmyGeneralEntity>> ARMY_GENERAL = register("army_general",
			EntityType.Builder.<ArmyGeneralEntity>of(ArmyGeneralEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ArmyGeneralEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FriedPotatoManEntity>> FRIED_POTATO_MAN = register("fried_potato_man", EntityType.Builder.<FriedPotatoManEntity>of(FriedPotatoManEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FriedPotatoManEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BeserkerEntity>> BESERKER = register("beserker",
			EntityType.Builder.<BeserkerEntity>of(BeserkerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BeserkerEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TownCenterMobEntity>> TOWN_CENTER_MOB = register("town_center_mob",
			EntityType.Builder.<TownCenterMobEntity>of(TownCenterMobEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TownCenterMobEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RaidLeaderEntity>> RAID_LEADER = register("raid_leader",
			EntityType.Builder.<RaidLeaderEntity>of(RaidLeaderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RaidLeaderEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotatoArcherEntity>> POTATO_ARCHER = register("potato_archer",
			EntityType.Builder.<PotatoArcherEntity>of(PotatoArcherEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoArcherEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<RemnantEntity>> REMNANT = register("remnant",
			EntityType.Builder.<RemnantEntity>of(RemnantEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RemnantEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Remnant2Entity>> REMNANT_2 = register("remnant_2",
			EntityType.Builder.<Remnant2Entity>of(Remnant2Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Remnant2Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Remnant3Entity>> REMNANT_3 = register("remnant_3",
			EntityType.Builder.<Remnant3Entity>of(Remnant3Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Remnant3Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Remnant4Entity>> REMNANT_4 = register("remnant_4",
			EntityType.Builder.<Remnant4Entity>of(Remnant4Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Remnant4Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Remnant5Entity>> REMNANT_5 = register("remnant_5",
			EntityType.Builder.<Remnant5Entity>of(Remnant5Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Remnant5Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<Remnant6Entity>> REMNANT_6 = register("remnant_6",
			EntityType.Builder.<Remnant6Entity>of(Remnant6Entity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(Remnant6Entity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<FlyingTeddyEntity>> FLYING_TEDDY = register("flying_teddy",
			EntityType.Builder.<FlyingTeddyEntity>of(FlyingTeddyEntity::new, MobCategory.MISC).setCustomClientFactory(FlyingTeddyEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ScoutLeaderEntity>> SCOUT_LEADER = register("scout_leader",
			EntityType.Builder.<ScoutLeaderEntity>of(ScoutLeaderEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScoutLeaderEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PotatoOutlawEntity>> POTATO_OUTLAW = register("potato_outlaw",
			EntityType.Builder.<PotatoOutlawEntity>of(PotatoOutlawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PotatoOutlawEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<HumanOutlawEntity>> HUMAN_OUTLAW = register("human_outlaw",
			EntityType.Builder.<HumanOutlawEntity>of(HumanOutlawEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HumanOutlawEntity::new)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () ->entityTypeBuilder.build(registryname));
	}


	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			PotatoManEntity.init();
			WildPotatomanEntity.init();
			HumanEntity.init();
			Prototype1Entity.init();
			PotatoMilitaEntity.init();
			HumanMilitaEntity.init();
			ProtoDefenderEntity.init();
			UnknownEntity.init();
			LostHazzyEntity.init();
			HazzycloneEntity.init();
			FishEntity.init();
			CorruptedplayerEntity.init();
			HumanMilitaryEntity.init();
			HumanKnightEntity.init();
			HumanScoutEntity.init();
			PotatoMilitaryEntity.init();
			PotatoKnightEntity.init();
			PotatoScoutEntity.init();
			GlitchEntity.init();
			MilitaryTrainerEntity.init();
			ArmyGeneralEntity.init();
			FriedPotatoManEntity.init();
			BeserkerEntity.init();
			TownCenterMobEntity.init();
			RaidLeaderEntity.init();
			PotatoArcherEntity.init();
			RemnantEntity.init();
			Remnant2Entity.init();
			Remnant3Entity.init();
			Remnant4Entity.init();
			Remnant5Entity.init();
			Remnant6Entity.init();
			ScoutLeaderEntity.init();
			PotatoOutlawEntity.init();
			HumanOutlawEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(POTATO_MAN.get(), PotatoManEntity.createAttributes().build());
		event.put(WILD_POTATO_MAN.get(), WildPotatomanEntity.createAttributes().build());
		event.put(HUMAN.get(), HumanEntity.createAttributes().build());
		event.put(PROTOTYPE_1.get(), Prototype1Entity.createAttributes().build());
		event.put(POTATO_MILITA.get(), PotatoMilitaEntity.createAttributes().build());
		event.put(HUMAN_MILITA.get(), HumanMilitaEntity.createAttributes().build());
		event.put(PROTO_DEFENDER.get(), ProtoDefenderEntity.createAttributes().build());
		event.put(UNKNOWN.get(), UnknownEntity.createAttributes().build());
		event.put(LOST_HAZZY.get(), LostHazzyEntity.createAttributes().build());
		event.put(HAZZYCLONE.get(), HazzycloneEntity.createAttributes().build());
		event.put(FISH.get(), FishEntity.createAttributes().build());
		event.put(CORRUPTEDPLAYER.get(), CorruptedplayerEntity.createAttributes().build());
		event.put(HUMAN_MILITARY.get(), HumanMilitaryEntity.createAttributes().build());
		event.put(HUMAN_KNIGHT.get(), HumanKnightEntity.createAttributes().build());
		event.put(HUMAN_SCOUT.get(), HumanScoutEntity.createAttributes().build());
		event.put(POTATO_MILITARY.get(), PotatoMilitaryEntity.createAttributes().build());
		event.put(POTATO_KNIGHT.get(), PotatoKnightEntity.createAttributes().build());
		event.put(POTATO_SCOUT.get(), PotatoScoutEntity.createAttributes().build());
		event.put(GLITCH.get(), GlitchEntity.createAttributes().build());
		event.put(MILITARY_TRAINER.get(), MilitaryTrainerEntity.createAttributes().build());
		event.put(ARMY_GENERAL.get(), ArmyGeneralEntity.createAttributes().build());
		event.put(FRIED_POTATO_MAN.get(), FriedPotatoManEntity.createAttributes().build());
		event.put(BESERKER.get(), BeserkerEntity.createAttributes().build());
		event.put(TOWN_CENTER_MOB.get(), TownCenterMobEntity.createAttributes().build());
		event.put(RAID_LEADER.get(), RaidLeaderEntity.createAttributes().build());
		event.put(POTATO_ARCHER.get(), PotatoArcherEntity.createAttributes().build());
		event.put(REMNANT.get(), RemnantEntity.createAttributes().build());
		event.put(REMNANT_2.get(), Remnant2Entity.createAttributes().build());
		event.put(REMNANT_3.get(), Remnant3Entity.createAttributes().build());
		event.put(REMNANT_4.get(), Remnant4Entity.createAttributes().build());
		event.put(REMNANT_5.get(), Remnant5Entity.createAttributes().build());
		event.put(REMNANT_6.get(), Remnant6Entity.createAttributes().build());
		event.put(SCOUT_LEADER.get(), ScoutLeaderEntity.createAttributes().build());
		event.put(POTATO_OUTLAW.get(), PotatoOutlawEntity.createAttributes().build());
		event.put(HUMAN_OUTLAW.get(), HumanOutlawEntity.createAttributes().build());
	}
}
