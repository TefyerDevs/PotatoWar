package net.tefyer.potatowar.procedures;

import com.mojang.serialization.Codec;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.world.inventory.ShowCurrentQuestMenu;
import net.tefyer.potatowar.network.PotatowarModVariables;

import io.netty.buffer.Unpooled;
import org.jetbrains.annotations.NotNull;

import static net.minecraftforge.network.NetworkHooks.*;

public class CurrentQuestKeyOnKeyPressedProcedure {

	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(PotatowarModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PotatowarModVariables.PlayerVariables())).HasQuest) {
			if (entity instanceof Player _player && !_player.level().isClientSide()){
				_player.displayClientMessage(Component.literal("You do not have any quests currently"), false);
			    return;
		    }

		if (!(entity instanceof ServerPlayer _ent))
			return;
		BlockPos _bpos = BlockPos.containing(x, y, z);
		openScreen(_ent, new MenuProvider() {
			@Override
			public @NotNull Component getDisplayName() {
					return Component.literal("ShowCurrentQuest");
				}

			@Override
			public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
				return new ShowCurrentQuestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
			}
		}, _bpos);

		}
	}
}
