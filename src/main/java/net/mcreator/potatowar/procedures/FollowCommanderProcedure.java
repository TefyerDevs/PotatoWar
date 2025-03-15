package net.mcreator.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.potatowar.network.PotatowarModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class FollowCommanderProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity().getY(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double y, Entity entity) {
		execute(null, world, y, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double y, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("potatowar:ModeID") == 1
				&& (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))))
				&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
			if (entity.getX() >= entity.getPersistentData().getDouble("potatowar:PositionX") + 12 || entity.getX() <= entity.getPersistentData().getDouble("potatowar:PositionX") - 12
					|| entity.getZ() <= entity.getPersistentData().getDouble("potatowar:PositionZ") - 12 || entity.getZ() >= entity.getPersistentData().getDouble("potatowar:PositionZ") + 12) {
				entity.getPersistentData().putBoolean("potatowar:outsidePosition", true);
			}
			if (entity.getPersistentData().getBoolean("potatowar:outsidePosition") == true) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity.getPersistentData().getDouble("potatowar:PositionX")), y, (entity.getPersistentData().getDouble("potatowar:PositionZ")), 1.2);
			}
			if (entity.getX() >= entity.getPersistentData().getDouble("potatowar:PositionX") + 4 || entity.getX() <= entity.getPersistentData().getDouble("potatowar:PositionX") - 4
					|| entity.getZ() <= entity.getPersistentData().getDouble("potatowar:PositionZ") - 4 || entity.getZ() >= entity.getPersistentData().getDouble("potatowar:PositionZ") + 4) {
				entity.getPersistentData().putBoolean("potatowar:outsidePosition", false);
			}
		} else if (entity.getPersistentData().getDouble("potatowar:ModeID") == 3
				&& (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human"))) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))))
				&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))) {
			for (Entity entityiterator : new ArrayList<>(world.players())) {
				if (entity.getPersistentData().getDouble("potatowar:LeaderID") == (entityiterator.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).LeaderID
						&& (entity instanceof ServerPlayer || entity instanceof Player)) {
					if (entity.getX() >= entityiterator.getX() + 16 || entity.getX() <= entityiterator.getX() - 16 || entity.getZ() >= entityiterator.getZ() + 16 || entity.getZ() <= entityiterator.getZ() - 16) {
						entity.getPersistentData().putBoolean("potatowar:OutsideLeaderRange", true);
					}
					if (entity.getPersistentData().getBoolean("potatowar:OutsideLeaderRange") == true) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((entityiterator.getX()), y, (entityiterator.getZ()), 1.2);
					}
					if (entity.getX() >= entityiterator.getX() + 4 || entity.getX() <= entityiterator.getX() - 4 || entity.getZ() >= entityiterator.getZ() + 4 || entity.getZ() <= entityiterator.getZ() - 4) {
						entity.getPersistentData().putBoolean("potatowar:OutsideLeaderRange", false);
					}
				}
			}
		}
	}
}
