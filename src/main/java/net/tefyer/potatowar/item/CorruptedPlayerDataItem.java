
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

import java.util.List;

public class CorruptedPlayerDataItem extends Item {

	public Multiblock multiblock = new Multiblock(PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState().getBlock());

	public CorruptedPlayerDataItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));

		enterMultiblockData();
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
		checkSummon(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}

	public void checkSummon(LevelAccessor world, int x, int y, int z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (multiblock.checkMultiblock(world, x, y, z)) {

			multiblock.replaceBlocks(world,x,y,z);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PotatowarModEntities.CORRUPTEDPLAYER.get().spawn(_level, BlockPos.containing(x, y + 1, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Error Entity.Herobrine not found."), false);
		}
	}

	private void enterMultiblockData() {
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
