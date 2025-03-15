package net.tefyer.potatowar.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.tefyer.potatowar.network.PotatowarModVariables;
import net.tefyer.potatowar.init.PotatowarModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerReputationProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatoWar:Joined") == false) {
			{
				double _setval = 0;
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PotatoReputation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HumanReputation = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Mth.nextDouble(RandomSource.create(), 0, 1000);
				entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LeaderID = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PotatowarModBlocks.ODD_POTATO_PLANT_STG_1.get()).copy();
				_setstack.setCount(5);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			entity.getPersistentData().putBoolean("potatoWar:Joined", true);
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("potatowar:potato_war"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if (entity.getPersistentData().getBoolean("potatowar:MigrationSet") == false) {
			entity.getPersistentData().putBoolean("potatowar:MigrationSet", true);
			PotatowarModVariables.WorldVariables.get(world).MigrationX = Mth.nextInt(RandomSource.create(), -1000, 1000);
			PotatowarModVariables.WorldVariables.get(world).syncData(world);
			PotatowarModVariables.WorldVariables.get(world).MigrationZ = Mth.nextInt(RandomSource.create(), -1000, 1000);
			PotatowarModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
