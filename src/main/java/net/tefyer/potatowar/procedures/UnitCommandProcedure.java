package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.tefyer.potatowar.network.PotatowarModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class UnitCommandProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getTarget(), event.getEntity());
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (((sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HumanReputation >= 250
				&& entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))
				|| (sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation >= 250
						&& entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))))
				&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian"))) && entity.getPersistentData().getDouble("potatowar:ModeID") == 1) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Wandering"), false);
			entity.getPersistentData().putDouble("potatowar:LeaderID", 0);
			entity.getPersistentData().putBoolean("potatowar:HoldPosition", false);
			entity.getPersistentData().putDouble("potatowar:ModeID", 2);
		} else if (((sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HumanReputation >= 250
				&& entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))
				|| (sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation >= 250
						&& entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato"))))
				&& !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian"))) && entity.getPersistentData().getDouble("potatowar:ModeID") == 2) {
			entity.getPersistentData().putDouble("potatowar:ModeID", 3);
			entity.getPersistentData().putDouble("potatowar:LeaderID", ((sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).LeaderID));
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Following"), false);
		} else if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("potatowar:civilian")))
				&& (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:human")))
						&& (sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HumanReputation >= 250
						|| entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:potato")))
								&& (sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation >= 250)
				&& entity.getPersistentData().getDouble("potatowar:ModeID") == 3) {
			entity.getPersistentData().putDouble("potatowar:PositionX", (entity.getX()));
			entity.getPersistentData().putDouble("potatowar:PositionZ", (entity.getZ()));
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Guarding"), false);
			entity.getPersistentData().putDouble("potatowar:ModeID", 1);
		}
	}
}
