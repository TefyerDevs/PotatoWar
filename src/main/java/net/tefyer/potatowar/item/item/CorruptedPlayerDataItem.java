
package net.tefyer.potatowar.item.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.tefyer.potatowar.init.PotatowarModBlocks;
import net.tefyer.potatowar.init.PotatowarModEntities;

import java.util.List;

public class CorruptedPlayerDataItem extends Item {
	public CorruptedPlayerDataItem() {
		super(new Properties().stacksTo(1).rarity(Rarity.EPIC));
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

	public void checkSummon(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (checkIfMultiBlock(world, x, y, z)) {
			world.setBlock(BlockPos.containing(x - 1, y, z), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y, z), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z + 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z - 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 1, z), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 1, z), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z + 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y - 1, z - 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 1, z - 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 1, z + 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x - 1, y - 1, z + 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x + 1, y - 1, z - 1), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), PotatowarModBlocks.DIGITAL_BLOCK.get().defaultBlockState(), 3);
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

	public boolean checkIfMultiBlock(LevelAccessor world, double x, double y,double z){
		return  (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERRACK;
	}
}
