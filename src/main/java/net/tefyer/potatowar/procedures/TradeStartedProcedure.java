package net.tefyer.potatowar.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.world.inventory.ItemquestMenu;
import net.tefyer.potatowar.world.inventory.AssassinQuestMenu;
import net.tefyer.potatowar.network.PotatowarModVariables;

import io.netty.buffer.Unpooled;

public class TradeStartedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.getPersistentData().getBoolean("potatowar:RandomizeQuest") == true) {
			entity.getPersistentData().putBoolean("potatowar:RandomizeQuest", false);
			SetItemsProcedure.execute(world, x, y, z, entity);
		}
		if ((sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation >= 0
				&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:kit")))) && entity.getPersistentData().getBoolean("potatowar:AssassinQuest") == true) {
			if (entity.getPersistentData().getBoolean("potatowar:QuestTaken") == true) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal((entity.getPersistentData().getString("potatowar:QuestHolderDisplayName") + " has already accepted my quest. Come back later and I might have one for you.")), false);
			} else {
				if ((sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HasQuest) {
					if (sourceentity.getPersistentData().getDouble("potatowar:CivilianID") == entity.getPersistentData().getDouble("potatowar:CivilianID")) {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Your quest still is not complete."), false);
					} else {
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("You already have a quest, Abandon your current one before getting another"), false);
					}
				} else {
					{
						String _setval = entity.getPersistentData().getString("potatowar:AssassinName");
						sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AssassinName = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						String _setval = entity.getPersistentData().getString("potatowar:AssassinThing");
						sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AssassinThing = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = entity.getPersistentData().getDouble("potatowar:AssassinX");
						sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AssassinX = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = entity.getPersistentData().getDouble("potatowar:AssassinZ");
						sourceentity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AssassinZ = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					sourceentity.getPersistentData().putDouble("potatowar:CivilianID", (entity.getPersistentData().getDouble("potatowar:CivilianID")));
					entity.getPersistentData().putString("potatowar:QuestHolder", (ForgeRegistries.ENTITY_TYPES.getKey(sourceentity.getType()).toString()));
					entity.getPersistentData().putString("potatowar:QuestHolderDisplayName", (sourceentity.getDisplayName().getString()));
					if (sourceentity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("AssassinQuest");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new AssassinQuestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			}
		} else if ((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).PotatoReputation >= 0
				&& !((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:kit"))))) {
			sourceentity.getPersistentData().putDouble("potatowar:MilitaryPrice", (entity.getPersistentData().getDouble("potatowar:MilitaryPrice")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentQuest", (entity.getPersistentData().getDouble("potatoWar:QuestNum")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentQuest", (entity.getPersistentData().getDouble("potatoWar:QuestNum")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType1", (entity.getPersistentData().getDouble("potatoWar:ItemType1")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType2", (entity.getPersistentData().getDouble("potatoWar:ItemType2")));
			sourceentity.getPersistentData().putDouble("potatoWar:ItemType3", (entity.getPersistentData().getDouble("potatoWar:ItemType3")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount1", (entity.getPersistentData().getDouble("potatoWar:itemcount1")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount2", (entity.getPersistentData().getDouble("potatoWar:itemcount2")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerItemCount3", (entity.getPersistentData().getDouble("potatoWar:itemcount3")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardCount1", (entity.getPersistentData().getDouble("potatoWar:RewardCount1")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardCount2", (entity.getPersistentData().getDouble("potatoWar:RewardCount2")));
			sourceentity.getPersistentData().putDouble("potatoWar:PlayerRewardType", (entity.getPersistentData().getDouble("potatoWar:RewardType")));
			sourceentity.getPersistentData().putDouble("potatoWar:CurrentFactionID", (entity.getPersistentData().getDouble("potatoWar:FactionID")));
			sourceentity.getPersistentData().putDouble("PotatoWar:CivilianID", (entity.getPersistentData().getDouble("PotatoWar:CivilianID")));
			sourceentity.getPersistentData().putBoolean("potatoWar:SlotsLocked", true);
			sourceentity.getPersistentData().putBoolean("potatoWar:HasQuest", true);
			if (sourceentity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Itemquest");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ItemquestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
