package net.tefyer.potatowar.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.tefyer.potatowar.init.PotatowarModEntities;
import net.tefyer.potatowar.init.PotatowarModBlocks;

public class CorruptedPlayerDataRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH && (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH
				&& (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH && (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 1))).getBlock() == Blocks.GOLD_BLOCK && (world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 1))).getBlock() == Blocks.GOLD_BLOCK
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.NETHERRACK) {
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
}
