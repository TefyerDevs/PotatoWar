
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.tefyer.potatowar.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.tefyer.potatowar.client.renderer.UnknownRenderer;
import net.tefyer.potatowar.client.renderer.TownCenterMobRenderer;
import net.tefyer.potatowar.client.renderer.ScoutLeaderRenderer;
import net.tefyer.potatowar.client.renderer.RemnantRenderer;
import net.tefyer.potatowar.client.renderer.Remnant6Renderer;
import net.tefyer.potatowar.client.renderer.Remnant5Renderer;
import net.tefyer.potatowar.client.renderer.Remnant4Renderer;
import net.tefyer.potatowar.client.renderer.Remnant3Renderer;
import net.tefyer.potatowar.client.renderer.Remnant2Renderer;
import net.tefyer.potatowar.client.renderer.RaidLeaderRenderer;
import net.tefyer.potatowar.client.renderer.Prototype1Renderer;
import net.tefyer.potatowar.client.renderer.ProtoDefenderRenderer;
import net.tefyer.potatowar.client.renderer.PotatoScoutRenderer;
import net.tefyer.potatowar.client.renderer.PotatoOutlawRenderer;
import net.tefyer.potatowar.client.renderer.PotatoMilitaryRenderer;
import net.tefyer.potatowar.client.renderer.PotatoMilitaRenderer;
import net.tefyer.potatowar.client.renderer.PotatoManRenderer;
import net.tefyer.potatowar.client.renderer.WildPotatoManRenderer;
import net.tefyer.potatowar.client.renderer.PotatoKnightRenderer;
import net.tefyer.potatowar.client.renderer.PotatoArcherRenderer;
import net.tefyer.potatowar.client.renderer.MilitaryTrainerRenderer;
import net.tefyer.potatowar.client.renderer.LostHazzyRenderer;
import net.tefyer.potatowar.client.renderer.HumanScoutRenderer;
import net.tefyer.potatowar.client.renderer.HumanRenderer;
import net.tefyer.potatowar.client.renderer.HumanOutlawRenderer;
import net.tefyer.potatowar.client.renderer.HumanMilitaryRenderer;
import net.tefyer.potatowar.client.renderer.HumanMilitaRenderer;
import net.tefyer.potatowar.client.renderer.HumanKnightRenderer;
import net.tefyer.potatowar.client.renderer.HazzycloneRenderer;
import net.tefyer.potatowar.client.renderer.GlitchRenderer;
import net.tefyer.potatowar.client.renderer.FriedPotatoManRenderer;
import net.tefyer.potatowar.client.renderer.FishRenderer;
import net.tefyer.potatowar.client.renderer.CorruptedplayerRenderer;
import net.tefyer.potatowar.client.renderer.BeserkerRenderer;
import net.tefyer.potatowar.client.renderer.ArmyGeneralRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PotatowarModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PotatowarModEntities.POTATO_MAN.get(), PotatoManRenderer::new);
        event.registerEntityRenderer(PotatowarModEntities.WILD_POTATO_MAN.get(), WildPotatoManRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN.get(), HumanRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.PROTOTYPE_1.get(), Prototype1Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_MILITA.get(), PotatoMilitaRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN_MILITA.get(), HumanMilitaRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.PROTO_DEFENDER.get(), ProtoDefenderRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.UNKNOWN.get(), UnknownRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.LOST_HAZZY.get(), LostHazzyRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HAZZYCLONE.get(), HazzycloneRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.FISH.get(), FishRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.CORRUPTEDPLAYER.get(), CorruptedplayerRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN_MILITARY.get(), HumanMilitaryRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN_KNIGHT.get(), HumanKnightRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN_SCOUT.get(), HumanScoutRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_MILITARY.get(), PotatoMilitaryRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_KNIGHT.get(), PotatoKnightRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_SCOUT.get(), PotatoScoutRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.GLITCH.get(), GlitchRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.MILITARY_TRAINER.get(), MilitaryTrainerRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.ARMY_GENERAL.get(), ArmyGeneralRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.FRIED_POTATO_MAN.get(), FriedPotatoManRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.BESERKER.get(), BeserkerRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.TOWN_CENTER_MOB.get(), TownCenterMobRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.RAID_LEADER.get(), RaidLeaderRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_ARCHER.get(), PotatoArcherRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT.get(), RemnantRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT_2.get(), Remnant2Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT_3.get(), Remnant3Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT_4.get(), Remnant4Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT_5.get(), Remnant5Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.REMNANT_6.get(), Remnant6Renderer::new);
		event.registerEntityRenderer(PotatowarModEntities.FLYING_TEDDY.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.SCOUT_LEADER.get(), ScoutLeaderRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.POTATO_OUTLAW.get(), PotatoOutlawRenderer::new);
		event.registerEntityRenderer(PotatowarModEntities.HUMAN_OUTLAW.get(), HumanOutlawRenderer::new);
	}
}
