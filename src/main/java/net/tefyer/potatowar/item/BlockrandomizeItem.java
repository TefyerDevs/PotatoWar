
package net.tefyer.potatowar.item;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.tefyer.potatowar.utils.ItemStackedItem;

import java.util.concurrent.atomic.AtomicReference;

public class BlockrandomizeItem extends Item {
	public BlockrandomizeItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		checkUseOn(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}


	public static ItemStack getStackedItem(int sltid, Entity entity){
		AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
		entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
			_retval.set(capability.getStackInSlot(sltid).copy());
		});
		return _retval.get();
	}

	public static ItemStackedItem createNewItem(){
		return BlockrandomizeItem::getStackedItem;
	}

	public static BlockState blockRandomizerBuilder(LevelAccessor world, double x, double y, double z, int randomInt, int targetInt, Entity entity){
		BlockState RandomBlock = Blocks.AIR.defaultBlockState();;
		if (!(((createNewItem().getItemStack(0, entity)).getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() :
				Blocks.AIR.defaultBlockState()).getBlock() == Blocks.AIR || ((createNewItem().getItemStack(0, entity)).getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() :
				Blocks.AIR.defaultBlockState()).getBlock() == Blocks.CAVE_AIR || ((createNewItem().getItemStack(0, entity)).getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() :
				Blocks.AIR.defaultBlockState()).getBlock() == Blocks.VOID_AIR) && randomInt == targetInt) {


			RandomBlock = ((createNewItem().getItemStack(0, entity)).getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState());
			setBlock(world, x, y, z, entity, RandomBlock);
		}

		return RandomBlock;
	}

	public static void setBlock(LevelAccessor world, double x, double y, double z, Entity entity, BlockState randomBlock){
		world.setBlock(BlockPos.containing(x, y, z), randomBlock, 3);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Block is: " + (createNewItem().getItemStack(0, entity)))), false);
	}

	public static void checkUseOn(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int RandomNumber = 0;
		RandomNumber = Mth.nextInt(RandomSource.create(), 1, 9);

		for(int i = 1; i <= 9;i++){
			blockRandomizerBuilder(world,x,y,z,RandomNumber,i,entity);
		}

	}
}
