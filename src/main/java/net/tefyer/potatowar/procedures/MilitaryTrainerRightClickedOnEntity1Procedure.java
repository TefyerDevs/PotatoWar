package net.tefyer.potatowar.procedures;

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

import net.tefyer.potatowar.world.inventory.MilitaryTrainerKitsMenu;

import io.netty.buffer.Unpooled;

public class MilitaryTrainerRightClickedOnEntity1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double RandomNum = 0;
		sourceentity.getPersistentData().putDouble("potatoWar:FactionID", (entity.getPersistentData().getDouble("potatoWar:FactionID")));
		sourceentity.getPersistentData().putDouble("potatowar:KitPrice", (entity.getPersistentData().getDouble("potatowar:KitPrice")));
		sourceentity.getPersistentData().putDouble("potatowar:KitID", (entity.getPersistentData().getDouble("potatowar:KitID")));
		if (sourceentity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("MilitaryTrainerKits");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new MilitaryTrainerKitsMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}
