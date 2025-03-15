package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.tefyer.potatowar.init.PotatowarModItems;
import net.tefyer.potatowar.entity.TownCenterMobEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightclickMobProcedure {
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
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PotatowarModItems.GREAT_STICK_OF_TESTING.get()) {
			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("My leader ID is: " + entity.getPersistentData().getDouble("potatowar:LeaderID"))), false);
			if (entity instanceof TownCenterMobEntity) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Town points: " + entity.getPersistentData().getDouble("potatowar:TownPoints"))), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Cooldown: " + entity.getPersistentData().getDouble("potatowar:TownCenterCheckCooldown"))), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Raid cooldown: " + entity.getPersistentData().getBoolean("potatowar:RaidCooldown"))), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Raid active: " + entity.getPersistentData().getBoolean("potatowar:RaidActive"))), false);
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("Raid active: " + entity.getPersistentData().getDouble("potatowar:RaidActive"))), false);
			}
		}
	}
}
