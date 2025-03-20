
package net.tefyer.potatowar.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.tefyer.potatowar.init.PotatowarModBlocks;
import net.tefyer.potatowar.init.PotatowarModEntities;
import net.tefyer.potatowar.multiblock.Multiblock;
import net.tefyer.potatowar.utils.EntityUtils;

import java.util.List;

public class CorruptedPlayerDataItem extends Item implements IMultiBlockedItem {

	public Multiblock multiblock = new Multiblock(PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState().getBlock());

	public CorruptedPlayerDataItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));

		addMultiBlockData();
	}



	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("item.potatowar.corrupted_player_data.description_0"));
		list.add(Component.translatable("item.potatowar.corrupted_player_data.description_1"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);

		checkMultiblock(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());

		return InteractionResult.SUCCESS;
	}
	@Override
	public void checkMultiblock(LevelAccessor world, int worldX, int worldY, int worldZ, Entity entity) {
		if (entity == null)
			return;

		if (multiblock.checkMultiblock(world, worldX, worldY, worldZ)) {

			multiblock.replaceBlocks(world,worldX,worldY,worldZ);
			EntityUtils.spawnEntityWithClientString(world,entity, PotatowarModEntities.CORRUPTEDPLAYER.get(),worldX,worldY,worldZ,"Error Entity.Herobrine not found.");
		}
	}

	@Override
	public void addMultiBlockData() {
		multiblock.addBlockData(0,0,0, Blocks.FIRE);


		multiblock.addBlockData(0,-1,0, Blocks.NETHERRACK);
		multiblock.addBlockData(0,-2,0, Blocks.NETHERRACK);


		multiblock.addBlockData(-1,-1,0, Blocks.REDSTONE_TORCH);
		multiblock.addBlockData(1,-1,0, Blocks.REDSTONE_TORCH);
		multiblock.addBlockData(0,-1,-1, Blocks.REDSTONE_TORCH);
		multiblock.addBlockData(0,-1,1, Blocks.REDSTONE_TORCH);


		multiblock.addBlockData(-1,-2,1, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(-1,-2,0, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(-1,-2,-1, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(1,-2,1, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(1,-2,0, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(1,-2,-1, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(0,-2,1, Blocks.GOLD_BLOCK);
		multiblock.addBlockData(0,-2,-1, Blocks.GOLD_BLOCK);
	}


}
